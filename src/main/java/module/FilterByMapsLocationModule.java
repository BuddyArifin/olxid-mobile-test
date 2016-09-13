package module;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

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
    public static final String cancelChooseBtn = "com.app.tokobagus.betterb:id/imgClearIcon";
    public static final String expandDockBtn = "com.app.tokobagus.betterb:id/imgMinimize";
    public static final String sliderRadius = "";
    public static final String cariDiLokasiIniBtn = "";

    public void verifyBackBtn()
    {
        Log.info("Verify Back Button");
    }
    public void verifySearchField()
    {
        Log.info("Verify Search Fields");
    }
    public void verifyMyCurrentLocationBtn()
    {
        Log.info("Verify My Current Location Button");
    }
    public void verifyCancelChooseBtn()
    {
        Log.info("Verify Cancel Choose Button");
    }
    public void verifySliderRadius()
    {
        Log.info("Verify Slider Radius");
    }
    public void verifyCariDiLokasiIniBtn()
    {
        Log.info("Verify Cari Di Lokasi Ini Button");
    }

    @Step("Verify System Display Content in Filter Page")
    public void verifyAllContentInLocationPage()
    {
        verifyBackBtn();
        verifySearchField();
        verifyMyCurrentLocationBtn();
        verifyCancelChooseBtn();
        verifySliderRadius();
        verifyCariDiLokasiIniBtn();
        Log.info("Verify All Content in Filter Page");
    }

    public void inputKeywordInSearchFields(String input)
    {
        sendKeysById(getContentLocator(searchField), input);
        Log.info("Input Keyword in Search Fields");
    }

    public void clickMyCurrentLocationBtn()
    {
        Log.info("Click My Current Location Button");
    }

    public void clickCancelChooseBtn()
    {
        Log.info("Click Cancel Choose Button");
    }

    public void sliderLeftSliderRadius()
    {
        Log.info("Slide Left Direction Slider Radius");
    }

    public void slideRightSliderRadius()
    {
        Log.info("Slide Right Direction Slider Radius");
    }

    public void clickCariDiLokasiIniBtn()
    {
        Log.info("Click Cari Di Lokasi Ini Button");
    }
}
