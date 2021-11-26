package api.api01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest04 {
    /*negative scenario:
 when() bir get request asagıdanverilen endpointe yollanır
 https://restful-booker.herokuapp.com/booking
 then() HTTPS STATUS CODE 200 OLSUN dur
and() response format should be "applcation/json"
 and() there should be 24 employess
 and() "Ashton Cox" should be one of the employees
 aand() 21 61 ve 23 should be among the empliyee ages
  */
    // http://dummy.restapiexample.com/api/v1/employees
    @Test
    public void test() {
        Response response = given().accept("application/json").when().
                get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType("application/json").
                body("data.id", Matchers.hasSize(24)).
                body("data.employee_name", Matchers.hasItem("Doris Wilder")).
                body("data.employee_age", Matchers.hasItems(21,61,63));



    }
}