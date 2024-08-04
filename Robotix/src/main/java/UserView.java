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

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }

    public int displayUserOptions(){
        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Modifier son profil");
        System.out.println("2 - Gerer sa flotte");
        System.out.println("3 - Gerer ses activites");
        System.out.println("4 - Voir l'etat de mes robots");
        System.out.println("5 - Voir ses notifications");
        System.out.println("6 - Acheter une composante");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;


    }

    public int displayRobotOptions(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher ses robots");
        System.out.println("2 - Enregistrer un robots");
        System.out.println("3 - Supprimer un robots");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public int displayActivityOptions(){

        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher activites");
        System.out.println("2 - Supprimer activites");
        System.out.println("3 - Ajouter activites");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }

    public int displayRobotStatus(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Afficher vue generale");
        System.out.println("2 - Afficher vue complete");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }
}
