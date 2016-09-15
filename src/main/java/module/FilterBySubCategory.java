package module;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
public class FilterBySubCategory extends BasePage {

    public static final String minPrice = "";
    public static final String maxPrice = "";
    public static final String categoryTitle = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    public static final String relativeLayout = "android.widget.RelativeLayout";
    public static final String linearLayout1 = "android.widget.LinearLayout";
    public static final String recycleViewCategory = "com.app.tokobagus.betterb:id/rvCategory";
    public static final String linearLayout = "com.app.tokobagus.betterb:id/layoutContainer";
    public static final String mobilCategory = "Mobil";
    public static final String semuaDiMobilCategory = "Semua di Mobil";
    public static final String mobilBekasCategory = "Mobil Bekas";
    public static final String hondaCategory = "Honda";
    public static final String propertiCategory = "";

    public FilterBySubCategory(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewCategory),
        @AndroidFindBy(id = linearLayout)
    })
    protected List<AndroidElement> categoryElement0;

    @AndroidFindBys({
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(id = recycleViewCategory),
        @AndroidFindBy(id = linearLayout)
    })
    protected List<AndroidElement> categoryElement1;

    @AndroidFindBys({
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(id = recycleViewCategory),
        @AndroidFindBy(id = linearLayout)
    })
    protected List<AndroidElement> categoryElement2;

    public void verifyAllCategory(){
       verifyCategoryListingElement1(categoryElement0);
    }

    public void verifySubCategory(){
        verifyCategoryListingElement1(categoryElement1);
    }

    public void verifySubCategory1(){
        verifyCategoryListingElement1(categoryElement2);
    }

    public void verifyCategoryListingElement1(List<AndroidElement> elements) {
        int i;
        Log.info("Verify Available Category on Listing");
        isWaitElementPresent(getIdLocator(recycleViewCategory));
        Log.info("Category Available ["+elements.size()+"]: ");
        for (i = 0 ; i < elements.size() ; i++) {
            String category = getCategoryTitle(i, elements);
            Log.info("* " + category + " ");
            Assert.assertNotNull(category);
        }
    }

    public String getCategoryTitle(int index, List<AndroidElement> elements) {
        return elements.get(index).findElementById(categoryTitle).getText();
    }

    public void clickMobilCategory()
    {
        Log.info("Click Mobil Category");
        clickElement(getTextLocator(mobilCategory));
    }

    public void clickSemuaDiMobilCategory()
    {
        Log.info("Click Semua Di Mobil Category");
        clickElement(getTextLocator(semuaDiMobilCategory));
    }

    public void clickMobilBekasCategory()
    {
        Log.info("Click Mobil Bekas Category");
        clickElement(getTextLocator(mobilBekasCategory));
    }

    @Step("Verify Content in Additional Filter")
    public void verifyContentInAdditionalFilter()
    {
        Log.info("Verify Content in Additional Filter");
    }
}
