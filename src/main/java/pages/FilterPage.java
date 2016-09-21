package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
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
    public static final String minPrice = "com.app.tokobagus.betterb:id/edtMinPrice";
    public static final String maxPrice = "com.app.tokobagus.betterb:id/edtMaxPrice";
    public static final String tipeKendaraanLayout = "Tipe kendaraan";
    public static final String transmisiLayout = "Transmisi";
    public static final String tahunLayout = "Tahun";
    public static final String luasTanahLayout = "Luas tanah";
    public static final String luasBangunanLayout = "Luas bangunan";
    public static final String lantaiLayout = "Lantai";
    public static final String kamarTidurLayout = "Kamar tidur";
    public static final String kamarMandiLayout = "Kamar mandi";
    public static final String sertifikasiLayout = "Sertifikasi";
    public static final String fasilitasLayout = "Fasilitas";
    public static final String alamatLokasiLayout = "Alamat lokasi";
    public static final String editTextAdditionalFilter = "android.widget.EditText";
    public static final String categoryTitle = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    public static final String relativeLayout = "android.widget.RelativeLayout";
    public static final String recycleViewCategory = "com.app.tokobagus.betterb:id/rvCategory";
    public static final String linearLayoutContainer = "com.app.tokobagus.betterb:id/layoutContainer";
    public static final String linearLayoutCategoryParams = "com.app.tokobagus.betterb:id/categoryParamsLayout";
    public static final String linearLayoutDropDownSelection = "android.widget.LinearLayout";
    public static final String textViewLayout = "com.app.tokobagus.betterb:id/btnSelection";
    public static final String recycleViewLayout = "com.app.tokobagus.betterb:id/md_contentRecyclerView";
    public static final String textViewDropDownSelectionTitle = "com.app.tokobagus.betterb:id/tvOptionName";
    public static final String pilihBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";

    private FilterByMapsLocationModule filterByMapsLocationModule;

    public FilterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    };

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
        @AndroidFindBy(id = linearLayoutCategoryParams),
        @AndroidFindBy(id = textViewLayout)
    })
    protected List<AndroidElement> dropDownListElement;

    @AndroidFindBys({
        @AndroidFindBy(id = recycleViewLayout),
        @AndroidFindBy(className =  linearLayoutDropDownSelection)
    })
    protected List<AndroidElement> checkBoxElement;

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
        return elements.get(index).findElementById(textViewDropDownSelectionTitle).getText();
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
        clickElement(getIdLocator(simpanBtn));
        Log.info("Click Simpan Button");
        return new ListingPage(driver);
    }

    public void clickSemuaDiMobilCategory()
    {
        categoryElement0.get(0).click();
        categoryElement1.get(0).click();
        Log.info("Click Semua Di Mobil");
    }

    public void clickMobilBekasHondaCategory()
    {
        String honda = "Honda";
        categoryElement0.get(0).click();
        verifySubCategory();
        categoryElement1.get(1).click();
        verifySubCategory1();
        ((AndroidDriver)driver).scrollToExact(honda);
        clickElement(getTextLocator(honda));
        Log.info("Click Mobil Bekas Honda");
    }

    public void clickPropertiRumahDijualCategory()
    {
        categoryElement0.get(2).click();
        verifySubCategory();
        categoryElement1.get(1).click();
        verifySubCategory1();
        categoryElement2.get(1).click();
        Log.info("Click Properti Category");
    }

    @Step("Verify Content in Additional Filter Properti Rumah Dijual")
    public void verifyContentInAdditionalFilterRumahDijual()
    {
        verifyMinPrice();
        verifyMaxPrice();
        verifyLuasTanah();
        verifyLuasBangunan();
        verifyLantai();
        verifyKamarTidur();
        verifyKamarMandi();
        verifySertifikasi();
        verifyFaslitas();
        verifyAlamatLokasi();
        Log.info("Verify Content in Additional Filter");
    }

    @Step("Verify Content in Additional Filter Semua Di Mobil")
    public void verifyContentInAdditionalFilterSemuaDiMobil()
    {
        verifyMinPrice();
        verifyMaxPrice();
        Log.info("Verify Content in Additional Filter Semua Di Mobil");
    }

    @Step("Verify Content in Additional Filter Mobil Bekas Honda")
    public void verifyContentInAdditionalFilterMobilBekasHonda()
    {
        verifyMinPrice();
        verifyMaxPrice();
        verifyTipeKendaraan();
        verifyTransmisi();
        verifyTahun();
        Log.info("Verify Content in Additional Filter Mobil Bekas Honda");
    }

    public void verifyMinPrice()
    {
        waitForVisibility(getIdLocator(minPrice));
        Assert.assertTrue(isElementPresent(getIdLocator(minPrice)));
        Log.info("Verify Minimum Price Edit Text");
    }
    public void verifyMaxPrice()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(maxPrice)));
        Log.info("Verify Maksimum Price Edit Text");
    }
    public void verifyTipeKendaraan()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(tipeKendaraanLayout)));
        Log.info("Verify Tipe Kendaraan");
    }
    public void verifyTransmisi()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(transmisiLayout)));
        Log.info("Verify Transmisi");
    }
    public void verifyTahun()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(tahunLayout)));
        Log.info("Verify Tahun");
    }
    public void verifyLuasTanah()
    {
        Assert.assertTrue(isElementPresent(getTextInputLayoutLocator(luasTanahLayout)));
        Log.info("Verify Luas Tanah");
    }
    public void verifyLuasBangunan()
    {
        swipePageBtmtToTop();
        Assert.assertTrue(isElementPresent(getTextInputLayoutLocator(luasBangunanLayout)));
        Log.info("Verify Luas Bangunan");
    }
    public void verifyLantai()
    {
        Assert.assertTrue(isElementPresent(getTextInputLayoutLocator(lantaiLayout)));
        Log.info("Verify Lantai");
    }
    public void verifyKamarTidur()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(kamarTidurLayout)));
        Log.info("Verify Kamar Tidur");
    }
    public void verifyKamarMandi()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(kamarMandiLayout)));
        Log.info("Verify Kamar Mandi");
    }
    public void verifySertifikasi()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(sertifikasiLayout)));
        Log.info("Verify Sertifikasi");
    }
    public void verifyFaslitas()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(fasilitasLayout)));
        Log.info("Verify Fasilitas");
    }
    public void verifyAlamatLokasi()
    {
        swipePageBtmtToTop();
        Assert.assertTrue(isElementPresent(getTextInputLayoutLocator(alamatLokasiLayout)));
        Log.info("Verify Alamat Lokasi");
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

    public void inputLuasTanah(String keyword)
    {
        clickElement(getTextInputLayoutLocator(luasTanahLayout));
        List<WebElement> list = getListElements(By.className("TextInputLayout"));
        list.get(0).findElement(By.className(editTextAdditionalFilter)).sendKeys(keyword);
        Log.info("Input Luas Tanah : " + keyword);
    }

    public void inputLuasBangunan(String keyword)
    {
        clickElement(getTextInputLayoutLocator(luasBangunanLayout));
        List<WebElement> list = getListElements(By.className("TextInputLayout"));
        list.get(1).findElement(By.className(editTextAdditionalFilter)).sendKeys(keyword);
        Log.info("Input Luas Bangunan : " + keyword);
    }

    public void inputLantai(String keyword)
    {
        clickElement(getTextInputLayoutLocator(lantaiLayout));
        List<WebElement> list = getListElements(By.className("TextInputLayout"));
        list.get(2).findElement(By.className(editTextAdditionalFilter)).sendKeys(keyword);
        Log.info("Input Lantai : " + keyword);
    }

    public void inputAlamatLokasi(String keyword)
    {
        clickElement(getTextInputLayoutLocator(alamatLokasiLayout));
        List<WebElement> list = getListElements(By.className("TextInputLayout"));
        list.get(3).findElement(By.className(editTextAdditionalFilter)).sendKeys(keyword);
        Log.info("Input Alamat Lokasi : " + keyword);
    }

    public void pilihKamarTidur()
    {
        swipePageBtmtToTop();
        String kamarTidur = "2";
        dropDownListElement.get(0).click();
        verifyCheckBoxElement(checkBoxElement);
        ((AndroidDriver)driver).scrollToExact(kamarTidur);
        clickElement(getTextLocator(kamarTidur));
        clickElement(getIdLocator(pilihBtn));
        Log.info("Pilih Kamar Tidur : 2");
    }

    public void pilihKamarMandi()
    {
        swipePageBtmtToTop();
        String kamarMandi = "2";
        dropDownListElement.get(1).click();
        verifyCheckBoxElement(checkBoxElement);
        ((AndroidDriver)driver).scrollToExact(kamarMandi);
        clickElement(getTextLocator(kamarMandi));
        clickElement(getIdLocator(pilihBtn));
        Log.info("Pilih Kamar Mandi : 2");
    }

    public void pilihSertifikasi()
    {
        String sertifikasi = "SHM - Sertifikat Hak Milik";
        dropDownListElement.get(2).click();
        verifyCheckBoxElement(checkBoxElement);
        ((AndroidDriver)driver).scrollToExact(sertifikasi);
        clickElement(getTextLocator(sertifikasi));
        clickElement(getIdLocator(pilihBtn));
        Log.info("Pilih Sertifikasi : SHM - Sertifikat Hak Milik");
    }

    public void pilihFasilitas()
    {
        String fasilitas = "AC";
        dropDownListElement.get(3).click();
        verifyCheckBoxElement(checkBoxElement);
        ((AndroidDriver)driver).scrollToExact(fasilitas);
        clickElement(getTextLocator(fasilitas));
        clickElement(getIdLocator(pilihBtn));
        Log.info("Pilih Fasilitas : AC");
    }

    public void pilihTipeKendaraanJazz()
    {
        swipePageBtmtToTop();
        String jazz = "Jazz";
        //Log.debug("Ini Loh Size nya = " + dropDownListElement.size());
        dropDownListElement.get(0).click();
        verifyCheckBoxElement(checkBoxElement);
        ((AndroidDriver)driver).scrollToExact(jazz);
        clickElement(getTextLocator(jazz));
        clickElement(getIdLocator(pilihBtn));
        Log.info("Pilih Tipe Kendaraan : Jazz");
    }

    public void pilihTipeTransmisi()
    {
        String manual = "Manual";
        dropDownListElement.get(1).click();
        verifyCheckBoxElement(checkBoxElement);
        clickElement(getTextLocator(manual));
        clickElement(getIdLocator(pilihBtn));
        Log.info("Pilih Tipe Transmisi : Manual");
    }

    public void pilihTahun()
    {
        String tahun = "2013";
        dropDownListElement.get(2).click();
        verifyCheckBoxElement(checkBoxElement);
        ((AndroidDriver)driver).scrollToExact(tahun);
        clickElement(getTextLocator(tahun));
        clickElement(getIdLocator(pilihBtn));
        Log.info("Pilih Tahun : Tahun 2013");
    }

    public void verifyTextLayout()
    {
        ((AndroidDriver)driver).scrollTo("Cari");
        List<WebElement> list = getListElements(By.className("TextInputLayout"));
        for (int i = 0; i < list.size(); i++)
        {
            //list.get(i).findElement(By.className("android.widget.EditText"));
            Log.info("Verify "+list.get(i).findElement(By.className("android.widget.EditText")).getText());
        }

    }

    public void inputMethod(int i, String text)
    {
        //((AndroidDriver)driver).scrollTo("Alamat lokasi");
        List<WebElement> list = getListElements(By.className("TextInputLayout"));
//        Log.debug("Isi dari element ini list ini : "+list.size());
//        for (int j  = 0; j < list.size(); j++)
//        {
//            Log.debug("Isi urutan ["+j+"] "+list.get(j).getText());
//            list.get(j).findElement(By.className("android.widget.EditText")).sendKeys("ini Urutan : "+j);
//        }
        list.get(i).findElement(By.className(editTextAdditionalFilter)).sendKeys(text);
    }
}
