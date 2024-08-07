import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Represente l'affichage general (ni utilisateur ni fournisseur) de l'application
 */
public class View {

    protected Scanner scanner = new Scanner(System.in);
    /**
     * Methode pour afficher la premiere page de l'application, pour s'incrire ou se connecter
     * @return le choix du client
     */
    public int displayStart() {
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Se connecter");
        System.out.println("2 - Creer un compte");
        return getInt();
    }
    /**
     * Methode pour afficher la page de connexion
     * @param b boolean utilise comme flag
     * @return une liste avec l'email et le mot de passe du client
     */
    public List<String> displayLoginPage(boolean b) {
        if (b){
            clearInputBuffer();
        }
        System.out.print("Entrez votre adresse email : ");
        String utilisateur = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String password = scanner.nextLine();
        List<String> info = new ArrayList<>(); info.add(utilisateur); info.add(password);
        return info;
    }
    /**
     * Methode pour afficher la page d'inscription
     * @return le choix du client
     */
    public int displaySignupPage() {
        System.out.println("Creation d'un nouveau compte:");
        System.out.println("1 - Utilisateur");
        System.out.println("2 - Fournisseur");
        return getInt();

    }
    /**
     * Methode pour afficher les informations necessaires pour l'inscription
     * @return une liste des informations de l'utilisateur apres l'inscription
     */
    public List<String> getUserSignupDetails() {
        System.out.print("Nom d'utilisateur : ");
        String nom = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String pass = scanner.nextLine();

        System.out.print("Adresse email : ");
        String email = scanner.nextLine();

        System.out.print("Recevoir notifications par email? (true/false) : ");
        boolean notif = getBool();

        return Arrays.asList(nom, pass, email, String.valueOf(notif));
    }
    /**
     * Methode pour afficher les informations necessaires pour l'inscription
     * @return une liste des informations du fournisseur apres l'inscription
     */
    public List<String> getSupplierSignupDetails() {
        System.out.print("Nom d'utilisateur : ");
        String util = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        System.out.print("Adresse email : ");
        String emailadress = scanner.nextLine();

        System.out.print("Adresse de la companie : ");
        String adresse = scanner.nextLine();

        System.out.print("Type de composantes : ");
        String type = scanner.nextLine();

        System.out.print("Recevoir notifications par email? (true/false) : ");
        boolean notif = getBool();

        System.out.print("Quantite de production : ");
        int quantite = getInt();

        return Arrays.asList(util, password, emailadress, adresse, type, String.valueOf(notif), String.valueOf(quantite));
    }
    /**
     * Methode pour afficher un string (en CLI) a l'application
     * @param message le string
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
    /**
     * Methode pour ferme le scanner
     */
    public void closeScanner() {
        scanner.close();
    }
    /**
     * Methode pour afficher le menu de fin, pour quitter ou revenir a un menu precedent
     * @return le choix du client
     */
    public int showEndingScreen(){

        System.out.println("Que voulez vous faire a present?");
        System.out.println("1 - Revenir au menu precedent");
        System.out.println("2 - Quitter l'application");
        return getInt();


    }
    /**
     * Methode pour afficher le menu des requetes publiques
     * @return le choix du client
     */
    public int showPublicRequestMenu(){

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Recuperer la liste des utilisateurs");
        System.out.println("2 - Rechercher un utilisateur");
        System.out.println("3 - Voir le profil d'un utilisateur");
        System.out.println("4 - Recuperer la liste des activites");
        System.out.println("5 - Recuperer la liste des fournisseurs");
        System.out.println("6 - Voir le profil d'un fournisseur");
        return getInt();


    }
    /**
     * Methode pour recuperer un string du client
     * @return le string
     */
    public String getString(){

        return scanner.nextLine();

    }
    /**
     * Methode pour recuperer un boolean que le client input
     * @return le boolean
     */
    public boolean getBool(){

        while (!scanner.hasNextBoolean()) {
            System.out.println("Veuillez entrer True ou False");
            scanner.next();
        }

        return scanner.nextBoolean();

    }
    /**
     * Methode pour recuperer (forcement) un int que le client input
     * @return le int du client
     */
    public int getInt(){

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre entier valide");
            scanner.next();
        }

        int i = scanner.nextInt();
        scanner.nextLine();
        return i;

    }
    /**
     * Methode pour recuperer (forcement) un float que le client input
     * @return le float de l'user
     */
    public float getFloat(){

        while (!scanner.hasNextFloat()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }

        float i = scanner.nextFloat();
        scanner.nextLine();
        return i;

    }
    /**
     * Methode pour vider le scanner
     */
    public void clearInputBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Consume the remaining newline
        }
    }


}

