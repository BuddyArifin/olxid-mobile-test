package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.ProfilSayaModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdsDetailsPage;
import pages.IklanSayaPage;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by NugrohoSantoso on 10/19/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Post Ads Test")
public class IklanSayaTest extends AndroidSetup {
    LoginPage loginPage;
    LoginWithOlxModule loginWithOlxModule;
    ListingPage listingPage;
    HamburgerBarModule hamburgerBarModule;
    IklanSayaPage iklanSayaPage;
    AdsDetailsPage adsDetailsPage;
    ProfilSayaModule profilSayaModule;

    @Stories("As A User i want be able to See All Contents of Category Page of \"Iklan Saya\"")
    @Title("Verify User able to See All Contents of \"Iklan Saya\"")
    @TestCaseId("TC_MYADS_15_001")
    @Test(priority = 1)
    public void verifyAllContentInIklanSayaPage()
    {
        loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        loginWithOlxModule = loginPage.clickLoginWithOlx();
        loginWithOlxModule.inputEmail("olxtester@gmail.com");
        loginWithOlxModule.inputPassword("testing");
        loginWithOlxModule.clickLoginWithOlxBtn();
        listingPage = loginWithOlxModule.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        iklanSayaPage = hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.verifyAllContentInIklanSayaPage();
    }

    @Stories("As a user i want to be able see Additional content in \"Aktif\" Panel")
    @Title("Verify system able to display Additional content in \"Aktif\" panel")
    @TestCaseId("TC_MYADS_15_002, TC_MYADS_15_005, TC_MYADS_15_006")
    @Test(priority = 3)
    public void verifyAdditionalContentInAktifPanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        iklanSayaPage.verifyContentInActivePanel();
    }

    @Stories("As a user i want to be able see content in \"Waiting\" Panel")
    @Title("Verify system able to display content in \"Waiting\" panel")
    @TestCaseId("TC_MYADS_15_002")
    @Test(priority = 3)
    public void verifyContentInWaitingPanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickWaitingPanel();
        iklanSayaPage.verifyContentInWaitingPanel();
    }

    @Stories("As a user i want to be able see content in \"Archive\" Panel")
    @Title("Verify system able to display content in \"Archive\" panel")
    @TestCaseId("TC_MYADS_15_002")
    @Test(priority = 3)
    public void verifyContentInArchivePanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickArchivePanel();
        iklanSayaPage.verifyContentInArchivePanel();
    }

    @Stories("As a user i want to be able see Additional content in \"Moderasi\" Panel")
    @Title("Verify system able to display Additional content in \"Moderasi\" panel")
    @TestCaseId("TC_MYADS_15_002, TC_MYADS_15_003")
    @Test(priority = 3)
    public void verifyAdditionalContentInModerasiPanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickModerasiPanel();
        iklanSayaPage.verifyContentInModeratedPanel();
    }

    @Stories("As a user i want to be able see content in \"Promote\" Panel")
    @Title("Verify system able to display content in \"Promote\" panel")
    @TestCaseId("TC_MYADS_15_002")
    @Test(priority = 3, enabled = false)
    public void verifyContentInPromotePanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickPromotePanel();
        iklanSayaPage.verifyContentInPromotePanel();
    }

    @Stories("As A User I want be able to Scroll the page on each Tab")
    @Title("Verify User able to Scroll page on each Tabs")
    @TestCaseId("TC_MYADS_15_004")
    @Test(priority = 3)
    public void verifyUserAbleToScrollPageOnEachTabs()
    {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        iklanSayaPage.verifyScrollUpAndDown();
        iklanSayaPage.clickWaitingPanel();
        iklanSayaPage.verifyScrollUpAndDown();
        iklanSayaPage.clickArchivePanel();
        iklanSayaPage.verifyScrollUpAndDown();
        iklanSayaPage.clickModerasiPanel();
        iklanSayaPage.verifyScrollUpAndDown();
        //disabled due to instabug location
        /*iklanSayaPage.clickPromotePanel();
        iklanSayaPage.verifyScrollUpAndDown();*/
    }

    @Stories("As a user able to click one of ads in Aktif Panel")
    @Title("Verify user able to click one of ads in Aktif Panel")
    @TestCaseId("TC_MYADS_15_007, TC_MYADS_15_008, TC_MYADS_15_009")
    @Test(priority = 3)
    public void verifyUserAbleToClickOneAdsInActivePanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
        adsDetailsPage.clickBackButton();
        iklanSayaPage.verifyAllContentInIklanSayaPage();
    }

    @Stories("As a user i want to be able click \"Non Aktif\" ads")
    @Title("Verify user able to click \"Non Aktif\" ads")
    @TestCaseId("TC_MYADS_15_025, TC_MYADS_15_026, TC_MYADS_15_027")
    @Test(priority = 3)
    public void verifyUserAbleToClickNonAktifkanIklan()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.clickNonActiveBtn();
        adsDetailsPage.verifyDeactivateReason();
        adsDetailsPage.clickCancelDeactivate();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
    }

    @Stories("As a user I want to see notification for each tabs if there's no content in it")
    @Title("Verify user able to see notification for each tabs if there's no content in it")
    @TestCaseId("TC_MYADS_15_049")
    @Test(priority = 4)
    public void verifyNoAdsContent(){
        iklanSayaPage.initIklanSayaPage();
        profilSayaModule = hamburgerBarModule.clickProfilSayaBtn();
        loginPage = profilSayaModule.clickLogoutDariOLXBtnProfilSayaPage();
        hamburgerBarModule.clickDisiniLogin();
        loginWithOlxModule = loginPage.clickLoginWithOlx();
        loginWithOlxModule.inputEmail("test.conf1a@gmail.com");
        loginWithOlxModule.inputPassword("confluence1234");
        loginWithOlxModule.clickLoginWithOlxBtn();
        profilSayaModule.verifyAllContentInProfilSayaPage();
        profilSayaModule.clickBackButton();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        iklanSayaPage.verifyAmountOfAds("Active");
        iklanSayaPage.clickWaitingPanel();
        iklanSayaPage.verifyAmountOfAds("Waiting");
        iklanSayaPage.clickArchivePanel();
        iklanSayaPage.verifyAmountOfAds("Archive");
        iklanSayaPage.clickModerasiPanel();
        iklanSayaPage.verifyAmountOfAds("Moderated");
    }
}
