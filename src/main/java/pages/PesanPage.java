package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by sekarayu on 10/24/16.
 */
public class PesanPage extends BasePage{

    public static final String title = "";
    public static final String jualTab = "";
    public static final String beliTab = "";
    public static final String olxTab = "";
    public static final String hamburgerbar = "";
    public static final String homeBottomMenu = "";
    public static final String kategoriBottomMenu = "";
    public static final String jualBottomMenu = "";
    public static final String pesanBottomMenu = "";
    public static final String faveBottomMenu = "";
    public static final String searchBtn = "";
    public static final String jualAdsImage = "";
    public static final String jualAdsTitle = "";
    public static final String jualMsgTime = "";
    public static final String beliAdsImage = "";
    public static final String beliAdsTitle = "";
    public static final String beliMsgTime = "";
    public static final String selectedProduct = "";
    public static final String msglistBackBtn = "";
    public static final String msglistAdsImage = "";
    public static final String msglistAdsTitle = "";
    public static final String msglistAdsPrice = "";
    public static final String selectedMsg = "";
    public static final String detailTitle = "";
    public static final String detailBackBtn = "";
    public static final String detailAttachmentIcon = "";
    public static final String detailChatArea = "";
    public static final String detailAdsThumbnail = "";
    public static final String detailAdsTitle = "";
    public static final String detailAdsPrice = "";
    public static final String detailOptionBtn = "";
    public static final String detailSendBtn = "";
    public static final String detailChatTemplate = "";
    public static final String detailChatField = "";
    public static final String detailUserAvatar = "";
    public static final String detailStatus = "";
    public static final String detailChatState = "";
    public static final String detailOptBlock = "";
    public static final String detailOptHapus = "";
    public static final String detailAttOptCamera = "";
    public static final String detailAttOptGallery = "";
    public static final String detailAttOptBatal = "";

    public PesanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyHamburgerBar()
    {
        Assert.assertTrue(isElementPresent(getContentLocator(hamburgerbar)));
        Log.info("Verify Hamburger Bar");
    }
    public void verifyTitlePage()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(title)));
        Log.info("Verify Title Page");
    }

    private void verifyJualTab(){
        Assert.assertTrue(isElementPresent(getIdLocator(jualTab)));
        Log.info("Verify Jual Tab");
    }

    private void verifyBeliTab(){
        Assert.assertTrue(isElementPresent(getIdLocator(beliTab)));
        Log.info("Verify Beli Tab");
    }

    private void verifyOlxTab(){
        Assert.assertTrue(isElementPresent(getIdLocator(olxTab)));
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

    @Step("Verify system able to display all contents in Pesan")
    public void verifyContentPesanPage(){
        Log.info("Verify all contents of PesanPage");
        verifyTitlePage();
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
        clickElement(getIdLocator(jualTab));
    }

    public void clickBeliTab(){
        Log.info("Click Beli Tab");
        clickElement(getIdLocator(beliTab));
    }

    public void clickOlxTab(){
        Log.info("Click Olx Tab");
        clickElement(getIdLocator(olxTab));
    }

    public void verifyMessageJual(){
        clickJualTab();
        Assert.assertTrue(isElementPresent(getIdLocator(jualAdsImage)));
        Assert.assertTrue(isElementPresent(getIdLocator(jualAdsTitle)));
        Assert.assertTrue(isElementPresent(getIdLocator(jualMsgTime)));
    }

    public void verifyMessageBeli(){
        clickBeliTab();
        Assert.assertTrue(isElementPresent(getIdLocator(beliAdsImage)));
        Assert.assertTrue(isElementPresent(getIdLocator(beliAdsTitle)));
        Assert.assertTrue(isElementPresent(getIdLocator(beliMsgTime)));
    }

    public void verifyMessageOlx(){
        clickOlxTab();
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
        clickHomeBottomMenu();
    }

    private void verifyAccessKategoriBtm(){
        clickKategoriBottomMenu();
    }

    private void verifyAccessJualBtm(){
        clickJualBottomMenu();
    }

    private void verifyAccessFaveBtm(){
        clickFavoriteBottomMenu();
    }

    public void verifyAccessBottomBarMenu(){
        verifyAccessHomeBtm();
        verifyAccessKategoriBtm();
        verifyAccessJualBtm();
        verifyAccessFaveBtm();
    }

    private void verifyAftProdBackBtn(){
        Assert.assertTrue(isElementPresent(getIdLocator(msglistBackBtn)));
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

    public void clickSelectedProduct(){
        Log.info("Click Selected Product");
        clickElement(getIdLocator(selectedProduct));
    }

    public void verifyContentAftSelectProd(){
        clickSelectedProduct();
        verifyAftProdBackBtn();
        verifyAftProdAdsImage();
        verifyAftProdAdsTitle();
        verifyAftProdAdsPrice();
    }

    public void clickBackOnAftProd(){
        Log.info("Click Back Button on After Select Product");
        clickElement(getIdLocator(msglistBackBtn));
    }

    public void verifyPageAfterClickBackOnAftProd(){
        clickBackOnAftProd();
    }

    public void clickSelectedMsg(){
        Log.info("Click Selected Message");
        clickElement(getIdLocator(selectedMsg));
    }

    private void verifyDetTitle(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailTitle)));
        Log.info("Verify Detail Title");
    }

    private void verifyDetBackBtn(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailBackBtn)));
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
        clickSelectedProduct();
        clickSelectedMsg();
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
        clickElement(getIdLocator(detailBackBtn));
    }

    public void verifyBackOnDetailMsg(){
        clickBackOnDetailMsg();
    }

    public void clickOptionOnDetailMsg(){
        Log.info("Click Option Menu on Detail Message Page");
        clickElement(getIdLocator(detailOptionBtn));
    }

    public void verifyOptOnDetailMsg(){
        clickOptionOnDetailMsg();
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
        clickAdsThumbOnDetailMsg();
        //verify page
    }

    public void clickAttIconOnDetailMsg(){
        Log.info("Click Attachment Icon on Detail Message page");
        clickElement(getIdLocator(detailAttachmentIcon));
    }

    private void verifyCamAttOptOnDetailMsg(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAttOptCamera)));
        Log.info("Verify Attachment Option Camera");
    }

    private void verifyGalleryAttOptOnDetailMsg(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAttOptGallery)));
        Log.info("Verify Attachment Option Gallery");
    }

    private void verifyBatalBtnAttOptOnDetailMsg(){
        Assert.assertTrue(isElementPresent(getIdLocator(detailAttOptBatal)));
        Log.info("Verify Attachment Option Batal button");
    }

    public void verifyAttOptOnDetailMsg(){
        clickAttIconOnDetailMsg();
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
        clickElement(getIdLocator(detailAttOptCamera));
    }

    public void clickGallOnAttScreen(){
        Log.info("Click Galeri on Attachment pop up screen");
        clickElement(getIdLocator(detailAttOptGallery));
    }

    public void verifyBatalOnAttScreen(){
        clickAttIconOnDetailMsg();
        clickBatalOnAttScreen();
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

}
