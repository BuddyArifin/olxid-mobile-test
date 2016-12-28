package pages;

import io.appium.java_client.android.AndroidDriver;
import module.HamburgerBarModule;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log;

/**
 * Created by sekarayu on 12/6/16.
 */
public class EditIklanPage extends BasePage {

    public EditIklanPage(WebDriver driver) {
        super(driver);
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
    public static final String imgFromGallery = "com.android.documentsui:id/icon_mime";
    public static final String saveImgFromGallery = "com.app.tokobagus.betterb:id/btnSave";

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

    public void verifyEditImageIklan(){
        Log.info("Verify edit image iklan");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(editImageItemContainer)));
        Assert.assertTrue(isElementPresent(getIdLocator(editImageIklan)));
        boolean editDelBtn = isElementPresent(getIdLocator(editDelImageBtn));
        if(!editDelBtn){
            uploadImageIfNotexist();
            Assert.assertTrue(isWaitElementPresent(getIdLocator(editDelImageBtn)));
        }
    }

    private void uploadImageIfNotexist(){
        clickAddImage();
        verifyAddImageSelection();
        clickImageGallery();
        chooseAnImageFromGallery();
        clickSaveImgGallery();
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
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(toggleUpDownDesc)));
    }

    public void verifyEditDescIklan(){
        Log.info("Verify edit description iklan");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(editDescIklan)));
    }

    public void verifyEditSimpanIklanBtn(){
        Log.info("Verify edit simpan iklan button");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(simpanIklanBtn)));
    }

    public void verifyEditIklanPageContents(){
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

    public void verifyConfirmDeleteImagePopUpContents(){
        Log.info("Verify confirm delete image pop up contents");
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
            if(isElementPresentAfterScrollDown(getIdLocator(clearDescBtn))){
                clickClearDesc();
                sendKeysById(getIdLocator(editDescIklan), desc);
            }else {
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
        if(isElementPresent(getTextLocator(kondisiBarang))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollDown(getTextLocator(kondisiBarang))){
            Assert.assertTrue(true);
        }else if(isElementPresentAfterScrollUp(getTextLocator(kondisiBarang))){
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
}
