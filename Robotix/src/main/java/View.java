import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class View {

    protected Scanner scanner = new Scanner(System.in);

    public int displayStart() {
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Se connecter");
        System.out.println("2 - Creer un compte");
        return getInt();
    }

    public List<String> displayLoginPage() {

        System.out.print("Entrez votre nom d'utilisateur : ");
        String utilisateur = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String password = scanner.nextLine();
        List<String> info = new ArrayList<>(); info.add(utilisateur); info.add(password);
        return info;
    }

    public int displaySignupPage() {
        System.out.println("Creation d'un nouveau compte:");
        System.out.println("1 - Utilisateur");
        System.out.println("2 - Fournisseur");
        return getInt();

    }

    public List<String> getUserSignupDetails() {
        System.out.print("Nom d'utilisateur : ");
        String nom = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String pass = scanner.nextLine();

        System.out.print("Adresse email : ");
        String email = scanner.nextLine();

        System.out.print("Recevoir notifications par email? (true/false) : ");
        String notif = scanner.nextLine();

        return Arrays.asList(nom, pass, email, notif);
    }

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

        System.out.print("Quantite de production : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int quantite = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return Arrays.asList(util, password, emailadress, adresse, type, String.valueOf(quantite));
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }

    public int showEndingScreen(){

        System.out.println("Que voulez vous faire a present?");
        System.out.println("1 - Revenir au menu precedent");
        System.out.println("2 - Quitter l'application");
        return getInt();


    }

    public int showPublicRequestMenu(){

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Recuperer la liste des utilisateurs");
        System.out.println("2 - Rechercher un utilisateur");
        System.out.println("3 - Voir le profil d'un utilisateur");
        System.out.println("4 - Recuperer la liste des activites");
        System.out.println("5 - Recuperer la liste des fournisseurs");
        System.out.println("6 - Rechercher un fournisseur");
        System.out.println("7 - Voir le profil d'un fournisseur");
        System.out.println("8 - Rechercher une composante");
        return getInt();


    }

    public String getString(){

        return scanner.nextLine();

    }

    public int getInt(){

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }

        int i = scanner.nextInt();
        scanner.nextLine();
        return i;

    }


}

