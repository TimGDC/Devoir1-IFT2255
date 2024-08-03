import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Robot {
    private String nom;
    private int numeroSerie;
    private int consommationCPU;
    private int consommationMemoire;
    private int batterie;
    private int vitesse;
    private int[] position = {0,0,0};
    private Object obj;
    private JSONObject baseDonneeObjet;

    public Robot(String nom, int numeroSerie, int jsonIndex) throws IOException, ParseException {

        this.nom = nom;
        this.numeroSerie = numeroSerie;
        initializationRobot();
        this.obj = new JSONParser().parse(new FileReader("src/main/java/BaseDonnee.json"));
        this.baseDonneeObjet = (JSONObject) obj;

        JSONArray listeUser = (JSONArray) baseDonneeObjet.get("Users");
        JSONObject userActuel = (JSONObject) listeUser.get(jsonIndex);
        JSONArray listeRobotsUser = (JSONArray) userActuel.get("robots");

        JSONObject nouveauRobotJson = new JSONObject();
        nouveauRobotJson.put("nom" , this.nom);
        nouveauRobotJson.put("numeroSerie" , this.numeroSerie);
        nouveauRobotJson.put("consommationCPU" , this.consommationCPU);
        nouveauRobotJson.put("consommationMemoire" , this.consommationMemoire);
        nouveauRobotJson.put("batterie" , this.batterie);
        nouveauRobotJson.put("vitesse" , this.vitesse);

        JSONArray positionJson = new JSONArray();
        positionJson.add(0, this.position[0]);
        positionJson.add(1, this.position[1]);
        positionJson.add(2, this.position[2]);

        nouveauRobotJson.put("position", positionJson);

        listeRobotsUser.add(nouveauRobotJson);
        try (FileWriter file = new FileWriter("src/main/java/BaseDonnee.json")) {
            file.write(baseDonneeObjet.toJSONString());
        }


    }

    private void initializationRobot() {

        Random random = new Random();
        this.batterie = random.nextInt(100) + 1;
        this.consommationCPU = random.nextInt(100) + 1;
        this.consommationMemoire = random.nextInt(100) + 1;
        this.batterie = random.nextInt(10) + 1;
        position[0] = random.nextInt(1000) + 1;
        position[1] = random.nextInt(1000) + 1;
        position[2] = random.nextInt(1000) + 1;

    }

    public int getNumeroSerie(){

        return this.numeroSerie;
    }
    public int getConsommationCPU(){

        return this.consommationCPU;
    }

    public int getConsommationMemoire(){

        return this.consommationMemoire;
    }
    public int getBatterie(){

        return this.batterie;
    }
    public int getVitesse(){

        return this.vitesse;
    }
    public String getNom(){

        return this.nom;
    }

    public void setNom(String nouveauNom){

        this.nom = nouveauNom;
    }
    public void setConsommationCPU(int nouvelleConsommation){

        this.consommationCPU = nouvelleConsommation;
    }

    public void setConsommationMemoire(int nouvelleConsommation){

        this.consommationMemoire = nouvelleConsommation;
    }
    public void setBatterie(int nouvelleBatterie){

        this.batterie = nouvelleBatterie;
    }
    public void setVitesse(int nouvelleVitesse){

        this.vitesse = nouvelleVitesse;
    }
    public void setNumeroSerie(int nouveauNumero){

        this.numeroSerie = nouveauNumero;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}

