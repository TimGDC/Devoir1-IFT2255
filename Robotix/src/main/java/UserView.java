import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Objects;

public class UserView extends View{

    public int displayUserMenu(){

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Requetes publiques");
        System.out.println("2 - Fonctionalites pour utilisateurs");
        System.out.println("3 - Quitter l'application");
        return getInt();
    }

    public int displayUserOptions(){
        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Modifier son profil");
        System.out.println("2 - Gerer ses robots");
        System.out.println("3 - Gerer ses activites");
        System.out.println("4 - Voir l'etat de mes robots");
        System.out.println("5 - Voir ses notifications");
        System.out.println("6 - Acheter une composante");
        System.out.println("7 - Trouver une composante");
        System.out.println("8 - Trouver un fournisseur");
        return getInt();

    }

    public int displayRobotOptions(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher ses robots");
        System.out.println("2 - Enregistrer un robots");
        System.out.println("3 - Supprimer un robots");
        return getInt();

    }

    public int displayActivityOptions(){

        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher activites");
        System.out.println("2 - Supprimer activites");
        System.out.println("3 - Ajouter activites");
        return getInt();

    }

    public int displayRobotStatus(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher vue generale");
        System.out.println("2 - Afficher vue complete");
        return getInt();

    }

    public int displaySearchingOptions(){
        System.out.println("1 - Afficher la fiche presentant toutes les informations");
        System.out.println("2 - Revenir au menu precedent");
        System.out.println("3 - Quitter l'application");
        return getInt();
    }
}
