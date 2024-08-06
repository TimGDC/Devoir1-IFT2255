

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class User {

    private String username;
    private String password;
    private String email;
    private boolean notificationsEmail;
    private ArrayList<Robot> listeRobotsUser = new ArrayList<>();
    private ArrayList<String> listeSuiveursUser = new ArrayList<>();;
    private ArrayList<String> listeInteretsUser = new ArrayList<>();;
    private ArrayList<String> listeActivitesUser = new ArrayList<>();;
    private String[] notifications = {"", ""};
    private Object obj;
    private JSONObject baseDonneeObjet;

    private static final String FILE_PATH = "src/main/java/BaseDonnee.json";


    public User(String username, String password, String email, boolean notificationsEmail) throws IOException, ParseException {

        this.username = username;
        this.password = password;
        this.email = email;
        this.notificationsEmail = notificationsEmail;
        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONObject nouvelUtilisateurObjet = new JSONObject();
        nouvelUtilisateurObjet.put("password", password);
        nouvelUtilisateurObjet.put("email", email);
        nouvelUtilisateurObjet.put("username", username);
        nouvelUtilisateurObjet.put("notificationsEmail", true);

        JSONArray utilisateurActivite = new JSONArray();
        JSONArray utilisateurRobots = new JSONArray();
        nouvelUtilisateurObjet.put("robots",utilisateurRobots);
        nouvelUtilisateurObjet.put("activites",utilisateurActivite);



        JSONArray listeUtilisateurs = (JSONArray) baseDonneeObjet.get("Users");
        listeUtilisateurs.add(nouvelUtilisateurObjet);


        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        }
        generationNotification();

    }

    private void generationNotification() {

        String notif1 = "Un de vos robots n'a plus de batterie!";
        String notif2 = "Un de vos robots est plein a 100%!";
        String notif3 = "Un de vos robots a une composante manquante!";
        String notif4 = "Vos composantes ont ete livrees!";
        String[] listeNotifications = {notif1, notif2, notif3, notif4};

        Random random = new Random();
        notifications[0] = listeNotifications[random.nextInt(4)];
        notifications[1] = listeNotifications[random.nextInt(4)];
        JSONArray notifJson = new JSONArray();
        notifJson.add(notifications[0]);
        notifJson.add(notifications[1]);

        JSONArray userList = (JSONArray) baseDonneeObjet.get("Users");
        int jsonI = 0;
        for(int i = 0; i < userList.size() ; i++){
            JSONObject userIndex = (JSONObject) userList.get(i);
            if(Objects.equals(userIndex.get("username"), this.username)){
                jsonI = i;
            }
        }
        JSONObject currentUser = (JSONObject) userList.get(jsonI);
        currentUser.put("notifications", notifJson);

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public String getUsername(){

        return this.username;
    }

    public void setUsername(String user){

        this.username = user;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }

    public ArrayList<String> getSuiveurs(){
        return this.listeSuiveursUser;
    }

    public ArrayList<Robot> getListeRobots(){
        return this.listeRobotsUser;
    }
    public void afficherListeRobots(){
        System.out.println("Liste des robots : ");
        for(Robot rob : listeRobotsUser){
            System.out.println(rob.getNom());
        }
    }


    public void enregistrerRobot(int numeroSerie, String nom, int jsonIndex) throws IOException, ParseException {

        Robot nouveauRobot = new Robot(nom, numeroSerie, jsonIndex);
        listeRobotsUser.add(nouveauRobot);

    }

    public void supprimerRobot(String nom, int index) throws IOException , ParseException{

        listeRobotsUser.removeIf(rob -> Objects.equals(rob.getNom(), nom));

        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONArray listeUser = (JSONArray) baseDonneeObjet.get("Users");
        JSONObject userActuel = (JSONObject) listeUser.get(index);
        JSONArray listeRobotsJson = (JSONArray) userActuel.get("robots");
        for(int j = 0; j < listeRobotsJson.size(); j++){
            JSONObject robots = (JSONObject) listeRobotsJson.get(j);
            if(Objects.equals(robots.get("nom"), nom)){
                listeRobotsJson.remove(j);
                break;
            }
        }
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void modifierProfil(String user, String pw, String email, boolean notifs, int index) throws IOException , ParseException{

        this.username = user;
        this.password = pw;
        this.email = email;
        this.notificationsEmail = notifs;

        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        //this.obj = new JSONParser().parse(new FileReader("src/main/java/BaseDonnee.json"));
        //this.baseDonneeObjet = (JSONObject) obj;

        JSONArray listeUser = (JSONArray) baseDonneeObjet.get("Users");
        JSONObject userActuel = (JSONObject) listeUser.get(index);
        userActuel.put("username", user);
        userActuel.put("password", pw);
        userActuel.put("email", email);
        userActuel.put("notificationsEmail", notifs);


        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        }


    }

    public void afficherActivites(){
        System.out.println("Liste d'activites : ");
        for(String act : listeActivitesUser){
            System.out.println(act);
        }
    }
    public void ajouterActivite(Activite activite, int index) throws IOException , ParseException{



        listeActivitesUser.add(activite.getNom());

        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        //this.obj = new JSONParser().parse(new FileReader("src/main/java/BaseDonnee.json"));
        //this.baseDonneeObjet = (JSONObject) obj;

        JSONArray listeUser = (JSONArray) baseDonneeObjet.get("Users");
        JSONObject userActuel = (JSONObject) listeUser.get(index);
        JSONArray listeActiviteJson = (JSONArray) userActuel.get("activites");

        JSONObject nouvelleActiviteJson = new JSONObject();
        nouvelleActiviteJson.put("nom" , activite.getNom());
        nouvelleActiviteJson.put("duree" , activite.getDuree());
        nouvelleActiviteJson.put("description" , activite.getDescription());
        nouvelleActiviteJson.put("status" , activite.getStatus());
        nouvelleActiviteJson.put("interet" , activite.getInteret());

        listeActiviteJson.add(nouvelleActiviteJson);



        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        }
        System.out.println(baseDonneeObjet);

    }

    public void supprimerActivite(Activite activite, int index)throws IOException , ParseException{

        listeActivitesUser.remove(activite.getNom());

        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONArray userList = (JSONArray) baseDonneeObjet.get("Users");
        JSONObject userActuel = (JSONObject) userList.get(index);
        JSONArray userActivite = (JSONArray) userActuel.get("activites");
        for(int i = 0 ; i < userActivite.size() ; i++){
            JSONObject activiteActuelle = (JSONObject) userActivite.get(i);
            if(Objects.equals(activite.getNom(), activiteActuelle.get("nom"))){
                userActivite.remove(i);
                break;
            }
        }

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void afficherEtats(int vue){
        if(listeRobotsUser.isEmpty()){
            System.out.println("Vous ne possedez pas de robots!");
        }else{
            if(vue == 0){
                System.out.println("Voici la vue generale de tous vos robots : ");
                for(Robot robot : listeRobotsUser){
                    System.out.printf("Nom : %s \nBatterie : %d\n", robot.getNom(), robot.getBatterie());
                }
            }else {
                System.out.println("Voici la vue complete de tous vos robots : ");
                for (Robot robot : listeRobotsUser) {
                    System.out.printf("Nom : %s \nBatterie : %d\nConsommation CPU : %d GHz\nConsommation Memoire : %d GB\nVitesse : %d km/h\nPosition : x=%d y=%d z=%d\n", robot.getNom(), robot.getBatterie(),
                            robot.getConsommationCPU(), robot.getConsommationMemoire(), robot.getVitesse(), robot.getPosition()[0], robot.getPosition()[1], robot.getPosition()[2]);
                }
            }
        }


    }

    public void afficherNotifications(){
        System.out.println("Voici vos notifications : ");
        for(String notif : notifications){
            System.out.println(notif);
        }
    }


    public ArrayList<String> getInterets() {
        return listeInteretsUser;
    }

    public ArrayList<String> getActivites() {
        return listeActivitesUser;
    }
}
