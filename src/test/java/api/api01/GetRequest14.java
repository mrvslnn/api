package api.api01;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends TestBase{

        @Test
        public void get01() {
            Response response = given().
                    spec(spec03).
                    when().
                    get();
            response.prettyPrint();

            List<HashMap<String,Object>> listOfMapsByGson= response.as(ArrayList.class);
            System.out.println(listOfMapsByGson);
            System.out.println(listOfMapsByGson.get(0));
            //200 tane id old verify ediniz
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(listOfMapsByGson.size()==200,"bingo");

            //121. elemanın complted degerinin true oldugunu verify ediniz
            softAssert.assertEquals(listOfMapsByGson.get(120).get("completed"),true);

            //sondan bir onceki elemanın title "numquam reppelendus a magnam" old verify ediniz
            softAssert.assertEquals(listOfMapsByGson.get(listOfMapsByGson.size()-2).get("title"),"umquam repellendus a magnam");

            softAssert.assertAll();
            //jaca objectini json formatına cevirme
            Gson gson=new Gson();
            String jsonFormList=gson.toJson(listOfMapsByGson);
            System.out.println(jsonFormList);

        }
    }

