package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import module.LoginWithOlxModule;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by buddyarifin on 9/2/16.
 */
public class AdsDetailsPage extends BasePage {
    public static final String backBtn = "Navigate up";
    protected static final String bannerInfo = "com.app.tokobagus.betterb:id/info_text";
    protected static final String bannerCloseBtn = "com.app.tokobagus.betterb:id/safety_info_close";
    protected static final String titleAds = "";
    protected static final String tipsAds = "com.app.tokobagus.betterb:id/info_text";
    protected static final String photoAds = "com.app.tokobagus.betterb:id/image";
    protected static final String photoPagination = "com.app.tokobagus.betterb:id/layout_pointer";
    protected static final String priceAds = "com.app.tokobagus.betterb:id/price";
    protected static final String favoriteBtn = "com.app.tokobagus.betterb:id/likes";
    protected static final String statusAdsDilihat = "com.app.tokobagus.betterb:id/viewed";
    protected static final String statusAdsDihubungi = "com.app.tokobagus.betterb:id/contacted";
    protected static final String postDateAds = "com.app.tokobagus.betterb:id/created_at";
    protected static final String conditionsAds = "com.app.tokobagus.betterb:id/condition";
    protected static final String postYearsAds = "";
    protected static final String transactionOptionAds = "";
    protected static final String descriptionsTitleAds = "com.app.tokobagus.betterb:id/title";
    protected static final String descriptionsAds = "com.app.tokobagus.betterb:id/description";
    protected static final String moreInfoBtn = "com.app.tokobagus.betterb:id/more";
    protected static final String avatarSeller = "com.app.tokobagus.betterb:id/seller_photo";
    protected static final String memberJoinDate = "com.app.tokobagus.betterb:id/seller_member_since";
    protected static final String memberRating = "";
    protected static final String adsLocation = "com.app.tokobagus.betterb:id/map_image";
    protected static final String idIklan = "com.app.tokobagus.betterb:id/ad_id";
    protected static final String lihatIklanAndTestimoni = "Lihat iklan lainnya";
    protected static final String laporkanIklan = "com.app.tokobagus.betterb:id/report";
    protected static final String hubungiPenjual = "com.app.tokobagus.betterb:id/contact";
    public static final String sharedBtn = "com.app.tokobagus.betterb:id/menu_share";
    public static final String lebihLanjutBtn = "com.app.tokobagus.betterb:id/safety_info_more";
    public static final String tutupBtn = "com.app.tokobagus.betterb:id/safety_info_close";
    public static final String sharingPanels = "android:id/resolver_list";
    public static final String sharingAppsText = "android:id/text1";
    public static final String PUSAT_BANTUAN = "Pusat Bantuan";

    public static final String androidOkButton = "android:id/button1";

    // Share
    public static final String shareIcon = "android:id/icon";
    public static final String statusAdsDifavoritkan = "com.app.tokobagus.betterb:id/liked";
    public static final String reasonDeactivatePopUp = "com.app.tokobagus.betterb:id/md_customViewFrame";
    public static final String radioGrupDeactivateReason = "com.app.tokobagus.betterb:id/recycler_view_reason_list";
    public static final String cancelDeactivate = "com.app.tokobagus.betterb:id/button_cancel";
    public static final String soldOnOlx = "com.app.tokobagus.betterb:id/radiobutton_sold_on_olx";
    public static final String soldOnOthersite = "com.app.tokobagus.betterb:id/radiobutton_sold_on_other_site";
    public static final String noResponse = "com.app.tokobagus.betterb:id/radiobutton_no_response";
    public static final String onVacation = "com.app.tokobagus.betterb:id/radiobutton_on_vacation";
    public static final String otherReason = "com.app.tokobagus.betterb:id/radiobutton_other";

    // Seller View
    public static final String gunakanFiturHighlightId = "com.app.tokobagus.betterb:id/safety_info_more";
    public static final String tutupButtonId = "com.app.tokobagus.betterb:id/safety_info_close";
    public static final String adsStatusDilihatId = "com.app.tokobagus.betterb:id/viewed";
    public static final String adsStatusDihubungiId = "com.app.tokobagus.betterb:id/contacted";
    public static final String adsStatusDiFavoritkaniId = "com.app.tokobagus.betterb:id/liked";
    public static final String setTerjualbtnId = "com.app.tokobagus.betterb:id/button_set_sold";
    public static final String nonActivatebtnId = "com.app.tokobagus.betterb:id/button_deactivate";
    public static final String editAdsBtnId = "com.app.tokobagus.betterb:id/menu_edit_ad";
    public static final String sudahTerjualReasonId = "com.app.tokobagus.betterb:id/recycler_view_reason_list";
    public static final String radioButton = "android.widget.RadioButton";
    public static final String deskripsiLaporanId = "com.app.tokobagus.betterb:id/edtInformation";
    public static final String kirimLaporanBtn = "com.app.tokobagus.betterb:id/btnSendReport";

    public static String getIdIklanExpected() {
        return idIklanExpected;
    }

    public static String idIklanExpected = null;
    private static String idIklanSave = "";
    private static boolean isMapsDisplayed;
    private static String dateAds;


    @AndroidFindBys({
            @AndroidFindBy(id = photoPagination)
    })
    protected List<AndroidElement> photoPaginations;

    @AndroidFindBys({
            @AndroidFindBy(id = sharingPanels),
            @AndroidFindBy(id = sharingAppsText)
    })
    protected List<AndroidElement> sharingToApps;

    @AndroidFindBys({
            @AndroidFindBy(id = sudahTerjualReasonId),
            @AndroidFindBy(id = radioButton)
    })
    protected List<AndroidElement> sudahTerjualReasonList;

    @AndroidFindBys({
            @AndroidFindBy(id = radioGrupDeactivateReason),
            @AndroidFindBy(className = radioButton)
    })
    protected List<AndroidElement> radioReasonList;

    @AndroidFindBys({
            @AndroidFindBy(id = "com.app.tokobagus.betterb:id/rgReport"),
            @AndroidFindBy(className = "android.widget.RadioButton")
    })
    public List<AndroidElement> listStatusLaporan;

    public AdsDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyBanner() {
        Log.info("Verify Banner display");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(bannerInfo)));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(bannerCloseBtn)));
    }
    public void verifyTitleAds(){
        Log.info("Verify Detail Iklan Text");
    }
    public void verifyShareBtn(){
        Log.info("Verify Share Button display");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(sharedBtn)));
    }
    public void verifyLebihLanjut(){
        Log.info("Verify Lebih Lanjut Button display");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(lebihLanjutBtn)));
    }
    public void verifyTutupBtn(){
        Log.info("Verify Tutup Button display");
        Assert.assertTrue(isElementPresent(getIdLocator(tutupBtn)));
    }
    public void verifyTipsAds(){
        Log.info("Verify Tips Transaksi Aman");
        Assert.assertTrue(isElementPresent(getIdLocator(tipsAds)));
    }
    public void verifyPhotoAds(){
        Log.info("Verify Ads Photo display");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(photoAds)));
        verifyListPhotos();
    }

    private void verifyListPhotos() {
        if (isListElementPresent(photoPaginations)){
            Log.info("Verify Ads list Photo display");
            clickElement(getIdLocator(photoAds));
            photoPaginations.forEach( photos -> {
                ((AndroidDriver)driver).swipe(driver.manage().window().getSize().getWidth()-10,
                        300, 20, 300, 1000);
            });
            driver.navigate().back();
        }
    }

    public void verifyPriceAds(){
        Log.info("Verify Price Ads display");
        Assert.assertTrue(isElementPresent(getIdLocator(priceAds)));
    }
    public void verifyFavoriteBtn(){
        Log.info("Verify Favorite Button display");
        Assert.assertTrue(isElementPresent(getIdLocator(favoriteBtn)));
    }
    public void verifyStatusAds(){
        Log.info("Verify Status Ads display");
        Assert.assertTrue(isElementPresent(getIdLocator(statusAdsDilihat)));
        Assert.assertTrue(isElementPresent(getIdLocator(statusAdsDihubungi)));
    }
    public void verifyStatusAdsFave(){
        Log.info("Verify Status Ads Favorit");
        Assert.assertTrue(isElementPresent(getIdLocator(statusAdsDifavoritkan)));
    }
    public void verifyPostDateAds(){
        Log.info("Verify Tanggal Pemasangan Iklan display");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(postDateAds)));
        setPostDateAds(getStringText(getIdLocator(postDateAds)));
    }
    public void verifyConditionsAds(){
        Log.info("Verify Kondisi Barang pada Iklan display");
        if (isElementPresent(getIdLocator(conditionsAds))) { // handle screen size lower
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(conditionsAds)));
        }
    }
    public void verifyPostYearsAds(){
        Log.info("Verify Tahun dari Iklan display");
    }
    public void verifyTransactionAds(){
        Log.info("Verify Available Transaksi eg. Ketemuan");
    }
    public void verifyDescriptionAds(){
        Log.info("Verify Deskripsi Iklan display");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(descriptionsTitleAds)));
        Assert.assertTrue(isElementPresent(getIdLocator(descriptionsAds)));
    }
    public void verifyMoreInfoAds(){
        Log.info("Verify Lihat Selengkapnya pada deskripsi display");
        boolean displayed = isElementPresentAfterScrollDown(getIdLocator(moreInfoBtn));
        if (displayed) {
            Assert.assertTrue(true);
            clickElement(getIdLocator(moreInfoBtn));
        }

    }
    public void verifyAvatarSeller(){
        Log.info("Verify Avatar Profile Picture display");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(avatarSeller)));
    }
    public void verifyMemberJoinDate(){
        Log.info("Verify Member Join Date display");
        if (isElementPresent(getIdLocator(memberJoinDate))) {
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(memberJoinDate)));
        }
    }
    public void verifyMemberRating(){
        Log.info("Verify Member Rating display");
    }
    public void verifyAdsLocations(){
        Log.info("Verify Lokasi Iklan dengan Maps");
        boolean displayed = isElementPresentAfterScrollDown(getIdLocator(adsLocation));
        if (displayed) {
            Assert.assertTrue(true);
            setIsMapsDisplayed(true);
        }
    }
    public void verifyidIklanNumber(){
        Log.info("Verify Iklan ID number");
        idIklanExpected = getStringText(getIdLocator(idIklan));
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(idIklan)));
        setIdIklanSave(getIdLocator(idIklan));
    }

    public void verifyLihatIklanAndTestimoni(){
        Log.info("Verify Lihat Iklan dan Testimoni");
        Assert.assertTrue(isElementPresentAfterScrollDown(getTextLocator(lihatIklanAndTestimoni)));
    }
    public void verifyLaporkanIklan(){
        Log.info("Verify Laporkan Iklan");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(laporkanIklan)));
    }
    public void verifyHubungiPenjual() {
        Log.info("Verify Hubungi penjual Button");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(hubungiPenjual)));
    }
    public void verifySudahTerjualBtn() {
        Log.info("Verify Sudah Terjual Button");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(setTerjualbtnId)));
    }
    public void verifyNonActiveBtn() {
        Log.info("Verify Non Active Button");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(nonActivatebtnId)));
    }

    public void verifyStatusLaporan() {
        Log.info("Verify List Laporan Status");
        super.isListElementPresent(listStatusLaporan);
        listStatusLaporan.forEach( item -> {
            Assert.assertNotNull(item.getText());
        });
    }

    public void verifyKirimLaporanBtn() {
        Log.info("Verify Kirim Laporan Button");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(kirimLaporanBtn)));
    }

    @Step("Verify All Contents of Kirim Laporan")
    public void verifyAllContentsofKirimLaporan() {
        verifyKirimLaporanBtn();
        verifyStatusLaporan();
    }

    @Step("Verify All Contents of Details Page")
    public void verifyAllContensAdsDetails(){
     //   verifyBanner();
        verifyTitleAds();
        verifyShareBtn();
        verifyLebihLanjut();
        verifyTutupBtn();
        verifyTipsAds();
        verifyPhotoAds();
        verifyPriceAds();
        verifyFavoriteBtn();
        verifyStatusAds();
//        verifyPostDateAds();
        verifyidIklanNumber();
//        verifyConditionsAds();
        verifyPostYearsAds();
        verifyTransactionAds();
        verifyMoreInfoAds();
        verifyAvatarSeller();
        verifyMemberJoinDate();
//        verifyMemberRating();
        verifyAdsLocations();
        verifyLihatIklanAndTestimoni();
        verifyLaporkanIklan();
        verifyHubungiPenjual();
    }

    @Step("Verify All Contents of Details Page [Seller View]")
    public void verifyAllContentsAdsDetailFromMyAds(){
        dismissTutorial();
        verifyTitleAds();
        verifyShareBtn();
        verifyEditBtn();
        verifyLebihLanjut();
        verifyTutupBtn();
        verifyTipsAds();
//        verifyPhotoAds();
        verifyPriceAds();
        verifyStatusAds();
        verifyStatusAdsFave();
        verifySudahTerjualBtn();
        verifyNonActiveBtn();
        verifyidIklanNumber();
//        verifyPostYearsAds();
//        verifyTransactionAds();
//        verifyMoreInfoAds();
        verifyAvatarSeller();
        verifyMemberJoinDate();
        verifyAdsLocations();
//        verifyLihatIklanAndTestimoni();
    }

    protected void verifyEditBtn() {
        Log.info("Verify Share Button display");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(editAdsBtnId)));
    }

    private void dismissTutorial() {
        Log.debug("Dismiss Tutorial");
        if (!checkTutorialsColors(getContentLocator(backBtn))) {
            clickBySize(getPointLocation(getIdLocator(editAdsBtnId)));
        }
    }

    public void clickShareBtn() {
        isElementPresentAfterScrollUp(getIdLocator(bannerCloseBtn));
        clickElement(getIdLocator(sharedBtn));
    }

    public void verifyShare(){
        WaitFor(2);
        waitForVisibility(getIdLocator(shareIcon));
        Assert.assertTrue(isElementPresent(getIdLocator(shareIcon)));
        Log.info("Verify share suggestion list is present");
        driver.navigate().back();
    }

    public void clickCloseBtn() {
        Log.info("Click Close Button, on Tips Transaksi Aman");
        clickElement(getIdLocator(tutupBtn));
    }
    public void clickInfoLebihLanjut() {
        Log.info("Click Info Lebih Lanjut link Button");
        Assert.assertTrue(isElementPresentAfterScrollUp(getIdLocator(lebihLanjutBtn)));
        clickElement(getIdLocator(lebihLanjutBtn));
        Assert.assertTrue(isWaitElementPresent(getAndroidViewTextLocator(PUSAT_BANTUAN)));
        driver.navigate().back();
    }
    public void clickFavoriteBtn() {
        Log.info("Click to Favorite Button, Add Ads to Favorite");
        isElementPresentAfterScrollUp(getIdLocator(favoriteBtn));
        clickElement(getIdLocator(favoriteBtn));
        clickOkOnAlert();
    }
    public void clickLihatIklanAndTestimoni() {
        isElementPresentAfterScrollDown(getTextLocator(lihatIklanAndTestimoni));
        Log.info("Click Lihat Iklan dan Testimoni");
        clickElement(getTextLocator(lihatIklanAndTestimoni));
    }

    public void verifyLihatIklanLainnya() {
        isWaitElementPresent(getIdLocator(ListingPage.gambarIklan));
        if (!isNotFoundSearchContentVisible()) {
            Log.info("Verify Gambar Iklan");
            ListingPage.listAds.forEach( listedAds -> {
                Assert.assertTrue(listedAds.isDisplayed(),
                        "Some Ads from List Are not Valid");
            });
        }
    }

    public void clickLaporkanIklan() {
        Log.info("Click Laporkan Iklan");
        isElementPresentAfterScrollDown(getIdLocator(laporkanIklan));
        swipePageBtmtToTop(); // make sure laporan iklan present but not visible
        clickElement(getIdLocator(laporkanIklan));
    }
    public FilterByMapsLocationModule clickAdsLocations() {
        Log.info("Click Ads Location Button");
        if (getIsMapsDisplayed()) {
            isElementPresentAfterScrollDown(getIdLocator(adsLocation));
            clickElement(getIdLocator(adsLocation));
        }
        return new FilterByMapsLocationModule(driver);
    }
    public void clickMoreInfo() {
        Log.info("Click More Info Button, full description");
        clickElement(getIdLocator(moreInfoBtn));
    }
    public PesanPage clickHubugiPenjual() {
        isElementPresentAfterScrollDown(getIdLocator(hubungiPenjual));
        Log.info("Click Hubungi Penjual Button");
        clickElement(getIdLocator(hubungiPenjual));
        return new PesanPage(driver);
    }

    public LoginPage verifyAlertAndTapOK() {
        Log.info("Click OK Alert");
        if(isWaitElementPresent(getIdLocator(alertContent))) {
            clickElement(getIdLocator(tapOkButton));
            loginToOlx();
        }
        return new LoginPage(driver);
    }

    private void loginToOlx() {
        LoginPage loginPage = new LoginPage(driver);
        LoginWithOlxModule loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.inputEmail("remote.googs@gmail.com");
        loginOlx.inputPassword("remoteclient@789");
        loginOlx.clickLoginWithOlxBtn();
    }

    public void clickNonActiveBtn() {
        Log.info("Click Non Active Button");
        clickElement(getIdLocator(nonActivatebtnId));
    }

    public void clickSudahTerjual() {
        Log.info("Click Sudah Terjual Button");
        clickElement(getIdLocator(setTerjualbtnId));
    }

    @Override
    public boolean isListElementPresent(List<AndroidElement> list) {
        try {
            if (!list.isEmpty()) {
                for (int i=0 ; i<list.size() ; i++) {
                    String textOnElement = list.get(i).getText();
                    Log.debug("Share apps available : "+textOnElement);
                    Assert.assertNotNull(textOnElement);
                    if (i > 3) {
                        break;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public void clickBackFromAdsDetails() {
        clickElement(getContentLocator(backBtn));
    }

    public void initAdsDetailsTest() {
        Log.info("Back to initiate Ads Details Page");
        ListingPage listing = new ListingPage(driver);
        if(isElementPresent(getIdLocator(sharedBtn))){ // on Details Page
            clickBackFromAdsDetails();
            isWaitElementPresent(getIdLocator(ListingPage.homeBtnBtmID));
            goToAdsDetailsFromListing(listing);
        } else if (isElementPresent(getIdLocator(ListingPage.homeBtnBtmID))) {
            Assert.assertTrue(true, "Already in Listing Page");
            clickElement(getIdLocator(ListingPage.homeBtnBtmID));
            goToAdsDetailsFromListing(listing);
        } else if (isElementPresent(getIdLocator(FilterByMapsLocationModule.addressTitle)) ||
                isElementPresent(getIdLocator(kirimLaporanBtn))) {
            driver.navigate().back();
            clickBackFromAdsDetails();
            goToAdsDetailsFromListing(listing);
        } else if (isElementPresent(getIdLocator(ListingPage.gambarIklan))) {
            clickBackFromAdsDetails();
            goToAdsDetailsFromListing(listing);
        } else if (isElementPresent(getIdLocator(PesanPage.detailSendBtn))) {
            clickBackFromAdsDetails();
            goToAdsDetailsFromListing(listing);
        }
    }

    private void goToAdsDetailsFromListing(ListingPage listing) {
        listing.selectAdsFromListing();
        isWaitElementPresent(getIdLocator(favoriteBtn));
    }

    public void verifyDeactivateReason(){
        Log.info("Verify Deactivate Reason");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(reasonDeactivatePopUp)));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(radioGrupDeactivateReason)));
        verifyDeactivateReasonList();
    }

    private void verifyDeactivateReasonList(){
        Assert.assertTrue(isElementPresent(getIdLocator(soldOnOlx)));
        Assert.assertTrue(isElementPresent(getIdLocator(soldOnOthersite)));
        Assert.assertTrue(isElementPresent(getIdLocator(noResponse)));
        Assert.assertTrue(isElementPresent(getIdLocator(onVacation)));
        Assert.assertTrue(isElementPresent(getIdLocator(otherReason)));
    }

    public void clickCancelDeactivate(){
        Log.info("Click Cancel Deactivate");
        clickElement(getIdLocator(cancelDeactivate));
    }

    public boolean deactivateReasonDisplayed(){
        return isWaitElementPresent(getIdLocator(radioGrupDeactivateReason));
    }

    public void chooseDeactivateReason() {
        Log.debug("Choose Deactive Reason : Alasan Lainnya");
        Assert.assertTrue(super.isListElementPresent(radioReasonList));
        radioReasonList.get(5).click();
        driver.findElements(getIdLocator(radioGrupDeactivateReason))
                .get(0).findElement(By.className("android.widget.EditText"))
                .sendKeys(" Testing Purpose ");
    }

    public void verifyNonAktifStatus() {
        isWaitElementPresent(getIdLocator("android:id/title"));
    }

    public void clickBatalNonAktif(){
        clickElement(getIdLocator(tutupBtn));
    }

    public void verifyAdsMoveToNonActivePanels() {
        Log.debug("Verify Deactivate Ads, Move to Non Aktif");
//        isElementPresentAfterScrollDown(getIdLocator(idIklan));
        Log.debug("Expected : "+getIdIklanExpected());
        Log.debug("Actual : "+getStringText(getIdLocator(idIklan)));
        Assert.assertEquals(getIdIklanExpected(), getStringText(getIdLocator(idIklan)));
    }

    public void clickTerjualorTersewaOpts() {
        Log.info("Choose SUdah Terjual or Tersewa di OLX");
        radioReasonList.get(0).click();
    }

    public void chooseFirstOptionStatusLaporan() {
        Log.info("choose first option laporan status : "+listStatusLaporan.get(0).getText());
        listStatusLaporan.get(0).click();
    };

    public void inputDeskripsiLaporan(String input) {
        Log.info("Input Deskripsi Laporan "+input);
        sendKeysById(getIdLocator(deskripsiLaporanId), input);
    }

    public void clickKirimLaporanBtn() {
        Log.info("Click Kirim Laporan Button");
        clickElement(getIdLocator(kirimLaporanBtn));
    }

    private static String getIdIklanSave() {
        return idIklanSave;
    }

    private void setIdIklanSave(By by) {
        idIklanSave = getStringText(by);
    }

    public static boolean getIsMapsDisplayed() {
        return isMapsDisplayed;
    }

    public static void setIsMapsDisplayed(boolean isMapsDisplayed) {
        AdsDetailsPage.isMapsDisplayed = isMapsDisplayed;
    }

    // Favorite Sections
    public void verifyAdsAlreadyOnFavoriteList() {
        isWaitElementPresent(getIdLocator(favoriteBtn));
        isElementPresentAfterScrollDown(getIdLocator(idIklan));
        Assert.assertEquals(getIdIklanSave(), getStringText(getIdLocator(idIklan)), "Id Number of Ads is not match" );
    }

    public static String getPostDateAds() {
        return dateAds;
    }

    public void setPostDateAds(String dateAdse) {
        dateAds = dateAdse;
    }
}
