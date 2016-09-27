package module;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by buddyarifin on 9/26/16.
 */
public class SaldoOlxModule extends BasePage {

    public SaldoOlxModule(WebDriver driver) {
        super(driver);
    }

    public static final String backbutton = "";
    public static final String titleSaldo = "";
    public static final String infoBanner = "";
    public static final String skipBanner = "";
    public static final String saldoAndaSaatIni = "";
    public static final String saldoAmount = "";
    public static final String historyTransaction = "";
    public static final String historyTransactionDate = "";
    public static final String isiUlangSaldoText = "";
    public static final String isiUlangSaldoBtn = "";

    @Step("Verify All Contents of Saldo Olx Page")
    public void allContentOfSaldoOlx() {
        verifyBackbutton();
        verifytitleSaldo();
        verifyInfoBanner();
        verifySkipBanner();
        verifySaldoAmount();
        verifySaldoSaatIni();
        verifyHistoryTransactions();
        verifyHistoryTransactionsDate();
        verifyIsiUlangSaldo();
        verifyIsiUlangSaldoBtn();
    }

    public void verifyBackbutton() {
        Log.info("Veviry Back Button displays");}
    public void verifytitleSaldo() { Log.info("Verify Title Saldo Olx besides Back Button displays");}
    public void verifyInfoBanner() { Log.info("Verify Info Banner with description displays");}
    public void verifySkipBanner() { Log.info("Verify Close Button Banner display");}
    public void verifySaldoSaatIni() { Log.info("Verify Saldo Olx Saat Ini Text displays");}
    public void verifySaldoAmount() { Log.info("Verify Saldo Amount displays");}
    public void verifyHistoryTransactions() { Log.info("Verify History Transactions displays");}
    public void verifyHistoryTransactionsDate() { Log.info("Verify History Transactions date displays");}
    public void verifyIsiUlangSaldo() { Log.info("Verify Isi Ulang Text displays");}
    public void verifyIsiUlangSaldoBtn() { Log.info("Verify Isi Ulang Saldo Button displays");}


    public void clickBackButton() { Log.info("Click Back Button");}
    public void clickSkipBanner() { Log.info("Click Skip Banner");}
    public void clickIsiUlangSaldoOLX() { Log.info("Click Isi Ulang Saldo Olx");}

}
