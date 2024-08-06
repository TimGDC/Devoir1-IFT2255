

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Fournisseur {

    private String username;
    private String password;
    private String email;
    private String adresse;
    private String type;
    private int capaciteFabrication;
    boolean notificationsEmail;
    private ArrayList<String> notifications = new ArrayList<>();
    private Object obj;
    private JSONObject baseDonneeObjet;
    private final String FILE_PATH = "src/main/java/BaseDonnee.json";
    private ArrayList<Composante> listeComposante = new ArrayList<>();

    public Fournisseur(String user, String pw, String email, String adresse, String type, boolean notifs, int production) throws IOException, ParseException {

        this.username = user;
        this.password = pw;
        this.email = email;
        this.adresse = adresse;
        this.type = type;
        this.capaciteFabrication = production;
        this.notificationsEmail = notifs;


        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONObject nouveauFournisseurObjet = new JSONObject();
        nouveauFournisseurObjet.put("password", password);
        nouveauFournisseurObjet.put("email", email);
        nouveauFournisseurObjet.put("username", username);
        nouveauFournisseurObjet.put("notificationsEmail", notificationsEmail);
        nouveauFournisseurObjet.put("type", type);
        nouveauFournisseurObjet.put("production", production);
        nouveauFournisseurObjet.put("adresse", adresse);
        JSONArray fournisseurComposantes = new JSONArray();

        nouveauFournisseurObjet.put("composantes",fournisseurComposantes);


        JSONArray listeFournisseurs = (JSONArray) baseDonneeObjet.get("Fournisseurs");
        listeFournisseurs.add(nouveauFournisseurObjet);


        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        }

    }
    public Fournisseur(){}

    public String getAdresse() {
        return this.adresse;
    }

    public String getType() {
        return this.type;
    }

    public int getCapaciteFabrication() {
        return capaciteFabrication;
    }

    public void modifierProfilFournisseur(String user, String pw, String email, String adresse, String type, boolean notifs, int capacite, int index) throws IOException, ParseException{
        this.username = user;
        this.password = pw;
        this.email = email;
        this.adresse = adresse;
        this.type = type;
        this.capaciteFabrication = capacite;
        this.notificationsEmail = notifs;

        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONArray listeFournisseurs = (JSONArray) baseDonneeObjet.get("Fournisseurs");
        JSONObject fournisseurActuel = (JSONObject) listeFournisseurs.get(index);

        fournisseurActuel.put("password", pw);
        fournisseurActuel.put("email", email);
        fournisseurActuel.put("username", user);
        fournisseurActuel.put("notificationsEmail", notifs);
        fournisseurActuel.put("type", type);
        fournisseurActuel.put("production", capacite);
        fournisseurActuel.put("adresse", adresse);

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        }



    }

    public void enregistrerComposante(String nom, String type, String description, float prix, String fournisseur, int quantite,int index) throws IOException, ParseException{

        Composante nouvelleComposante = new Composante(nom, type, description, prix, fournisseur, quantite);
        listeComposante.add(nouvelleComposante);
        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONArray listeFournisseurJson = (JSONArray) baseDonneeObjet.get("Fournisseurs");
        JSONObject fournisseurActuel = (JSONObject) listeFournisseurJson.get(index);
        JSONArray listeComposanteJson = (JSONArray) fournisseurActuel.get("composantes");

        JSONObject nouvelleComposanteJson = new JSONObject();
        nouvelleComposanteJson.put("nom" , nouvelleComposante.getNom());
        nouvelleComposanteJson.put("type" , nouvelleComposante.getType());
        nouvelleComposanteJson.put("description" , nouvelleComposante.getDesc());
        nouvelleComposanteJson.put("prix" , nouvelleComposante.getPrix());
        nouvelleComposanteJson.put("fournisseur" , nouvelleComposante.getFournisseur());
        nouvelleComposanteJson.put("quantite" , nouvelleComposante.getQuantite());

        listeComposanteJson.add(nouvelleComposanteJson);

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        }

    }

    public ArrayList<Composante> getListeComposante() {
        return this.listeComposante;
    }
    public String getListeComposanteDeepString() {
        StringBuilder sb = new StringBuilder();
        for (Composante composante : listeComposante) {
            sb.append(composante.toString()).append("\n");
        }
        return sb.toString();
    }
    public void afficherComposante() {
        int index = 1;
        System.out.println("Liste des composantes de ce fournisseur : ");
        for (Composante comp : listeComposante) {

            System.out.println("Composante " + index);
            System.out.printf("Nom : %s \nType : %s \nDescription : %s \nPrix : %f \nFournisseur : %s\n", comp.getNom(),
                    comp.getType(), comp.getDesc(), comp.getPrix(), comp.getFournisseur());
            index += 1;

        }
    }

    public void supprimerComposante(String nom, int index) throws IOException, ParseException{


        listeComposante.removeIf(comp -> Objects.equals(comp.getNom(), nom));
        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONArray listeFournisseurJson = (JSONArray) baseDonneeObjet.get("Fournisseurs");
        JSONObject fournisseurActuel = (JSONObject) listeFournisseurJson.get(index);
        JSONArray listeComposantesJson = (JSONArray) fournisseurActuel.get("composantes");
        for(int i = 0; i < listeComposantesJson.size(); i++){
            JSONObject comp = (JSONObject) listeComposantesJson.get(i);
            if(Objects.equals(comp.get("nom"), nom)){
                listeComposantesJson.remove(i);
                break;
            }
        }
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void modifierComposante(String nom, String type, String description, float prix, int index, int indexComposante) throws IOException, ParseException{


        Composante composante = listeComposante.get(indexComposante);
        composante.setNom(nom);
        composante.setType(type);
        composante.setDesc(description);
        composante.setPrix(prix);

        this.baseDonneeObjet = JSONSingleton.getInstance().parseJSONFile(FILE_PATH);
        JSONArray listeFournisseurJson = (JSONArray) baseDonneeObjet.get("Fournisseurs");
        JSONObject fournisseurActuel = (JSONObject) listeFournisseurJson.get(index);
        JSONArray listeComposanteJson = (JSONArray) fournisseurActuel.get("composantes");
        JSONObject composanteActuelle = (JSONObject) listeComposanteJson.get(indexComposante);

        composanteActuelle.put("nom" , nom);
        composanteActuelle.put("type" , type);
        composanteActuelle.put("description" , description);
        composanteActuelle.put("prix" , prix);


        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(baseDonneeObjet.toJSONString());
        }

    }

    public String getUsername() {

        return this.username;
    }

    public void setUsername(String user) {

        this.username = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String pass) {

        this.password = pass;
    }

    public String getEmail() {
        return this.email;
    }


    public void setEmail(String mail) {
        this.email = mail;
    }

    public void setCapaciteFabrication(int capaciteFabrication) {
        this.capaciteFabrication = capaciteFabrication;
    }
    public void ajouterComposanteListe(Composante composante){

        this.listeComposante.add(composante);

    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNotificationsEmail(boolean notificationsEmail) {
        this.notificationsEmail = notificationsEmail;
    }
    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }
}
