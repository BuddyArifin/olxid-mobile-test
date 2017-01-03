package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.ProfilSayaModule;
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
        loginOlx.inputEmail("1482149220.3562@olx-trojan.com");
        loginOlx.inputPassword("test123");
        loginOlx.clickLoginWithOlxBtn();
        ListingPage listingPage = loginOlx.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        hamburgerBar = listingPage.clickHamburgerBar();
        hamburgerBar.verifyAllContentsInHamburgerBar();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.verifyAllContentInIklanSayaPage();
        iklanSayaPage.clickActivePanel();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAllContentsAdsDetailFromMyAds();
    }

    @Stories("As A User I want to be able to diactivate Ads")
    @Title("Verify User able to diactivated, by clicking \"Non Aktifkan\"")
    @TestCaseId("TC_AdDetails_09_014, TC_MYADS_15_025, TC_MYADS_15_026, TC_MYADS_15_027,TC_MYADS_15_028")
    @Test(priority = 3)
    public void verifyUserAbleToClickNonAktifkanIklan()
    {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyNonActiveBtn();
        adsDetailsPage.clickNonActiveBtn();
        adsDetailsPage.verifyNonAktifStatus();
        adsDetailsPage.chooseDeactivateReason();
        adsDetailsPage.clickNonActiveBtn();
        adsDetailsPage.verifyCopySbgIklanBaruButton();
        /*adsDetailsPage.clickBackFromAdsDetails();
        iklanSayaPage.clickNonAktifPanel();
        iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyStatusAds();
        adsDetailsPage.verifyAdsMoveToNonActivePanels();*/
    }

    @Stories("As A User I want to be able to diactivate Ads")
    @Title("Verify User able to diactivated, by clicking \"Non Aktifkan\"")
    @TestCaseId("TC_AdDetails_09_014, TC_MYADS_15_020, TC_MYADS_15_021, TC_MYADS_15_022, TC_MYADS_15_023, TC_MYADS_15_024")
    @Test(priority = 3)
    public void verifyUserAbleToClickSetTerjualAds()
    {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        iklanSayaPage.clickActivePanel();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifySudahTerjualBtn();
        adsDetailsPage.clickSudahTerjual();
        adsDetailsPage.verifyNonAktifStatus();
        adsDetailsPage.clickTerjualorTersewaOpts();
        adsDetailsPage.clickNonActiveBtn();
        adsDetailsPage.verifyCopySbgIklanBaruButton();
        /*adsDetailsPage.clickBackFromAdsDetails();
        iklanSayaPage.clickNonAktifPanel();
        iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyAdsMoveToNonActivePanels();*/
    }

    @Stories("As A User I want to be able to Duplicate Deactivate Ads to New")
    @Title("Verify User able to Activate ads")
    @TestCaseId("")
    @Test(priority = 3, enabled = false)
    public void verifyUserAbleToDuplicateDeactivateAdsToNewActiveAds() {
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

    /**EDIT IKLAN*/

    @Stories("As A User i want to be able to See All Contents of Edit Iklan page")
    @Title("Verify User able to See All Contents of Edit Iklan page")
    @TestCaseId("TC_AdDetails_09_015")
    @Test(priority = 3)
    public void verifyAllContentInEditIklanPage()
    {
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyEditBtn();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditIklanPageContents();
    }

    @Stories("As a user I will not be able to edit ads category")
    @Title("Verify user not able to edit ads category")
    @TestCaseId("TC_AdDetails_09_016")
    @Test(priority = 3)
    public void verifyKategoriNotClickable(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditJudulIklan();
        editIklanPage.verifyKategoriNotClickable();
    }

    @Stories("As a user I will not be able to edit ads with blank image")
    @Title("Verify user not able to edit ads with blank image")
    @TestCaseId("TC_AdDetails_09_017")
    @Test(priority = 3, enabled = false)
    public void verifyImageBlank(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditImageIklan();
        editIklanPage.clickDeleteImageIklan();
        editIklanPage.verifyConfirmDeleteImagePopUpContents();
        editIklanPage.confirmYesDeleteImageIklan();
        editIklanPage.clickEditSimpanBtn();
    }

    @Stories("As a user I will not be able to edit ads title with blank")
    @Title("Verify user not able to edit ads title with blank")
    @TestCaseId("TC_AdDetails_09_019")
    @Test(priority = 3)
    public void verifyTitleBlank(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditJudulIklan();
        editIklanPage.clickClearJudulIklan();
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidJudulIklan();
    }

    @Stories("As a user I will not be able to edit ads title with less than minimum characters")
    @Title("Verify user not able to edit ads title with less than minimum characters")
    @TestCaseId("TC_AdDetails_09_020")
    @Test(priority = 3)
    public void verifyTitleLessMinimum(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditJudulIklan();
        editIklanPage.inputNewIklanTitle("Testing");
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidJudulIklan();
    }

    @Stories("As a user I will not be able to edit ads title with more than maximum characters")
    @Title("Verify user not able to edit ads title with more than maximum characters")
    @TestCaseId("TC_AdDetails_09_021")
    @Test(priority = 3)
    public void verifyTitleMoreMaximum(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditJudulIklan();
        editIklanPage.inputNewIklanTitle("TestingTestingTestingTestingTestingTestingTestingTestingTestingTestingT");
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidJudulIklan();
    }

    @Stories("As a user I will not be able to edit ads title with invalid characters")
    @Title("Verify user not able to edit ads title with invalid characters")
    @TestCaseId("TC_AdDetails_09_023")
    @Test(priority = 3)
    public void verifyTitleInvalidChars(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditJudulIklan();
        editIklanPage.inputNewIklanTitle("@#$!%&*&$%#@!#$@");
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidCharJudulIklan();
    }

    @Stories("As a user I will not be able to edit ads price with invalid amount")
    @Title("Verify user not able to edit ads price with invalid amount")
    @TestCaseId("TC_AdDetails_09_026")
    @Test(priority = 3, enabled = false)
    public void verifyPriceInvalid(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditJudulIklan();
        editIklanPage.verifyEditPriceIklan();
        editIklanPage.inputNewIklanPrice("999999999999999999");
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidHarga();
    }

    @Stories("As a user I will not be able to edit ads price with blank amount")
    @Title("Verify user not able to edit ads price with blank amount")
    @TestCaseId("TC_AdDetails_09_027")
    @Test(priority = 3)
    public void verifyPriceBlank(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditJudulIklan();
        editIklanPage.verifyEditPriceIklan();
        editIklanPage.clickClearPriceIklan();
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidHarga();
    }

    @Stories("As a user I want to be able to leave description field blank")
    @Title("Verify user able to leave ads description field blank")
    @TestCaseId("TC_AdDetails_09_028")
    @Test(priority = 3)
    public void verifyDescBlank(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditImageIklan();
        editIklanPage.verifyOpsionalInfo();
        editIklanPage.inputNewIklanDesc("");
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifySuccessAlert();
        editIklanPage.clickTutupOnSuccessAlert();
    }

    @Stories("As a user I will not be able to edit ads description with more than max characters and use too many capital letters")
    @Title("Verify user not able to edit ads description with more than max characters and use too many capital letters")
    @TestCaseId("TC_AdDetails_09_029")
    @Test(priority = 3)
    public void verifyDescMax(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditImageIklan();
        editIklanPage.verifyOpsionalInfo();
        editIklanPage.inputNewIklanDescMax();
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidDesc();
    }

    @Stories("As a user I will not be able to edit ads description with less than minimum characters")
    @Title("Verify user not able to edit ads description with less than min characters")
    @TestCaseId("TC_AdDetails_09_030")
    @Test(priority = 3)
    public void verifyDescLessMin(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditImageIklan();
        editIklanPage.verifyOpsionalInfo();
        editIklanPage.inputNewIklanDesc("Testing");
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifyInvalidDesc();
    }

    @Stories("As a user I want to be able to input ads description with length = max length and all in lower case")
    @Title("Verify user able to input ads description with length = max length and all in lower case")
    @TestCaseId("TC_AdDetails_09_033")
    @Test(priority = 3)
    public void verifyDescMaxLower(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditImageIklan();
        editIklanPage.verifyOpsionalInfo();
        editIklanPage.inputNewIklanDescMaxLowercase();
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.verifySuccessAlert();
        editIklanPage.clickTutupOnSuccessAlert();
    }

    @Stories("As a user I want to be able to cancel delete ads image")
    @Title("Verify user able to cancel delete ads image")
    @TestCaseId("TC_AdDetails_09_032")
    @Test(priority = 3)
    public void verifyCancelDelImage(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditImageIklan();
        editIklanPage.clickDeleteImageIklan();
        editIklanPage.verifyConfirmDeleteImagePopUpContents();
        editIklanPage.confirmNoDeleteImageIklan();
        editIklanPage.verifyEditIklanPageContents();
    }

    @Stories("As a user I will be able to change ads product condition as Baru or Bekas")
    @Title("Verify user able to change ads product condition as Baru or Bekas")
    @TestCaseId("TC_AdDetails_09_031, TC_MYADS_15_046")
    @Test(priority = 4)
    public void verifyChangeKondisi(){
        iklanSayaPage.initIklanSayaPage();
        iklanSayaPage.clickBackBtn();
        ProfilSayaModule profilSayaModule = hamburgerBar.clickProfilSayaBtn();
        profilSayaModule.verifyAllContentInProfilSayaPage();
        LoginPage loginPage = profilSayaModule.clickLogoutDariOLXBtnProfilSayaPage();
        hamburgerBar.clickDisiniLogin();
        LoginWithOlxModule loginWithOlxModule = loginPage.clickLoginWithOlx();
        loginWithOlxModule.inputEmail("1482307492.3114@olx-trojan.com");
        loginWithOlxModule.inputPassword("test123");
        loginWithOlxModule.clickLoginWithOlxBtn();
        profilSayaModule.verifyAllContentInProfilSayaPage();
        profilSayaModule.clickBackButton();
        iklanSayaPage = hamburgerBar.clickIklanSayaBtn();
        AdsDetailsPage adsDetailsPage = iklanSayaPage.clickOneOfAdsInAdsList();
        adsDetailsPage.verifyEditBtn();
        EditIklanPage editIklanPage = adsDetailsPage.clickEditIklanBtn();
        editIklanPage.verifyEditImageIklan();
        editIklanPage.verifyAdsKondisi();
        editIklanPage.clickSelectKondisi();
        editIklanPage.verifyKondisiSelectionOpt();
        editIklanPage.clickKondisiSelectionBekas();
        editIklanPage.clickEditSimpanBtn();
        editIklanPage.clickTutupOnSuccessAlert();
    }


}
