package api.api01;

import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import utilities.Booking;
import utilities.JsonUtil;
import utilities.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ObjectMapperTestWithMap extends TestBase {

    @Test
    public void javaToJson(){
        HashMap<Integer,String> map=new HashMap<>();
        map.put(101,"Ali");
        map.put(102,"Can");
        map.put(103,"remziye");
        System.out.println(map);

        String jsonFromMap=JsonUtil.convertJavaToJson(map);
        System.out.println(jsonFromMap);
    }
    @Test
    public void jsonToJava(){
        Response response=given().spec(spec01).when().get("/booking/3");
        response.prettyPrint();
        //apıden gelen json datayı mape cevirdim -->de serialization
        Map<String,Object> jsonToMapApi=JsonUtil.ConvertJsonToJava(response.asString(),Map.class);
        System.out.println(jsonToMapApi);
        /*apiden gelen json formatındaki datayı mape cevirdim
        testcase de bana verilen datatyı map e cevircem
        1.maddede olusturduum map ile 2.adımda olusturdugummap dek dataalrı karsılastırarak
        verification yapacagım
         */
Map<String,Object> jsonToMapTestCase=new HashMap<>();
jsonToMapTestCase.put("firstname","Sally");
jsonToMapTestCase.put("lastname","Smith");
jsonToMapTestCase.put("totalprice",152);
jsonToMapTestCase.put("depositpaid",false);

response.then().assertThat().statusCode(200);
assertEquals(jsonToMapTestCase.get("firstname"),jsonToMapApi.get("firstname"));
    }

//    @Test
//    public void jsonToJava(){
//        Response response=given().spec(spec01).when().get("/booking/3");
//        Booking jsonToPojoApi=JsonUtil.convertJavaToJson(response.asString(),Booking.class);
//    }
}
