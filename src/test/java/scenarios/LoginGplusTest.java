package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
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
    private HamburgerBarModule hamburgerBarModule;
    private ListingPage listingPage;

    @Stories("As A User I want able to Login Using Google+")
    @Title("Verify Google+ ask permissions from users to give the granted access")
    @TestCaseId("TC_LBG_03_002")
    @Test(priority = 2)
    public void userAbleToGiveGrantedAccessToGplus() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        loginWithGplusModule = loginPage.clickLoginWithGPlus();
        loginWithGplusModule.verifyAccountExist();
        loginWithGplusModule.clickSelectedAccounts();
        loginWithGplusModule.checkPermissionDetails();
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
        listingPage = loginWithGplusModule.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As A User I want to be able to see GPlus Profile content")
    @Title("Verify User able to see GPlus Profile content")
    @TestCaseId("TC_LBG_03_005")
    @Test(priority = 4)
    public void userAbleToSeeGplusProfContent(){
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        hamburgerBarModule.clickProfilSayaBtn();
        loginWithGplusModule.verifyGplusProfileContent();
    }

    @Stories("As A User I want able to Logout after Success Login")
    @Title("Verify User Able to Logout after Success Google+ Login")
    @TestCaseId("TC_LBG_03_004")
    @Test(priority = 5)
    public void userAbleToLogoutAfterSuccessGplusLogin() {
        LoginPage loginPage = loginWithGplusModule.clickLogOutGPlus();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        hamburgerBarModule.clickProfilSayaBtn();
        loginPage.verifyContentsOfLoginPage();
    }
}
