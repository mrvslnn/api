package api.api01;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.Booking;
import utilities.BookingDates;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class PostRequest05 extends TestBase {

    /*accept type json olsun
post request yolladıgında requestbody
{
 "firstname": "Eric",
 "lastname": "Smith",
 "totalprice": 555,
 "depositpaid": false,
 "bookingdates": {
 "checkin": "2016-09-09",
 "checkout": "2017-09-21"
 }
 "additionalneeds": "Wifi"
 }
 Then
status code 200 olmalı
response body nın request body ile aynı old verify yapınız

}
     */
@Test
public void post01(){
    BookingDates bookingDates=new BookingDates("2016-09-09","2017-09-21");
    Booking booking=new Booking("Eric","Smith",555,false,bookingDates,"Wifi");
    Response response=given().
            contentType(ContentType.JSON).
            spec(spec01).
            auth().
            basic("admin","password123").
            body(booking).
            when().
            post("/booking");
    response.prettyPrint();


    //status code 200olmalı
        response.
                then().
                assertThat().
                statusCode(200);
    //assertion kullanarak yaoalım
    JsonPath json=response.jsonPath();
    SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"), booking.getFirstname());
        softAssert.assertEquals(json.getString("booking.lastname"), booking.getLastname());
        softAssert.assertEquals(json.getInt("booking.totalprice"), booking.getTotalprice());
        softAssert.assertEquals(json.getBoolean("booking.deposidpaid"), false);
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), "2016-09-09");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"), "2017-09-21");
        softAssert.assertEquals(json.getString("booking.additionalneeds"), "Wifi");
        softAssert.assertAll();
}
}