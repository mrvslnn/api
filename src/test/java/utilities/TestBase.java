package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestBase {

    protected RequestSpecification spec01;
    protected RequestSpecification spec02;
    protected RequestSpecification spec03;
    Map<String,String> bookingDatesMap=new HashMap<>();

    Map<String,Object> requestBodyMap=new HashMap<>();
    @Before
    public  void setSpec01() {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }
        @Before
        public void setSpec02(){
            spec02=new RequestSpecBuilder().
                    setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
                    build();
        }

    @Before
    public void setSpec03(){
        spec03=new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com/todos").
                build();
    }
    protected Response createRequestBody() {

        JSONObject jsonBookingDatesBody=new JSONObject();
        jsonBookingDatesBody.put("checkin","2020-05-02");
        jsonBookingDatesBody.put("checkout","2020-05-05");

        JSONObject jsonRequestBody=new JSONObject();
        jsonRequestBody.put("firstname","Eric");
        jsonRequestBody.put("lastname","Smith");
        jsonRequestBody.put("totalprice",555);
        jsonRequestBody.put("depozidpaid",false);
        jsonRequestBody.put("bookingdates", jsonBookingDatesBody);
        jsonRequestBody.put("additionalneeds","Wifi");

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).auth().
                basic("admin", "password123").
                body(jsonRequestBody.toString()).
                when().
                post("/booking");


        return response;


    }
    protected Response createRequestBodyMap(){
        bookingDatesMap.put("checkin","2020-05-02");
        bookingDatesMap.put("checkout","2020-05-05");


        requestBodyMap.put("firstname","Eric");
        requestBodyMap.put("lastname","Smith");
        requestBodyMap.put("totalprice",123);
        requestBodyMap.put("depozidpaid",true);
        requestBodyMap.put("bookingdates",bookingDatesMap);
        requestBodyMap.put("additionalneeds","Wifi");

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().
                basic("admin","password123").
                body(requestBodyMap.toString()).
                when().
                post("/booking");
return response;
    }

}



