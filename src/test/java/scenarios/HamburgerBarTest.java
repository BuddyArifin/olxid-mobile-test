package scenarios;

import listeners.ScreenshootsListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by NugrohoSantoso on 9/10/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("HamburgerBar Feature")
public class HamburgerBarTest extends AndroidSetup {

    @Stories("As a user i want to able open Navigation Menu")
    @Title("Verify user able to open Navigation Menu")
    @TestCaseId("TC_LISTING_06_026")
    @Test(priority = 1)
    public void verifyUserAbleToOpenNavigationMenu()
    {
    }

    @Stories("As A User i want to able see Content in Navigation Menu")
    @Title("Verify System display All Content in Navigation Menu")
    @TestCaseId("TC_LISTING_06_027")
    @Test(priority = 2)
    public void verifySystemDisplayAllContentInNavigationMenu()
    {
    }

    @Stories("As A User i want to able Click ProfilSaya")
    @Title("Verify User able to click Profil Saya Button")
    @TestCaseId("TC_LISTING_06_028")
    @Test(priority = 3)
    public void verifyUserAbleToClickProfilSayaButton()
    {
    }

    @Stories("As A User i want to able Click IklanSaya")
    @Title("Verify User able to click IklanSaya Button")
    @TestCaseId("TC_LISTING_06_029")
    @Test(priority = 4)
    public void verifyUserAbleToClickIklanSayaButton()
    {
    }

    @Stories("As A User i want to able Click SaldoOLX")
    @Title("Verify User able to click SaldoOLX Button")
    @TestCaseId("TC_LISTING_06_030")
    @Test(priority = 5)
    public void verifyUserAbleToClickSaldoOLXButton()
    {
    }

    @Stories("As A User i want to able Click PusatBantuan")
    @Title("Verify User able to click PusatBantuan Button")
    @TestCaseId("TC_LISTING_06_031")
    @Test(priority = 6)
    public void verifyUserAbleToClickPusatBantuanButton()
    {
    }

    @Stories("As A User i want to able Click TentangOLX")
    @Title("Verify User able to click TentangOLX Button")
    @TestCaseId("TC_LISTING_06_032")
    @Test(priority = 7)
    public void verifyUserAbleToClickTentangOLXButton()
    {
    }

    @Stories("As a user i want to be able close Navigation Menu")
    @Title("Verify System didn't display navigation menu")
    @TestCaseId("TC_LISTING_06_033")
    @Test(priority = 8)
    public void verifySystemNotDisplayNavigationMenu()
    {
    }
}
