package scenarios;

import org.testng.TestNG;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by buddyarifin on 11/22/16.
 */
public class RunParallelSuites {

    public static void main(String[] args){
        TestNG testNG = new TestNG();
        File resource = new File("src/test/resources");
        File testXmlone = new File(resource, "testng.xml");

        List<String> suites = new ArrayList<String>();
        suites.add(testXmlone.getAbsolutePath());

        testNG.setTestSuites(suites);
        testNG.setSuiteThreadPoolSize(2);
        testNG.run();
    }
}
