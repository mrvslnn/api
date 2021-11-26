package api.api01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends TestBase {
    /*
       http://dummy.restapiexample.com/api/v1/employees
   url ine bir istek gönderildiğinde
   Dönen response un
    Status kodunun 200,
    1)10’dan büyük tüm id’leri ekrana yazdırın ve
   10’dan büyük 14 id olduğunu,
    2)30’dan küçük tüm yaşları ekrana yazdırın ve
     bu yaşların içerisinde en büyük yaşın 23 olduğunu
    3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
     bunların içerisinde “Charde Marshall” olduğunu test edin
        */
    @Test
    public void get01() {
        Response response = given().
                spec(spec02).
                when().
                get();
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        JsonPath json = response.jsonPath();
        SoftAssert  softAssert=new SoftAssert();
        //10dan buyuk tum id leri consola yazdır
        List<Integer> idList = json.getList("data.findAll{it.id>10}.id");
        System.out.println(idList);
        softAssert.assertEquals(idList.size(),14,"sorun verdi");


        List<Integer> idList1 = json.getList("data.findAll{it.employee_age<30}.employee_age");
        Collections.sort(idList1);
        System.out.println(idList1);
        System.out.println(idList1.get(idList1.size() - 1));
        softAssert.assertEquals(idList1.size()-1,23,"sorun verdi");

        List<Integer> idList2= json.getList("data.findAll{it.employe_salary<30}.employee_name");
        softAssert.assertTrue(idList2.contains("Charde Marshall"),"Lütfen tekrar deneyiniz");
        softAssert.assertAll();

    }
}