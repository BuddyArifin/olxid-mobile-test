package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.ProfilSayaModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPreferencesPage;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 8/26/16.
 */

@Listeners(ScreenshootsListener.class)
@Features("Login Feature")
public class LoginOLXTest extends AndroidSetup {
    private CategoryPreferencesPage categoryPreferencesPage;
    private ListingPage listingPage;
    private HamburgerBarModule hamburgerBarModule;
    private ProfilSayaModule profilSayaModule;

    // login With OLX Login Page

    @Stories("A User I Want to See Content in Login Page")
    @Title("Verify System Content in Login Page Displayed")
    @TestCaseId("TC_LOGIN_04_001")
    @Test(priority = 1, groups = "smoke.test")
    public void userAbleToContentOLXLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        LoginWithOlxModule loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.verifyLoginOlxContents();
    }

    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with OLX Account and with unregistered Email")
    @TestCaseId("TC_LOGIN_04_002")
    @Test(priority = 3)
    public void userNotAbleToLoginWithUnregisteredEmail() {
        LoginWithOlxModule loginOlx = new LoginWithOlxModule(driver);
        loginOlx.initOlxLoginTest();
        loginOlx.inputEmail("remote@gmail.com");
        loginOlx.inputPassword("Welcome123");
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorWrongCredentials();
    }

    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with OLX Account and with Incorrect Email Format")
    @TestCaseId("TC_LOGIN_04_003")
    @Test(priority = 3)
    public void userNotAbleToLoginWithIncorrectEmailFormat() {
        LoginWithOlxModule loginOlx = new LoginWithOlxModule(driver);
        loginOlx.initOlxLoginTest();
        loginOlx.inputEmail("remote");
        loginOlx.inputPassword("hoho");
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorInvalidEmail();
    }

    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with OLX Account and with Invalid Credentials (Email or Password)")
    @TestCaseId("TC_LOGIN_04_004")
    @Test(priority = 3)
    public void userNotAbleToLoginWithInvalidCredentials() {
        LoginWithOlxModule loginOlx = new LoginWithOlxModule(driver);
        loginOlx.initOlxLoginTest();
        loginOlx.inputEmail("remote@gmail.com");
        loginOlx.inputPassword("Welcome123");
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorWrongCredentials();
    }

    @Stories("As A User I want not able to Login")
    @Title("Verify User not Able to Login with Empty Credentials")
    @TestCaseId("TC_LOGIN_04_007")
    @Test(priority = 3)
    public void userNotAbleToLoginWithBlankCredentials() {
        LoginWithOlxModule loginOlx = new LoginWithOlxModule(driver);
        loginOlx.initOlxLoginTest();
        loginOlx.inputEmail("");
        loginOlx.inputPassword("");
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorBlankEmail();
    }

/** Forgot Password Start */


    @Stories("As a user I want to be able to see the contents of Forgot/Lupa Password")
    @Title("Verify user able to see the contents of Forgot/Lupa Password")
    @TestCaseId("TC_LOGIN_04_008")
    @Test(priority = 3)
    public void verifyContentForgotPass(){
        LoginWithOlxModule loginWithOlxModule = new LoginWithOlxModule(driver);
        loginWithOlxModule.initOlxLoginTest();
        loginWithOlxModule.clickForgotPassOlx();
        loginWithOlxModule.verifyForgotPassContent();
    }

    @Stories("As an unregistered user I will not be able to ask for password recovery")
    @Title("Verify unregistered user not able to ask for password recovery")
    @TestCaseId("TC_LOGIN_004_011")
    @Test(priority = 3)
    public void unregisteredEmailInForgotPass(){
        LoginWithOlxModule loginWithOlxModule = new LoginWithOlxModule(driver);
        loginWithOlxModule.initOlxLoginTest();
        loginWithOlxModule.clickForgotPassOlx();
        loginWithOlxModule.verifyForgotPassContent();
        loginWithOlxModule.inputEmailForgotPass("example@test.mail");
        loginWithOlxModule.clickKirimForgotPass();
        loginWithOlxModule.verifyErrorUnregisteredEmailForgotPass();
    }

    @Stories("As a user I will not be able to input invalid email in forgot password page")
    @Title("Verify user not be able to input invalid email in forgot password page")
    @TestCaseId("TC_LOGIN_04_012")
    @Test(priority = 3)
    public void invalidEmailInForgotPass(){
        LoginWithOlxModule loginWithOlxModule = new LoginWithOlxModule(driver);
        loginWithOlxModule.initOlxLoginTest();
        loginWithOlxModule.clickForgotPassOlx();
        loginWithOlxModule.verifyForgotPassContent();
        loginWithOlxModule.inputEmailForgotPass("example");
        loginWithOlxModule.clickKirimForgotPass();
        loginWithOlxModule.verifyErrorInvalidEmail();
    }

    @Stories("As a user I will not be able to input blank email in forgot password page")
    @Title("Verify user not be able to input blank email in forgot password page")
    @TestCaseId("TC_LOGIN_04_013")
    @Test(priority = 3)
    public void blankEmailInForgotPass(){
        LoginWithOlxModule loginWithOlxModule = new LoginWithOlxModule(driver);
        loginWithOlxModule.initOlxLoginTest();
        loginWithOlxModule.clickForgotPassOlx();
        loginWithOlxModule.verifyForgotPassContent();
        loginWithOlxModule.inputEmailForgotPass("");
        loginWithOlxModule.clickKirimForgotPass();
        loginWithOlxModule.verifyErrorBlankEmailForgotPass();
    }

    @Stories("As a user I want to be able to receive password recovery via email")
    @Title("Verify user able to receive password recovery via email")
    @TestCaseId("TC_LOGIN_04_009, TC_LOGIN_04_010")
    @Test(priority = 3)
    public void userAbleToReceivePassRecovery(){
        LoginWithOlxModule loginWithOlxModule = new LoginWithOlxModule(driver);
        loginWithOlxModule.initOlxLoginTest();
        loginWithOlxModule.clickForgotPassOlx();
        loginWithOlxModule.verifyForgotPassContent();
        loginWithOlxModule.inputEmailForgotPass("whoami@olx.co.id");
        loginWithOlxModule.clickKirimForgotPass();
        loginWithOlxModule.verifyForgotPassNotifSuccess("Link Terkirim", "whoami@olx.co.id");
        loginWithOlxModule.clickTutupForgotPassNotif();
        loginWithOlxModule.verifyLoginOlxContents();
        //need to verify email
    }

/** Forgot Password End */



    @Stories("As A User I want able to Login")
    @Title("Verify User Able to Login with OLX Account")
    @TestCaseId("TC_LOGIN_04_005")
    @Test(priority = 12, groups = "smoke.test")
    public void userAbleToLoginWithValidCredentials() {
        LoginWithOlxModule loginOlx = new LoginWithOlxModule(driver);
        loginOlx.initOlxLoginTest();
        loginOlx.inputEmail("whoami@olx.co.id");
        loginOlx.inputPassword("test123");
        loginOlx.clickLoginWithOlxBtn();
        listingPage = loginOlx.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As A User I Want be Able to Logout After Success Login by OLX Account")
    @Title("Verify User Able to Logout after Success OLX Account Login")
    @TestCaseId("TC_LOGIN_04_006")
    @Test(priority = 13, groups = "smoke.test")
    public void userAbleToLogoutAfterSuccessOlxLogin() {
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        profilSayaModule = hamburgerBarModule.clickProfilSayaBtn();
        LoginPage loginPage = profilSayaModule.clickLogoutDariOLXBtnProfilSayaPage();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        hamburgerBarModule.clickProfilSayaBtn();
        hamburgerBarModule.clickOkOnAlert();
        loginPage.verifyContentsOfLoginPage();
    }



}
