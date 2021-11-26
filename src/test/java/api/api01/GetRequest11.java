package api.api01;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest11 extends TestBase {

    //
    @Test
    public void get01(){
        Response response=given().
                spec(spec03).
                when().
                get("/2");
        response.prettyPrint();

        HashMap<String,String> map=response.as(HashMap.class);//de serialization
        System.out.println(map);
        System.out.println(map.keySet());//id completed title userId
        System.out.println(map.values());//2.0 flase quis ut nam faciils et officia qui 1.0
        //completed key sinin deginin false oldugunu verify ediniz
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(map.get("completed"), false,"false omalıydı ama degil");
        //user id title degerlerini verify ediniz
        softAssert.assertEquals(map.get("userId"), 1,"false omalıydı ama degil");
        softAssert.assertEquals(map.get("title"),"quis ut nam facilis et officia qui" ,"false omalıydı ama degil");
        softAssert.assertEquals(map.get("id"), 2,"yanlis");
        softAssert.assertAll();

        Gson gson = new Gson();

        String oflistmap= gson.toJson(map);

        System.out.println(oflistmap);
    }
}
