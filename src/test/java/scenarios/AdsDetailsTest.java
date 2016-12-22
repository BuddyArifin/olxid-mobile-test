package scenarios;

import listeners.ScreenshootsListener;
import module.FilterByMapsLocationModule;
import module.LoginWithOlxModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdsDetailsPage;
import pages.FavoritePage;
import pages.ListingPage;
import pages.LoginPage;
import pages.PesanPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 9/2/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Ads Details")
public class AdsDetailsTest extends AndroidSetup {
    LoginPage loginPage;
    ListingPage listingPage;
    AdsDetailsPage adsDetailsPage;

    @Stories("As A User I want be able to see Overall item on detail listing page")
    @Title("Verify User able to see Overall items of details ads")
    @TestCaseId("TC_AdDetails_09_001, TC_AdDetails_09_006")
    @Test(priority = 1)
    public void verifyAllContentsOfAdsDetails() {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipOnBoardingSliders().skipLogin();
        listingPage.verifyContentsOfListingPage();
        listingPage.clickSearchBtnPrm();
        listingPage.inputSearchKeyword("Supra x 125");
        listingPage.verifySuggestionList();
        listingPage.clickSuggestions();
        listingPage.verifyContentsOfListingPage();
        adsDetailsPage = listingPage.selectAdsFromListing();
        adsDetailsPage.verifyAllContensAdsDetails();
    }

    @Stories("As A User I want be able to SHARE Ads")
    @Title("Verify User able to SHARE their Ads")
    @TestCaseId("TC_AdDetails_09_002")
    @Test(priority = 3)
    public void verifyUserAbleToShareAds() {
        adsDetailsPage = new AdsDetailsPage(driver);
        adsDetailsPage.initAdsDetailsTest();
        adsDetailsPage.clickShareBtn();
        adsDetailsPage.verifyShare();
        adsDetailsPage.verifyShareBtn();
    }

    @Stories("As A User I want be able to Learn Tips \"Transaksi Aman\" with \"Info Lebih Lanjut\" Button")
    @Title("Verify User able to Learn Tips Transaksi Aman ")
    @TestCaseId("TC_AdDetails_09_003")
    @Test(priority = 3)
    public void verifyUserAbleToAccessTipsTransaksi() {
        adsDetailsPage = new AdsDetailsPage(driver);
        adsDetailsPage.initAdsDetailsTest();
        adsDetailsPage.verifyBanner();
        adsDetailsPage.clickInfoLebihLanjut();
        adsDetailsPage.verifyInfoLebihLanjut();
    }

    @Stories("As A User I want be able to add Ads to Favorite")
    @Title("Verify User able to add Ads to Favorite")
    @TestCaseId("TC_AdDetails_09_005")
    @Test(priority = 3, dependsOnMethods = "verifyAllContentsOfAdsDetails")
    public void verifyUserAbleToAddAdsToFavorite() {
        adsDetailsPage = new AdsDetailsPage(driver);
        adsDetailsPage.initAdsDetailsTest();
        adsDetailsPage.clickFavoriteBtn();
        loginPage = adsDetailsPage.clickOkOnAlert();
        LoginWithOlxModule loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.inputEmail("remote.googs@gmail.com");
        loginOlx.inputPassword("remoteclient@789");
        loginOlx.clickLoginWithOlxBtn();
        adsDetailsPage.clickBackFromAdsDetails();
        FavoritePage favoritePage = listingPage.clickFavoritBtmBtn();
        favoritePage.verifyFavoritePageContent();
        favoritePage.clickFirstAds();
        adsDetailsPage.verifyAdsAlreadyOnFavoriteList();
        adsDetailsPage.clickBackFromAdsDetails();
        favoritePage.resetFavoriteAds();
    }

    @Stories("As A User I want be able to see related Ads & Testimoni by clicking \"Lihat Iklan Lainnya & Testimoni\"")
    @Title("Verify User able to see related Ads & Testimoni by clicking \"Lihat Iklan Lainnya & Testimoni\"")
    @TestCaseId("TC_AdDetails_09_008")
    @Test(priority = 3)
    public void verifyUserAbleGoToRelatedAdsAndTestimoni() {
        adsDetailsPage = new AdsDetailsPage(driver);
        adsDetailsPage.initAdsDetailsTest();
        adsDetailsPage.clickLihatIklanAndTestimoni();
        adsDetailsPage.verifyLihatIklanLainnya();
    }

    @Stories("As A User I want be able to find Location Ads with Maps")
    @Title("Verify User able to find Location Ads with Maps")
    @TestCaseId("TC_AdDetails_09_009")
    @Test(priority = 3)
    public void verifyUserAbleToFindAdsLocations() {
        adsDetailsPage = new AdsDetailsPage(driver);
        adsDetailsPage.initAdsDetailsTest();
        FilterByMapsLocationModule location = adsDetailsPage.clickAdsLocations();
        location.verifyCurrentLocationAddress();
    }

    @Stories("As A User I want be able to give feedback by \"Laporkan Iklan\" Option")
    @Title("Verify User able to give feedback by \"Laporkan Iklan\" Option")
    @TestCaseId("TC_AdDetails_09_010")
    @Test(priority = 3)
    public void verifyUserAbleToLaporkanIklan() {
        adsDetailsPage = new AdsDetailsPage(driver);
        adsDetailsPage.initAdsDetailsTest();
        adsDetailsPage.clickLaporkanIklan();
        adsDetailsPage.verifyAllContentsofKirimLaporan();
        adsDetailsPage.chooseFirstOptionStatusLaporan();
        adsDetailsPage.inputDeskripsiLaporan("Olx Mantapppp !!!!, makasih Olx");
//        adsDetailsPage.clickLaporkanIklan(); disable due, on production side
    }

    @Stories("As A User I want be able to Hubungi Penjual below Ads Details")
    @Title("Verify User abel to Hubungi Penjual")
    @TestCaseId("TC_AdDetails_09_011")
    @Test(priority = 3)
    public void verifyUserAbleToHubungiPenjual() {
        adsDetailsPage = new AdsDetailsPage(driver);
        adsDetailsPage.initAdsDetailsTest();
        PesanPage pesan = adsDetailsPage.clickHubugiPenjual();
        adsDetailsPage.verifyAlertAndTapOK();
        pesan.verifyRedirectionHubPenjualtoPesan();
    }

}
