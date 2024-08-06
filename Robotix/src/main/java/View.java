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

    public List<String> displayLoginPage(boolean b) {
        if (b){
            clearInputBuffer();
        }
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
        boolean notif = getBool();

        return Arrays.asList(nom, pass, email, String.valueOf(notif));
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

        System.out.print("Recevoir notifications par email? (true/false) : ");
        boolean notif = getBool();

        System.out.print("Quantite de production : ");
        int quantite = getInt();

        return Arrays.asList(util, password, emailadress, adresse, type, String.valueOf(notif), String.valueOf(quantite));
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
        System.out.println("6 - Voir le profil d'un fournisseur");
        return getInt();


    }

    public String getString(){

        return scanner.nextLine();

    }

    public boolean getBool(){

        while (!scanner.hasNextBoolean()) {
            System.out.println("Veuillez entrer True ou False");
            scanner.next();
        }

        return scanner.nextBoolean();

    }

    public int getInt(){

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre entier valide");
            scanner.next();
        }

        int i = scanner.nextInt();
        scanner.nextLine();
        return i;

    }

    public float getFloat(){

        while (!scanner.hasNextFloat()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }

        float i = scanner.nextFloat();
        scanner.nextLine();
        return i;

    }

    public void clearInputBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Consume the remaining newline
        }
    }


}

