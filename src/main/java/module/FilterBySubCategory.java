package module;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
public class FilterBySubCategory extends BasePage {
    public FilterBySubCategory(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static final String subCategoryElement1 = "";
    public static final String subCategoryElement2 = "";
    public static final String subCategoryElement3 = "";
    public static final String luasTanahBtn = "";
    public static final String luasBangunanBtn = "";
    public static final String sertifikatBtn = "";
    public static final String lantaiBtn = "";
    public static final String kamarTidurBtn = "";
    public static final String kamarMandiBtn = "";

    @Step("Verify Content in Additional Filter")
    public void verifyContentInAdditionalFilter()
    {
        Log.info("Verify Content in Additional Filter");
    }
}
