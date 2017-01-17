package module;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.FilterPage;
import pages.ListingPage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
public class FilterByMapsLocationModule extends BasePage {
    public FilterByMapsLocationModule(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String backBtn = "com.app.tokobagus.betterb:id/imageView_arrow_back";
    public static final String cobaKembaliBtnMaps = "com.app.tokobagus.betterb:id/btnRetryGetLocation";
    public static final String searchField = "com.app.tokobagus.betterb:id/searchEditText_input";
    public static final String autoSuggest = "com.app.tokobagus.betterb:id/primaryText";
    public static final String autoSuggestFound = "com.app.tokobagus.betterb:id/secondaryText";
    public static final String myCurrentLocationBtn = "com.app.tokobagus.betterb:id/btnDetectMyLocation";
    public static final String eraseSearchBtn = "com.app.tokobagus.betterb:id/imgClearIcon";
    public static final String expandDockBtn = "com.app.tokobagus.betterb:id/imgMinimize";
    public static final String addressTitle = "com.app.tokobagus.betterb:id/tvPlaceName";
    public static final String jarakIklanMax = "com.app.tokobagus.betterb:id/tvMaxDistanceTitle";
    public static final String sliderRadius = "com.app.tokobagus.betterb:id/sbRadius";
    public static final String cariDiLokasiIniBtn = "com.app.tokobagus.betterb:id/btnSetLocation";
    public static final String baloonGmaps = "Lokasi saat ini.";
    public static final String listView = "com.app.tokobagus.betterb:id/recyclerView_result";
    public static final String gpsAlertTitle = "GPS belum dihidupkan";
    public static final String gpsAlertDesc = "Mohon hidupkan fitur GPS untuk mencari iklan terdekat";
    public static final String gpsActiveBtn = "com.app.tokobagus.betterb:id/ok_button";
    public static final String gpsCancelPopup = "com.app.tokobagus.betterb:id/cancel_button";
    public static final String switchOnGPS = "com.android.settings:id/switch_widget";
    public String locationText = "";
    public boolean isClickedBy;

    /**
     * Pilih Kota Maps, Locator
     * */
    public static final String pilihKotaBtnId = "com.app.tokobagus.betterb:id/tvSelectCity";
    public static final String regionTitleId = "com.app.tokobagus.betterb:id/tvRegionTitle";

    @AndroidFindBys({
            @AndroidFindBy(id = listView),
            @AndroidFindBy(id = autoSuggest)
    })
    private List<AndroidElement> suggestionFoundList;

    @AndroidFindBys({
            @AndroidFindBy(id = listView),
            @AndroidFindBy(id = autoSuggestFound)
    })
    private List<AndroidElement> suggestionAddressList;

    @AndroidFindBys({
            @AndroidFindBy(id = regionTitleId)
    })
    private List<AndroidElement> listKotaAll;

    public void verifyBackBtn()
    {
        Log.info("Verify Back Button");

    }
    public void verifySearchField()
    {
        Log.info("Verify Search Fields");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(searchField)),
                "Search Field Maps Not found");
    }
    public void verifyMyCurrentLocationBtn()
    {
        Log.info("Verify My Current Location Button");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(myCurrentLocationBtn)),
                "Current Location Button Not found");
    }
    public void verifyClearSearchBtn()
    {
        Log.info("Verify Cancel Choose Button");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(eraseSearchBtn)));
    }
    public void verifyExpandDockBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(expandDockBtn)));
        Log.info("Verify Expand Dock Button");
    }
    public void verifySliderRadius()
    {
        Log.info("Verify Slider Radius");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(sliderRadius)),
                "Slider Radius Maps Not found");
    }
    public void verifyCariDiLokasiIniBtn()
    {
        Log.info("Verify Cari Di Lokasi Ini Button");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(cariDiLokasiIniBtn)),
                "Button 'Cari Di Lokasi ini' not found");
    }
    public void verifyGoogleBaloon()
    {
        Log.info("Verify google baloon displays");
        Assert.assertTrue(isWaitElementPresent(getAndroidViewTextLocator(baloonGmaps)));
    }
    public void verifyCurrentLocationAddress()
    {
        Log.info("Verify Current Location Address");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(addressTitle)),
                "Address Title Maps Not found");
    }
    public void verifyJarakIklanTitle() {
        Log.info("Verify Jarak Iklan Maximum Text");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(jarakIklanMax)),
                "Jarak Iklan Title Maps Not found");
    }

    public void verifyGpsNonActiveAlertTitle()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(gpsAlertTitle)),
                "GPS title Alert Maps Not found");
        Log.info("Verify GPS non Active Title");
    }

    public void verifyGpsNonActiveAlertDesc()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(gpsAlertDesc)),
                "GPS Descriptions Maps Not found");
        Log.info("Verify GPS non Active Desc");
    }

    public void verifyGpsActiveBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(gpsActiveBtn)),
                "GPS Active Button Maps Not found");
        Log.info("Verify GPS Activeted Button");
    }

    public void verifyGpsCancelBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(gpsCancelPopup)),
                "GPS Cancel Button Maps Not found");
        Log.info("Verify GPS Activeted Button");
    }

    @Step("Verify System Display Content in Filter Page")
    public void verifyAllContentInLocationPage()
    {
        isWaitElementPresent(getIdLocator(sliderRadius));
        dismissTutorial();
        verifySearchField();
        verifyMyCurrentLocationBtn();
        verifyCurrentLocationAddress();
        verifyJarakIklanTitle();
        verifySliderRadius();
        verifyCariDiLokasiIniBtn();
        Log.info("Verify All Content in Filter Page");
    }

    public void verifySuggestions() {
        Log.info("Available Suggestions ["+suggestionFoundList.size()+"] :");
        isWaitElementPresent(getIdLocator(autoSuggest));
        Assert.assertTrue(isListElementPresent(suggestionFoundList),
                "Suggestion After input keyword not displayed");
    }

    public void chooseSuggestion(int index) {
        Assert.assertTrue(isListElementPresent(suggestionAddressList));
        Log.info("User choose : "+suggestionFoundList.get(index).getText());
        suggestionFoundList.get(index).click();
        WaitFor(1);
    }

    public void inputKeywordInSearchFields(String input)
    {
        sendKeysById(getIdLocator(searchField), input);
        Log.info("Input Keyword in Search Fields");
    }

    public void clickMyCurrentLocationBtn()
    {
        Log.info("Click My Current Location Button");
        clickElement(getIdLocator(myCurrentLocationBtn));
    }

    public void clickClearSearchBtn()
    {
        Log.info("Click Cancel Choose Button");
        clickElement(getIdLocator(eraseSearchBtn));
    }

    public void clickFirstIndexSuggestion()
    {
        Log.info("Click First Index Suggestion");
    }

    public void sliderLeftSliderRadius()
    {

        Log.info("Slide Left Direction Slider Radius");
    }

    public void slideRightSliderRadius()
    {
        Log.info("Slide Right Direction Slider Radius");
        boolean isSliderVisible = isWaitElementPresent(getIdLocator(sliderRadius));

        if (isSliderVisible) {
            Point seek_bar = getPointLocation(getIdLocator(sliderRadius));
            Dimension dimension_seekBar = getDimesionElement(getIdLocator(sliderRadius));

            int start = seek_bar.getX();
            int end = dimension_seekBar.getWidth();
            int y = seek_bar.getY();

            TouchAction action = new TouchAction((MobileDriver) driver);
            //Move it 40%
            int moveTo=(int)(end*0.4);
            action.longPress(start,y).moveTo(moveTo,y).release().perform();
            locationText = getStringText(getIdLocator(addressTitle));
        }
        else {
            Assert.assertTrue(false, " Sliders not found/visible ");
        }
    }

    public void clickSearchField() {
        clickElement(getIdLocator(searchField));
    }

    public BasePage clickCariDiLokasiIniBtn()
    {
        Log.info("Click Cari Di Lokasi Ini Button");
        clickElement(getIdLocator(cariDiLokasiIniBtn));
        return new ListingPage(driver);
    }

    public void openedTrayLocation() {
        Log.info("Expand Location Tray Menus");
        clickElement(getIdLocator(addressTitle));
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

    public FilterByMapsLocationModule clickGPSCancelBtn()
    {
        Log.info("Click Tidak Sekarang Button");
        clickElement(getIdLocator(gpsCancelPopup));
        return new FilterByMapsLocationModule(driver);
    }

    public void verifyGpsAlertImage() {
        Log.info("Verify Logo of Alert Pop Up");
        Assert.assertTrue(isWaitElementPresent(getImageViewLocator(0)));
    }

    @Step("Verify All Content of GPS alert non active")
    public void verifyGPSAlertDisplay() {
        verifyGpsAlertImage();
        verifyGpsNonActiveAlertTitle();
        verifyGpsNonActiveAlertDesc();
        verifyGpsActiveBtn();
        verifyGpsCancelBtn();
    }

    public void dismissTutorial() {
        if (isEnvTestProduction()) {
            isWaitElementPresent(getIdLocator(sliderRadius));
            if (!checkTutorialsColors(getIdLocator(searchField))) {
                clickBySize(getPointLocation(getIdLocator(myCurrentLocationBtn)));
                clickBySize(getPointLocation(getIdLocator(sliderRadius)));
                Log.info("Dismiss This Tutorial");
            }
        }
    }

    public FilterPage clickBackButtonFromMaps(){
        Log.info("Click Back Button From Filter Maps");
        clickElement(getIdLocator(backBtn));
        return new FilterPage(driver);
    }

    public boolean isMapsFilterPage(){
      return isWaitElementPresent(getIdLocator(searchField));
    }

    public void clickTutorialBala()
    {
        if (isClickedBy)
        {
            clickBySize(getPointLocation(getIdLocator(myCurrentLocationBtn)));
            clickBySize(getPointLocation(getIdLocator(sliderRadius)));
        }
    }

    public void clickPilihKota() {
        Log.info("Click Pilih Kota Tab");
        clickElement(getIdLocator(pilihKotaBtnId));
    }

    public void chooseCityList(String city) {
        Log.info("Choose Kota");
        List<String> listKota = new ArrayList<>(Arrays.asList(city.split("/")));
        Collections.sort(listKota);

        listKota.forEach( kota -> {
            selectCityByKeyword(kota);
        });
    }

    public void selectCityByKeyword(String keywords) {
        listKotaAll.forEach(listKotaAll -> {
            if (listKotaAll.getText().equalsIgnoreCase(keywords)){
                listKotaAll.click();
            }
        });
    }
}
