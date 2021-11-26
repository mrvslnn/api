package api.api01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class GetRequest06 extends TestBase {
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
                     }
        }
    */
    @Test
    public  void  get01(){
        Response response=given().
                spec(spec01).
                when().
                get("/booking/5");
        response.prettyPrint();
        response.
then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("Ricky"),
                        "lastname", equalTo("Jackson"),
                        "totalprice",equalTo(249),
                        "depositpaid",equalTo(false),
                        "bookingdates.checkin",equalTo("2021-12-23"),
                        "bookingdates.checkout",equalTo("2013-06-09"));

//        spec02.pathParams("parametre1", "booking",
//                "parametre2", 2);
//
//
//        Response response =given().spec(spec02).
//                accept("application/json").
//                when().
//                get("/{parametre1}/{parametre2}");
//
//        //ikinci yöntem get("/booking/5);
//        response.prettyPrint();
//
//
//        response.then().contentType("application/JSON").
//                statusCode(200).body("firstname",equalTo("Hakan"),
//                        "lastname",equalTo("Tetik"),"totalprice",equalTo(861) ,"depositpaid",equalTo(true),
//                        "bookingdates.checkin",equalTo("2021-03-29"),"bookingdates.checkout",equalTo("2021-04-08"));


    }
}