package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 12/6/16.
 */

@Listeners(ScreenshootsListener.class)
@Features("Ads Details")
public class AdsDetailsSellerViewTest extends AndroidSetup {
    IklanSayaPage iklanSayaPage;
    HamburgerBarModule hamburgerBar;

    @Stories("As A User and Seller I want to be able to see Overall item on detail listing page")
    @Title("Verify User able to see Overall items of details ads")
    @TestCaseId("TC_AdDetails_09_012")
    @Test(priority = 1)
    public void verifyAllContentsofDetailsonSellerView(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        LoginWithOlxModule loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.inputEmail("ferga.dipa@olx.co.id");
        loginOlx.inputPassword("testing123");
        loginOlx.clickLoginWithOlxBtn();
        ListingPage listingPage = loginOlx.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        hamburgerBar = listingPage.clickHamburgerBar();
        hamburgerBar.verifyAllContentsInHamburgerBar();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.verifyAllContentInIklanSayaPage();
    }

    @Stories("As A User I want to be able to diactivate Ads")
    @Title("Verify User able to diactivated, by clicking \"Non Aktifkan\"")
    @TestCaseId("TC_AdDetails_09_014")
    @Test(priority = 3)
    public void verifyUserAbleToClickNonAktifkanIklan()
    {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
        adsDetailsPage.clickNonActiveBtn();
        adsDetailsPage.verifyNonAktifStatus();
        adsDetailsPage.chooseDeactivateReason();
        adsDetailsPage.clickNonActiveBtn();
        adsDetailsPage.clickBackFromAdsDetails();
        iklanSayaPage.clickNonAktifPanel();
        iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyStatusAds();
        adsDetailsPage.verifyAdsMoveToNonActivePanels();
    }

    @Stories("As A User I want to be able to diactivate Ads")
    @Title("Verify User able to diactivated, by clicking \"Non Aktifkan\"")
    @TestCaseId("TC_AdDetails_09_014")
    @Test(priority = 3)
    public void verifyUserAbleToClickSetTerjualAds()
    {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
        adsDetailsPage.clickSudahTerjual();
        adsDetailsPage.verifyNonAktifStatus();
        adsDetailsPage.clickTerjualorTersewaOpts();
        adsDetailsPage.clickNonActiveBtn();
        adsDetailsPage.clickBackFromAdsDetails();
        iklanSayaPage.clickNonAktifPanel();
        iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAdsMoveToNonActivePanels();
    }

    @Stories("As A User I want to be able to Duplicate Deactivate Ads to New")
    @Title("Verify User able to Activate ads")
    @TestCaseId("")
    @Test(priority = 3, enabled = false)
    public void verifyUserAbleToDuplicateDeactivateAdsToNewActiveAds()
    {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.clickNonAktifPanel();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyCopySbgIklanBaruButton();
        PostAdsPage postAdsPage = adsDetailsPage.clickCopySbgIklanBaruButton();
        postAdsPage.clickThumbnailsPhoto();
        postAdsPage.inputJudulAds("[ACTIVATED by Automation]");
        // take a picture
        // edit judul ads
        // add location
        // verify Ads already activated
        // or moderated with spesific judul
    }


}
