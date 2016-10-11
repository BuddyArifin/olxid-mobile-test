package scenarios;

import listeners.ScreenshootsListener;
import module.LoginWithOlxModule;
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

    @Stories("As a user i want to see content in Camera Page")
    @Title("Verify content in camera page")
    @TestCaseId("TC_JUAL_11_001")
    @Test(priority = 1)
    public void verifyAllContentInCameraPage()
    {
        loginPage = new LoginPage(driver);
        loginWithOlxModule = loginPage.clickLoginWithOlx();
        loginWithOlxModule.clickLoginWithOlxBtn();
        listingPage = loginWithOlxModule.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        postAdsPage = listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
    }

    @Stories("As a user i want to be able to take photo")
    @Title("Verify user able to take photo")
    @TestCaseId("TC_JUAL_11_002")
    @Test(priority = 2)
    public void verifyUserAbleToTakePhoto()
    {
        postAdsPage.clickShutterBtn();
    }

    @Stories("As a user i want see additional content camera page")
    @Title("Verify System display additional content in camera page")
    @TestCaseId("TC_JUAL_11_004, TC_JUAL_11_005")
    @Test(priority = 3)
    public void verifySystemDisplayAdditionalContentInCameraPage()
    {
        postAdsPage.verifyContentAdditionalInCameraPage();
    }

    @Stories("As a user i want to be able to cancel take photo")
    @Title("Verify user able to cancel take photo")
    @TestCaseId("TC_JUAL_11_003")
    @Test(priority = 4)
    public void verifyUserAbleToCancelTakePhoto()
    {
        postAdsPage.clickCloseBtnAtas();
        postAdsPage.verifyContentPostingForm();
    }

    @Stories("As a user i want to be able see and click X Button (Right Side Photo)")
    @Title("Verify user able to click X button (Beside Jual Title)")
    @TestCaseId("TC_JUAL_11_016")
    @Test(priority = 5)
    public void verifyUserAbleToClickXButtonBesideJualTitle()
    {
        listingPage = postAdsPage.clickBatalNavigateUp();
        listingPage.verifyContentsOfListingPage();
    }

    @Stories("As a user i want to be able retake photo")
    @Title("Verify User able to retake photo after tap \"Ulang\" Button")
    @TestCaseId("TC_JUAL_11_006")
    @Test(priority = 6)
    public void verifyUserAbleToRetakePhotoAfterTapUlangButton()
    {
        postAdsPage = listingPage.clickJualBtnBtm();
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
    @Test(priority = 7)
    public void verifyUserAbleToCancelCropping()
    {
        postAdsPage.clickCropBtnAtas();
        postAdsPage.verifyContentAdditionalWhenCroppingPhoto();
        postAdsPage.clickBatalNavigateUpCrop();
    }

    @Stories("As a user i want to be able crop photo")
    @Title("Verify User able to crop photo")
    @TestCaseId("TC_JUAL_11_008")
    @Test(priority = 8)
    public void verifyUserAbleToCropPhoto()
    {
        postAdsPage.getSizeElementsBeforeRotateAndCrop();
        postAdsPage.clickCropBtnAtas();
        postAdsPage.verifyContentAdditionalWhenCroppingPhoto();
        postAdsPage.click169CropControlOption();
        postAdsPage.clickCropBtnAccept();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.verifyImageCropped();
    }

    @Stories("As a user i want to be able cancel rotate photo")
    @Title("Verify User able to cancel rotate photo")
    @TestCaseId("TC_JUAL_11_010")
    @Test(priority = 9, enabled = false)
    public void verifyUserAbleToCancelRotatePhoto()
    {
    }

    @Stories("As a user i want to be able rotate photo")
    @Title("Verify User able to rotate photo")
    @TestCaseId("TC_JUAL_11_01")
    @Test(priority = 9)
    public void verifyUserAbleToRotatePhoto()
    {
        postAdsPage.getSizeElementsBeforeRotateAndCrop();
        postAdsPage.clickRotateBtn();
        postAdsPage.verifyImageRotated();
    }

    @Stories("As a user i want to be able input title ads")
    @Title("Verify User able to insert title ads")
    @TestCaseId("TC_JUAL_11_013")
    @Test(priority = 10)
    public void verifyUserAbleToInsertTitleAds()
    {
        postAdsPage.inputJudulAds("Xiaomi Layarnya Meledak");
    }

    @Stories("As user i want to be able content in PostingForm Step 2")
    @Title("Verify System able to display content in PostingForm Step 2")
    @TestCaseId("TC_JUAL_11_007, TC_JUAL_11_014, TC_JUAL_11_015")
    @Test(priority = 11)
    public void verifySystemAbleToDisplayContentInPostingFormStep2()
    {
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();
    }

    @Stories("As a user i want to be able choose method to add photo")
    @Title("Verify user able to choose option add photo from gallery")
    @TestCaseId("TC_JUAL_11_017, TC_JUAL_11_018")
    @Test(priority = 13)
    public void verifyUserAbleToChooseOptionAddPhotoFromGallery()
    {
        postAdsPage.clickPlusAdditionalPhotos();
        postAdsPage.verifyOptionAlert();
        postAdsPage.clickGaleriFotoBtn();
        postAdsPage.clickOneOfPictureGallery();
        postAdsPage.clickSimpanBtn();
    }

    @Stories("As a user i want to be able cancel uploaded or taken photo")
    @Title("Verify user able to cancel uploaded or taken photo")
    @TestCaseId("TC_JUAL_11_019")
    @Test(priority = 14)
    public void verifyUserAbleToCancelUploadedOrTakenPhoto()
    {
        postAdsPage.clickCloseButtonXPhotoThumb();
        postAdsPage.clickYaPositiveBtn();
    }

    @Stories("As a user i want to be able click and input title Ads")
    @Title("Verify user able to click and input title Ads in Judul Column")
    @TestCaseId("TC_JUAL_11_020")
    @Test(priority = 15)
    public void verifyUserAbleToClickAndInputTitleAdsInJudulColumn()
    {
        postAdsPage.inputJudulAds("Xiaomi Layar Meledak");
    }

    @Stories("As a user i want to be able click and edit Ads Kategori")
    @Title("Verify user able to click and edit Ads Kategori")
    @TestCaseId("TC_JUAL_11_021")
    @Test(priority = 16)
    public void verifyUserAbleToClickAndEditAdsKategori()
    {
        postAdsPage.clickKategoriAds();
    }

    @Stories("As a user i want to be able see suggestion Kategori")
    @Title("Verify system able to display suggestion Kategori")
    @TestCaseId("TC_JUAL_11_022")
    @Test(priority = 17)
    public void verifySystemAbleToDisplaySuggestionKategori()
    {
        postAdsPage.verifySuggestionKategori();
    }

    @Stories("As a user i want to be able see suggestion Price")
    @Title("Verify system able to display suggestion Price")
    @TestCaseId("TC_JUAL_11_024")
    @Test(priority = 18)
    public void verifySystemAbleToDisplaySuggestionPrice()
    {
        postAdsPage.verifySuggestionHarga();
    }

    @Stories("As a user i want to be able click and input price Ads")
    @Title("Verify user able to click and input price Ads")
    @TestCaseId("TC_JUAL_11_023")
    @Test(priority = 19)
    public void verifyUserAbleToClickAndInputPriceAds()
    {
        postAdsPage.inputHarga("10000000");
    }

    @Stories("As a user i want to be able input Description and no character limit")
    @Title("Verify user able to input Description and no character limit")
    @TestCaseId("TC_JUAL_11_029")
    @Test(priority = 20, enabled = false)
    public void verifyUserAbleToInputDescriptionAndNoCharacterLimit()
    {

    }

    @Stories("As a user i want to be able skip input \"Description\"")
    @Title("Verify user able to skip input Description")
    @TestCaseId("TC_JUAL_11_030")
    @Test(priority = 30, enabled = false)
    public void verifyUserAbleToSkipInputDescription()
    {
    }

    @Stories("As a user i want to be able input description later")
    @Title("Verify user able to input Description later")
    @TestCaseId("TC_JUAL_11_031")
    @Test(priority = 31, enabled = false)
    public void verifyUserAbleToInputDescriptionLater()
    {
    }

    @Stories("As a user i will not able to Post ads")
    @Title("Verify user not able to post ads if Pemrosesan Data not check")
    @TestCaseId("TC_JUAL_11_032")
    @Test(priority = 32, enabled = false)
    public void verifyUserNotAbleToPostAdsIfPemrosesanDataNotChecked()
    {
    }

    @Stories("As a user i want to able check Pemrosesan Data")
    @Title("Verify user able to check Pemrosesan Data")
    @TestCaseId("TC_JUAL_11_033")
    @Test(priority = 33, enabled = false)
    public void verifyUserAbleToCheckPemrosesanData()
    {
    }

    @Stories("As a user i want to able post Ads")
    @Title("Verify user success Post Ads")
    @TestCaseId("TC_JUAL_11_034")
    @Test(priority = 34, enabled = false)
    public void verifyUserSuccessPostAds()
    {
    }

    @Stories("As a user i want to be able see Posting Ad Pop-Up confirmation")
    @Title("Verify System display Post Ads Pop-Up confirmation")
    @TestCaseId("TC_JUAL_11_035")
    @Test(priority = 35, enabled = false)
    public void verifySystemDisplayPostAdsPopUpConfirmation()
    {
    }

    @Stories("As a user i want to be see content Pop-Up Confirmation")
    @Title("Verify System display content in Pop-Up Confirmation")
    @TestCaseId("TC_JUAL_11_036")
    @Test(priority = 36, enabled = false)
    public void verifySystemDisplayContentInPopUpConfirmation()
    {
    }

    @Stories("As a user i want to be able click \"Gunakan Fitur Top Listing\"")
    @Title("Verify user able click \"Gunakan Fitur Top Listing\"")
    @TestCaseId("TC_JUAL_11_037")
    @Test(priority = 37, enabled = false)
    public void verifyUserAbleClickGunakanFiturTopListingButton()
    {
    }

    @Stories("As a user i want to be able click \"Tutup\"")
    @Title("Verify user able click \"Tutup\"")
    @TestCaseId("TC_JUAL_11_038")
    @Test(priority = 38, enabled = false)
    public void verifyUserAbleClickTutupButton()
    {
    }

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify User able to Input additional Input Field \"Mobil\" and \"Motor\" Kategori")
    @TestCaseId("TC_JUAL_11_026")
    @Test(priority = 26, enabled = false)
    public void verifySystemAbleToDisplayAdditionalInputFieldMobilMotorKategori()
    {

    }

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify System able to display additional Input Field \"Properti\" Kategori")
    @TestCaseId("TC_JUAL_11_027")
    @Test(priority = 27, enabled = false)
    public void verifySystemAbleToDisplayAdditionalInputFieldPropertiKategori()
    {
    }

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify System able to display additional Input Field in \"Jasa & Lowongan\" Kategori")
    @TestCaseId("TC_JUAL_11_025, TC_JUAL_11_028")
    @Test(priority = 28, enabled = false)
    public void verifySystemAbleToDisplayAdditionalInputFieldJasaDanLowonganKategori()
    {
    }


}
