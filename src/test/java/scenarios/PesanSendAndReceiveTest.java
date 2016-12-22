package scenarios;

import listeners.ScreenshootsListener;
import module.LoginWithOlxModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdsDetailsPage;
import pages.ListingPage;
import pages.LoginPage;
import pages.PesanPage;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by buddyarifin on 12/20/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Pesan Feature")
public class PesanSendAndReceiveTest extends AndroidSetup {

    @Test(priority = 1)
    public void verifyBuyerAbleToSendMessageAndDisplayOnLayoutMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipOnBoardingSliders();
        LoginWithOlxModule loginOlx = loginPage.clickLoginWithOlx();
        loginOlx.inputEmail("buddy.arifin@icloud.com");
        loginOlx.inputPassword("nazgul_buddy");
        loginOlx.clickLoginWithOlxBtn();
        ListingPage listingPage = loginOlx.verifyListingPage();
        listingPage.verifyContentsOfListingPage();
        listingPage.clickSearchBtnPrm();
        listingPage.inputSearchKeyword("Dijual rumah di daerah pondok indah");
        listingPage.verifySuggestionList();
        listingPage.clickSuggestions();
        listingPage.verifyContentsOfListingPage();
        AdsDetailsPage adsDetailsPage = listingPage.clickSpesificAdsWithPrice("1.895.000.000");
        adsDetailsPage.verifyAllContensAdsDetails();
        PesanPage pesan = adsDetailsPage.clickHubugiPenjual();
        pesan.inputMessage("Hai Seller, ini automation coba diverified");
        pesan.clickSendButton();
    }

    @Test(priority = 3, enabled = false)
    public void verifiySellerAbleToReceiveMessageFromBuyer() {}
}
