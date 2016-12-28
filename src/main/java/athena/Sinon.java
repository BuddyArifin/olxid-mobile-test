package athena;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import pages.Constants;
import pages.InstanceDriver;
import utils.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by buddyarifin on 8/4/16.
 */

public class Sinon extends InstanceDriver{
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
    protected static String user_id = "60028131";

    public void setUser_id(String user_id_new) {
        user_id = user_id.replace(getUser_id(), user_id_new);
    }

    public String getUser_id() {
        return user_id;
    }


    public Response getCities(){
        return response = RestAssured.given()
                .when().get(Constants.base_uri + "trojan/allcities");
    }

    public Response getDistricts(){
        return response = RestAssured.given()
                .when().get(Constants.base_uri + "trojan/alldistrict");
    }

    public Response getRegions(){
        return response = RestAssured.given()
                .when().get(Constants.base_uri + "trojan/allregions");
    }

    public Response getCategories(){
        return response = RestAssured.given()
                .when().get(Constants.base_uri + "trojan/allcategories");
    }

    public Response getAdsById(String id){
        return response = RestAssured.given()
                .parameter("ad_id",id)
                .when().get(Constants.base_uri + "trojan/adverts");
    }

    public Response postCreateUserWithPassword(String email){
        return response = RestAssured.given().when()
                .post(Constants.base_uri + "trojan/createuserwithpassword/?email="+email);
    }

    public Response postCreateUserWithPassword(){
        this.response = RestAssured.given().when()
                .post(Constants.base_uri + "trojan/createuserwithpassword/");
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(200).build());
        return response;
    }

    public Response createAds() {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", getUser_id());
        params.put("title", " Jual Helm Full Face [TEST] ");
        params.put("description", "Alasan jual, karena lagi testing");

        this.response = RestAssured.with()
                .queryParameters(params)
                .when()
                .post(Constants.base_uri + "trojan/createactivead/");
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(200).build());
        DataBuilder.convertJsonToFile(response);
        return response;
    }

    /**
     * @param status must be registered as
     * status blocked = Moderasi
     * status removed_by_user, outdated = Tidak aktif
     * status moderated, removed_by_moderator = Ditolak
     * status active, disabled = active
     */
    public Response createAdsWithStatus(String status) {
        Map<String, String> params = new HashMap<>();
        params.put("status", status);

        this.response = RestAssured.with()
                .queryParameters(params)
                .when()
                .post(Constants.base_uri + "trojan/createadwithstatus/");
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(200).build());
        DataBuilder.convertJsonToFile(response);
        return response;
    }

    public Response createUserWithBalance() {
        this.response = RestAssured.with()
                .when()
                .post(Constants.base_uri + "trojan/createuserwithbalance/");
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(200).build());
        return response;
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

    @Test
    public void testCreateAds() throws IOException{
        Sinon sinon = new Sinon();
        sinon.createAds();
    }

    @Test
    public void testCreateNonActiveAds() throws IOException {
        Sinon sinon = new Sinon();
        sinon.createAdsWithStatus("removed_by_user");
    }
    @Test
    public void testCreateUserWithBalance() throws IOException {
        Sinon sinon = new Sinon();
        Response response = sinon.createUserWithBalance();
        Log.debug(DataBuilder.getUserName(response));
        Log.debug(DataBuilder.getPassword(response));
    }

    @Test
    public void testCreateUserWithPassword() throws IOException {
        Sinon sinon = new Sinon();
        Response response = sinon.postCreateUserWithPassword("whoami@olx.co.id");
        Log.debug(DataBuilder.getUserName(response));
        Log.debug(DataBuilder.getPassword(response));
        setUser_id(DataBuilder.getUserId(response));
        sinon.createAds();
    }

    @Test
    public void testCreateRandomUser() throws IOException {
        Sinon sinon = new Sinon();
        Response response = sinon.postCreateUserWithPassword();
        Log.debug(DataBuilder.getUserName(response));
        Log.debug(DataBuilder.getPassword(response));
    }

}
