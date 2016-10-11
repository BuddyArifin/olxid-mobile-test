package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
public class PostAdsPage extends BasePage {
    public PostAdsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String closeBtn = "com.app.tokobagus.betterb:id/btnCancel";
    public static final String liveViewFrame = "com.app.tokobagus.betterb:id/cwac_cam2_preview_stack";
    public static final String shutterBtn = "com.app.tokobagus.betterb:id/cwac_cam2_picture";
    public static final String galeriBtn = "com.app.tokobagus.betterb:id/cwac_cam2_gallery";
    public static final String cropBtnAtas = "com.app.tokobagus.betterb:id/btnCrop";
    public static final String rotateBtn = "com.app.tokobagus.betterb:id/btnRotate";
    public static final String takenImagePreview = "com.app.tokobagus.betterb:id/imgPreview";
    public static final String judulIklan = "com.app.tokobagus.betterb:id/edtTitle";
    public static final String ulangBtn = "com.app.tokobagus.betterb:id/btnRetake";
    public static final String simpanBtn = "com.app.tokobagus.betterb:id/btnSave";
    public static final String crop169Btn = "16:9";
    public static final String cropBtnCropMenu = "com.app.tokobagus.betterb:id/menu_crop";
    public static final String closeBtnPFS2 = "Navigate up";
    public static final String jualTitle = "Pasang Iklan";
    public static final String photoAds = "com.app.tokobagus.betterb:id/imgImage";
    public static final String deletePhotoBtn = "com.app.tokobagus.betterb:id/btnDelete";
    public static final String recyclerViewPhoto = "com.app.tokobagus.betterb:id/rvImages";
    public static final String relativeLayoutClass = "android.widget.RelativeLayout";
    public static final String imageInBorder = "com.app.tokobagus.betterb:id/imgImage";
    public static final String judulAds = "com.app.tokobagus.betterb:id/edtTitle";
    public static final String kategoriAds = "com.app.tokobagus.betterb:id/tvCategory";
    public static final String kategoriTitleAds = "com.app.tokobagus.betterb:id/tvCategoryName";
    public static final String lokasiIklan = "com.app.tokobagus.betterb:id/tvLocationTitle";
    public static final String detilTambahanDeskripsi = "com.app.tokobagus.betterb:id/descriptionInformationLayout";
    public static final String deskripsiEditText = "com.app.tokobagus.betterb:id/edtDescription";
    public static final String hargaTextInputLayout = "com.app.tokobagus.betterb:id/priceLayout";
    public static final String hargaBarangEditText = "com.app.tokobagus.betterb:id/edtPrice";
    public static final String minGajiEditText = "com.app.tokobagus.betterb:id/edtMinPrice";
    public static final String maxGajiEditText = "com.app.tokobagus.betterb:id/edtMaxPrice";
    public static final String pemrosesanData = "com.app.tokobagus.betterb:id/cbAgreement";
    public static final String pasangIklanBtn = "com.app.tokobagus.betterb:id/btnPostAd";
    public static final String popUpLayoutSuccessPost = "com.app.tokobagus.betterb:id/successFragmentContainer";
    public static final String gunakanFiturTopListingBtn = "com.app.tokobagus.betterb:id/btnUsePaidFeature";
    public static final String tutupPopUpBtn = "com.app.tokobagus.betterb:id/btnClose";
    public static final String stateScale = "com.app.tokobagus.betterb:id/state_scale";
    public static final String stateAspectRatio = "com.app.tokobagus.betterb:id/state_aspect_ratio";
    public static final String stateAspectRotate = "com.app.tokobagus.betterb:id/state_rotate";
    public static final String layoutAspectRation = "com.app.tokobagus.betterb:id/layout_aspect_ratio";
    public static final String frameLayoutClass = "android.widget.FrameLayout";
    public static final String recycleViewCategory = "com.app.tokobagus.betterb:id/rvCategory";
    public static final String linearLayoutContainer = "com.app.tokobagus.betterb:id/layoutContainer";
    public static final String categoryTitle = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    public static final String iconThumbGallery = "com.android.documentsui:id/icon_thumb";
    public static final String optionGalleryOrCamera = "android:id/content";
    public static final String galeriFotoBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultNeutral";
    public static final String kameraFotoBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public int upperHeigth, bottomHeight, upperHeightRotateAndCrop, bottomHeightRotateAndCrop;

    @AndroidFindBys({
        @AndroidFindBy(className = frameLayoutClass),
        @AndroidFindBy(id = iconThumbGallery)
    })
    protected List<AndroidElement> imageIconGallery;

    @AndroidFindBys({
        @AndroidFindBy(id = recyclerViewPhoto),
        @AndroidFindBy(className = relativeLayoutClass),
        @AndroidFindBy(className = frameLayoutClass),
        @AndroidFindBy(id = imageInBorder)
    })
    protected List<AndroidElement> photoIklanThumb;

    @AndroidFindBys({
        @AndroidFindBy(id = recyclerViewPhoto),
        @AndroidFindBy(className = relativeLayoutClass),
        @AndroidFindBy(className = frameLayoutClass),
        @AndroidFindBy(id = deletePhotoBtn)
    })
    protected List<AndroidElement> deletePhotoThumb;

    @AndroidFindBys({
        @AndroidFindBy(id = layoutAspectRation),
        @AndroidFindBy(className = frameLayoutClass)
    })
    protected List<AndroidElement> controlOptionCrop;

    @AndroidFindBys({
            @AndroidFindBy(id = recycleViewCategory),
            @AndroidFindBy(id = linearLayoutContainer)
    })
    protected List<AndroidElement> categoryElement0;

    @AndroidFindBys({
            @AndroidFindBy(className = relativeLayoutClass),
            @AndroidFindBy(className = relativeLayoutClass),
            @AndroidFindBy(className = relativeLayoutClass),
            @AndroidFindBy(id = recyclerViewPhoto),
            @AndroidFindBy(id = linearLayoutContainer)
    })
    protected List<AndroidElement> categoryElement1;

    @AndroidFindBys({
            @AndroidFindBy(className = relativeLayoutClass),
            @AndroidFindBy(className = relativeLayoutClass),
            @AndroidFindBy(className = relativeLayoutClass),
            @AndroidFindBy(className = relativeLayoutClass),
            @AndroidFindBy(id = recycleViewCategory),
            @AndroidFindBy(id = linearLayoutContainer)
    })
    protected List<AndroidElement> categoryElement2;

    @AndroidFindBys({
            @AndroidFindBy(id = recycleViewCategory),
            @AndroidFindBy(id = categoryTitle)
    })
    protected List<AndroidElement> subCategoryTitle;

    @Step("Verify Content in Camera Page")
    public void verifyContentInCameraPage()
    {
        //verifyCloseBtn();
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
        verifyCloseBtn();
        verifyTakenImagePreview();
        verifyJudulIklan();
        verifyUlangBtn();
        verifySimpanBtn();
        Log.info("Verify Content Additional in Camera Page");
    }

    @Step("Verify Content Additional When Cropping Photo")
    public void verifyContentAdditionalWhenCroppingPhoto()
    {
        verifyBatalBtn();
        verifyCropBtnAccept();
        verifyCropOptionControl();
        verifyStateScaleOption();
        verifyStateAspectRatio();
        verifyStateAspectRotate();
        Log.info("Verify Content Additional When Cropping Photo");
    }

    public void verifyCloseBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(closeBtn)));
        Log.info("Verify Close Button");
    }
    public void verifyLiveViewFrame()
    {
        isWaitElementPresent(getIdLocator(liveViewFrame));
        Assert.assertTrue(isElementPresent(getIdLocator(liveViewFrame)));
        Log.info("Verify Live View Frame");
    }
    public void verifyShutterBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(shutterBtn)));
        Log.info("Verify Shutter Button");
    }
    public void verifyGaleriBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(galeriBtn)));
        Log.info("Verify Gallery Button");
    }
    public void verifyCropBtnAtas()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(cropBtnAtas)));
        Log.info("Verify Crop Button Bagian Atas");
    }
    public void verifyRotateBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(rotateBtn)));
        Log.info("Verify Rotate Button");
    }
    public void verifyTakenImagePreview()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(takenImagePreview)));
        Log.info("Verify Taken Image Preview");
    }
    public void verifyJudulIklan()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(judulIklan)));
        Log.info("Verify Textbox Judul Iklan");
    }
    public void verifyUlangBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(ulangBtn)));
        Log.info("Verify Ulang Button");
    }
    public void verifyBatalBtn()
    {
        Assert.assertTrue(isElementPresent(getContentLocator(closeBtnPFS2)));
        Log.info("Verify Batal Button");
    }
    public void verifySimpanBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(simpanBtn)));
        Log.info("Verify Simpan Button");
    }
    public void verifyCropBtnAccept()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(cropBtnCropMenu)));
        Log.info("Verify Crop Button In Crop Page");
    }
    public void verifyCropOptionControl()
    {
        Assert.assertTrue(isListElementPresent(controlOptionCrop));
        Log.info("Verify Cropping Control Option");
    }
    public void verifyStateScaleOption()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(stateScale)));
        Log.info("Verify State Scale");
    }
    public void verifyStateAspectRatio()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(stateAspectRatio)));
        Log.info("Verify State Aspect Ratio");
    }
    public void verifyStateAspectRotate()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(stateAspectRotate)));
        Log.info("Verify State Aspect Rotate");
    }

    public void getSizeElementsBeforeRotateAndCrop() {
        isWaitElementPresent(getIdLocator(takenImagePreview));
        WebElement activeLayout = driver.findElement(getIdLocator(takenImagePreview));
        upperHeigth = activeLayout.getLocation().getY();
        bottomHeight = activeLayout.getSize().getHeight() + upperHeigth;
        Log.info("Upper Height : " + upperHeigth + " , Bottom Height : " + bottomHeight);
    }

//    public void clickCloseBtn()
//    {
//        clickElement(getIdLocator(closeBtn));
//        Log.info("Click Back Button");
//    }

    public void clickCloseBtnAtas()
    {
        clickElement(getIdLocator(closeBtn));
        Log.info("Click Close Button Top Layer");
    }

    public void clickShutterBtn()
    {
        clickElement(getIdLocator(shutterBtn));
        Log.info("Click Shutter Button");
    }

    public void clickCropBtnAtas()
    {
        clickElement(getIdLocator(cropBtnAtas));
        Log.info("Click Crop Button Bagian Atas");
    }

    public void click169CropControlOption()
    {
        controlOptionCrop.get(4).click();
        Log.info("Click Option Crop 3:4");
    }

    public void clickCropBtnAccept()
    {
        clickElement(getIdLocator(cropBtnCropMenu));
        WebElement activeLayout = driver.findElement(getIdLocator(takenImagePreview));
        upperHeightRotateAndCrop = activeLayout.getLocation().getY();
        bottomHeightRotateAndCrop = activeLayout.getSize().getHeight();
        Log.info("Upper Height : " + upperHeightRotateAndCrop + " , Bottom Height : " + bottomHeightRotateAndCrop);
        Log.info("Click Crop Button Accept in Crop Menu");
    }

    public void verifyImageCropped()
    {
        boolean imageCrop;
        if (upperHeigth < upperHeightRotateAndCrop && bottomHeight > bottomHeightRotateAndCrop)
        {
            imageCrop = true;
            Log.info("Photo Has Been Cropped");
        }
        else
        {
            imageCrop = false;
            Log.info("Photo Not Cropped");
        }
        Assert.assertTrue(imageCrop);
        Log.info("Verify Image Cropped");
    }

    public void clickBatalNavigateUpCrop()
    {
        clickElement(getContentLocator(closeBtnPFS2));
        Log.info("Click Batal Button");
    }

    public ListingPage clickBatalNavigateUp()
    {
        clickElement(getContentLocator(closeBtnPFS2));
        Log.info("Click Batal Button");
        return new ListingPage(driver);
    }

    public void clickRotateBtn()
    {
        WebElement activeLayout = driver.findElement(getIdLocator(takenImagePreview));
        clickElement(getIdLocator(rotateBtn));
        upperHeightRotateAndCrop = activeLayout.getLocation().getY();
        bottomHeightRotateAndCrop = activeLayout.getSize().getHeight();
        Log.info("Upper Height : " + upperHeightRotateAndCrop + " , Bottom Height : " + bottomHeightRotateAndCrop);
        Log.info("Click Rotate Button");
    }

    public void verifyImageRotated()
    {
        boolean imageRotate;
        if (upperHeigth > upperHeightRotateAndCrop && bottomHeight < bottomHeightRotateAndCrop)
        {
            imageRotate = true;
            Log.info("Photo Has Been Rotated");
        }
        else
        {
            imageRotate = false;
            Log.info("Photo Not Rotated");
        }
        Assert.assertTrue(imageRotate);
        Log.info("Verify Image Rotated");
    }

//    public void inputIsiJudulIklanDisini(String keyword)
//    {
//        sendKeysById(getIdLocator(judulIklan), keyword);
//        Log.info("Input Judul Iklan");
//    }

    public void clickUlangBtn()
    {
        clickElement(getIdLocator(ulangBtn));
        Log.info("Click Ulang Button");
    }

//    public void clickBatalBtn()
//    {
//        Log.info("Click Batal Button");
//    }

    public void clickSimpanBtn()
    {
        clickElement(getIdLocator(simpanBtn));
        Log.info("Click Simpan Button");
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
//        verifyHargaOrGajiColumn();
        verifyLokasiIklanColumn();
        verifyDetilTambahanDanDeskripsiColumn();
        verifyPemrosesanDataCheckBoxColumn();
        verifyPasangIklanBtn();
        Log.info("Verify Content in Posting Form");
    }

    public void verifyCloseButtonX()
    {
        Assert.assertTrue(isElementPresent(getContentLocator(closeBtnPFS2)));
        Log.info("Verify Cancel Button Beside Title");
    }
    public void verifyJualTitle()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(jualTitle)));
        Log.info("Verify Jual Title");
    }
    public void verifyPhotoThumbnails()
    {
        Assert.assertTrue(isListElementPresent(photoIklanThumb));
        Log.info("Verify Photo Thumbnails");
    }
    public void verifyPlusPhotoThumbnails()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(imageInBorder)));
        Log.info("Verify Plus Button in Photo Thumbnails Column");
    }
    public void verifyCancelPhotoThumbnails()
    {
        if (photoIklanThumb.size() == 1)
        {
            Assert.assertFalse(isElementPresent(getIdLocator(deletePhotoBtn)));
        }
        else {
            Assert.assertTrue(isElementPresent(getIdLocator(deletePhotoBtn)));
        }
        Log.info("Verify Cancel Button in Photo Thumbnails Column");
    }
    public void verifyJudulColumn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(judulAds)));
        Log.info("Verify Judul Column");
    }
    public void verifyKategoriColumn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(kategoriAds)));
        Log.info("Verify Kategori Column");
    }
//    public void verifyHargaOrGajiColumn()
//    {
//        Log.info("Verify Harga Column");
//    }
    public void verifyLokasiIklanColumn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(lokasiIklan)));
        Log.info("Verify Lokasi Iklan Column");
    }
    public void verifyDetilTambahanDanDeskripsiColumn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(detilTambahanDeskripsi)));
        Log.info("Verify Detil Tambahan dan Deskripsi Column");
    }
    public void verifyPemrosesanDataCheckBoxColumn()
    {
        swipePageBtmtToTop();
        Assert.assertTrue(isElementPresent(getIdLocator(pemrosesanData)));
        Log.info("Verify Pemrosesan Data CheckBox Column");
    }
    public void verifyPasangIklanBtn()
    {
        swipePageBtmtToTop();
        Assert.assertTrue(isElementPresent(getIdLocator(pasangIklanBtn)));
        Log.info("Verify Pasang Iklan Button");
    }

    public void clickPlusAdditionalPhotos() {
        swipePageTopToBtm();

        Log.info("Photo Thumb Size : "+ photoIklanThumb.size());
        photoIklanThumb.get(1).click();
//        for (int i = 0; i < photoIklanThumb.size(); i++)
//        {
//            if (!deletePhotoThumb.get(i).isDisplayed())
//            {
//                photoIklanThumb.get(i).click();
//                break;
//            }
//        }
//        clickElement(getIdLocator(plusPhotoBtn));
        Log.info("Click Plus Additional Photos in Thumbnails");
    }

    public void verifyOptionAlert()
    {
        verifyOptioGalleryOrCameraPopUp();
        verifyGalleryBtnOption();
        verifyCameraBtnOption();
        Log.info("Verify Option Alert Gallery Or Camera");
    }
    public void verifyOptioGalleryOrCameraPopUp()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(optionGalleryOrCamera)));
        Log.info("Verify Option Gallery or Camera Pop-Up");
    }
    public void verifyGalleryBtnOption()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(galeriFotoBtn)));
        Log.info("Verify Gallery Button Option");
    }
    public void verifyCameraBtnOption()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(kameraFotoBtn)));
        Log.info("Verify Camera Button Option");
    }

    public void clickCloseButtonXPhotoThumb()
    {
        clickElement(getIdLocator(deletePhotoBtn));
        Log.info("Click Close Button X Beside Jual Title");
    }

    public void clickGaleriFotoBtn()
    {
        clickElement(getIdLocator(galeriFotoBtn));
        Log.info("Click Galeri Button");
    }

    public void clickYaPositiveBtn()
    {
        clickElement(getIdLocator(kameraFotoBtn));
        Log.info("Klik Ya Yakin Untuk Menghapus");
    }

    public void clickOneOfPictureGallery()
    {
        imageIconGallery.get(0).click();
        Log.info("Click One Image Gallery");
    }

    public void clickGalleryOrCamera()
    {
        Log.info("Click Gallery or Camera To Add Photo");
    }

    public void clickCancelAdditionalPhotos()
    {
        Log.info("Click Cancel Additional Photos in Thumbnails");
    }

    public void inputJudulAds(String keyword)
    {
        List<WebElement> judulIklanAds = driver.findElements(getIdLocator(judulAds));
        if (judulIklanAds.get(0).getText().length() == 0)
        {
            sendKeysById(getIdLocator(judulAds), keyword);
            Log.info("Input Judul Ads : "+ keyword);
        }
        else
        {
            Log.info("Judul Ads Has Been Inputted With Text : " + judulIklanAds.get(0).getText());
        }
    }

    public void clickKategoriAds()
    {
        List<WebElement> kategoriValueAds = driver.findElements(getIdLocator(kategoriTitleAds));
        if (kategoriValueAds.get(0).getText().equalsIgnoreCase("Pilih kategori"))
        {
            clickElement(getIdLocator(kategoriTitleAds));

        }
        Log.info("Click Kategori Ads");
    }

    public void verifySuggestionKategori()
    {
        Boolean suggestionKategori;
        List<WebElement> kategoriValueAds = driver.findElements(getIdLocator(kategoriTitleAds));
        if (!kategoriValueAds.get(0).getText().equalsIgnoreCase("Pilih kategori"))
        {
            suggestionKategori = true;
            Log.info("Suggestion Kategori Displayed : " + kategoriValueAds.get(0).getText());
        }
        else
        {
            suggestionKategori = false;
            Log.info("Suggestion Kategori Not Displayed");
        }
        Assert.assertTrue(suggestionKategori);
        Log.info("Verify Suggestion Kategori");
    }

    public void verifySuggestionHarga()
    {
        Boolean suggestionHarga;
        List<WebElement> hargaValueAds = driver.findElements(getIdLocator(hargaTextInputLayout));
        if (hargaValueAds.get(0).getText().contains("Price "))
        {
            suggestionHarga = true;
            Log.info("Suggestion Harga Displayed : " + hargaValueAds.get(0).getText());
        }
        else
        {
            suggestionHarga = false;
            Log.info("Suggestion Harga Not Displayed");
        }
        Assert.assertTrue(suggestionHarga);
        Log.info("Verify Suggestion Harga");
    }

    public void inputHarga(String keyword)
    {
        sendKeysById(getIdLocator(hargaBarangEditText), keyword);
        Log.info("Input Harga or Gaji Ads");
    }

    public void verifyAdditionalInputFieldJasaDanLowonganCategory()
    {
        verifyHargaChangeToGaji();
        verifyAdditionalFieldGajiMinimal();
        verifyAdditionalFieldGajiMaksimal();
        Log.info("Verify Additional Input Field in Jasa Dan Lowongan Category");
    }

    public void verifyListElementMethodAndClickElement(String layoutClass, List<AndroidElement> parentElements, List<AndroidElement> childElements, String comparisonWord)
    {
        isWaitElementPresent(getIdLocator(layoutClass));
        String elementValueText = "";
        Log.info("Category Available ["+parentElements.size()+"]: ");
        for (int i = 0 ; i < parentElements.size() ; i++) {
            elementValueText = childElements.get(i).getText();
            if (parentElements.size() >= 2 && elementValueText.equalsIgnoreCase(comparisonWord)) {
                parentElements.get(i).click();
                Log.info("Click Element Index : " + i + ", ValueText : " + elementValueText);
                break;
            }
        }
    }

    public void clickMobilBekasHondaCategory()
    {
        String mobil = "Mobil";
        String mobilBekas = "Mobil Bekas";
        String audi = "Audi";
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, mobil);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, mobilBekas);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement2, subCategoryTitle, audi);
        Log.info("Click Mobil Bekas Honda Sub-Category");
    }

    public void clickPropertiRumahDijualCategory()
    {
        String properti = "Properti";
        String rumah = "Rumah";
        String dijual = "Dijual";
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, properti);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, rumah);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement2, subCategoryTitle, dijual);
        Log.info("Click Properti Rumah Di Jual Sub-Category");
    }

    public void verifyHargaChangeToGaji()
    {
        Assert.assertFalse(isElementPresent(getIdLocator(hargaBarangEditText)));
        Log.info("Verify Harga Change To Gaji As User Choose Jasa & Lowongan Kategori");
    }
    public void verifyAdditionalFieldGajiMinimal()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(minGajiEditText)));
        Log.info("Verify Additional Input Field Gaji Dari Rupiah");
    }
    public void verifyAdditionalFieldGajiMaksimal()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(maxGajiEditText)));
        Log.info("Verify Additional Input Field Gaji Hingga Rupiah");
    }

    public void verifyAdditionalInputFieldPropertiCategory()
    {
        verifyAdditionalInputFieldLuasTanah();
        verifyAdditionalInputFieldLuasBangunan();
        verifyAdditionalInputFieldSertifikat();
        verifyAdditionalInputFieldFasilitas();
        Log.info("Verify Additional Input Field in Properti Category");
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

    public void verifyAdditionalInputMobilDanMotorCategory()
    {
        verifyAdditionalInputFieldTipeKendaraan();
        verifyAdditionalInputFieldTransmisi();
        verifyAdditionalInputFieldTahun();
        Log.info("Verify Additional Input Field in Mobil dan Motor Category");
    }

    public void verifyAdditionalInputFieldTipeKendaraan()
    {
        Log.info("Verify Additional Input Field Tipe Kendaraan");
    }
    public void verifyAdditionalInputFieldTransmisi()
    {
        Log.info("Verify Additional Input Field Transmisi");
    }
    public void verifyAdditionalInputFieldTahun()
    {
        Log.info("Verify Additional Input Field Tahun");
    }

    public void clickDetilTambahDanDeskripsi()
    {
        clickElement(getIdLocator(detilTambahanDeskripsi));
        Log.info("Click Detil Tambahan dan Deskripsi");
    }

    public void inputDetilTambahanDanDeskripsi(String inputText)
    {
        String[] listString = inputText.split("");
//        List<String> listString = new ArrayList<String>(Arrays.asList(inputText.split("")));
        for(int i = 0; i < 4096; i++)
        {
            String splitan = listString[i]+" ";
            sendKeysById(getIdLocator(deskripsiEditText), splitan.charAt(i));
            if (i % 4 == 0) {
                splitan += splitan;
            }
        }
        sendKeysById(getIdLocator(deskripsiEditText), inputText);
//        sen
        Log.info("Input Detil Tambahan dan Deskripsi");
    }

    public void verifyNoLimitCharacterDescription()
    {
        Log.info("Verify No Limit Character Description");
    }

    public void clickCheckBoxPemrosesanData()
    {
        clickElement(getIdLocator(pemrosesanData));
        Log.info("Click CheckBox Pemrosesan Data");
    }

    public void clickPasangIklanButton()
    {
        clickElement(getIdLocator(pasangIklanBtn));
        Log.info("Click Pasang Iklan Button");
    }

    public void verifyContentInPopUpSuccessPosting()
    {
        verifyPopUpSuccesPostingAdsAppear();
        verifyGunakanFiturTopListingButton();
        verifyTutupPopUpConfirmationButton();
        Log.info("verify Content in Pop-Up Succes Posting");
    }

    public void verifyPopUpSuccesPostingAdsAppear()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(popUpLayoutSuccessPost)));
        Log.info("Verify Pop-Up Success Posting Appear");
    }

    public void verifyGunakanFiturTopListingButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(gunakanFiturTopListingBtn)));
        Log.info("Verify Gunakan Fitur Top Listing Button");
    }

    public void verifyTutupPopUpConfirmationButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(tutupPopUpBtn)));
        Log.info("Verify Tutup Pop Up Confirmation Button");
    }

    public void clickGunakanFiturTopListingButton()
    {
        clickElement(getIdLocator(gunakanFiturTopListingBtn));
        Log.info("Click Gunakan Fitur Top Listing Button");
    }

    public void clickTutupPopUpConfirmationButton()
    {
        clickElement(getIdLocator(tutupPopUpBtn));
        Log.info("Click Tutup Pop-Up Confirmation Button");
    }
}
