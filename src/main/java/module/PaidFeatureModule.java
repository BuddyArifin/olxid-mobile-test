package module;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.AdsDetailsPage;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by sekarayu on 10/27/16.
 */
public class PaidFeatureModule extends BasePage {
    public static final String titleTopListing = "com.app.tokobagus.betterb:id/md_titleFrame";
    public static final String batalTopListingBtnId = "com.app.tokobagus.betterb:id/md_buttonDefaultNegative";
    public static final String beliTopListingBtnId = "com.app.tokobagus.betterb:id/md_buttonDefaultPositive";
    public static final String msgSuccesspage = "com.app.tokobagus.betterb:id/safety_info_text";
    public static final String tutupSuccessPage = "";
    public static final String titleInsufficientPage = "";
    public static final String msgInsufficientPage = "";
    public static final String batalBtnInsufficientPage = "";
    public static final String reloadBtnInsufficientPage = "";
    public static final String groupRadioButtonId = "com.app.tokobagus.betterb:id/md_contentRecyclerView";
    public static final String textOnRadioButtonId = "com.app.tokobagus.betterb:id/md_title";

    public PaidFeatureModule(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
            @AndroidFindBy(id = groupRadioButtonId),
            @AndroidFindBy(id = textOnRadioButtonId)
    })
    protected List<AndroidElement> listDurasi;

    public void verifyTitleTopListing(){
        Log.info("Verify Title Top Listing");
        Assert.assertTrue(isElementPresent(getIdLocator(titleTopListing)),
                "Title Top Listing on pop up not found");
    }

    public boolean isTopListingPopUpPresent() {
        return isElementPresent(getIdLocator(titleTopListing));
    }

    public void verifyAllDurasiListing() {
        Log.info("Verify Durasi Listing");
        listDurasi.forEach( durations -> {
            Assert.assertTrue(!durations.getText().isEmpty(),
                    "Radio Title not have a Text to verified");
        });
    }

    @Step("Verify Durations List options")
    public void verifyDurationOptOnTopListing(){
        verifyTitleTopListing();
        verifyAllDurasiListing();
    }

    public void verifyBatalBtnOnTopListing(){
        Log.info("Verify Batal Button Top Listing");
        Assert.assertTrue(isElementPresent(getIdLocator(batalTopListingBtnId)),
                "Batal Button Not Found");
    }

    public void verifyBeliBtnOnTopListing(){
        Log.info("Verify Beli Button Top Listing");
        Assert.assertTrue(isElementPresent(getIdLocator(beliTopListingBtnId))
        ,"Beli Top LIsting not found");
    }

    public void clickDurasiDays(int durasiFiturHiglight) {
        listDurasi.forEach( durations -> {
            if (durations.getText().contains(Integer.toString(durasiFiturHiglight))) {
                Log.info("Click Durasi Highlight Listing -> "+durations.getText());
                durations.click();
            }
        });
    }

    public void clickDuration3Days(){
        Log.info("Click duration option 3 days");
        clickDurasiDays(3);
    }

    public void clickDuration7Days(){
        Log.info("Click duration option 7 days");
        clickDurasiDays(7);
    }

    public void clickDuration14Days(){
        Log.info("Click duration option 14 days");
        clickDurasiDays(14);
    }

    public void clickDuration28Days(){
        Log.info("Click duration option 28 days");
        clickDurasiDays(28);
    }

    public AdsDetailsPage clickBatalOnTopListing(){
        Log.info("Click batal button on top listing page");
        clickElement(getIdLocator(batalTopListingBtnId));
        return new AdsDetailsPage(driver);
    }

    public void clickBeliOnTopListing(){
        Log.info("Click beli button on top listing page");
        clickElement(getIdLocator(beliTopListingBtnId));
    }

    public void verifyMsgSuccessPage(){
        Log.info("Verify Msg Success Page : "+getStringText(getIdLocator(msgSuccesspage)));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(msgSuccesspage)),
                "Message Success After Success not Found");
    }

    public void clickTutupSuccessPage(){
        Log.info("Click tutup button on success page");
        clickElement(getIdLocator(tutupSuccessPage));
    }

    public void verifyPageAfterTutupSuccess(){
        //verify if redirected page is correct
    }

    public void verifyTitleInsufPage(){
        Log.info("Verify title on insufficient notification page");
        Assert.assertTrue(isElementPresent(getIdLocator(titleInsufficientPage)));
    }

    public void verifyMsgInsufPage(){
        Assert.assertTrue(isElementPresent(getIdLocator(msgInsufficientPage)));
        Log.info("Verify message on insufficient notification page");
    }

    public void verifyBatalBtnInsufPage(){
        Assert.assertTrue(isElementPresent(getIdLocator(batalBtnInsufficientPage)));
        Log.info("Verify batal btn on insufficient notification page");
    }

    public void verifyIsiulangInsufPage(){
        Assert.assertTrue(isElementPresent(getIdLocator(reloadBtnInsufficientPage)));
        Log.info("Verify isi ulang btn on insufficient notification page");
    }

    public void clickBatalBtnInsufPage(){
        Log.info("Click batal button on insufficient notification page");
        clickElement(getIdLocator(batalBtnInsufficientPage));
    }

    public void clickIsiulangBtnInsufPage(){
        Log.info("Click isi ulang btn on insufficient notification page");
        clickElement(getIdLocator(reloadBtnInsufficientPage));
    }

    public void verifyPageAfterBatalInsuf(){
        //verify if redirected page is correct (previous page)
    }

    public void verifyPageAfterIsiulangInsuf(){
        //verify if redirected page is correct (go to isi ulang saldo olx page)
    }

    public void verifyJangkaWaktuAktifPromosi() {
        Log.info("Verify Msg Jangka Waktu Promosi : "+getStringText(getIdLocator(msgSuccesspage)));
        Assert.assertTrue(isElementPresent(getIdLocator(msgSuccesspage)),
                "Message Jangka Waktu Top Listing not Found");
    }
}
