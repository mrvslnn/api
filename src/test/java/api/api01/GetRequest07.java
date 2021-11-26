package api.api01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class GetRequest07 extends TestBase {
    //firstname i suzan olanı bul
    @Test
    public void get() {


        Response response = given().
                spec(spec01).
                when().
                get("/booking/5");
        response.prettyPrint();
        assertTrue(response.getBody().asString().contains("bookingid"));
    }

    @Test
    public void get02() {
        spec01.queryParam("firstname", "Susan");

        Response response = given().
                spec(spec01).
                when().
                get("/booking");
        response.prettyPrint();
        assertTrue(response.getBody().asString().contains("bookingid"));
}}