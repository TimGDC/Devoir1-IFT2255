import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Objects;
/**
 * Represente tout l'affichage en rapport avec l'utilisateur
 */
public class UserView extends View{
    /**
     * Methode pour afficher le menu initial de l'utilisateur
     * @return le choix de l'utilisateur pour aller a la prochaine page
     */
    public int displayUserMenu(){

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Requetes publiques");
        System.out.println("2 - Fonctionalites pour utilisateurs");
        System.out.println("3 - Quitter l'application");
        return getInt();
    }
    /**
     * Methode pour afficher le menu des fonctionnalites de l'utilisateur
     * @return le choix de l'utilisateur pour aller a la prochaine page
     */
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
    /**
     * Methode pour afficher le menu pour gerer les robots de l'utilisateur
     * @return le choix de l'utilisateur pour aller a la prochaine page
     */
    public int displayRobotOptions(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher ses robots");
        System.out.println("2 - Enregistrer un robots");
        System.out.println("3 - Supprimer un robots");
        return getInt();

    }
    /**
     * Methode pour afficher le menu d'activite de l'utilisateur
     * @return le choix de l'utilisateur pour aller a la prochaine page
     */
    public int displayActivityOptions(){

        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher activites");
        System.out.println("2 - Supprimer activites");
        System.out.println("3 - Ajouter activites");
        return getInt();

    }
    /**
     * Methode pour afficher soit la vue generale, soit la vue complete des etats des robots
     * @return le choix de l'utilisateur pour aller a la prochaine page
     */
    public int displayRobotStatus(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher vue generale");
        System.out.println("2 - Afficher vue complete");
        return getInt();

    }
    /**
     * Methode pour afficher les choix lors de la recherche d'une composante ou d'un fournisseur
     * @return le choix de l'utilisateur pour aller a la prochaine page
     */
    public int displaySearchingOptions(){
        System.out.println("1 - Afficher la fiche presentant toutes les informations");
        System.out.println("2 - Revenir au menu precedent");
        System.out.println("3 - Quitter l'application");
        return getInt();
    }
}
