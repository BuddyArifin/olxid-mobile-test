package scenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import listeners.ScreenshootsListener;


/**
 * Created by buddyarifin on 8/5/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Login Feature")
public class LoginPageTest extends AndroidSetup {
    LoginPage loginPage;

    @Stories("As a User I want to be able to see Boarding Contents")
    @Title("Verify users able to see all contents on Boarding Sliders")
    @TestCaseId("TC_HOME_01_001, TC_HOME_01_002, TC_HOME_01_009")
    @Test(priority = 1, groups = "smoke.test")
    public void verifyOnBoardingSlidersContents() {
        loginPage = new LoginPage(driver);
        loginPage.verifyContentsOfOnBoardingSlidersPage();
    }

    @Stories("As a User I want to be able to skip Boarding Sliders")
    @Title("Verify user able to skip Boarding Images")
    @TestCaseId("TC_HOME_01_004, TC_HOME_01_003")
    @Test(priority = 2, groups = "smoke.test")
    public void verifyUserAbleToSkipOnBoardingSliders() {
        loginPage.clickSkipOnBoardingSliders();
    }

    @Stories("As A User I Want to see overall Login Page Details")
    @Title("Verify All Contents of Home Page")
    @TestCaseId("TC_HOME_01_005, TC_HOME_01_008")
    @Test(priority = 3)
    public void verifyHomePageContents() {
        loginPage.verifyContentsOfLoginPage();
    }

    @Stories("As A User I Want to skip Login Process")
    @Title("Verify User Able to Skip Login Process and redirect to Listing Page")
    @TestCaseId("TC_HOME_01_010")
    @Test(priority = 4)
    public void userAbleToSkipLogin() {
        loginPage.skipLogin();
    }

    @Stories("As a User I want to be able to see On Boarding Slides just on First Install")
    @Title("verify user able to see On Boarding Sliders just on First Install")
    @TestCaseId("TC_HOME_01_010")
    @Test(priority = 5, enabled = false)
    public void verifyOnBoardingDisplayOnFirstInstallOnly() {
        loginPage.verifyOnBoardingOnlyOnFirstInstall();
        loginPage.verifyContentsOfLoginPage();
    }
}