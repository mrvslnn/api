package api.api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends TestBase {
    @Test
    public void get01(){
        Response response=given().
                spec(spec02).when().get();

        JsonPath json=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(json.getString("data[0].employee_name"),"Tiger Nixer");
        softAssert.assertEquals(json.getString("data[1].employee_name"),"Garrett Winters");
        softAssert.assertEquals(json.getString("data[2].employee_name"),"Ashton Cox");
        softAssert.assertEquals(json.getString("data[3].employee_name"),"Cedric Kelly");
        softAssert.assertEquals(json.getString("data[4].employee_name"),"Airi Satou");


//        for (int i=0; isimList.size(); i++){
//    softAssert.assertEquals(json.getString("data["+ i +"].employee_name"),);
//}
        List<Map>actualList=json.getList("data");
        System.out.println(actualList);

        Map<Integer,String> exceptedMap=new HashMap<>();
        exceptedMap.put(0,"Tiger Nixer");
        exceptedMap.put(1,"Garrett Winters");
        

        for (int i=0; i<exceptedMap.size();i++){
            softAssert.assertEquals(actualList.get(i).get("employee_name"),exceptedMap.get(i));

        }
    }
}
