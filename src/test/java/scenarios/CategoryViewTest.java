package scenarios;

import listeners.ScreenshootsListener;
import module.HamburgerBarModule;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPreferencesPage;
import pages.FilterPage;
import pages.ListingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 10/10/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Category View Page")
public class CategoryViewTest extends AndroidSetup {
    ListingPage listingPage;
    CategoryPreferencesPage category;
    HamburgerBarModule hamburgerBar;
    FilterPage filter;

    @Stories("As A User i want be able to See All Contents ")
    @Title("Verify User able to see All of Contents on Kategori View")
    @TestCaseId("TC_PROFILE_14_001, TC_PROFILE_14_001")
    @Test(priority = 1, groups = "smoke.test")
    public void userAbleToSeeAllContentsKategoriViewsPage() {
        LoginPage loginPage = new LoginPage(driver);
        listingPage = loginPage.clickSkipOnBoardingSliders().skipLogin();
        listingPage.verifyContentsOfListingPage();
        category = listingPage.clickKategoriBtnBtm();
        category.verifyAllContentsOfCategoryViewPage();
    }

    @Stories("As A User i want be able to Access hamburger bar")
    @Title("Verify User able to Access Hamburger Bar on Kategori Page")
    @TestCaseId("TC_PROFILE_14_003")
    @Test(priority = 2)
    public void userAbleToAccessHamburgerBarOnKategoriViewsPage() {
        hamburgerBar = listingPage.clickHamburgerBar();
        hamburgerBar.verifyAllContentsInHamburgerBar();
        hamburgerBar.closeHamburgerBarDrawer();
    }

    @Stories("As A User I want be able to Advance Search")
    @Title("Verify User able to Access Advance Search on Primary Bar")
    @TestCaseId("TC_PROFILE_14_004")
    @Test(priority = 3)
    public void userAbleToAccessAdvanceSearchOnKatoriViewsPage() {
        hamburgerBar = listingPage.clickHamburgerBar();
        hamburgerBar.verifyAllContentsInHamburgerBar();
        hamburgerBar.closeHamburgerBarDrawer();
        category.verifyAllContentsOfCategoryViewPage();
    }

    @Stories("As A User I want just able to choose 1 category in Category View")
    @Title("Verify User only able to choose 1 category")
    @TestCaseId("TC_PROFILE_14_005")
    @Test(priority = 4, groups = "smoke.test")
    public void userAbleOnlyAbleToChooseOneKategori() {
        category.selectCategory(1);
        listingPage.verifyContentsOfListingPage();
        filter = listingPage.clickFilterBtnPrm();
        Assert.assertEquals(filter.getCategoryChoosen(),
                CategoryPreferencesPage.categoryChoosing);
    }

}
