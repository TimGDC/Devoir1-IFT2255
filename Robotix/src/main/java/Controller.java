import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Gere les inputs des user, met a jour les modeles (User et Fournisseur) et les views, et est responable de la logique derriere
 * l'application.
 */
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

    /**
     * Constructeur du controlleur
     * @param view la vue associee
     * @param listeUsers liste d'utilisateurs dans la base de donnees
     * @param listeFournisseurs liste de fournisseurs dans le DB
     * @param listeComposantes liste de composantes dans la DB
     * @param listeActivites liste d'activites dans la DB
     * @param baseDonneeObjet objet representant la base de donnee
     */
    public Controller(View view, ArrayList<User> listeUsers, ArrayList<Fournisseur> listeFournisseurs, ArrayList<Composante> listeComposantes, Activite[] listeActivites, JSONObject baseDonneeObjet)  {
        this.view = view;
        this.listeUsers = listeUsers;
        this.listeFournisseurs = listeFournisseurs;
        this.listeComposantes = listeComposantes;
        this.listeActivites = listeActivites;
        this.baseDonneeObjet = baseDonneeObjet;

    }
    /**
     * Constructeur de base
     */
    public Controller(){}
    /**
     * Debute l'application, en commencant par la page de "Inscrire" ou "Se Connecter"
     * @throws IOException erreur pour Input / Output
     * @throws ParseException erreur relie a JSON
     */
    public void start() throws IOException, ParseException {
        int choice = view.displayStart();
        switch (choice) {
            case 1:
                login(false);
                break;
            case 2:
                signup();
                break;
            default:
                System.out.println("Veuillez entrer soit 1 ou 2.");
                start();
        }
    }
    /**
     * Methode pour se connecter au logiciel avec son compte.
     * Inscription se fait avec un email (unique) et un mot de passe.
     * Affiche le menu Utilisateur ou Fournisseur
     * @param b boolean utilise comme flag pour ne pas afficher 2 fois le meme message
     * @throws IOException erreur Input / Output
     * @throws ParseException erreur JSON
     */
    protected void login(boolean b) throws IOException, ParseException{
        List<String> loginInfos = view.displayLoginPage(b);
        String email = loginInfos.get(0); String password = loginInfos.get(1);
        Boolean trouver = false;
        for(User user : listeUsers){

            if (Objects.equals(user.getEmail(), email) && Objects.equals(user.getPassword(), password)) {
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
                if (Objects.equals(fourn.getEmail(), email) && Objects.equals(fourn.getPassword(), password)) {
                    int index = listeFournisseurs.indexOf(fourn);

                    //SupplierMenu
                    FournisseurView fournisseurView = new FournisseurView();
                    FournisseurController fournisseurController = new FournisseurController(fournisseurView, listeUsers, listeFournisseurs, listeComposantes, listeActivites, baseDonneeObjet);
                    fournisseurController.fournisseurMenu(index);
                    trouver = true;
                    view.closeScanner();
                    break;
                }
            }
        }
        if (!trouver) {
            System.out.println("Utilisateur ou mot de pass incorrect.");
            login(b);
            view.closeScanner();

        }
    }
    /**
     * Methode pour s'inscrire en tant que nouvel utilisateur ou fournisseur
     * Si on utilise un email deja dans la DB, on ne peut pas creer un nouveau compte
     * @throws IOException erreur Input / Output
     * @throws ParseException erreur JSON
     */
    protected void signup() throws IOException, ParseException {
        int choix = view.displaySignupPage();
        switch (choix) {
            case 1:
                //AJOUTER CONDITION UTILISATEUR ET EMAIL UNIQUES
                Boolean userExists = false;
                List<String> userDetails = view.getUserSignupDetails();
                for(User user : listeUsers){
                    if(Objects.equals(user.getEmail(), userDetails.get(2))){
                        userExists = true;
                    }
                }
                for(Fournisseur fourn : listeFournisseurs){
                    if(Objects.equals(fourn.getEmail(), userDetails.get(2))){
                        userExists = true;
                    }
                }
                if(!userExists){

                    User nouvelUtilisateur = new User(userDetails.get(0), userDetails.get(1), userDetails.get(2), Boolean.parseBoolean(userDetails.get(3)));
                    listeUsers.add(nouvelUtilisateur);
                    view.displayMessage("Creation de compte reussi!");
                    login(true);
                    break;

                }else{

                    view.displayMessage("Adresse email deja utilisee!");
                    start();
                    break;
                }


            case 2:
                List<String> supplierDetails = view.getSupplierSignupDetails();
                Boolean fournExist = false;
                for(User user : listeUsers){
                    if(Objects.equals(user.getEmail(), supplierDetails.get(2))){
                        fournExist = true;
                    }
                }

                for(Fournisseur fourn : listeFournisseurs){
                    if(Objects.equals(fourn.getEmail(), supplierDetails.get(2))){
                        fournExist = true;
                    }
                }
                if(!fournExist){
                    Fournisseur nouveauFournisseur = new Fournisseur(
                            supplierDetails.get(0),
                            supplierDetails.get(1),
                            supplierDetails.get(2),
                            supplierDetails.get(3),
                            supplierDetails.get(4),
                            Boolean.parseBoolean(supplierDetails.get(5)),
                            Integer.parseInt(supplierDetails.get(6)));
                    listeFournisseurs.add(nouveauFournisseur);
                    view.displayMessage("Creation de compte reussi!");
                    login(false);
                    break;

                }
                else{

                    view.displayMessage("Adresse email deja utilisee!");
                    start();
                    break;

                }


            default:
                view.displayMessage("Veuillez entrer 1 ou 2.");
                signup(); // Restart signup process on invalid choice
        }
    }



    /**
     * Afficher la liste des utilisateurs dans la base de donnees
     */
    protected void afficherListeUtilisateur(){
        System.out.println("Liste d'utilisateurs : ");
        for(User user : listeUsers){
            System.out.println(user.getUsername());
        }
    }
    /**
     * Methode pour rechercher un user
     * @param nom le nom d'utilisateur recherche
     * @return un boolean si l'utilisateur existe ou non
     */
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
    /**
     * Methode pour afficher le profil d'un utlisateur, avec toutes ces informations (publiques)
     * @param nom le nom du user a afficher le profil
     */
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
    /**
     * Methode pour afficher la liste d'activites disponibles
     */
    protected void afficherListeActivites(){
        System.out.println("Liste de toutes les activites");
        for(Activite act : listeActivites){
            System.out.println(act.getNom());
        }
    }

    /**
     * Methode pour afficher la liste des fournisseurs dans le DB
     */
    protected void afficherListeFournisseurs(){
        System.out.println("Liste de tous les fournisseurs");
        for(Fournisseur fourn : listeFournisseurs){
            System.out.println(fourn.getUsername());
        }
    }
    /**
     * Methode pour afficher le profile d'un fournisseur
     * @param nom le nom du fournisseur recherche
     */
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

}
