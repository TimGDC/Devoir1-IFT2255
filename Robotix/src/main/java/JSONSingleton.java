import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
/**
 * Implementation du patron de conception Singleton pour gerer le JSON et s'assurer d'avoir une instance.
 */
public class JSONSingleton {

    private static JSONSingleton instance;
    /**
     * Constructeur prive pour limiter l'acces
     */
    private JSONSingleton() {
    }
    /**
     * Methode pour creer une instance de JSONSingleton
     * @return l'instance
     */
    public static JSONSingleton getInstance() {
        if (instance == null) {
            instance = new JSONSingleton();
        }
        return instance;
    }
    /**
     * Methode pour parser un fichier JSON, ici la base de donnees
     * @param filePath le chemin du fichier
     * @return un Object JSON representant la base de donnees
     * @throws IOException
     * @throws ParseException
     */
    public JSONObject parseJSONFile(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filePath));
        return (JSONObject) obj;
    }
}
