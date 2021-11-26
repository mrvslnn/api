package api.api01;

import org.junit.Test;
import utilities.BookingDates;
import utilities.JsonUtil;

public class ObjectMapperTestWithPojo {

    @Test
    public void javaToJson(){
        BookingDates bookingDates=new BookingDates("2020-11-03","2020-11-08");
        String jsonFromPojo= JsonUtil.convertJavaToJson(bookingDates);
        System.out.println(jsonFromPojo);
    }
}
