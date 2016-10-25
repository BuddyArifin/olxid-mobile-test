package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PesanPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by sekarayu on 10/24/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Pesan Feature")
public class PesanTest extends AndroidSetup {
    PesanPage pesanPage;
    LoginPage loginPage;
    HamburgerBarModule hamburgerBarModule;

    @Stories("As a user I want to be able to see Pesan layout contents")
    @Title("Verify system able to display all contents in Pesan")
    @TestCaseId("TC_PESAN_10_001, TC_PESAN_10_002")
    @Test(priority = 1, enabled = false)
    public void verifyContentDisplayPesanPage(){
        loginPage = new LoginPage(driver);

        pesanPage.verifyContentPesanPage();
    }

    @Stories("As a user I want to be able to see messages under Jual tab")
    @Title("Verify system able to display all Pesan contents under Jual tab")
    @TestCaseId("TC_PESAN_10_003")
    @Test(priority = 2, enabled = false)
    public void verifyMessageJual(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.verifyMessageJual();
    }

    @Stories("As a user I want to be able to see messages under Beli tab")
    @Title("Verify system able to display all Pesan contents under Beli tab")
    @TestCaseId("TC_PESAN_10_004")
    @Test(priority = 3, enabled = false)
    public void verifyMessageBeli(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.verifyMessageBeli();
    }

    @Stories("As a user I want to be able to see messages under OLX tab")
    @Title("Verify system able to display all Pesan contents under OLX tab")
    @TestCaseId("TC_PESAN_10_005")
    @Test(priority = 4, enabled = false)
    public void verifyMessageOlx(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.verifyMessageOlx();
    }

    @Stories("As a user I want to be able to see the number of unread messages")
    @Title("Verify system able to display number of unread messages/notifications for each tabs : Jual, Beli, OLX and also in the Bottom bar (menu Pesan)")
    @TestCaseId("TC_PESAN_10_006")
    @Test(priority = 5, enabled = false)
    public void verifyUnreadMessages(){
        pesanPage.verifyUnreadMessages();
    }

    @Stories("As a user I won't be able to see the number of unread messages for each tabs if I don't have any unread messages")
    @Title("Verify system able to display each tabs (Jual, Beli, OLX) without the number of unread messages, also in the Bottom Bar")
    @TestCaseId("TC_PESAN_10_007")
    @Test(priority = 6, enabled = false)
    public void verifyNoUnreadMessages(){
        pesanPage.verifyNoUnreadMessages();
    }

    @Stories("As a user I want to be able to access Bottom Bar menu from Chat/Message page")
    @Title("Verify system able to access Bottom bar menu from Chat/Message page")
    @TestCaseId("TC_PESAN_10_009")
    @Test(priority = 7, enabled = false)
    public void verifyAccessBottomBarMenu(){ pesanPage.verifyAccessBottomBarMenu(); }

    @Stories("As a user I want to be able to see Pesan layout after select a product")
    @Title("Verify system able to display Pesan layout after select a product")
    @TestCaseId("TC_PESAN_10_010")
    @Test(priority = 8, enabled = false)
    public void verifyContentAftProd(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.verifyContentAftSelectProd();
    }

    @Stories("As a user I want to be able to click Back from chat/message list page")
    @Title("Verify system able to redirect to Pesan main menu from chat/message list page")
    @TestCaseId("TC_PESAN_10_012")
    @Test(priority = 9, enabled = false)
    public void verifyAftClickBackOnAftProd(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickBackOnAftProd();
        pesanPage.verifyPageAfterClickBackOnAftProd();
    }

    @Stories("As a user I want to be able to see Chat layout contents")
    @Title("Verify system able to display Chat layout contents")
    @TestCaseId("TC_PESAN_10_011, TC_PESAN_10_013")
    @Test(priority = 10, enabled = false)
    public void verifyContentMsgDetail(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.verifyContentMessageDetail();
    }

    @Stories("As a user I want to be able to see user's initial in Chat layout")
    @Title("Verify system able to display user's initial in Chat layout for user who doesn't have avatar")
    @TestCaseId("TC_PESAN_10_014")
    @Test(priority = 11, enabled = false)
    public void verifyInitialAvatar(){
        pesanPage.verifyDetUserAvatar();
    }

    @Stories("As a user I want to be able to go back from message/chat details page")
    @Title("Verify system able to go back from message/chat details page")
    @TestCaseId("TC_PESAN_10_015")
    @Test(priority = 12, enabled = false)
    public void verifyBackOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.clickBackOnDetailMsg();
        pesanPage.verifyBackOnDetailMsg();
    }

    @Stories("As a user I want to be able to see Option list from message/chat page")
    @Title("Verify system able to display option list menu from message/chat page")
    @TestCaseId("TC_PESAN_10_016")
    @Test(priority = 13, enabled = false)
    public void verifyOptionMenuOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.clickOptionOnDetailMsg();
        pesanPage.verifyOptOnDetailMsg();
    }

    @Stories("As a user I want to be able to go to Ads Detail page from message/chat page")
    @Title("Verify system able to redirect to Ads Detail page from message/chat page")
    @TestCaseId("TC_PESAN_10_017")
    @Test(priority = 14, enabled = false)
    public void verifyPageAftClickAdsAvtOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.clickAdsThumbOnDetailMsg();
        pesanPage.verifyPageAftClickAdsThumb();
    }

    @Stories("As a user I want to be able to see option list of Attachment (paperclip) icon")
    @Title("Verify system able to display option list menu of Attachment (paperclip) icon")
    @TestCaseId("TC_PESAN_10_018")
    @Test(priority = 15, enabled = false)
    public void verifyAttOptionOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.clickAttIconOnDetailMsg();
        pesanPage.verifyAttOptOnDetailMsg();
    }

    @Stories("As a user I want to be able to cancel attaching/uploading image")
    @Title("Verify system able to click Batal/Cancel button from Attachment pop up screen")
    @TestCaseId("TC_PESAN_10_019")
    @Test(priority = 16, enabled = false)
    public void verifyBatalAttOptOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.clickAttIconOnDetailMsg();
        pesanPage.clickBatalOnAttScreen();
        pesanPage.verifyBatalOnAttScreen();
    }

    @Stories("As a user I want to be able to see Chat Templates for Buyer")
    @Title("Verify system able to display list of Chat Templates for Buyer")
    @TestCaseId("TC_PESAN_10_022")
    @Test(priority = 17, enabled = false)
    public void verifyBuyerChatTemplatesOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickBeliTab();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.verifyBuyerChatTempOnDetailMsg();
    }

    @Stories("As a user I want to be able to see Chat Templates for Seller")
    @Title("Verify system able to display list of Chat Templates for Seller")
    @TestCaseId("TC_PESAN_10_023")
    @Test(priority = 18, enabled = false)
    public void verifySellerChatTemplatesOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickJualTab();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.verifySellerChatTempOnDetailMsg();
    }

    @Stories("As a user I want to be able to send message reply using Chat Template")
    @Title("Verify system able to send reply using Chat Template")
    @TestCaseId("TC_PESAN_10_024")
    @Test(priority = 19, enabled = false)
    public void verifyChatTempSentOnDetMsg(){
        pesanPage.clickPesanBottomMenu();
        pesanPage.clickSelectedProduct();
        pesanPage.clickSelectedMsg();
        pesanPage.chooseChatTempOnDetailMsg();
        pesanPage.verifyChatTempSentOnDetailMsg();
    }

}
