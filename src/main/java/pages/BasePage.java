package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created Simple by Egakun on 22 March 2015
 */
public class BasePage {

    protected WebDriver driver;
    String app_package_name = "com.app.tokobagus.betterb:id/name";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    protected void WaitForClickabilityOf(By locator,int time){
    	WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    protected boolean isElementPresent(By by) {
   	try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
    
    protected void clickElement(By by){
    	waitForClickabilityOf(by);
    	driver.findElement(by).click();
    }
    
    protected void clickElement(By by, int time){
    	WaitForClickabilityOf(by, time);
    	driver.findElement(by).click();
    }
    
    
    protected void sendKeysElement(By by,String keys){
    	waitForVisibilityOf(by);
    	//driver.findElement(by).clear();
    	driver.findElement(by).sendKeys(keys);
    }
    
    public By getTextLocator(String locator){
    	return By.xpath("//android.widget.TextView[@text='"+locator+"']");
    }
    
    public By getEditTextLocator(String locator){
    	return By.xpath("//android.widget.EditText[@text='"+locator+"']");
    }
    
    public By getIdLocator(String locator){
    	return By.id(locator);
    }
    
    public By getImageLocator(String locator){
    	return By.xpath("//android.widget.ImageButton[@index='"+locator+"']");
    }
    
    public By getButtonLocator(String locator){
    	return By.xpath("//android.widget.Button[@text='"+locator+"']");
    }
    
    protected byte[] attachScreenShot(String filename) throws IOException{
    	File file = new File(Constant.screenshotsDir+filename);
    	FileOutputStream screenshotStream = new FileOutputStream(file);
    	byte[] bytes =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);	
    	screenshotStream.write(bytes);
        screenshotStream.close();
        return bytes;
    }

    protected void takeScreenShotInFile(String filename) throws Exception{
    	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	new File(Constant.screenshotsDir).mkdirs();
    	FileUtils.copyFile(file, new File(Constant.screenshotsDir+filename));
    }
    
    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }


    public void swipeLeftToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.01);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.9);
        swipeObject.put("endY", 0.6);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeFirstCarouselFromRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.2);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.2);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void performTapAction(WebElement elementToTap) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 360); // in pixels from left
        tapObject.put("y", (double) 170); // in pixels from top
        tapObject.put("element", Double.valueOf(((RemoteWebElement) elementToTap).getId()));
        js.executeScript("mobile: tap", tapObject);
    }
}
