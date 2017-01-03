package scenarios;

import athena.DataBuilder;
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
        File app = new File(appDir, apkname);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", Constants.appPackage);
        capabilities.setCapability("appActivity", Constants.appActivity);
        capabilities.setCapability("appWaitActivity", Constants.appActivity);

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
        capabilities.setCapability("appWaitDuration", 1000000);

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

    public String getLatestApk() throws Exception {
        String appname = "";
        File folder = new File(Constants.apkDir);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if(listOfFiles[i].getName().contains("app-uat")){
                    appname = listOfFiles[i].getName();
                    break;
                }
            }
        }
        Log.info("APK Version : "+appname);
        return appname;
    }
}
