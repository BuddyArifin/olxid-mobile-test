package scenarios;

import listeners.ScreenshootsListener;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by NugrohoSantoso on 9/10/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("HamburgerBar Feature")
public class HamburgerBarTest extends AndroidSetup {
}
