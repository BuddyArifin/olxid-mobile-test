package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.PaidFeatureModule;
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
 * Created by buddyarifin on 12/13/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Paid Feature")
public class PaidFeatureIklanSayaTest extends AndroidSetup {
    IklanSayaPage iklanSayaPage;
    HamburgerBarModule hamburgerBar;

    @Stories("As a user I want to be able to see Pilih Durasi Top Listing contents")
    @Title("Verify system able to display Pilih Durasi Top Listing contents as a pop up after user click Gunakan Fitur Top Listing button")
    @TestCaseId("TC_PAIDF_16_001, TC_MYADS_15_010, TC_MYADS_15_011, TC_MYADS_15_012")
    @Test(priority = 1)
    public void verifyUserAbleToPilihDurasiAfterTapGunakanHighlightFeature() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        LoginWithOlxModule loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.loginUserWithBalance();
        loginOlx.clickLoginWithOlxBtn();
        ListingPage listingPage = loginOlx.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        hamburgerBar = listingPage.clickHamburgerBar();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.verifyAktifPanel();
        iklanSayaPage.clickActivePanel();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
        PaidFeatureModule paidFeature = adsDetailsPage.clickTopListing();
        paidFeature.verifyAllDurasiListing();
    }

    @Stories("As a user I want to be able to select an option from Pilih Durasi Top Listing")
    @Title("Verify system able to select an option from Pilih Durasi Top Listing")
    @TestCaseId("TC_PAIDF_16_002, TC_PAIDF_16_003, TC_PAIDF_16_004, TC_MYADS_15_013, TC_MYADS_15_014, TC_MYADS_15_015")
    @Test(priority = 3)
    public void verifyUserAbleToSelectanOptionFromDurasiTopListing() {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
        PaidFeatureModule paidFeature = adsDetailsPage.clickTopListing();
        paidFeature.clickBatalOnTopListing();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
        adsDetailsPage.clickTopListing();
        paidFeature.clickDuration3Days();
        paidFeature.clickBeliOnTopListing();
        paidFeature.verifyMsgSuccessPage();
    }
}
