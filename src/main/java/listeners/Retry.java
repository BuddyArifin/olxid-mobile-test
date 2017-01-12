package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.ClearStepStorageEvent;
import ru.yandex.qatools.allure.events.RemoveAttachmentsEvent;
import ru.yandex.qatools.allure.utils.AnnotationManager;
import utils.Log;

/**
 * Created by buddyarifin on 7/22/16.
 */
public class Retry implements IRetryAnalyzer {

    private int retryCount=1;
    private int maxRetryCount=2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            AnnotationManager testAnnotationAllure = new AnnotationManager(result.getMethod().getConstructorOrMethod()
                    .getMethod().getAnnotations());
            Allure.LIFECYCLE.fire(new RemoveAttachmentsEvent(".*"));
            Allure.LIFECYCLE.fire(new ClearStepStorageEvent());
            Log.debug("######  Retry failed tc-scenarios : " + testAnnotationAllure.getTitle() + " ######");
            retryCount++;
            return true;
        }
        return false;
    }
}
