package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.SaldoOlxModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ListingPage;
import pages.LoginPage;
import pages.PostAdsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 9/26/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Saldo OLX Feature")
public class SaldoOlxTest extends AndroidSetup {
    LoginPage loginPage;
    LoginWithOlxModule loginWithOlxModule;
    ListingPage listingPage;
    HamburgerBarModule hamburgerBarModule;
    PostAdsPage postAdsPage;
    SaldoOlxModule saldoOlxModule;

    @Stories("As A User i want be able to see all Contents of Saldo Olx")
    @Title("Verify User able to see All Contents of Saldo Olx")
    @TestCaseId("TC_SALDO_12_001")
    @Test(priority = 1)
    public void verifyAllContentsSaldoOlxPage() {
        loginPage = new LoginPage(driver);
        loginWithOlxModule = loginPage.clickSkipOnBoardingSliders().clickLoginWithOlx();
        loginWithOlxModule.inputEmail("olxtester@gmail.com");
        loginWithOlxModule.inputPassword("testing");
        loginWithOlxModule.clickLoginWithOlxBtn();
        listingPage = loginWithOlxModule.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        saldoOlxModule = hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.verifyAllContentOfSaldoOlx();
    }

    @Stories("As A User i want to be able to back previous page, after tapping back button")
    @Title("Verify User able to back to previous page, after tapping back button")
    @TestCaseId("TC_SALDO_12_002")
    @Test(priority = 2)
    public void verifyUserAbleToBackYoPreviousPageAfterClickBackButton() {
        hamburgerBarModule = saldoOlxModule.clickBackButton();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
    }

    @Stories("As a user i want to be able swipe infobanner")
    @Title("Verify user able to swipe info banner")
    @TestCaseId("TC_SALDO_12_003")
    @Test(priority = 3, enabled = false)
    public void verifyUserAbleToSwipeInfoBanner() {
        saldoOlxModule = hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.clickNextInfoImageBanner();
        saldoOlxModule.clickPrevInfoImageBanner();
    }

    @Stories("As a user i want to be able close info banner")
    @Title("Verify User able to close info banner by click \"Tutup\" Button")
    @TestCaseId("TC_SALDO_12_011")
    @Test(priority = 4, enabled = false)
    public void verifyUserAbleToCloseInfoBannerByClickTutupButton() {
        saldoOlxModule.clickSkipBanner();
    }

    @Stories("As A User i want to be able to Tap History Transactions button, below List Transaction History")
    @Title("Verify User able to see Transaction History by Tapping History Transactions")
    @TestCaseId("TC_SALDO_12_004")
    @Test(priority = 5)
    public void verifyUserAbleToSeeTransactionHistoryByTappingHistoryTransactions() {
        hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.verifyAllContentOfSaldoOlx();
        saldoOlxModule.clickHistoryTransaction();

    }

    @Stories("As A User i want be able to verify All Contents of History Transaction Page")
    @Title("Verify User able to verify All contents of History Transaction Page")
    @TestCaseId("TC_SALDO_12_005")
    @Test(priority = 6)
    public void verifyUserAbleToVerifyAllContentsOfHistoryTransactionPage() {
        saldoOlxModule.verifyAllContentHistoryTransaction();
    }

    @Stories("As A User I want be able to back to Saldo OLX ")
    @Title("Verify User able to back to Saldo OLX by Tapping Back Button")
    @TestCaseId("TC_SALDO_12_00")
    @Test(priority = 7)
    public void verifyUserAbleToBackToSaldoOlxPage() {
        saldoOlxModule.clickBackBtn();
        saldoOlxModule.clickBackBtn();
    }

    @Stories("As A User I want to be able redirect to Isi Ulang Saldo OLX Page, after tapping ISI ULANG SALDO Button")
    @Title("Verify User able to redirect to ISI Ulang OLX Page, after tapping ISI ULANG SALDO Button")
    @TestCaseId("TC_SALDO_12_007")
    @Test(priority = 7)
    public void verifyUserAbleToRedirectToIsiUlangOLXPageAfterClickIsiUlangSaldoButton() {
        hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.verifyAllContentOfSaldoOlx();
        saldoOlxModule.clickIsiUlangSaldoOLX();
    }

    @Stories("As A User i want to be able to verify All Contents of ISI Ulang Saldo Page")
    @Title("Verify User able to verify All Contents of ISI Ulang Page")
    @TestCaseId("TC_SALDO_12_008")
    @Test(priority = 8)
    public void verifyUserAbleToVerifyAllContentsOfIsiUlangPage() {
        saldoOlxModule.verifyContentIsiUlangPage();
    }

    @Stories("As A User i want to be able to Choose Nominal Price Saldo.")
    @Title("Verify User able to choose Nominal Price Saldo")
    @TestCaseId("TC_SALDO_12_009")
    @Test(priority = 9)
    public void verifyUserAbleToChooseNominalPriceSaldo() {
        saldoOlxModule.clickOneOfNominalSaldoRadioButton();
    }

    @Stories("As A User i want to be able to Accept \"Syarat dan Ketentuan\"")
    @Title("Verify User able to Accept \"Syarat dan Ketentuan\"")
    @TestCaseId("TC_SALDO_12_010")
    @Test(priority = 10)
    public void verifyUserAbleToAcceptSyaratDanKetentuan() {
        saldoOlxModule.checkSyaratDanKetentuan();
    }

    @Stories("As A User I want to be able to Click Bayar Button")
    @Title("Verify User able to Click Bayar Button")
    @TestCaseId("TC_SALDO_12_011")
    @Test(priority = 11)
    public void verifyUserAbleToClickBayarButton() {
        saldoOlxModule.clickBayarButton();
        // needs to verify
    }
}
