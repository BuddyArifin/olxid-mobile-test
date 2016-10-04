package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import module.HamburgerBarModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by buddyarifin on 8/24/16.
 */
public class ListingPage extends BasePage{

    public static final String hamburgerBar = "android.widget.ImageButton";
    public static final String titlePage = "Sulley";
    public static final String searchBtnPrmID = "com.app.tokobagus.betterb:id/search_item";
    public static final String filterBtnPrmID = "com.app.tokobagus.betterb:id/filter_item";
    public static final String jarakDariKamuBtnID = "com.app.tokobagus.betterb:id/distance";
    public static final String locationAllowAccessBtn = "com.android.packageinstaller:id/permission_allow_button";
    public static final String gambarIklan = "com.app.tokobagus.betterb:id/iv_ad_item_image";
    public static final String hargaIklan = "com.app.tokobagus.betterb:id/tv_ad_item_price";
    public static final String homeBtnBtmID = "com.app.tokobagus.betterb:id/tab_listing";
    public static final String kategoriBtnBtmID = "com.app.tokobagus.betterb:id/tab_category";
    public static final String jualBtnBtmID = "com.app.tokobagus.betterb:id/tab_postad";
    public static final String pesanBtnBtmID = "com.app.tokobagus.betterb:id/tab_Messages";
    public static final String pesanNotif = "";
    public static final String favoritBtnBtmId = "com.app.tokobagus.betterb:id/tab_Favorite";
    public static final String btmBarId = "com.app.tokobagus.betterb:id/bb_bottom_bar_item_container";
    public static final String toolBarPrimaryId = "com.app.tokobagus.betterb:id/toolbar";
    public static final String FILTER = "Filter";
    public static final String adsId = "com.app.tokobagus.betterb:id/iv_ad_item_image";

    public static final String gpsAlertTitle = "GPS belum dihidupkan";
    public static final String gpsAlertDesc = "Mohon hidupkan fitur GPS untuk mencari iklan terdekat";
    public static final String gpsActiveBtn = "com.app.tokobagus.betterb:id/ok_button";
    public static final String gpsCancelPopup = "com.app.tokobagus.betterb:id/cancel_button";
    public static final String switchOnGPS = "com.android.settings:id/switch_widget";

    public ListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
            @AndroidFindBy(id = toolBarPrimaryId),
            @AndroidFindBy(className = hamburgerBar)
    })
    protected List<AndroidElement> hamburgerBarLayout;

    @AndroidFindBys({
            @AndroidFindBy(id = adsId)
    })
    protected List<AndroidElement> adsList;

    @Step("Verify All Contents of ListingPage")
    public void verifyContentsOfListingPage()
    {
        Log.info("Verify All Contents of ListingPage");
        isAutoAcept(getIdLocator(locationAllowAccessBtn));
        verifyHamburgerBar();
        verifyTitlePage();
        verifySearchBtnPrm();
        verifyFilterBtnPrm();
        verifyJarakDariKamuBtnBtm();
        verifyGambarIklan();
        verifyHargaIklan();
        verifyHomeBtnBtm();
        verifyKategoriBtnBtm();
        verifyJualBtnBtm();
        verifyPesanBtnBtm();
        verifyPesanNotif();
        verifyFavoritBtnBtm();
    }

    public void verifyHamburgerBar()
    {
        Assert.assertTrue(isListElementPresent(hamburgerBarLayout));
        Log.info("Verify Hamburger Bar");
    }
    public void verifyTitlePage()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(titlePage)));
        Log.info("Verify Title Page");
    }
    public void verifySearchBtnPrm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(searchBtnPrmID)));
        Log.info("Verify Search Button");
    }
    public void verifyFilterBtnPrm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(filterBtnPrmID)));
        Log.info("Verify Filter Button");
    }
    public void verifyJarakDariKamuBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(jarakDariKamuBtnID)));
        Log.info("Verify Jarak Dari Kamu Button");
    }
    public void verifyGambarIklan()
    {
        WaitForClickabilityOf(getIdLocator(gambarIklan), 100);
        Assert.assertTrue(isElementPresent(getIdLocator(gambarIklan)));
        Log.info("Verify Gambar Iklan");
    }
    public void verifyHargaIklan()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(hargaIklan)));
        Log.info("Verify Harga Iklan");
    }
    public void verifyHomeBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(homeBtnBtmID)));
        Log.info("Verify Home Button");
    }
    public void verifyKategoriBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(kategoriBtnBtmID)));
        Log.info("Verify Kategori Button");
    }
    public void verifyJualBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(jualBtnBtmID)));
        Log.info("Verify Jual Button");
    }
    public void verifyPesanBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(pesanBtnBtmID)));
        Log.info("Verify Pesan Button");
    }
    public void verifyPesanNotif()
    {
        Log.info("Verify Pesan Notif");
    }

    public void verifyFavoritBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(favoritBtnBtmId)));
        Log.info("Verify Favorit Button");
    }

    public void verifyGpsNonActiveAlertTitle()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(gpsAlertTitle)));
        Log.info("Verify GPS non Active Title");
    }

    public void verifyGpsNonActiveAlertDesc()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(gpsAlertDesc)));
        Log.info("Verify GPS non Active Desc");
    }

    public void verifyGpsActiveBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(gpsActiveBtn)));
        Log.info("Verify GPS Activeted Button");
    }

    public void verifyGpsCancelBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(gpsCancelPopup)));
        Log.info("Verify GPS Activeted Button");
    }

    public HamburgerBarModule clickHamburgerBar()
    {
        Log.info("Click Hamburger Bar");
        hamburgerBarLayout.get(0).click();
        return new HamburgerBarModule(driver);
    }

    public void clickSearchBtnPrm()
    {
        clickElement(getIdLocator(searchBtnPrmID));
        Log.info("Click Search Button");
    }

    public FilterPage clickFilterBtnPrm()
    {
        Log.info("Click Filter Button");
        clickElement(getContentDescLocator(FILTER));
        return new FilterPage(driver);
    }

    public FilterByMapsLocationModule clickJarakDariKamuBtn()
    {
        Log.info("Click Jarak Dari Kamu Button");
        clickElement(getIdLocator(jarakDariKamuBtnID));
        return new FilterByMapsLocationModule(driver);
    }

    public KategoriPage clickKategoriBtnBtm()
    {
        Log.info("Click Kategori Bottom Bar Button");
        clickElement(getIdLocator(kategoriBtnBtmID));
        return new KategoriPage(driver);
    }

    public PostAdsPage clickJualBtnBtm()
    {
        Log.info("Click Jual Bottom Bar Button");
        clickElement(getIdLocator(jualBtnBtmID));
        return new PostAdsPage(driver);
    }

    public ListingPage clickGPSCancelBtn()
    {
        Log.info("Click Tidak Sekarang Button");
        clickElement(getIdLocator(gpsCancelPopup));
        return new ListingPage(driver);
    }

    public void clickGPSActiveBtn()
    {
        Log.info("Click Tidak Sekarang Button");
        clickElement(getIdLocator(gpsActiveBtn));
    }

    public void verifyBtmBarDissappear()
    {
        Log.info("Verify Bottom Bar Dissapear as User Scrolling Down");
        swipePageBtmtToTop();
        Assert.assertFalse(isElementPresent(getIdLocator(btmBarId)));
    }

    public void verifyBtmBarAppear()
    {
        Log.info("Verify Bottom Bar Appear as User Scrolling Up");
        swipePageTopToBtm();
        Assert.assertTrue(isElementPresent(getIdLocator(btmBarId)));
    }

    public AdsDetailsPage selectAdsFromListing() {
        Log.info("Select Ads From Listing");
        adsList.get(0).click();
        return new AdsDetailsPage(driver);
    }

    @Override
    public void swipePageTopToBtm() {
        int starty = (int) (driver.manage().window().getSize().getHeight() * 0.004);
        int endy = (int) (driver.manage().window().getSize().getHeight() * 0.95);
        int startx = driver.manage().window().getSize().getWidth() / 2;
        ((AndroidDriver)driver).swipe(startx, starty, startx, endy, 700);
    }

    public void turnOffGPS() {
        Log.info("Turn Off GPS");
        swipePageTopToBtm();
        swipePageTopToBtm();
        clickElement(getTextLocator("Location"));
        swipePageBtmtToTop();
        swipePageBtmtToTop();
        String currentActivity = ((AndroidDriver)driver).currentActivity();
        ((AndroidDriver)driver).closeApp();
        ((AndroidDriver)driver).startActivity("com.app.tokobagus.betterb",
                currentActivity);
    }

    public void turnOnGPS() {
        Log.info("Turn On GPS");
        String currentActivity = ((AndroidDriver)driver).currentActivity();
        ((AndroidDriver)driver).closeApp();
        ((AndroidDriver)driver).startActivity("com.app.tokobagus.betterb",
                currentActivity);
        clickElement(getIdLocator(gpsActiveBtn));
        clickElement(getIdLocator(switchOnGPS));
        ((AndroidDriver)driver).startActivity("com.app.tokobagus.betterb",
                currentActivity);
    }

    @Step("Verify All Content of GPS alert non active")
    public void verifyGPSAlertDisplay() {
        verifyGpsAlertImage();
        verifyGpsNonActiveAlertTitle();
        verifyGpsNonActiveAlertDesc();
        verifyGpsActiveBtn();
        verifyGpsCancelBtn();
    }

    public void verifyGpsAlertImage() {
        Log.info("Verify Logo of Alert Pop Up");
        Assert.assertTrue(isWaitElementPresent(getImageViewLocator(0)));
    }
}
