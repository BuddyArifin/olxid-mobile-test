package module;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.Constants;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;
import static pages.FilterPage.backBtn;
import static module.HamburgerBarModule.avatarSaya;

/**
 * Created by buddyarifin on 8/12/16.
 */
public class LoginWithGplusModule extends BasePage {

    public static final String validEmail = "apps@olx.co.id";
    public static final String listAccountID = "android:id/list";
    public static final String accountName = "com.google.android.gms:id/account_display_name";
    public static final String accountEmail = "com.google.android.gms:id/account_name";
    public static final String addAccount = "android:id/button2";
    public static final String permissionDetailsInfo = "com.google.android.gms:id/scope_description_label";
    public static final String allowBtn = "com.google.android.gms:id/accept_button";
    public static final String denyBtn = "com.google.android.gms:id/cancel_button";
    public static final String categoryPreferences = "com.app.tokobagus.betterb:id/rvCategory";
    //Profile menu when login with Gplus
    public static final String gplusavatar = "com.app.tokobagus.betterb:id/profileView_ivAvatar";
    public static final String gplususername = "com.app.tokobagus.betterb:id/profileView_tvUserName";
    public static final String gpluslogoutbtn = "com.app.tokobagus.betterb:id/profileView_btnLogout";

    public LoginWithGplusModule(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
            @AndroidFindBy(id = listAccountID),
            @AndroidFindBy(className = Constants.linearLayout),
            @AndroidFindBy(className = Constants.linearLayout)
    })
    protected List<AndroidElement> listAccount;

    @Step("Verify Existing Google Account on Devices")
    public void verifyAccountExist() {
        Log.info("Account Available ["+listAccount.size()+"]: ");
        for (int i = 0 ; i < listAccount.size() ; i++) {
            String text = listAccount.get(i).findElementById(accountEmail).getText();
            Log.info("- "+text);
        }
    }

    @Step("Click Selected Google Accounts on Device")
    public void clickSelectedAccounts()
    {
        String text = null;
        Log.info("clickSelectedAccounts");
//        listAccount.get(1).click();
        isWaitElementPresent(getIdLocator(listAccountID));
        for (int i = 0 ; i < listAccount.size() ; i++) {
            text = listAccount.get(i).findElementById(accountEmail).getText();
//            if (text == validEmail)
//            {
//                break;
//            }
        }
        clickElement(getTextLocator(text));
//        waitForVisibilityOf(getIdLocator(allowBtn));
    }

    public void checkPermissionDetails(){
        boolean perminfo = isElementPresent(getIdLocator(permissionDetailsInfo));
        if(perminfo == true){
            verifyPermissionDetailsInfo();
            verifyDenyBtn();
            verifyAllowBtn();
            clickAllowBtn();
        }
    }

    @Step("Verify Permission Details Appear")
    public void verifyPermissionDetailsInfo() {
        Log.info("permissionDetailsAppear");
//        waitForVisibilityOf(getIdLocator(permissionDetailsInfo));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(permissionDetailsInfo)));
    }

    @Step("Verify Allow Button Appear")
    public void verifyAllowBtn() {
        Log.info("verifyAllowBtnAppear");
        Assert.assertTrue(isElementPresent(getIdLocator(allowBtn)));
    }

    @Step("Click Allow Button")
    public void clickAllowBtn() {
        Log.info("clickAllowBtn");
        clickElement(getIdLocator(allowBtn));
    }

    @Step("Verify Deny Button Appear")
    public void verifyDenyBtn() {
        Log.info("verifyDenyBtnAppear");
        Assert.assertTrue(isElementPresent(getIdLocator(denyBtn)));
    }

    @Step("Click Deny Button")
    public void clickDenyBtn() {
        Log.info("clickDenyButton");
        clickElement(getIdLocator(denyBtn));
    }

    @Step("Verify Set Category Preferences")
    public void verifySetCategoryPreferences() {
        Log.info("verifySetCategoryPreferences");
        Assert.assertTrue(isElementPresent(getIdLocator(categoryPreferences)));
    }

    @Step("Verify Listing Page")
    public ListingPage verifyListingPage() {
        return new ListingPage(driver);
    }

    /** Verify Profile Menu when Login with Gplus */

    public void verifyGplusAvatar(){
        Log.info("Verfy Gplus Avatar");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(gplusavatar)));
    }

    public void verifyGplusUsername(){
        Log.info("Verify Gplus Username");
        Assert.assertTrue(isElementPresent(getIdLocator(gplususername)));
    }

    public void verifyGplusLogoutBtn(){
        Log.info("Verify Gplus Logout Btn");
        Assert.assertTrue(isElementPresent(getIdLocator(gpluslogoutbtn)));
    }

    public void verifyGplusProfileContent(){
        verifyGplusAvatar();
        verifyGplusUsername();
        verifyGplusLogoutBtn();
    }

    public LoginPage clickLogOutGPlus(){
        clickElement(getIdLocator(gpluslogoutbtn));
        closeAlertKonf();
        Log.info("Click Logout from Google +");
        return new LoginPage(driver);
    }

    public void initGplusTest() {
        Log.info("Back to initials login with Gplus");
        ListingPage listing = new ListingPage(driver);
        if (listing.isListingButton()) {
            Assert.assertTrue(true, "Already on Home Page");
        } else if (isHamburger()) {
            driver.navigate().back();
        } else if (isOnProfilePage()) {
            clickElement(getContentLocator(backBtn));
            HamburgerBarModule hamburger = new HamburgerBarModule(driver);
            hamburger.closeHamburgerBarDrawer();
        }
    }

    public boolean isHamburger() {
        return isElementPresent(getIdLocator(avatarSaya));
    }

    public boolean isOnProfilePage() {
        return isElementPresent(getIdLocator(gpluslogoutbtn));
    }
}