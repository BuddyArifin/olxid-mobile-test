package scenarios;

import listeners.ScreenshootsListener;
import module.LoginWithFBModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ListingPage;
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
    LoginPage loginPage;

    // login with FB
    @Stories("As A User I Will not be Able to Login")
    @Title("Verify User Not Able to Login with Invalid Facebook Credentials")
    @TestCaseId("TC_LBF_02_001")
    @Test(priority = 1)
    public void userNotAbleToLoginWithInvalidFBCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        LoginWithFBModule fbLogin = loginPage.clickLoginWithFacebook();
        fbLogin.loginFb("remote@gmail.com", "Welcome123");
        fbLogin.verifyAlert();
    }

    @Stories("As A User I want able to Login")
    @Title("Verify Facebook Ask Permissions from Users to Give the Granted Access")
    @TestCaseId("TC_LBF_02_003")
    @Test(priority = 3)
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
    @TestCaseId("TC_LBF_02_004")
    @Test(priority = 4)
    public void userAbleGoToListingAfterSuccessFBLogin() {
        LoginWithFBModule fbLogin = new LoginWithFBModule(driver);
        ListingPage listingPage = fbLogin.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As A User i want be able to Logout after Success Login FB")
    @Title("Verify User Able to Logout after Success FB login")
    @TestCaseId("TC_LBF_02_005")
    @Test(priority = 5)
    public void userAbleToLogoutAfterSuccessFBLogin() {}
}
