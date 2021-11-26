package api.api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest08 extends TestBase {
/*
    https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
    HTTP Status Code’unun 200
    ve response content type’inin “application/JSON” oldugunu
    ve response body’sinin asagidaki gibi oldugunu test edin
    {"firstname": Sally,
            "lastname": "Smith",
            "totalprice": 789,
            "depositpaid": false,
            "bookingdates": {
               "checkin": "2017-12-11",
                "checkout":"2020-02-20"
                 */

@Test
    public void get01(){
    spec01.pathParam("bookibgid",5);
    Response response=given().
            spec(spec01).
when().get("/booking/5");
    response.prettyPrint();
    JsonPath json=response.jsonPath();
    System.out.println(json.getString("firsname"));
    assertEquals("firstname istenilen gibi degil","Jim",json.getString("firsname"));

    System.out.println(json.getString("lastname"));
    assertEquals("firstname istenilen gibi degil","Jones",json.getString("lastname"));

    System.out.println(json.getInt("totalPrice"));
    assertEquals("istenilen gibi degil",("580"), json.getString("totalprice"));

    System.out.println(json.getBoolean("depositpaid"));
    assertEquals("istenilen gibi degil",true,json.getBoolean("depositpaid"));


    System.out.println(json.getString("bookingdates.checkin"));
    assertEquals("istenilen gibi degil",("2012-04-09"), json.getString("bookingdates.checkin"));

    System.out.println(json.getString("bookingdates.checkout"));
}
}
