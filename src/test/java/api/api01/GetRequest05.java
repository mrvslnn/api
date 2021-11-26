package api.api01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {
    /* when ı send a get request to rest apı url
    https://restful-booker.herokuapp.com/booking/5
    then http status code 200 olsun
    and firstname should be jim
    and totalprice should be 602
    and checkin should be 2015-06-12
     */
    @Test
    public void test() {
        Response response = given().accept("application/json").when().
                get("https://restful-booker.herokuapp.com/booking/5");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/JSON").
                body("firstname", Matchers.equalTo("Eric"),
                        "totalprice", Matchers.equalTo(602),
                        "bookingdates.checkin", Matchers.equalTo("2015-06-12"));
    }
}