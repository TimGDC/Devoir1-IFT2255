import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Represente la partie du controlleur reponsable pour tout ce qui est rapport avec le fournisseur
 */
public class FournisseurController extends Controller{

   FournisseurView fournisseurView;
   int indexComposante;
    /**
     * Constructeur
     * @param fournisseurView la vue associe
     * @param listeUsers liste d'utilisateurs
     * @param listeFournisseurs liste de fournisseurs
     * @param listeComposantes liste de composantes
     * @param listeActivites listes d'activites
     * @param baseDonneeObjet Object pour gerer la DB
     */
   public FournisseurController(FournisseurView fournisseurView, ArrayList<User> listeUsers, ArrayList<Fournisseur> listeFournisseurs, ArrayList<Composante> listeComposantes, Activite[] listeActivites, JSONObject baseDonneeObjet){

       this.fournisseurView = fournisseurView;
       this.listeUsers = listeUsers;
       this.listeFournisseurs = listeFournisseurs;
       this.listeComposantes = listeComposantes;
       this.listeActivites = listeActivites;
       this.baseDonneeObjet = baseDonneeObjet;
   }
    /**
     * Methode pour gerer le menu du fournisseur, une fois connecter au logiciel
     * @param index l'index du fournisseur en question dans la DB
     * @throws IOException
     * @throws ParseException
     */
   public void fournisseurMenu(int index) throws IOException, ParseException{

       //JSONArray listeFournisseurJson = (JSONArray) baseDonneeObjet.get("Fournisseurs");
       //System.out.println(listeFournisseurJson.get(index));
       fournisseurView.displayMessage("Bienvenue " + listeFournisseurs.get(index).getUsername() + "!");


       int choix = fournisseurView.displayFournisseurMenu();
       switch (choix) {
           case 1:
               requetesPubliques(index);
               break;
           case 2:
               fonctionsFournisseur(index);
               break;

           case 3:
               fournisseurView.displayMessage("A la prochaine!");
               fournisseurView.closeScanner();
               break;

           default:
               fournisseurView.displayMessage("Veuillez entrer un nombre entre 1 et 2.");
       }

   }
    /**
     * Methode qui gere les fonctions disponibles au fournisseur
     * @param index l'index du fournisseur dans la DB
     * @throws IOException
     * @throws ParseException
     */
   private  void fonctionsFournisseur(int index) throws IOException, ParseException {

        int choix = fournisseurView.displayFournisseurOptions();
        switch (choix) {
            case 1:

                fournisseurView.displayMessage("Nouveau nom d'utilisateur : ");
                String util = fournisseurView.getString();

                fournisseurView.displayMessage("Nouveau mot de passe : ");
                String password =fournisseurView.getString();

                fournisseurView.displayMessage("Nouvelle adresse email : ");
                String emailadress = fournisseurView.getString();

                fournisseurView.displayMessage("Nouvelle Adresse de la companie : ");
                String adresse = fournisseurView.getString();

                fournisseurView.displayMessage("Nouveau type de composantes : ");
                String type = fournisseurView.getString();

                fournisseurView.displayMessage("Recevoir notifications par email? (true/false) : ");
                Boolean notifs = Boolean.parseBoolean(fournisseurView.getString());

                fournisseurView.displayMessage("Nouvelle quantite de production : ");
                int quantite = fournisseurView.getInt();

                listeFournisseurs.get(index).modifierProfilFournisseur(util,password,emailadress,adresse,type,notifs,quantite, index);
                fournisseurView.displayMessage("Mise a jour du compte reussie!");
                break;
            case 2:
                // Afficher composante
                listeFournisseurs.get(index).afficherComposante();
                break;
            case 3:
                // Supprimer composante
                //A VERIFIER TESTER
                fournisseurView.displayMessage("Nom de la composante a supprimer?");
                String n = fournisseurView.getString();
                listeFournisseurs.get(index).supprimerComposante(n , index);
                break;
            case 4:
                // Modifier composante
                fournisseurView.displayMessage("Nom de la composante a modifier?");
                String m = fournisseurView.getString();

                for(int i = 0 ; i< listeFournisseurs.get(index).getListeComposante().size() ; i++){

                    if(Objects.equals(listeFournisseurs.get(index).getListeComposante().get(i).getNom(), m)){
                        this.indexComposante = i;
                    }
                }

                fournisseurView.displayMessage("Nouveau nom de la composante");
                String nomComp = fournisseurView.getString();

                fournisseurView.displayMessage("Nouveau type de la composante");
                String typeComp = fournisseurView.getString();

                fournisseurView.displayMessage("Nouvelle description de la composante");
                String descComp = fournisseurView.getString();

                fournisseurView.displayMessage("Nouveau prix de la composante");
                float prixComp = fournisseurView.getFloat();

                listeFournisseurs.get(index).modifierComposante(nomComp,typeComp, descComp, prixComp, index, indexComposante);
                break;
            case 5:
                //Enregistrer composante
                fournisseurView.displayMessage("Nom de la composante");
                String nomCompE = fournisseurView.getString();
                fournisseurView.displayMessage("Type de la composante");
                String typeCompE = fournisseurView.getString();
                fournisseurView.displayMessage("Description de la composante");
                String descCompE = fournisseurView.getString();
                fournisseurView.displayMessage("Prix de la composante");
                float prixCompE = fournisseurView.getFloat();
                fournisseurView.displayMessage("Quantite a vendre de la composante");
                int quantiteCompE = fournisseurView.getInt();
                listeFournisseurs.get(index).enregistrerComposante(nomCompE, typeCompE, descCompE, prixCompE, listeFournisseurs.get(index).getUsername(),quantiteCompE, index );
                break;

            default:
                fournisseurView.displayMessage("Veuillez entrer un nombre valide");
        }endingMenuFournisseur(index);


   }
    /**
     * Methode qui gere les requetes publiques disponibles au fournisseur
     * @param index l'index du fournisseur dans la DB
     * @throws IOException
     * @throws ParseException
     */
    protected void requetesPubliques(int index) throws IOException, ParseException {

        int choix = fournisseurView.showPublicRequestMenu();
        switch (choix) {
            case 1:
                afficherListeUtilisateur();


                break;
            case 2:

                System.out.println("Veuillez entrer un nom d'utilisateur a rechercher");
                rechercherUtilisateur(fournisseurView.getString());


                break;
            case 3:

                System.out.println("Veuillez entrer un nom d'utilisateur a afficher le profil");
                afficherProfilUtilisateur(fournisseurView.getString());


                break;
            case 4:
                afficherListeActivites();

                break;
            case 5:
                afficherListeFournisseurs();

                break;
            case 6:

                System.out.println("Veuillez entrer un nom de fournisseur a afficher le profil");
                afficherProfileFournisseur(fournisseurView.getString());
                break;
            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 9.");
        }
        endingMenuFournisseur(index);


    }

    /**
     * Methode pour le menu de fin, si on veut quitter l'application ou revenir a un menu precedent
     * @param index l'index du fournisseur
     * @throws IOException
     * @throws ParseException
     */
    protected void endingMenuFournisseur(int index) throws IOException, ParseException {

        int choix = fournisseurView.showEndingScreen();

        switch (choix) {
            case 1:

                fournisseurMenu(index);
                break;

            case 2:

                fournisseurView.closeScanner();
                System.out.println("A la prochaine!");
                break;
        }

    }
}
