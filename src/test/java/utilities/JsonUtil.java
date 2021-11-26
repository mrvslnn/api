
package utilities;
import org.codehaus.jackson.map.ObjectMapper;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import java.io.IOException;
public class JsonUtil {
    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }
    public static String convertJavaToJson(Object object){
        String jsonResult = "";
        try {
            jsonResult = mapper.writeValueAsString(object);


        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
    //lson formatındaki datayı java object e ceviren method
    public static <T> T ConvertJsonToJava(String json, Class<T> cls) {
        T javaResult = null;
        try {
            javaResult= mapper.readValue(json, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;

    }

}
