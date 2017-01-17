package module;

import com.google.common.base.Function;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by buddyarifin on 9/26/16.
 */
public class SaldoOlxModule extends BasePage {


    public static final String historyTransactionTitle = "Riwayat Transaksi";
    public static final String pusatBantuanHeader = "com.app.tokobagus.betterb:id/action_bar";

    public SaldoOlxModule(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String backbutton = "Navigate up";
    public static final String titleSaldo = "OLX";
    public static final String infoBanner = "com.app.tokobagus.betterb:id/walletInfo_text";
    public static final String skipBanner = "com.app.tokobagus.betterb:id/wallet_btnCloseMoreInfo";
    public static final String lebihLanjutBtn = "com.app.tokobagus.betterb:id/wallet_btnMoreInfo";
    public static final String skipBannerTopUpSection = "com.app.tokobagus.betterb:id/topupInfo_btnMore";
    public static final String tutupBannerTopUpSection = "com.app.tokobagus.betterb:id/topupInfo_btnClose";
    public static final String saldoAndaSaatIni = "com.app.tokobagus.betterb:id/label_olx_balance";
    public static final String saldoAmount = "com.app.tokobagus.betterb:id/olx_balance";
    public static final String saldoDateExpired = "com.app.tokobagus.betterb:id/olx_expiredDate";
    public static final String historyTransaction = "";
    public static final String historyTransactionDate = "";
    public static final String historyTransactionBtn = "";
    public static final String isiUlangSaldoText = "";
    public static final String isiUlangSaldoBtn = "com.app.tokobagus.betterb:id/btn_top_up";
    public static final String infoImageSlide = "com.app.tokobagus.betterb:id/intro_iv";
    public static final String infoImageSlideFrameLayout = "com.app.tokobagus.betterb:id/indicator_container";
    public static final String introTitleID = "com.app.tokobagus.betterb:id/intro_iv";
    public static final String nextImageSlideBtn = "com.app.tokobagus.betterb:id/next";
    public static final String prevImageSlideBtn = "com.app.tokobagus.betterb:id/prev";
    public static final String topUpTitle = "TOP UP";
    public static final String saldoAndaTitle = "com.app.tokobagus.betterb:id/topup_tvMyBalance";
    public static final String saldoAndaAmount = "com.app.tokobagus.betterb:id/topup_tvMyBalanceValue";
    public static final String nominalSaldoRadioButton = "com.app.tokobagus.betterb:id/rowNominal_rb";
    public static final String nominalSaldoRv = "com.app.tokobagus.betterb:id/topup_rv";
    public static final String nominalSaldoLinearLayout = "com.app.tokobagus.betterb:id/rowNominal_view";
    public static final String syaratDanKetentuanChkBox = "com.app.tokobagus.betterb:id/topup_chkAgrrement";
    public static final String bayarBtn = "com.app.tokobagus.betterb:id/topup_btnPay";
    public static final String transactionDate = "com.app.tokobagus.betterb:id/rowTransaction_tvDate";
    public static final String noTransaction = "com.app.tokobagus.betterb:id/rowTransaction_tvTransNumber";
    public static final String noTransactionStatus = "com.app.tokobagus.betterb:id/rowTransaction_tvTransStatus";
    public static final String transactionPrice = "com.app.tokobagus.betterb:id/rowTransaction_tvPromoPrice";
    public static final String transactionHistory = "com.app.tokobagus.betterb:id/btn_show_transaction_history";
    public static final String infoLebihLanjut = "com.app.tokobagus.betterb:id/safety_info_more";
    public static final String PUSAT_BANTUAN = "Pusat Bantuan";


    @AndroidFindBys({
            @AndroidFindBy(id = nominalSaldoRadioButton)
    })
    protected List<AndroidElement> nominalRadioButtonGroup;

    @AndroidFindBys({
            @AndroidFindBy(id = "com.app.tokobagus.betterb:id/historyTransOlxId_pagerIndicator"),
            @AndroidFindBy(className = "android.widget.LinearLayout"),
            @AndroidFindBy(className = "android.widget.TextView")
    })
    protected List<AndroidElement> threePanels;

    @Step("Verify All Contents of Saldo Olx Page")
    public void verifyAllContentOfSaldoOlx()
    {
        verifyBackbutton();
        verifytitleSaldo();
        verifyInfoBanner();
        verifyLebihLanjutButton();
        verifyLebihLanjutBtn();
        verifySkipBanner();
        verifySaldoAmount();
        verifySaldoSaatIni();
        verifyHistoryTransactionsTitle();
        verifyHistoryTransactionsDate();
        verifyIsiUlangSaldoTitle();
        verifyIsiUlangSaldoBtn();
        verifyHistoryTransactionsDate();
    }
    public void verifyBackbutton()
    {
        Assert.assertTrue(isWaitElementPresent(getContentLocator(backbutton)),"Back Button Not Found");
        Log.info("Veviry Back Button displays");
    }
    public void verifytitleSaldo()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(titleSaldo)),"Title Button Not Found");
        Log.info("Verify Title Saldo Olx besides Back Button displays");
    }
    public void verifyInfoBanner()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(infoBanner)),"Info Banner Not Found");
        Log.info("Verify Info Banner with description displays");
    }
    public void verifySkipBanner()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(skipBanner)),"Skip Banner Not Found");
        Log.info("Verify Close Button Banner display");
    }
    public void verifyLebihLanjutBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(lebihLanjutBtn)),"Lebih Lanjut Button Not Found");
        Log.info("Verify Lebih Lanjut Info Banner Button");
    }
    public void verifySaldoSaatIni()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(saldoAndaSaatIni)),"Saldo Saat Ini Not Found");
        Log.info("Verify Saldo Olx Saat Ini Text displays");
    }
    public void verifySaldoAmount()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(saldoAmount)),"Saldo Amount Not Found");
        Log.info("Verify Saldo Amount displays");
    }
    public void verifyHistoryTransactionsTitle()
    {
        Log.info("Verify History Transactions displays");
    }
    public void verifyHistoryTransactionsDate()
    {
        Log.info("Verify History Transactions date displays");
        // add conditions if, we test with a fresh users which not have history
        if (isElementPresent(getIdLocator(transactionDate))) {
            Assert.assertTrue(true);
            verifyHistoryTransactionsNumber();
            verifyHistoryTransactionsStatus();
            verifyHistoryTransactionsPrice();
        } else {
            verifyInfoImageSlide();
            verifyNextImageSlideBtn();
            verifyPrevImageSlideBtn();
        }
    }
    public void verifyHistoryTransactionsNumber()
    {
        Log.info("Verify History Transactions Number displays");
        Assert.assertTrue(isElementPresent(getIdLocator(noTransaction)),"History Transaction Number Not Found");
    }
    public void verifyHistoryTransactionsStatus()
    {
        Log.info("Verify History Transactions Status displays");
        Assert.assertTrue(isElementPresent(getIdLocator(noTransactionStatus)),"History Transaction Status Not Found");
    }
    public void verifyHistoryTransactionsPrice()
    {
        Log.info("Verify History Transactions Price displays");
        Assert.assertTrue(isElementPresent(getIdLocator(transactionPrice)),"History Transaction Price Not Found");
    }
    public void verifyIsiUlangSaldoTitle()
    {
        Log.info("Verify Isi Ulang Text displays");
    }
    public void verifyIsiUlangSaldoBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(isiUlangSaldoBtn)),"Isi Ulang Saldo Button Not Found");
        Log.info("Verify Isi Ulang Saldo Button displays");
    }
    public void verifyInfoImageSlide()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(infoImageSlide)),"Isi Ulang Image Slide Not Found");
        Log.info("Verify Info Image Slide");
    }
    public void verifyNextImageSlideBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(nextImageSlideBtn)),"Next Image Slide Button Not Found");
        Log.info("Verify Next Images Slide Button");
    }
    public void verifyPrevImageSlideBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(prevImageSlideBtn)),"Prev Image Slide Button Not Found");
        Log.info("Verify Previous Image Slide Button");
    }
    public void verifyLebihLanjutButton()
    {
        Log.info("Verify Lebih Lanjut Button");
        Assert.assertTrue(isElementPresent(getIdLocator(lebihLanjutBtn)), "Lebih Lanjut Button Not Found");
    }

    public HamburgerBarModule clickBackButton()
    {
        clickElement(getContentLocator(backbutton));
        Log.info("Click Back Button");
        return new HamburgerBarModule(driver);
    }

    public void clickBackBtn()
    {
        Log.info("Click Back Button");
        clickElement(getContentLocator(backbutton));
    }
    public void clickSkipBanner()
    {
        clickElement(getIdLocator(skipBanner));
        Log.info("Click Skip Banner");
    }

    public void clickLebihLanjutInfoBanner()
    {
        clickElement(getIdLocator(lebihLanjutBtn));
        Log.info("Click Lebih Lanjut Button in Info Banner");
    }

    public void clickIsiUlangSaldoOLX()
    {
        clickElement(getIdLocator(isiUlangSaldoBtn));
        Log.info("Click Isi Ulang Saldo Olx");
    }
    public void clickHistoryTransaction()
    {
        Log.info("Click History Transaction");
        clickElement(getIdLocator(transactionHistory));
    }

    public void clickNextInfoImageBanner()
    {
        do {
            clickElement(getIdLocator(nextImageSlideBtn));

        }while (isElementPresent(getIdLocator(nextImageSlideBtn)));
        Log.info("Click Next Image Slide");
    }

    public void clickPrevInfoImageBanner()
    {
        do {
            clickElement(getIdLocator(prevImageSlideBtn));

        }while (isElementPresent(getIdLocator(prevImageSlideBtn)));
        Log.info("Click Next Image Slide");
    }


    /**
     * History Transaction Page Sections
     * */


    @Step("Verify All Content in History Transaction Page")
    public void verifyAllContentHistoryTransaction()
    {
        verifyBackbutton();
        verifyHistoryTransactionTitle();
        verifyThreePanelStatus();
        verifyIsiUlangOLXBtn();
        verifyTransactionHistoryRelatedUsage();
    }

    public void verifyHistoryTransactionTitle()
    {
        Log.info("Verify Saldo OLX Title");
        Assert.assertTrue(isElementPresent(getTextLocator(historyTransactionTitle)),"History Transaction Title Not Found");
    }

    public void verifyThreePanelStatus()
    {
        Log.info("Verify Three Panel Status");
        Assert.assertTrue(isListElementPresent(threePanels),"Three Panel Status Not Found");
    }

    public void verifyIsiUlangOLXBtn()
    {
        Log.info("Verify Isi Ulang Button");
    }

    public void verifyTransactionHistoryRelatedUsage()
    {
        Log.info("Verify Transaction History Related Usage");
    }


    /**
     * Isi Ulang Page Sections
     * */

    @Step("Verify All Content ini Isi Ulang Page")
    public void verifyContentIsiUlangPage()
    {
        verifyBackbutton();
        verifyTopUpTitle();
        //verifySaldoAndaAndSaldoAmount();
        verifyNominalPriceSaldo();
    }

    public void verifyTopUpTitle()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(topUpTitle)));
        Log.info("Verify Top Up Title");
    }

    public void verifySaldoAndaAndSaldoAmount()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(saldoAndaTitle)));
        Assert.assertTrue(isElementPresent(getIdLocator(saldoAndaAmount)));
        Log.info("Verify Saldo Anda and Saldo Amount");
    }

    public void verifyNominalPriceSaldo()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(nominalSaldoRadioButton)));
        Log.info("Verify Nominal Price Saldo");
    }

    public void verifySyaratDanKetentuanBerlaku()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(syaratDanKetentuanChkBox)));
        Log.info("Verify Syarat dan Ketentan Berlaku");
    }

    public void verifyBayarButton()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(bayarBtn)));
        Log.info("Verify Bayar Button");
    }

    public void clickOneOfNominalSaldoRadioButton()
    {
        nominalRadioButtonGroup.get(0).click();
        Log.info("Click One of Nominal Saldo Radio Button");
    }

    public void checkSyaratDanKetentuan()
    {
        Log.info("Check Syarat dan Ketentuan Check Box");
        isElementPresentAfterScrollDown(getIdLocator(skipBannerTopUpSection));
        verifySyaratDanKetentuanBerlaku();
        clickElement(getIdLocator(syaratDanKetentuanChkBox));
    }

    public void clickBayarButton()
    {
        Log.info("Click Bayar Button");
        verifyBayarButton();
        clickElement(getIdLocator(bayarBtn));
    }

    @Override
    public Boolean isElementPresentAfterScrollDown(final By locator){
        WebElement element = driver.findElement(locator);
        int excludeLocator = element.getSize().getHeight();
        final int startY = driver.manage().window().getSize().getHeight() - excludeLocator;
        final int endY = (int) (driver.manage().window().getSize().getHeight() * 0.04);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                ((AndroidDriver)driver).swipe(200, startY, 200, endY, 500);
                return driver.findElement(locator).isDisplayed();
            }
        });
    }

    public HamburgerBarModule initSaldoOlxTest() {
        Log.info("Back to initiate Saldo Olx Page");
        if (isElementPresent(getIdLocator(isiUlangSaldoBtn))) {
            backToHamburgerBar();
        } else if (isListElementPresent(threePanels)) {
            clickBackBtn();
            backToHamburgerBar();
        } else if (isElementPresent(getTextLocator(topUpTitle))) {
            clickBackBtn();
            backToHamburgerBar();
        } else if (isCurrentPageOnPusatBantuan()) {
            driver.navigate().back();
        }else {
            Assert.assertTrue(true, "Already on Opened Hamburger Bar");
        }
        return new HamburgerBarModule(driver);
    }

    private void backToHamburgerBar() {
        HamburgerBarModule hamburgerBar;
        hamburgerBar = clickBackButton();
        isWaitElementPresent(getIdLocator(hamburgerBar.avatarSaya));
    }

    public void clickLebihLanjut() {
        Log.info("Click Lebih Lanjut Button");
        clickElement(getIdLocator(lebihLanjutBtn));
    }

    public void verifyInfoLebihLanjut() {
        Assert.assertTrue(isWaitElementPresent(getAndroidViewTextLocator(PUSAT_BANTUAN)),
                "Pusat Bantuan Web View Not Found/Displayed");
        driver.navigate().back();
    }

    public boolean isCurrentPageOnPusatBantuan() {
        return isElementPresent(getIdLocator(pusatBantuanHeader));
    }
}
