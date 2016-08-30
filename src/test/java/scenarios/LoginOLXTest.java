package scenarios;

import listeners.ScreenshootsListener;
import module.LoginWithOlxModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPreferencesPage;
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
    private LoginWithOlxModule loginOlx;
    private CategoryPreferencesPage categoryPreferencesPage;

    // login With OLX Login Page

    @Stories("A User I Want to See Content in Login Page")
    @Title("Verify System Conten in Login Page Displayed")
    @TestCaseId("TC_LOGIN_04_001")
    @Test(priority = 1)
    public void userAbleToContentOLXLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.verifyLoginOlxContents();
    }

    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with OLX Account and with unregistered Email")
    @TestCaseId("TC_LOGIN_04_002")
    @Test(priority = 6, enabled = false)
    public void userNotAbleToLoginWithUnregisteredEmail() {
        loginOlx.inputEmail("remote@gmail.com");
        loginOlx.inputPassword("Welcome123");
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorInvalidEmail();

    }

    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with OLX Account and with Incorrect Email Format")
    @TestCaseId("TC_LOGIN_04_003")
    @Test(priority = 3)
    public void userNotAbleToLoginWithIncorrectEmailFormat() {
        loginOlx.inputEmail("remote");
        loginOlx.inputPassword("hoho");
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorInvalidEmail();
    }

    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with OLX Account and with Invalid Credentials (Email or Password)")
    @TestCaseId("TC_LOGIN_04_004")
    @Test(priority = 4, enabled = false)
    public void userNotAbleToLoginWithInvalidCredentials() {
        loginOlx.inputEmail("remote@gmail.com");
        loginOlx.inputPassword("Welcome123");
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorWrongCredentials();
    }

    @Stories("As A User I want not able to Login")
    @Title("Verify User not Able to Login with Empty Credentials")
    @TestCaseId("TC_LOGIN_04_006")
    @Test(priority = 2)
    public void userNotAbleToLoginWithBlankCredentials() {
        loginOlx.clickLoginWithOlxBtn();
        loginOlx.verifyErrorBlankEmail();
    }

    @Stories("As A User I want able to Login")
    @Title("Verify User Able to Login with OLX Account")
    @TestCaseId("TC_LOGIN_04_005")
    @Test(priority = 5)
    public void userAbleToLoginWithValidCredentials() {
        loginOlx.inputEmail("remote@gmail.com");
        loginOlx.inputPassword("Welcome123");
        loginOlx.clickLoginWithOlxBtn();
        categoryPreferencesPage = loginOlx.verifySetCategoryPreferences();
        categoryPreferencesPage.verifyTitleListing();
    }

    @Stories("As A User I Want be Able to Logout After Success Login by OLX Account")
    @Title("Verify User Able to Logout after Success OLX Account Login")
    @TestCaseId("TC_LOGIN_04_006")
    @Test(priority = 7)
    public void userAbleToLogoutAfterSuccessOlxLogin() {}
}
