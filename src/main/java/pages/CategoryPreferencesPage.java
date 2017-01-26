package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by buddyarifin on 8/11/16.
 */
public class CategoryPreferencesPage extends BasePage {

    protected static final String relativeLayout = "android.widget.RelativeLayout";
    protected static final String linearLayout = "android.widget.LinearLayout";
    protected static final String titleListingText = "Pilih Kategori Favorit Kamu";
    protected static final String categoryListingID = "com.app.sulley/rvCategory";
    protected static final String cardViewID = "com.app.tokobagus.betterb:id/card_view";
    protected static final String categoryTitle = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    protected static final String buttonSimpanText = "SIMPAN";
    protected static final String buttonSkipID = "com.app.tokobagus.betterb:id/btnSkip";
    protected static final String checkIconID = "com.app.tokobagus.betterb:id/imgCheckbox";
    protected static final String errorMsgBarID = "com.app.tokobagus.betterb:id/snackbar_text";
    protected static final String okErrorMSG = "com.app.tokobagus.betterb:id/snackbar_action";
    protected static final String containerList = "com.app.tokobagus.betterb:id/rvCategory";
    public static String categoryChoosing;

    public CategoryPreferencesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
            @AndroidFindBy(id = cardViewID),
            @AndroidFindBy(className = relativeLayout)
    })
    protected List<AndroidElement> categoryList;

    @AndroidFindBys({
            @AndroidFindBy(id = cardViewID),
            @AndroidFindBy(className = relativeLayout),
            @AndroidFindBy(id = checkIconID)
    })
    protected List<AndroidElement> checkedList;

    @AndroidFindBys({
            @AndroidFindBy(id = containerList),
            @AndroidFindBy(id = categoryTitle)
    })
    protected List<AndroidElement> subCategory;

    @Step("Verify All Contents of Category View")
    public void verifyAllContentsOfCategoryPage() {
        verifyTitleListing();
        verifyCategoryListing();
        verifySimpanBtn();
    }

    @Step("Verify All Contents of Category View from Bottom Bar")
    public void verifyAllContentsOfCategoryViewPage() {
        verifyCategoryListing();
    }

    public void verifyTitleListing() {
        Log.info("Verify Title Category Page");
        Assert.assertTrue(isWaitElementPresent(getTextLocator(titleListingText)));
    }

    public void verifyCategoryListing() {
        Log.info("Verify Available Category on Listing");
        isWaitElementPresent(getIdLocator(cardViewID));
        Log.info("Category Available ["+categoryList.size()+"]: ");
        for (int i = 0 ; i < categoryList.size() ; i++) {
            String category = getCategoryTitle(i);
            Log.info("* " + category + " ");
            if (i >=2 && categoryList.size() >=2 ) {
                Log.info("...");
                break;
            }
            Assert.assertNotNull(category);
        }
    }

    public void verifySimpanBtn() {
        Log.info("Verify Simpan Button");
        try{
            if (!isElementPresent(getTextLocator(buttonSimpanText))) {
                ((AndroidDriver)driver).scrollTo("SIMPAN");
            }
        }catch (NoSuchElementException e){
            Log.debug("Element Simpan Button not display, need to Scroll");
        }
        Assert.assertTrue(isElementPresent(getTextLocator(buttonSimpanText)));
        ((AndroidDriver)driver).swipe(200, 200, 200, driver.manage().window().getSize().getHeight()-10, 10000);
    }

    public void clickBackBtn() {}

    public ListingPage clickSimpanBtn() {
        Log.info("Click SIMPAN Button");
        try{
            if (!isElementPresent(getTextLocator(buttonSimpanText))) {
                ((AndroidDriver)driver).scrollTo("SIMPAN");
            }
        }catch (NoSuchElementException e){
            Log.debug("Element Simpan Button not display, need to Scroll");
        }
        clickElement(getTextLocator(buttonSimpanText));
        return new ListingPage(driver);
    }

    public void clickSkipBtn() {
        Log.info("Click SKIP Button");
        waitForClickabilityOf(getIdLocator(buttonSkipID), 100);
        clickElement(getIdLocator(buttonSkipID));
    }

    public boolean verifySelectedCount(int expectedSize) {
        return checkedList.size() >= expectedSize;
    }

    public void resetSelectedCategory() {
        Log.info("Unset Selected Category");
        int counter = 0;
        for (int i = 0 ; i < categoryList.size() ; i++) {
            try {
                if(categoryList.get(i).findElementById(checkIconID).isDisplayed()) {
                    selectCategory(i);
                    counter++;
                    if (counter > 2) {
                        break;
                    }
                }
            }catch (NoSuchElementException e) {
                break;
            }
        }
    }

    public String getCategoryTitle(int index) {
        return categoryList.get(index).findElementById(categoryTitle).getText();
    }

    private void selectFirstSubCategory() {
        if ( !subCategory.isEmpty() ) {
            Log.info("Selected SUb Category : "+subCategory.get(0).getText());
            subCategory.get(0).click();
        }
    }

    public void selectCategory(int index) {
        categoryChoosing = getCategoryTitle(index);

        Log.info("Select Category "+getCategoryTitle(index));
        categoryList.get(index).findElementById(categoryTitle).click();

        selectFirstSubCategory();
    }

    public void selectedMoreThan3Category() {
        Log.debug("Already Checked : ");
        for (int i = 0 ; i < categoryList.size() ; i++) {
            try {
                if (categoryList.get(i).findElementById(checkIconID).isDisplayed()) {
                    Log.debug("- "+getCategoryTitle(i));
                }
            }catch (NoSuchElementException e) {
                selectCategory(i);
                verifyErrorMsgDisplay();
                break;
            }
        }
    }
    
    public void verifyErrorMsgDisplay() {
        Log.info("Verify Error Message Display");
        Assert.assertTrue(isElementPresent(getIdLocator(errorMsgBarID)));
        clickElement(getIdLocator(okErrorMSG));
    }

}
