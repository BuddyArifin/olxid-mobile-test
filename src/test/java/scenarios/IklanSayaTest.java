package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import module.LoginWithOlxModule;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.IklanSayaPage;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by NugrohoSantoso on 10/19/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Post Ads Test")
public class IklanSayaTest extends AndroidSetup {
    LoginPage loginPage;
    LoginWithOlxModule loginWithOlxModule;
    ListingPage listingPage;
    HamburgerBarModule hamburgerBarModule;
    IklanSayaPage iklanSayaPage;

    @Stories("As A User i want be able to See All Contents of Category Page of \"Iklan Saya\"")
    @Title("Verify User able to See All Contents of \"Iklan Saya\"")
    @TestCaseId("TC_MYADS_14_001")
    @Test(priority = 1)
    public void verifyAllContentInIklanSayaPage()
    {
    }

    @Stories("As a user i want to be able see Additional content in \"Moderasi\" Panel")
    @Title("Verify system able to display Additional content in \"Moderasi\" panel")
    @TestCaseId("TC_MYADS_14_002, TC_MYADS_14_003")
    @Test(priority = 2)
    public void verifyAdditionalContentInModerasiPanel()
    {
    }

    @Stories("As A User I want be able to Scroll the page on each Tab")
    @Title("Verify User able to Scroll page on each Tabs")
    @TestCaseId("TC_MYADS_14_004")
    @Test(priority = 3)
    public void verifyUserAbleToScrollPageOnEachTabs()
    {
    }

    @Stories("As a user i want to be able see Additional content in \"Aktif\" Panel")
    @Title("Verify system able to display Additional content in \"Aktif\" panel")
    @TestCaseId("TC_MYADS_14_005, TC_MYADS_14_006")
    @Test(priority = 4)
    public void verifyAdditionalContentInAktifPanel()
    {
    }

    @Stories("As A User I want be able to select Multiple Ads")
    @Title("Verify User able to select multiple ads")
    @TestCaseId("TC_MYADS_14_007")
    @Test(priority = 5)
    public void verifyUserAbleToSelectMultipleAds()
    {
    }

    @Stories("As A User I want be able to \"Non Aktifkan Iklan\"")
    @Title("Verify User able to change Ads Status to Non Aktif by tapping \"Non Aktifkan Iklan\"")
    @TestCaseId("TC_MYADS_14_008")
    @Test(priority = 6)
    public void verifyUserAbleToChangeAdsStatusToNonAktifByTappingNonAktifkanIklan()
    {
    }

    @Stories("As A User I want be able to cancel selected ads")
    @Title("Verify user able to cancel Multiple Ads by tapping Batal")
    @TestCaseId("TC_MYADS_14_009")
    @Test(priority = 7)
    public void verifyUserAbleToCancelMultipleAdsByTappingBatal()
    {
    }

    @Stories("As A User I want be able to see \"Sudah Terjual\"")
    @Title("Verify User able to see \"Sudah Terjual\" status after non aktifkan iklan")
    @TestCaseId("TC_MYADS_14_010")
    @Test(priority = 8)
    public void verifyUserAbleToSeeSudahTerjualStatusAfterNonAktifkanIklan()
    {
    }
}
