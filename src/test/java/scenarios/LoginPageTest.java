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

    @Stories("As A User I Want to see overall Login Page Details")
    @Title("Verify All Contents of Home Page")
    @TestCaseId("TC_HOME_01_001, TC_HOME_01_001, TC_HOME_01_008")
    @Test(priority = 1)
    public void verifyHomePageContents() {
        loginPage = new LoginPage(driver);
        loginPage.verifyContentsOfLoginPage();
    }

    @Stories("As A User I Want to skip Login Process")
    @Title("Verify User Able to Skip Login Process and redirect to Listing Page")
    @TestCaseId("TC_HOME_01_002")
    @Test(priority = 3)
    public void userAbleToSkipLogin() {
        loginPage.clickSkipButton();
    }

    @Stories("As a User I Want to be able to Swipe/Scroll the Intro Image")
    @Title("Verify User Able to Swipe/Scroll the Intro Images")
    @TestCaseId("TC_HOME_01_009")
    @Test(priority = 2)
    public void userAbleToSwipeSlide() {
        loginPage.verifySlidersContents();
    }
}