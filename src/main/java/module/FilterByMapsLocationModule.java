package module;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.jetty.html.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

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

    public static final String backBtn = "";
    public static final String searchField = "com.app.tokobagus.betterb:id/edtLocation";
    public static final String myCurrentLocationBtn = "com.app.tokobagus.betterb:id/btnDetectMyLocation";
    public static final String clearSearchBtn = "com.app.tokobagus.betterb:id/imgClearIcon";
    public static final String expandDockBtn = "com.app.tokobagus.betterb:id/imgMinimize";
    public static final String sliderRadius = "com.app.tokobagus.betterb:id/sbRadius";
    public static final String cariDiLokasiIniBtn = "com.app.tokobagus.betterb:id/btnSetLocation";
    public static final String suggestionTitle = "com.app.tokobagus.betterb:id/primaryText";
    public static final String listViewPlaces = "com.app.tokobagus.betterb:id/lvPlaces";
    public static final String linearLayoutPlaces = "android.widget.LinearLayout";

    @AndroidFindBys({
        @AndroidFindBy(id = listViewPlaces),
        @AndroidFindBy(className = linearLayoutPlaces)
    })
    protected List<AndroidElement> suggestionList;

    public void verifyBackBtn()
    {
        Log.info("Verify Back Button");
    }
    public void verifySearchField()
    {
        WaitForClickabilityOf(getIdLocator(searchField), 50);
        Assert.assertTrue(isElementPresent(getIdLocator(searchField)));
        Log.info("Verify Search Fields");
    }
    public void verifyMyCurrentLocationBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(myCurrentLocationBtn)));
        Log.info("Verify My Current Location Button");
    }
    public void verifyClearSearchBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(clearSearchBtn)));
        Log.info("Verify Cancel Choose Button");
    }
    public void verifyExpandDockBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(expandDockBtn)));
        Log.info("Verify Expand Dock Button");
    }
    public void verifySliderRadius()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(sliderRadius)));
        Log.info("Verify Slider Radius");
    }
    public void verifyCariDiLokasiIniBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(cariDiLokasiIniBtn)));
        Log.info("Verify Cari Di Lokasi Ini Button");
    }

    @Step("Verify System Display Content in Filter Page")
    public void verifyAllContentInLocationPage()
    {
        //verifyBackBtn();
        verifySearchField();
        verifyMyCurrentLocationBtn();
        verifyExpandDockBtn();
        verifySliderRadius();
        verifyCariDiLokasiIniBtn();
        Log.info("Verify All Content in Filter Page");
    }

    public void verifySuggestionListing(List<AndroidElement> elements)
    {
        int i;
        Log.info("Verify Available Category on Listing");
        isWaitElementPresent(getIdLocator(listViewPlaces));
        Log.info("Category Available ["+elements.size()+"]: ");
        for (i = 0 ; i < elements.size() ; i++) {
            String category = getSuggestionInfo(i, elements);
            Log.info("* " + category + " ");
            Assert.assertNotNull(category);
        }
    }

    public String getSuggestionInfo(int index, List<AndroidElement> elements)
    {
        return elements.get(index).findElementById(suggestionTitle).getText();
    }

    public void verifySuggestionList()
    {
        verifySuggestionListing(suggestionList);
        Log.info("Suggestion List Verified");
    }

    public void inputKeywordInSearchFields(String input)
    {
        sendKeysById(getContentLocator(searchField), input);
        Log.info("Input Keyword in Search Fields");
    }

    public void clickMyCurrentLocationBtn()
    {
        clickElement(getIdLocator(myCurrentLocationBtn));
        Log.info("Click My Current Location Button");
    }

    public void clickClearSearchBtn()
    {
        clickElement(getIdLocator(clearSearchBtn));
        Log.info("Click Cancel Choose Button");
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
        WebElement seek_bar = driver.findElement(getIdLocator(sliderRadius));
        int start = seek_bar.getLocation().getX();
        int end = seek_bar.getSize().getWidth();
        int y = seek_bar.getLocation().getY();
        TouchAction action = new TouchAction((MobileDriver)driver);
        //Move it 40%
        int moveTo=(int)(end*0.4);
        action.press(start,y).moveTo(moveTo,y).release().perform();
        Log.info("Slide Right Direction Slider Radius");
    }

    public void clickCariDiLokasiIniBtn()
    {
        clickElement(getIdLocator(cariDiLokasiIniBtn));
        Log.info("Click Cari Di Lokasi Ini Button");
    }
}
