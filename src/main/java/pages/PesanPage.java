package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by sekarayu on 10/24/16.
 */
public class PesanPage extends BasePage{

    public static final String title = "OLX";
    public static final String jualTab = "Jual";
    public static final String beliTab = "Beli";
    public static final String olxTab = "OLX";
    public static final String hamburgerbar = "Navigate up";
    public static final String homeBottomMenu = "com.app.tokobagus.betterb:id/tab_listing";
    public static final String kategoriBottomMenu = "com.app.tokobagus.betterb:id/tab_category";
    public static final String jualBottomMenu = "com.app.tokobagus.betterb:id/tab_postad";
    public static final String pesanBottomMenu = "com.app.tokobagus.betterb:id/tab_messages";
    public static final String faveBottomMenu = "com.app.tokobagus.betterb:id/tab_Favorite";
    public static final String searchBtn = "com.app.tokobagus.betterb:id/search_item";
    public static final String jualAdsImage = "com.app.tokobagus.betterb:id/conversation_image";
    public static final String jualAdsTitle = "com.app.tokobagus.betterb:id/conversation_name";
    public static final String jualMsgTime = "com.app.tokobagus.betterb:id/conversation_lastupdate";
    public static final String beliAdsImage = "com.app.tokobagus.betterb:id/conversation_image";
    public static final String beliAdsTitle = "com.app.tokobagus.betterb:id/conversation_name";
    public static final String beliMsgTime = "com.app.tokobagus.betterb:id/conversation_lastupdate";
    public static final String olxNotifImage = "com.app.tokobagus.betterb:id/notification_icon";
    public static final String olxNotifTitle = "com.app.tokobagus.betterb:id/notification_title";
    public static final String olxNotifTime = "com.app.tokobagus.betterb:id/notification_time";
    public String selectedProduct = "";
    public static final String msglistBackBtn = "Navigate Up";
    public static final String msglistAdsImage = "com.app.tokobagus.betterb:id/imgAdPhoto";
    public static final String msglistAdsTitle = "";
    public static final String msglistAdsPrice = "";
    public static final String msglistChatAvatar = "com.app.tokobagus.betterb:id/conversation_image";
    public static final String msglistChatName = "com.app.tokobagus.betterb:id/conversation_name";
    public static final String msglistChatLastMsg = "com.app.tokobagus.betterb:id/conversation_lastmsg";
    public static final String msglistChatTime = "com.app.tokobagus.betterb:id/conversation_lastupdate";
    public String selectedMsg = "";
    public static final String detailTitle = "";
    public static final String detailBackBtn = "Navigate up";
    public static final String detailAttachmentIcon = "com.app.tokobagus.betterb:id/send_image_button";
    public static final String detailChatArea = "com.app.tokobagus.betterb:id/chat_room_message_list";
    public static final String detailAdsThumbnail = "com.app.tokobagus.betterb:id/ad_image";
    public static final String detailAdsTitle = "com.app.tokobagus.betterb:id/ad_title";
    public static final String detailAdsPrice = "com.app.tokobagus.betterb:id/ad_price";
    public static final String detailOptionBtn = "";
    public static final String detailSendBtn = "com.app.tokobagus.betterb:id/send_text_button";
    public static final String detailChatTemplate = "";
    public static final String detailChatField = "com.app.tokobagus.betterb:id/message";
    public static final String detailUserAvatar = "";
    public static final String detailStatus = "";
    public static final String detailChatState = "";
    public static final String detailOptBlock = "";
    public static final String detailOptHapus = "";
    public static final String detailAttOption = "android:id/text1";
    public static final int detailAttOptCamera = 0;
    public static final String Kamera = "Kamera";
    public static final int detailAttOptGallery = 1;
    public static final String Galeri = "Galeri";
    public static final String detailAttOptBatal = "";
    public static final String loginAlert = "com.app.tokobagus.betterb:id/md_content";
    public static final String loginBtnInAlert = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";

    public PesanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyHamburgerBar()
    {
        Assert.assertTrue(isWaitElementPresent(getContentLocator(hamburgerbar)));
        Log.info("Verify Hamburger Bar");
    }
    public void verifyTitlePage()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(title)));
        Log.info("Verify Title Page");
    }

    private void verifyJualTab(){
        Assert.assertTrue(isElementPresent(getTextLocator(jualTab)));
        Log.info("Verify Jual Tab");
    }

    private void verifyBeliTab(){
        Assert.assertTrue(isElementPresent(getTextLocator(beliTab)));
        Log.info("Verify Beli Tab");
    }

    private void verifyOlxTab(){
        Assert.assertTrue(isElementPresent(getTextLocator(olxTab)));
        Log.info("Verify OLX Tab");
    }

    public void verifyTabs()
    {
        verifyJualTab();
        verifyBeliTab();
        verifyOlxTab();
    }

    private void verifyHomeBottom(){
        Assert.assertTrue(isElementPresent(getIdLocator(homeBottomMenu)));
        Log.info("Verify Home Bottom Menu");
    }

    private void verifyKategoriBottom(){
        Assert.assertTrue(isElementPresent(getIdLocator(kategoriBottomMenu)));
        Log.info("Verify Kategori Bottom Menu");
    }

    private void verifyJualBottom(){
        Assert.assertTrue(isElementPresent(getIdLocator(jualBottomMenu)));
        Log.info("Verify Jual Bottom Menu");
    }

    private void verifyPesanBottom(){
        Assert.assertTrue(isElementPresent(getIdLocator(pesanBottomMenu)));
        Log.info("Verify Pesan Bottom Menu");
    }

    private void verifyFavoriteBottom(){
        Assert.assertTrue(isElementPresent(getIdLocator(faveBottomMenu)));
        Log.info("Verify Favorite Bottom Menu");
    }

    public void verifyBottomBar(){
        verifyHomeBottom();
        verifyKategoriBottom();
        verifyJualBottom();
        verifyPesanBottom();
        verifyFavoriteBottom();
    }

    public void verifySearchBtn(){
        Assert.assertTrue(isElementPresent(getIdLocator(searchBtn)));
        Log.info("Verify Search Button");
    }

    public void verifyContentPesanPage(){
        Log.info("Verify all contents of PesanPage");
        //verifyTitlePage();
        verifyHamburgerBar();
        verifyTabs();
        verifyBottomBar();
        verifySearchBtn();
    }

    public void clickPesanBottomMenu(){
        Log.info("Click Pesan Bottom Menu");
        clickElement(getIdLocator(pesanBottomMenu));
    }

    public void clickJualTab(){
        Log.info("Click Jual Tab");
        clickElement(getTextLocator(jualTab));
    }

    public void clickBeliTab(){
        Log.info("Click Beli Tab");
        clickElement(getTextLocator(beliTab));
    }

    public void clickOlxTab(){
        Log.info("Click Olx Tab");
        clickElement(getTextLocator(olxTab));
    }

    public void verifyMessageJual(){
        //waitForVisibility(getIdLocator(jualAdsImage));
        WaitFor(40);
        Assert.assertTrue(isElementPresent(getIdLocator(jualAdsImage)));
        Assert.assertTrue(isElementPresent(getIdLocator(jualAdsTitle)));
        Assert.assertTrue(isElementPresent(getIdLocator(jualMsgTime)));
    }

    public void verifyMessageBeli(){
        //waitForVisibility(getIdLocator(beliAdsImage));
        WaitFor(25);
        Assert.assertTrue(isElementPresent(getIdLocator(beliAdsImage)));
        Assert.assertTrue(isElementPresent(getIdLocator(beliAdsTitle)));
        Assert.assertTrue(isElementPresent(getIdLocator(beliMsgTime)));
    }

    public void verifyMessageOlx(){
        //waitForVisibility(getIdLocator(olxNotifImage));
        WaitFor(25);
        Assert.assertTrue(isElementPresent(getIdLocator(olxNotifImage)));
        Assert.assertTrue(isElementPresent(getIdLocator(olxNotifTitle)));
        Assert.assertTrue(isElementPresent(getIdLocator(olxNotifTime)));
    }

    public void verifyUnreadMessages(){
        //check number of unread messages
        //if > 0 then okay
        verifyUnreadAll();
        verifyUnreadJual();
        verifyUnreadBeli();
        verifyUnreadOlx();
    }

    public void verifyNoUnreadMessages(){
        //check number of unread messages
        //if =0 then okay
        verifyUnreadAll();
        verifyUnreadJual();
        verifyUnreadBeli();
        verifyUnreadOlx();
    }

    private void verifyUnreadAll(){
        //make it return number of unread messages
        clickPesanBottomMenu();
    }

    private void verifyUnreadJual(){
        //make it return number of unread messages
        clickJualTab();
    }

    private void verifyUnreadBeli(){
        //make it return number of unread messages
        clickBeliTab();
    }

    private void verifyUnreadOlx(){
        //make it return number of unread messages
        clickOlxTab();
    }

    public void clickHomeBottomMenu(){
        clickElement(getIdLocator(homeBottomMenu));
    }

    public void clickKategoriBottomMenu(){
        clickElement(getIdLocator(kategoriBottomMenu));
    }

    public void clickJualBottomMenu(){
        clickElement(getIdLocator(jualBottomMenu));
    }

    public void clickFavoriteBottomMenu(){
        clickElement(getIdLocator(faveBottomMenu));
    }

    private void verifyAccessHomeBtm(){
        clickPesanBottomMenu();
        clickHomeBottomMenu();
    }

    private void verifyAccessKategoriBtm(){
        clickPesanBottomMenu();
        clickKategoriBottomMenu();
    }

    private void verifyAccessJualBtm(){
        clickPesanBottomMenu();
        clickJualBottomMenu();
    }

    private void verifyAccessFaveBtm(){
        clickPesanBottomMenu();
        clickFavoriteBottomMenu();
    }

    public void verifyAccessBottomBarMenu(){
        verifyAccessHomeBtm();
        verifyAccessKategoriBtm();
        verifyAccessJualBtm();
        verifyAccessFaveBtm();
    }

    private void verifyAftProdBackBtn(){
        Assert.assertTrue(isElementPresent(getContentLocator(msglistBackBtn)));
        Log.info("Verify Back Button on Message List After Select Product");
    }

    private void verifyAftProdAdsImage(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistAdsImage)));
        Log.info("Verify Ads Image on Message List After Select Product");
    }

    private void verifyAftProdAdsTitle(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistAdsTitle)));
        Log.info("Verify Ads Title on Message List After Select Product");
    }

    private void verifyAftProdAdsPrice(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistAdsPrice)));
        Log.info("Verify Ads Price on Message List After Select Product");
    }

    private void verifyAftProdChatAvatar(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistChatAvatar)));
        Log.info("Verify Sender Avatar on Message List After Select Product");
    }

    private void verifyAftProdChatName(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistChatName)));
        Log.info("Verify Sender Name on Message List After Select Product");
    }

    private void verifyAftProdChatLastMsg(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistChatLastMsg)));
        Log.info("Verify Last Message on Message List After Select Product");
    }

    private void verifyAftProdChatTime(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistChatTime)));
        Log.info("Verify Chat Time on Message List After Select Product");
    }

    public void clickSelectedProduct(){
        //click ads title/avatar
        Log.info("Click Selected Product");
        clickElement(getIdLocator(selectedProduct));
    }

    public void verifyContentAftSelectProd(){
        verifyAftProdBackBtn();
        verifyAftProdAdsImage();
        //verifyAftProdAdsTitle();
        //verifyAftProdAdsPrice();
        verifyAftProdChatAvatar();
        verifyAftProdChatName();
        verifyAftProdChatLastMsg();
        verifyAftProdChatTime();
    }

    public void clickBackOnAftProd(){
        Log.info("Click Back Button on After Select Product");
        clickElement(getContentLocator(msglistBackBtn));
    }

    public void verifyPageAfterClickBackOnAftProd(){
        //verify redirected page
        verifyMessageJual();
    }

    public void clickSelectedMsg(){
        Log.info("Click Selected Message");
        //click chat avatar/chat name
        clickElement(getIdLocator(selectedMsg));
    }

    private void verifyDetTitle(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailTitle)));
        Log.info("Verify Detail Title");
    }

    private void verifyDetBackBtn(){
        Assert.assertTrue(isElementPresent(getContentLocator(detailBackBtn)));
        Log.info("Verify Detail Back Button");
    }

    private void verifyDetAttachIcon(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAttachmentIcon)));
        Log.info("Verify Detail Attachment Icon");
    }

    private void verifyDetOptionBtn(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailOptionBtn)));
        Log.info("Verify Detail Option Button");
    }

    private void verifyDetSendBtn(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailSendBtn)));
        Log.info("Verify Detail Send Buttton");
    }

    private void verifyDetChatArea(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailChatArea)));
        Log.info("Verify Detail Chat Area");
    }

    private void verifyDetChatField(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailChatField)));
        Log.info("Verify Detail Chat Field");
    }

    private void verifyDetAdsThumbnail(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAdsThumbnail)));
        Log.info("Verify Detail Ads Thumbnail");
    }

    private void verifyDetAdsTitle(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAdsTitle)));
        Log.info("Verify Detail Ads Title");
    }

    private void verifyDetAdsPrice(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAdsPrice)));
        Log.info("Verify Detail Ads Price");
    }

    private void verifyDetChatTemplate(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailChatTemplate)));
        Log.info("Verify Detail Chat Template");
    }

    public void verifyDetUserAvatar(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailUserAvatar)));
        Log.info("Verify Detail User Avatar");
    }

    private void verifyDetStatus(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailStatus)));
        Log.info("Verify Detail Status");
    }

    private void verifyDetChatState(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailChatState)));
        Log.info("Verify Detail Chat State");
    }

    public void verifyContentMessageDetail(){
        Log.info("Verify all content message detail");
        verifyDetTitle();
        verifyDetBackBtn();
        verifyDetAttachIcon();
        verifyDetOptionBtn();
        verifyDetChatArea();
        verifyDetChatField();
        verifyDetSendBtn();
        verifyDetAdsThumbnail();
        verifyDetAdsTitle();
        verifyDetAdsPrice();
        verifyDetChatTemplate();
        verifyDetUserAvatar();
        verifyDetStatus();
        verifyDetChatState();
    }

    public void clickBackOnDetailMsg(){
        Log.info("Click Back on Detail Message page");
        clickElement(getContentLocator(detailBackBtn));
    }

    public void verifyBackOnDetailMsg(){
        //verify redirected page
    }

    public void clickOptionOnDetailMsg(){
        Log.info("Click Option Menu on Detail Message Page");
        clickElement(getIdLocator(detailOptionBtn));
    }

    public void verifyOptOnDetailMsg(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailOptBlock)));
        Log.info("Verify Option Block User");
        Assert.assertTrue(isElementPresent(getIdLocator(detailOptHapus)));
        Log.info("Verify Option Hapus Percakapan");
    }

    public void clickAdsThumbOnDetailMsg(){
        Log.info("Click Ads Thumbnail on Detail Message page");
        clickElement(getIdLocator(detailAdsThumbnail));
    }

    public void verifyPageAftClickAdsThumb(){
        //verify page
    }

    public void clickAttIconOnDetailMsg(){
        Log.info("Click Attachment Icon on Detail Message page");
        clickElement(getIdLocator(detailAttachmentIcon));
    }

    private void verifyCamAttOptOnDetailMsg(){
        String kamera = driver.findElements(By.id(detailAttOption)).get(detailAttOptCamera).getText();
        Assert.assertTrue(kamera.equalsIgnoreCase(Kamera));
        Log.info("Verify Attachment Option Camera");
    }

    private void verifyGalleryAttOptOnDetailMsg(){
        String galeri = driver.findElements(By.id(detailAttOption)).get(detailAttOptGallery).getText();
        Assert.assertTrue(galeri.equalsIgnoreCase(Galeri));
        Log.info("Verify Attachment Option Gallery");
    }

    private void verifyBatalBtnAttOptOnDetailMsg(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAttOptBatal)));
        Log.info("Verify Attachment Option Batal button");
    }

    public void verifyAttOptOnDetailMsg(){
        verifyCamAttOptOnDetailMsg();
        verifyGalleryAttOptOnDetailMsg();
        verifyBatalBtnAttOptOnDetailMsg();
    }

    public void clickBatalOnAttScreen(){
        Log.info("Click Batal button on Attachment pop up screen");
        clickElement(getIdLocator(detailAttOptBatal));
    }

    public void clickCamOnAttScreen(){
        Log.info("Click Kamera on Attachment pop up screen");
        driver.findElements(By.id(detailAttOption)).get(detailAttOptCamera).click();
    }

    public void clickGallOnAttScreen(){
        Log.info("Click Galeri on Attachment pop up screen");
        driver.findElements(By.id(detailAttOption)).get(detailAttOptGallery).click();
    }

    public void verifyBatalOnAttScreen(){
        //verify redirect page
        //verify pop up disappear
    }

    public void verifyBuyerChatTempOnDetailMsg(){
        verifyDetChatTemplate();
        //verify the content of the templates
        //if content == buyer content, then OK
    }

    public void verifySellerChatTempOnDetailMsg(){
        verifyDetChatTemplate();
        //verify the content of the templates
        //if content == seller content, then OK
    }

    public void chooseChatTempOnDetailMsg(){
        Log.info("Choose a Chat Template");
        clickElement(getIdLocator(detailChatTemplate));
    }

    public void verifyChatTempSentOnDetailMsg(){
        Log.info("Verify Chat Template was sent to Chat Area");
        //check chat template exist in chat area
    }

    public void verifyLoginAlertDisplayed(){
        Assert.assertTrue(isElementPresent(getIdLocator(loginAlert)));
        Assert.assertTrue(isElementPresent(getIdLocator(loginBtnInAlert)));
        Log.info("Verify Login Alert Displayed");
    }

    public void clickLoginOnLoginAlert(){
        Log.info("Click Login btn in Login Alert");
        clickElement(getIdLocator(loginBtnInAlert));
    }

}
