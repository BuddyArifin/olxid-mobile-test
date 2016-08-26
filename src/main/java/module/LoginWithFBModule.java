package module;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.CategoryPreferencesPage;
import utils.Log;

import java.util.Set;

/**
 * Created by buddyarifin on 8/12/16.
 */
public class LoginWithFBModule extends BasePage {

    public static final String email = "com.facebook.katana:id/login_username";
    public static final String emailCss = "input[type='email']";
    public static final String password = "com.facebook.katana:id/login_password";
    public static final String passwordCss = "input[type='password']";
    public static final String loginBtn = "com.facebook.katana:id/login_login";
    public static final String loginCss = "button[type='button']";
    public static final String cancelBtn = "";
    public static final String closeBtn = "";
    public static final String confirmBtn = "u_0_9";
    public static final String confirmBtnCss = "button[name='__CONFIRM__']";
    public static final String accessFBInfoText = "";
    public static final String alertIncorrectCredentials = "com.facebook.katana:id/alertTitle";
    public static final String alertIncorrectCredentialsCss = "div[data-sigil='m_login_notice']";
    public static final String okButton = "com.facebook.katana:id/button1";

    public LoginWithFBModule(WebDriver driver) {
        super(driver);
    }

    // Native
    public void clickLogin() {
        Log.info("Click Login on FB App");
        clickElement(getIdLocator(loginBtn));
    }
    public void inputAppEmail(String emailText) {
        Log.info("Input Email FB Login");
        sendKeysById(getIdLocator(email), emailText);
    }
    public void inputAppPassword(String passwordText) {
        Log.info("Input Password FB Login");
        sendKeysById(getIdLocator(password), passwordText);
    }
    public void clickConfirm() {
        if(isFBAppInstalled()) {
            Log.info("Accepting Permission FB App");
            clickElement(getButtonLocator(confirmBtn));
        } else {
            Log.info("Accepting Permission FB App");
            clickElement(By.cssSelector(confirmBtnCss));
            switchNativeCtx();
        }
    }

    // Web View
    public void inputWebEmail(String emailText) {
        Log.info("Input Email FB Login");
        sendKeysById(By.cssSelector(emailCss), emailText);
    }
    public void inputWebPassword(String passwordText) {
        Log.info("Input Password FB Login");
        sendKeysById(By.cssSelector(passwordCss), passwordText);
    }
    public void clickWebLogin() {
        Log.info("Click FB Login Button");
        clickElement(By.cssSelector(loginCss));
    }

    public void verifyLoginFormFB() {
        verifyEmailField();
        verifyPassField();
        verifyLoginBtn();
    }
    public void verifyEmailField() {
        Log.info("Verified email Text Field");
        Assert.assertTrue(isElementPresent(getIdLocator(email)));
    }
    public void verifyPassField() {
        Log.info("Verified Password Text Field");
        Assert.assertTrue(isElementPresent(getIdLocator(password)));
    }
    public void verifyLoginBtn() {
        Log.info("Verified Login Button");
        Assert.assertTrue(isElementPresent(getIdLocator(loginBtn)));
    }
    public void verifyAlert() {
        if (isWaitElementPresent(getIdLocator(okButton))) {
            Log.info("Verify Alert display");
            Assert.assertTrue(isWaitElementPresent(getIdLocator(alertIncorrectCredentials)));
            clickElement(getIdLocator(okButton));
        } else {
            Log.info("Verify Alert display");
            Assert.assertTrue(isElementPresent(By.cssSelector(alertIncorrectCredentialsCss)));
            clickElement(By.cssSelector(emailCss));
        }
    }

    public void clickCloseBtn() {}
    public void verifyCloseBtn() {}
    public void verifyConfirmBtn() {}
    public void verifyAccessFBInfo() {}

    public CategoryPreferencesPage verifySetCategoryPrefefences() {
        return new CategoryPreferencesPage(driver);
    }

    public void loginFb(String emailText, String passText) {
        if (isFBAppInstalled()) {
            verifyLoginFormFB();
            clickElement(getIdLocator(email)); // handle appium not swith to password field
            inputAppEmail(emailText);
            clickElement(getIdLocator(password));
            inputAppPassword(passText);
            clickLogin();
        } else {
            switchWebViewCtx();
            isWaitElementPresent(By.cssSelector(emailCss));
            clickElement(By.cssSelector(emailCss));
            inputWebEmail(emailText);
            clickElement(By.cssSelector(passwordCss));
            inputWebPassword(passText);
            clickWebLogin();
        }
    }

    public boolean isFBAppInstalled() {
        if (isWaitElementPresent(getIdLocator(email))) {
            return true;
        } else {
            Log.debug("Login must using web view");
            return false;
        }
    }

    public void checkView() {
        Set<String> contextName = ((AndroidDriver)driver).getContextHandles();
        for (String context : contextName) {
            Log.info(context);
        }
    }

    public void removeLoginApps_logout() {
        String hamburgerBar = "com.facebook.katana:id/bookmarks_tab";
        String accountSettings = "Account Settings";
        String logout = "Log Out";
        String okId = "com.facebook.katana:id/button1";
        ((AndroidDriver)driver).startActivity("com.facebook.katana", "com.facebook.katana.LoginActivity");
        clickElement(getIdLocator(hamburgerBar));
        ((AndroidDriver)driver).scrollTo(logout);
        clickElement(By.xpath("//android.view.ViewGroup[@content-desc='"+logout+"']"));
        clickElement(getIdLocator(okId));
    }

}
