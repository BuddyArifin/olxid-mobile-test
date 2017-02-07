package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.ProfilSayaModule;
import module.SaldoOlxModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by sekarayu on 2/2/17.
 */

@Listeners(ScreenshootsListener.class)
@Features("Beli Kuota")
public class BeliKuotaTest extends AndroidSetup {
    LoginPage loginPage;
    IklanSayaPage iklanSayaPage;
    HamburgerBarModule hamburgerBar;
    BeliKuotaPage beliKuotaPage;
    ListingPage listingPage;
    PostAdsPage postAdsPage;
    PostAdsPage.Maps maps;
    SaldoOlxModule saldoOlxModule;
    LoginWithOlxModule loginOlx;

    @Stories("As a user I will be able to see Beli Kuota page content")
    @Title("Verify user able to see Beli Kuota page content")
    @TestCaseId("TC_PAYW_18_003")
    @Test(priority = 1)
    public void verifyUserAbleToSeeBeliKuotaPageContent(){
        loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.inputEmail("testsekar@olx.co.id");
        loginOlx.inputPassword("test123");
        loginOlx.clickLoginWithOlxBtn();
        listingPage = loginOlx.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        hamburgerBar = listingPage.clickHamburgerBar();
        hamburgerBar.verifyAllContentsInHamburgerBar();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.verifyBeliKuotaBtn();
        beliKuotaPage = iklanSayaPage.clickBeliKuotaBtn();
        beliKuotaPage.verifyBeliKuotaPageContent();
    }

    @Stories("As a user I won't be able to post new ad if I have 10 active ads in Iklan Saya page")
    @Title("Verify user won't be able to post new ad if user has 10 active ads in Iklan Saya page")
    @TestCaseId("TC_PAYW_18_004, TC_PAYW_18_005, TC_PAYW_18_006, TC_PAYW_18_007, TC_PAYW_18_008")
    @Test(priority = 3)
    public void verifyUserNotAbleToPostNewAd(){
        beliKuotaPage.initBeliKuotaPage();
        postAdsPage = listingPage.clickJualBtnBtm();
        postAdsPage.verifyContentInCameraPage();
        postAdsPage.clickShutterBtn();
        postAdsPage.verifyContentAdditionalInCameraPage();
        postAdsPage.inputJudulAds("Dijual Rumah Di Daerah Pondok Indah");
        postAdsPage.clickSimpanBtn();
        postAdsPage.verifyContentPostingForm();

        maps = postAdsPage.clickCariLokasiBtn();
        maps.verifyAllContentInLocationPage();
        maps.clickMyCurrentLocationBtn();
        postAdsPage = maps.clickCariDiLokasiIniBtn();

        postAdsPage.verifySuggestionKategori();
        postAdsPage.clickKategoriAds();
        postAdsPage.verifySuggestionHargaAndInputHarga("1000000000");
        postAdsPage.verifyAdditionalInputFieldPropertiCategory();
        postAdsPage.inputNomorHandphone("085718893452");
        postAdsPage.inputAdditionalFieldLuasTanah("200");
        postAdsPage.inputAdditionalFieldLuasBangunan("200");
        postAdsPage.clickPasangIklanButton();

        beliKuotaPage.verifySlotIklanTitle();
        beliKuotaPage.verifySlotIklanDesc();
        beliKuotaPage.verifySlotIklanOpt();
        beliKuotaPage.verifySlotIklanBeliBtn();
        beliKuotaPage.choosePaywallSlotHabis50();
        beliKuotaPage.clickBeliBtnPaywallSlotIklanHabis();
        beliKuotaPage.verifyAlertInsufSaldo();
        beliKuotaPage.clickTidakOnAlertInsufSaldo();
        beliKuotaPage.verifySlotIklanTitle();
        beliKuotaPage.clickBeliBtnPaywallSlotIklanHabis();
        beliKuotaPage.verifyAlertInsufSaldo();
        saldoOlxModule = beliKuotaPage.clickYaOnAlertInsufSaldo();

        saldoOlxModule.verifyIsiSaldoContentFromBeliKuota();
    }

    @Stories("As a user I will be able to buy quota")
    @Title("Verify user able to buy quota")
    @TestCaseId("TC_PAYW_18_009")
    @Test(priority = 4)
    public void verifyUserAbleToBuyPaywall(){
        beliKuotaPage.initBeliKuotaPage();
        hamburgerBar = listingPage.clickHamburgerBar();
        hamburgerBar.verifyAllContentsInHamburgerBar();
        ProfilSayaModule profilSayaModule = hamburgerBar.clickProfilSayaBtn();
        profilSayaModule.verifyLogoutDariOLXButtonProfilSayaPage();
        loginPage = profilSayaModule.clickLogoutDariOLXBtnProfilSayaPage();
        hamburgerBar.clickDisiniLogin();
        loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.inputEmail("saldosekar@olx.co.id");
        loginOlx.inputPassword("test123");
        loginOlx.clickLoginWithOlxBtn();
        profilSayaModule.verifyBackBtnProfilSayaPage();
        profilSayaModule.clickBackButton();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.verifyBeliKuotaBtn();
        beliKuotaPage = iklanSayaPage.clickBeliKuotaBtn();
        beliKuotaPage.verifyBeliKuotaPageContent();
        beliKuotaPage.choosePaywall50();
        beliKuotaPage.clickBeliPaywall();
        beliKuotaPage.verifyAlertSuccessBuyPaywall();
    }

}
