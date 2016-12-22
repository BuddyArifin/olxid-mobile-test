package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by buddyarifin on 12/8/16.
 */
public class FavoritePage extends BasePage{

    public static final String filterButton = "com.app.tokobagus.betterb:id/filter_item";
    public static final String favoriteIconID = "com.app.tokobagus.betterb:id/btn_remove_favorite";
    public static final String searchIconID = "com.app.tokobagus.betterb:id/search_item";
    public static final String favoriteTitleText = "Favorit";

    public FavoritePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
            @AndroidFindBy(id = favoriteIconID)
    })
    public List<AndroidElement> favoriteIcon;

    @AndroidFindBys({
            @AndroidFindBy(id = "com.app.tokobagus.betterb:id/recycler_view_favad_list"),
            @AndroidFindBy(id = "com.app.tokobagus.betterb:id/ly_picture")
    })
    public List<AndroidElement> listAds;

    public void verifyFavoriteIcon() {
        Log.info("Verify Favorite Icon");
        favoriteIcon.forEach( favoriteIcon -> {
            Assert.assertTrue(favoriteIcon.isDisplayed());
        });
    }

    public void verifyListAds() {
        Log.info("Verify List Of Ads on Favorite");
        isWaitListElementPresent(listAds);
        listAds.forEach( listAds -> {
            Assert.assertTrue(waitForVisibility(listAds));
        });
    }

    @Step("Verify Favorite Page Contents")
    public void verifyFavoritePageContent() {
        verifyFavoriteIcon();
        verifyListAds();
    }

    public AdsDetailsPage clickFirstAds() {
        if (isListElementPresent(listAds)) {
            listAds.iterator().next().click();
        }
        return new AdsDetailsPage(driver);
    }

    public void resetFavoriteAds() {
        Log.info("Remove Existing Favorite Ads");
        for (AndroidElement element : favoriteIcon) {
            favoriteIcon.get(0).click();

                if (isElementPresent(getIdLocator(alertContent))) {
                    clickElement(getIdLocator(okKonfirmasiPopUp));
                }

        }
        Log.debug("Isi dari Favorite list : "+favoriteIcon.size());
    }
}
