package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by NugrohoSantoso on 10/18/16.
 */
public class IklanSayaPage extends BasePage{
    public IklanSayaPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String backBtn = "";
    public static final String iklanSayaTitle = "";
    public static final String dustBin = "";
    public static final String moderasiPanel = "";
    public static final String aktifPanel = "";
    public static final String ditolakPanel = "";
    public static final String nonAktifPanel = "";
    public static final String amountOfAds = "";
    public static final String imageAndPrice = "";
    public static final String checkBoxAds = "";
    public static final String nonAktifkanIklan = "";
    public static final String batalBtn = "";
    public static final String sudahTerjualBtn = "";

    @Step("Verify All Content In IklanSaya Page")
    public void verifyAllContentInIklanSayaPage()
    {
        verifyBackBtn();
        verifyIklanSayaTitle();
        verifyDustBin();
        verifyModerasiPanel();
        verifyAktifPanel();
        verifyDitolakPanel();
        verifyNonaktifPanel();
        verifyAmountOfAds();
        verifyImageAndPrice();
        Log.info("Verify All Content In IklanSaya Page");
    }

    public void verifyBackBtn()
    {
        Log.info("Verify Back Button");
    }
    public void verifyIklanSayaTitle()
    {
        Log.info("Verify Iklan Saya Title");
    }
    public void verifyDustBin()
    {
        Log.info("Verify Dust Bin");
    }
    public void verifyModerasiPanel()
    {
        Log.info("Verify Moderasi Panel");
    }
    public void verifyAktifPanel()
    {
        Log.info("Verify Aktif Panel");
    }
    public void verifyDitolakPanel()
    {
        Log.info("Verify Ditolak Panel");
    }
    public void verifyNonaktifPanel()
    {
        Log.info("Verify Nonaktif Panel");
    }
    public void verifyAmountOfAds()
    {
        Log.info("Verify Amount Of Ads");
    }
    public void verifyImageAndPrice()
    {
        Log.info("Verify Image And Price");
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
    }

    public void clickModerasiPanel()
    {
        verifySudahTerjualBtn();
        Log.info("Click Moderasi Panel");
    }

    public AdsDetailsPage clickOneOfAdsInAdsList()
    {
        Log.info("Click One Of Ads In Ads List");
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
}
