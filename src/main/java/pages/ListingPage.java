package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import module.HamburgerBarModule;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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

    public static final String hamburgerBar = "Navigate up";
    public static final String titlePage = "OLX";
    public static final String searchBtnPrmID = "com.app.tokobagus.betterb:id/search_item";
    public static final String filterBtnPrmID = "com.app.tokobagus.betterb:id/filter_item";
    public static final String jarakDariKamuBtnID = "com.app.tokobagus.betterb:id/distance";
    public static final String permissionAllowAccessBtn = "com.android.packageinstaller:id/permission_allow_button";
    public static final String gambarIklan = "com.app.tokobagus.betterb:id/iv_ad_item_image";
    public static final String hargaIklan = "com.app.tokobagus.betterb:id/tv_ad_item_price";
    public static final String homeBtnBtmID = "com.app.tokobagus.betterb:id/tab_listing";
    public static final String kategoriBtnBtmID = "com.app.tokobagus.betterb:id/tab_category";
    public static final String jualBtnBtmID = "com.app.tokobagus.betterb:id/tab_post_ad";
    public static final String pesanBtnBtmID = "com.app.tokobagus.betterb:id/tab_message";
    public static final String pesanNotif = "";
    public static final String favoritBtnBtmId = "com.app.tokobagus.betterb:id/tab_favorite";
    public static final String btmBarId = "com.app.tokobagus.betterb:id/bb_bottom_bar_item_container";
    public static final String toolBarPrimaryId = "com.app.tokobagus.betterb:id/toolbar";
    public static final String adsId = "com.app.tokobagus.betterb:id/iv_ad_item_image";

    public static final String gpsAlertTitle = "GPS belum dihidupkan";
    public static final String gpsAlertDesc = "Mohon hidupkan fitur GPS untuk mencari iklan terdekat";
    public static final String gpsActiveBtn = "com.app.tokobagus.betterb:id/ok_button";
    public static final String gpsCancelPopup = "com.app.tokobagus.betterb:id/cancel_button";
    public static final String switchOnGPS = "com.android.settings:id/switch_widget";
    public static final String searchByKeyword = "com.app.tokobagus.betterb:id/searchEditText_input";
    public static final String backBtnSearchKeyword = "com.app.tokobagus.betterb:id/imageView_arrow_back";
    public static final String suggesstionSearchlist = "com.app.tokobagus.betterb:id/recyclerView_result";
    public static final String suggesstionSearchKeyword = "com.app.tokobagus.betterb:id/tvKeyword";
    public static final String suggesstionSemuaDiKategory = "com.app.tokobagus.betterb:id/tvCategoryName";
    public static final String disagreeButton = "android:id/button2";
    public boolean isClickedBy;
    public boolean lalala;
    public static final String filterTitle = "Filter";
    public static final String jarakMaks = "com.app.tokobagus.betterb:id/tvMaxDistanceTitle";

    public ListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        isAutoAcept(getIdLocator(batalKonfirmasiPopUp)); // handle Beta Marketing Pop up
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

    @AndroidFindBys({
            @AndroidFindBy(id = suggesstionSearchlist),
            @AndroidFindBy(id = suggesstionSearchKeyword)
    })
    protected List<AndroidElement> suggestList;

    @AndroidFindBy(id = suggesstionSemuaDiKategory)
    protected AndroidElement semuaDiKategory;

    @Step("Verify All Contents of ListingPage")
    public void verifyContentsOfListingPage()
    {
        Log.info("Verify All Contents of ListingPage");
        verifyandSkipTutorialElements();
        verifyHamburgerBar();
//        verifyTitlePage();
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
        Assert.assertTrue(isWaitElementPresent(getContentLocator(hamburgerBar)));
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
        //WaitForClickabilityOf(getIdLocator(gambarIklan), 100);
        // Assert.assertTrue(isWaitElementPresent(getIdLocator(gambarIklan)),"Image Listing Is Not Available"); // disabled until not found ads image or text, created
        Log.info("Verify Gambar Iklan");
    }
    public void verifyHargaIklan()
    {
//        Assert.assertTrue(isElementPresent(getIdLocator(hargaIklan)),"Price Listing Is Not Available"); // disabled until not found ads image or text, created
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

    public void verifySuggestionList()
    {
        Log.info("Verify Suggestion List after tapping keyword");
        isWaitElementPresent(getIdLocator(suggesstionSemuaDiKategory));
        Assert.assertTrue(isListElementPresent(suggestList));
    }

    public HamburgerBarModule clickHamburgerBar()
    {
        Log.info("Click Hamburger Bar");
        clickElement(getContentLocator(hamburgerBar));
        return new HamburgerBarModule(driver);
    }

    public void clickSearchBtnPrm()
    {
        Log.info("Click Search Button");
        isWaitElementPresent(getIdLocator(searchBtnPrmID));
        clickElement(getIdLocator(searchBtnPrmID));
    }

    public void inputSearchKeyword(String keyword){
        sendKeysById(getIdLocator(searchByKeyword), keyword);
    }

    public void clickSuggestions() {
        Log.info("Click Suggestion from Keyword");
        semuaDiKategory.click();
        verifyJarakDariKamuBtnBtm();
    }

    public FilterPage clickFilterBtnPrm()
    {
        Log.info("Click Filter Button");
        clickElement(getIdLocator(filterBtnPrmID));
        return new FilterPage(driver);
    }

    public FilterByMapsLocationModule clickJarakDariKamuBtn()
    {
        Log.info("Click Jarak Dari Kamu Button");
        clickElement(getIdLocator(jarakDariKamuBtnID));
        return new FilterByMapsLocationModule(driver);
    }

    public CategoryPreferencesPage clickKategoriBtnBtm()
    {
        Log.info("Click Kategori Bottom Bar Button");
        clickElement(getIdLocator(kategoriBtnBtmID));
        return new CategoryPreferencesPage(driver);
    }

    public PostAdsPage clickJualBtnBtm()
    {
        Log.info("Click Jual Bottom Bar Button");
        clickElement(getIdLocator(jualBtnBtmID));
        isAutoAcept(getIdLocator(permissionAllowAccessBtn));
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
        super.swipePageBtmtToTop();
        super.swipePageBtmtToTop();
        super.swipePageBtmtToTop();
        Assert.assertFalse(isWaitElementPresent(getIdLocator(btmBarId)));
    }

    public void verifyBtmBarAppear()
    {
        Log.info("Verify Bottom Bar Appear as User Scrolling Up");
        super.swipePageTopToBtm();
        Assert.assertTrue(isElementPresent(getIdLocator(btmBarId)));
    }

    public void verifyLocationsChanged(String text){
        Log.info("Verify Locations Changed to "+text);
        Assert.assertTrue(getStringText(getIdLocator(jarakDariKamuBtnID)).contains(text));
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

    @Override
    public void swipePageBtmtToTop(){
        int starty = (int) (driver.manage().window().getSize().getHeight() * 0.95);
        int endy = (int) (driver.manage().window().getSize().getHeight() * 0.004);
        int startx = driver.manage().window().getSize().getWidth() / 2;
        ((AndroidDriver)driver).swipe(startx, starty, startx, endy, 700);
    }

    public void turnOffGPS() {
        Log.info("Turn Off GPS");
        ((AndroidDriver)driver).toggleLocationServices();
        ((AndroidDriver)driver).startActivity(Constants.appPackage,
                Constants.appActivity);
    }

    public void turnOnGPS() {
        Log.info("Turn On GPS");
        ((AndroidDriver)driver).toggleLocationServices();
        isAutoAcept(getIdLocator(disagreeButton));
        ((AndroidDriver)driver).startActivity(Constants.appPackage,
                Constants.appActivity);
    }

    @Step("Verify All Content of GPS alert non active")
    public void verifyGPSAlertDisplay() {
        verifyGpsAlertImage();
        verifyGpsNonActiveAlertTitle();
        verifyGpsNonActiveAlertDesc();
        verifyGpsActiveBtn();
        verifyGpsCancelBtn();
    }

    @Override
    public boolean isAutoAcept(By by) {
        try
        {
            WaitForClickabilityOf(by, 20);
            if (waitForVisibility(by)) {
                clickElement(by);
                return true;
            }
            else {
                return true;
            }
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            return true;
        }
    }

    public void verifyGpsAlertImage() {
        Log.info("Verify Logo of Alert Pop Up");
        Assert.assertTrue(isWaitElementPresent(getImageViewLocator(0)));
    }

    public void verifyandSkipTutorialElements(){
        if (!checkTutorialsColors(getIdLocator(jarakDariKamuBtnID))) {
            clickBySize(getPointLocation(getIdLocator(filterBtnPrmID)));
            clickBySize(getPointLocation(getIdLocator(jarakDariKamuBtnID)));
            clickBySize(getPointLocation(getIdLocator(jualBtnBtmID)));
        }
    }

    public boolean isListingButton(){
        return isWaitElementPresent(getIdLocator(homeBtnBtmID));
    }

    public void clickBackDevice(){ driver.navigate().back(); }

    public FavoritePage clickFavoritBtmBtn(){
        clickElement(getIdLocator(favoritBtnBtmId));
        return new FavoritePage(driver);
    }

    public boolean isOnFilterPage(){ return isWaitElementPresent(getTextLocator(filterTitle));}

    public boolean isOnSearchPosition(){ return isWaitElementPresent(getIdLocator(searchByKeyword));}

    public void clickBackOnSearchAndMaps(){ clickElement(getIdLocator(backBtnSearchKeyword));}

    public boolean isOnMapsPage(){ return isWaitElementPresent(getIdLocator(jarakMaks));}

    public void initialListingPage(){
        HamburgerBarModule hamburgerBarModule = new HamburgerBarModule(driver);
        if(isListingButton()){
            Assert.assertTrue(true, "Already in Listing Page");
        }else if(hamburgerBarModule.isHamburgerBar()){
            clickFavoritBtmBtn();
        }else if(isOnFilterPage()){
            clickBackDevice();
        }else if(isOnSearchPosition() || isOnMapsPage()){
            clickBackOnSearchAndMaps();
        }
    }
}
