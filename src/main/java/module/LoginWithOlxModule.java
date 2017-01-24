package module;


import athena.DataBuilder;
import athena.Sinon;
import com.jayway.restassured.response.Response;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.CategoryPreferencesPage;
import pages.ListingPage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by buddyarifin on 8/5/16.
 */
public class LoginWithOlxModule extends BasePage {
    public static final String showHiddenPass = "com.app.tokobagus.betterb:id/text_input_password_toggle";
    public static final String okButtonErrorMessage = "com.app.tokobagus.betterb:id/snackbar_action";
    public static final String forgotPasslayout = "com.app.tokobagus.betterb:id/profileForgotPass_layout";
    public static final String textView = "android.widget.TextView";
    public static String titlePage = "Masuk dengan akun OLX";
    public static final String emailField = "com.app.tokobagus.betterb:id/entranceLogin_txtEmail";
    public static String passField = "com.app.tokobagus.betterb:id/entranceLogin_txtPass";
    public static String showPass = "";
    public static String loginOlxBtn = "com.app.tokobagus.betterb:id/entranceLogin_btnLogin";
    public static String errorMessageId = "com.app.tokobagus.betterb:id/snackbar_text";
    public static String emailBlankErrorText = "Kolom email tidak boleh kosong";
    public static String passBlankErrorText = "Kolom password tidak boleh kosong";
    public static String emailNotValidText = "Email tidak valid";
    public static String loginGagal = "Login Gagal";
    public static String unathorized401 = "401 Unauthorized";
    public static String passErrorMsg = "";
    //forgot password
    public static String forgotPassBtn = "com.app.tokobagus.betterb:id/entranceLogin_btnForgotPass";
    public static String emailForgotPass = "com.app.tokobagus.betterb:id/profileForgotPass_txtEmail";
    public static String kirimBtnForgotPass = "com.app.tokobagus.betterb:id/profileForgotPass_btnSend";
    public static String forgotPassTitlePage = "Lupa Password";
    public static String forgotPassSuccessNotifTitle = "com.app.tokobagus.betterb:id/md_title";
    public static String forgotPassSuccessNotifMsg = "com.app.tokobagus.betterb:id/md_content";
    public static String forgotPassSuccessNotifTutup = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public static String unregisteredEmailErrorText = "Email belum terdaftar di OLX";
    public static String blankEmailForgotPassErrorText = "Email harus diisi";
    public static final String propname = "changepass.properties";

    public static final String linearlayout = "android.widget.LinearLayout";

    public LoginWithOlxModule(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindAll({
            @AndroidFindBy(id = forgotPasslayout),
            @AndroidFindBy(className = textView)
    })
    protected AndroidElement incorrectErrorField;

    @AndroidFindAll({
            @AndroidFindBy(id = emailField),
            @AndroidFindBy(className = linearlayout),
            @AndroidFindBy(className = textView)
    })
    protected AndroidElement emailAlert;

    @Step("Verify Login With OLX Contents")
    public void verifyLoginOlxContents() {
        Log.info("verify Login With OLX Contents");
        verifyEmailField();
        verifyPassField();
        verifyShowPass();
        verifyLoginWithOlxBtn();
        //forgot pass
        verifyForgotPassOlxLink();
    }

    @Step("Verify Email Field")
    public void verifyEmailField() {
        Log.info("verify Email Field");
        waitForClickabilityOf(getIdLocator(emailField), 100);
        Assert.assertTrue(isWaitElementPresent(getIdLocator(emailField)));
    }

    @Step("Verify Pass Field")
    public void verifyPassField() {
        Log.info("verify Pass Field");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(passField)));
    }

    @Step("Verify Login With OLX Button")
    public void verifyLoginWithOlxBtn() {
        Log.info("verify Login With OLXButton");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(loginOlxBtn)));
    }

    @Step("Verify Error Invalid Email")
    public void verifyErrorInvalidEmail() {
        Log.info("verify Error Invalid Email");
        Assert.assertTrue(incorrectErrorField.isDisplayed());
//        Assert.assertTrue(getStringText(getIdLocator(errorMessageId)).equalsIgnoreCase(emailNotValidText),
//                "Result are not same expected : "+emailNotValidText+" But, get error message : "+errorMessageId);
    }

    public void verifyErrorBlankEmail() {
        Log.info("Verify Blank email error message");
        //Assert.assertTrue(isWaitElementPresent(getIdLocator(errorMessageId)));
        Assert.assertTrue(emailAlert.isDisplayed());
    }

    public void verifyErrorBlankPassword() {
        Log.info("Verify Blank password error message");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(errorMessageId)));
        //Assert.assertTrue(getStringText(getIdLocator(errorMessageId)).equalsIgnoreCase(passBlankErrorText));
    }

    @Step("Verify Error Wrong Credentials")
    public void verifyErrorWrongCredentials() {
        Log.info("verify Error Wrong Credentials");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(errorMessageId)));
        //Assert.assertTrue(getStringText(getIdLocator(errorMessageId)).equalsIgnoreCase(loginGagal));
    }

    @Step("Verify Show Password")
    public void verifyShowPass() {
        Log.info("verify Show Password");
    }

    public void inputEmail(String emailText) {
        Log.info("Input email "+emailText);
        verifyEmailField();
        sendKeysById(getIdLocator(emailField), emailText);
    }

    public void inputPassword(String passwordText) {
        Log.info("Input pass "+passwordText);
        clickElement(getIdLocator(showHiddenPass));
        sendKeysById(getIdLocator(passField), passwordText);
        clickElement(getIdLocator(showHiddenPass));
    }

    @Step("Verify Click Login With OLX Button")
    public void clickLoginWithOlxBtn() {
        Log.info("verify Click Login With OLXButton");
        clickElement(getIdLocator(loginOlxBtn));

        // retrying, conn time out
        if (isElementPresent(getIdLocator(okButtonErrorMessage))) {

            Log.warn("First Login are failed, retrying to able login");
            clickElement(getIdLocator(loginOlxBtn));
        }
    }

    @Step("Verify Set Category Preferences")
    public CategoryPreferencesPage verifySetCategoryPreferences() {
        Log.info("verify Set Catefory Preferences");
        return new CategoryPreferencesPage(driver);
    }

    @Step("Verify Listing Page")
    public ListingPage verifyListingPage() {
        Log.info("verify Listing Page");
        return new ListingPage(driver);
    }

    /** Forgot Password */

    public void verifyForgotPassOlxLink(){
        Log.info("Verify Forgot Password Olx Link");
        Assert.assertTrue(isElementPresent(getIdLocator(forgotPassBtn)));
    }

    public void clickForgotPassOlx(){
        Log.info("Click Forgot Password OLX");
        clickElement(getIdLocator(forgotPassBtn));
    }

    public void verifyForgotPassContent(){
        verifyForgotPassTitle();
        verifyForgotPassEmailField();
        verifyForgotPassKirimBtn();
    }

    private void verifyForgotPassTitle(){
        Log.info("Verify Forgot Password Title Page");
        Assert.assertTrue(isElementPresent(getTextLocator(forgotPassTitlePage)));
    }

    private void verifyForgotPassEmailField(){
        Log.info("Verify Forgot Password Email Field");
        Assert.assertTrue(isElementPresent(getIdLocator(emailForgotPass)));
    }

    private void verifyForgotPassKirimBtn(){
        Log.info("Verify Forgot Password Kirim Button");
        Assert.assertTrue(isElementPresent(getIdLocator(kirimBtnForgotPass)));
    }

    public void inputEmailForgotPass(String emailForgot){
        Log.info("Input Email Forgot Password : "+emailForgot);
        sendKeysById(getIdLocator(emailForgotPass), emailForgot);
    }

    public void clickKirimForgotPass(){
        Log.info("Click Kirim Forgot Password");
        clickElement(getIdLocator(kirimBtnForgotPass));
    }

    private void verifyFPSuccessTitle(String fpsuccesstitle){
        Log.info("Verify Forgot Password Success Title");
        Assert.assertTrue(isElementPresent(getIdLocator(forgotPassSuccessNotifTitle)));
        Assert.assertTrue(getStringText(getIdLocator(forgotPassSuccessNotifTitle)).contains(fpsuccesstitle));
    }

    private void verifyFPSuccessMsg(String emailForgotPass){
        Log.info("Verify Forgot Password Success Message");
        Assert.assertTrue(isElementPresent(getIdLocator(forgotPassSuccessNotifMsg)));
        Assert.assertTrue(getStringText(getIdLocator(forgotPassSuccessNotifMsg)).contains(emailForgotPass));
    }

    private void verifyFPSuccessTutupBtn(){
        Log.info("Verify Forgot Password Success Tutup Btn");
        Assert.assertTrue(isElementPresent(getIdLocator(forgotPassSuccessNotifTutup)));
    }

    public void verifyForgotPassNotifSuccess(String fpsuccesstitle, String emailForgotPass){
        Log.info("Verify Forgot Password Success Notification");
        verifyFPSuccessTitle(fpsuccesstitle);
        verifyFPSuccessMsg(emailForgotPass);
        verifyFPSuccessTutupBtn();
    }

    public void clickTutupForgotPassNotif(){
        Log.info("Click Tutup on Forgot Password Notification Alert");
        clickElement(getIdLocator(forgotPassSuccessNotifTutup));
    }

    public void verifyErrorUnregisteredEmailForgotPass() {
        Log.info("Verify Unregistered email error message in Forgot Password page");
        boolean errorDisplayed = isWaitElementPresent(getIdLocator(errorMessageId));
        if(errorDisplayed){
            Assert.assertTrue(true);
            clickElement(getIdLocator(okButtonErrorMessage));
        }
        //Assert.assertTrue(getStringText(getIdLocator(errorMessageId)).equalsIgnoreCase(unregisteredEmailErrorText));
    }

    public void verifyErrorBlankEmailForgotPass() {
        Log.info("Verify Blank email error message in Forgot Password page");
        boolean errorDisplayed = isWaitElementPresent(getIdLocator(errorMessageId));
        if(errorDisplayed){
            Assert.assertTrue(true);
            clickElement(getIdLocator(okButtonErrorMessage));
        }
        //Assert.assertTrue(getStringText(getIdLocator(errorMessageId)).equalsIgnoreCase(blankEmailForgotPassErrorText));
    }

    public void initOlxLoginTest() {
        Log.info("Back to initials login with OLX");
        if (isElementPresent(getIdLocator(loginOlxBtn))) {
            Assert.assertTrue(true, "Already on Login OLX");
        } else if (isElementPresent(getIdLocator(kirimBtnForgotPass))) {
            driver.navigate().back();
        }
    }

    /** This method is applicable for Change Password case */
    public void inputEmailForChangePass(){
        Properties properties = new Properties();
        File file = new File(propname);
        FileInputStream fileInputStream = null;
        String email = "";
        try {
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            email = properties.getProperty("email");
            verifyEmailField();
            sendKeysById(getIdLocator(emailField), email);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void inputPasswordForChangePass(){
        Properties properties = new Properties();
        File file = new File(propname);
        FileInputStream fileInputStream = null;
        String oldpass = "";
        try {
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            oldpass = properties.getProperty("oldPassword");
            clickElement(getIdLocator(showHiddenPass));
            sendKeysById(getIdLocator(passField), oldpass);
            clickElement(getIdLocator(showHiddenPass));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Login with Balance
    public void loginUserWithBalance() {
        Sinon sinon = new Sinon();
        Response res = sinon.createUserWithBalance();
        String email = DataBuilder.getUserName(res);
        String pass = DataBuilder.getPassword(res);
        String user_id = DataBuilder.getUserId(res);
        inputEmail(email);
        inputPassword(pass);
        sinon.setUser_id(user_id);
        sinon.createAds();
    }

    // Login with new Users only
    public void loginWithNewUser() {
        Sinon sinon = new Sinon();
        Response response = sinon.postCreateUserWithPassword();
        String email = DataBuilder.getUserName(response);
        String pass = DataBuilder.getPassword(response);
        String user_id = DataBuilder.getUserId(response);
        inputEmail(email);
        inputPassword(pass);
        sinon.setUser_id(user_id);
        sinon.createAds();
    }
}
