package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
public class PostAdsPage extends BasePage {
    public PostAdsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String closeBtn = "";
    public static final String liveViewFrame = "";
    public static final String shutterBtn = "";
    public static final String galeriBtn = "";
    public static final String cropBtnAtas = "";
    public static final String rotateBtn = "";
    public static final String judulIklan = "";
    public static final String ulangBtn = "";
    public static final String batalBtn = "";
    public static final String simpanBtn = "";
    public static final String cropBtnBawah = "";
    public static final String closeBtnPFS2 = "";
    public static final String jualTitle = "";
    public static final String photoAds = "";
    public static final String plusPhotoBtn = "";
    public static final String judulAds = "";
    public static final String kategoriAds = "";
    public static final String hargaAdsGajiAds = "";
    public static final String lokasiIklan = "";
    public static final String detilTambahanDeskripsi = "";
    public static final String pemrosesanData = "";
    public static final String pasangIklanBtn = "";
    public static final String popUpLayoutSuccessPost = "";
    public static final String gunakanFiturTopListingBtn = "";
    public static final String tutupPopUpBtn = "";

    @Step("Verify Content in Camera Page")
    public void verifyContentInCameraPage()
    {
        verifyCloseBtn();
        verifyLiveViewFrame();
        verifyShutterBtn();
        verifyGaleriBtn();
        Log.info("Verify Content in Camera Page");
    }

    @Step("Verify Content Additional in Camera Page")
    public void verifyContentAdditionalInCameraPage()
    {
        verifyCropBtnAtas();
        verifyRotateBtn();
        verifyLiveViewFrame();
        verifyCloseBtn();
        verifyJudulIklan();
        verifyUlangBtn();
        verifySimpanBtn();
        Log.info("Verify Content Additional in Camera Page");
    }

    @Step("Verify Content Additional When Cropping Photo")
    public void verifyContentAdditionalWhenCroppingPhoto()
    {
        verifyBatalBtn();
        verifyCropBtnBawah();
        Log.info("Verify Content Additional When Cropping Photo");
    }

    public void verifyCloseBtn()
    {
        Log.info("Verify Close Button");
    }
    public void verifyLiveViewFrame()
    {
        Log.info("Verify Live View Frame");
    }
    public void verifyShutterBtn()
    {
        Log.info("Verify Shutter Button");
    }
    public void verifyGaleriBtn()
    {
        Log.info("Verify Gallery Button");
    }
    public void verifyCropBtnAtas()
    {
        Log.info("Verify Crop Button Bagian Atas");
    }
    public void verifyRotateBtn()
    {
        Log.info("Verify Rotate Button");
    }
    public void verifyJudulIklan()
    {
        Log.info("Verify Textbox Judul Iklan");
    }
    public void verifyUlangBtn()
    {
        Log.info("Verify Ulang Button");
    }
    public void verifyBatalBtn()
    {
        Log.info("Verify Batal Button");
    }
    public void verifySimpanBtn()
    {
        Log.info("Verify Simpan Button");
    }
    public void verifyCropBtnBawah()
    {
        Log.info("Verify Crop Button Bagian Bawah");
    }

    public void clickBackBtn()
    {
        Log.info("Click Back Button");
    }

    public void clickShutterBtn()
    {
        Log.info("Click Shutter Button");
    }

    public void clickGaleriBtn()
    {
        Log.info("Click Galeri Button");
    }

    public void clickCropBtnAtas()
    {
        Log.info("Click Crop Button Bagian Atas");
    }

    public void clickCropBtnBawah()
    {
        Log.info("Click Crop Button Bagian Bawah");
    }

    public void clickRotateBtn()
    {
        Log.info("Click Rotate Button");
    }

    public void inputIsiJudulIklanDisini()
    {
        Log.info("Input Judul Iklan");
    }

    public void clickUlangBtn()
    {
        Log.info("Click Ulang Button");
    }

    public void clickBatalBtn()
    {
        Log.info("Click Batal Button");
    }

    public void clickSimpanBtn()
    {
        Log.info("Click Simpan Button");
    }

    public void clickGunakan() {
        Log.info("Click Gunakan");
    }

    public void verifyContentPostingForm()
    {
        verifyCloseButtonX();
        verifyJualTitle();
        verifyPhotoThumbnails();
        verifyPlusPhotoThumbnails();
        verifyCancelPhotoThumbnails();
        verifyJudulColumn();
        verifyKategoriColumn();
        verifyHargaOrGajiColumn();
        verifyLokasiIklanColumn();
        verifyDetilTambahanDanDeskripsiColumn();
        verifyPemrosesanDataCheckBoxColumn();
        verifyPasangIklanBtn();
        Log.info("Verify Content in Posting Form");
    }

    public void verifyCloseButtonX()
    {
        Log.info("Verify Cancel Button Beside Title");
    }
    public void verifyJualTitle()
    {
        Log.info("Verify Jual Title");
    }
    public void verifyPhotoThumbnails()
    {
        Log.info("Verify Photo Thumbnails");
    }
    public void verifyPlusPhotoThumbnails()
    {
        Log.info("Verify Plus Button in Photo Thumbnails Column");
    }
    public void verifyCancelPhotoThumbnails()
    {
        Log.info("Verify Cancel Button in Photo Thumbnails Column");
    }
    public void verifyJudulColumn()
    {
        Log.info("Verify Judul Column");
    }
    public void verifyKategoriColumn()
    {
        Log.info("Verify Kategori Column");
    }
    public void verifyHargaOrGajiColumn()
    {
        Log.info("Verify Harga Column");
    }
    public void verifyLokasiIklanColumn()
    {
        Log.info("Verify Lokasi Iklan Column");
    }
    public void verifyDetilTambahanDanDeskripsiColumn()
    {
        Log.info("Verify Detil Tambahan dan Deskripsi Column");
    }
    public void verifyPemrosesanDataCheckBoxColumn()
    {
        Log.info("Verify Pemrosesan Data CheckBox Column");
    }
    public void verifyPasangIklanBtn()
    {
        Log.info("Verify Pasang Iklan Button");
    }

    public void clickCloseButtonX()
    {
        Log.info("Click Close Button X Beside Jual Title");
    }

    public void clickPlusAdditionalPhotos()
    {
        Log.info("Click Plus Additional Photos in Thumbnails");
    }

    public void clickGalleryOrCamera()
    {
        Log.info("Click Gallery or Camera To Add Photo");
    }

    public void clickCancelAdditionalPhotos()
    {
        Log.info("Click Cancel Additional Photos in Thumbnails");
    }

    public void inputJudulAds()
    {
        Log.info("Input Judul Ads");
    }

    public void clickKategoriAds()
    {
        Log.info("Click Kategori Ads");
    }

    public void verifySuggestionKategori()
    {
        Log.info("Verify Suggestion Kategori");
    }

    public void inputHargaOrGajiAds()
    {
        Log.info("Input Harga or Gaji Ads");
    }

    public void verifySuggestionHarga()
    {
        Log.info("Verify Suggestion Harga");
    }

    public void verifyHargaChangeToGaji()
    {
        Log.info("Verify Harga Change To Gaji As User Choose Jasa & Lowongan Kategori");
    }

    public void verifyAdditionalInputField()
    {
        verifyAdditionalInputFieldTahun();
        verifyAdditionalInputFieldLuasTanah();
        verifyAdditionalInputFieldLuasBangunan();
        verifyAdditionalInputFieldSertifikat();
        verifyAdditionalInputFieldFasilitas();
        verifyAdditionalInputFieldJenisPekerjaan();
    }

    public void verifyAdditionalInputFieldTahun()
    {
        Log.info("Verify Additional Input Field Tahun");
    }
    public void verifyAdditionalInputFieldLuasTanah()
    {
        Log.info("Verify Additional Input Field Luas Tanah");
    }
    public void verifyAdditionalInputFieldLuasBangunan()
    {
        Log.info("Verify Additional Input Field Luas Bangunan");
    }
    public void verifyAdditionalInputFieldSertifikat()
    {
        Log.info("Verify Additional Input Field Sertifikat");
    }
    public void verifyAdditionalInputFieldFasilitas()
    {
        Log.info("Verify Additional Input Field Fasilitas");
    }
    public void verifyAdditionalInputFieldJenisPekerjaan()
    {
        Log.info("Verify Additional Input Field Jenis Pekerjaan");
    }

    public void inputDetilTambahanDanDeskripsi()
    {
        Log.info("Input Detil Tambahan dan Deskripsi");
    }

    public void verifyNoLimitCharacterDescription()
    {
        Log.info("Verify No Limit Character Description");
    }

    public void clickSkipInputDescription()
    {
        Log.info("Click Skip Input Description Step");
    }

    public void clickCheckBoxPemrosesanData()
    {
        Log.info("Click CheckBox Pemrosesan Data");
    }

    public void clickPasangIklanButton()
    {
        Log.info("Click Pasang Iklan Button");
    }

    public void verifyPopUpSuccesPostingAdsAppear()
    {
        Log.info("Verify Pop-Up Success Posting Appear");
    }

    public void verifyContentInPopUpSuccessPosting()
    {
        verifyGunakanFiturTopListingButton();
        verifyTutupPopUpConfirmationButton();
        Log.info("verify Content in Pop-Up Succes Posting");
    }

    public void verifyGunakanFiturTopListingButton()
    {
        Log.info("Verify Gunakan Fitur Top Listing Button");
    }

    public void verifyTutupPopUpConfirmationButton()
    {
        Log.info("Verify Tutup Pop Up Confirmation Button");
    }

    public void clickGunakanFiturTopListingButton()
    {
        Log.info("Click Gunakan Fitur Top Listing Button");
    }

    public void clickTutupPopUpConfirmationButton()
    {
        Log.info("Click Tutup Pop-Up Confirmation Button");
    }
}
