package api.api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.openqa.selenium.json.Json;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends TestBase {
    @Test
    public void get01(){
        Response response=given().
                spec(spec02).
                when().
                get();
        response.prettyPrint();
        //jsonpath objesi olusturun
        JsonPath json=response.jsonPath();
        System.out.println(json.getString("data.employee_name"));
       //ikinci isminin "garret winters" oldugunu  verify edniiz
        assertEquals("isim istenen gibi degil","garret winters",json.getString("data[1].employee_name"));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("data[1].employee_name"),"garret winters");
         //iscilerin arasında herrod chandler oldugunu verify ediniz
        softAssert.assertTrue(json.getString("data.employee_name").contains("herrod chandler"));
       //7.isicnin massının 137500 old verify ediniz
        softAssert.assertEquals(json.getList("data[6].employee_salary").size(),137500);

        //24 tane isci oldugunu verify ediniz
        softAssert.assertEquals(json.getList("data.id").size(),24);
        softAssert.assertAll();
    }
}
