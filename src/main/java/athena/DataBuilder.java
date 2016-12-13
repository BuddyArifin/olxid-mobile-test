package athena;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log;

import java.io.*;
import java.lang.reflect.Method;
import com.jayway.jsonpath.JsonPath;

/**
 * Created by buddyarifin on 12/6/16.
 */
public class DataBuilder {

    public JsonObject convertFiletoJson(File file) {
        JsonObject jsonObject = new JsonObject();
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

    public static void convertJsonToFile(Response response) {
        try{
            String statusAds = getStatusAds(response);
            FileWriter writer = new FileWriter("src/test/resources/goldendata/ADS-"+statusAds+".json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonObject jsonObject = new JsonParser().parse(response.asString()).getAsJsonObject();
            String json = gson.toJson(jsonObject);
            writer.write(json);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static DocumentContext getData(Response response) {
        return JsonPath.parse(response.asString());
    }

    // From ADS Request
    public static String getIdAdsNumber() {
        Sinon sinon = new Sinon();
        Response response = sinon.createAds();
        return JsonPath.parse(response.asString()).read("$.data.ad.id");
    }

    public static String getIdAdsNumber(Response response)
    {
        return getData(response).read("$.data.ad.id");
    }
    public static String getTitleAds(Response response) {
        return getData(response).read("$.data.ad.title");
    }
    public static String getDescriptionAds(Response response) {
        return getData(response).read("$.data.ad.title");
    }
    public static String getStatusAds(Response response) {
        return getData(response).read("$.data.ad.status");
    }
    //From Create User Request
    public static String getUserName(Response response) {
        return getData(response).read("$.data.user.email");
    }
    public static String getPassword(Response response) {
        return getData(response).read("$.data.user.password");
    }
    public static String getUserId(Response response) {
        return getData(response).read("$.data.user.id");
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] getData(Method m) {
        String testname = m.getName() + ".json";
        File jsonFileDir = new File("src/test/resources/goldendata/");
        File jsonfile = new File(jsonFileDir, testname);
        JsonObject jsonObject = convertFiletoJson(jsonfile.getAbsoluteFile());
        return new Object[][]{{jsonObject}};
    }
}
