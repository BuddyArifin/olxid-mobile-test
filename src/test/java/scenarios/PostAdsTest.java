package scenarios;

import listeners.ScreenshootsListener;
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
    ListingPage listingPage;
    PostAdsPage postAdsPage;

    @Stories("As a user i want to see content in Camera Page")
    @Title("Verify content in camera page")
    @TestCaseId("TC_FILTER_11_001")
    @Test(priority = 1)
    public void verifyAllContentInCameraPage()
    {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipButton();
        listingPage.verifyContentsOfListingPage();
        postAdsPage = listingPage.clickJualBtnBtm();
    }

    @Stories("As a user i want to be able to take photo")
    @Title("Verify user able to take photo")
    @TestCaseId("TC_FILTER_11_002")
    @Test(priority = 2)
    public void verifyUserAbleToTakePhoto()
    {
    }

    @Stories("As a user i want to be able to take photo")
    @Title("Verify user able to cancel take photo")
    @TestCaseId("TC_FILTER_11_003")
    @Test(priority = 3)
    public void verifyUserAbleToCancelTakePhoto()
    {
    }

    @Stories("As a user i want to be able view taken photo")
    @Title("Verify user able to view taken photo")
    @TestCaseId("TC_FILTER_11_004")
    @Test(priority = 4)
    public void verifyUserAbleToViewTakenPhoto()
    {
    }

    @Stories("As a user i want see additional content camera page")
    @Title("Verify System display additional content in camera page")
    @TestCaseId("TC_FILTER_11_005")
    @Test(priority = 5)
    public void verifySystemDisplayAdditionalContentInCameraPage()
    {
    }

    @Stories("As a user i want to be able retake photo")
    @Title("Verify User able to retake photo after tap \"Ulang\" Button")
    @TestCaseId("TC_FILTER_11_006")
    @Test(priority = 6)
    public void verifyUserAbleToRetakePhotoAfterTapUlangButton()
    {
    }

    @Stories("As a user i want be able to use taken photo")
    @Title("Verify User able to use taken photo")
    @TestCaseId("TC_FILTER_11_007")
    @Test(priority = 7)
    public void verifyUserAbleToUseTakenPhoto()
    {
    }

    @Stories("As a user i want to be able use photo in Gallery")
    @Title("Verify User able to use Photo in Gallery")
    @TestCaseId("TC_FILTER_11_008")
    @Test(priority = 8)
    public void verifyUserAbleToUsePhotoInGallery()
    {
    }

    @Stories("As a user i want to be able crop photo")
    @Title("Verify User able to crop photo")
    @TestCaseId("TC_FILTER_11_009")
    @Test(priority = 9)
    public void verifyUserAbleToCropPhoto()
    {
    }

    @Stories("As a user i want to cancel cropping")
    @Title("Verify User able to cancel cropping")
    @TestCaseId("TC_FILTER_11_010")
    @Test(priority = 10)
    public void verifyUserAbleToCancelCropping()
    {
    }

    @Stories("As a user i want to be able rotate photo")
    @Title("Verify User able to rotate photo")
    @TestCaseId("TC_FILTER_11_011")
    @Test(priority = 11)
    public void verifyUserAbleToRotatePhoto()
    {
    }

    @Stories("As a user i want to be able cancel rotate photo")
    @Title("Verify User able to cancel rotate photo")
    @TestCaseId("TC_FILTER_11_012")
    @Test(priority = 12)
    public void verifyUserAbleToCancelRotatePhoto()
    {
    }

    @Stories("As a user i want to be able input title ads")
    @Title("Verify User able to insert title ads")
    @TestCaseId("TC_FILTER_11_013")
    @Test(priority = 13)
    public void verifyUserAbleToInsertTitleAds()
    {
    }

    @Stories("As a user i want to able redirect to Posting Form Step 2")
    @Title("Verify user able to redirect to Posting Form Step 2")
    @TestCaseId("TC_FILTER_11_014")
    @Test(priority = 14)
    public void verifyUserAbleToRedirectToPostingFormStep2()
    {
    }

    @Stories("As user i want to be able content in PostingForm Step 2")
    @Title("Verify System able to display content in PostingForm Step 2")
    @TestCaseId("TC_FILTER_11_015")
    @Test(priority = 15)
    public void verifySystemAbleToDisplayContentInPostingFormStep2()
    {
    }

    @Stories("As a user i want to be able see and click X Button (Right Side Photo)")
    @Title("Verify user able to click X button (Beside Jual Title)")
    @TestCaseId("TC_FILTER_11_016")
    @Test(priority = 16)
    public void verifyUserAbleToClickXButtonBesideJualTitle()
    {
    }

    @Stories("As a user i want to be able click +(Additional Photos)")
    @Title("Verify user able to click +(Additional Photos) button")
    @TestCaseId("TC_FILTER_11_017")
    @Test(priority = 17)
    public void verifyUserAbleToClickPlusAdditionalPhotosButton()
    {
    }

    @Stories("As a user i want to be able choose method to add photo")
    @Title("Verify user able to choose option add photo from gallery")
    @TestCaseId("TC_FILTER_11_018")
    @Test(priority = 18)
    public void verifyUserAbleToChooseOptionAddPhotoFromGallery()
    {
    }

    @Stories("As a user i want to be able cancel uploaded or taken photo")
    @Title("Verify user able to cancel uploaded or taken photo")
    @TestCaseId("TC_FILTER_11_019")
    @Test(priority = 19)
    public void verifyUserAbleToCancelUploadedOrTakenPhoto()
    {
    }

    @Stories("As a user i want to be able click and input title Ads")
    @Title("Verify user able to click and input title Ads in Judul Column")
    @TestCaseId("TC_FILTER_11_020")
    @Test(priority = 20)
    public void verifyUserAbleToClickAndInputTitleAdsInJudulColumn()
    {
    }

    @Stories("As a user i want to be able click and edit Ads Kategori")
    @Title("Verify user able to click and edit Ads Kategori")
    @TestCaseId("TC_FILTER_11_021")
    @Test(priority = 21)
    public void verifyUserAbleToClickAndEditAdsKategori()
    {
    }

    @Stories("As a user i want to be able see suggestion Kategori")
    @Title("Verify system able to display suggestion Kategori")
    @TestCaseId("TC_FILTER_11_022")
    @Test(priority = 22)
    public void verifySystemAbleToDisplaySuggestionKategori()
    {
    }

    @Stories("As a user i want to be able click and input price Ads")
    @Title("Verify user able to click and input price Ads")
    @TestCaseId("TC_FILTER_11_023")
    @Test(priority = 23)
    public void verifyUserAbleToClickAndInputPriceAds()
    {
    }

    @Stories("As a user i want to be able see suggestion Price")
    @Title("Verify system able to display suggestion Price")
    @TestCaseId("TC_FILTER_11_024")
    @Test(priority = 24)
    public void verifySystemAbleToDisplaySuggestionPrice()
    {
    }

    @Stories("As a user able to see additional input Gaji field")
    @Title("Verify System able to change input from harga to Gaji as user choose \"Jasa & Lowongan\"")
    @TestCaseId("TC_FILTER_11_025")
    @Test(priority = 25)
    public void verifySystemAbleToChangeInputFromHargaToGajiAsUserChooseJasaDanLowongan()
    {
    }

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify System able to display additional Input Field \"Mobil\" and \"Motor\" Kategori")
    @TestCaseId("TC_FILTER_11_026")
    @Test(priority = 26)
    public void verifySystemAbleToDisplayAdditionalInputFieldMobilMotorKategori()
    {
    }

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify System able to display additional Input Field \"Properti\" Kategori")
    @TestCaseId("TC_FILTER_11_027")
    @Test(priority = 27)
    public void verifySystemAbleToDisplayAdditionalInputFieldPropertiKategori()
    {
    }

    @Stories("As a user able to see additional input field as user choose \"Mobil\", \"Motor\", \"Properti\", \"Jasa & Lowongan\" Kategori")
    @Title("Verify System able to display additional Input Field in \"Jasa & Lowongan\" Kategori")
    @TestCaseId("TC_FILTER_11_028")
    @Test(priority = 28)
    public void verifySystemAbleToDisplayAdditionalInputFieldJasaDanLowonganKategori()
    {
    }

    @Stories("As a user i want to be able input Description and no character limit")
    @Title("Verify user able to input Description and no character limit")
    @TestCaseId("TC_FILTER_11_029")
    @Test(priority = 29)
    public void verifyUserAbleToInputDescriptionAndNoCharacterLimit()
    {
    }

    @Stories("As a user i want to be able skip input \"Description\"")
    @Title("Verify user able to skip input Description")
    @TestCaseId("TC_FILTER_11_030")
    @Test(priority = 30)
    public void verifyUserAbleToSkipInputDescription()
    {
    }

    @Stories("As a user i want to be able input description later")
    @Title("Verify user able to input Description later")
    @TestCaseId("TC_FILTER_11_031")
    @Test(priority = 31)
    public void verifyUserAbleToInputDescriptionLater()
    {
    }

    @Stories("As a user i will not able to Post ads")
    @Title("Verify user not able to post ads if Pemrosesan Data not check")
    @TestCaseId("TC_FILTER_11_032")
    @Test(priority = 32)
    public void verifyUserNotAbleToPostAdsIfPemrosesanDataNotChecked()
    {
    }

    @Stories("As a user i want to able check Pemrosesan Data")
    @Title("Verify user able to check Pemrosesan Data")
    @TestCaseId("TC_FILTER_11_033")
    @Test(priority = 33)
    public void verifyUserAbleToCheckPemrosesanData()
    {
    }

    @Stories("As a user i want to able post Ads")
    @Title("Verify user success Post Ads")
    @TestCaseId("TC_FILTER_11_034")
    @Test(priority = 34)
    public void verifyUserSuccessPostAds()
    {
    }

    @Stories("As a user i want to be able see Posting Ad Pop-Up confirmation")
    @Title("Verify System display Post Ads Pop-Up confirmation")
    @TestCaseId("TC_FILTER_11_035")
    @Test(priority = 35)
    public void verifySystemDisplayPostAdsPopUpConfirmation()
    {
    }

    @Stories("As a user i want to be see content Pop-Up Confirmation")
    @Title("Verify System display content in Pop-Up Confirmation")
    @TestCaseId("TC_FILTER_11_036")
    @Test(priority = 36)
    public void verifySystemDisplayContentInPopUpConfirmation()
    {
    }

    @Stories("As a user i want to be able click \"Gunakan Fitur Top Listing\"")
    @Title("Verify user able click \"Gunakan Fitur Top Listing\"")
    @TestCaseId("TC_FILTER_11_037")
    @Test(priority = 37)
    public void verifyUserAbleClickGunakanFiturTopListingButton()
    {
    }

    @Stories("As a user i want to be able click \"Tutup\"")
    @Title("Verify user able click \"Tutup\"")
    @TestCaseId("TC_FILTER_11_038")
    @Test(priority = 38)
    public void verifyUserAbleClickTutupButton()
    {
    }
}
