package scenarios;

import listeners.ScreenshootsListener;
import module.FilterByMapsLocationModule;
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
    FilterByMapsLocationModule filterByMapsLocationModule;

    @Stories("As a User I want See Content in Filter Page")
    @Title("Verify System Display Content in Filter Page")
    @TestCaseId("TC_FILTER_08_002")
    @Test(priority = 1)
    public void verifyAllContentInFilterPage()
    {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipButton();
        listingPage.verifyContentsOfListingPage();
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.verifyAllContentOfFilterPage();
    }

    @Stories("As a User I want See cancel input button")
    @Title("Verify System Display cancel input button")
    @TestCaseId("TC_FILTER_08_003")
    @Test(priority = 2, enabled = false)
    public void verifyButtonXExist()
    {
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("jazz");
        filterPage.verifyCancelButton();
    }

    @Stories("As a User i want to be able cancel inputted keyword")
    @Title("Verify Search Field null")
    @TestCaseId("TC_FILTER_08_003")
    @Test(priority = 3, enabled = false)
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
        filterPage.clickSimpanButton();
    }

    @Stories("As a user i want see listing by current location")
    @Title("Verify Listing ads sorted by current location")
    @TestCaseId("TC_FILTER_08_006")
    @Test(priority = 8, enabled = false)
    public void verifyListingAdsSortedByCurrentLocation()
    {
        listingPage.clickFilterBtnPrm();
        filterByMapsLocationModule = filterPage.clickLocationButton();
    }

    @Stories("As a user i want see listing by input price range")
    @Title("Verify Listing ads sorted by inputted price range")
    @TestCaseId("TC_FILTER_08_007")
    @Test(priority = 5, enabled = false)
    public void verifyListingAdsSortedByInputtedPriceRange()
    {
    }

    @Stories("As a user i want see listing by nearest, newest, cheaper, expensive")
    @Title("Verify Listing ads sorted by selected nearest, newest, cheaper, expensive")
    @TestCaseId("TC_FILTER_08_008")
    @Test(priority = 6)
    public void verifyListingAdsSortedByUrutkanColumn()
    {
        listingPage.clickFilterBtnPrm();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickRadioButtonTerdekatInUrutkanColumn();
        filterPage.clickSimpanButton();
    }

    @Stories("As a user i want see listing by new or second condition")
    @Title("Verify Listing ads sorted by selected condition")
    @TestCaseId("TC_FILTER_08_009")
    @Test(priority = 7)
    public void verifyListingAdsSortedByConditionColumn()
    {
    }

    @Stories("As a user i want to be able select detail location")
    @Title("Verify user redirect to Detail Location Page")
    @TestCaseId("TC_FILTER_08_010")
    @Test(priority = 9, enabled = false)
    public void verifyUserRedirectToDetailLocationPage()
    {
        filterByMapsLocationModule.verifyAllContentInLocationPage();
    }

    @Stories("As user i want to see suggestion location")
    @Title("Verify System able to display suggestion as user input location")
    @TestCaseId("TC_FILTER_08_012")
    @Test(priority = 10, enabled = false)
    public void verifySystemAbleToDisplaySuggestionAsUserInputLocation()
    {
        filterByMapsLocationModule.inputKeywordInSearchFields("Menara");
        filterByMapsLocationModule.verifySuggestions();
    }

    @Stories("As user i want to be able select location")
    @Title("Verify Listing ads sorted by selected suggestion location")
    @TestCaseId("TC_FILTER_08_013")
    @Test(priority = 11, enabled = false)
    public void verifyUserAbleToSelectLocationSuggestion()
    {
        filterByMapsLocationModule.chooseSuggestion(0);
    }

    @Stories("As user i want to be able change radius")
    @Title("Verify Listing ads sorted by selected radius location")
    @TestCaseId("TC_FILTER_08_014")
    @Test(priority = 12, enabled = false)
    public void verifySliderSlideRight()
    {
        filterByMapsLocationModule.slideRightSliderRadius();
        filterByMapsLocationModule.clickCariDiLokasiIniBtn();
    }

    @Stories("As user i want to see sub-category option")
    @Title("Verify System display sub-category option")
    @TestCaseId("TC_FILTER_08_015")
    @Test(priority = 13)
    public void verifyCategoryElementAppear()
    {
        listingPage.clickFilterBtnPrm();
        filterPage.clickUbahButton();
        //filterPage.verifyAllCategory();
    }

    @Stories("As user i want to be able select sub-category Mobil Bekas Honda")
    @Title("Verify Listing ads sorted by selected sub-category Mobil Bekas Honda")
    @TestCaseId("TC_FILTER_08_016")
    @Test(priority = 14)
    public void verifyListingAdsSortedBySelectedSubCategoryMobilBekasHonda()
    {
        filterPage.clickMobilBekasHondaCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputMinPrice("10000000000");
        filterPage.inputMaxPrice("20000000000");
        filterPage.pilihTipeKendaraanJazz();
        filterPage.pilihTipeTransmisi();
        filterPage.pilihTahun();
        filterPage.clickSimpanButton();
    }

    @Stories("As user i want to be able select sub-category Mobil Semua Di Mobil")
    @Title("Verify Listing ads sorted by selected sub-category Mobil Semua Di Mobil")
    @TestCaseId("TC_FILTER_08_017")
    @Test(priority = 15)
    public void verifyListingAdsSortedBySelectedSubCategoryMobilSemuaDiMobil()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickUbahButton();
        filterPage.clickSemuaDiMobilCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputMinPrice("10000000000");
        filterPage.inputMaxPrice("20000000000");
        filterPage.clickSimpanButton();
    }

    @Stories("As user i want to be able select sub-category Properti Rumah Dijual")
    @Title("Verify Listing ads sorted by selected sub-category Properti Rumah Dijual")
    @TestCaseId("TC_FILTER_08_018")
    @Test(priority = 16)
    public void verifyListingAdsSortedBySelectedSubCategoryPropertiRumahDijual()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.verifyAllContentOfFilterPage();
        filterPage.clickUbahButton();
        filterPage.clickPropertiRumahDijualCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputLuasTanah("100");
        filterPage.inputLuasBangunan("100");
        filterPage.inputLantai("2");
        filterPage.pilihKamarTidur();
        filterPage.pilihKamarMandi();
        filterPage.pilihSertifikasi();
        filterPage.pilihFasilitas();
        filterPage.inputAlamatLokasi("Jl. Wijaya 1 no 15");
        filterPage.clickSimpanButton();
    }

    @Stories("As user i want to be able reset filter")
    @Title("Verify System all column back to default")
    @TestCaseId("TC_FILTER_08_019")
    @Test(priority = 17)
    public void verifyResetButtonClicked()
    {
        filterPage = listingPage.clickFilterBtnPrm();
        filterPage.clickResetButton();
        filterPage.clickSearchField();
        filterPage.inputKeywordSearchField("Jazz");
        filterPage.clickRadioButtonTerdekatInUrutkanColumn();
        filterPage.clickUbahButton();
        filterPage.clickMobilBekasHondaCategory();
        filterPage.verifyContentAdditionalFilterInSelectedSubCategory();
        filterPage.inputMinPrice("10000000000");
        filterPage.inputMaxPrice("20000000000");
        filterPage.pilihTipeKendaraanJazz();
        filterPage.pilihTipeTransmisi();
        filterPage.pilihTahun();
        filterPage.clickResetButton();
        filterPage.clickSimpanButton();
    }

    @Stories("As user i want to be able back to Listing Page")
    @Title("Verify User back to Listing Page")
    @TestCaseId("TC_FILTER_08_021")
    @Test(priority = 18, enabled = false)
    public void verifyBackButtonClicked()
    {
        filterPage.clickBackBtn();
    }
}
