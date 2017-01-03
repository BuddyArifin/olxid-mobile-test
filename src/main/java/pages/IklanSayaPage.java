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
    }

    public static final String backBtn = "Navigate up";
    public static final String iklanSayaTitle = "Iklan Saya";
    public static final String moderasiPanel = "Moderasi";
    public static final String aktifPanel = "Aktif";
    public static final String nonAktifPanel = "Non-Aktif";
    public static final String ditolakPanel = "Ditolak";
    public static final String promotePanel = "Promosi";
    public static final String sudahTerjualBtn = "com.app.tokobagus.betterb:id/button_set_sold";
    public static final String scrollMenu = "com.app.tokobagus.betterb:id/pager_tab_strip";
    public static final String linearLayout = "android.widget.LinearLayout";
    public static final String textView = "android.widget.TextView";
    public static final String swipeRefreshLayout = "com.app.tokobagus.betterb:id/swipeRefreshLayout";
    public static final String adList = "com.app.tokobagus.betterb:id/recycler_view_ad_list";
    public static final String frameLayout = "android.widget.FrameLayout";
    public static final String textNoResult = "com.app.tokobagus.betterb:id/text_no_result";
    public static final String adsImg = "com.app.tokobagus.betterb:id/iv_ad_item_image";
    public static final String adsPrice = "com.app.tokobagus.betterb:id/tv_ad_item_price";
    public static final String detailIklanTitle = "Detail Iklan";
    public static final String iconPostAds = "com.app.tokobagus.betterb:id/menu_post_ad";

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
        EditIklanPage editIklanPage = new EditIklanPage(driver);

        if(isElementPresent(getTextLocator(iklanSayaTitle))){
            clickBackBtn();
        }else if(hamburgerBarModule.isHamburgerBar()){
            Assert.assertTrue(true,"Already in HamburgerBar");
        }else if ( isCurrentpageOnDetailsInactiveAds() ) {
            clickBackBtn();
            getBackToMyDetailsAds();
        }else if(isElementPresent(getTextLocator(detailIklanTitle))){
            getBackToMyDetailsAds();
        }else if(adsDetailsPage.deactivateReasonDisplayed()){
            adsDetailsPage.clickCancelDeactivate();
            getBackToMyDetailsAds();
        } else if (paidFeatureModule.isTopListingPopUpPresent()) {
            paidFeatureModule.clickBatalOnTopListing();
            getBackToMyDetailsAds();
        }else if(editIklanPage.editAdsTitleDisplayed()){
            getBackToMyDetailsAds();
        }
    }

    public void getBackToMyDetailsAds() {
        clickBackBtn();
        waitForVisibility(getTextLocator(iklanSayaTitle));
//        clickBackBtn();
    }

    @Step("Verify All Content In IklanSaya Page")
    public void verifyAllContentInIklanSayaPage()
    {
//        verifyandSkipTutorialPostadsImage();

        verifyBackBtn();
        verifyIklanSayaTitle();
        verifyImageAndPrice();
        verifyAktifPanel();
        clickActivePanel();
        verifyAmountOfAds("Aktif");
        verifyModerasiPanel();
        clickModerasiPanel();
        verifyAmountOfAds("Moderasi");
        verifyNonAktifPanel();
        clickNonAktifPanel();
        verifyAmountOfAds("NonAktif");
        verifyDitolakPanel();
        clickDitolakPanel();
        verifyAmountOfAds("Ditolak");
        verifyPromotePanel();
        Log.info("Verify All Content In IklanSaya Page");
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

    public void verifyDitolakPanel(){
        Log.info("Verify Ditolak Panel");
        Assert.assertTrue(isElementPresent(getTextLocator(ditolakPanel)));
    }

    public void verifyNonAktifPanel()
    {
        Log.info("Verify Non Aktif Panel");
        Assert.assertTrue(isElementPresent(getTextLocator(nonAktifPanel)));
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
            case "Aktif" : panel1 = aktifPanel; panel2 = moderasiPanel;break;
            case "Moderasi" : panel1 = moderasiPanel; panel2 = nonAktifPanel;break;
            case "NonAktif" : panel1 = nonAktifPanel; panel2 = ditolakPanel;break;
            case "Ditolak" : panel1 = ditolakPanel; panel2 = promotePanel;break;
        }
        int size = tabMenuText.size();
        String text, text1;
        String actAds = "";
        try {
            for(int i=0; i<size; i++){
                text = tabMenuText.get(i).getText();
                if(text.equalsIgnoreCase(panel1)){
                    text1 = tabMenuText.get(i+1).getText();
                    if(text1.equalsIgnoreCase(panel2)){
                        actAds = "0";
                    }else {
                        actAds = text1;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Log.info("amountInPanel : "+actAds);
        /*int countAds = adsInOnePage.size();
        if(actAds.contains("99")){
            Log.info(key+" ads : "+actAds);
            Assert.assertTrue(countAds > 99, "Amount of "+key+" ads : "+actAds);
        }else if(Integer.parseInt(actAds) == countAds){
            if(Integer.parseInt(actAds) == 0){
                Log.info("There is no "+key+" ads");
                Assert.assertTrue(isWaitElementPresent(getIdLocator(textNoResult)));
            }else {
                Log.info(key+" ads : "+actAds);
                Assert.assertTrue(true, "Amount of "+key+" ads : "+actAds);
            }
        }*/
    }

    public void verifyImageAndPrice()
    {
        Log.info("Verify Image And Price");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(adsImg)), "Images on List Ads, not displayed");
        Assert.assertTrue(isElementPresent(getIdLocator(adsPrice)), "Prices on List Ads, not displayed");
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
        clickElement(getContentLocator(backBtn));
        Log.info("Click Back Button");
    }

    public void clickActivePanel(){
        if(isElementPresent(getTextLocator(aktifPanel))){
            clickElement(getTextLocator(aktifPanel));
        }else {
            swipeRightForPanel();
            clickElement(getTextLocator(aktifPanel));
        }
        Log.info("Click Active Panel");
    }

    public void clickDitolakPanel(){
        clickElement(getTextLocator(ditolakPanel));
        Log.info("Click Ditolak Panel");
    }

    public void clickModerasiPanel()
    {
        if(isElementPresent(getTextLocator(promotePanel))){
            clickElement(getTextLocator(moderasiPanel));
        }else {
            swipeLeftForPanel();
            clickElement(getTextLocator(moderasiPanel));
        }
        Log.info("Click Moderasi Panel");
    }

    public void clickPromotePanel(){
        if(isElementPresent(getTextLocator(promotePanel))){
            swipeLeftForPanel();
            clickElement(getTextLocator(promotePanel));
        }else {
            swipeLeftForPanel();
            clickElement(getTextLocator(promotePanel));
        }
        Log.info("Click Promote Panel");
    }

    public void verifyContentInActivePanel(){
        verifyIklanSayaTitle();
        verifyBackBtn();
        verifyImageAndPrice();
        verifySudahTerjualBtn();
    }

    public void verifyContentInNonAktifPanel(){
        verifyIklanSayaTitle();
        verifyBackBtn();
        verifyImageAndPrice();
    }

    public void verifyContentInDitolakPanel(){
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
        verifyBatalBtn();
        verifyNonAktifkanIklanBtn();
        Log.info("Verify Button Additional Appear After CheckBox Checked");
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
        clickElement(getTextLocator(nonAktifPanel));
        swipePageTopToBtm();
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

    public void verifyandSkipTutorialPostadsImage(){
        if (!checkTutorialsColors(getIdLocator(backBtn))) {
            clickBySize(getPointLocation(getIdLocator(iconPostAds)));
        }
    }

    public boolean isCurrentpageOnDetailsInactiveAds() {
        return isElementPresent(getIdLocator(AdsDetailsPage.copyIklanSbgIklanBaruId));
    }

    private void verifyAdsAvailableOnActive() {
        if (!isAdsonActivePanelExist()) {
            createAdswithSpesificUserId("61474857");
            createAdswithSpesificUserId("60028131");
        }
    }

    private void createAdswithSpesificUserId(String user_id) {
        Log.debug(" Send Request to Sinon --> Create Ads ");
        Sinon sinon = new Sinon();
        sinon.setUser_id(user_id);
        sinon.createAds();
    }

    private boolean isAdsonActivePanelExist() {
        return isElementPresent(getIdLocator(IklanSayaPage.adsImg));
    }
}
