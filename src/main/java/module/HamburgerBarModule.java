package module;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.IklanSayaPage;
import pages.ListingPage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by NugrohoSantoso on 9/9/16.
 */
public class HamburgerBarModule extends BasePage {

    public static final String avatarSaya = "com.app.tokobagus.betterb:id/sidemenu_tvAvatarName";
    public static final String profilSayaBtn = "Profil Saya";
    public static final String iklanSayaBtn = "Iklan Saya";
    public static final String saldoOLXBtn = "Saldo OLX";
    public static final String pusatBantuanBtn = "Pusat Bantuan";
    public static final String tentangOLXBtn = "Tentang OLX";
    public static final String hamburgerBarLayout = "com.app.tokobagus.betterb:id/left_drawer";
    public static final String headerContentLogoOlx = "header-fix-view";
    public static final String PUSAT_BANTUAN = "Pusat Bantuan";
    public static final String klikDisiniLogin = "com.app.tokobagus.betterb:id/sidemenu_tvAvatarStatus";

    public HamburgerBarModule(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Verify All Contents In HamburgerBar")
    public void verifyAllContentsInHamburgerBar()
    {
        verifyAvatarSaya();
        verifyProfilSayaBtn();
        verifyIklanSayaBtn();
        verifySaldoOLXBtn();
        verifyPusatBantuanBtn();
        verifyTentangOLXBtn();
    }

    public void verifyAvatarSaya()
    {
        WaitForClickabilityOf(getIdLocator(avatarSaya), 100);
        Assert.assertTrue(isElementPresent(getIdLocator(avatarSaya)));
        Log.info("Verify Avatar Profil");
    }
    public void verifyProfilSayaBtn()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(profilSayaBtn)));
        Log.info("Verify Profil Saya Button");
    }
    public void verifyIklanSayaBtn()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(iklanSayaBtn)));
        Log.info("Verify Iklan Saya Button");
    }
    public void verifySaldoOLXBtn()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(saldoOLXBtn)));
        Log.info("Verify Saldo OLX Button");
    }
    public void verifyPusatBantuanBtn()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(pusatBantuanBtn)));
        Log.info("Verify Pusat Bantuan Button");
    }
    public void verifyTentangOLXBtn()
    {
        Assert.assertTrue(isElementPresent(getTextLocator(tentangOLXBtn)));
        Log.info("Verify Tentang OLX Button");
    }

    @Step("Click Profil Saya Button")
    public ProfilSayaModule clickProfilSayaBtn()
    {
        clickElement(getTextLocator(profilSayaBtn));
        Log.info("Click Profil Saya Button");
        return new ProfilSayaModule(driver);
    }

    @Step("Click Iklan Saya Button")
    public IklanSayaPage clickIklanSayaBtn()
    {
        clickElement(getTextLocator(iklanSayaBtn));
        Log.info("Click Iklan Saya Button");
        return new IklanSayaPage(driver);
    }

    @Step("Click Saldo OLX Button")
    public SaldoOlxModule clickSaldoOLXBtn()
    {
        clickElement(getTextLocator(saldoOLXBtn));
        Log.info("Click Saldo OLX Button");
        return new SaldoOlxModule(driver);
    }

    @Step("Click Pusat Bantuan Button")
    public void clickPusatBantuanBtn()
    {
        clickElement(getTextLocator(pusatBantuanBtn));
        Log.info("Click Pusat Bantuan Button");
    }

    @Step("Click Tentang OLX Button")
    public void clickTentangOLXBtn()
    {
        clickElement(getTextLocator(tentangOLXBtn));
        Log.info("Click Tentang OLX Button");
    }

    public ListingPage closeHamburgerBarDrawer()
    {
        WebElement hamburgerDrawerLayout = driver.findElement(getIdLocator(hamburgerBarLayout));
        int heightMiddleHamburgerDrawerLayout = hamburgerDrawerLayout.getSize().getHeight() / 2;
        int widthEndHamburgerDrawerLayout = hamburgerDrawerLayout.getSize().getWidth();
        int widthStartHamburgerDrawerLayout = hamburgerDrawerLayout.getSize().getWidth() * 0 + 10;
        ((AndroidDriver)driver).swipe(widthEndHamburgerDrawerLayout, heightMiddleHamburgerDrawerLayout, widthStartHamburgerDrawerLayout, heightMiddleHamburgerDrawerLayout, 1000);
        return new ListingPage(driver);
    }

    public void verifyPusatBantuanContent() {
        Assert.assertTrue(isWaitElementPresent(getAndroidViewTextLocator(PUSAT_BANTUAN)));
        driver.navigate().back();
    }

    public void verifyTentangOlxContent() {
        Assert.assertTrue(isWaitElementPresent(getAndroidViewTextLocator(PUSAT_BANTUAN)));
        driver.navigate().back();
    }

    public boolean isHamburgerBar(){
        return isWaitElementPresent(getIdLocator(hamburgerBarLayout));
    }

    public void clickDisiniLogin(){
        clickElement(getIdLocator(klikDisiniLogin));
        Log.info("Click Login Disini");
    }

    public void clickOkAlert() {
        closeAlertKonf();
    }
}
