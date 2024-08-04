import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class FournisseurController extends Controller{

   FournisseurView fournisseurView;

   public FournisseurController(FournisseurView fournisseurView, ArrayList<User> listeUsers, ArrayList<Fournisseur> listeFournisseurs, ArrayList<Composante> listeComposantes, Activite[] listeActivites, JSONObject baseDonneeObjet){

       this.fournisseurView = fournisseurView;
       this.listeUsers = listeUsers;
       this.listeFournisseurs = listeFournisseurs;
       this.listeComposantes = listeComposantes;
       this.listeActivites = listeActivites;
       this.baseDonneeObjet = baseDonneeObjet;
   }

   public void fournisseurMenu(int index) throws IOException, ParseException{

       JSONArray listeFournisseurJson = (JSONArray) baseDonneeObjet.get("Fournisseurs");
       for(int i=0 ; i<listeFournisseurJson.size(); i++){
           JSONObject fournisseurActuel = (JSONObject) listeFournisseurJson.get(i);
           if(fournisseurActuel.get("username") == listeFournisseurs.get(index).getUsername()){
               this.jsonIndex = i;
           }
       }
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

                fournisseurView.displayMessage("Nouvelle adresse email");
                String emailadress = fournisseurView.getString();

                fournisseurView.displayMessage("Nouvelle Adresse de la companie");
                String adresse = fournisseurView.getString();

                fournisseurView.displayMessage("Nouveau type de composantes");
                String type = fournisseurView.getString();

                fournisseurView.displayMessage("Nouvelle quantite de production");
                int quantite = fournisseurView.getInt();

                listeFournisseurs.get(index).modifierProfilFournisseur(util,password,emailadress,adresse,type,quantite);
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

                listeFournisseurs.get(index).enregistrerComposante(nomComp, typeComp, descComp, prixComp, listeFournisseurs.get(index).getUsername());
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
                //Mettre a jour nom a supprimer
                fournisseurView.displayMessage("Index de la composante a supprimer?");
                int i = fournisseurView.getInt();
                listeFournisseurs.get(index).supprimerComposante(i);
                endingMenuFournisseur(index);
                break;
            case 3:
                //Mettre a jour nom a supprimer
                fournisseurView.displayMessage("Index de la composante a modifier?");
                int j = fournisseurView.getInt();

                fournisseurView.displayMessage("Nom de la composante");
                String nomComp = fournisseurView.getString();

                fournisseurView.displayMessage("Type de la composante");
                String typeComp = fournisseurView.getString();

                fournisseurView.displayMessage("Description de la composante");
                String descComp = fournisseurView.getString();

                fournisseurView.displayMessage("Prix de la composante");
                int prixComp = fournisseurView.getInt();

                listeFournisseurs.get(index).modifierComposante(j,nomComp,typeComp, descComp, prixComp);
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
                chercherComposante(fournisseurView.getString());


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
