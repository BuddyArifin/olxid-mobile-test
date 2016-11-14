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
    @TestCaseId("TC_FILTER_08_002")
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
    @Test(priority = 2)
    public void verifyButtonXExist()
    {
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("jazz");
        filterPage.verifySuggestionList();
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
    @TestCaseId("TC_FILTER_08_005")
    @Test(priority = 4)
    public void verifyListingAdsSortedByInputtedKeyword()
    {
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickSearchField();
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user i want see listing by current location")
    @Title("Verify Listing ads sorted by current location")
    @TestCaseId("TC_FILTER_08_006")
    @Test(priority = 5)
    public void verifyListingAdsSortedByCurrentLocation()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickCancelButtonSearchField();
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
    @Test(priority = 6, enabled = false)
    public void verifyListingAdsSortedByInputtedPriceRange()
    {
    }

    @Stories("As a user i want see listing by nearest, newest, cheaper, expensive")
    @Title("Verify Listing ads sorted by selected nearest, newest, cheaper, expensive")
    @TestCaseId("TC_FILTER_08_008")
    @Test(priority = 7)
    public void verifyListingAdsSortedByUrutkanColumn()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickCancelButtonSearchField();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickSearchField();
        filterPage.clickRadioButtonTerdekatInUrutkanColumn();
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user i want see listing by new or second condition")
    @Title("Verify Listing ads sorted by selected condition")
    @TestCaseId("TC_FILTER_08_009")
    @Test(priority = 8, enabled = false)
    public void verifyListingAdsSortedByConditionColumn()
    {
    }

    @Stories("As a user i want to be able select detail location")
    @Title("Verify user redirect to Detail Location Page")
    @TestCaseId("TC_FILTER_08_010")
    @Test(priority = 9)
    public void verifyUserRedirectToDetailLocationPage()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        mapsFilter = filterPage.clickLocationButton();
        mapsFilter.verifyAllContentInLocationPage();
    }

    @Stories("As a user i want be able to see GPS Turn On Confirmations Alert ")
    @Title("Verify User able to get Confirmation Pop up to Turn On GPS")
    @TestCaseId("TC_LISTING_06_015, TC_LISTING_06_017")
    @Test(priority = 10,enabled = false)
    public void verifyAlertDisplayWhenGPSOff() {
        mapsFilter.turnOffGPS();
        mapsFilter.verifyGPSAlertDisplay();
    }

    @Stories("As a User i want to able choose \"Tolak\" in pop-up Aktivasi GPS")
    @Title("Verify User able to choose \"Tolak\" in Pop-Up Aktivasi GPS")
    @TestCaseId("TC_LISTING_06_016")
    @Test(priority = 11, enabled = false)
    public void verifyUserAbletoSkipPopUpActivating() {
        mapsFilter.clickGPSCancelBtn();
    }

    @Stories("As a user i want be able to choose \"Hidupkan\" in Pop-Up Aktivasi GPS")
    @Title("Verify User able to choose \"Hidupkan\" in Pop-Up Aktivasi GPS")
    @TestCaseId("TC_LISTING_06_018")
    @Test(priority = 12, enabled = false)
    public void verifyUserAbleToChooseAktivasiGPS() {
        mapsFilter.turnOnGPS();
        mapsFilter.verifyAllContentInLocationPage();
    }

    @Stories("As user i want to see suggestion location")
    @Title("Verify System able to display suggestion as user input location")
    @TestCaseId("TC_FILTER_08_012")
    @Test(priority = 13)
    public void verifySystemAbleToDisplaySuggestionAsUserInputLocation()
    {
        mapsFilter.inputKeywordInSearchFields("Menara");
        mapsFilter.clickSearchField();
        mapsFilter.verifySuggestions();
    }

    @Stories("As user i want to be able select location")
    @Title("Verify Listing ads sorted by selected suggestion location")
    @TestCaseId("TC_FILTER_08_013")
    @Test(priority = 14)
    public void verifyUserAbleToSelectLocationSuggestion()
    {
        mapsFilter.chooseSuggestion(0);
    }

    @Stories("As user i want to be able change radius")
    @Title("Verify Listing ads sorted by selected radius location")
    @TestCaseId("TC_FILTER_08_014")
    @Test(priority = 15)
    public void verifySliderSlideRight()
    {
        mapsFilter.slideRightSliderRadius();
        mapsFilter.clickCariDiLokasiIniBtn();
        filterPage.clickSimpanButton();
    }

    @Stories("As user i want to see sub-category option")
    @Title("Verify System display sub-category option")
    @TestCaseId("TC_FILTER_08_020")
    @Test(priority = 16)
    public void verifyCategoryElementAppear()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickCancelButtonSearchField();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickChooseCategoryField();
    }

    @Stories("As user i want to be able select sub-category Mobil Bekas Honda")
    @Title("Verify Listing ads sorted by selected sub-category Mobil Bekas Honda")
    @TestCaseId("TC_FILTER_08_021")
    @Test(priority = 17)
    public void verifyListingAdsSortedBySelectedSubCategoryMobilBekasHonda()
    {
        filterPage.clickMobilBekasHondaCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputMinPrice("80000000");
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
    @Test(priority = 18)
    public void verifyListingAdsSortedBySelectedSubCategoryMobilSemuaDiMobil()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickChooseCategoryField();
        filterPage.clickSemuaDiMobilCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.clickMinimumPrice();
        filterPage.inputMinPrice("80000000");
        filterPage.inputMaxPrice("300000000");
        listingPage = filterPage.clickSimpanButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As user i want to be able select sub-category Properti Rumah Dijual")
    @Title("Verify Listing ads sorted by selected sub-category Properti Rumah Dijual")
    @TestCaseId("TC_FILTER_08_024")
    @Test(priority = 19)
    public void verifyListingAdsSortedBySelectedSubCategoryPropertiRumahDijual()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickChooseCategoryField();
        filterPage.clickPropertiRumahDijualCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputMinPrice("100000000");
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
    @Test(priority = 20)
    public void verifyResetButtonClicked()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickRadioButtonTerdekatInUrutkanColumn();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.clickMinimumPrice();
        filterPage.inputMinPrice("80000000");
        filterPage.inputMaxPrice("300000000");
//        filterPage.pilihTipeKendaraan("Jazz");
//        filterPage.pilihTransmisi("Manual");
//        filterPage.pilihTahun("2013");
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
    }

    @Stories("As user i want to be able back to Listing Page")
    @Title("Verify User back to Listing Page")
    @TestCaseId("TC_FILTER_08_027")
    @Test(priority = 21)
    public void verifyBackButtonClicked()
    {
        filterPage.clickBackBtn();
        listingPage.verifyContentsOfListingPage();
    }
}
