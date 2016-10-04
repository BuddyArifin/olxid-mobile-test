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
 * Created by buddyarifin on 9/26/16.
 */
public class SaldoOlxModule extends BasePage {

    public SaldoOlxModule(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String backbutton = "Navigate up";
    public static final String titleSaldo = "Saldo OLX";
    public static final String infoBanner = "com.app.tokobagus.betterb:id/walletInfo_text";
    public static final String skipBanner = "com.app.tokobagus.betterb:id/wallet_btnCloseMoreInfo";
    public static final String lebihLanjutBtn = "com.app.tokobagus.betterb:id/wallet_btnMoreInfo";
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


    @AndroidFindBys({
            @AndroidFindBy(id = nominalSaldoRadioButton)
    })
    protected List<AndroidElement> nominalRadioButtonGroup;

    @Step("Verify All Contents of Saldo Olx Page")
    public void verifyAllContentOfSaldoOlx()
    {
        verifyBackbutton();
        verifytitleSaldo();
        verifyInfoBanner();
        verifyLebihLanjutBtn();
        verifySkipBanner();
        verifySaldoAmount();
        verifySaldoSaatIni();
        verifyHistoryTransactionsTitle();
        verifyHistoryTransactionsDate();
        verifyIsiUlangSaldoTitle();
        verifyIsiUlangSaldoBtn();
        verifyHistoryTransactionsDate();
        verifyHistoryTransactionsNumber();
        verifyHistoryTransactionsStatus();
        verifyHistoryTransactionsPrice();
//        verifyInfoImageSlide();
//        verifyNextImageSlideBtn();
//        verifyPrevImageSlideBtn();
    }
    public void verifyBackbutton()
    {
        Assert.assertTrue(isWaitElementPresent(getContentLocator(backbutton)));
        Log.info("Veviry Back Button displays");
    }
    public void verifytitleSaldo()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(titleSaldo)));
        Log.info("Verify Title Saldo Olx besides Back Button displays");
    }
    public void verifyInfoBanner()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(infoBanner)));
        Log.info("Verify Info Banner with description displays");
    }
    public void verifySkipBanner()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(skipBanner)));
        Log.info("Verify Close Button Banner display");
    }
    public void verifyLebihLanjutBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(lebihLanjutBtn)));
        Log.info("Verify Lebih Lanjut Info Banner Button");
    }
    public void verifySaldoSaatIni()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(saldoAndaSaatIni)));
        Log.info("Verify Saldo Olx Saat Ini Text displays");
    }
    public void verifySaldoAmount()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(saldoAmount)));
        Log.info("Verify Saldo Amount displays");
    }
    public void verifyHistoryTransactionsTitle()
    {
        Log.info("Verify History Transactions displays");
    }
    public void verifyHistoryTransactionsDate()
    {
        Log.info("Verify History Transactions date displays");
        Assert.assertTrue(isElementPresent(getIdLocator(transactionDate)));
    }
    public void verifyHistoryTransactionsNumber()
    {
        Log.info("Verify History Transactions Number displays");
        Assert.assertTrue(isElementPresent(getIdLocator(noTransaction)));
    }
    public void verifyHistoryTransactionsStatus()
    {
        Log.info("Verify History Transactions Status displays");
        Assert.assertTrue(isElementPresent(getIdLocator(noTransactionStatus)));
    }
    public void verifyHistoryTransactionsPrice()
    {
        Log.info("Verify History Transactions Price displays");
        Assert.assertTrue(isElementPresent(getIdLocator(transactionPrice)));
    }
    public void verifyIsiUlangSaldoTitle()
    {
        Log.info("Verify Isi Ulang Text displays");
    }
    public void verifyIsiUlangSaldoBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(isiUlangSaldoBtn)));
        Log.info("Verify Isi Ulang Saldo Button displays");
    }
    public void verifyInfoImageSlide()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(infoImageSlide)));
        Log.info("Verify Info Image Slide");
    }
    public void verifyNextImageSlideBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(nextImageSlideBtn)));
        Log.info("Verify Next Images Slide Button");
    }
    public void verifyPrevImageSlideBtn()
    {
        Assert.assertTrue(isElementPresent(getIdLocator(prevImageSlideBtn)));
        Log.info("Verify Previous Image Slide Button");
    }

    public HamburgerBarModule clickBackButton()
    {
        clickElement(getContentLocator(backbutton));
        Log.info("Click Back Button");
        return new HamburgerBarModule(driver);
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

    @Step("Verify All Content in History Transaction Page")
    public void verifyAllContentHistoryTransaction()
    {
        verifyBackbutton();
        verifySaldoOLXTitle();
        verifyThreePanelStatus();
        verifyIsiUlangOLXBtn();
        verifyTransactionHistoryRelatedUsage();
    }

    public void verifySaldoOLXTitle()
    {
        Log.info("Verify Saldo OLX Title");
    }

    public void verifyThreePanelStatus()
    {
        Log.info("Verify Three Panel Status");
    }

    public void verifyIsiUlangOLXBtn()
    {
        Log.info("Verify Isi Ulang Button");
    }

    public void verifyTransactionHistoryRelatedUsage()
    {
        Log.info("Verify Transaction History Related Usage");
    }

    @Step("Verify All Content ini Isi Ulang Page")
    public void verifyContentIsiUlangPage()
    {
        verifyBackbutton();
        verifyTopUpTitle();
        verifySaldoAndaAndSaldoAmount();
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
        isElementPresentAfterScroll(getIdLocator(syaratDanKetentuanChkBox));
        verifySyaratDanKetentuanBerlaku();
        clickElement(getIdLocator(syaratDanKetentuanChkBox));
        Log.info("Check Syarat dan Ketentuan Check Box");
    }

    public void clickBayarButton()
    {
        verifyBayarButton();
        clickElement(getIdLocator(bayarBtn));
        Log.info("Click Bayar Button");
    }
}
