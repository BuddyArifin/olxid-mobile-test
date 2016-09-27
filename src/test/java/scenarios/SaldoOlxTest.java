package scenarios;

import listeners.ScreenshootsListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 9/26/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Saldo OLX Feature")
public class SaldoOlxTest extends AndroidSetup {

    @Stories("As A User i want be able to see all Contents of Saldo Olx")
    @Title("Verify User able to see All Contents of Saldo Olx")
    @TestCaseId("TC_SALDO_12_001")
    @Test(priority = 1)
    public void verifyAllContentsSaldoOlxPage() {
    }

    @Stories("As A User I want to be able to skip, related information by clicking X button besides the information sentence")
    @Title("Verify User able to skip related information about Saldo Olx by Tapping X button")
    @TestCaseId("TC_SALDO_12_004")
    @Test(priority = 2)
    public void verifyUserAbleToSkipRelatedInfo() {
    }

    @Stories("As A User i want to be able to see \"ISI ULANG SALDO\" Button")
    @Title("Verify User able to see \"ISI ULANG SALDO\" button")
    @TestCaseId("TC_SALDO_12_007")
    @Test(priority = 3)
    public void verifyUserAbleToIsiUlangSaldo() {
    }

    @Stories("As A User i want to be able to back previous page, after tapping back button")
    @Title("Verify User able to back to previous page, after tapping back button")
    @TestCaseId("TC_SALDO_12_009")
    @Test(priority = 4)
    public void verifyUserAbleToBackToPreviousPage() {
    }

    @Stories("As A User I want to be able redirect to Isi Ulang Saldo OLX Page, after tapping ISI ULANG SALDO Button")
    @Title("Verify User able to redirect to ISI Ulang OLX Page, after tapping ISI ULANG SALDO Button")
    @TestCaseId("TC_SALDO_12_013")
    @Test(priority = 5)
    public void verifyUserAbleRedirectToIsiUlangPageAfterTappingIsiUlangSaldo() {
    }

}
