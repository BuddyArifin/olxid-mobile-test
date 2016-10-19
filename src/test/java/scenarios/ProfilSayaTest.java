package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.ProfilSayaModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by NugrohoSantoso on 10/3/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("HamburgerBar Feature")
public class ProfilSayaTest extends AndroidSetup {
    LoginPage loginPage;
    LoginWithOlxModule loginWithOlxModule;
    ListingPage listingPage;
    HamburgerBarModule hamburgerBarModule;
    ProfilSayaModule profilSayaModule;

    @Stories("As a user i am not able to access Profil Saya Page")
    @Title("Verify user not able to access Profil Saya Page without Login")
    @TestCaseId("TC_PROFILE_13_001")
    @Test(priority = 1)
    public void verifyUserNotAbleToAccessProfilSayaPage() {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipOnBoardingSliders().skipLogin();
        listingPage.verifyContentsOfListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.clickProfilSayaBtn();
        loginPage.verifyContentsOfLoginPage();
    }

    @Stories("As a user i want to be able see all content in Profile Saya Page")
    @Title("Verify system able to display content in Profil Saya Page")
    @TestCaseId("TC_PROFIL_13_002")
    @Test(priority = 2)
    public void verifySystemAbleToDisplayContentInProfilSayaPage() {
        loginWithOlxModule = loginPage.clickLoginWithOlx();
//        loginWithOlxModule.inputEmail("krisna.parahita@olx.co.id");
//        loginWithOlxModule.inputPassword("testing");
        loginWithOlxModule.clickLoginWithOlxBtn();
        listingPage.verifyContentsOfListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        profilSayaModule = hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.verifyAllContentInProfilSayaPage();
    }

    @Stories("As a user i want to be able click back button")
    @Title("Verify user able to click back button")
    @TestCaseId("TC_PROFIL_13_003")
    @Test(priority = 3)
    public void verifyUserAbleToClickBackButton() {
    }

    @Stories("As a user i want to see my default avatar before i change")
    @Title("Verify system display default user avatar image")
    @TestCaseId("TC_PROFIL_13_004")
    @Test(priority = 4)
    public void verifySystemDisplayDefaultUserAvatarImage() {
        profilSayaModule.verifyAvatarProfilSayaPage();
    }

    @Stories("As a user i want to be able click My Avatar")
    @Title("Verify user able to click My Avatar")
    @TestCaseId("TC_PROFIL_13_005")
    @Test(priority = 5)
    public void verifyUserAbleToClickMyAvatar() {
    }

    @Stories("As a user i want to be able to change avatar directly from Camera or Gallery")
    @Title("Verify user able to change avatar directly from Camera or Gallery")
    @TestCaseId("TC_PROFIL_13_006")
    @Test(priority = 6)
    public void verifyUserAbleToChangeAvatarDirectlyFromCameraOrGallery() {
    }

    @Stories("As a user i want to be able click \"Username\"")
    @Title("Verify user able to click \"Username\"")
    @TestCaseId("TC_PROFIL_13_007")
    @Test(priority = 7)
    public void verifyUserAbleToClickUsername() {
    }

    @Stories("As a user i want to be able change username")
    @Title("Verify user able to change user name")
    @TestCaseId("TC_PROFIL_13_008")
    @Test(priority = 8)
    public void verifyUserAbleToChangeUserName() {
    }

    @Stories("As a user i want to be able click \"Ganti Password\" button")
    @Title("Verify user able to click \"Ganti Password\" button")
    @TestCaseId("TC_PROFIL_13_010")
    @Test(priority = 9)
    public void verifyUserAbleToClickGantiPasswordButton() {
    }

    @Stories("As a user i want to be able input current password in Ubah Password Page")
    @Title("Verify user able to input current password in Ubah Password Page")
    @TestCaseId("TC_PROFIL_13_011")
    @Test(priority = 10)
    public void verifyUserAbleToInputCurrentPasswordInUbahPasswordPage() {
    }

    @Stories("As a user i want to be able click \"Tampilkan Password\" Checkbox")
    @Title("Verify user able to click \"Tampilkan Password\" Checbox")
    @TestCaseId("TC_PROFIL_13_012")
    @Test(priority = 11)
    public void verifyUserAbleToClickTampilkanPasswordCheckbox() {
    }

    @Stories("As a user i am not able to change password")
    @Title("Verify user not able to change password by input invalid current password")
    @TestCaseId("TC_PROFIL_13_013")
    @Test(priority = 12)
    public void verifyUserNotAbleToChangePasswordByInputInvalidCurrentPassword() {
    }

    @Stories("As a system able to ask user to input new password")
    @Title("Verify system able to ask user to input new password")
    @TestCaseId("TC_PROFIL_13_014")
    @Test(priority = 13)
    public void verifySystemAbleToAskUserToInputNewPassword() {
    }

    @Stories("As a user i want to be able input new password")
    @Title("Verify user able to input new password")
    @TestCaseId("TC_PROFIL_13_015")
    @Test(priority = 14)
    public void verifyUserAbleToInputNewPassword() {
    }

    @Stories("As a user i want to be able input confirmation new password")
    @Title("Verify user able to input confirmation new password")
    @TestCaseId("TC_PROFIL_13_016")
    @Test(priority = 15)
    public void verifyUserAbleToInputConfirmationNewPassword() {
    }

    @Stories("As a user i want to be able change password")
    @Title("Verify user able to change password")
    @TestCaseId("TC_PROFIL_13_017")
    @Test(priority = 16)
    public void verifyUserAbleToChangePassword() {
    }

    @Stories("As a user i want to be able see change password success pop-up")
    @Title("Verify system able to display change password success pop-up")
    @TestCaseId("TC_PROFIL_13_018")
    @Test(priority = 17)
    public void verifySystemAbleToDisplayChangePasswordSuccessPopUp() {
    }

    @Stories("As user i want to see all content in change password success pop-up")
    @Title("Verify system able to display all content in change password success pop-up")
    @TestCaseId("TC_PROFIL_13_019")
    @Test(priority = 18)
    public void verifySystemAbleToDisplayAllContentInChangePasswordSuccessPopUp() {
    }

    @Stories("As a user i want to be able click \"CEK EMAIL\" button")
    @Title("Verify system able to display \"CEK EMAIL\" button")
    @TestCaseId("TC_PROFIL_13_020")
    @Test(priority = 19)
    public void verifySystemAbleToDisplayCekEmailButton() {
    }

    @Stories("As a user i want to be able click \"TUTUP\" button")
    @Title("Verify user able to click \"TUTUP\" button")
    @TestCaseId("TC_PROFIL_13_021")
    @Test(priority = 20)
    public void verifyUserAbleToCLickTutupButton() {
    }
}
