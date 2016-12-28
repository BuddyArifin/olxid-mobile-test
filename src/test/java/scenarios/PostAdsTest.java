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
 * Created by NugrohoSantoso on 9/6/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Post Ads Test")
public class PostAdsTest extends AndroidSetup {
    LoginPage loginPage;
    LoginWithOlxModule loginWithOlxModule;
    ListingPage listingPage;
    PostAdsPage postAdsPage;
    PostAdsPage.Maps maps;
    PaidFeatureModule paidFeatureModule;

    @Stories("As a user not able Post Ads")
    @Title("Verify user not able to post ads if user not log in")
    @TestCaseId("TC_JUAL_11_001, TC_JUAL_11_042")
    @Test(priority = 1)
    public void postadsNoLogin(){
        loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        listingPage = loginPage.skipLogin();
        listingPage.verifyContentsOfListingPage();
        postAdsPage = listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Mobil Audi TT Tahun 2015");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
        postAdsPage.verifyAdditionalInputMobilDanMotorCategory();
        postAdsPage.inputAdditionalInputFieldTahun();
        postAdsPage.clickDetilTambahDanDeskripsi();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dijual Mobil Audi TT Tahun 2015");
        postAdsPage.verifyNoLimitCharacterDescription();
        postAdsPage.clickPasangIklanButton();
        postAdsPage.verifyLoginPopupNotif();
        loginPage = postAdsPage.clickLoginBtnInLoginPopup();
        loginPage.verifyOlxBtn();
        loginWithOlxModule = loginPage.clickLoginWithOlx();
        loginWithOlxModule.loginWithNewUser();
        loginWithOlxModule.clickLoginWithOlxBtn();
        postAdsPage.verifyPopUpSuccesPostingAdsAppear();
        postAdsPage.verifyContentInPopUpSuccessPosting();
        listingPage = postAdsPage.clickTutupPopUpConfirmationButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user i want to be able to take photo")
    @Title("Verify user able to take photo")
    @TestCaseId("TC_JUAL_11_002")
    @Test(priority = 3)
    public void verifyUserAbleToTakePhoto()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
    }

    @Stories("As a user i want see additional content camera page")
    @Title("Verify System display additional content in camera page")
    @TestCaseId("TC_JUAL_11_004, TC_JUAL_11_005")
    @Test(priority = 3)
    public void verifySystemDisplayAdditionalContentInCameraPage()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
    }

    @Stories("As a user i want to be able to cancel take photo")
    @Title("Verify user able to cancel take photo")
    @TestCaseId("TC_JUAL_11_003")
    @Test(priority = 3)
    public void verifyUserAbleToCancelTakePhoto()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.clickCloseBtnAtas();
        postAdsPage.verifyContentPostingForm();
    }

    @Stories("As a user i want to be able see and click X Button (Right Side Photo)")
    @Title("Verify user able to click X button (Beside Jual Title)")
    @TestCaseId("TC_JUAL_11_015")
    @Test(priority = 3)
    public void verifyUserAbleToClickXButtonBesideJualTitle()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickBackDevice();
        postAdsPage.verifyContentPostingForm();
        listingPage = postAdsPage.clickBatalNavigateUp();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user i want to be able retake photo")
    @Title("Verify User able to retake photo after tap \"Ulang\" Button")
    @TestCaseId("TC_JUAL_11_006")
    @Test(priority = 3)
    public void verifyUserAbleToRetakePhotoAfterTapUlangButton()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.clickUlangBtn();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
    }

    @Stories("As a user i want to cancel cropping")
    @Title("Verify User able to cancel cropping")
    @TestCaseId("TC_JUAL_11_009")
    @Test(priority = 3)
    public void verifyUserAbleToCancelCropping()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.clickCropBtnAtas();
        postAdsPage.verifyContentAdditionalWhenCroppingPhoto();
        postAdsPage.clickBatalNavigateUpCrop();
    }

    @Stories("As a user i want to be able crop photo")
    @Title("Verify User able to crop photo")
    @TestCaseId("TC_JUAL_11_008")
    @Test(priority = 3)
    public void verifyUserAbleToCropPhoto()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.getSizeElementsBeforeRotateAndCrop();
        postAdsPage.clickCropBtnAtas();
        postAdsPage.verifyContentAdditionalWhenCroppingPhoto();
        postAdsPage.click169CropControlOption();
        postAdsPage.clickCropBtnAccept();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.verifyImageCropped();
    }

    @Stories("As a user i want to be able rotate photo")
    @Title("Verify User able to rotate photo")
    @TestCaseId("TC_JUAL_11_010")
    @Test(priority = 3)
    public void verifyUserAbleToRotatePhoto()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.getSizeElementsBeforeRotateAndCrop();
        postAdsPage.clickRotateBtn();
        postAdsPage.verifyImageRotated();
    }

    @Stories("As a user i want to be able input title ads")
    @Title("Verify User able to insert title ads")
    @TestCaseId("TC_JUAL_11_012")
    @Test(priority = 3)
    public void verifyUserAbleToInsertTitleAds()
    {

        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Xiaomi Layarnya Meledak");
    }

    @Stories("As user i want to be able content in PostingForm Step 2")
    @Title("Verify System able to display content in PostingForm Step 2")
    @TestCaseId("TC_JUAL_11_007, TC_JUAL_11_014, TC_JUAL_11_015")
    @Test(priority = 3)
    public void verifySystemAbleToDisplayContentInPostingFormStep2()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickBackDevice();
        postAdsPage.verifyContentPostingForm();
    }

    @Stories("As a user i want to be able click and input title Ads")
    @Title("Verify user able to click and input title Ads in Judul Column")
    @TestCaseId("TC_JUAL_11_019")
    @Test(priority = 3)
    public void verifyUserAbleToClickAndInputTitleAdsInJudulColumn()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickBackDevice();
        postAdsPage.verifyContentPostingForm();
        postAdsPage.inputJudulAds("Xiaomi Layar Meledak");
    }

    @Stories("As a user i want to be able choose Location of my ads")
    @Title("Verify user able to choose Location of my ads")
    @TestCaseId("TC_JUAL_11_041")
    @Test(priority = 3)
    public void verifyUserAbleToChooseLocationOfMyAds()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickBackDevice();
        postAdsPage.verifyContentPostingForm();
        maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();
    }

    @Stories("As a user i want to be able see suggestion Kategori")
    @Title("Verify system able to display suggestion Kategori")
    @TestCaseId("TC_JUAL_11_021")
    @Test(priority = 3)
    public void verifySystemAbleToDisplaySuggestionKategori()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickBackDevice();
        postAdsPage.verifyContentPostingForm();
        postAdsPage.inputJudulAds("Xiaomi Layarnya Meledak");
        postAdsPage.verifySuggestionKategori();
    }

    @Stories("As a user i want to be able click and edit Ads Kategori")
    @Title("Verify user able to click and edit Ads Kategori")
    @TestCaseId("TC_JUAL_11_020")
    @Test(priority = 3)
    public void verifyUserAbleToClickAndEditAdsKategori()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickBackDevice();
        postAdsPage.verifyContentPostingForm();
        postAdsPage.inputJudulAds("Dijual Rumah Dekat Pantai Kuta");
        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
    }

    @Stories("As a user i want to be able click and input price Ads")
    @Title("Verify user able to click and input price Ads")
    @TestCaseId("TC_JUAL_11_022, TC_JUAL_11_023")
    @Test(priority = 3)
    public void verifyUserAbleToClickAndInputPriceAds()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Xiaomi Layarnya Meledak");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
    }

    @Stories("As a user i want to be able input Description and no character limit")
    @Title("Verify user able to input Description and no character limit")
    @TestCaseId("TC_JUAL_11_031")
    @Test(priority = 3)
    public void verifyUserAbleToInputDescriptionAndNoCharacterLimit()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickBackDevice();
        postAdsPage.verifyContentPostingForm();
        postAdsPage.clickDetilTambahanDeskripsiExpandDock();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dijual Xiaomi Layar 5.5 inci, kondisi 99% bagus");
        postAdsPage.verifyNoLimitCharacterDescription();
    }


    @Stories("As a user i want to able post Ads")
    @Title("Verify user success Post Ads")
    @TestCaseId("TC_JUAL_11_036, TC_JUAL_11_038, TC_JUAL_11_040")
    @Test(priority = 3)
    public void verifyUserSuccessPostAds()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Xiaomi Layarnya Meledak");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
        postAdsPage.clickDetilTambahanDeskripsiExpandDock();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dijual Xiaomi Layar 5.5 inci, kondisi 99% bagus");
        postAdsPage.verifyNoLimitCharacterDescription();
        postAdsPage.clickPasangIklanButton();
        postAdsPage.verifyContentInPopUpSuccessPosting();
        postAdsPage.clickTutupPopUpConfirmationButton();
        listingPage.verifyContentsOfListingPage();
    }

    /*@Stories("As a user i want to be able click \"Gunakan Fitur Top Listing\"")
    @Title("Verify user able click \"Gunakan Fitur Top Listing\"")
    @TestCaseId("TC_JUAL_11_039")
    @Test(priority = 24, enabled = false)
    public void verifyUserAbleClickGunakanFiturTopListingButton()
    {
        postAdsPage.clickGunakanFiturTopListingButton();
    }

    @Stories("As a user i want to be able skip input \"Description\"")
    @Title("Verify user able to skip input Description")
    @TestCaseId("TC_JUAL_11_032")
    @Test(priority = 26, enabled = false)
    public void verifyUserAbleToSkipInputDescription()
    {
    }

    @Stories("As a user i want to be able input description later")
    @Title("Verify user able to input Description later")
    @TestCaseId("TC_JUAL_11_033")
    @Test(priority = 27, enabled = false)
    public void verifyUserAbleToInputDescriptionLater()
    {
    }*/

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify User able to Input additional Input Field \"Mobil\" and \"Motor\" Kategori")
    @TestCaseId("TC_JUAL_11_025, TC_JUAL_11_026")
    @Test(priority = 3)
    public void verifySystemAbleToDisplayAdditionalInputFieldMobilMotorKategori()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Mobil Audi TT Tahun 2015");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
        postAdsPage.verifyAdditionalInputMobilDanMotorCategory();
        postAdsPage.inputAdditionalInputFieldTahun();
        postAdsPage.clickDetilTambahDanDeskripsi();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dijual Mobil Audi TT Tahun 2015");
        postAdsPage.verifyNoLimitCharacterDescription();
        postAdsPage.clickPasangIklanButton();
        postAdsPage.verifyPopUpSuccesPostingAdsAppear();
        postAdsPage.verifyContentInPopUpSuccessPosting();
        postAdsPage.clickTutupPopUpConfirmationButton();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify System able to display additional Input Field \"Properti\" Kategori")
    @TestCaseId("TC_JUAL_11_027, TC_JUAL_11_028")
    @Test(priority = 3)
    public void verifySystemAbleToDisplayAdditionalInputFieldPropertiKategori()
    {
        postAdsPage.initialPostAdsTest();
        listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Dijual Rumah Di Daerah Pondok Indah");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
        postAdsPage.verifyAdditionalInputFieldPropertiCategory();
        postAdsPage.inputAdditionalFieldLuasTanah("200");
        postAdsPage.inputAdditionalFieldLuasBangunan("200");
        postAdsPage.clickDetilTambahDanDeskripsi();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dijual Rumah Di Daerah Pondok Indah Dengan Luas Tanah 200, Luas Bangunan 200, 4 Lantai");
        postAdsPage.verifyNoLimitCharacterDescription();
        postAdsPage.clickPasangIklanButton();
        postAdsPage.verifyPopUpSuccesPostingAdsAppear();
        postAdsPage.verifyContentInPopUpSuccessPosting();
        postAdsPage.clickTutupPopUpConfirmationButton();
        listingPage.verifyContentsOfListingPage();
    }

/*    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify System able to display additional Input Field in \"Jasa & Lowongan\" Kategori")
    @TestCaseId("TC_JUAL_11_029, TC_JUAL_11_030")
    @Test(priority = 30, enabled = false)
    public void verifySystemAbleToDisplayAdditionalInputFieldJasaDanLowonganKategori()
    {
        postAdsPage = listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Dicari Karyawan Untuk Administrasi");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        //postAdsPage.clickJasaLowonganAdministrasi();
        postAdsPage.verifyHargaChangeToGaji();
        postAdsPage.verifyAdditionalInputFieldJasaLowonganCategory();
        postAdsPage.inputAdditionalInputFieldGajiMinimal("3000000");
        postAdsPage.inputAdditionalInputFieldGajiMaksimal("6000000");
        postAdsPage.clickDetilTambahDanDeskripsi();
        postAdsPage.inputDetilTambahanDanDeskripsi("Dicari 5 Orang Karyawan Di Bidang Administrasi");
        postAdsPage.verifyNoLimitCharacterDescription();
        postAdsPage.clickPasangIklanButton();
        postAdsPage.verifyPopUpSuccesPostingAdsAppear();
        postAdsPage.verifyContentInPopUpSuccessPosting();
        listingPage = postAdsPage.clickTutupPopUpConfirmationButton();
        listingPage.verifyContentsOfListingPage();
    }*/
}
