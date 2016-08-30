package scenarios;

import listeners.ScreenshootsListener;
import module.LoginWithFBModule;
import module.LoginWithGplusModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPreferencesPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 8/15/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Login Feature")
public class LoginFBTest extends AndroidSetup {

    // login with FB
    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with Invalid Facebook Credentials")
    @TestCaseId("TC_LBF_02_001")
    @Test(priority = 1)
    public void userNotAbleToLoginWithInvalidFBCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        LoginWithFBModule fbLogin = loginPage.clickLoginWithFacebook();
        fbLogin.loginFb("remote@gmail.com", "Welcome123");
        fbLogin.verifyAlert();
    }

    @Stories("As A User I want able to Login")
    @Title("Verify Facebook Ask Permissions from Users to Give the Granted Access")
    @TestCaseId("TC_LBF_02_003")
    @Test(priority = 3, enabled = false)
    public void userAbleToGiveGrantedAccessToFB() {
        LoginWithFBModule fbLogin = new LoginWithFBModule(driver);
        fbLogin.clickConfirm();
    }

    @Stories("As A User I want able to Login")
    @Title("Verify User Able to Login with Facebook Credentials")
    @TestCaseId("TC_LBF_02_002")
    @Test(priority = 2)
    public void userAbleToLoginWithValidFBCredentials() {
        LoginWithFBModule fbLogin = new LoginWithFBModule(driver);
        fbLogin.loginFb("remote.googs@gmail.com", "Welcome123");
    }

    @Stories("As A User I want Able to Redirect to Destination Page after Success Login")
    @Title("Verify User Able to Redirect to Destination Page After Success Login")
    @TestCaseId("TC_LBF_02_004, TC_LBF_02_005")
    @Test(priority = 4)
    public void userAbleToSetPreferencesAfterSuccessFBLogin() {
        LoginWithFBModule fbLogin = new LoginWithFBModule(driver);
        CategoryPreferencesPage category = fbLogin.verifySetCategoryPrefefences();
        category.verifyCategoryListing();
    }

    @Stories("As A User i want be able to Logout after Success Login FB")
    @Title("Verify User Able to Logout after Success FB login")
    @TestCaseId("TC_LBF_02_006")
    @Test(priority = 5)
    public void userAbleToLogoutAfterSuccessFBLogin() {}

    @Title("Logout Fb account")
    @Test(priority = 99)
    public void launchAnotherActivity() {
        LoginWithFBModule fb = new LoginWithFBModule(driver);
        fb.removeLoginApps_logout();
    }

    // login with Gplus
    @Test(enabled = false)
    public void userAbleToRedirectToGmailLogin() {
        LoginPage loginPage = new LoginPage(driver);
        LoginWithGplusModule gplus = loginPage.clickLoginWithGPlus();
        gplus.verifyAccountExist();
    }

    @Stories("As A User I Will not be Able to Login with Google+")
    @Title("Verify User Not Able to Login with Invalid Google+ Credentials")
    @TestCaseId("TC_LBG_03_001")
    @Test(priority = 6)
    public void userNotAbleToLoginWithInvalidGplusCredentials() {}

    @Stories("As A User I want able to Login Using Google+")
    @Title("Verify Google+ ask permissions from users to give the granted access")
    @TestCaseId("TC_LBG_03_003")
    @Test(priority = 8)
    public void userAbleToGiveGrantedAccessToGplus() {}

    @Stories("As A User I want able to Login with Google+")
    @Title("Verify User Able to Login with Google+ Credentials")
    @TestCaseId("TC_LBG_03_002")
    @Test(priority = 7)
    public void userAbleToLoginWithValidGplusCredentials() {}

    @Stories("As A User I want Set Preferences Category After Success Login")
    @Title("Verify User Able to Set Preferences Category After Success Login")
    @TestCaseId("TC_LBG_03_005, TC_LBG_03_004")
    @Test(priority = 7)
    public void userAbleToSetPreferencesAfterSuccessGplusLogin() {}
    public void userAbleToLogoutAfterSuccessGplusLogin() {}

    // login with SMS
    public void userNotAbleToLoginWithBlankPIN() {}
    public void userAbleToMintaPIN() {}
    public void userAbleToMintaUlangPIN() {}
    public void userNotAbleToLoginWithInvalidPIN() {}
    public void userNotAbleToLoginWithInvalidPhoneNumber() {}
    public void userAbleToLoginWithValidPIN() {}

}
