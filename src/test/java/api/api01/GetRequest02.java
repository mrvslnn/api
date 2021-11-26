package api.api01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {
    /*positive scenario:
    when() bir get request asagıdanverilen endpointe yollanır
    https://restful-booker.herokuapp.com/booking
    and() status code 200dur
    and() content type "application/json" dir
     */
    @Test
    public void get(){

        Response response = given().accept("application/json"). when().
                get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();


        response.then().contentType("application/json").statusCode(200);


    }
    /*negative scenario:
   when() bir get request asagıdanverilen endpointe yollanır
   https://restful-booker.herokuapp.com/booking
   then() status code 404dur
  and() response body notfound var
   and() "         "    merve yok
   and() content type "application/json" dir
    */
    @Test
    public void get03(){

        Response response = given().accept("application/json"). when().
                get("https://restful-booker.herokuapp.com/booking/47");
        response.prettyPrint();


        response.then().contentType("application/json").statusCode(404);


    }

    }

