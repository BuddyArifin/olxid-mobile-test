package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import module.ProfilSayaModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ListingPage;
import pages.LoginPage;
import pages.PostAdsPage;
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
    PostAdsPage postAdsPage;

    @Stories("As a user i am not able to access Profil Saya Page")
    @Title("Verify user not able to access Profil Saya Page without Login")
    @TestCaseId("TC_PROFILE_13_001, TC_PROFIL_13_002")
    @Test(priority = 1)
    public void verifyUserNotAbleToAccessProfilSayaPage() {
        loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipOnBoardingSliders().skipLogin();
        listingPage.verifyContentsOfListingPage();
        hamburgerBarModule = listingPage.clickHamburgerBar();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
        profilSayaModule = hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.verifyLoginPopupNotif();
        loginPage = profilSayaModule.clickLoginBtnInLoginPopup();
        loginPage.verifyContentsOfLoginPage();

        loginWithOlxModule = loginPage.clickLoginWithOlx();
        loginWithOlxModule.inputEmail("olxtester@gmail.com");
        loginWithOlxModule.inputPassword("testing");
        loginWithOlxModule.clickLoginWithOlxBtn();
        profilSayaModule.verifyAllContentInProfilSayaPage();
    }

    @Stories("As a user i want to be able click back button")
    @Title("Verify user able to click back button")
    @TestCaseId("TC_PROFIL_13_003")
    @Test(priority = 3)
    public void verifyUserAbleToClickBackButton() {
        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.clickBackButton();
        hamburgerBarModule.verifyAllContentsInHamburgerBar();
    }

    @Stories("As a user i want to be able click My Avatar")
    @Title("Verify user able to click My Avatar")
    @TestCaseId("TC_PROFIL_13_004, TC_PROFIL_13_005, TC_PROFIL_13_006")
    @Test(priority = 3)
    public void verifyUserAbleToClickMyAvatar() {
        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.verifyAvatarProfilSayaPage();
        profilSayaModule.clickAvatar();
        profilSayaModule.verifyAllEditAvatarPopUpContents();
        profilSayaModule.clickDeleteAvatar();
        //take shot old avatar
        profilSayaModule.takeShotOldAvatar();
        profilSayaModule.clickAvatar();
        profilSayaModule.verifyAllEditAvatarPopUpContents();
        //upload gallery
        profilSayaModule.clickUploadAvatarGalery();
        postAdsPage = profilSayaModule.clickOneOfPictureGallery();
        postAdsPage.clickSimpanBtn();
        profilSayaModule.takeShotNewAvatar();
        profilSayaModule.verifyOldNewAvatar();
        //delete
        profilSayaModule.takeShotOldAvatar();
        profilSayaModule.clickAvatar();
        profilSayaModule.verifyAllEditAvatarPopUpContents();
        profilSayaModule.clickDeleteAvatar();
        profilSayaModule.takeShotNewAvatar();
        profilSayaModule.verifyOldNewAvatar();
        //capture from camera
        profilSayaModule.takeShotOldAvatar();
        profilSayaModule.clickAvatar();
        profilSayaModule.verifyAllEditAvatarPopUpContents();
        profilSayaModule.clickUploadAvatarCamera();
        profilSayaModule.clickShutterCamera();
        postAdsPage = profilSayaModule.acceptTakePicture();
        postAdsPage.clickSimpanBtn();
        profilSayaModule.takeShotNewAvatar();
        profilSayaModule.verifyOldNewAvatar();
    }

    @Stories("As a user i want to be able click \"Username\"")
    @Title("Verify user able to click \"Username\"")
    @TestCaseId("TC_PROFIL_13_007, TC_PROFIL_13_008")
    @Test(priority = 3)
    public void verifyUserAbleToClickUsername() {

        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.clickEditUsername();
        profilSayaModule.inputUsername("Automation Guys 2");
        profilSayaModule.verifyNewUsername();
    }

    @Stories("As a user i am not able to change password")
    @Title("Verify user not able to change password by input invalid current password")
    @TestCaseId("TC_PROFIL_13_010, TC_PROFIL_13_013")
    @Test(priority = 3)
    public void verifyUserNotAbleToChangePasswordByInputInvalidCurrentPassword() {
        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.verifyGantiPasswordButtonProfilSayaPage();
        profilSayaModule.clickUbahPasswordBtnProfilSayaPage();
        profilSayaModule.verifyAllContentInGantiPasswordPage();
        profilSayaModule.inputOldPassword("WrongOldPassword");
        profilSayaModule.inputNewPassword("newPass");
        profilSayaModule.inputKonfirmPassword("newPass");
        profilSayaModule.clickSimpanPasswordButton();
        profilSayaModule.verifyAlertShowsUp();
        profilSayaModule.clickOkOnSnackbar();
    }

    @Stories("As a system able to ask user to input new password")
    @Title("Verify system able to ask user to input new password")
    @TestCaseId("TC_PROFIL_13_015")
    @Test(priority = 3)
    public void verifySystemAbleToAskUserToInputNewPassword() {
        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.verifyGantiPasswordButtonProfilSayaPage();
        profilSayaModule.clickUbahPasswordBtnProfilSayaPage();
        profilSayaModule.verifyAllContentInGantiPasswordPage();
        profilSayaModule.inputOldPassword("WrongOldPassword");
        profilSayaModule.inputNewPassword("");
        profilSayaModule.inputKonfirmPassword("");
        profilSayaModule.clickSimpanPasswordButton();
        profilSayaModule.verifyAlertShowsUp();
        profilSayaModule.clickOkOnSnackbar();
    }

    @Stories("As a User I want not able to change password")
    @Title("Verify user should not able to change password with unmatch new and confirm Password")
    @TestCaseId("TC_PROFIL_13_014")
    @Test(priority = 3)
    public void verifySystemDisplayAlertOnUnmatchNewandConfirmPass() {
        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.verifyGantiPasswordButtonProfilSayaPage();
        profilSayaModule.clickUbahPasswordBtnProfilSayaPage();
        profilSayaModule.verifyAllContentInGantiPasswordPage();
        profilSayaModule.inputOldPassword("testing");
        profilSayaModule.inputNewPassword("unmatch");
        profilSayaModule.inputKonfirmPassword("unmatch1");
        profilSayaModule.clickSimpanPasswordButton();
        profilSayaModule.verifyAlertShowsUp();
        profilSayaModule.clickOkOnSnackbar();
    }

    @Stories("As a user i want to be able change password")
    @Title("Verify user able to change password")
    @TestCaseId("TC_PROFIL_13_009, TC_PROFIL_13_011, TC_PROFIL_13_012, TC_PROFIL_13_016, TC_PROFIL_13_017, TC_PROFIL_13_018, TC_PROFIL_13_019, TC_PROFIL_13_020, TC_PROFIL_13_022")
    @Test(priority = 4)
    public void verifyUserAbleToChangePassword() {

        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        loginPage = profilSayaModule.clickLogoutDariOLXBtnProfilSayaPage();
        hamburgerBarModule.clickDisiniLogin();
        loginPage.verifyContentsOfLoginPage();
        loginWithOlxModule = loginPage.clickLoginWithOlx();
        loginWithOlxModule.inputEmail("test.conf1a@gmail.com");
        loginWithOlxModule.inputPassword("confluence12345");
        loginWithOlxModule.clickLoginWithOlxBtn();
        profilSayaModule.initialProfilSayaTest();
        hamburgerBarModule.clickProfilSayaBtn();
        profilSayaModule.verifyGantiPasswordButtonProfilSayaPage();
        profilSayaModule.clickUbahPasswordBtnProfilSayaPage();
        profilSayaModule.verifyAllContentInGantiPasswordPage();
        profilSayaModule.inputOldPassword("confluence12345");
        profilSayaModule.inputNewPassword("confluence1234");
        profilSayaModule.inputKonfirmPassword("confluence1234");
        profilSayaModule.clickSimpanPasswordButton();
        profilSayaModule.clickTutupAlertSuccess();
    }
}
