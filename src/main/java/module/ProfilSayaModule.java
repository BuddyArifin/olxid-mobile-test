package module;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.*;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by itintern on 10/3/16.
 */
public class ProfilSayaModule extends BasePage{
    //Variable for ProfilSaya Page Page
    public static final String backBtn = "Navigate up";
    public static final String titleProfilSaya = "Profil";
    public static final String avatarProfilSaya = "com.app.tokobagus.betterb:id/profileView_ivAvatar";
    public static final String editAvatarProfilSaya = "com.app.tokobagus.betterb:id/profileView_btnEditAvatar";
    public static final String usernameProfilSaya = "com.app.tokobagus.betterb:id/profileView_tvUserName";
    public static final String informasiGabungProfilSaya = "com.app.tokobagus.betterb:id/profileView_tvMemberSince";
    public static final String verifikasiAkunText1 = "com.app.tokobagus.betterb:id/profileView_tvVerifyAccountTitle";
    public static final String verifikasiAkunText2 = "com.app.tokobagus.betterb:id/profileView_tvVerifyAccountInfo";
    public static final String nomorTeleponText = "Nomor Handphone";
    public static final String nomorTeleponNumber = "com.app.tokobagus.betterb:id/profileView_txtViewHandphone";
    public static final String emailText = "com.app.tokobagus.betterb:id/profileView_tvLoginWithInfo";
    public static final String emailValue = "com.app.tokobagus.betterb:id/profileView_tvLoginWithValue";
    public static final String passwordtext = "Password";
    public static final String gantiPasswordBtn = "com.app.tokobagus.betterb:id/profileView_btnChangePassword";
    //public static final String logOutDariOLXBtn = "com.app.tokobagus.betterb:id/profileView_lyLogout";
    public static final String logOutDariOLXBtn = "com.app.tokobagus.betterb:id/profileView_btnLogout";
    public static final String iconThumbGallery = "com.android.documentsui:id/icon_thumb";
    public static final String frameLayoutClass = "android.widget.FrameLayout";
    public static final String btnCamera = "com.app.tokobagus.betterb:id/profileUpdateAvt_btnCamera";
    public static final String btnGallery = "com.app.tokobagus.betterb:id/profileUpdateAvt_btnGallery";
    public static final String btnRemoveAvatar = "com.app.tokobagus.betterb:id/profileUpdateAvt_btnRemove";
    public static final String oldavatarname = "old_avatar.png";
    public static final String newavatarname = "new_avatar.png";

    //Variable for GantiPassword Page
    public static final String rootContainer = "com.app.tokobagus.betterb:id/rootContainer";
    public static final String cancelBtn = "";
    public static final String passwordLamaField = "com.app.tokobagus.betterb:id/profileUpdatePass_txtOldPass";
    public static final String passwordBaruField = "com.app.tokobagus.betterb:id/profileUpdatePass_txtNewPass";
    public static final String passwordKonfirmField = "com.app.tokobagus.betterb:id/profileUpdatePass_txtNewPassConfirm";
    public static final String chkBoxTampilkanPassword = "com.app.tokobagus.betterb:id/text_input_password_toggle";
    public static final String simpanBtn = "com.app.tokobagus.betterb:id/profileUpdatePass_btnChangePassword";
    public static final String tutupKonfirmasiPopUp = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public static final String shutterButton = "com.android.camera:id/shutter_button";
    public static final String acceptAfterTakePicture = "com.android.camera:id/btn_done";
    public static final String editUsernameProfileBtn = "com.app.tokobagus.betterb:id/profileView_btnEditUserName";
    public static final String editProfileUsernameContainer = "com.app.tokobagus.betterb:id/profileView_lyUserNameEdit";
    public static final String editTextUsername = "com.app.tokobagus.betterb:id/profileView_txtUserName";
    public static final String usernameDoneCancelContainer = "com.app.tokobagus.betterb:id/profileView_lyUserNameEditAction";
    public static final String textViewClass = "android.widget.TextView";
    public static final String editTextClass = "android.widget.EditText";
    public static final String linearLayout = "android.widget.LinearLayout";
    public static final String nomorTeleponContainer = "com.app.tokobagus.betterb:id/profileView_lyHandphoneEdit";
    public static final String editHandphoneButton = "com.app.tokobagus.betterb:id/profileView_btnEditHandphone";
    public static final String editTextFieldNoTelp = "com.app.tokobagus.betterb:id/profileView_txtEditHandphone";
    public static final String alertInvalidFormChangePass = "com.app.tokobagus.betterb:id/snackbar_text";
    public static final String noHandphoneText = "Nomor Handphone";
    public static final String imageViewClass = "android.widget.ImageView";
    public static final String logoutKonfirmasiTitleId = "com.app.tokobagus.betterb:id/md_titleFrame";
    public String oldUsername = null;
    public static final String permissionAllowAccessBtn = "com.android.packageinstaller:id/permission_allow_button";
    public static final String snackbarOkBtn = "com.app.tokobagus.betterb:id/snackbar_action";

    @AndroidFindBys({
            @AndroidFindBy(id = chkBoxTampilkanPassword)
    })
    protected List<AndroidElement> hintPasswordBtn;

    @AndroidFindBys({
            @AndroidFindBy(className = frameLayoutClass),
            @AndroidFindBy(id = iconThumbGallery)
    })
    protected List<AndroidElement> imageIconGallery;

    @AndroidFindBy(id = editProfileUsernameContainer)
    protected WebElement usernameContainer;

    @AndroidFindBy(id = nomorTeleponContainer)
    protected WebElement noTeleponContainer;

    @AndroidFindBys({
            @AndroidFindBy(id = usernameDoneCancelContainer),
            @AndroidFindBy(className = imageViewClass)
    })
    protected List<AndroidElement> doneCancelButton;

    public ProfilSayaModule(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void initialProfilSayaTest(){
        Log.info("Back to Initial Profil Saya Test");
        HamburgerBarModule hamburgerBarModule = new HamburgerBarModule(driver);
        if (hamburgerBarModule.isHamburgerBar()){
            Assert.assertTrue(true,"Already in HamburgerBar");
        }else if (isProfilSayaPage()){
            clickElement(getContentLocator(backBtn));
        }else if(isChangePassPage()){
            Log.info("in Change Pass Page");
            clickBackDevice();
            waitForVisibility(getContentLocator(backBtn));
            clickBackDevice();
        }else{
            Assert.assertTrue(true,"Already in HamburgerBar");
        }
    }

    public boolean isProfilSayaPage(){
        return isWaitElementPresent(getIdLocator(gantiPasswordBtn));
    }

    public boolean isChangePassPage(){
        return isWaitElementPresent(getIdLocator(passwordLamaField));
    }

    public void clickBackDevice(){
        driver.navigate().back();
    }

    //Method for ProfilSaya Page
    public void verifyBackBtnProfilSayaPage()
    {
        Log.info("Verify Back Button in ProfilSaya Page");
        Assert.assertTrue(isWaitElementPresent(getContentLocator(backBtn)));
    }
    public void verifyTitleProfilSayaPage()
    {
        Log.info("Verify Title in Profil Saya Page");
        Assert.assertTrue(isElementPresent(getTextLocator(titleProfilSaya)));
    }
    public void verifyAvatarProfilSayaPage()
    {
        Log.info("Verify Avatar in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getIdLocator(avatarProfilSaya)));
        Assert.assertTrue(isElementPresent(getIdLocator(editAvatarProfilSaya)));
    }
    public void verifyUsernameProfilSayaPage()
    {
        Log.info("Verify Username in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getIdLocator(usernameProfilSaya)));
    }

    public void verifyNomorTeleponTextProfilSayaPage()
    {
        Log.info("Verify Text Nomor Handphone in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getTextLocator(noHandphoneText)));
    }
    public void verifyEditNomorHpBtnProfilSayaPage()
    {
        Log.info("Verify Edit Nomor Hp Button in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getTextLocator(editHandphoneButton)));
    }
    public void verifyEmailTextProfilSayaPage()
    {
        Log.info("Verify Email Text in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getIdLocator(emailText)));
    }
    public void verifyEmailValueProfilSayaPage()
    {
        Log.info("Verify Email Value in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getIdLocator(emailValue)));
    }
    public void verifyPasswordTextProfilSayaPage()
    {
        Log.info("Verify Password Text in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getTextLocator(passwordtext)));
    }
    public void verifyGantiPasswordButtonProfilSayaPage()
    {
        Log.info("Verify Ganti Password Button in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getIdLocator(gantiPasswordBtn)));
    }
    public void verifyLogoutDariOLXButtonProfilSayaPage()
    {
        Log.info("Verify Logout Dari OLX in ProfilSaya Page");
        Assert.assertTrue(isElementPresent(getIdLocator(logOutDariOLXBtn)));
    }

    @Step("Verify All Edit Avatar Pop Up Button Contents")
    public void verifyAllEditAvatarPopUpContents() {
        verifyUploadAvatarCamera();
        verifyUploadAvatarGalery();
        verifyDeleteAvatar();
    }
    public void verifyUploadAvatarCamera() {
        Log.info("Verify Upload Avatar Camera");
        Assert.assertTrue(isElementPresent(getIdLocator(btnCamera)));
    }
    public void verifyUploadAvatarGalery() {
        Log.info("Verify Upload Avatar Galery");
        Assert.assertTrue(isElementPresent(getIdLocator(btnGallery)));
    }
    public void verifyDeleteAvatar() {
        Log.info("Verify Delete Avatar");
        Assert.assertTrue(isElementPresent(getIdLocator(btnRemoveAvatar)));
    }
    public void clickUploadAvatarCamera() {
        Log.info("Click Upload Avatar Camera");
        clickElement(getIdLocator(btnCamera));
    }
    public void clickUploadAvatarGalery() {
        Log.info("Click Upload Avatar galery");
        clickElement(getIdLocator(btnGallery));
    }
    public void clickDeleteAvatar() {
        Log.info("Click Delete Avatar");
        clickElement(getIdLocator(btnRemoveAvatar));
    }
    public PostAdsPage clickOneOfPictureGallery()
    {
        Log.info("Click One Image Gallery");
        imageIconGallery.get(0).click();
        return new PostAdsPage(driver);
    }
    public void clickShutterCamera() {
        super.isAutoAcept(getIdLocator(permissionAllowAccessBtn));
        Log.info("Take picture from Camera");
        clickElement(getIdLocator(shutterButton));
    }
    public PostAdsPage acceptTakePicture() {
        Log.info("Accepting Photo");
        clickElement(getIdLocator(acceptAfterTakePicture));
        return new PostAdsPage(driver);
    }
    public void clickAvatar() {
        Log.info("Click Edit Avatar Button");
        clickElement(getIdLocator(editAvatarProfilSaya));
    }
    public void clickEditUsername() {
        Log.info("Click Edit Username Button");
        oldUsername = getStringText(getIdLocator(usernameProfilSaya));
        clickElement(getIdLocator(editUsernameProfileBtn));
    }
    public void clickEditNoHandphone() {
        Log.info("Click Edit No Handphone Button");
        clickElement(getIdLocator(editHandphoneButton));
    }
    public void verifyEditTextField(WebElement textFiedContainer) {
        List<WebElement> elementList = textFiedContainer.findElements(By.className(linearLayout));
        Assert.assertTrue(textFiedContainer.findElement(By.className(textViewClass)).isDisplayed()); // verify titled textfiled
        Assert.assertTrue(textFiedContainer.findElement(By.className(editTextClass)).isDisplayed()); // verify edit textfield
        Assert.assertTrue(isListElementPresentWeb(elementList)); // verify done and cancel button
    }
    public void inputUsername(String keywords) {
        Log.info("Edit Username with "+keywords);
        verifyEditTextField(usernameContainer);
        sendKeysById(getIdLocator(editTextUsername), keywords);
        doneCancelButton.get(0).click();
//      Assert.assertFalse(getStringText(getIdLocator(usernameProfilSaya)).equalsIgnoreCase(oldUsername));
    }

    public void verifyNewUsername(){
        waitForVisibility(getIdLocator(usernameProfilSaya));
        Log.info("Old username : "+oldUsername+". New username : "+getStringText(getIdLocator(usernameProfilSaya)));
        //Assert.assertFalse(getStringText(getIdLocator(usernameProfilSaya)).equalsIgnoreCase(oldUsername));
    }

    public void inputNoHandphone(String nomorTelepon) {
        Log.info("Edit Nomor Telepon with "+nomorTelepon);
        String oldNoHandphone = getStringText(getIdLocator(nomorTeleponNumber));
        verifyEditTextField(noTeleponContainer);
        sendKeysById(getIdLocator(editTextFieldNoTelp), nomorTelepon);
        doneCancelButton.get(0).click();
        Assert.assertFalse(getStringText(getIdLocator(nomorTeleponNumber)).equalsIgnoreCase(oldNoHandphone));
    }


    @Step("Verify All Content in ProfilSaya Page")
    public void verifyAllContentInProfilSayaPage()
    {
        waitForVisibilityOf(getIdLocator(usernameProfilSaya));
        verifyBackBtnProfilSayaPage();
        verifyTitleProfilSayaPage();
        verifyAvatarProfilSayaPage();
        verifyUsernameProfilSayaPage();
        verifyNomorTeleponTextProfilSayaPage();
        verifyEmailTextProfilSayaPage();
        verifyEmailValueProfilSayaPage();
        verifyPasswordTextProfilSayaPage();
        verifyGantiPasswordButtonProfilSayaPage();
        verifyLogoutDariOLXButtonProfilSayaPage();
        Log.info("Verify All Content In ProfilSaya Page Page");
    }

    public void clickUbahPasswordBtnProfilSayaPage()
    {
        Log.info("Click Ubah Password Button in Profil Saya Page");
        clickElement(getIdLocator(gantiPasswordBtn));
    }

    public LoginPage clickLogoutDariOLXBtnProfilSayaPage()
    {
        Log.info("Click Logout Dari OLX Button in Profil Saya Page");
        waitForVisibilityOf(getIdLocator(logOutDariOLXBtn));
        clickElement(getIdLocator(logOutDariOLXBtn));
        closeAlertKonf();
        return new LoginPage(driver);
    }

    //Method for GantiPassword Page

    public void verifyCancelBtnGantiPasswordPage()
    {
        Log.info("Verify Cancel Button in GantiPassword Page");
    }
    public void verifyGantiPasswordTitleGantiPasswordPage()
    {
        Log.info("Verify Ganti Password Title in GantiPassword Page");
        Assert.assertTrue(isElementPresent(getTextLocator(titleProfilSaya)));
    }
    public void verifyPasswordLamaField()
    {
        Log.info("Verify Password Baru Field in GantiPassword Page");
        Assert.assertTrue(isElementPresent(getIdLocator(passwordLamaField)));
    }
    public void verifyPasswordBaruField()
    {
        Log.info("Verify Password Baru Field in GantiPassword Page");
        Assert.assertTrue(isElementPresent(getIdLocator(passwordBaruField)));
    }
    public void verifyKonfirmasiPasswordBaruGantiPasswordPage()
    {
        Log.info("Verify Konfirmasi Password Baru in GantiPassword Page");
        Assert.assertTrue(isElementPresent(getIdLocator(passwordKonfirmField)));
    }
    public void verifyCheckBoxTampilkanPasswordGantiPasswordPage()
    {
        Log.info("Verify Checkbox Tampilkan Password in GantiPassword Page");
        Assert.assertTrue(isListElementPresent(hintPasswordBtn));
    }
    public void verifySimpanButtonGantiPasswordPage()
    {
        Log.info("Verify Simpan Button in GantiPassword Page");
        Assert.assertTrue(isElementPresent(getIdLocator(simpanBtn)));
    }
    public void verifyTutupKonfirmasiPopUp() {
        Log.info("Verify Tutup Konfirmasi Pop Up");
        Assert.assertTrue(isElementPresent(getIdLocator(tutupKonfirmasiPopUp)));
    }

    //Ganti Password
    public void inputOldPassword(String keywords) {
        Log.info("Input Olx Password : "+keywords);
        sendKeysById(getIdLocator(passwordLamaField), keywords);
        clickHintPass(getIdLocator(passwordLamaField), 0);
    }
    public void inputNewPassword(String keywords) {
        Log.info("Input New Password : "+keywords);
        sendKeysById(getIdLocator(passwordBaruField), keywords);
        clickHintPass(getIdLocator(passwordBaruField), 1);
    }
    public void inputKonfirmPassword(String keywords) {
        Log.info("Input Konfirmasi Password : "+keywords);
        sendKeysById(getIdLocator(passwordKonfirmField), keywords);
        clickHintPass(getIdLocator(passwordKonfirmField), 2);
    }

    public void clickHintPass(By by, int index) {
        Log.info("Click Hint Password Button");
        hintPasswordBtn.get(index).click();
    }

    public HamburgerBarModule clickBackButton() {
        Log.info("Click Back Button");
        verifyBackBtnProfilSayaPage();
        clickElement(getContentLocator(backBtn));
        return new HamburgerBarModule(driver);
    }

    public void clickSimpanPasswordButton() {
        Log.info("Click update password Simpan Button");
        clickElement(getIdLocator(simpanBtn));
    }

    public void clickTutupAlertSuccess() {
        verifyTutupKonfirmasiPopUp();
        clickElement(getIdLocator(tutupKonfirmasiPopUp));
    }

    public void verifyAlertShowsUp() {
        boolean checkStatus = isWaitElementPresent(getIdLocator(alertInvalidFormChangePass));
        Assert.assertTrue(checkStatus);
        Log.debug("Alert message : "+getStringText(getIdLocator(alertInvalidFormChangePass)));
    }

    @Step("Verify All Content in GantiPassword Page")
    public void verifyAllContentInGantiPasswordPage()
    {
        verifyCancelBtnGantiPasswordPage();
        verifyGantiPasswordTitleGantiPasswordPage();
        verifyPasswordLamaField();
        verifyPasswordBaruField();
        verifyKonfirmasiPasswordBaruGantiPasswordPage();
        verifyCheckBoxTampilkanPasswordGantiPasswordPage();
        verifySimpanButtonGantiPasswordPage();
        Log.info("Verify All Content in GantiPassword Page");
    }

    //verify image
    public void takeShotOldAvatar(){
        try {
            takeScreenShotInFile(oldavatarname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takeShotNewAvatar(){
        waitForVisibilityOf(getContentLocator(backBtn));
        waitForVisibilityOf(getTextLocator(titleProfilSaya));
        WaitFor(2);
        try {
            takeScreenShotInFile(newavatarname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyOldNewAvatar(){
        Log.info("Verify New Avatar in ProfilSaya Page");
        try {
            Assert.assertTrue(isImgNotEqual(new File(Constants.screenshotsDir+oldavatarname), new File(Constants.screenshotsDir+newavatarname)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickOkOnSnackbar(){
        Log.info("Click Ok on Snackbar");
        clickElement(getIdLocator(snackbarOkBtn));
    }
}
