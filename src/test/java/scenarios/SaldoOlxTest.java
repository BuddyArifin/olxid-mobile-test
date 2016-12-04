package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.ProfilSayaModule;
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

    @Stories("As A User i want be able to see all Contents of Saldo Olx")
    @Title("Verify User able to see All Contents of Saldo Olx")
    @TestCaseId("TC_SALDO_12_001")
    @Test(priority = 1, groups = "smoke.test")
    public void verifyAllContentsSaldoOlxPage() {
        LoginPage loginPage = new LoginPage(driver);
        LoginWithOlxModule loginWithOlxModule = loginPage.clickSkipOnBoardingSliders().clickLoginWithOlx();
        loginWithOlxModule.inputEmail("olxtester@gmail.com");
        loginWithOlxModule.inputPassword("testing");
        loginWithOlxModule.clickLoginWithOlxBtn();
        ListingPage listingPage = loginWithOlxModule.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        HamburgerBarModule hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        SaldoOlxModule saldoOlxModule = hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.verifyAllContentOfSaldoOlx();
    }

    @Stories("As A User i want to be able to back previous page, after tapping back button")
    @Title("Verify User able to back to previous page, after tapping back button")
    @TestCaseId("TC_SALDO_12_002")
    @Test(priority = 3)
    public void verifyUserAbleToBackYoPreviousPageAfterClickBackButton() {
        SaldoOlxModule saldoOlx = new SaldoOlxModule(driver);
        saldoOlx.initSaldoOlxTest();
    }


    @Stories("As a user i want to be able close info banner")
    @Title("Verify User able to close info banner by click \"Tutup\" Button")
    @TestCaseId("TC_SALDO_12_011")
    @Test(priority = 3, enabled = false)
    public void verifyUserAbleToCloseInfoBannerByClickTutupButton() {
        SaldoOlxModule saldoOlxModule = new SaldoOlxModule(driver);
        HamburgerBarModule hamburgerBarModule = saldoOlxModule.initSaldoOlxTest();
        hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.clickSkipBanner();
    }

    @Stories("As A User i want to be able to Tap History Transactions button, below List Transaction History")
    @Title("Verify User able to see Transaction History by Tapping History Transactions")
    @TestCaseId("TC_SALDO_12_004")
    @Test(priority = 3, groups = "smoke.test")
    public void verifyUserAbleToSeeTransactionHistoryByTappingHistoryTransactions() {
        SaldoOlxModule saldoOlxModule = new SaldoOlxModule(driver);
        HamburgerBarModule hamburgerBarModule = saldoOlxModule.initSaldoOlxTest();
        hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.verifyAllContentOfSaldoOlx();
        saldoOlxModule.clickHistoryTransaction();

    }

    @Stories("As A User i want be able to verify All Contents of History Transaction Page")
    @Title("Verify User able to verify All contents of History Transaction Page")
    @TestCaseId("TC_SALDO_12_005")
    @Test(priority = 3)
    public void verifyUserAbleToVerifyAllContentsOfHistoryTransactionPage() {
        SaldoOlxModule saldoOlxModule = new SaldoOlxModule(driver);
        HamburgerBarModule hamburgerBarModule = saldoOlxModule.initSaldoOlxTest();
        hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.clickHistoryTransaction();
        saldoOlxModule.verifyAllContentHistoryTransaction();
    }

    @Stories("As A User I want be able to back to Saldo OLX ")
    @Title("Verify User able to back to Saldo OLX by Tapping Back Button")
    @TestCaseId("TC_SALDO_12_00")
    @Test(priority = 3)
    public void verifyUserAbleToBackToSaldoOlxPage() {
        SaldoOlxModule saldoOlxModule = new SaldoOlxModule(driver);
        saldoOlxModule.initSaldoOlxTest();
    }

    @Stories("As a user i want to be able swipe infobanner")
    @Title("Verify user able to swipe info banner")
    @TestCaseId("TC_SALDO_12_003")
    @Test(priority = 10)
    public void verifyUserAbleToSwipeInfoBanner() {
        SaldoOlxModule saldoOlxModule = new SaldoOlxModule(driver);
        HamburgerBarModule hamburgerBarModule = saldoOlxModule.initSaldoOlxTest();
        ProfilSayaModule profilSayaModule = hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.clickLogoutDariOLXBtnProfilSayaPage();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        saldoOlxModule = hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.closeAlertKonf();
        LoginPage loginPage = new LoginPage(driver);
        LoginWithOlxModule loginWithOlxModule= loginPage.clickLoginWithOlx();
        loginWithOlxModule.verifyLoginOlxContents();
        loginWithOlxModule.inputEmail("buddy.arifin@icloud.com");
        loginWithOlxModule.inputPassword("nazgul_buddy");
        loginWithOlxModule.clickLoginWithOlxBtn();
        saldoOlxModule.clickNextInfoImageBanner();
        saldoOlxModule.clickPrevInfoImageBanner();
    }

    @Stories("As A User I want to be able redirect to Isi Ulang Saldo OLX Page, after tapping ISI ULANG SALDO Button")
    @Title("Verify User able to redirect to ISI Ulang OLX Page, after tapping ISI ULANG SALDO Button")
    @TestCaseId("TC_SALDO_12_007, TC_SALDO_12_008, TC_SALDO_12_009, TC_SALDO_12_010, TC_SALDO_12_011")
    @Test(priority = 11, groups = "smoke.test")
    public void verifyUserAbleToRedirectToIsiUlangOLXPageAfterClickIsiUlangSaldoButton() {
        SaldoOlxModule saldoOlxModule = new SaldoOlxModule(driver);
        HamburgerBarModule hamburgerBarModule = saldoOlxModule.initSaldoOlxTest();
        hamburgerBarModule.clickSaldoOLXBtn();
        saldoOlxModule.clickIsiUlangSaldoOLX();
        saldoOlxModule.verifyContentIsiUlangPage();
        saldoOlxModule.clickOneOfNominalSaldoRadioButton();
        saldoOlxModule.checkSyaratDanKetentuan();
        saldoOlxModule.clickBayarButton();
    }
}
