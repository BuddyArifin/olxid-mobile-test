package module;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import utils.Log;

/**
 * Created by sekarayu on 10/27/16.
 */
public class PaidFeatureModule extends BasePage {
    public static final String topListingBtn = "";
    public static final String titleTopListing = "";
    public static final String opt3daysTopListing = "";
    public static final String opt7daysTopListing = "";
    public static final String opt14daysTopListing = "";
    public static final String opt28daysTopListing = "";
    public static final String batalTopListingBtn = "";
    public static final String beliTopListingBtn = "";
    public static final String msgSuccesspage = "";
    public static final String tutupSuccessPage = "";
    public static final String titleInsufficientPage = "";
    public static final String msgInsufficientPage = "";
    public static final String batalBtnInsufficientPage = "";
    public static final String reloadBtnInsufficientPage = "";

    public PaidFeatureModule(WebDriver driver) { super(driver); }

    public void clickTopListing(){
        Log.info("Click Use Top Listing Button");
        clickElement(getIdLocator(topListingBtn));
    }

    public void verifyTitleTopListing(){
        Assert.assertTrue(isElementPresent(getIdLocator(titleTopListing)));
        Log.info("Verify Title Top Listing");
    }

    private void verifyDuration3Days(){
        Assert.assertTrue(isElementPresent(getIdLocator(opt3daysTopListing)));
        Log.info("Verify Duration Option 3 Days");
    }

    private void verifyDuration7Days(){
        Assert.assertTrue(isElementPresent(getIdLocator(opt7daysTopListing)));
        Log.info("Verify Duration Option 7 Days");
    }

    private void verifyDuration14Days(){
        Assert.assertTrue(isElementPresent(getIdLocator(opt14daysTopListing)));
        Log.info("Verify Duration Option 14 Days");
    }

    private void verifyDuration28Days(){
        Assert.assertTrue(isElementPresent(getIdLocator(opt28daysTopListing)));
        Log.info("Verify Duration Option 28 Days");
    }

    public void verifyDurationOptOnTopListing(){
        verifyDuration3Days();
        verifyDuration7Days();
        verifyDuration14Days();
        verifyDuration28Days();
    }

    public void verifyBatalBtnOnTopListing(){
        Assert.assertTrue(isElementPresent(getIdLocator(batalTopListingBtn)));
        Log.info("Verify Batal Button Top Listing");
    }

    public void verifyBeliBtnOnTopListing(){
        Assert.assertTrue(isElementPresent(getIdLocator(beliTopListingBtn)));
        Log.info("Verify Beli Button Top Listing");
    }

    public void clickDuration3Days(){
        Log.info("Click duration option 3 days");
        clickElement(getIdLocator(opt3daysTopListing));
    }

    public void clickDuration7Days(){
        Log.info("Click duration option 7 days");
        clickElement(getIdLocator(opt7daysTopListing));
    }

    public void clickDuration14Days(){
        Log.info("Click duration option 14 days");
        clickElement(getIdLocator(opt14daysTopListing));
    }

    public void clickDuration28Days(){
        Log.info("Click duration option 28 days");
        clickElement(getIdLocator(opt28daysTopListing));
    }

    public void clickBatalOnTopListing(){
        Log.info("Click batal button on top listing page");
        clickElement(getIdLocator(batalTopListingBtn));
    }

    public void clickBeliOnTopListing(){
        Log.info("Click beli button on top listing page");
        clickElement(getIdLocator(beliTopListingBtn));
    }

    public void verifyMsgSuccessPage(){
        Assert.assertTrue(isElementPresent(getIdLocator(msgSuccesspage)));
        Log.info("Verify Msg Success Page");
    }

    public void clickTutupSuccessPage(){
        Log.info("Click tutup button on success page");
        clickElement(getIdLocator(tutupSuccessPage));
    }

    public void verifyPageAfterTutupSuccess(){
        //verify if redirected page is correct
    }

    public void verifyTitleInsufPage(){
        Assert.assertTrue(isElementPresent(getIdLocator(titleInsufficientPage)));
        Log.info("Verify title on insufficient notification page");
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
}
