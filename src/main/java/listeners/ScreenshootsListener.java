package listeners;

import org.openqa.grid.web.Hub;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.BasePage;
import pages.InstanceDriver;
import ru.yandex.qatools.allure.utils.AnnotationManager;
import utils.Log;

import java.lang.annotation.Annotation;
import java.util.Iterator;

/**
 * Created by buddyarifin on 6/14/16.
 */
public class ScreenshootsListener extends TestListenerAdapter  {
    private BasePage base;
    private WebDriver driver;
    private Object obj;
    private Annotation[] annotations;
    private Hub hub;

    @Override
    public void onTestFailure(ITestResult testResult){
        obj = testResult.getInstance();
        driver = ((InstanceDriver)obj).driver;
        base = new BasePage(driver);
        try {
            Log.debug("***** Error "+getTestTitle(testResult)+" test has failed *****");
            base.getAttachment("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
//            request.goToTracker(testResult, this.array);
            Log.debug("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
        } catch (Exception e){
            Log.debug("-->Unable to screen capture, for test "+getTestTitle(testResult));
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult){
        Log.debug("Running Test --> "+getTestTitle(iTestResult));
        obj = iTestResult.getInstance();
        driver = ((InstanceDriver)obj).driver;
        base = new BasePage(driver);
        base.setTutorialPresent(true);
        base.setTutorialCameraDismiss(true);
        base.setTutorialMapsPresent(true);
    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        obj = testResult.getInstance();
        driver = ((InstanceDriver)obj).driver;
        base = new BasePage(driver);
        try {
            Log.debug("***** Success Execution for "+getTestTitle(testResult)+" *****");
//            request.goToTracker(testResult, this.array);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
            Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
            while (listOfFailedTests.hasNext()){
                ITestResult failedTest = listOfFailedTests.next();
                ITestNGMethod method = failedTest.getMethod();
                if (testContext.getFailedTests().getResults(method).size() > 1){
                    listOfFailedTests.remove();
                } else {
                    if (testContext.getPassedTests().getResults(method).size() > 0) {
                        listOfFailedTests.remove();
                    }
                }
            }
    }

    private String getTestTitle(ITestResult result) {
        annotations = result.getMethod().getConstructorOrMethod().getMethod().getAnnotations();
        AnnotationManager annotationManager = new AnnotationManager(annotations);
        return annotationManager.getTitle();
    }

}
