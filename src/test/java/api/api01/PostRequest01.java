package api.api01;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class PostRequest01 extends TestBase {
    /*accept type json olsun
    post request yolladgımda

    status code 200 olmalı responce body ile request body aynı olmalı
     */
    //1.way
    @Test
    public void post01(){

        String jsonRequestBody = "{\n" +
                " \"firstname\": \"Eric\",\n" +
                " \"lastname\": \"Smith\",\n" +
                " \"totalprice\": 555,\n" +
                " \"depositpaid\": false,\n" +
                " \"bookingdates\": {\n" +
                " \"checkin\": \"2016-09-09\",\n" +
                " \"checkout\": \"2017-09-21\"\n" +
                "},\n"+
                "\"additionalneeds\":\"Wifi\"\n"+
                " }";
        Response response=given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().
                basic("admin","password123").
                body(jsonRequestBody.toString()).
                when().
                post("/booking");
        response.prettyPrint();

        //status code 200olmalı
response.then().assertThat().statusCode(200);
//assertion kullanarak yaoalım
        JsonPath json=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"), "Eric");
        softAssert.assertEquals(json.getString("booking.lasttname"), "Smith");
        softAssert.assertEquals(json.getString("booking.totalprice"), 555);
        softAssert.assertEquals(json.getString("booking.depozidpaid"), false);
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), "2016-09-09");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"), "2017-09-21");
        softAssert.assertEquals(json.getString("booking.additionalneeds"), "Wifi");
        softAssert.assertAll();





    }
}