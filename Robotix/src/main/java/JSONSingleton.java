import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONSingleton {

    private static JSONSingleton instance;

    private JSONSingleton() {
    }

    public static JSONSingleton getInstance() {
        if (instance == null) {
            instance = new JSONSingleton();
        }
        return instance;
    }

    public JSONObject parseJSONFile(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filePath));
        return (JSONObject) obj;
    }
}
