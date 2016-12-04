package pages;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import utils.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;

/**
 * Created by buddyarifin on 8/29/16.
 */
public class InstanceDriver {

    public AndroidDriver driver;
    protected String hubparallel;
    private JsonObject jsonObject;

    public String setHub(ITestContext iTestContext) {
        String suitename = iTestContext.getCurrentXmlTest().getName();
        if(suitename.contains("DEVICES")) {
            Log.debug("Pointing Test to Registered HUB : "+Constants.hubIPDevices);
            this.hubparallel = Constants.hubIPDevices;
        } else if (suitename.contains("AVD")){
            Log.debug("Pointing Test to Registered HUB : "+Constants.hubIPEmu);
            this.hubparallel = Constants.hubIPEmu;
        }
        return this.hubparallel;
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] getData(Method m) {
        String testname = m.getName() + ".json";
        File jsonFileDir = new File("src/test/resources/goldendata/");
        File jsonfile = new File(jsonFileDir, testname);
        jsonObject = convertFiletoJson(jsonfile.getAbsoluteFile());
        return new Object[][]{{jsonObject}};
    }

    public JsonObject convertFiletoJson(File file) {
        jsonObject = new JsonObject();
        try{
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader(file));
            jsonObject = jsonElement.getAsJsonObject();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.info("Warning : File not found");
        }
        return jsonObject;
    }
}
