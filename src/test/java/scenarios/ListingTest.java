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

    /*@Stories("As a user i want be able to see GPS Turn On Confirmations Alert ")
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
    }*/

    @Stories("As A User i want to able see Content in Navigation Menu")
    @Title("Verify System display All Content in Navigation Menu")
    @TestCaseId("TC_LISTING_06_001, TC_LISTING_06_027, TC_LISTING_06_026, TC_LISTING_06_33")
    @Test(priority = 3)
    public void verifyAllContentsInHamburgerBar()
    {
        listingPage.initialListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        hamburgerBarModule.closeHamburgerBarDrawer();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a User I want enable Search ads")
    @Title("Verify Search ads by Keyword in Search Box")
    @TestCaseId("TC_LISTING_06_002")
    @Test(priority = 3)
    public void userAbleSearchAdsByInputtedKeyword()
    {
        listingPage.initialListingPage();
        listingPage.clickSearchBtnPrm();
        listingPage.inputSearchKeyword("Jazz");
        listingPage.verifySuggestionList();
        listingPage.clickSuggestions();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a User I want to Click 1Km dari Kamu")
    @Title("Verify User able to redirect to Radius Selection Page")
    @TestCaseId("TC_LISTING_06_004")
    @Test(priority = 3)
    public void userAbleToClick1KMDariKamuButton()
    {
        listingPage.initialListingPage();
        filterByMapsLocationModule = listingPage.clickJarakDariKamuBtn();
        filterByMapsLocationModule.verifyAllContentInLocationPage();
        filterByMapsLocationModule.clickCariDiLokasiIniBtn();
    }

    @Stories("As A User I want Bottom Bar Disappear")
    @Title("Verify ads Scrolling Unlimited and Bottom Bar Disappear when Scrolling")
    @TestCaseId("TC_LISTING_06_012, TC_LISTING_06_013")
    @Test(priority = 3)
    public void verifyBtmBarDissappear()
    {
        listingPage.initialListingPage();
        listingPage.verifyContentsOfListingPage();
        listingPage.verifyBtmBarDissappear();
        listingPage.verifyBtmBarAppear();
    }

    @Stories("As A User i want to able Click Pusat Bantuan")
    @Title("Verify User able to click PusatBantuan Button")
    @TestCaseId("TC_LISTING_06_036")
    @Test(priority = 11)
    public void userAbleToGoToPusatBantuan() {
        listingPage.initialListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAvatarSaya();
        hamburgerBarModule.clickPusatBantuanBtn();
        hamburgerBarModule.verifyPusatBantuanContent();
        hamburgerBarModule.closeHamburgerBarDrawer();

    }

    @Stories("As A User i want to able Click Pusat Bantuan")
    @Title("Verify User able to click PusatBantuan Button")
    @TestCaseId("TC_LISTING_06_036")
    @Test(priority = 12)
    public void userAbleToGoToTentangOlx() {
        listingPage.initialListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAvatarSaya();
        hamburgerBarModule.clickTentangOLXBtn();
        hamburgerBarModule.verifyTentangOlxContent();
        hamburgerBarModule.closeHamburgerBarDrawer();

    }


    @Stories("As user i want to be able change radius")
    @Title("Verify Listing ads sorted by selected radius location")
    @TestCaseId("TC_FILTER_08_010, TC_FILTER_08_011, TC_FILTER_08_012, TC_FILTER_08_013, TC_FILTER_08_014")
    @Test(priority = 3)
    public void userAbleToChangeRadius() {
        listingPage.initialListingPage();
        filterPage = listingPage.clickFilterBtnPrm();
        filterByMapsLocationModule = filterPage.clickLocationButton();
        filterByMapsLocationModule.verifyAllContentInLocationPage();
        filterByMapsLocationModule.inputKeywordInSearchFields("Menara");
        filterByMapsLocationModule.verifySuggestions();
        filterByMapsLocationModule.chooseSuggestion(1);

        filterByMapsLocationModule.slideRightSliderRadius();
        filterByMapsLocationModule.clickCariDiLokasiIniBtn();
        filterPage.clickSimpanButton();
        listingPage.verifyLocationsChanged(
                filterByMapsLocationModule.locationText);
    }


    @Stories("As A User I want to Able Click Button in Bottom Bar")
    @Title("Verify User able to click Kategori on Bottom Bar")
    @TestCaseId("TC_LISTING_06_021")
    @Test(priority = 3)
    public void userAbleGoToKategoriPage() {
        listingPage.initialListingPage();
        categoryPreferencesPage = listingPage.clickKategoriBtnBtm();
        categoryPreferencesPage.verifyCategoryListing();
    }
}
