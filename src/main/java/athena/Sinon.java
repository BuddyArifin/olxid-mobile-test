package athena;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import pages.Constants;

import java.io.IOException;

/**
 * Created by buddyarifin on 8/4/16.
 */

public class Sinon {
    /**
     * Needed Operation
     * 1. Create Active Ads √
     * 2. Create User with SMS Password - not available yet
     * 3. Create User with Password √
     * 4. GET Category √
     * 5. Create User with Spesific Data - with GUI
     * 6. Create Active Ads with Params
     * */

     //Refactor
    public Sinon(){}

    protected Response response;
    protected RestAssured restAssured;

    public JsonObject getCities(){
        response = restAssured.given().when().get(Constants.base_uri + "trojan/allcities");
        return new JsonParser().parse(response.asString()).getAsJsonObject();
    }

    public JsonObject getDistricts(){
        response = restAssured.given().when().get(Constants.base_uri + "trojan/alldistrict");
        return new JsonParser().parse(response.asString()).getAsJsonObject();
    }

    public JsonObject getRegions(){
        response = restAssured.given().when().get(Constants.base_uri + "trojan/allregions");
        return new JsonParser().parse(response.asString()).getAsJsonObject();
    }

    public JsonObject getCategories(){
        response = restAssured.given().when().get(Constants.base_uri + "trojan/allcategories");
        return new JsonParser().parse(response.asString()).getAsJsonObject();
    }

    public JsonObject getAdsById(String id){
        response = restAssured.given().parameter("ad_id",id).when().get(Constants.base_uri + "trojan/adverts");
        return new JsonParser().parse(response.asString()).getAsJsonObject();
    }

    public JsonObject postCreateUserWithPassword(String email){
        response = restAssured.given().when().
                post(Constants.base_uri + "trojan/createuserwithpassword/?email="+email);
        return new JsonParser().parse(response.asString()).getAsJsonObject();
    }

    @Test
    public void testGetCities() throws IOException{
        Sinon sinon = new Sinon();
        System.out.println(sinon.getCities().toString());
    }

    @Test
    public void testGetDistricts() throws IOException{
        Sinon sinon = new Sinon();
        System.out.println(sinon.getDistricts().toString());
    }

    @Test
    public void testGetRegions() throws IOException{
        Sinon sinon = new Sinon();
        System.out.println(sinon.getRegions().toString());
    }

    @Test
    public void testGetCategories() throws IOException{
        Sinon sinon = new Sinon();
        System.out.println(sinon.getCategories().toString());
    }

    @Test
    public void testGetAdsById() throws IOException{
        Sinon sinon = new Sinon();
        String id = "1";
        System.out.println(sinon.getAdsById(id).toString());
    }

}
