package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
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
 * Created by NugrohoSantoso on 9/7/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Listing Feature")
public class ListingTest extends AndroidSetup {
    CategoryPreferencesPage categoryPreferencesPage;
    ListingPage listingPage;
    LoginPage loginPage;
    HamburgerBarModule hamburgerBarModule;

    @Stories("As a User I want to See Content in ListingPage")
    @Title("Verify System able to Display Content in ListingPage")
    @TestCaseId("TC_LISTING_06_001")
    @Test(priority = 1)
    public void verifyContentDisplayInListingPage()
    {
        loginPage = new LoginPage(driver);
        categoryPreferencesPage = new CategoryPreferencesPage(driver);
        listingPage = new ListingPage(driver);
        loginPage.clickSkipButton();
        categoryPreferencesPage.clickSkipBtn();
        listingPage.clickAllowAccessLocationButton();
        listingPage.clickAllowAccessLocationButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As A User i want to able see Content in Navigation Menu")
    @Title("Verify System display All Content in Navigation Menu")
    @TestCaseId("TC_LISTING_06_027")
    @Test(priority = 2)
    public void verifyAllContentsInHamburgerBar()
    {
        listingPage = new ListingPage(driver);
        hamburgerBarModule = new HamburgerBarModule(driver);
        listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
    }

    @Stories("As a User I want enable Search ads")
    @Title("Verify Search ads by Keyword in Search Box")
    @TestCaseId("TC_LISTING_06_002")
    @Test(priority = 2, enabled = false)
    public void userAbleSearchAdsByInputtedKeyword()
    {
        loginPage.clickSkipButton();
        categoryPreferencesPage.clickSkipBtn();
    }

    @Stories("As a User I want to Click 1Km dari Kamu")
    @Title("Verify User able to redirect to Radius Selection Page")
    @TestCaseId("TC_LISTING_06_004")
    @Test(priority = 3, enabled = false)
    public void userAbleToClick1KMDariKamuButton()
    {
        loginPage.clickSkipButton();
        categoryPreferencesPage.clickSkipBtn();
        listingPage.clickJarakDariKamuBtn();
    }

    @Stories("As A User I want to able Click Filter/Advance on the primary tool")
    @Title("Verify User able to click Filter on the primary toolbar")
    @TestCaseId("TC_LISTING_06_021")
    @Test(priority = 5)
    public void userAbleToClickFilterButton()
    {
        loginPage = new LoginPage(driver);
        categoryPreferencesPage = new CategoryPreferencesPage(driver);
        listingPage = new ListingPage(driver);
        listingPage.clickFilterBtnPrm();
    }
}
