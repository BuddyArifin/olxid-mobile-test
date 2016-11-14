package scenarios;

import listeners.ScreenshootsListener;
import module.FilterByMapsLocationModule;
import module.HamburgerBarModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPreferencesPage;
import pages.FilterPage;
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
    FilterPage filterPage;
    FilterByMapsLocationModule filterByMapsLocationModule;
    CategoryPreferencesPage categoryPreferencesPage;

    @Stories("As a User I want to See Content in ListingPage")
    @Title("Verify System able to Display Content in ListingPage")
    @TestCaseId("TC_LISTING_06_001, TC_LISTING_06_003, TC_LISTING_06_009")
    @Test(priority = 1)
    public void verifyContentDisplayInListingPage()
    {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipOnBoardingSliders().skipLogin();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user i want be able to see GPS Turn On Confirmations Alert ")
    @Title("Verify User able to get Confirmation Pop up to Turn On GPS")
    @TestCaseId("TC_LISTING_06_007, TC_LISTING_06_009")
    @Test(priority = 2, enabled = false)
    public void verifyAlertDisplayWhenGPSOff() {
        listingPage.turnOffGPS();
        loginPage.clickSkipOnBoardingSliders().skipLogin();
    }

    @Stories("As a User i want to able choose \"Tolak\" in pop-up Aktivasi GPS")
    @Title("Verify User able to choose \"Tolak\" in Pop-Up Aktivasi GPS")
    @TestCaseId("TC_LISTING_06_008")
    @Test(priority = 3, enabled = false)
    public void verifyUserAbletoSkipPopUpActivating() {
        listingPage.verifyGPSAlertDisplay();
        listingPage.clickGPSCancelBtn();
    }

    @Stories("As a user i want be able to choose \"Hidupkan\" in Pop-Up Aktivasi GPS")
    @Title("Verify User able to choose \"Hidupkan\" in Pop-Up Aktivasi GPS")
    @TestCaseId("TC_LISTING_06_010")
    @Test(priority = 4, enabled = false)
    public void verifyUserAbleToChooseAktivasiGPS() {
        listingPage.turnOnGPS();
        loginPage.clickSkipOnBoardingSliders().skipLogin();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As A User i want to able see Content in Navigation Menu")
    @Title("Verify System display All Content in Navigation Menu")
    @TestCaseId("TC_LISTING_06_001, TC_LISTING_06_027, TC_LISTING_06_026")
    @Test(priority = 5)
    public void verifyAllContentsInHamburgerBar()
    {
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
    }

    @Stories("As a user i want to be able close Navigation Menu")
    @Title("Verify System didn't display navigation menu")
    @TestCaseId("TC_LISTING_06_001, TC_LISTING_06_33")
    @Test(priority = 6)
    public void closeNavigationMenu()
    {
        listingPage = hamburgerBarModule.closeHamburgerBarDrawer();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a User I want enable Search ads")
    @Title("Verify Search ads by Keyword in Search Box")
    @TestCaseId("TC_LISTING_06_002")
    @Test(priority = 7)
    public void userAbleSearchAdsByInputtedKeyword()
    {
        listingPage.clickSearchBtnPrm();
        listingPage.inputSearchKeyword("Jazz");
        listingPage.verifySuggestionList();
        listingPage.clickSuggestions();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a User I want to Click 1Km dari Kamu")
    @Title("Verify User able to redirect to Radius Selection Page")
    @TestCaseId("TC_LISTING_06_004")
    @Test(priority = 8)
    public void userAbleToClick1KMDariKamuButton()
    {

        filterByMapsLocationModule = listingPage.clickJarakDariKamuBtn();
        filterByMapsLocationModule.verifyAllContentInLocationPage();
        filterByMapsLocationModule.clickCariDiLokasiIniBtn();
    }

    @Stories("As A User I want Bottom Bar Disappear")
    @Title("Verify ads Scrolling Unlimited and Bottom Bar Disappear when Scrolling")
    @TestCaseId("TC_LISTING_06_012")
    @Test(priority = 9)
    public void verifyBtmBarDissappear()
    {
        listingPage.verifyContentsOfListingPage();
        listingPage.verifyBtmBarDissappear();
    }

    @Stories("As A User I want Bottom Bar Appear")
    @Title("Verify Bottom Bar Appear when Scrolling Up")
    @TestCaseId("TC_LISTING_06_013")
    @Test(priority = 10)
    public void verifyBtmBarAppear()
    {
        listingPage.verifyBtmBarAppear();
    }

    @Stories("As A User i want to able Click Pusat Bantuan")
    @Title("Verify User able to click PusatBantuan Button")
    @TestCaseId("TC_LISTING_06_036")
    @Test(priority = 11, enabled = false)
    public void userAbleToGoToPusatBantuan() {
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.clickPusatBantuanBtn();
        hamburgerBarModule.verifyPusatBantuanContent();
        hamburgerBarModule.closeHamburgerBarDrawer();

    }

    @Stories("As A User i want to able Click Pusat Bantuan")
    @Title("Verify User able to click PusatBantuan Button")
    @TestCaseId("TC_LISTING_06_036")
    @Test(priority = 12, enabled = false)
    public void userAbleToGoToTentangOlx() {
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.clickTentangOLXBtn();
        hamburgerBarModule.verifyTentangOlxContent();
        hamburgerBarModule.closeHamburgerBarDrawer();

    }


    @Stories("As A User I want to able Click Filter/Advance on the primary tool")
    @Title("Verify User able to click Filter on the primary toolbar")
    @TestCaseId("TC_LISTING_06_021")
    @Test(priority = 13)
    public void userAbleToClickFilterButton()
    {
        filterPage = listingPage.clickFilterBtnPrm();
    }


    /**
     * MAPS Test Sections
     * */

    @Stories("As a user i want to be able select detail location")
    @Title("Verify user redirect to Detail Location Page")
    @TestCaseId("TC_FILTER_08_010")
    @Test(priority = 14)
    public void verifyUserAbleToRedirectToMaps() {
        filterPage.clickLocationButton();
        filterByMapsLocationModule.verifyAllContentInLocationPage();
    }

    @Stories("As user i want to be able input location")
    @Title("Verify Listing ads sorted by inputted location")
    @TestCaseId("TC_FILTER_08_011")
    @Test(priority = 15)
    public void userAbleToSearchLocationByTypingAddress() {
        filterByMapsLocationModule.inputKeywordInSearchFields("Menara");
    }

    @Stories("As user i want to see suggestion location")
    @Title("Verify System able to display suggestion as user input location")
    @TestCaseId("TC_FILTER_08_012")
    @Test(priority = 16)
    public void userAbleToSeeSuggesstionAfterTyping() {
        filterByMapsLocationModule.verifySuggestions();
    }

    @Stories("As user i want to be able select location")
    @Title("Verify Listing ads sorted by selected suggestion location")
    @TestCaseId("TC_FILTER_08_013")
    @Test(priority = 17)
    public void userAbleToSelectLocationFromSuggestions() {
        filterByMapsLocationModule.chooseSuggestion(1);
    }

    @Stories("As user i want to be able change radius")
    @Title("Verify Listing ads sorted by selected radius location")
    @TestCaseId("TC_FILTER_08_014")
    @Test(priority = 18)
    public void userAbleToChangeRadius() {
        filterByMapsLocationModule.slideRightSliderRadius();
        filterByMapsLocationModule.clickCariDiLokasiIniBtn();
        filterPage.clickSimpanButton();
        listingPage.verifyLocationsChanged(
                filterByMapsLocationModule.locationText);
    }


    @Stories("As A User I want to Able Click Button in Bottom Bar")
    @Title("Verify User able to click Kategori on Bottom Bar")
    @TestCaseId("TC_LISTING_06_021")
    @Test(priority = 19)
    public void userAbleGoToKategoriPage() {
        categoryPreferencesPage = listingPage.clickKategoriBtnBtm();
        categoryPreferencesPage.verifyCategoryListing();
    }
}
