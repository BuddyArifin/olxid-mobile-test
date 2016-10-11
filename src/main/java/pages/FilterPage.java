package pages;

import com.google.common.base.Function;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by NugrohoSantoso on 9/2/16.
 */
public class FilterPage extends BasePage {
    public static final String backBtn = "Navigate up";
    public static final String searchField = "com.app.tokobagus.betterb:id/edtSearch";
    public static final String cancelBtn = "com.app.tokobagus.betterb:id/btnClearSearch";
    public static final String locationBtn = "com.app.tokobagus.betterb:id/imgGpsIcon";
    public static final String myLocationBtn = "";
    public static final String terdekatRBtn = "com.app.tokobagus.betterb:id/rbNearest";
    public static final String terbaruRBtn = "com.app.tokobagus.betterb:id/rbNewest";
    public static final String termurahRBtn = "com.app.tokobagus.betterb:id/rbCheapest";
    public static final String termahalRBtn = "com.app.tokobagus.betterb:id/rbMostExpensive";
    public static final String ubahBtn = "com.app.tokobagus.betterb:id/btnChooseCategory";
    public static final String resetBtn = "com.app.tokobagus.betterb:id/btnReset";
    public static final String simpanBtn = "com.app.tokobagus.betterb:id/btnSearch";
    public static final String minPrice = "com.app.tokobagus.betterb:id/edtMinPrice";
    public static final String maxPrice = "com.app.tokobagus.betterb:id/edtMaxPrice";
    public static final String luasTanahLayout = "Luas tanah";
    public static final String luasBangunanLayout = "Luas bangunan";
    public static final String lantaiLayout = "Lantai";
    public static final String alamatLokasiLayout = "Alamat lokasi";
    public static final String editTextAdditionalFilter = "android.widget.EditText";
    public static final String categoryTitle = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    public static final String relativeLayout = "android.widget.RelativeLayout";
    public static final String recycleViewCategory = "com.app.tokobagus.betterb:id/rvCategory";
    public static final String linearLayoutContainer = "com.app.tokobagus.betterb:id/layoutContainer";
    public static final String linearLayoutCategoryParams = "com.app.tokobagus.betterb:id/categoryParamsLayout";
    public static final String textViewParamsTitle = "com.app.tokobagus.betterb:id/tvTitle";
    public static final String linearLayoutDropDownSelection = "android.widget.LinearLayout";
    public static final String textViewClass = "TextInputLayout";
    public static final String textViewLayout = "com.app.tokobagus.betterb:id/btnSelection";
    public static final String recycleViewLayout = "com.app.tokobagus.betterb:id/md_contentRecyclerView";
    public static final String textViewCheckBoxId = "com.app.tokobagus.betterb:id/tvOptionName";
    public static final String pilihBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public static final String actionBar = "com.app.tokobagus.betterb:id/action_bar";
    public static final String imageButtonBack = "android.widget.ImageButton";
    public boolean isOldVersionDevices = false;

    private FilterByMapsLocationModule filterByMapsLocationModule;

    public FilterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    };

    @AndroidFindBys({
        @AndroidFindBy(id = actionBar),
        @AndroidFindBy(className = imageButtonBack)
    })
    protected List<AndroidElement> backBtnTopPrm;

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewCategory),
        @AndroidFindBy(id = linearLayoutContainer)
    })
    protected List<AndroidElement> categoryElement0;

    @AndroidFindBys({
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(id = recycleViewCategory),
        @AndroidFindBy(id = linearLayoutContainer)
    })
    protected List<AndroidElement> categoryElement1;

    @AndroidFindBys({
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(className = relativeLayout),
        @AndroidFindBy(id = recycleViewCategory),
        @AndroidFindBy(id = linearLayoutContainer)
    })
    protected List<AndroidElement> categoryElement2;

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewCategory),
        @AndroidFindBy(id = categoryTitle)
    })
    protected List<AndroidElement> subCategoryTitle;

    @AndroidFindBys({
        @AndroidFindBy(id = linearLayoutCategoryParams),
        @AndroidFindBy(id = textViewLayout)
    })
    protected List<AndroidElement> dropDownListElement;

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewLayout),
        @AndroidFindBy(className =  linearLayoutDropDownSelection)
    })
    protected List<AndroidElement> checkBoxElement;

    @AndroidFindBys({
        @AndroidFindBy(id = linearLayoutCategoryParams),
        @AndroidFindBy(className = textViewClass)
    })
    protected List<AndroidElement> additionalFilterInput;

    @AndroidFindBys({
        @AndroidFindBy(className = textViewClass),
        @AndroidFindBy(className = editTextAdditionalFilter)
    })
    protected List<AndroidElement> editInputList;

    @AndroidFindBys({
        @AndroidFindBy(id = "com.app.tokobagus.betterb:id/inputLayout"),
        @AndroidFindBy(className = editTextAdditionalFilter)
    })
    protected List<AndroidElement> editInputListOldVersion;

    @AndroidFindBys({
        @AndroidFindBy(className = textViewClass)
    })
    protected List<AndroidElement> inputList;

    @AndroidFindBys({
        @AndroidFindBy(id = linearLayoutCategoryParams),
        @AndroidFindBy(id = textViewParamsTitle)
    })
    protected List<AndroidElement> textViewDropDownTitle;

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewLayout),
        @AndroidFindBy(id = textViewCheckBoxId)
    })
    protected List<AndroidElement> textViewCheckBoxTitle;

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
    /**
     * Mas Buddy baiknya method2 dibawah ini dihapus atau tidak?
     *
    public void verifyAllCategory(){
        verifyCategoryListingElement1(categoryElement0);
    }
    public void verifySubCategory(){
        verifyCategoryListingElement1(categoryElement1);
    }
    public void verifySubCategory1(){
        verifyCategoryListingElement1(categoryElement2);
    }
    public void verifyCategoryListingElement1(List<AndroidElement> elements)
    {
        Log.info("Verify Available Category on Listing");
        isWaitElementPresent(getIdLocator(recycleViewCategory));

        Log.info("Category Available ["+elements.size()+"]: ");
        for (int i = 0 ; i < elements.size() ; i++) {

            String category = getCategoryTitle(i, elements);
            Log.info("* " + category + " ");
            Assert.assertNotNull(category);
            if (i >=2 && elements.size() >=2 ) {
                Log.info("... ");
                break;
            }
        }
    }
     public String getCategoryTitle(int index, List<AndroidElement> elements)
     {
     return elements.get(index).findElementById(categoryTitle).getText();
     }
     */

    /**
     * This below method has made with 2 function
     * 1. to Verify Size of a ListElement
     * 2. Click the Index of a ListElement
     */
    public void verifyListElementMethodAndClickElement(String layoutClass, List<AndroidElement> parentElements, List<AndroidElement> childElements, String comparisonWord)
    {
        isWaitElementPresent(getIdLocator(layoutClass));
        String elementValueText = "";
        Log.info("Category Available ["+parentElements.size()+"]: ");
        for (int i = 0 ; i < parentElements.size() ; i++) {
            elementValueText = childElements.get(i).getText();
            if (parentElements.size() >= 2 && elementValueText.equalsIgnoreCase(comparisonWord)) {
                parentElements.get(i).click();
                Log.info("Click Element Index : " + i + ", ValueText : " + elementValueText);
                break;
            }
        }
    }
    public void verifyCheckBoxElement(List<AndroidElement> elements)
    {
        Log.info("Verify Available Category on Listing");
        isWaitElementPresent(getIdLocator(recycleViewLayout));
        Log.info("Category Available ["+elements.size()+"]: ");
        for (int i = 0 ; i < elements.size() ; i++) {
            String checkBox = getCheckBoxTitle(i, elements);
            Log.debug("Isi urutan ["+i+"] "+elements.get(i).getText());
            Log.info("* " + checkBox + " ");
            Assert.assertNotNull(checkBox);
            if (i >=2 && elements.size() >=2 ) {
                Log.info("... ");
                break;
            }
        }
    }
    public String getCheckBoxTitle(int index, List<AndroidElement> elements)
    {
        return elements.get(index).findElementById(textViewCheckBoxId).getText();
    }
    public ListingPage clickBackBtn()
    {
        Log.info("Click Back Button");
        backBtnTopPrm.get(0).click();
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

    public void clickUbahButton()
    {
        Log.info("Click Ubah Button");
        clickElement(getIdLocator(ubahBtn));
    }

    public void clickResetButton()
    {
        swipePageBtmtToTop();
        swipePageBtmtToTop();
        clickElement(getIdLocator(resetBtn));
        Log.info("Click Reset Button");
    }

    public ListingPage clickSimpanButton()
    {
        swipePageBtmtToTop();
        swipePageBtmtToTop();
        clickElement(getIdLocator(simpanBtn));
        Log.info("Click Simpan Button");
        return new ListingPage(driver);
    }

    public void clickSemuaDiMobilCategory()
    {
        String mobil = "Mobil";
        String semuaDiMobil = "Semua di Mobil";
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, mobil);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, semuaDiMobil);
        Log.info("Click Semua Di Mobil Sub-Category");
    }

    public void clickMobilBekasHondaCategory()
    {
        String mobil = "Mobil";
        String mobilBekas = "Mobil Bekas";
        String honda = "Honda";
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, mobil);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, mobilBekas);
        ((AndroidDriver)driver).scrollToExact(honda);
        clickElement(getTextLocator(honda));
        Log.info("Click Mobil Bekas Honda Sub-Category");
    }

    public void clickPropertiRumahDijualCategory()
    {
        String properti = "Properti";
        String rumah = "Rumah";
        String dijual = "Dijual";
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement0, subCategoryTitle, properti);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement1, subCategoryTitle, rumah);
        verifyListElementMethodAndClickElement(recycleViewCategory, categoryElement2, subCategoryTitle, dijual);
        Log.info("Click Properti Rumah Di Jual Sub-Category");
    }

    @Step("Verify Content Additional Filter in Selected Sub-Category")
    public void verifyContentAdditionalFilterInSelectedSubCategory()
    {
        isListElementPresent(additionalFilterInput);
        Log.info("Verify Content Additional Filter in Selected Sub-Category");
    }

    public void inputMinPrice(String keyword)
    {
        sendKeysById(getIdLocator(minPrice), keyword);
        Log.info("Input Minimum Harga");
    }

    public void inputMaxPrice(String keyword)
    {
        sendKeysById(getIdLocator(maxPrice), keyword);
        Log.info("Input Maksimum Harga");
    }

    //handle old version of Android
    public List<WebElement> isTextInputLayoutDisplays() {
        if (isListElementPresent(inputList)){
            return getListElements(By.className("TextInputLayout"));
        } else {
            isOldVersionDevices = true;
            return getListElements(By.id("com.app.tokobagus.betterb:id/inputLayout"));
        }
    }

    //handle old version of Android
    public List<AndroidElement> isTextEditLayoutDisplays() {
        if (isOldVersionDevices){
            return editInputListOldVersion;
        } else {
            return editInputList;
        }
    }

    /**
     * Adopt method from BasePage
     * */
    public Boolean isElementPresentAfterScroll(String locator) {
        String classname;
        if (isOldVersionDevices) {
            classname = "android.widget.LinearLayout";
        } else {
            classname = "TextInputLayout";
        }
        final String classFinal = classname;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                ((AndroidDriver)driver).swipe(200, 300, 200, 45, 500);
                return driver.findElement(By.xpath("//"+classFinal+"[@text='"+locator+"']")).isDisplayed();
            }
        });
    }

    /**
     * This below method has made to input Keyword in ListElement with class TextInputLayout at AdditionalFilter
     */
    public void inputMethod(String comparisonWord, String inputText) {
        List<WebElement> parentElement = isTextInputLayoutDisplays();
        List<AndroidElement> childElement2 = isTextEditLayoutDisplays();
        String parentValueText = "";
        for (int i = 0; i < childElement2.size(); i++)
        {
            parentValueText = parentElement.get(i).getText();
            Log.info("Parent Element Index : ["+i+"], Value Text : " + parentValueText);
            if (parentValueText.equalsIgnoreCase(comparisonWord)) {
                childElement2.get(i).replaceValue(inputText);
                break;
            }
            Log.info("This is Index from EditInput "+ parentValueText + " = " + i);
        }
        Log.info("Input " + parentValueText + " : " + inputText);
    }

    public void inputLuasTanah(String keyword)
    {
        inputMethod(luasTanahLayout, keyword);
    }

    public void inputLuasBangunan(String keyword)
    {
        isElementPresentAfterScroll(luasBangunanLayout);
        inputMethod(luasBangunanLayout, keyword);
    }

    public void inputLantai(String keyword)
    {
        isElementPresentAfterScroll(lantaiLayout);
        inputMethod(lantaiLayout, keyword);
    }

    public void inputAlamatLokasi(String keyword)
    {
        isElementPresentAfterScroll(alamatLokasiLayout);
        inputMethod(alamatLokasiLayout, keyword);
    }

    public void pilihTipeKendaraan(String inputText)
    {
        swipePageBtmtToTop();
        String tipeKendaraanLayout = "Tipe kendaraan";
        verifyListElementMethodAndClickElement(linearLayoutCategoryParams, dropDownListElement, textViewDropDownTitle, tipeKendaraanLayout);
        clickCheckBoxElement(inputText,recycleViewLayout,textViewCheckBoxTitle);
        clickElement(getIdLocator(pilihBtn));
    }

    public void pilihTransmisi(String inputText)
    {
        String transmisiLayout = "Transmisi";
        verifyListElementMethodAndClickElement(linearLayoutCategoryParams, dropDownListElement, textViewDropDownTitle, transmisiLayout);
        clickCheckBoxElement(inputText,recycleViewLayout,textViewCheckBoxTitle);
        clickElement(getIdLocator(pilihBtn));
    }

    public void pilihTahun(String inputText)
    {
        String tahunLayout = "Tahun";
        verifyListElementMethodAndClickElement(linearLayoutCategoryParams, dropDownListElement, textViewDropDownTitle, tahunLayout);
        clickCheckBoxElement(inputText,recycleViewLayout,textViewCheckBoxTitle);
        clickElement(getIdLocator(pilihBtn));
    }

    public void pilihKamarTidur(String inputText)
    {
        swipePageBtmtToTop();
        String kamarTidurLayout = "Kamar tidur";
        verifyListElementMethodAndClickElement(linearLayoutCategoryParams, dropDownListElement, textViewDropDownTitle, kamarTidurLayout);
        clickCheckBoxElement(inputText,recycleViewLayout,textViewCheckBoxTitle);
        clickElement(getIdLocator(pilihBtn));
    }

    public void pilihKamarMandi(String inputText)
    {
        swipePageBtmtToTop();
        String kamarMandiLayout = "Kamar mandi";
        verifyListElementMethodAndClickElement(linearLayoutCategoryParams, dropDownListElement, textViewDropDownTitle, kamarMandiLayout);
        clickCheckBoxElement(inputText,recycleViewLayout,textViewCheckBoxTitle);
        clickElement(getIdLocator(pilihBtn));
    }

    public void pilihSertifikasi(String inputText)
    {
        String sertifikasiLayout = "Sertifikasi";
        verifyListElementMethodAndClickElement(linearLayoutCategoryParams, dropDownListElement, textViewDropDownTitle, sertifikasiLayout);
        clickCheckBoxElement(inputText,recycleViewLayout,textViewCheckBoxTitle);
        clickElement(getIdLocator(pilihBtn));
    }


    public void pilihFasilitas(String inputText)
    {
        String fasilitasLayout = "Fasilitas";
        verifyListElementMethodAndClickElement(linearLayoutCategoryParams, dropDownListElement, textViewDropDownTitle, fasilitasLayout);
        clickCheckBoxElement(inputText,recycleViewLayout,textViewCheckBoxTitle);
        clickElement(getIdLocator(pilihBtn));
    }

    /**
     * This below method has made for swipe from bottom to top your Active Layout
     */
    public void swipeActiveLayoutBtmToTop(String activeLayoutId)
    {
        WebElement activeLayout = driver.findElement(getIdLocator(activeLayoutId));
        int upperHeight = activeLayout.getLocation().getY();
        int middleHeight = activeLayout.getSize().getHeight() / 2;
        int bottomHeight = activeLayout.getSize().getHeight() - upperHeight;
        int leftWidth = activeLayout.getLocation().getX();
        int middleWidth = activeLayout.getSize().getWidth() / 2;
        int rightWidth = activeLayout.getSize().getWidth();
        ((AndroidDriver)driver).swipe(middleWidth, bottomHeight, middleWidth, upperHeight, 500);
    }

    /**
     * This below method has made that can click several selection checkbox with several selection inputText
     * the method can scroll automatically if needed
     */
    public void clickCheckBoxElement(String inputText, String activeLayoutId, List<AndroidElement> childElement)
    {
        List<String> listString = new ArrayList<String>(Arrays.asList(inputText.split("/")));
        Collections.sort(listString);
        String parentElementValue = "";
        String splitTextPart = "";
        for(int i = 0; i < childElement.size(); i++)
        {
            parentElementValue = childElement.get(i).getText();
            if(listString.size() == 0)
            {
                break;
            }
            else
            {
                for(int j = 0; j < listString.size(); j++)
                {
                    splitTextPart = listString.get(j);
                    if (parentElementValue.equalsIgnoreCase(splitTextPart))
                    {
                        listString.remove(splitTextPart);
                        childElement.get(i).click();
                    }
                    else if (i == childElement.size() - 1 && listString.size() > 0)
                    {
                        swipeActiveLayoutBtmToTop(activeLayoutId);
                        i = 0;
                    }
                }
            }
        }



//        for (int i = 0; i <= parentElement.size(); i++)
//        {
//            if (i == parentElement.size()) {
//                swipeActiveLayoutBtmToTop(activeLayoutId);
//                i = 0;
//            }
//            else
//            {
//                parentElementValue = childElement.get(i).getText();
//                if (listString.size() > 0) {
//                    for (int j = 0; j < listString.size(); j++) {
//                        splitTextPart = listString.get(j);
//                        if (parentElementValue.equalsIgnoreCase(splitTextPart)) {
//                            parentElement.get(i).click();
//                            Log.info("Click : " + splitTextPart);
//                            listString.remove(splitTextPart);
////                            Log.info("Sekarang Size dari string Array : " + listString.size());
////                            break;
//                        }
//                    }
//                }
//                else
//                {
//                    clickElement(getIdLocator(acceptBtnId));
//                    break;
//                }
//            }
//        }
    }


}
