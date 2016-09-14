package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import module.FilterBySubCategory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.properties.utils.PropertiesUtils;
import utils.Log;

import java.util.List;

/**
 * Created by NugrohoSantoso on 9/2/16.
 */
public class FilterPage extends BasePage {
    public static final String backBtn = "Navigate up";
    public static final String searchField = "com.app.tokobagus.betterb:id/edtSearch";
    public static final String cancelBtn = "com.app.tokobagus.betterb:id/btnClearSearch";
    public static final String locationBtn = "com.app.tokobagus.betterb:id/btnOpenMap";
    public static final String myLocationBtn = "";
    public static final String terdekatRBtn = "com.app.tokobagus.betterb:id/rbNearest";
    public static final String terbaruRBtn = "com.app.tokobagus.betterb:id/rbNewest";
    public static final String termurahRBtn = "com.app.tokobagus.betterb:id/rbCheapest";
    public static final String termahalRBtn = "com.app.tokobagus.betterb:id/rbMostExpensive";
    public static final String ubahBtn = "com.app.tokobagus.betterb:id/btnChooseCategory";
    public static final String resetBtn = "com.app.tokobagus.betterb:id/btnReset";
    public static final String simpanBtn = "com.app.tokobagus.betterb:id/btnSearch";
    private FilterByMapsLocationModule filterByMapsLocationModule;
    private FilterBySubCategory filterBySubCategory;

    public FilterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    };

    @Step("Verify System Display Content in Filter Page")
    public void verifyAllContentOfFilterPage()
    {
        verifyBackButton();
        verifySearchField();
        verifyLocationButton();
        verifyMyLocationButton();
        verifyTerdekatRadioButton();
        verifyTerbaruRadioButton();
        verifyTermurahRadioButton();
        verifyTermahalRadioButton();
        verifyUbahButton();
        verifyResetButton();
        verifySimpanButton();
        Log.info("Verify All Content in Filter Page");
    }
    public void verifyBackButton()
    {
        Assert.assertTrue(isElementPresent(getContentLocator(backBtn)));
        Log.info("Verify Back Button");
    }
    public void verifySearchField()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(searchField)));
        Log.info("Verify Search Field");
    }
    public void verifyCancelButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(cancelBtn)));
        Log.info("Verify Cancel Button");
    }
    public void verifyLocationButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(locationBtn)));
        Log.info("Verify Location Button");
    }
    public void verifyMyLocationButton()
    {
        Log.info("Verify MyLocation Button");
    }
    public void verifyTerdekatRadioButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(terdekatRBtn)));
        Log.info("Verify Terdekat Radio Button");
    }
    public void verifyTerbaruRadioButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(terbaruRBtn)));
        Log.info("Verify Terbaru Radio Button");
    }
    public void verifyTermurahRadioButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(termurahRBtn)));
        Log.info("Verify Termurah Radio Button");
    }
    public void verifyTermahalRadioButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(termahalRBtn)));
        Log.info("Verify Termahal Radio Button");
    }
    public void verifyUbahButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(ubahBtn)));
        Log.info("Verify Ubah Button");
    }
    public void verifyResetButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(resetBtn)));
        Log.info("Verify Reset Button");
    }
    public void verifySimpanButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(simpanBtn)));
        Log.info("Verify Simpan Button");
    }

    public ListingPage clickBackBtn()
    {
        Log.info("Click Back Button");
        clickElement(getContentLocator(backBtn));
        return new ListingPage(driver);
    }

    public void clickSearchField()
    {
        Log.info("Click Search Field");
        clickElement(getIdLocator(searchField));
    }

    public void inputKeywordSearchField(String keyword)
    {
        Log.info("Input Keyword in Search Field : "+keyword);
        sendKeysById(getIdLocator(searchField), keyword);
    }

    public void clickCancelButtonSearchField()
    {
        Log.info("Click Cancel Button in Search Field");
        clickElement(getIdLocator(cancelBtn));
    }

    public void clickMyLocationButton()
    {
        Log.info("Click MyLocation Button");
    }

    public FilterByMapsLocationModule clickLocationButton()
    {
        Log.info("Click Location Button");
        clickElement(getIdLocator(locationBtn));
        return new FilterByMapsLocationModule(driver);
    }

    public void clickRadioButtonTerdekatInUrutkanColumn()
    {
        clickElement(getIdLocator(terdekatRBtn));
        Log.info("Click Terdekat Radio Button in Urutkan Column");
    }

    public void clickRadioButtonTerbaruInUrutkanColumn()
    {
        clickElement(getIdLocator(terbaruRBtn));
        Log.info("Click Terbaru Radio Button in Urutkan Column");
    }

    public void clickRadioButtonTermurahInUrutkanColumn()
    {
        clickElement(getIdLocator(termurahRBtn));
        Log.info("Click Termurah Radio Button in Urutkan Column");
    }

    public void clickRadioButtonTermahalInUrutkanColumn()
    {
        clickElement(getIdLocator(termahalRBtn));
        Log.info("Click Termahal Radio Button in Urutkan Column");
    }

    public FilterBySubCategory clickUbahButton()
    {
        Log.info("Click Ubah Button");
        clickElement(getIdLocator(ubahBtn));
        return new FilterBySubCategory(driver);
    }

    public void clickResetButton()
    {
        clickElement(getIdLocator(resetBtn));
        Log.info("Click Reset Button");
    }

    public void clickSimpanButton()
    {
        clickElement(getIdLocator(simpanBtn));
        Log.info("Click Simpan Button");
    }
}
