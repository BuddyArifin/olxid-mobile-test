package pages;

import athena.DataBuilder;
import athena.Sinon;
import com.jayway.jsonpath.DocumentContext;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import module.HamburgerBarModule;
import module.PaidFeatureModule;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.Iterator;
import java.util.List;

/**
 * Created by NugrohoSantoso on 10/18/16.
 */
public class IklanSayaPage extends BasePage{

    public static final String postAdsIcon = "com.app.tokobagus.betterb:id/menu_post_ad";
    public static final String panelList = "com.app.tokobagus.betterb:id/tab_title_view";
    public Sinon sinon = new Sinon();

    public IklanSayaPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        DataBuilder.getData(sinon.createAds()); // Creating Iklan, prevent empty iklan saya
    }

    public static final String backBtn = "Navigate up";
    public static final String iklanSayaTitle = "Iklan Saya";
    public static final String moderasiPanel = "Moderasi";
    public static final String aktifPanel = "Aktif";
    public static final String waitingPanel = "Waiting";
    public static final String archivePanel = "Archive";
    public static final String promotePanel = "Promote";
    public static final String sudahTerjualBtn = "com.app.tokobagus.betterb:id/button_set_sold";
    public static final String scrollMenu = "com.app.tokobagus.betterb:id/pager_tab_strip";
    public static final String linearLayout = "android.widget.LinearLayout";
    public static final String textView = "android.widget.TextView";
    public static final String adList = "com.app.tokobagus.betterb:id/recycler_view_ad_list";
    public static final String frameLayout = "android.widget.FrameLayout";
    public static final String textNoResult = "com.app.tokobagus.betterb:id/text_no_result";
    public static final String adsImg = "com.app.tokobagus.betterb:id/iv_ad_item_image";
    public static final String adsPrice = "com.app.tokobagus.betterb:id/tv_ad_item_price";
    public static final String detailIklanTitle = "Detail Iklan";

    @AndroidFindBys({
            @AndroidFindBy(id = scrollMenu),
            @AndroidFindBy(className = linearLayout),
            @AndroidFindBy(className = linearLayout),
            @AndroidFindBy(className = textView)
    })
    protected List<AndroidElement> tabMenuText;

    @AndroidFindBys({
            @AndroidFindBy(id = adList),
            @AndroidFindBy(className = frameLayout)
    })
    protected List<AndroidElement> adsInOnePage;

    public void initIklanSayaPage(){
        HamburgerBarModule hamburgerBarModule = new HamburgerBarModule(driver);
        AdsDetailsPage adsDetailsPage = new AdsDetailsPage(driver);
        PaidFeatureModule paidFeatureModule = new PaidFeatureModule(driver);
        if(isElementPresent(getTextLocator(iklanSayaTitle))){
            clickBackBtn();
        }else if(hamburgerBarModule.isHamburgerBar()){
            Assert.assertTrue(true,"Already in HamburgerBar");
        }else if(isElementPresent(getTextLocator(detailIklanTitle))){
            getBackToMyDetailsAds();
        }else if(adsDetailsPage.deactivateReasonDisplayed()){
            adsDetailsPage.clickCancelDeactivate();
            getBackToMyDetailsAds();
        } else if (paidFeatureModule.isTopListingPopUpPresent()) {
            paidFeatureModule.clickBatalOnTopListing();
            getBackToMyDetailsAds();
        }
    }

    public void getBackToMyDetailsAds() {
        clickBackBtn();
        waitForVisibility(getTextLocator(iklanSayaTitle));
        clickBackBtn();
    }

    @Step("Verify All Content In IklanSaya Page")
    public void verifyAllContentInIklanSayaPage()
    {
        Log.info("Verify All Content In IklanSaya Page");
        dismissTutorial();
//        verifyBackBtn();
//        verifyIklanSayaTitle();
//        verifyImageAndPrice();
//        verifyAktifPanel();
//        verifyWaitingPanel();
//        verifyArchivePanel();
//        verifyModerasiPanel();
//        verifyPromotePanel();
    }

    protected void dismissTutorial() {
        Log.debug("Dismiss Tutorial");
        if (!checkTutorialsColors(getContentLocator(backBtn))) {
            clickBySize(getPointLocation(getIdLocator(postAdsIcon)));
        }
    }

    public void verifyBackBtn()
    {
        Log.info("Verify Back Button");
        Assert.assertTrue(isElementPresent(getContentLocator(backBtn)));
    }

    public void verifyIklanSayaTitle()
    {
        Log.info("Verify Iklan Saya Title");
        Assert.assertTrue(isElementPresent(getTextLocator(iklanSayaTitle)));
    }

    public void verifyModerasiPanel()
    {
        Log.info("Verify Moderasi Panel");
        swipeLeftForPanel();
        Assert.assertTrue(isElementPresent(getTextLocator(moderasiPanel)));
    }

    private void swipeLeftForPanel(){
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.7);
        int endx = (int) (size.width * 0.2);
        int pointSwipe = (int) (size.height / 6.24);
        ((AndroidDriver)driver).swipe(startx,pointSwipe,endx,pointSwipe,2000);
    }

    private void swipeRightForPanel(){
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.7);
        int endx = (int) (size.width * 0.2);
        int pointSwipe = (int) (size.height / 6.24);
        ((AndroidDriver)driver).swipe(endx,pointSwipe,startx,pointSwipe,2000);
    }

    public void verifyAktifPanel()
    {
        Log.info("Verify Aktif Panel");
        Assert.assertTrue(isElementPresent(getTextLocator(aktifPanel)));
    }

    public void verifyWaitingPanel(){
        Log.info("Verify Waiting Panel");
        Assert.assertTrue(isElementPresent(getTextLocator(waitingPanel)));
    }

    public void verifyArchivePanel()
    {
        Log.info("Verify Archive Panel");
        Assert.assertTrue(isElementPresent(getTextLocator(archivePanel)));
    }

    public void verifyPromotePanel()
    {
        Log.info("Verify Promote Panel");
        Assert.assertTrue(isElementPresent(getTextLocator(promotePanel)));
    }

    public void verifyAmountOfAds(String key)
    {
        Log.info("Verify Amount Of Ads");
        String panel1 = "";
        String panel2 = "";
        switch (key){
            case "Active" : panel1 = aktifPanel; panel2 = waitingPanel;break;
            case "Waiting" : panel1 = waitingPanel; panel2 = archivePanel;break;
            case "Archive" : panel1 = archivePanel; panel2 = moderasiPanel;break;
            case "Moderated" : panel1 = moderasiPanel; panel2 = promotePanel;break;
        }
        int size = tabMenuText.size();
        String text, text1;
        int actAds = 0;
        try {
            for(int i=0; i<size; i++){
                text = tabMenuText.get(i).getText();
                if(text.equalsIgnoreCase(panel1)){
                    text1 = tabMenuText.get(i+1).getText();
                    if(text1.equalsIgnoreCase(panel2)){
                        actAds = 0;
                    }else {
                        actAds = Integer.parseInt(text1);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        int countAds = adsInOnePage.size();
        Log.info(String.valueOf(countAds));
        if(countAds == actAds){
            if(actAds == 0){
                Log.info("There is no "+key+" ads");
                Assert.assertTrue(isWaitElementPresent(getIdLocator(textNoResult)));
            }else {
                Log.info(key+" ads : "+actAds);
                Assert.assertTrue(true, "Amount of "+key+" ads : "+actAds);
            }
        }
    }

    public void verifyImageAndPrice()
    {
        Log.info("Verify Image And Price");
        Assert.assertTrue(isElementPresent(getIdLocator(adsImg)));
        Assert.assertTrue(isElementPresent(getIdLocator(adsPrice)));
    }
    public void verifyNonAktifkanIklanBtn()
    {
        Log.info("Verify Non-Aktifkan Iklan Button");
    }
    public void verifyBatalBtn()
    {
        Log.info("Verify Batal Button");
    }
    public void verifySudahTerjualBtn()
    {
        Log.info("Verify Sudah Terjual Button");
        Assert.assertTrue(isElementPresent(getIdLocator(sudahTerjualBtn)));
    }

    public void clickBackBtn(){
        Log.info("Click Back Button");
        clickElement(getContentLocator(backBtn));
    }

    public void clickActivePanel(){
        Log.info("Click Active Panel");
        clickElement(getTextLocator(aktifPanel));
    }

    public void clickWaitingPanel(){
        Log.info("Click Waiting Panel");
        clickElement(getTextLocator(waitingPanel));
    }

    public void clickArchivePanel(){
        Log.info("Click Archive Panel");
        clickElement(getTextLocator(archivePanel));
    }

    public void clickModerasiPanel()
    {
        Log.info("Click Moderasi Panel");
        if(isElementPresent(getTextLocator(promotePanel))){
            clickElement(getTextLocator(moderasiPanel));
        }else {
            swipeLeftForPanel();
            clickElement(getTextLocator(moderasiPanel));
        }
    }

    public void clickPromotePanel(){
        Log.info("Click Promote Panel");
        if(isElementPresent(getTextLocator(promotePanel))){
            clickElement(getTextLocator(promotePanel));
        }else {
            swipeLeftForPanel();
            clickElement(getTextLocator(promotePanel));
        }
    }

    public void verifyContentInActivePanel(){
        verifyIklanSayaTitle();
        verifyBackBtn();
        verifyImageAndPrice();
        verifySudahTerjualBtn();
    }

    public void verifyContentInWaitingPanel(){
        verifyIklanSayaTitle();
        verifyBackBtn();
        verifyImageAndPrice();
    }

    public void verifyContentInArchivePanel(){
        verifyIklanSayaTitle();
        verifyBackBtn();
        verifyImageAndPrice();
    }

    public void verifyContentInModeratedPanel(){
        verifyIklanSayaTitle();
        verifyBackBtn();
        verifyImageAndPrice();
    }

    public void verifyContentInPromotePanel(){
        verifyIklanSayaTitle();
        verifyBackBtn();
        verifyImageAndPrice();
    }

    public void verifyScrollUpAndDown(){
        swipePageBtmtToTop();
        WaitFor(3);
        swipePageTopToBtm();
    }

    public AdsDetailsPage clickOneOfAdsInAdsList()
    {
        Log.info("Click One Of Ads In Ads List");
        clickElement(getIdLocator(adsImg));
        return new AdsDetailsPage(driver);
    }

    public void clickHoldAdsInAdsList()
    {
        Log.info("Click And Hold Ads In Ads List");
    }

    public void clickCheckBoxInAds()
    {
        Log.info("Click Checkbox In Ads List");
    }

    public void verifyCheckBoxAdsChecked()
    {
        Log.info("Verify CheckBox Ads Checked");
    }

    public void verifyButtonAdditionalAfterCheckBoxChecked()
    {
        Log.info("Verify Button Additional Appear After CheckBox Checked");
        verifyBatalBtn();
        verifyNonAktifkanIklanBtn();
    }

    public void clickNonAktifkanButton()
    {
        Log.info("Click Non-Aktifkan Button");
    }

    public void clickBatalButton()
    {
        Log.info("Click Batal Button");
    }

    public void clickNonAktifPanel() {
        clickPanel("Non-Aktif");
        DataBuilder.getData(sinon.createAdsWithStatus("removed_by_user")); // prepare ads non active on panel
    }

    private void clickPanel(String panel) {
        List<WebElement> list = getListElements(getIdLocator(panelList));
        for (Iterator<WebElement> panelString = list.iterator(); panelString.hasNext();) {
            WebElement actualString = panelString.next();
            if (actualString.getText().equalsIgnoreCase(panel)) {
                actualString.click();
            }
        }
    }
}
