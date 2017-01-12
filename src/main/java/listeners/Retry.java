package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.ClearStepStorageEvent;
import ru.yandex.qatools.allure.events.RemoveAttachmentsEvent;
import ru.yandex.qatools.allure.events.StepCanceledEvent;
import ru.yandex.qatools.allure.events.TestCaseCanceledEvent;
import ru.yandex.qatools.allure.utils.AnnotationManager;
import utils.Log;

import java.util.Iterator;

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
            deleteSkippedTestOnRetry(result);
            Log.info("######  Retry failed tc-scenarios : " + testAnnotationAllure.getTitle() + " ######");
            retryCount++;
            return true;
        }
        return false;
    }

    private void deleteSkippedTestOnRetry(ITestResult tr) {
        Iterator<ITestResult> listOfSkippedTest = tr.getTestContext().getSkippedTests().getAllResults().iterator();
        while (listOfSkippedTest.hasNext()) {
            ITestResult m_skipped_test = listOfSkippedTest.next();
            ITestNGMethod m_skipped = m_skipped_test.getMethod();
            if (tr.getTestContext().getSkippedTests().getResults(m_skipped).size() > 1){
                listOfSkippedTest.remove();
            } else if (tr.getTestContext().getSkippedTests().getResults(m_skipped).size() > 0) {
                listOfSkippedTest.remove();
            }
        }
    }
}
