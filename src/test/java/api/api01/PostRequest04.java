package api.api01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest04 extends TestBase {
    @Test
    public void post01(){
        Map<String,String> bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin","2020-05-02");
        bookingDatesMap.put("checkout","2020-05-05");

        Map<String,Object> requestBodyMap=new HashMap<>();
        requestBodyMap.put("firstname","Eric");
        requestBodyMap.put("lastname","Smith");
        requestBodyMap.put("totalprice",123);
        requestBodyMap.put("depozidpaid",true);
        requestBodyMap.put("bookingdates",bookingDatesMap);
        requestBodyMap.put("additionalneeds","Wifi");

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().
                basic("admin","password123").
                body(requestBodyMap.toString()).
                when().
                post("/booking");
response.prettyPrint();



    }
}
