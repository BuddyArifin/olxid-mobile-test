package scenarios;

import listeners.ScreenshootsListener;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by NugrohoSantoso on 9/6/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Post Ads Test")
public class PostAdsTest extends AndroidSetup {
}
