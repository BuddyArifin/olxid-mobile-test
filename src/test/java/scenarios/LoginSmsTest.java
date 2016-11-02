package scenarios;

import listeners.ScreenshootsListener;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by NugrohoSantoso on 8/26/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Login Feature")
@Deprecated
public class LoginSmsTest extends AndroidSetup{
    
    // login with SMS
    public void userNotAbleToLoginWithBlankPIN() {}
    public void userAbleToMintaPIN() {}
    public void userAbleToMintaUlangPIN() {}
    public void userNotAbleToLoginWithInvalidPIN() {}
    public void userNotAbleToLoginWithInvalidPhoneNumber() {}
    public void userAbleToLoginWithValidPIN() {}
}
