import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Controller {

    protected View view;
    protected ArrayList<User> listeUsers;
    protected ArrayList<Fournisseur> listeFournisseurs;
    protected ArrayList<Composante> listeComposantes;
    protected Activite[] listeActivites;

    //Base donnee
    protected final String baseDonneePath = "src/main/java/BaseDonnee.json";
    protected Object obj;
    protected JSONObject baseDonneeObjet;
    protected int jsonIndex;

    public Controller(View view, ArrayList<User> listeUsers, ArrayList<Fournisseur> listeFournisseurs, ArrayList<Composante> listeComposantes, Activite[] listeActivites, JSONObject baseDonneeObjet)  {
        this.view = view;
        this.listeUsers = listeUsers;
        this.listeFournisseurs = listeFournisseurs;
        this.listeComposantes = listeComposantes;
        this.listeActivites = listeActivites;
        this.baseDonneeObjet = baseDonneeObjet;

    }
    public Controller(){}

    public void start() throws IOException, ParseException {
        int choice = view.displayStart();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                signup();
                break;
            default:
                System.out.println("Veuillez entrer soit 1 ou 2.");
                start();
        }
    }

    protected void login() throws IOException, ParseException{
        List<String> loginInfos = view.displayLoginPage();
        String utilisateur = loginInfos.get(0); String password = loginInfos.get(1);
        Boolean trouver = false;
        for(User user : listeUsers){

            if (Objects.equals(user.getUsername(), utilisateur) && Objects.equals(user.getPassword(), password)) {
                int index = listeUsers.indexOf(user);

                // UserMenu
                UserView userView = new UserView();
                UserController userController = new UserController(userView, listeUsers, listeFournisseurs, listeComposantes, listeActivites, baseDonneeObjet);
                userController.userMenu(index);
                trouver = true;
                view.closeScanner();
                break;
            }
        }
        if(!trouver) {
            for (Fournisseur fourn : listeFournisseurs) {
                if (Objects.equals(fourn.getUsername(), utilisateur) && Objects.equals(fourn.getPassword(), password)) {
                    int index = listeFournisseurs.indexOf(fourn);

                    //SupplierMenu
                    FournisseurView fournisseurView = new FournisseurView();
                    FournisseurController fournisseurController = new FournisseurController(fournisseurView, listeUsers, listeFournisseurs, listeComposantes, listeActivites, baseDonneeObjet);
                    fournisseurController.fournisseurMenu(index);
                    trouver = true;
                    view.closeScanner();
                }
            }
        }
        if (!trouver) {
            System.out.println("Utilisateur ou mot de pass incorrect.");
            login();
            view.closeScanner();
        }
    }

    protected void signup() throws IOException, ParseException {
        int choix = view.displaySignupPage();
        switch (choix) {
            case 1:
                List<String> userDetails = view.getUserSignupDetails();
                User nouvelUtilisateur = new User(userDetails.get(0), userDetails.get(1), userDetails.get(2));
                listeUsers.add(nouvelUtilisateur);
                view.displayMessage("Creation de compte reussi!");
                login(); // Redirect to login after successful signup
                break;

            case 2:
                List<String> supplierDetails = view.getSupplierSignupDetails();
                Fournisseur nouveauFournisseur = new Fournisseur(
                        supplierDetails.get(0),
                        supplierDetails.get(1),
                        supplierDetails.get(2),
                        supplierDetails.get(3),
                        supplierDetails.get(4),
                        Integer.parseInt(supplierDetails.get(5))
                );
                listeFournisseurs.add(nouveauFournisseur);
                view.displayMessage("Creation de compte reussi!");
                login(); // Redirect to login after successful signup
                break;

            default:
                view.displayMessage("Veuillez entrer 1 ou 2.");
                signup(); // Restart signup process on invalid choice
        }
    }




    protected void afficherListeUtilisateur(){
        System.out.println("Liste d'utilisateurs : ");
        for(User user : listeUsers){
            System.out.println(user.getUsername());
        }
    }
    protected boolean rechercherUtilisateur(String nom){
        boolean bool = false;
        for(User user : listeUsers) {
            if (Objects.equals(user.getUsername(), nom)) {
                bool=true;
                break;
            }
        }
        return bool;
    }
    protected void afficherProfilUtilisateur(String nom){
        for(User user : listeUsers){
            if(Objects.equals(user.getUsername(), nom)){
                System.out.println("Voici le profil de l'utilisateur " + user.getUsername());
                System.out.println("Email : " + user.getEmail());
                user.afficherListeRobots();
                user.afficherActivites();
            }

        }

    }

    protected void afficherListeActivites(){
        System.out.println("Liste de toutes les activites");
        for(Activite act : listeActivites){
            System.out.println(act.getNom());
        }
    }


    protected void afficherListeFournisseurs(){
        System.out.println("Liste de tous les fournisseurs");
        for(Fournisseur fourn : listeFournisseurs){
            System.out.println(fourn.getUsername());
        }
    }

    protected boolean chercherFournisseur(String recherche){
        String mot = recherche;
        boolean bool = false;
        for(Fournisseur fourn : listeFournisseurs){
            if(Objects.equals(mot, fourn.getAdresse()) || Objects.equals(mot, fourn.getType()) || Objects.equals(mot, fourn.getUsername())){
                System.out.println("Le fournisseur " + fourn.getUsername() + " existe sur cette platforme!");
                bool=true;
            }
        }
        return bool;
    }
    protected void afficherProfileFournisseur(String nom){

        for(Fournisseur fourn : listeFournisseurs){
            if(Objects.equals(fourn.getUsername(), nom)) {
                System.out.println("Voici le profil du fournisseur " + fourn.getUsername());
                System.out.println("Email : " + fourn.getAdresse());
                System.out.println("Capacite production : " + fourn.getCapaciteFabrication());
                fourn.afficherComposante();

            }
        }

    }

    protected boolean chercherComposante(String recherche){
        String mot = recherche;
        boolean bool = false;
        for(Composante comp : listeComposantes){
            if(Objects.equals(mot, comp.getNom()) || Objects.equals(mot, comp.getType()) || Objects.equals(mot, comp.getFournisseur())){
                System.out.println("La composante " + comp.getNom() + " est disponible sur cette platforme, vendue par " + comp.getFournisseur() +
                        " pour un prix de " + comp.getPrix() + "$");
                bool=true;
            }
        }
        return bool;
    }
}
