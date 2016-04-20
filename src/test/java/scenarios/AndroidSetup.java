package scenarios;


import io.appium.java_client.android.AndroidDriver;
import pages.Constant;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    protected AndroidDriver driver;
    
    protected void prepareAndroidForAppium(String udid) throws MalformedURLException, Exception {
        File appDir = new File(Constant.apkDir);
        File app = new File(appDir, "app-olxid-release.6.1.3.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", "com.app.tokobagus.betterb");
        capabilities.setCapability("appActivity", "sea.olx.activities.SplashscreenActivity");
        //capabilities.setCapability(CapabilityType.BROWSER_NAME,"android");
        //mandatory capabilities
        capabilities.setCapability("deviceName",udid);
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid", udid);
        
        //No Reset Apps
        capabilities.setCapability("no-reset", false);
        capabilities.setCapability("full-reset", true);
        
        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);
        System.out.println("SESSION CREATED : "+driver.getSessionId().toString()+" "+udid+" ");
    }
    
    
}
