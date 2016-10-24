package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
    protected static final String bannerInfo = "com.app.tokobagus.betterb:id/info_text";
    protected static final String bannerCloseBtn = "com.app.tokobagus.betterb:id/safety_info_close";
    protected static final String titleAds = "";
    protected static final String tipsAds = "com.app.tokobagus.betterb:id/info_text";
    protected static final String photoAds = "com.app.tokobagus.betterb:id/image";
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
    protected static final String sudahTerjualBtn = "";
    protected static final String nonActivateBtn = "";
    public static final String sharedBtn = "com.app.tokobagus.betterb:id/menu_share";
    public static final String lebihLanjutBtn = "com.app.tokobagus.betterb:id/safety_info_more";
    public static final String tutupBtn = "com.app.tokobagus.betterb:id/safety_info_close";

    @AndroidFindBys({
            @AndroidFindBy(id = photoAds)
    })
    protected List<AndroidElement> listPhoto;

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
        Assert.assertTrue(isElementPresent(getIdLocator(sharedBtn)));
    }
    public void verifyLebihLanjut(){
        Log.info("Verify Lebih Lanjut Button display");
        Assert.assertTrue(isElementPresent(getIdLocator(lebihLanjutBtn)));
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
        Assert.assertTrue(isElementPresent(getIdLocator(photoAds)));
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
    public void verifyPostDateAds(){
        Log.info("Verify Tanggal Pemasangan Iklan display");
        Assert.assertTrue(isElementPresent(getIdLocator(postDateAds)));
    }
    public void verifyConditionsAds(){
        Log.info("Verify Kondisi Barang pada Iklan display");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(conditionsAds)));
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
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(moreInfoBtn)));
        clickElement(getIdLocator(moreInfoBtn));
        Assert.assertTrue(isElementPresent(getIdLocator(descriptionsAds)));
    }
    public void verifyAvatarSeller(){
        Log.info("Verify Avatar Profile Picture display");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(avatarSeller)));
    }
    public void verifyMemberJoinDate(){
        Log.info("Verify Member Join Date display");
        Assert.assertTrue(isElementPresent(getIdLocator(memberJoinDate)));
    }
    public void verifyMemberRating(){
        Log.info("Verify Member Rating display");
    }
    public void verifyAdsLocations(){
        Log.info("Verify Lokasi Iklan dengan Maps");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(adsLocation)));
    }
    public void verifyidIklanNumber(){
        Log.info("Verify Iklan ID number");
        Assert.assertTrue(isElementPresentAfterScrollDown(getIdLocator(idIklan)));

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
    }
    public void verifyNonActiveBtn() {
        Log.info("Verify Non Active Button");
    }

    @Step("Verify All Contents of Details Page")
    public void verifyAllContensAdsDetails(){
        verifyBanner();
        verifyTitleAds();
        verifyShareBtn();
        verifyLebihLanjut();
        verifyTutupBtn();
        verifyTipsAds();
//        verifyPhotoAds();
        verifyPriceAds();
        verifyFavoriteBtn();
        verifyStatusAds();
        verifyPostDateAds();
        verifyConditionsAds();
        verifyPostYearsAds();
        verifyTransactionAds();
        verifyDescriptionAds();
        verifyMoreInfoAds();
        verifyAvatarSeller();
        verifyMemberJoinDate();
//        verifyMemberRating();
//        verifyAdsLocations();
//        verifyidIklanNumber();
        verifyLihatIklanAndTestimoni();
        verifyLaporkanIklan();
        verifyHubungiPenjual();
    }

    public void clickShareBtn() {
        swipePageTopToBtm();
        Log.info("Click SHARE Button");
        clickElement(getIdLocator(sharedBtn));
    }
    public void clickCloseBtn() {
        Log.info("Click Close Button, on Tips Transaksi Aman");
        clickElement(getIdLocator(tutupBtn));
    }
    public void clickInfoLebihLanjut() {
        Log.info("Click Info Lebih Lanjut link Button");
        Assert.assertTrue(isElementPresentAfterScrollUp(getIdLocator(lebihLanjutBtn)));
        clickElement(getIdLocator(lebihLanjutBtn));
    }
    public void clickFavoriteBtn() {
        Log.info("Click to Favorite Button, Add Ads to Favorite");
        clickElement(getIdLocator(favoriteBtn));
    }
    public void clickLihatIklanAndTestimoni() {
        isElementPresentAfterScrollDown(getTextLocator(lihatIklanAndTestimoni));
        Log.info("Click Lihat Iklan dan Testimoni");
        clickElement(getTextLocator(lihatIklanAndTestimoni));
    }
    public void clickLaporkanIklan() {
        Log.info("Click Laporkan Iklan");
        isElementPresentAfterScrollDown(getIdLocator(laporkanIklan));
        clickElement(getIdLocator(laporkanIklan));
    }
    public void clickAdsLocations() {
        Log.info("Click Ads Location Button");
        clickElement(getIdLocator(adsLocation));
    }
    public void clickMoreInfo() {
        Log.info("Click More Info Button, full description");
        clickElement(getIdLocator(moreInfoBtn));
    }
    public void clickHubugiPenjual() {
        isElementPresentAfterScrollDown(getIdLocator(hubungiPenjual));
        Log.info("Click Hubungi Penjual Button");
        clickElement(getIdLocator(hubungiPenjual));
    }
    public void clickNonActiveBtn() {
        Log.info("Click Non Active Button");
    }

    public void clickSudahTerjual() {
        Log.info("Click Sudah Terjual Button");
    }


}
