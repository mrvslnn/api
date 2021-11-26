package api.api01;

import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends TestBase {
    @Test
    public void get01() {
        Response response = given().
                spec(spec03).
                when().
                get();
        response.prettyPrint();

        List<HashMap<String,Object>> listOfMaps= response.as(ArrayList.class);
        System.out.println(listOfMaps);
        System.out.println(listOfMaps.get(0));
        //200 tane id old verify ediniz
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(listOfMaps.size()==200,"bingo");

        //121. elemanın complted degerinin true oldugunu verify ediniz
        softAssert.assertEquals(listOfMaps.get(120).get("completed"),true);

       //sondan bir onceki elemanın title "numquam reppelendus a magnam" old verify ediniz
        softAssert.assertEquals(listOfMaps.get(120).get("completed"),true);

        softAssert.assertAll();
    }
}