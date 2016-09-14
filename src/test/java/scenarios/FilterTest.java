package scenarios;

import listeners.ScreenshootsListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FilterPage;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Login Feature")
public class FilterTest extends AndroidSetup{
    LoginPage loginPage;
    ListingPage listingPage;
    FilterPage filterPage;

    @Stories("As a User I want See Content in Filter Page")
    @Title("Verify System Display Content in Filter Page")
    @TestCaseId("TC_FILTER_08_002")
    @Test(priority = 1)
    public void verifyAllContentInFilterPage()
    {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipButton();
        listingPage.clickAllowAccessLocationButton();
        filterPage = listingPage.clickFilterBtnPrm();
        listingPage.clickAllowAccessLocationButton();
        filterPage.verifyAllContentOfFilterPage();
    }

    @Stories("As a User I want See cancel input button")
    @Title("Verify System Display cancel input button")
    @TestCaseId("TC_FILTER_08_003")
    @Test(priority = 2)
    public void verifyButtonXExist()
    {
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("jazz");
        filterPage.verifyCancelButton();
    }

    @Stories("As a User i want to be able cancel inputted keyword")
    @Title("Verify Search Field null")
    @TestCaseId("TC_FILTER_08_003")
    @Test(priority = 3)
    public void verifySearchFieldNull()
    {
        filterPage.clickCancelButtonSearchField();
    }

    @Stories("As a User I want to Able Input Keyword Search")
    @Title("Verify Listing ads sorted by inputted keyword")
    @TestCaseId("TC_FILTER_08_003")
    @Test(priority = 3, enabled = false)
    public void verifyListingAdsSortedByInputtedKeyword()
    {
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickSimpanButton();
    }

    @Stories("As a user i want see listing by current location")
    @Title("Verify Listing ads sorted by current location")
    @TestCaseId("TC_FILTER_08_004")
    @Test(priority = 3, enabled = false)
    public void verifyListingAdsSortedByCurrentLocation()
    {
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickMyLocationButton();
        filterPage.clickSimpanButton();
    }

    @Stories("As a user i want see listing by input price range")
    @Title("Verify Listing ads sorted by inputted price range")
    @TestCaseId("TC_FILTER_08_005")
    @Test(priority = 4, enabled = false)
    public void verifyListingAdsSortedByInputtedPriceRange()
    {
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickMyLocationButton();
        filterPage.clickSimpanButton();
    }

    @Stories("As a user i want see listing by nearest, newest, cheaper, expensive")
    @Title("Verify Listing ads sorted by selected nearest, newest, cheaper, expensive")
    @TestCaseId("TC_FILTER_08_006")
    @Test(priority = 5, enabled = false)
    public void verifyListingAdsSortedByUrutkanColumn()
    {
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickMyLocationButton();
        filterPage.clickRadioButtonTerdekatInUrutkanColumn();
        filterPage.clickSimpanButton();
    }

    @Stories("As a user i want see listing by new or second condition")
    @Title("Verify Listing ads sorted by selected condition")
    @TestCaseId("TC_FILTER_08_007")
    @Test(priority = 6, enabled = false)
    public void verifyListingAdsSortedByConditionColumn()
    {
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickMyLocationButton();
        filterPage.clickRadioButtonTerdekatInUrutkanColumn();
        filterPage.clickSimpanButton();
    }

    @Stories("As user i want to be able reset filter")
    @Title("Verify System all column back to default")
    @TestCaseId("TC_FILTER_08_019")
    @Test(priority = 98)
    public void verifyResetButtonClicked()
    {
        filterPage = new FilterPage(driver);
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickRadioButtonTerdekatInUrutkanColumn();
        filterPage.clickResetButton();
    }

    @Stories("As user i want to be able back to Listing Page")
    @Title("Verify User back to Listing Page")
    @TestCaseId("TC_FILTER_08_021")
    @Test(priority = 99)
    public void verifyBackButtonClickec()
    {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipButton();
        listingPage.clickAllowAccessLocationButton();
        filterPage = listingPage.clickFilterBtnPrm();
        listingPage.clickAllowAccessLocationButton();
        filterPage.clickBackBtn();
    }
}
