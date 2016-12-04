package scenarios;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetup extends InstanceDriver {

    public void prepareAndroidForAppium(String udid) throws MalformedURLException, Exception {
        File appDir = new File(Constants.apkDir);
        File app = new File(appDir, Constants.apkName);
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
        capabilities.setCapability("unicodeKeyboard", "false");
        capabilities.setCapability("locationContextEnabled", "true");
        capabilities.setCapability("deviceReadyTimeout", 100);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL(udid), capabilities);

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
        udid = setHub(ctx);
        prepareAndroidForAppium(udid);
        ctx.setAttribute("WebDriver", this.driver);
        checkEligibleRun();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
