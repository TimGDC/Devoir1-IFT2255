import java.util.ArrayList;
import java.util.Random;

public class Robot {
    private String nom;
    private int numeroSerie;
    private int consommation;
    private int batterie;
    private int vitesse;
    private int[] position = {0,0,0};

    public Robot(String nom, int numeroSerie){

        this.nom = nom;
        this.numeroSerie = numeroSerie;
        initializationRobot();
    }

    private void initializationRobot() {

        Random random = new Random();
        this.batterie = random.nextInt(100) + 1;
        this.consommation = random.nextInt(100) + 1;
        this.batterie = random.nextInt(10) + 1;
        position[0] = random.nextInt(1000) + 1;
        position[1] = random.nextInt(1000) + 1;
        position[2] = random.nextInt(1000) + 1;

    }

    public int getNumeroSerie(){

        return this.numeroSerie;
    }
    public int getConsommation(){

        return this.consommation;
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
    public void setConsommation(int nouvelleConsommation){

        this.consommation = nouvelleConsommation;
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

