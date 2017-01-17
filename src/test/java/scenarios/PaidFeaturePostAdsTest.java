package scenarios;

import listeners.ScreenshootsListener;
import module.LoginWithOlxModule;
import module.PaidFeatureModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ListingPage;
import pages.LoginPage;
import pages.PostAdsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 12/13/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Paid Feature")
public class PaidFeaturePostAdsTest extends AndroidSetup {
    ListingPage listingPage;
    PostAdsPage postAdsPage;

    @Stories("As a user I want to be able to see Pilih Durasi Top Listing contents")
    @Title("Verify system able to display Pilih Durasi Top Listing contents as a pop up after user click Gunakan Fitur Top Listing button")
    @TestCaseId("TC_PAIDF_16_009, TC_PAIDF_16_013, TC_JUAL_11_039, TC_JUAL_11_040")
    @Test(priority = 1, groups = "smoke.test")
    public void verifyUserAbleToSeeTopListingAfterChooseHighlightonSuccessPostAds() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        LoginWithOlxModule loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.loginUserWithBalance();
        loginOlx.clickLoginWithOlxBtn();
        listingPage = loginOlx.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        postAdsPage = listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Mobil Audi TT Tahun 2015");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        PostAdsPage.Maps maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
        postAdsPage.verifyAdditionalInputMobilDanMotorCategory();
        postAdsPage.inputAdditionalInputFieldTahun();
        postAdsPage.inputNomorHandphone("085718893452");
        postAdsPage.clickDetilTambahDanDeskripsi();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dijual Mobil Audi TT Tahun 2015");
        postAdsPage.verifyNoLimitCharacterDescription();
        postAdsPage.clickPasangIklanButton();
        postAdsPage.verifyContentInPopUpSuccessPosting();
        PaidFeatureModule paidFeature = postAdsPage.clickGunakanFiturTopListingButton();
        paidFeature.clickBatalOnTopListing();
    }

    @Stories("As a user I want to be able to click Beli on Pilih Durasi Top Listing")
    @Title("Verify system able to click Beli on Pilih Durasi Top Listing")
    @TestCaseId("TC_PAIDF_16_011, TC_PAIDF_16_012")
    @Test(priority = 3, groups = "smoke.test")
    public void verifyUserAbleToClickBeliAfterPilihDurasiTopListing() {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Mobil Audi TT Tahun 2015");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        PostAdsPage.Maps maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
        postAdsPage.verifyAdditionalInputMobilDanMotorCategory();
        postAdsPage.inputAdditionalInputFieldTahun();
        postAdsPage.inputNomorHandphone("085718893452");
        postAdsPage.clickDetilTambahDanDeskripsi();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dijual Mobil Audi TT Tahun 2015");
        postAdsPage.verifyNoLimitCharacterDescription();
        postAdsPage.clickPasangIklanButton();
        postAdsPage.verifyContentInPopUpSuccessPosting();
        PaidFeatureModule paidFeature = postAdsPage.clickGunakanFiturTopListingButton();
        paidFeature.clickDuration3Days();
        paidFeature.clickBeliOnTopListing();
    }


}
