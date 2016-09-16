package scenarios;

import listeners.ScreenshootsListener;
import module.FilterByMapsLocationModule;
import module.HamburgerBarModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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
    ListingPage listingPage;
    LoginPage loginPage;
    HamburgerBarModule hamburgerBarModule;
    FilterByMapsLocationModule filterByMapsLocationModule;

    @Stories("As a User I want to See Content in ListingPage")
    @Title("Verify System able to Display Content in ListingPage")
    @TestCaseId("TC_LISTING_06_001")
    @Test(priority = 1)
    public void verifyContentDisplayInListingPage()
    {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As A User i want to able see Content in Navigation Menu")
    @Title("Verify System display All Content in Navigation Menu")
    @TestCaseId("TC_LISTING_06_027")
    @Test(priority = 2, enabled = false)
    public void verifyAllContentsInHamburgerBar()
    {
        listingPage = new ListingPage(driver);
        hamburgerBarModule = listingPage.clickHamburgerBar();;
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
    }

    @Stories("As a User I want enable Search ads")
    @Title("Verify Search ads by Keyword in Search Box")
    @TestCaseId("TC_LISTING_06_002")
    @Test(priority = 3, enabled = false)
    public void userAbleSearchAdsByInputtedKeyword()
    {

    }

    @Stories("As a User I want to Click 1Km dari Kamu")
    @Title("Verify User able to redirect to Radius Selection Page")
    @TestCaseId("TC_LISTING_06_004")
    @Test(priority = 4, enabled = false)
    public void userAbleToClick1KMDariKamuButton()
    {
        filterByMapsLocationModule = listingPage.clickJarakDariKamuBtn();
    }

    @Stories("As A User I want Bottom Bar Disappear")
    @Title("Verify ads Scrolling Unlimited and Bottom Bar Disappear when Scrolling")
    @TestCaseId("TC_LISTING_06_012")
    @Test(priority = 5)
    public void verifyBtmBarDissappear()
    {
        listingPage.verifyBtmBarDissappear();
    }

    @Stories("As A User I want Bottom Bar Appear")
    @Title("Verify Bottom Bar Appear when Scrolling Up")
    @TestCaseId("TC_LISTING_06_013")
    @Test(priority = 6)
    public void verifyBtmBarAppear()
    {
        listingPage.verifyBtmBarAppear();
    }

    @Stories("As A User I want to able Click Filter/Advance on the primary tool")
    @Title("Verify User able to click Filter on the primary toolbar")
    @TestCaseId("TC_LISTING_06_021")
    @Test(priority = 7)
    public void userAbleToClickFilterButton()
    {
        listingPage.clickFilterBtnPrm();
    }
}
