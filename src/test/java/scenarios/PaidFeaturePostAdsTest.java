package scenarios;

import listeners.ScreenshootsListener;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by buddyarifin on 12/13/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Paid Feature")
public class PaidFeaturePostAdsTest extends AndroidSetup {
}
