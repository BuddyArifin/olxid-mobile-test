package scenarios;

import listeners.ScreenshootsListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPreferencesPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 8/11/16.
 */

@Deprecated
@Listeners(ScreenshootsListener.class)
@Features("Category Feature")
public class CategoryPreferencesTest extends AndroidSetup {
    CategoryPreferencesPage categoryPreferencesPage;

    @Stories("Verify Category can be Accessed after Login")
    @Title("Verify Contents and Category accessible after First Time Login")
    @TestCaseId("TC_CATEGORY_04_001")
    @Test(priority = 1)
    public void verifyAllContensOfCategoryPreferencesPage() {
        LoginPage loginPage = new LoginPage(driver);
        categoryPreferencesPage = loginPage.skipPreferences();
        categoryPreferencesPage.verifyAllContentsOfCategoryPage();
    }

    @Stories("As a User I want enable Access Category in Profile Edit")
    @Title("Verify User Category can be Accessed in Profile Edit")
    @TestCaseId("TC_CATEGORY_04_002")
    @Test(priority = 6, enabled = false)
    public void verifyCategoryPreferencesOnProfileEdit() {}

    @Stories("As a User I want enable Select 1 Index Category")
    @Title("Verify User 1 Index Category can be Selected")
    @TestCaseId("TC_CATEGORY_04_003")
    @Test(priority = 3)
    public void verifyUserAbleToSelectedOneCategory() {
        categoryPreferencesPage.selectCategory(0);
        Assert.assertTrue(categoryPreferencesPage.verifySelectedCount(1));
    }

    @Stories("As a User I want enable Select 2 Index Category")
    @Title("Verify User 2 Index Category can be Selected")
    @TestCaseId("TC_CATEGORY_04_004")
    @Test(priority = 4)
    public void verifyUserAbleToSelectedTwoCategory() {
        categoryPreferencesPage.selectCategory(1);
        Assert.assertTrue(categoryPreferencesPage.verifySelectedCount(2));
    }

    @Stories("Verify User 3 Index Category can be Selected")
    @Title("As a User I want enable Select 3 Index Category")
    @TestCaseId("TC_CATEGORY_04_005")
    @Test(priority = 5)
    public void verifyUserAbleToSelectThreeCategory() {
        categoryPreferencesPage.selectCategory(2);
        Assert.assertTrue(categoryPreferencesPage.verifySelectedCount(3));
    }

    @Stories("As a User I Want Unselected 1 Category")
    @Title("Verify User Unselected 1 Category")
    @TestCaseId("TC_CATEGORY_04_006")
    @Test(priority = 2)
    public void verifyUserAbleToUnSelectCategory() {
        categoryPreferencesPage.resetSelectedCategory();
    }

    @Stories("As a User I Will not Able to Select More 3 Index Category")
    @Title("Verify User Will not Able Selected More than 3 Index Category")
    @TestCaseId("TC_CATEGORY_04_007")
    @Test(priority = 7)
    public void verifyUserNotAbleToSelectedMoreThan3Category() {
//        categoryPreferencesPage.selectedMoreThan3Category();
        categoryPreferencesPage.selectCategory(3);
        categoryPreferencesPage.verifyErrorMsgDisplay();
    }

    @Stories("As a User I Will not Able To Select More 3 Index Category")
    @Title("Verify User Will not Able Selected More than 3 Index Category after Edit")
    @TestCaseId("TC_CATEGORY_04_008")
    @Test(priority = 9)
    public void verifyUserNotAbleToSelectedMoreThan3CategoryAfterEdit() {}

    @Stories("As a User I Will not seeing Category Preferences when Login for a second time")
    @Title("Verify System not display Category Preferences when not First Time Login")
    @TestCaseId("TC_CATEGORY_04_009")
    @Test(priority = 10)
    public void verifyUserNotAbleToAccessCategoryOnSecondLogin() {}

    @Stories("As a User I want be able to redirect to Listing, after select Category")
    @Title("Verify System will redirect User to Listing")
    @TestCaseId("TC_CATEGORY_07_013")
    @Test(priority = 8)
    public void verifyUserAbleToRedirectToListing() {
        categoryPreferencesPage.clickSimpanBtn();
    }

}
