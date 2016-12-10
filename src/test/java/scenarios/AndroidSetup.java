package scenarios;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.BasePage;
import pages.Constants;
import pages.InstanceDriver;
import tracking.NetClient;
import utils.Log;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class AndroidSetup extends InstanceDriver {

    public NetClient net;
    public BasePage basePage;
    private JsonObject jsonObject;

    public void prepareAndroidForAppium(String udid) throws MalformedURLException, Exception {
        String apkname = getLatestApk();

        File appDir = new File(Constants.apkDir);
        //File app = new File(appDir, Constants.apkName);
        File app = new File(appDir, apkname);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", Constants.appPackage);
        capabilities.setCapability("appActivity", Constants.appActivity);

        capabilities.setCapability("deviceName","Galaxy");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("newCommandTimeout", 60 * 5);
       // capabilities.setCapability("udid", udid);
        
        //No Reset Apps
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", false);

        //No Keyboard Layout
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("locationContextEnabled", "true");
        capabilities.setCapability("deviceReadyTimeout", 100);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL(Constants.hubIP), capabilities);

        //set location for maps - based on Menara Sentraya
        Location location = new Location(-6.2454429, 106.8026181, 0.0);
        driver.setLocation(location);
        Log.debug("SESSION CREATED : "+driver.getSessionId().toString()+" "+udid+" ");
    }

    private void checkEligibleRun() throws Exception {
        SessionId sessionId = driver.getSessionId();
        Log.info("Session ID = "+sessionId.toString());
        boolean isappinst = driver.isAppInstalled(Constants.appPackage);
        Log.info("Is app installed = "+isappinst);
        if(sessionId == null && isappinst == false){
            System.exit(1);
        }
    }

    @Parameters({"udid"})
    @BeforeClass
    public void setUp(@Optional String udid, ITestContext ctx) throws Exception{
        prepareAndroidForAppium(udid);
        ctx.setAttribute("WebDriver", this.driver);
        checkEligibleRun();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] getData(Method m) {
        String testname = m.getName() + ".json";
        File jsonFileDir = new File("src/test/resources/goldendata/");
        File jsonfile = new File(jsonFileDir, testname);
        jsonObject = convertFiletoJson(jsonfile.getAbsoluteFile());
        return new Object[][]{{jsonObject}};
    }

    public JsonObject convertFiletoJson(File file) {
        jsonObject = new JsonObject();
        try{
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader(file));
            jsonObject = jsonElement.getAsJsonObject();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.info("Warning : File not found");
        }
        return jsonObject;
    }

    public String getLatestApk() throws Exception {
        String appname = "";
        File folder = new File(Constants.apkDir);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if(listOfFiles[i].getName().contains("app-release")){
                    appname = listOfFiles[i].getName();
                    break;
                }
            }
        }
        Log.info("APK Version : "+appname);
        return appname;
    }
}
