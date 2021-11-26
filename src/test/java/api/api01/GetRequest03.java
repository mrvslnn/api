package api.api01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest03 {
    /*when i send get request to rest api url
    https://restful-booker.herokuapp.com/booking/1
    and accept type is "application/JSON"
    then HTTPS STATUS CODE SHOULD BE "application/JSON"
    and fisrt name susan
    and lastname brown
    and checkin date should be "2015-02-16"
    and checkout date should be "2017-06-20"

     */



    @Test
    public void get01(){
        Response response=given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking/1");
                response.prettyPrint();
    response.then().assertThat().statusCode(200).
            contentType("application/json").
            body("firstname", Matchers.equalTo("Sally")).
            body("lastname",Matchers.equalTo("jackson")).
            body("totalprice",Matchers.equalTo(5000)).
            body("depositpaid",Matchers.equalTo(true)).
            body("bookingdates.chekin",Matchers.equalTo("2015-02-03")).
            body("bookingdates.chekout",Matchers.equalTo("2015-03-12")).
            body("additionalneeds",Matchers.equalTo("BALIK_EKMEK_LIMON_TURSU_ve_Baklava_Yemiyek_mi"));
    //2.yol
        assertEquals(200,response.getStatusCode());
//tekbody deyazmaca
        response.then().assertThat().statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Sally"),
                        "lastname",Matchers.equalTo("jackson"),
                "totalprice",Matchers.equalTo(5000),
                "depositpaid",Matchers.equalTo(true),
                "bookingdates.chekin",Matchers.equalTo("2015-02-03"),
                "bookingdates.chekout",Matchers.equalTo("2015-03-12"),
                "additionalneeds",Matchers.equalTo("BALIK_EKMEK_LIMON_TURSU_ve_Baklava_Yemiyek_mi"));

    }
}
