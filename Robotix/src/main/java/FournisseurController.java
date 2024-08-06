import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class FournisseurController extends Controller{

   FournisseurView fournisseurView;
   int indexComposante;
   public FournisseurController(FournisseurView fournisseurView, ArrayList<User> listeUsers, ArrayList<Fournisseur> listeFournisseurs, ArrayList<Composante> listeComposantes, Activite[] listeActivites, JSONObject baseDonneeObjet){

       this.fournisseurView = fournisseurView;
       this.listeUsers = listeUsers;
       this.listeFournisseurs = listeFournisseurs;
       this.listeComposantes = listeComposantes;
       this.listeActivites = listeActivites;
       this.baseDonneeObjet = baseDonneeObjet;
   }

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
               fournisseurView.closeScanner();
               fournisseurView.displayMessage("A la prochaine!");
               break;

           default:
               fournisseurView.displayMessage("Veuillez entrer un nombre entre 1 et 2.");
       }

   }

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

                fournisseurView.displayMessage("Nouvelle quantite de production : ");
                int quantite = fournisseurView.getInt();

                fournisseurView.displayMessage("Recevoir notifications par email? (true/false) : ");
                boolean notifs = Boolean.parseBoolean(fournisseurView.getString());

                listeFournisseurs.get(index).modifierProfilFournisseur(util,password,emailadress,adresse,type,notifs,quantite, index);
                fournisseurView.displayMessage("Mise a jour du compte reussie!");
                endingMenuFournisseur(index);
                break;
            case 2:

                gererComposantes(index);
                endingMenuFournisseur(index);
                break;

            case 3:
                fournisseurView.displayMessage("Nom de la composante");
                String nomComp = fournisseurView.getString();
                fournisseurView.displayMessage("Type de la composante");
                String typeComp = fournisseurView.getString();
                fournisseurView.displayMessage("Description de la composante");
                String descComp = fournisseurView.getString();
                fournisseurView.displayMessage("Prix de la composante");
                int prixComp = fournisseurView.getInt();

                listeFournisseurs.get(index).enregistrerComposante(nomComp, typeComp, descComp, prixComp, listeFournisseurs.get(index).getUsername(), index);
                endingMenuFournisseur(index);
                break;

            default:
                fournisseurView.displayMessage("Veuillez entrer un nombre entre 1 et 9.");
        }

    }
    public void gererComposantes(int index) throws IOException, ParseException {


        int choixComposante = fournisseurView.displayComposanteOptions();
        switch (choixComposante){
            case 1:
                listeFournisseurs.get(index).afficherComposante();
                endingMenuFournisseur(index);
                break;
            case 2:
                //A VERIFIER TESTER
                fournisseurView.displayMessage("Nom de la composante a supprimer?");
                String n = fournisseurView.getString();
                listeFournisseurs.get(index).supprimerComposante(n , index);
                endingMenuFournisseur(index);
                break;
            case 3:
                //Mettre a jour nom a supprimer

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
                int prixComp = fournisseurView.getInt();

                listeFournisseurs.get(index).modifierComposante(nomComp,typeComp, descComp, prixComp, index, indexComposante);
                endingMenuFournisseur(index);
                break;

        }


    }
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

                System.out.println("Veuillez entrer un nom de fournisseur a rechercher");
                chercherFournisseur(fournisseurView.getString());


                break;
            case 7:

                System.out.println("Veuillez entrer un nom de fournisseur a afficher le profil");
                afficherProfileFournisseur(fournisseurView.getString());


                break;
            case 8:

                System.out.println("Veuillez entrer un nom, type ou nom de fournisseur d'une composante");
                chercherComposante(fournisseurView.getString(), 0);


                break;
            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 9.");
        }
        endingMenuFournisseur(index);


    }
    protected void endingMenuFournisseur(int index) throws IOException, ParseException {

        int choix = fournisseurView.showEndingScreen();

        switch (choix) {
            case 1:

                fournisseurMenu(index);
                break;

            case 2:


                System.out.println("A la prochaine!");
                fournisseurView.closeScanner();
                break;


        }

    }
}
