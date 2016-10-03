package module;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by itintern on 10/3/16.
 */
public class ProfilSayaModule extends BasePage{
    //Variable for ProfilSaya Page Page
    public static final String backBtn = "";
    public static final String titleProfilSaya = "";
    public static final String avatarProfilSaya = "";
    public static final String usernameProfilSaya = "";
    public static final String informasiGabungProfilSaya = "";
    public static final String verifikasiAkunText1 = "";
    public static final String verifikasiAkunText2 = "";
    public static final String nomorTeleponText = "";
    public static final String nomorTeleponNumber = "";
    public static final String emailText = "";
    public static final String emailValue = "";
    public static final String passwordtext = "";
    public static final String gantiPasswordBtn = "";
    public static final String logOutDariOLXBtn = "";
    //Variable for GantiPassword Page
    public static final String cancelBtn = "";
    public static final String gantiPasswordTitle = "";
    public static final String passwordBaruField = "";
    public static final String konfirmasiPasswordBaru = "";
    public static final String chkBoxTampilkanPassword = "";
    public static final String simpanBtn = "";

    public ProfilSayaModule(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Method for ProfilSaya Page

    public void verifyBackBtnProfilSayaPage()
    {
        Log.info("Verify Back Button in ProfilSaya Page");
    }
    public void verifyTitleProfilSayaPage()
    {
        Log.info("Verify Title in ProfilSaya Page");
    }
    public void verifyAvatarProfilSayaPage()
    {
        Log.info("Verify Avatar in ProfilSaya Page");
    }
    public void verifyUsernameProfilSayaPage()
    {
        Log.info("Verify Username in ProfilSaya Page");
    }
    public void verifyInformasiGabungProfilSayaPage()
    {
        Log.info("Verify Informasi Gabung in ProfilSaya Page");
    }
    public void verifyVerifikasiAkunText1ProfilSayaPage()
    {
        Log.info("Verify Verifikasi Akun Text 1 in ProfilSaya Page");
    }
    public void verifyVerifikasiAkunText2ProfilSayaPage()
    {
        Log.info("Verify Verifikasi Akun Text 2 in ProfilSaya Page");
    }
    public void verifyNomorTeleponTextProfilSayaPage()
    {
        Log.info("Verify Text Nomor Telepon in ProfilSaya Page");
    }
    public void verifyNomorTeleponNumberProfilSayaPage()
    {
        Log.info("Verify Nomor Telepon Number in ProfilSaya Page");
    }
    public void verifyEmailTextProfilSayaPage()
    {
        Log.info("Verify Email Text in ProfilSaya Page");
    }
    public void verifyEmailValueProfilSayaPage()
    {
        Log.info("Verify Email Value in ProfilSaya Page");
    }
    public void verifyPasswordTextProfilSayaPage()
    {
        Log.info("Verify Password Text in ProfilSaya Page");
    }
    public void verifyGantiPasswordButtonProfilSayaPage()
    {
        Log.info("Verify Ganti Password Button in ProfilSaya Page");
    }
    public void verifyLogoutDariOLXButtonProfilSayaPage()
    {
        Log.info("Verify Logout Dari OLX in ProfilSaya Page");
    }

    @Step("Verify All Content in ProfilSaya Page")
    public void verifyAllContentInProfilSayaPage()
    {
        verifyBackBtnProfilSayaPage();
        verifyTitleProfilSayaPage();
        verifyAvatarProfilSayaPage();
        verifyUsernameProfilSayaPage();
        verifyInformasiGabungProfilSayaPage();
        verifyVerifikasiAkunText1ProfilSayaPage();
        verifyVerifikasiAkunText2ProfilSayaPage();
        verifyNomorTeleponTextProfilSayaPage();
        verifyNomorTeleponNumberProfilSayaPage();
        verifyEmailTextProfilSayaPage();
        verifyEmailValueProfilSayaPage();
        verifyPasswordTextProfilSayaPage();
        verifyGantiPasswordButtonProfilSayaPage();
        verifyLogoutDariOLXButtonProfilSayaPage();
        Log.info("Verify All Content In ProfilSaya Page Page");
    }

    public void clickUbahPasswordBtnProfilSayaPage()
    {
        Log.info("Click Ubah Password Button in Profil Saya Page");
    }

    public void clickLogoutDariOLXBtnProfilSayaPage()
    {
        Log.info("Click Logout Dari OLX Button in Profil Saya Page");
    }

    //Method for GantiPassword Page

    public void verifyCancelBtnGantiPasswordPage()
    {
        Log.info("Verify Cancel Button in GantiPassword Page");
    }
    public void verifyGantiPasswordTitleGantiPasswordPage()
    {
        Log.info("Verify Ganti Password Title in GantiPassword Page");
    }
    public void verifyPasswordBaruField()
    {
        Log.info("Verify Password Baru Field in GantiPassword Page");
    }
    public void verifyKonfirmasiPasswordBaruGantiPasswordPage()
    {
        Log.info("Verify Konfirmasi Password Baru in GantiPassword Page");
    }
    public void verifyCheckBoxTampilkanPasswordGantiPasswordPage()
    {
        Log.info("Verify Checkbox Tampilkan Password in GantiPassword Page");
    }
    public void verifySimpanButtonGantiPasswordPage()
    {
        Log.info("Verify Simpan Button in GantiPassword Page");
    }

    @Step("Verify All Content in GantiPassword Page")
    public void verifyAllContentInGantiPasswordPage()
    {
        verifyCancelBtnGantiPasswordPage();
        verifyGantiPasswordTitleGantiPasswordPage();
        verifyPasswordBaruField();
        verifyKonfirmasiPasswordBaruGantiPasswordPage();
        verifyCheckBoxTampilkanPasswordGantiPasswordPage();
        verifySimpanButtonGantiPasswordPage();
        Log.info("Verify All Content in GantiPassword Page");
    }
}
