package api.api01;


import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    //rest assured kullanarak api testing ypacagız

    @Test
    public void getMethosd01(){
        given().
        when().
                get("https://restful-booker.herokuapp.com").
                then().
                       assertThat().
                        statusCode(200);
    }
    @Test
    public void getMethods2(){
        Response response = given(). when().
                get("https://restful-booker.herokuapp.com/booking/3");
        response.prettyPrint();

        System.out.println(response.getStatusCode());
        //responce body daki datanın content yani icerik
        System.out.println(response.getContentType());

        //headers daki bilgileri almak
        System.out.println(response.getHeaders());
        //headers daki istenen bir datayı almak ıcın
        System.out.println("Date" + response.getHeader("Date"));

        //assertion yapalım
        //1)status code 200
        //assertthat hard assertion demektir ilk hatada excution da durur ve hata verir
        response.then().assertThat().contentType("application/json; charset=utf-8").statusCode(200);
        response.then().assertThat().statusLine("HTTP/1.1 200 OK").contentType("application/json; charset=utf-8").statusCode(200);

    }

}
