package pages;

import com.google.common.base.Function;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import module.PaidFeatureModule;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
public class PostAdsPage extends BasePage {
    public static final String textFieldAdditionalId = "com.app.tokobagus.betterb:id/edtInput";
    public static final String textTitleAdditionalId = "com.app.tokobagus.betterb:id/inputLayout";

    public PostAdsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String closeBtn = "com.app.tokobagus.betterb:id/btnCancel";
    public static final String liveViewFrame = "com.app.tokobagus.betterb:id/cwac_cam2_preview_stack";
    public static final String shutterBtn = "com.app.tokobagus.betterb:id/takeShot";
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
    public static final String lokasiIklanBtn = "com.app.tokobagus.betterb:id/tvPlaceName";
    public static final String detilTambahanDeskripsi = "com.app.tokobagus.betterb:id/descriptionInformationLayout";
    public static final String toggleDescription = "com.app.tokobagus.betterb:id/imgToggleUpDown";
    public static final String deskripsiEditText = "com.app.tokobagus.betterb:id/edtDescription";
    public static final String hargaTextInputLayout = "com.app.tokobagus.betterb:id/priceLayout";
    public static final String suggestedPriceField = "com.app.tokobagus.betterb:id/tvOptionalMessage";
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
    public static final String recycleViewCategoryInputField = "com.app.tokobagus.betterb:id/md_contentRecyclerView";
    public static final String inputCategoryTitleID = "com.app.tokobagus.betterb:id/tvOptionName";
    public static final String linearLayoutInputField = "com.app.tokobagus.betterb:id/mandatoryCategoryParamsLayout";
    public static final String dropDownInputFieldTitle = "com.app.tokobagus.betterb:id/tvTitle";
    public static final String dropDownInputField = "com.app.tokobagus.betterb:id/btnSelection";
    public static final String linearLayoutContainer = "com.app.tokobagus.betterb:id/layoutContainer";
    public static final String categoryTitle = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    public static final String iconThumbGallery = "com.android.documentsui:id/icon_thumb";
    public static final String optionGalleryOrCamera = "android:id/content";
    public static final String descriptionLayout = "com.app.tokobagus.betterb:id/descriptionLayout";
    public static final String linearLayoutClass = "android.widget.LinearLayout";
    public static final String textViewClass = "android.widget.TextView";
    public static final String textInputLayoutClass = "TextInputLayout";
    public static final String editTextAdditionalField = "android.widget.EditText";
    public static final String galeriFotoBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultNeutral";
    public static final String kameraFotoBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public static final String galleryIcon = "com.app.tokobagus.betterb:id/btnGallery";
    public static final String cameraIconId = "com.app.tokobagus.betterb:id/btnCamera";
    public String suggestedHarga = "";
    public boolean suggestionHarga;
    public boolean customCamera = true;
    public boolean isOldVersionDevices = false;
    public int upperHeigth, bottomHeight, upperHeightRotateAndCrop, bottomHeightRotateAndCrop;
    public boolean suggestionKategori;
    public String suggestedHarga2 = "";
    public String mobil = "mobil";
    public String rumah = "rumah";
    public String lowongan = "karyawan";
    public static final String loginPopupNotif = "com.app.tokobagus.betterb:id/md_content";
    public static final String loginBtnInLoginPopup = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";

    @AndroidFindBys({
            @AndroidFindBy(className = textInputLayoutClass)
    })
    protected List<AndroidElement> inputList;

    @AndroidFindBys({
            @AndroidFindBy(id = "com.app.tokobagus.betterb:id/inputLayout"),
            @AndroidFindBy(id = "com.app.tokobagus.betterb:id/edtInput")
    })
    protected List<AndroidElement> editInputList;

    @AndroidFindBys({
            @AndroidFindBy(id = linearLayoutInputField),
            @AndroidFindBy(className = textInputLayoutClass)
    })
    protected List<AndroidElement> additionaInputField;

    @AndroidFindBys({
            @AndroidFindBy(id = "com.app.tokobagus.betterb:id/inputLayout"),
            @AndroidFindBy(className = editTextAdditionalField)
    })
    protected List<AndroidElement> editInputListOldVersion;

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
            @AndroidFindBy(id = recycleViewCategory),
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

    @AndroidFindBys({
        @AndroidFindBy(id = descriptionLayout),
        @AndroidFindBy(className = linearLayoutClass),
        @AndroidFindBy(className = textViewClass)
    })
    protected List<AndroidElement> textViewCharacter;

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewCategoryInputField),
        @AndroidFindBy(className = linearLayoutClass)
    })
    protected List<AndroidElement> inputCategory;

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewCategoryInputField),
        @AndroidFindBy(id = inputCategoryTitleID)
    })
    protected List<AndroidElement> inputCategoryTitle;

    @AndroidFindBys({
            @AndroidFindBy(id = linearLayoutInputField),
            @AndroidFindBy(className = linearLayoutClass),
            @AndroidFindBy(className = linearLayoutClass),
            @AndroidFindBy(id = dropDownInputField)
    })
    protected List<AndroidElement> dropDownListElement;

    @AndroidFindBys({
            @AndroidFindBy(id = linearLayoutInputField),
            @AndroidFindBy(className = linearLayoutClass),
            @AndroidFindBy(className = linearLayoutClass),
            @AndroidFindBy(id = dropDownInputFieldTitle)
    })
    protected List<AndroidElement> textViewDropDownTitle;

    @AndroidFindBys({
            @AndroidFindBy(id = recycleViewCategoryInputField),
            @AndroidFindBy(id = inputCategoryTitleID)
    })
    protected List<AndroidElement> textViewCheckBoxTitle;

    public void initialPostAdsTest(){
        Log.info("Back to Initial Post Ads Test");
        ListingPage listingPage = new ListingPage(driver);
        PaidFeatureModule paidFeature = new PaidFeatureModule(driver);
        if (listingPage.isListingButton()){
            Assert.assertTrue(true,"Already in Home");
        } else{
            if (isPostAdsPage()){
                clickElement(getContentLocator(closeBtnPFS2));
            } else if(isCameraPage()){
                clickBackDevice();
                waitForClickabilityOf(getContentLocator(closeBtnPFS2));
                clickElement(getContentLocator(closeBtnPFS2));
            } else if(isCameraAdditionalPage()){
                clickCloseBtnAtas();
                waitForClickabilityOf(getContentLocator(closeBtnPFS2));
                clickElement(getContentLocator(closeBtnPFS2));
            } else if (isElementPresent(getIdLocator(popUpLayoutSuccessPost))) {
                paidFeature.clickBatalOnTopListing();
            } else if (isCurrentPageonMaps()) {
                Maps maps = new Maps(driver);
                maps.clickBackButtonFromMaps();
            } else {
                Assert.assertTrue(true,"Already in Home");
            }
        }
    }

    public boolean isPostAdsPage(){
        return isElementPresent(getTextLocator(jualTitle));
    }

    public boolean isCameraPage(){
        return isElementPresent(getIdLocator(shutterBtn));
    }

    public boolean isCameraAdditionalPage(){
        return isElementPresent(getIdLocator(cropBtnAtas));
    }

    public boolean isCurrentPageonMaps() {
        return isElementPresent(getIdLocator(FilterByMapsLocationModule.cobaKembaliBtnMaps))
                || isElementPresent(getIdLocator(Maps.myCurrentLocationBtn));
    }

    @Step("Verify Content in Camera Page")
    public void verifyContentInCameraPage()
    {
        customCamera = true;
//        verifyCloseBtn();
//        dismissTutorial();
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
    public void verifyShutterBtn()
    {
        waitForClickabilityOf(getIdLocator(shutterBtn));
        Assert.assertTrue(isElementPresent(getIdLocator(shutterBtn)));
        Log.info("Verify Shutter Button");
    }
    public void verifyGaleriBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(galleryIcon)));
        Log.info("Verify Gallery Button");
    }
    public void verifyCropBtnAtas()
    {
        waitForClickabilityOf(getIdLocator(cropBtnAtas));
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
        Assert.assertTrue(isWaitElementPresent(getContentLocator(closeBtnPFS2)));
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
        bottomHeight = upperHeigth - activeLayout.getSize().getHeight();
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
        bottomHeightRotateAndCrop = upperHeightRotateAndCrop - activeLayout.getSize().getHeight();
        Log.info("Upper Height : " + upperHeightRotateAndCrop + " , Bottom Height : " + bottomHeightRotateAndCrop);
        Log.info("Click Crop Button Accept in Crop Menu");
    }

    public void verifyImageCropped()
    {
        boolean imageCrop;
        //Log.info("A : "+upperHeigth+" ; B : "+upperHeightRotateAndCrop+" ; C : "+bottomHeight+" ; D : "+bottomHeightRotateAndCrop);
        if (upperHeigth < upperHeightRotateAndCrop && bottomHeight < bottomHeightRotateAndCrop)
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
        bottomHeightRotateAndCrop = upperHeightRotateAndCrop - activeLayout.getSize().getHeight();
        Log.info("Upper Height : " + upperHeightRotateAndCrop + " , Bottom Height : " + bottomHeightRotateAndCrop);
        Log.info("Click Rotate Button");
    }

    public void verifyImageRotated()
    {
        boolean imageRotate;
        if (upperHeigth < upperHeightRotateAndCrop && bottomHeight < bottomHeightRotateAndCrop)
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

//    public void verifyAllContentInDefaultCamera()
//    {
//        verifyLiveViewFrameDefaultCamera();
//        verifyShutterDefaultCamera();
//        verifyCancelDefaultCamera();
//        verifyEffectButtonDefaultCamera();
//        Log.info("Verify All Content in Default Camera Page");
//    }
//
//    public void verifyShutterDefaultCamera()
//    {
//        Assert.assertTrue(isElementPresent(getIdLocator(shutterBtnDefaultCamera)));
//        Log.info("Verify Shutter Button Default Camera");
//    }
//
//    public void verifyCancelDefaultCamera()
//    {
//        Assert.assertTrue(isElementPresent(getIdLocator(cancelBtnDefaultCamera)));
//        Log.info("Verify Cancel Button Default Camera");
//    }
//
//    public void verifyEffectButtonDefaultCamera()
//    {
//        Assert.assertTrue(isElementPresent(getIdLocator(effectBtnDefaultCamera)));
//        Log.info("Verify Effect Button Default Camera");
//    }
//
//    public void verifyLiveViewFrameDefaultCamera()
//    {
//        Assert.assertTrue(isElementPresent(getIdLocator(liveViewFrameDefaultCamera)));
//        Log.info("Verify Live View Default Camera");
//    }
//
//    public void verifyAcceptBtnDefaultCamera()
//    {
//        Assert.assertTrue(isElementPresent(getIdLocator(acceptBtnDefaultCamera)));
//        Log.info("Verify Accept Button Default Camera");
//    }
//
//    public void verifyRetakeBtnDefaultCamera()
//    {
//        Assert.assertTrue(isElementPresent(getIdLocator(retakeBtnDefaultCamera)));
//        Log.info("Verify Retake Button Default Camera");
//    }
//
//    public void verifyAdditionalContentInDefaultCamera()
//    {
//        verifyLiveViewFrameDefaultCamera();
//        verifyAcceptBtnDefaultCamera();
//        verifyCancelDefaultCamera();
//        verifyRetakeBtnDefaultCamera();
//        Log.info("Verify Additional Content In Default Camera");
//    }
//
//    public void clickShutterBtnDefaultCamera()
//    {
//        clickElement(getIdLocator(shutterBtnDefaultCamera));
//        Log.info("Click Shutter Button Default Camera");
//    }
//
//    public void clickRetakeBtnDefaultCamera()
//    {
//        clickElement(getIdLocator(retakeBtnDefaultCamera));
//        Log.info("Click Retake Button Default Camera");
//    }
//
//    public void clickAcceptBtnDefaultCamera()
//    {
//        clickElement(getIdLocator(acceptBtnDefaultCamera));
//        Log.info("Click Accept Button Default Camera");
//    }

    public void verifyContentPostingForm()
    {
        customCamera = false;
        verifyCloseButtonX();
        verifyJualTitle();
        verifyPhotoThumbnails();
        verifyPlusPhotoThumbnails();
        verifyCancelPhotoThumbnails();
        verifyJudulColumn();
        verifyKategoriColumn();
        verifyLokasiIklanColumn();
        verifyDetilTambahanDanDeskripsiColumn();
        verifyPasangIklanBtn();
        Log.info("Verify Content in Posting Form");
    }

    public void verifyCloseButtonX()
    {
        isWaitElementPresent(getContentLocator(closeBtnPFS2));
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
        swipePageBtmtToTop();
        Assert.assertTrue(isElementPresent(getIdLocator(detilTambahanDeskripsi)));
        Log.info("Verify Detil Tambahan dan Deskripsi Column");
    }

    public void verifyPasangIklanBtn()
    {
        swipePageBtmtToTop();
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(pasangIklanBtn)));
        Log.info("Verify Pasang Iklan Button");
    }

    public void clickPlusAdditionalPhotos() {
        swipePageTopToBtm();

        Log.info("Photo Thumb Size : "+ photoIklanThumb.size());
        photoIklanThumb.get(photoIklanThumb.size()-1).click();
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

    public Maps clickCariLokasiBtn()
    {
        clickElement(getIdLocator(lokasiIklanBtn));
        Log.info("Click Cari Lokasi Button");
        return new Maps(driver);
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
        isWaitElementPresent(getIdLocator(optionGalleryOrCamera));
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

    public void clickYaPositiveOrCameraBtn()
    {
        isWaitElementPresent(getIdLocator(kameraFotoBtn));
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
        WebElement element = driver.findElement(getIdLocator(judulAds));
        if (element.getText().length() == 0)
        {
            sendKeysById(getIdLocator(judulAds), keyword);
            Log.info("Input Judul Ads : "+ keyword);
        }
        else
        {
            Log.info("Judul Ads Has Been Inputted With Text : " + element.getText());//judulIklanAds.get(0).getText());
        }
    }

    public void clickKategoriAds()
    {
        List<WebElement> kategoriValueAds = driver.findElements(getIdLocator(kategoriTitleAds));
        //WebElement el = driver.findElement(getIdLocator(kategoriTitleAds));
        if (suggestionKategori)
        {
            Log.info("Suggestion Kategori Displayed : " + kategoriValueAds.get(0).getText());
        }
        else
        {
            //kategoriValueAds.get(0).click();
            clickElement(getIdLocator(kategoriTitleAds));

            String text = driver.findElement(getIdLocator(judulAds)).getText().toLowerCase();
            if(text.contains(mobil)){
                clickMobilBekasAudiCategory();
            }else if(text.contains(rumah)){
                clickPropertiRumahDijualCategory();
            }else if(text.contains(lowongan)){
                clickJasaLowonganAdministrasi();
            }

            //clickElement(getIdLocator(kategoriTitleAds));
        }
        Log.info("Click Kategori Ads");
    }

    public void verifySuggestionKategori()
    {
        String kategoriValue = driver.findElement(getIdLocator(kategoriTitleAds)).getText();
        if(!kategoriValue.contains("Pilih kategori")){
            suggestionKategori = true;
            Log.info("Suggestion Kategori Displayed : " + kategoriValue);
            Assert.assertTrue(suggestionKategori);
        }else {
            suggestionKategori = false;
            Log.info("Suggestion Kategori Not Displayed");
            Assert.assertFalse(suggestionKategori);
        }
        Log.info("Verify Suggestion Kategori");
    }

    public void verifySuggestionHargaAndInputHarga(String keyword)
    {
        if (isWaitElementPresent(getIdLocator(suggestedPriceField)))//element.getText().contains("Price "))
        {
            WebElement element = driver.findElement(getIdLocator(suggestedPriceField));
            WebElement element1 = driver.findElement(By.id(hargaBarangEditText));
            suggestionHarga = true;
            suggestedHarga = element.getText();//hargaValueAds.get(0).getText();
            Log.info("Suggestion Harga Displayed : " + element.getText());
            /*suggestedHarga = suggestedHarga.replaceAll("[a-zA-Q]|[()]|\\s|[.]","");
            String[] hargaPertengahan = suggestedHarga.split("R");
            BigInteger minPrice = new BigInteger(hargaPertengahan[1]);
            BigInteger maxPrice = new BigInteger(hargaPertengahan[2]);*/
            suggestedHarga = suggestedHarga.replaceAll("[a-z]|[()]|\\s|[.]","");
            suggestedHarga2 = suggestedHarga.replaceAll("[a-zA-Z]"," ");
            if(suggestedHarga2.contains("$") || suggestedHarga2.contains("€")){
                suggestedHarga2 = suggestedHarga2.replaceAll("[€]|[$]"," ");
            }
            String[] hargaPertengahan = suggestedHarga2.split(" ");
            BigInteger minPrice = new BigInteger(hargaPertengahan[2]);
            BigInteger maxPrice = new BigInteger(hargaPertengahan[3]);
            BigInteger averagePrice = minPrice.add(maxPrice);
            BigInteger dividedTwo = new BigInteger("2");
            averagePrice = averagePrice.divide(dividedTwo);
            String inputPrice = String.valueOf(averagePrice);
            element1.sendKeys(inputPrice);
            hideSoftKeyboard();
            Log.info("Input Harga or Gaji Ads : "+ averagePrice);
            Assert.assertTrue(suggestionHarga);
        }
        else
        {
            suggestionHarga = false;
            Log.info("Suggestion Harga Not Displayed");
            sendKeysById(getIdLocator(hargaBarangEditText), keyword);
            Log.info("Input Harga or Gaji Ads : "+ keyword);
            Assert.assertFalse(suggestionHarga);
        }
        Log.info("Verify Suggestion and Input Harga");
    }

    public void verifyListElementMethodAndClickElement(String layoutClass, List<AndroidElement> parentElements, List<AndroidElement> childElements, String comparisonWord)
    {
        isWaitElementPresent(getIdLocator(layoutClass));
        isListElementPresent(childElements);
        String elementValueText = "";
        Log.info("Category Available ["+parentElements.size()+"]: "+parentElements.get(0).getText() + " "+ childElements.get(0).getText());
        for (int i = 0 ; i < parentElements.size() ; i++) {
            elementValueText = childElements.get(i).getText();
            if (parentElements.size() >= 2 && elementValueText.equalsIgnoreCase(comparisonWord)) {
                parentElements.get(i).click();
                Log.info("Click Element Index : " + i + ", ValueText : " + elementValueText);
                break;
            }
        }
    }

    public void clickMobilBekasAudiCategory()
    {
        String mobil = "Mobil";
        String mobilBekas = "Mobil Bekas";
        String audi = "Audi";
        String classElement = driver.findElement(By.id("com.app.tokobagus.betterb:id/titleLayout")).getAttribute("className");
        if (classElement.equalsIgnoreCase("TextInputLayout") || suggestionKategori)
        {
            Log.info(classElement);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, mobil);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, mobilBekas);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement2, subCategoryTitle, audi);
        }
        else
        {
            Log.info(classElement);
            verifySuggestionKategori();
        }

        Log.info("Click Mobil Bekas Audi Sub-Category");
    }

    public void clickPropertiRumahDijualCategory()
    {
        String properti = "Properti";
        String rumah = "Rumah";
        String dijual = "Dijual";
        String classElement = driver.findElement(By.id("com.app.tokobagus.betterb:id/titleLayout")).getAttribute("className");
        if (classElement.equalsIgnoreCase("TextInputLayout")) {
            Log.info(classElement);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, properti);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, rumah);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement2, subCategoryTitle, dijual);
        }
        else if (classElement.equalsIgnoreCase("android.widget.LinearLayout"))
        {
            Log.info(classElement);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, properti);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, rumah);
            verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement2, subCategoryTitle, dijual);
            verifySuggestionKategori();
        }
        Log.info("Click Properti Rumah Di Jual Sub-Category");
    }

    public void clickJasaLowonganAdministrasi()
    {
        String jasaLowonganKerja = "Jasa & Lowongan Kerja";
        String lowongan = "Lowongan";
        String administrasi = "Administrasi";
        String classElement = driver.findElement(By.id("com.app.tokobagus.betterb:id/titleLayout")).getAttribute("className");
        //if (classElement.equalsIgnoreCase("TextInputLayout")) {
        if(classElement.contains("LinearLayout")){
            swipePageBtmtToTop();
            //((AndroidDriver) driver).scrollToExact(jasaLowonganKerja);
            clickElement(getTextLocator(jasaLowonganKerja));
            clickElement(getTextLocator(lowongan));
            clickElement(getTextLocator(administrasi));
        }else {
            Log.info(classElement);
            verifySuggestionKategori();
        }
    }

    public void verifyHargaChangeToGaji()
    {
        Assert.assertFalse(isElementPresent(getIdLocator(hargaBarangEditText)));
        Log.info("Verify Harga Change To Gaji As User Choose Jasa & Lowongan Kategori");
    }

    public void verifyAdditionalInputFieldJasaLowonganCategory()
    {
        verifyAdditionalFieldGajiMinimal();
        verifyAdditionalFieldGajiMaksimal();
        Log.info("Verify Additional Input Field in Jasa & Lowongan Category");
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
        isListElementPresent(additionaInputField);
        Log.info("Verify Additional Input Field in Properti Category");
    }

    //handle old version of Android [need to destroy]
    public List<WebElement> isTextInputLayoutDisplays() {
        if (getVersionDevices().startsWith("6")){
            return getListElements(By.className("TextInputLayout"));
        } else {
            return getListElements(By.id("com.app.tokobagus.betterb:id/inputLayout"));
        }
    }

    //handle old version of Android
    public List<AndroidElement> isTextEditLayoutDisplays() {
        if (getVersionDevices().startsWith("6")){
            return editInputList;
        } else {
            return editInputListOldVersion;
        }
    }

    /**
     * Adopt method from BasePage
     * */
    public Boolean isElementPresentAfterScroll(final String locator) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(30, TimeUnit.SECONDS)
                    .pollingEvery(5, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            return wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    ((AndroidDriver)driver).swipe(200, 300, 200, 45, 500);
                    return driver.findElement(By.id(textTitleAdditionalId)).isDisplayed();
                }
            });
        } catch ( TimeoutException e){
            return false;
        }
    }

    public void inputMethod(String comparisonWord, String inputText) {
        List<WebElement> parentElement = getListElements(By.id(textTitleAdditionalId));
        String parentValueText = "";
        for (int i = 0; i < parentElement.size(); i++)
        {
            parentValueText = parentElement.get(i).getText();
            Log.info("Parent Element Index : ["+i+"], Value Text : " + parentValueText);
            if (parentValueText.equalsIgnoreCase(comparisonWord)) {
                parentElement.get(i).findElements(getIdLocator(textFieldAdditionalId))
                        .get(0).sendKeys(inputText);
                hideSoftKeyboard();
                break;
            }
            Log.info("This is Index from EditInput "+ parentValueText + " = " + i);
        }
        Log.info("Input " + parentValueText + " : " + inputText);
    }

    public void inputAdditionalFieldLuasTanah(String keyword)
    {
        String luasTanah = "Luas tanah *";
        //isElementPresentAfterScroll(luasTanah);
        isElementPresentAfterScrollDown(getTextLocator(luasTanah));
        inputMethod(luasTanah, keyword);
    }

    public void inputAdditionalFieldKondisi()
    {
        swipePageBtmtToTop();
        //String kondisi = "kondisi *";
        String kondisiBekas = "Bekas";
        clickElement(getIdLocator(dropDownInputField));
        //verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, kondisi);
        verifyListElementMethodAndClickElement(recycleViewCategoryInputField, inputCategory, inputCategoryTitle, kondisiBekas);
    }

    public void inputAdditionalFieldLuasBangunan(String keyword)
    {
        swipePageBtmtToTop();
        String luasBangunan = "Luas bangunan *";
//        isElementPresentAfterScroll(luasBangunan);
        inputMethod(luasBangunan, keyword);
    }

    public void inputAdditionalFieldLantai(String keyword)
    {
        String lantai = "Lantai";
        isElementPresentAfterScroll(lantai);
        inputMethod(lantai, keyword);
    }

    public void inputAdditionalFieldAlamatLokasi(String keyword)
    {
        String alamatLokasi = "Alamat lokasi";
        isElementPresentAfterScroll(alamatLokasi);
        inputMethod(alamatLokasi, keyword);
    }

    public void inputAdditionalInputFieldTKamarTidur()
    {
        String kamarTidur = "Kamar tidur";
        isElementPresentAfterScroll(kamarTidur);
        String duaKamarTidur = "2";
        verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, kamarTidur);
        verifyListElementMethodAndClickElement(recycleViewCategoryInputField, inputCategory, inputCategoryTitle, duaKamarTidur);
    }

    public void inputAdditionalInputFieldTKamarMandi()
    {
        String kamarMandi = "Kamar mandi";
        isElementPresentAfterScroll(kamarMandi);
        String duaKamarMandi = "2";
        verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, kamarMandi);
        verifyListElementMethodAndClickElement(recycleViewCategoryInputField, inputCategory, inputCategoryTitle, duaKamarMandi);
    }

    public void inputAdditionalInputFieldTSertifikasi()
    {
        String sertifikasi = "Sertifikasi";
        isElementPresentAfterScroll(sertifikasi);
        String sertifikasiHakMilik = "SHM - Sertifikat Hak Milik";
        verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, sertifikasi);
        verifyListElementMethodAndClickElement(recycleViewCategoryInputField, inputCategory, inputCategoryTitle, sertifikasiHakMilik);
    }

    public void inputAdditionalInputFieldTFasilitas(String inputText)
    {
        String fasilitas = "Fasilitas";
        isElementPresentAfterScroll(fasilitas);
        verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, fasilitas);
        clickCheckBoxElement(inputText,recycleViewCategoryInputField,textViewCheckBoxTitle);
        clickElement(getIdLocator(kameraFotoBtn));
    }

    public void swipeActiveLayoutBtmToTop(String activeLayoutId)
    {
        WebElement activeLayout = driver.findElement(getIdLocator(activeLayoutId));
        int upperHeight = activeLayout.getLocation().getY();
        int middleHeight = activeLayout.getSize().getHeight() / 2;
        int bottomHeight = activeLayout.getSize().getHeight() - upperHeight;
        int leftWidth = activeLayout.getLocation().getX();
        int middleWidth = activeLayout.getSize().getWidth() / 2;
        int rightWidth = activeLayout.getSize().getWidth();
        ((AndroidDriver)driver).swipe(middleWidth, bottomHeight, middleWidth, upperHeight, 500);
    }

    /**
     * This below method has made that can click several selection checkbox with several selection inputText
     * the method can scroll automatically if needed
     */
    public void clickCheckBoxElement(String inputText, String activeLayoutId, List<AndroidElement> childElement)
    {
        List<String> listString = new ArrayList<String>(Arrays.asList(inputText.split("/")));
        Collections.sort(listString);
        String parentElementValue = "";
        String splitTextPart = "";
        for(int i = 0; i < childElement.size(); i++)
        {
            parentElementValue = childElement.get(i).getText();
            if(listString.size() == 0)
            {
                break;
            }
            else
            {
                for(int j = 0; j < listString.size(); j++)
                {
                    splitTextPart = listString.get(j);
                    if (parentElementValue.equalsIgnoreCase(splitTextPart))
                    {
                        listString.remove(splitTextPart);
                        childElement.get(i).click();
                    }
                    else if (i == childElement.size() - 1 && listString.size() > 0)
                    {
                        swipeActiveLayoutBtmToTop(activeLayoutId);
                        i = 0;
                    }
                }
            }
        }
    }

    public void verifyAdditionalInputMobilDanMotorCategory()
    {
        swipePageBtmtToTop();
//        verifyAdditionalInputFieldTipeKendaraan();
//        verifyAdditionalInputFieldTransmisi();
        verifyAdditionalInputFieldTahun();
        Log.info("Verify Additional Input Field in Mobil dan Motor Category");
    }

    public void verifyAdditionalInputFieldTipeKendaraan()
    {
        String tipeKendaraan = "Tipe kendaraan";
        Assert.assertTrue(isElementPresent(getTextLocator(tipeKendaraan)));
        Log.info("Verify Additional Input Field Tipe Kendaraan");
    }
    public void verifyAdditionalInputFieldTransmisi()
    {
        String transmisi = "Transmisi";
        Assert.assertTrue(isElementPresent(getTextLocator(transmisi)));
        Log.info("Verify Additional Input Field Transmisi");
    }
    public void verifyAdditionalInputFieldTahun()
    {
        swipePageBtmtToTop();
        String tahun = "Tahun *";
        Assert.assertTrue(isElementPresent(getTextLocator(tahun)));
        Log.info("Verify Additional Input Field Tahun");
    }

    public void inputAdditionalInputFieldTipeKendaraan()
    {
        swipePageBtmtToTop();
        String tipeKendaraan = "Tipe kendaraan";
        String audi = "Audi TT";
        verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, tipeKendaraan);
        verifyListElementMethodAndClickElement(recycleViewCategoryInputField, inputCategory, inputCategoryTitle, audi);
    }

    public void inputAdditionalInputFieldTransmisi()
    {
        swipePageBtmtToTop();
        String transmisi = "Transmisi";
        String automatic = "Automatic";
        verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, transmisi);
        verifyListElementMethodAndClickElement(recycleViewCategoryInputField, inputCategory, inputCategoryTitle, automatic);
    }

    public void inputAdditionalInputFieldTahun()
    {
        swipePageBtmtToTop();
        clickElement(getIdLocator(dropDownInputField));
//        String tahun = "Tahun *";
        String tahunDetail = "2015";
//        verifyListElementMethodAndClickElement(linearLayoutInputField, dropDownListElement, textViewDropDownTitle, tahun);
        ((AndroidDriver)driver).scrollToExact(tahunDetail);
        clickElement(getTextLocator(tahunDetail));
    }

    public void inputAdditionalInputFieldGajiMinimal(String keyword)
    {
        sendKeysById(getIdLocator(minGajiEditText), keyword);
        Log.info("Input Additional Input Field Gaji Minimal");
    }

    public void inputAdditionalInputFieldGajiMaksimal(String keyword)
    {
        sendKeysById(getIdLocator(maxGajiEditText), keyword);
        Log.info("Input Additional Input Field Gaji Maksimal");
    }

    public void clickDetilTambahDanDeskripsi()
    {
        clickElement(getIdLocator(detilTambahanDeskripsi));
        Log.info("Click Detil Tambahan dan Deskripsi");
    }

    public void clickDetilTambahanDeskripsiExpandDock()
    {
        clickElement(getIdLocator(toggleDescription));
        Log.info("Click Expand Dock Detil Tambahan dan Deskripsi");
    }

    public void inputDetilTambahanDanDeskripsi(String inputText)
    {
        swipePageBtmtToTop();
        sendKeysById(getIdLocator(deskripsiEditText), inputText);
        Log.info("Input Detil Tambahan dan Deskripsi");
    }

    public void verifyNoLimitCharacterDescription()
    {
        String[] characterLimit = textViewCharacter.get(0).getText().split(" / ");
        Boolean limitReach;
        int useCharacter = Integer.parseInt(characterLimit[0]);
        int totalCharacter = Integer.parseInt(characterLimit[1]);
        if (useCharacter < totalCharacter)
        {
            limitReach = false;
            Log.info("Jumlah character yang di gunakan : "+characterLimit[0]+". Dari "+characterLimit[1]+" character");
            Log.info("Your description is not reached character limit");
        }
        else
        {
            limitReach = true;
            Log.info("Jumlah character yang di gunakan : "+characterLimit[0]+". Dari "+characterLimit[1]+" character");
            Log.info("Your description is full");
        }
        Assert.assertFalse(limitReach);
        Log.info("Verify No Limit Character Description");
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
        waitForVisibility(getIdLocator(popUpLayoutSuccessPost));
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

    public PaidFeatureModule clickGunakanFiturTopListingButton()
    {
        clickElement(getIdLocator(gunakanFiturTopListingBtn));
        Log.info("Click Gunakan Fitur Top Listing Button");
        return new PaidFeatureModule(driver);
    }

    public ListingPage clickTutupPopUpConfirmationButton()
    {
        clickElement(getIdLocator(tutupPopUpBtn));
        Log.info("Click Tutup Pop-Up Confirmation Button");
        return new ListingPage(driver);
    }

    public void dismissTutorial() {
        Log.info("Dismiss tutorial");
        if (!checkTutorialsColors(getIdLocator(galleryIcon))) {
            clickBySize(getPointLocation(getIdLocator(shutterBtn)));
        }
    }

    public void clickThumbnailsPhoto() {
        Log.info("Click Thumbnails photo");
        clickElement(getIdLocator(imageInBorder));
    }

    public void verifyKameraIcon() {
        Log.info("Verify Kamera Icon");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(cameraIconId)));
    }

    public void uploadUsingCamera() {
        Log.info("Upload using camera");
        verifyKameraIcon();
        clickElement(getIdLocator(cameraIconId));
    }

    public class Maps extends FilterByMapsLocationModule
    {
        public Maps(WebDriver driver) {
            super(driver);
        }

        @Override
        public void verifyAllContentInLocationPage() {
            verifySearchField();
//            dismissTutorial();
            verifyMyCurrentLocationBtn();
            verifyCurrentLocationAddress();
            verifyCariDiLokasiIniBtn();
            Log.info("Verify All Content in Filter Page");
        }

        @Override
        public void dismissTutorial() {
            if (!checkTutorialsColors(getIdLocator(searchField))) {
                clickBySize(getPointLocation(getIdLocator(myCurrentLocationBtn)));
                Log.info("Dismiss This Tutorial");
            }
        }

        @Override
        public PostAdsPage clickCariDiLokasiIniBtn() {
            clickElement(getIdLocator(cariDiLokasiIniBtn));
            return new PostAdsPage(driver);
        }
    }

    public void verifyLoginPopupNotif(){
        Assert.assertTrue(isElementPresent(getIdLocator(loginPopupNotif)));
        Log.info("Verify Login Popup Notification");
    }

    public LoginPage clickLoginBtnInLoginPopup(){
        clickElement(getIdLocator(loginBtnInLoginPopup));
        Log.info("Click Login Btn in Login Pop up Notification");
        return new LoginPage(driver);
    }

    public void clickBackDevice(){
        driver.navigate().back();
    }
}
