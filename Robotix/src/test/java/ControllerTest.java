import org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;
import java.awt.geom.Arc2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.junit.jupiter.api.Assertions;

class ControllerTest {
    private Controller controller;
    private View view;
    private ArrayList<User> listUser;
    private ArrayList<Fournisseur> listFourni;
    private Activite[] listActivite = new Activite[2];
    private JSONObject objet;
    private ArrayList<Composante> listComposantes;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() throws ParseException, IOException {

        User user1 = new User("mehdi", "password123", "mehdi@gmail.com", true);
        User user2 = new User("tim", "pass", "tim@gmail.com", false);
        Fournisseur fournisseur1 = new Fournisseur("fourn1", "fournipass", "fourn@hotmail.com", "123 rue abc", "CPU", true, 500);
        Activite activite1 = new Activite("Cinema", 2, "cine", "film", "En cours");
        Activite activite2 = new Activite("Soccer", 4, "ballon", "sport", "non debutee");
        listUser = new ArrayList<>();
        listUser.add(user1);
        listUser.add(user2);
        listFourni = new ArrayList<>();
        listFourni.add(fournisseur1);
        listActivite[0] = activite1;
        listActivite[1] = activite2;
        view = new View();
        listComposantes = new ArrayList<>();
        objet = new JSONObject();
        controller = new Controller(view, listUser, listFourni, listComposantes, listActivite, objet);
    }

    @Test
    public void testEnregistrerRobot() throws IOException, ParseException {
        String nom = "robot";
        listUser.get(0).enregistrerRobot(12345, nom, 0);
        boolean existe = false;
        for (Robot robot : listUser.get(0).getListeRobots()) {
            if (Objects.equals(robot.getNom(), nom)) {
                existe = true;
            }
        }
        Assertions.assertTrue(existe);
    }

    @Test
    public void testModifierProfil() throws IOException, ParseException {
        String username = "test";
        listUser.get(0).modifierProfil(username, "abc", "test", true, 0);
        Assertions.assertTrue(listUser.get(0).getUsername() == username);
    }


    @Test
    public void testRechercherUtilisateur_UserExists() {
        Assertions.assertTrue(controller.rechercherUtilisateur("mehdi"));
    }

    @Test
    public void testRechercherUtilisateur_UserDoesNotExist() {
        Assertions.assertFalse(controller.rechercherUtilisateur("wayne"));
    }

    /*@Test
    public void testGetString(){
        Assertions.assertTrue(isString(view.getString()) );
    }
    @Test
    public void testGetBoolean(){
        Assertions.assertTrue(isBoolean(view.getBool()));
    }
    @Test
    public void testGetFloat(){
        Assertions.assertTrue(isFloat(view.getFloat()) );
    }
    @Test
    public void testGetInt(){
        Assertions.assertTrue(isInt(view.getInt()));
    }
    public static boolean isBoolean(Object obj) {
        return obj instanceof Boolean;
    }
    public static boolean isFloat(Object obj) {
        return obj instanceof Float;
}
public static boolean isInt(Object obj) {
        return obj instanceof Integer;
}
    public static boolean isString(Object obj) {
        return obj instanceof String;}
     */
}