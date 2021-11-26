package api.api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class PostRequest03 extends TestBase {
    @Test
    public void post01(){
        Response response=createRequestBody();
        response.prettyPrint();

        //status code 200olmalı
        response.then().assertThat().statusCode(200);
//assertion kullanarak yapalım
        JsonPath json=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"), "Eric");
        softAssert.assertEquals(json.getString("booking.lastname"), "Smith");
        softAssert.assertEquals(json.getList("booking.totalprice"), 555);
        softAssert.assertEquals(json.getBoolean("booking.deposidpaid"), false);
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), "2016-09-09");
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"), "2017-09-21");
        softAssert.assertEquals(json.getString("booking.additionalneeds"), "Wifi");
        softAssert.assertAll();
    }
    }

