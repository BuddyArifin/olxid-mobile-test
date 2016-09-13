package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.FilterByMapsLocationModule;
import module.HamburgerBarModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
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

    public ListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Click Allow Access Google Location Button ")
    public void clickAllowAccessLocationButton() {
        isAutoAcept(getIdLocator(locationAllowAccessBtn));
        Log.info("Click Allow Access Location Button");
    }

    @Step("Verify All Contents of ListingPage")
    public void verifyContentsOfListingPage()
    {
        Log.info("Verify All Contents of ListingPage");
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

    @Step("Verify Hamburger Bar")
    public void verifyHamburgerBar()
    {
        WaitForClickabilityOf(getContentLocator(hamburgerBar), 40);
        Assert.assertTrue(isWaitElementPresent(getContentLocator(hamburgerBar)));
        Log.info("Verify Hamburger Bar");
    }

    @Step("Verify Title Page")
    public void verifyTitlePage()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(titlePage)));
        Log.info("Verify Title Page");
    }

    @Step("Verify Search Button")
    public void verifySearchBtnPrm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(searchBtnPrmID)));
        Log.info("Verify Search Button");
    }

    @Step("Verify Filter Button")
    public void verifyFilterBtnPrm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(filterBtnPrmID)));
        Log.info("Verify Filter Button");
    }

    @Step("Verify Jarak Dari Kamu Button")
    public void verifyJarakDariKamuBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(jarakDariKamuBtnID)));
        Log.info("Verify Jarak Dari Kamu Button");
    }

    @Step("Verify Gambar Iklan")
    public void verifyGambarIklan()
    {
        WaitForClickabilityOf(getIdLocator(gambarIklan), 100);
        Assert.assertTrue(isElementPresent(getIdLocator(gambarIklan)));
        Log.info("Verify Gambar Iklan");
    }

    @Step("Verify Harga Iklan")
    public void verifyHargaIklan()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(hargaIklan)));
        Log.info("Verify Harga Iklan");
    }

    @Step("Verify Home Button")
    public void verifyHomeBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(homeBtnBtmID)));
        Log.info("Verify Home Button");
    }

    @Step("Verify Kategori Button")
    public void verifyKategoriBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(kategoriBtnBtmID)));
        Log.info("Verify Kategori Button");
    }

    @Step("Verify Jual Button")
    public void verifyJualBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(jualBtnBtmID)));
        Log.info("Verify Jual Button");
    }

    @Step("Verify Pesan Button")
    public void verifyPesanBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(pesanBtnBtmID)));
        Log.info("Verify Pesan Button");
    }

    @Step("Verify Pesan Notif")
    public void verifyPesanNotif()
    {
        Log.info("Verify Pesan Notif");
    }

    @Step("Verify Favorit Button")
    public void verifyFavoritBtnBtm()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(favoritBtnBtmId)));
        Log.info("Verify Favorit Button");
    }

    @Step("Click Hamburger Primary Bar Bar")
    public HamburgerBarModule clickHamburgerBar()
    {
        Log.info("Click Hamburger Bar");
        clickElement(getIdLocator(hamburgerBar));
        return new HamburgerBarModule(driver);
    }

    @Step("Click Search Primary Bar Button")
    public void clickSearchBtnPrm()
    {
        clickElement(getIdLocator(searchBtnPrmID));
        Log.info("Click Search Button");
    }

    @Step("Click Filter Primary Bar Button")
    public FilterPage clickFilterBtnPrm()
    {
        Log.info("Click Filter Button");
        clickElement(getIdLocator(filterBtnPrmID));
        return new FilterPage(driver);
    }

    @Step("Click Jarak Dari Kamu Button")
    public FilterByMapsLocationModule clickJarakDariKamuBtn()
    {
        Log.info("Click Jarak Dari Kamu Button");
        clickElement(getIdLocator(jarakDariKamuBtnID));
        return new FilterByMapsLocationModule(driver);
    }

    @Step("Click Kategori Bottom Bar Button")
    public KategoriPage clickKategoriBtnBtm()
    {
        Log.info("Click Kategori Bottom Bar Button");
        clickElement(getIdLocator(kategoriBtnBtmID));
        return new KategoriPage(driver);
    }

    @Step("Click Jual Bottom Bar Button")
    public PostAdsPage clickJualBtnBtm()
    {
        Log.info("Click Jual Bottom Bar Button");
        clickElement(getIdLocator(jualBtnBtmID));
        return new PostAdsPage(driver);
    }
}
