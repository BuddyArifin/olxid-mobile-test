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
@Features("Filter Feature")
public class FilterTest extends AndroidSetup{
    LoginPage loginPage;
    ListingPage listingPage;
    FilterPage filterPage;
    FilterPage.MapsFilter mapsFilter;

    @Stories("As a User I want See Content in Filter Page")
    @Title("Verify System Display Content in Filter Page")
    @TestCaseId("TC_FILTER_08_002, TC_LISTING_06_021")
    @Test(priority = 1)
    public void verifyAllContentInFilterPage()
    {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipOnBoardingSliders().skipLogin();
        listingPage.verifyContentsOfListingPage();
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.verifyAllContentOfFilterPage();
    }

    @Stories("As a User I want See cancel input button")
    @Title("Verify System Display cancel input button")
    @TestCaseId("TC_FILTER_08_003")
    @Test(priority = 3)
    public void verifyButtonXExist()
    {   filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.verifySuggestionList();
        filterPage.verifyCancelButton();
    }

    @Stories("As a User i want to be able cancel inputted keyword")
    @Title("Verify Search Field null")
    @TestCaseId("TC_FILTER_08_003")
    @Test(priority = 3)
    public void verifySearchFieldNull()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickCancelButtonSearchField();
    }

    @Stories("As a User I want to Able Input Keyword Search")
    @Title("Verify Listing ads sorted by inputted keyword")
    @TestCaseId("TC_FILTER_08_005")
    @Test(priority = 3)
    public void verifyListingAdsSortedByInputtedKeyword()
    {   filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickSearchField();
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
        // verify sort by keyword and terbaru
    }

    @Stories("As a user i want see listing by current location")
    @Title("Verify Listing ads sorted by current location")
    @TestCaseId("TC_FILTER_08_006")
    @Test(priority = 3)
    public void verifyListingAdsSortedByCurrentLocation()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        //filterPage.clickCancelButtonSearchField();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickSearchField();
        mapsFilter = filterPage.clickLocationButton();
        mapsFilter.verifyAllContentInLocationPage();
        mapsFilter.clickMyCurrentLocationBtn();
        filterPage = mapsFilter.clickCariDiLokasiIniBtn();
        filterPage.verifyAllContentOfFilterPage();
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user i want see listing by input price range")
    @Title("Verify Listing ads sorted by inputted price range")
    @TestCaseId("TC_FILTER_08_007")
    @Test(priority = 3, enabled = false)
    public void verifyListingAdsSortedByInputtedPriceRange()
    {
    }

    @Stories("As a user i want see listing by nearest, newest, cheaper, expensive")
    @Title("Verify Listing ads sorted by selected nearest, newest, cheaper, expensive")
    @TestCaseId("TC_FILTER_08_008")
    @Test(priority = 3)
    public void verifyListingAdsSortedByUrutkanColumn()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        //filterPage.clickCancelButtonSearchField();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickSearchField();
        filterPage.clickRadioButtonTermahalInUrutkanColumn();
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
        listingPage.verifyListSortByTermahal();
    }

    @Stories("As a user i want see listing by new or second condition")
    @Title("Verify Listing ads sorted by selected condition")
    @TestCaseId("TC_FILTER_08_009")
    @Test(priority = 3, enabled = false)
    public void verifyListingAdsSortedByConditionColumn()
    {
    }

    @Stories("As a user i want to be able select detail location")
    @Title("Verify user redirect to Detail Location Page")
    @TestCaseId("TC_FILTER_08_010")
    @Test(priority = 3)
    public void verifyUserRedirectToDetailLocationPage()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        mapsFilter = filterPage.clickLocationButton();
        mapsFilter.verifyAllContentInLocationPage();
    }

    @Stories("As a user i want be able to see GPS Turn On Confirmations Alert ")
    @Title("Verify User able to get Confirmation Pop up to Turn On GPS")
    @TestCaseId("TC_LISTING_06_015, TC_LISTING_06_017")
    @Test(priority = 3,enabled = false)
    public void verifyAlertDisplayWhenGPSOff() {
        mapsFilter.turnOffGPS();
        mapsFilter.verifyGPSAlertDisplay();
    }

    @Stories("As a User i want to able choose \"Tolak\" in pop-up Aktivasi GPS")
    @Title("Verify User able to choose \"Tolak\" in Pop-Up Aktivasi GPS")
    @TestCaseId("TC_LISTING_06_016")
    @Test(priority = 3, enabled = false)
    public void verifyUserAbletoSkipPopUpActivating() {
        mapsFilter.clickGPSCancelBtn();
    }

    @Stories("As a user i want be able to choose \"Hidupkan\" in Pop-Up Aktivasi GPS")
    @Title("Verify User able to choose \"Hidupkan\" in Pop-Up Aktivasi GPS")
    @TestCaseId("TC_LISTING_06_018")
    @Test(priority = 3, enabled = false)
    public void verifyUserAbleToChooseAktivasiGPS() {
        mapsFilter.turnOnGPS();
        mapsFilter.verifyAllContentInLocationPage();
    }

    @Stories("As user i want to see suggestion location")
    @Title("Verify System able to display suggestion as user input location")
    @TestCaseId("TC_FILTER_08_012, TC_FILTER_08_012")
    @Test(priority = 3)
    public void verifySystemAbleToDisplaySuggestionAsUserInputLocation()
    {   filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        mapsFilter = filterPage.clickLocationButton();
        mapsFilter.verifyAllContentInLocationPage();
        mapsFilter.inputKeywordInSearchFields("Menara");
        mapsFilter.clickSearchField();
        mapsFilter.verifySuggestions();
        mapsFilter.chooseSuggestion(0);
        mapsFilter.clickBackButtonFromMaps();
    }

    @Stories("As user i want to be able select location")
    @Title("Verify Listing ads sorted by selected suggestion location")
    @TestCaseId("TC_FILTER_08_013")
    @Test(priority = 3,enabled = false)
    public void verifyUserAbleToSelectLocationSuggestion()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        mapsFilter.chooseSuggestion(0);
    }

    @Stories("As user i want to be able change radius")
    @Title("Verify Listing ads sorted by selected radius location")
    @TestCaseId("TC_FILTER_08_014")
    @Test(priority = 2)
    public void verifySliderSlideRight()
    {   filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        mapsFilter = filterPage.clickLocationButton();
        mapsFilter.verifyAllContentInLocationPage();
        mapsFilter.clickMyCurrentLocationBtn();
        mapsFilter.slideRightSliderRadius();
        mapsFilter.clickCariDiLokasiIniBtn();
        filterPage.clickSimpanButton();
    }

    @Stories("As user i want to see sub-category option")
    @Title("Verify System display sub-category option")
    @TestCaseId("TC_FILTER_08_020")
    @Test(priority = 3)
    public void verifyCategoryElementAppear()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
       // filterPage.inputKeywordSearchField("Jazz");
       // filterPage.clickCancelButtonSearchField();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickChooseCategoryField();
    }

    @Stories("As user i want to be able select sub-category Mobil Bekas Honda")
    @Title("Verify Listing ads sorted by selected sub-category Mobil Bekas Honda")
    @TestCaseId("TC_FILTER_08_021")
    @Test(priority = 3)
    public void verifyListingAdsSortedBySelectedSubCategoryMobilBekasHonda()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        //filterPage.inputKeywordSearchField("Jazz");
        //filterPage.clickCancelButtonSearchField();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickChooseCategoryField();
        filterPage.clickMobilBekasHondaCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputMinPrice("1000");
        filterPage.inputMaxPrice("300000000");
        filterPage.pilihTipeKendaraan("Jazz");
        filterPage.pilihTransmisi("Manual");
        filterPage.pilihTahun("2013");
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As user i want to be able select sub-category Mobil Semua Di Mobil")
    @Title("Verify Listing ads sorted by selected sub-category Mobil Semua Di Mobil")
    @TestCaseId("TC_FILTER_08_022")
    @Test(priority = 3)
    public void verifyListingAdsSortedBySelectedSubCategoryMobilSemuaDiMobil()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickChooseCategoryField();
        filterPage.clickSemuaDiMobilCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.clickMinimumPrice();
        filterPage.inputMinPrice("1000");
        filterPage.inputMaxPrice("300000000");
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As user i want to be able select sub-category Properti Rumah Dijual")
    @Title("Verify Listing ads sorted by selected sub-category Properti Rumah Dijual")
    @TestCaseId("TC_FILTER_08_024")
    @Test(priority = 3)
    public void verifyListingAdsSortedBySelectedSubCategoryPropertiRumahDijual()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickChooseCategoryField();
        filterPage.clickPropertiRumahDijualCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputMinPrice("1000000");
//        filterPage.inputMaxPrice("800000000");
        filterPage.inputLuasTanah("100");
        filterPage.inputLuasBangunan("100");
        filterPage.inputLantai("2");
        filterPage.pilihKamarTidur("2");
        filterPage.pilihKamarMandi("2");
        filterPage.pilihSertifikasi("HGB - Hak Guna Bangun/Lainnya  (PPJB,Girik,Adat,dll)/SHM - Sertifikat Hak Milik");
        filterPage.pilihFasilitas("AC/Telephone/PAM/Microwave");
//        filterPage.inputAlamatLokasi("Jl. Wijaya 1 no 15");
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As user i want to be able reset filter")
    @Title("Verify System all column back to default")
    @TestCaseId("TC_FILTER_08_019")
    @Test(priority = 3)
    public void verifyResetButtonClicked()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        filterPage.inputKeywordSearchField("samsung galaxy");
        filterPage.clickSearchField();
        filterPage.clickRadioButtonTermurahInUrutkanColumn();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
        listingPage.verifyListSortByTermurah();
        listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();

    }

    @Stories("As user i want to be able back to Listing Page")
    @Title("Verify User back to Listing Page")
    @TestCaseId("TC_FILTER_08_027")
    @Test(priority = 3)
    public void verifyBackButtonClicked()
    {
        filterPage.initialFilterTest();
        listingPage.clickFilterBtnPrm();
        filterPage.clickBackBtn();
        listingPage.verifyContentsOfListingPage();
    }
}
