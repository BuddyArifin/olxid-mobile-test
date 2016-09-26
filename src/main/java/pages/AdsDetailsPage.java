package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by buddyarifin on 9/2/16.
 */
public class AdsDetailsPage extends BasePage {
    protected static final String titleAds = "";
    protected static final String shareBtn = "";
    protected static final String closeBtn = "";
    protected static final String tipsAds = "";
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

    public AdsDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTitleAds(){
        Log.info("Verify Detail Iklan Text");
    }
    public void verifyShareBtn(){
        Log.info("Verify Share Button display");
    }
    public void verifyCloseBtn(){
        Log.info("Verify Close Button display");
    }
    public void verifyTipsAds(){
        Log.info("Verify Tips Transaksi Aman");
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
        Assert.assertTrue(isElementPresent(getIdLocator(conditionsAds)));
    }
    public void verifyPostYearsAds(){
        Log.info("Verify Tahun dari Iklan display");
    }
    public void verifyTransactionAds(){
        Log.info("Verify Available Transaksi eg. Ketemuan");
    }
    public void verifyDescriptionAds(){
        Log.info("Verify Deskripsi Iklan display");
        Assert.assertTrue(isElementPresent(getIdLocator(descriptionsTitleAds)));
        Assert.assertTrue(isElementPresent(getIdLocator(descriptionsAds)));
    }
    public void verifyMoreInfoAds(){
        Log.info("Verify Lihat Selengkapnya pada deskripsi display");
        Assert.assertTrue(isElementPresent(getIdLocator(moreInfoBtn)));
    }
    public void verifyAvatarSeller(){
        Log.info("Verify Avatar Profile Picture display");
        Assert.assertTrue(isElementPresent(getIdLocator(avatarSeller)));
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
        Assert.assertTrue(isElementPresent(getIdLocator(adsLocation)));
    }
    public void verifyidIklanNumber(){
        Log.info("Verify Iklan ID number");
        Assert.assertTrue(isElementPresent(getIdLocator(idIklan)));
    }
    public void verifyLihatIklanAndTestimoni(){
        Log.info("Verify Lihat Iklan dan Testimoni");
        Assert.assertTrue(isElementPresent(getTextLocator(lihatIklanAndTestimoni)));
    }
    public void verifyLaporkanIklan(){
        Log.info("Verify Laporkan Iklan");
        Assert.assertTrue(isElementPresent(getIdLocator(laporkanIklan)));
    }
    public void verifyHubungiPenjual() {
        Log.info("Verify Hubungi penjual Button");
        Assert.assertTrue(isElementPresent(getIdLocator(hubungiPenjual)));
    }

    @Step("Verify All Contents of Details Page")
    public void verifyAllContensAdsDetails(){
        verifyTitleAds();
        verifyShareBtn();
        verifyCloseBtn();
        verifyTipsAds();
        verifyPhotoAds();
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
        verifyMemberRating();
        verifyAdsLocations();
        verifyidIklanNumber();
        verifyLihatIklanAndTestimoni();
        verifyLaporkanIklan();
        verifyHubungiPenjual();
    }

    public void clickShareBtn() {
        Log.info("Click SHARE Button");
    }
    public void clickCloseBtn() {
        Log.info("Click Close Button, on Tips Transaksi Aman");
    }
    public void clickInfoLebihLanjut() {
        Log.info("Click Info Lebih Lanjut link Button");
    }
    public void clickFavoriteBtn() {
        Log.info("Click to Favorite Button, Add Ads to Favorite");
        clickElement(getIdLocator(favoriteBtn));
    }
    public void clickLihatIklanAndTestimoni() {
        Log.info("Click Lihat Iklan dan Testimoni");
        clickElement(getTextLocator(lihatIklanAndTestimoni));
    }
    public void clickLaporkanIklan() {
        Log.info("Click Laporkan Iklan");
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
        Log.info("Click Hubungi Penjual Button");
        clickElement(getIdLocator(hubungiPenjual));
    }


}
