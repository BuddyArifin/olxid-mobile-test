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
@Features("Iklan Saya Feature")
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
        loginWithOlxModule.inputEmail("1482149220.3562@olx-trojan.com");
        loginWithOlxModule.inputPassword("test123");
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

    @Stories("As a user i want to be able see content in \"Non Aktif\" Panel")
    @Title("Verify system able to display content in \"Non Aktif\" panel")
    @TestCaseId("TC_MYADS_15_002")
    @Test(priority = 3)
    public void verifyContentInNonAktifPanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickNonAktifPanel();
        iklanSayaPage.verifyContentInNonAktifPanel();
    }

    @Stories("As a user i want to be able see content in \"Ditolak\" Panel")
    @Title("Verify system able to display content in \"Ditolak\" panel")
    @TestCaseId("TC_MYADS_15_002")
    @Test(priority = 3)
    public void verifyContentInDitolakPanel()
    {
        iklanSayaPage.initIklanSayaPage();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickDitolakPanel();
        iklanSayaPage.verifyContentInDitolakPanel();
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
    @Test(priority = 3)
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
        iklanSayaPage.clickModerasiPanel();
        iklanSayaPage.verifyScrollUpAndDown();
        iklanSayaPage.clickNonAktifPanel();
        iklanSayaPage.verifyScrollUpAndDown();
        iklanSayaPage.clickDitolakPanel();
        iklanSayaPage.verifyScrollUpAndDown();
        iklanSayaPage.clickPromotePanel();
        iklanSayaPage.verifyScrollUpAndDown();
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
        loginWithOlxModule.inputEmail("1482910393.936@olx-trojan.com");
        loginWithOlxModule.inputPassword("test123");
        loginWithOlxModule.clickLoginWithOlxBtn();
        profilSayaModule.verifyAllContentInProfilSayaPage();
        profilSayaModule.clickBackButton();
        hamburgerBarModule.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        iklanSayaPage.verifyAmountOfAds("Aktif");
        iklanSayaPage.clickModerasiPanel();
        iklanSayaPage.verifyAmountOfAds("Moderasi");
        iklanSayaPage.clickNonAktifPanel();
        iklanSayaPage.verifyAmountOfAds("NonAktif");
        iklanSayaPage.clickDitolakPanel();
        iklanSayaPage.verifyAmountOfAds("Ditolak");
    }
}
