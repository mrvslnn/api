package api.api01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends TestBase {
//    String jsonRequrstBody = "{\n" +
//            " \"firstname\": \"Eric\",\n" +
//            " \"lastname\": \"Smith\",\n" +
//            " \"totalprice\": 555,\n" +
//            " \"depositpaid\": false,\n" +
//            " \"bookingdates\": {\n" +
//            " \"checkin\": \"2020-05-02\",\n" +
//            " \"checkout\": \"2020-05-05\"\n" +
//            "},\n"+
//            "\"additionalneeds\":\"Wifi\"\n"+
//            " }";
    @Test
    public void post01(){
        JSONObject jsonBookingDatesBody=new JSONObject();
        jsonBookingDatesBody.put("checkin","2020-05-02");
        jsonBookingDatesBody.put("checkout","2020-05-05");

        JSONObject jsonRequestBody=new JSONObject();
        jsonRequestBody.put("firstname","Eric");
        jsonRequestBody.put("lastname","Smith");
        jsonRequestBody.put("totalprice",555);
        jsonRequestBody.put("depozidpaid",false);
        jsonRequestBody.put("bookingdates", jsonBookingDatesBody);
        jsonRequestBody.put("additionalneeds","Wifi");



    }
}
