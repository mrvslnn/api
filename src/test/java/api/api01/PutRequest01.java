package api.api01;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends TestBase {
    @Test
    public void put01(){
        Response response=given().
                spec(spec01).when().get("/booking");
        response.prettyPrint();
        JSONObject jsonObject=new JSONObject();

    }
}
