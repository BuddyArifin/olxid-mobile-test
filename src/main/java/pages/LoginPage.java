package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.LoginWithFBModule;
import module.LoginWithGplusModule;
import module.LoginWithOlxModule;
import module.LoginWithSMSModule;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by buddyarifin on 8/4/16.
 */
public class LoginPage extends BasePage {

    protected static final String facebookBtnID = "com.app.tokobagus.betterb:id/entrance_btnFb";
    protected static final String googleBtnID = "com.app.tokobagus.betterb:id/entrance_btnGp";
    protected static final String smsBtnID = "com.app.tokobagus.betterb:id/entrance_btnLoginSms";
    protected static final String olxLoginID = "com.app.tokobagus.betterb:id/entrance_btnLoginOlx";
    protected static final String skipBtnID = "com.app.tokobagus.betterb:id/entrance_btnSkip";
    protected static final String skipOnBoardingSliders = "com.app.tokobagus.betterb:id/entrance_skip";
    protected static final String olxLogoID = "com.app.tokobagus.betterb:id/entrance_btnLoginOlx";
    protected static final String presentationTextID = "com.app.tokobagus.betterb:id/entrance_bottomSubContainer1";
    public static final String paginationsID = "com.app.tokobagus.betterb:id/entrance_indicatorContainer";
    public static final String linearLayout = "android.widget.LinearLayout";
    public static final String imageView = "android.widget.ImageView";
    public static final String introTitleID = "com.app.tokobagus.betterb:id/intro_tv";
    public static final String textView = "android.widget.TextView";
    AndroidDriver androidDriver;
    public static final String alertShake = "com.app.tokobagus.betterb:id/animation_description";
    public static final String imageOnBoarding = "com.app.tokobagus.betterb:id/intro_lyImage";
    public static final String onBoardingText = "com.app.tokobagus.betterb:id/intro_lyContent";
    public static final String imageOnBoardingPagination = "com.app.tokobagus.betterb:id/entrance_indicatorContainer";
    public static final String disclaimerTextContainers = "com.app.tokobagus.betterb:id/entrance_bottomSubContainer4";

    LoginWithFBModule fb = new LoginWithFBModule(driver);

    @AndroidFindBys({
            @AndroidFindBy(id = paginationsID),
            @AndroidFindBy(className = linearLayout),
            @AndroidFindBy(className = imageView)
    })
    public List<AndroidElement> paginations;

    @AndroidFindBys({
            @AndroidFindBy(id = imageOnBoardingPagination),
            @AndroidFindBy(className = linearLayout),
            @AndroidFindBy(className = imageView)
    })
    public List<AndroidElement> onBoardingPaginations;

    @AndroidFindBys({
            @AndroidFindBy(id = imageOnBoarding),
            @AndroidFindBy(className = imageView),
    })
    public List<AndroidElement> imageOnBoardingList;

    @AndroidFindBys({
            @AndroidFindBy(id = onBoardingText),
            @AndroidFindBy(className = textView)
    })
    public List<AndroidElement> onBoardingTextList;

    @AndroidFindBys({
            @AndroidFindBy(id = disclaimerTextContainers),
            @AndroidFindBy(className = Constants.textView)
    })
    public List<AndroidElement> disclaimers;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        isAutoAcept(getIdLocator(alertShake)); // handle marketing Pop Up
    }

    @Step("Verify All Contents of On Boarding Sliders")
    public void verifyContentsOfOnBoardingSlidersPage() {
        Log.info("Verify On Boarding Sliders");
        verifySkipOnBoardingSliders();
        verifyOnBoardingSliders();
    }

    @Step("Verify All Contents of LoginPage")
    public void verifyContentsOfLoginPage() {
        Log.info("Verify All Contents of LoginPage");
        verifySkipBtn();
        verifyPresentationText();
        verifyFacebookBtn();
        verifyGmailBtn();
        verifyOlxBtn();
        verifyDisclaimers();
    }

    @Step("Verify Facebook Login Button")
    public void verifyFacebookBtn() {
        Log.info("Verify Facebook Login Button");
        Assert.assertTrue(isElementPresent(getIdLocator(facebookBtnID)));
    }

    @Step("Verify Google Plus Button")
    public void verifyGmailBtn() {
        Log.info("Verify Google Plus Button");
        Assert.assertTrue(isElementPresent(getIdLocator(googleBtnID)));
    }

    @Deprecated
    @Step("Verify Login with SMS Button")
    public void verifySmsBtn() {
        Log.info("Verify Login with SMS Button");
        Assert.assertTrue(isElementPresent(getIdLocator(smsBtnID)));
    }

    @Step("Verify OLX Login Button")
    public void verifyOlxBtn() {
        Log.info("Verify OLX Login Button");
        Assert.assertTrue(isElementPresent(getIdLocator(olxLoginID)));
    }

    @Step("Verify Skip Button")
    public void verifySkipBtn() {
        Log.info("Verify Skip Button");
        WaitForClickabilityOf(getIdLocator(skipBtnID), 100);
        Assert.assertTrue(isWaitElementPresent(getIdLocator(skipBtnID)));
    }

    @Step("Verify Text Presentations")
    public void verifyPresentationText() {
        Log.info("Verify Text Presentations");
        Assert.assertTrue(isElementPresent(getIdLocator(presentationTextID)));
    }

    @Step("Click Facebook Login Button")
    public LoginWithFBModule clickLoginWithFacebook() {
        Log.info("Click FB Button");
        WaitForClickabilityOf(getIdLocator(facebookBtnID), 100);
        clickElement(getIdLocator(facebookBtnID));
        return new LoginWithFBModule(driver);
    }

    @Step("Click Google Plus Login Button")
    public LoginWithGplusModule clickLoginWithGPlus() {
        Log.info("Click Google Button");
        clickElement(getIdLocator(googleBtnID));
        return new LoginWithGplusModule(driver);
    }

    @Step("Click SMS Login Button")
    public LoginWithSMSModule clickLoginWithSms() {
        Log.info("Click SMS Login Button");
        clickElement(getIdLocator(smsBtnID));
        return new LoginWithSMSModule(driver);
    }

    @Step("Click OLX Login Button")
    public LoginWithOlxModule clickLoginWithOlx() {
        Log.info("Click OLX Login Button");
        WaitForClickabilityOf(getIdLocator(olxLoginID), 100);
        clickElement(getIdLocator(olxLoginID));
        return new LoginWithOlxModule(driver);
    }

    @Step("Click Skip Login Button")
    public ListingPage skipLogin() {
        Log.info("Click Skip Login Button");
        WaitForClickabilityOf(getIdLocator(skipBtnID), 100);
        clickElement(getIdLocator(skipBtnID));
        return new ListingPage(driver);
    }

    public void verifyDisclaimers() {
        Log.info("Verify Disclaimers displays");
        Assert.assertTrue(isListElementPresent(disclaimers));
    }

    @Deprecated
    public CategoryPreferencesPage skipPreferences() {
        return new CategoryPreferencesPage(driver);
    }

    @Step("Verify Sliders Contents")
    public void verifySlidersContents() {
        Log.debug("Sliders available size : "+paginations.size());
        Log.debug(" intro title : ");
        for (int i=0; i < paginations.size() ;i++) {
            Log.info("  * "+getStringText(getIdLocator(introTitleID)));
            androidDriver = ((AndroidDriver) driver);
            androidDriver.swipe(androidDriver.manage().window().getSize().getWidth()-10,
                    300, 20, 300, 1000);
            Assert.assertNotNull(getStringText(getIdLocator(introTitleID)));
        }
    }

    public void verifySkipOnBoardingSliders(){
        Log.info("Verify Skip on Boarding Sliders");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(skipOnBoardingSliders)));
    }

    public LoginPage clickSkipOnBoardingSliders() {
        Log.info("Click skip on boarding sliders");
        clickElement(getIdLocator(skipOnBoardingSliders));
        return this;
    }

    public void verifyOnBoardingSliders() {
        Log.info("Verify On Boarding Image Paginations");
        int paginationSize = onBoardingPaginations.size();
        Log.debug("Image Sliders available size : "+paginationSize);
        for ( int i=0 ; i < paginationSize ; i++) { // image sliders
            androidDriver = ((AndroidDriver) driver);
            androidDriver.swipe(androidDriver.manage().window().getSize().getWidth()-10,
            300, 20, 300, 1000);
            for (int j=0 ; j < imageOnBoardingList.size(); j++) { // image contents list
                Assert.assertNotNull(isListElementPresent(imageOnBoardingList));
            }
            for (int k=0 ; k < onBoardingTextList.size(); k++) { // text list
                Log.debug(onBoardingTextList.get(k).getText());
                Assert.assertNotNull(onBoardingPaginations.get(k).getText());
            }
        }
    }

    public void verifyOnBoardingOnlyOnFirstInstall() {
        Log.info("Verify User only see On Boarding at first time install");
        androidDriver = ((AndroidDriver)driver);
        androidDriver.closeApp();
        androidDriver.startActivity(Constants.appPackage, Constants.appActivity);

    }

    @Override
    public boolean isAutoAcept(By by) {
        try
        {
            WaitForClickabilityOf(by, 80);
            if (waitForVisibility(by)) {
                clickElement(by);
                return true;
            }
            else {
                return true;
            }
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            return true;
        }
    }
}
