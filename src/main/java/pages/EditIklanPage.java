package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Log;

import java.util.List;

/**
 * Created by sekarayu on 12/6/16.
 */
public class EditIklanPage extends BasePage {

    public EditIklanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String editAdsTitle = "Edit Iklan";
    public static final String backBtn = "Navigate up";
    public static final String editImageIklan = "com.app.tokobagus.betterb:id/imgImage";
    public static final String editDelImageBtn = "com.app.tokobagus.betterb:id/btnDelete";
    public static final String editImageItemContainer = "com.app.tokobagus.betterb:id/imageItemContainer";
    public static final String editJudulIklan = "com.app.tokobagus.betterb:id/edtTitle";
    public static final String clearJudulbtn = "com.app.tokobagus.betterb:id/btnClearTitle";
    public static final String editLokasiIklan = "com.app.tokobagus.betterb:id/tvPlaceName";
    public static final String gpsLokasiBtn = "com.app.tokobagus.betterb:id/imgGpsIcon";
    public static final String kategoriIklan = "com.app.tokobagus.betterb:id/tvCategoryName";
    public static final String kategoriExtraInfo = "com.app.tokobagus.betterb:id/tvCategoryExtraInformation";
    public static final String editPriceIklan = "com.app.tokobagus.betterb:id/edtPrice";
    public static final String clearPricebtn = "com.app.tokobagus.betterb:id/btnClearPrice";
    public static final String editDescIklan = "com.app.tokobagus.betterb:id/edtDescription";
    public static final String clearDescBtn = "com.app.tokobagus.betterb:id/btnClearDescription";
    public static final String toggleUpDownDesc = "com.app.tokobagus.betterb:id/imgToggleUpDown";
    public static final String simpanIklanBtn = "com.app.tokobagus.betterb:id/btnPostAd";
    public static final String popupConfirmDelImage = "android:id/content";
    public static final String confDelImgYes = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public static final String confDelImgNo = "com.app.tokobagus.betterb:id/md_buttonDefaultNegative";
    public static final String min15char = "Min. 15 karakter";
    public static final String hargaHarusDiisi = "Harga harus diisi.";
    public static final String min20char = "Min. 20 karakter";
    public static final String successAlert = "com.app.tokobagus.betterb:id/tvExplanation";
    public static final String tutupOnSuccessAlert = "com.app.tokobagus.betterb:id/btnClose";
    public static final String adsDetailTitle = "Detail Iklan";
    public static final String snackBar = "com.app.tokobagus.betterb:id/snackbar_text";
    public static final String snackBarOk = "com.app.tokobagus.betterb:id/snackbar_action";
    public static final String kondisiBarang = "kondisi";
    public static final String btnselectKondisi = "com.app.tokobagus.betterb:id/btnSelection";
    public static final String titleKondisiPopup = "com.app.tokobagus.betterb:id/md_title";
    public static final String contentSelectionKondisiPopup = "com.app.tokobagus.betterb:id/md_contentRecyclerView";
    public static final String kondisiBaru = "Baru";
    public static final String kondisiBekas = "Bekas";
    public static final String btnCamera = "com.app.tokobagus.betterb:id/btnCamera";
    public static final String btnGallery = "com.app.tokobagus.betterb:id/btnGallery";
    public static final String imgFromGallery = "com.android.documentsui:id/icon_thumb";
    public static final String saveImgFromGallery = "com.app.tokobagus.betterb:id/btnSave";
    public static final String androidPermissionAlert = "com.android.packageinstaller:id/permission_allow_button";
    public static final String shutterBtn = "com.android.camera:id/shutter_button";
    public static final String saveCapturedImgBtn = "com.android.camera:id/btn_done";
    public static final String openFromHambugerGallery = "com.android.documentsui:id/roots_toolbar";
    public static final String popUpMinOneImage = "com.app.tokobagus.betterb:id/md_titleFrame";
    public static final String nomorHpId = "com.app.tokobagus.betterb:id/edtPhone";

    @AndroidFindBys({
            @AndroidFindBy(className = "android.widget.GridView"),
            @AndroidFindBy(id = "android:id/text1")
    })
    public List<AndroidElement> appsPhotoOnPopUP;

    @AndroidFindBys({
            @AndroidFindBy(id = "android:id/list"),
            @AndroidFindBy(id = "android:id/title")
    })
    public List<AndroidElement> appsPhotonOnHamburger;

    @AndroidFindBys({
            @AndroidFindBy(id = editImageItemContainer),
            @AndroidFindBy(id = editDelImageBtn)
    })
    private List<AndroidElement> imageIklan;

    public boolean editAdsTitleDisplayed(){
        return isElementPresent(getTextLocator(editAdsTitle));
    }

    public void verifyEditAdsTitle(){
        Log.info("Verify Edit Ads Title");
        Assert.assertTrue(isWaitElementPresent(getTextLocator(editAdsTitle)));
    }

    public void verifyBackBtn(){
        Log.info("Verify back button");
        Assert.assertTrue(isElementPresent(getContentLocator(backBtn)));
    }

    public void uploadImageIfNotexist() {
        String pilihGambar = "Pilih gambar";

        if (isElementPresent(getTextLocator(pilihGambar))){

            usedDropBoxToUploadPicture(appsPhotoOnPopUP);

        } else if (isElementPresent(getIdLocator(openFromHambugerGallery))) {

            usedDropBoxToUploadPicture(appsPhotonOnHamburger);
        }

        searchAndClickTestPhoto();
    }

    private void usedDropBoxToUploadPicture(List<AndroidElement> list) {
        for (int i = 0; i < list.size() ; i++) {

            if (list.get(i).getText().equalsIgnoreCase("Dropbox")) {
                list.get(i).click();
                break;
            }
        }
    }

    private void searchAndClickTestPhoto() {
        String titleDropBoxId = "com.dropbox.android:id/left_title";
        String foldername = "Screenshots";
        String filename = "test.png";

        isWaitElementPresent(getIdLocator(titleDropBoxId));
        clickElement(getTextLocator(foldername));
        clickElement(getTextLocator(filename));

    }

    public void verifyEditImageIklan(){
        Log.info("Verify edit image iklan");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(editImageItemContainer)));
        Assert.assertTrue(isElementPresent(getIdLocator(editImageIklan)));
        boolean editDelBtn = isElementPresent(getIdLocator(editDelImageBtn));
        if(!editDelBtn){
            clickAddImage();
            verifyAddImageSelection();
            clickImageGallery();
            uploadImageIfNotexist();
            clickSaveImgGallery();
            Assert.assertTrue(isWaitElementPresent(getIdLocator(editDelImageBtn)));
        }
    }

    public void clickAddImage(){
        clickElement(getIdLocator(editImageIklan));
        Log.info("Click add image iklan");
    }

    public void verifyAddImageSelection(){
        Assert.assertTrue(isWaitElementPresent(getIdLocator(btnCamera)));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(btnGallery)));
    }

    public void clickImageCamera(){
        clickElement(getIdLocator(btnCamera));
        Log.info("Click image camera");
    }

    public void clickShutterCameraEdit(){
        clickElement(getIdLocator(shutterBtn));
        Log.info("Click shutter camera");
    }

    public void clickSaveCapturedImg(){
        clickElement(getIdLocator(saveCapturedImgBtn));
        Log.info("Click save captured image from camera");
    }

    public void clickImageGallery(){
        clickElement(getIdLocator(btnGallery));
        Log.info("Click image gallery");
    }

    public void chooseAnImageFromGallery(){
        clickElement(getIdLocator(imgFromGallery));
        Log.info("Click one image from gallery");
    }

    public void clickSaveImgGallery(){
        clickElement(getIdLocator(saveImgFromGallery));
        Log.info("Click simpan image upload from gallery");
    }

    public void verifyEditJudulIklan(){
        Log.info("Verify edit judul iklan");
        boolean clearjudul = isElementPresent(getIdLocator(clearJudulbtn));
        if(clearjudul){
            Assert.assertTrue(isElementPresent(getIdLocator(editJudulIklan)));
        }else {
            Assert.assertTrue(isElementPresentAfterScrollUp(getIdLocator(clearJudulbtn)));
            Assert.assertTrue(isElementPresent(getIdLocator(editJudulIklan)));
        }
    }

    public void verifyEditLokasiIklan(){
        Log.info("Verify edit lokasi iklan");
        Assert.assertTrue(isElementPresent(getIdLocator(editLokasiIklan)));
        Assert.assertTrue(isElementPresent(getIdLocator(gpsLokasiBtn)));
    }

    public void verifyKategoriIklan(){
        Log.info("Verify edit kategori iklan");
        Assert.assertTrue(isElementPresent(getIdLocator(kategoriIklan)));
        Assert.assertTrue(isElementPresent(getIdLocator(kategoriExtraInfo)));
    }

    public void verifyEditPriceIklan(){
        Log.info("Verify edit price iklan");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(editPriceIklan)));
        Assert.assertTrue(isElementPresent(getIdLocator(clearPricebtn)));
    }

    public void verifyOpsionalInfo(){
        Log.info("Verify opsional info");
        if(isElementPresent(getIdLocator(toggleUpDownDesc))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollDown(getIdLocator(toggleUpDownDesc))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollUp(getIdLocator(toggleUpDownDesc))){
            Assert.assertTrue(true);
        }
    }

    public void verifyEditDescIklan(){
        Log.info("Verify edit description iklan");
        if(isElementPresent(getIdLocator(editDescIklan))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollDown(getIdLocator(editDescIklan))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollUp(getIdLocator(editDescIklan))){
            Assert.assertTrue(true);
        }
    }

    public void verifyEditSimpanIklanBtn(){
        Log.info("Verify edit simpan iklan button");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(simpanIklanBtn)));
    }

    public void verifyEditIklanPageContents(){
        isAutoAcept(getIdLocator(androidPermissionAlert));
        verifyEditAdsTitle();
        verifyBackBtn();
        verifyEditImageIklan();
        verifyEditJudulIklan();
        verifyEditLokasiIklan();
        verifyKategoriIklan();
        verifyEditPriceIklan();
        verifyOpsionalInfo();
        verifyEditDescIklan();
        verifyEditSimpanIklanBtn();
    }

    public void clickBackBtn(){
        //clickElement(getContentLocator(backBtn));
        driver.navigate().back();
        Log.info("Click back button");
    }

    public void clickDeleteImageIklan(){
        clickElement(getIdLocator(editDelImageBtn));
        Log.info("Click delete image iklan");
    }

    public void verifyImageMoreThanOne(){
        clickElement(getIdLocator(confDelImgYes));
        clickOnEmptyBoxImages();
        verifyAddImageSelection();
        clickImageGallery();
        uploadImageIfNotexist();
        clickSaveImgGallery();
        clickDeleteImageIklan();
    }

    private void clickOnEmptyBoxImages() {
        int emptyBoxIndex = imageIklan.size();
        if (emptyBoxIndex > 0 ) {
            driver.findElements(getIdLocator(editImageItemContainer))
                    .get(emptyBoxIndex).click();
        }
    }

    public void verifyConfirmDeleteImagePopUpContents(){
        Log.info("Verify confirm delete image pop up contents");
        if(isElementPresent(getIdLocator(popUpMinOneImage))){
            verifyImageMoreThanOne();
        }
        Assert.assertTrue(isElementPresent(getIdLocator(popupConfirmDelImage)));
        Assert.assertTrue(isElementPresent(getIdLocator(confDelImgNo)));
        Assert.assertTrue(isElementPresent(getIdLocator(confDelImgYes)));
    }

    public void confirmYesDeleteImageIklan(){
        clickElement(getIdLocator(confDelImgYes));
        Log.info("Confirmed Delete Image");
    }

    public void confirmNoDeleteImageIklan(){
        clickElement(getIdLocator(confDelImgNo));
        Log.info("Cancel confirm delete image");
    }

    public void inputNewIklanTitle(String title){
        boolean judul = isElementPresentAfterScrollUp(getIdLocator(editJudulIklan));
        if(judul){
            sendKeysById(getIdLocator(editJudulIklan), title);
            Log.info("Input new judul iklan : "+title);
        }
    }

    public void clickClearJudulIklan(){
        clickElement(getIdLocator(clearJudulbtn));
        Log.info("Click clear judul iklan btn");
    }

    public void inputNewIklanPrice(String price){
        boolean harga = isElementPresentAfterScrollDown(getIdLocator(editPriceIklan));
        if(harga){
            driver.findElement(By.id(editPriceIklan)).sendKeys(price);
            hideSoftKeyboard();
            Log.info("Input new harga iklan : "+price);
        }
    }

    public void clickClearPriceIklan(){
        clickElement(getIdLocator(clearPricebtn));
        Log.info("Click clear harga iklan btn");
    }

    public void clickToggleOptional(){
        boolean opt = isElementPresentAfterScrollDown(getIdLocator(toggleUpDownDesc));
        if(opt){
            clickElement(getIdLocator(toggleUpDownDesc));
            Log.info("Click toggle opsional");
        }
    }

    public void clickClearDesc(){
        clickElement(getIdLocator(clearDescBtn));
        Log.info("Click clear description btn");
    }

    public void inputNewIklanDesc(String desc){
        boolean description = isElementPresentAfterScrollDown(getIdLocator(editDescIklan));
        if(description){
            if(getStringText(getIdLocator(editDescIklan)).isEmpty()){
                sendKeysById(getIdLocator(editDescIklan), desc);
            }else if (isElementPresentAfterScrollDown(getIdLocator(clearDescBtn))) {
                clickClearDesc();
                sendKeysById(getIdLocator(editDescIklan), desc);
            }
        }
        Log.info("Input new desc iklan : "+desc);
    }

    public void inputNewIklanDescMax(){
        boolean description = isElementPresentAfterScrollDown(getIdLocator(editDescIklan));
        int maxdesc = 4096;
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String desc = randomStringUtils.randomAlphabetic(maxdesc).toUpperCase();
        if(description){
            if(isElementPresentAfterScrollDown(getIdLocator(clearDescBtn))) {
                clickClearDesc();
                sendKeysById(getIdLocator(editDescIklan), desc);
            }else {
                sendKeysById(getIdLocator(editDescIklan), desc);
            }
        }
        Log.info("Input max chars for ads description");
    }

    public void inputNewIklanDescMaxLowercase(){
        boolean description = isElementPresentAfterScrollDown(getIdLocator(editDescIklan));
        int maxdesc = 4096;
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String desc = randomStringUtils.randomAlphabetic(maxdesc).toLowerCase();
        if(description){
            if(isElementPresentAfterScrollDown(getIdLocator(clearDescBtn))) {
                clickClearDesc();
                sendKeysById(getIdLocator(editDescIklan), desc);
            }else {
                sendKeysById(getIdLocator(editDescIklan), desc);
            }
        }
        Log.info("Input max chars in lower case for ads description");
    }

    public void clickEditSimpanBtn(){
        boolean simpan = isElementPresentAfterScrollDown(getIdLocator(simpanIklanBtn));
        if(simpan){
            clickElement(getIdLocator(simpanIklanBtn));
            Log.info("Click Edit Simpan Button");
        }
    }

    public void verifyKategoriNotClickable(){
        String clickable = driver.findElement(getIdLocator(kategoriIklan)).getAttribute("clickable");
        Log.info("kategori iklan clickable : "+clickable);
        Assert.assertTrue(clickable.equalsIgnoreCase("false"));
    }

    public void verifyInvalidJudulIklan(){
        Log.info("Verify invalid judul iklan");
        boolean alert = isElementPresent(getTextLocator(min15char));
        if(alert){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(isElementPresentAfterScrollUp(getTextLocator(min15char)));
        }
    }

    public void verifyInvalidCharJudulIklan(){
        Log.info("Verify invalid char judul iklan");
        Assert.assertTrue(isElementPresent(getIdLocator(snackBar)));
        clickElement(getIdLocator(snackBarOk));
    }

    public void verifyInvalidHarga(){
        Log.info("Verify invalid harga iklan");
        boolean invAlert = isElementPresent(getTextLocator(hargaHarusDiisi));
        if(invAlert){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(isElementPresentAfterScrollUp(getTextLocator(hargaHarusDiisi)));
        }
    }

    public void verifyInvalidDesc(){
        Log.info("Verify invalid desc iklan");
        Assert.assertTrue(isElementPresent(getIdLocator(snackBar)));
        clickElement(getIdLocator(snackBarOk));
    }

    public void verifySuccessAlert(){
        Log.info("Verify success alert");
        Assert.assertTrue(isElementPresent(getIdLocator(successAlert)));
        Assert.assertTrue(isElementPresent(getIdLocator(tutupOnSuccessAlert)));
    }

    public void clickTutupOnSuccessAlert(){
        clickElement(getIdLocator(tutupOnSuccessAlert));
        Log.info("Click tutup on success alert");
    }

    //KONDISI

    public void verifyAdsKondisi(){
        Log.info("Verify ads kondisi");
        if(isElementPresent(getIdLocator(btnselectKondisi))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollDown(getIdLocator(btnselectKondisi))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollUp(getIdLocator(btnselectKondisi))){
            Assert.assertTrue(true);
        }
        //Assert.assertTrue(isElementPresent(getTextLocator(kondisiBarang)));
        Assert.assertTrue(isElementPresent(getIdLocator(btnselectKondisi)));
    }

    public void clickSelectKondisi(){
        clickElement(getIdLocator(btnselectKondisi));
        Log.info("Click select kondisi");
    }

    public void verifyKondisiSelectionOpt(){
        Log.info("Verify kondisi selection option");
        Assert.assertTrue(isElementPresent(getIdLocator(titleKondisiPopup)));
        Assert.assertTrue(isElementPresent(getIdLocator(contentSelectionKondisiPopup)));
        Assert.assertTrue(isElementPresent(getTextLocator(kondisiBaru)));
        Assert.assertTrue(isElementPresent(getTextLocator(kondisiBekas)));
    }

    public void clickKondisiSelectionBaru(){
        clickElement(getTextLocator(kondisiBaru));
        Log.info("Click kondisi baru");
    }

    public void clickKondisiSelectionBekas(){
        clickElement(getTextLocator(kondisiBekas));
        Log.info("Click kondisi bekas");
    }

    @AndroidFindBy(id = nomorHpId)
    private AndroidElement nomorHandphoneField;

    public void inputNomorHandphone(String noTelp) {
        Log.info("Input Nomor Handphone");
        isElementPresentAfterScrollDown(getIdLocator(nomorHpId));
        nomorHandphoneField.replaceValue(noTelp);
        hideSoftKeyboard();
    }
}
