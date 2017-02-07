package pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.HamburgerBarModule;
import module.SaldoOlxModule;
import org.apache.xpath.operations.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Log;

import java.util.List;

/**
 * Created by sekarayu on 2/1/17.
 */
public class BeliKuotaPage extends BasePage {

    public BeliKuotaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String slotIklanHabisTitle = "Slot Iklan Habis";
    public static final String slotIklanDesc = "com.app.tokobagus.betterb:id/paywallTvInfo";
    public static final String slotIklanOptionTitle = "com.app.tokobagus.betterb:id/paywallTvTitle";
    public static final String slotIklanBeliBtn = "com.app.tokobagus.betterb:id/paywallBtnBuy";

    public static final String beliSlotIklanTitle = "Beli Slot Iklan";
    public static final String backBtn = "Navigate up";
    public static final String beliSlotIklanKategoriTtl = "com.app.tokobagus.betterb:id/tvCategory";
    public static final String beliSlotIklanKategoriOpt = "com.app.tokobagus.betterb:id/btnCategory";
    public static final String pilihKategoriTtl = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    public static final String rvCategory = "com.app.tokobagus.betterb:id/rvCategory";
    public static final String layoutContainer = "com.app.tokobagus.betterb:id/layoutContainer";
    public static final String beliSlotIklanLokasiTtl = "com.app.tokobagus.betterb:id/tvLocation";
    public static final String beliSlotIklanLokasiOpt = "com.app.tokobagus.betterb:id/locationButton";
    public static final String pilihLokasiTtl = "com.app.tokobagus.betterb:id/tvLocationTitle";
    public static final String rvLocation = "com.app.tokobagus.betterb:id/rvLocation";
    public static final String hargaSlotIklanContent = "com.app.tokobagus.betterb:id/tvPaywallPriceContainer";
    public static final String rvPaywallOpt = "com.app.tokobagus.betterb:id/paywallOptionsRv";
    public static final String viewParent = "com.app.tokobagus.betterb:id/viewParent";
    public static final String paywallOptRadio = "com.app.tokobagus.betterb:id/rowPaywall_rb";
    public static final String beliPaywallBtn = "com.app.tokobagus.betterb:id/paywallOptionsBtnBuy";
    public static final String alertSaldo = "com.app.tokobagus.betterb:id/md_content";
    public static final String tidakBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultNegative";
    public static final String yaBtn = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public static final String paywallRv = "com.app.tokobagus.betterb:id/paywallRv";
    public static final String successMsg = "berhasil";

    @AndroidFindBys({
            @AndroidFindBy(id = rvCategory),
            @AndroidFindBy(id = layoutContainer),
            @AndroidFindBy(id = pilihKategoriTtl)
    })
    public List<AndroidElement> categoryOption;

    @AndroidFindBys({
            @AndroidFindBy(id = rvLocation),
            @AndroidFindBy(id = layoutContainer),
            @AndroidFindBy(id = pilihLokasiTtl)
    })
    public List<AndroidElement> locationOption;

    @AndroidFindBys({
            @AndroidFindBy(id = rvPaywallOpt),
            @AndroidFindBy(id = viewParent),
            @AndroidFindBy(id = paywallOptRadio)
    })
    public List<AndroidElement> paywallOption;

    @AndroidFindBys({
            @AndroidFindBy(id = paywallRv),
            @AndroidFindBy(id = viewParent),
            @AndroidFindBy(id = paywallOptRadio)
    })
    public List<AndroidElement> paywallSlotIklanHabisOption;

    public void initBeliKuotaPage(){
        IklanSayaPage iklanSayaPage = new IklanSayaPage(driver);
        HamburgerBarModule hamburgerBarModule = new HamburgerBarModule(driver);
        ListingPage listingPage = new ListingPage(driver);
        SaldoOlxModule saldoOlxModule = new SaldoOlxModule(driver);
        if(isElementPresent(getTextLocator(beliSlotIklanTitle))){
            clickBackBtn();
            iklanSayaPage.clickBackBtn();
            listingPage.clickFavoritBtmBtn();
        }else if(isElementPresent(getIdLocator(alertSaldo))){
            clickTidakOnAlertInsufSaldo();
            clickBackBtn();
            clickBackBtn();
        }else if(isElementPresent(getTextLocator(slotIklanHabisTitle))){
            clickBackBtn();
            clickBackBtn();
        }else if(saldoOlxModule.isOnSaldoPage()){
            saldoOlxModule.clickBackBtn();
            clickBackBtn();
            clickBackBtn();
        }
    }

    public void verifySlotIklanTitle(){
        Assert.assertTrue(isWaitElementPresent(getTextLocator(slotIklanHabisTitle)));
        Log.info("Verify Slot Iklan Habis Title");
    }

    public void verifySlotIklanDesc(){
        Assert.assertTrue(isElementPresent(getIdLocator(slotIklanDesc)));
        Log.info("Verify Slot Iklan Habis Description");
    }

    public void verifySlotIklanOpt(){
        Assert.assertTrue(isElementPresent(getIdLocator(slotIklanOptionTitle)));
        Log.info("Verify Beli Slot Iklan Option Title");
        int countOpt = paywallSlotIklanHabisOption.size();
        if(countOpt < 1){
            Assert.assertTrue(false, "No paywall option displayed");
        }else {
            for(int i=0; i< countOpt; i++){
                Log.info("paywall opt "+i+" : "+paywallSlotIklanHabisOption.get(i).getText());
            }
        }
    }

    public void choosePaywallSlotHabis50(){
        paywallSlotIklanHabisOption.get(0).click();
    }

    public void verifySlotIklanBeliBtn(){
        Assert.assertTrue(isElementPresent(getIdLocator(slotIklanBeliBtn)));
        Log.info("Verify Beli Button");
    }

    public void clickBeliBtnPaywallSlotIklanHabis(){
        clickElement(getIdLocator(slotIklanBeliBtn));
        Log.info("Click beli button on slot iklan habis");
    }

    public void verifyBeliSlotIklanTitle(){
        Assert.assertTrue(isWaitElementPresent(getTextLocator(beliSlotIklanTitle)));
        Log.info("Verify beli slot iklan title");
    }

    public void verifyBackBtn(){
        Assert.assertTrue(isElementPresent(getContentLocator(backBtn)));
        Log.info("Verify back button");
    }

    public void clickBackBtn(){
        clickElement(getContentLocator(backBtn));
        Log.info("Click back button");
    }

    public void verifyBeliSlotIklanCategTtl(){
        Assert.assertTrue(isElementPresent(getIdLocator(beliSlotIklanKategoriTtl)));
        Log.info("Verify beli slot iklan kategori");
    }

    public void verifyBeliSlotIklanCategOpt(){
        clickElement(getIdLocator(beliSlotIklanKategoriOpt));
        Assert.assertTrue(isElementPresent(getIdLocator(pilihKategoriTtl)));
        int countCateg = categoryOption.size();
        if(countCateg < 1){
            Assert.assertTrue(false, "No category displayed");
        }else {
            for(int i=0; i<countCateg; i++){
                Log.info("category "+i+" : "+categoryOption.get(i).getText());
            }
        }
    }

    public void chooseCategoryRumah(){
        categoryOption.get(0).click();
        WaitFor(2);
        categoryOption.get(2).click();
        Log.info("Click Kategori Rumah");
    }

    public void verifyBeliSlotIklanLokasiTtl(){
        Assert.assertTrue(isElementPresent(getIdLocator(beliSlotIklanLokasiTtl)));
        Log.info("Verify beli slot iklan lokasi");
    }

    public void verifyBeliSlotIklanLokasiOpt(){
        clickElement(getIdLocator(beliSlotIklanLokasiOpt));
        Assert.assertTrue(isElementPresent(getIdLocator(pilihLokasiTtl)));
        int countloc = locationOption.size();
        if(countloc < 1){
            Assert.assertTrue(false, "No location displayed");
        }else {
            for(int i=0; i<countloc; i++){
                Log.info("location "+i+" : "+locationOption.get(i).getText());
            }
        }
    }

    public void chooseLocationJakarta(){
        locationOption.get(0).click();
        Log.info("Click lokasi Jakarta");
    }

    public void verifyHargaSlotIklanContent(){
        Assert.assertTrue(isElementPresent(getIdLocator(hargaSlotIklanContent)));
        Log.info("Verify harga slot iklan content");
        int countPay = paywallOption.size();
        if(countPay<1){
            Assert.assertTrue(false, "No paywall displayed");
        }else {
            for(int i=0; i<countPay; i++){
                Log.info("paywall "+i+" : "+paywallOption.get(i).getText());
            }
        }
    }

    public void choosePaywall50(){
        paywallOption.get(0).click();
        Log.info("Click paywall 50k");
    }

    public void verifyBeliPaywallBtn(){
        Assert.assertTrue(isElementPresent(getIdLocator(beliPaywallBtn)));
        Log.info("Verify Beli paywall button");
    }

    public void verifyBeliKuotaPageContent(){
        verifyBeliSlotIklanTitle();
        verifyBackBtn();
        verifyBeliSlotIklanCategTtl();
        verifyBeliSlotIklanCategOpt();
        chooseCategoryRumah();
        verifyBeliSlotIklanLokasiTtl();
        verifyBeliSlotIklanLokasiOpt();
        chooseLocationJakarta();
        verifyHargaSlotIklanContent();
        verifyBeliPaywallBtn();
    }

    public void clickBeliPaywall(){
        clickElement(getIdLocator(beliPaywallBtn));
        Log.info("Click Beli Paywall");
    }

    public void verifyAlertInsufSaldo(){
        Assert.assertTrue(isElementPresent(getIdLocator(alertSaldo)));
        Assert.assertTrue(isElementPresent(getIdLocator(tidakBtn)));
        Assert.assertTrue(isElementPresent(getIdLocator(yaBtn)));
    }

    public void clickTidakOnAlertInsufSaldo(){
        clickElement(getIdLocator(tidakBtn));
        Log.info("Click Tidak on Alert");
    }

    public SaldoOlxModule clickYaOnAlertInsufSaldo(){
        clickElement(getIdLocator(yaBtn));
        Log.info("Click Ya on Alert");
        return new SaldoOlxModule(driver);
    }

    public void verifyAlertSuccessBuyPaywall(){
        Assert.assertTrue(isElementPresent(getIdLocator(alertSaldo)));
        Assert.assertTrue(getStringText(getIdLocator(alertSaldo)).contains(successMsg));
        Assert.assertTrue(isElementPresent(getIdLocator(yaBtn)));
        Log.info("Verify Success Buy Paywall");
    }
}
