package scenarios;

import listeners.ScreenshootsListener;
import module.LoginWithGplusModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by NugrohoSantoso on 8/26/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Login Feature")
public class LoginGplusTest extends AndroidSetup {
    private LoginWithGplusModule loginWithGplusModule;

    @Stories("As A User I want able to Login Using Google+")
    @Title("Verify Google+ ask permissions from users to give the granted access")
    @TestCaseId("TC_LBG_03_002")
    @Test(priority = 2)
    public void userAbleToGiveGrantedAccessToGplus() {
        LoginPage loginPage = new LoginPage(driver);
        loginWithGplusModule = loginPage.clickLoginWithGPlus();
        loginWithGplusModule.verifyAccountExist();
        loginWithGplusModule.clickSelectedAccounts();
        loginWithGplusModule.verifyPermissionDetailsInfo();
        loginWithGplusModule.verifyDenyBtn();
        loginWithGplusModule.verifyAllowBtn();
        loginWithGplusModule.clickAllowBtn();
    }

    @Stories("As A User I want able to Login with Google+")
    @Title("Verify User Able to Login with Google+ Credentials")
    @TestCaseId("TC_LBG_03_001")
    @Test(priority = 1, enabled = false)
    public void userAbleToLoginWithValidGplusCredentials() {}

    @Stories("As A User I want Set Preferences Category After Success Login")
    @Title("Verify User Able to Set Preferences Category After Success Login")
    @TestCaseId("TC_LBG_03_003")
    @Test(priority = 3)
    public void userAbleGoToListingAfterSuccessGplusLogin() {
        LoginPage loginPage = new LoginPage(driver);
        LoginWithGplusModule gplus = loginPage.clickLoginWithGPlus();
        ListingPage listingPage = gplus.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As A User I want able to Logout after Success Login")
    @Title("Verify User Able to Logout after Success Google+ Login")
    @TestCaseId("TC_LBG_03_004")
    @Test(priority = 4)
    public void userAbleToLogoutAfterSuccessGplusLogin() {}
}
