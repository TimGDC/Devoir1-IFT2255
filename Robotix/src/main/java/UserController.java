import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class UserController extends Controller{


    UserView userView;
    public UserController(UserView userView, ArrayList<User> listeUsers, ArrayList<Fournisseur> listeFournisseurs, ArrayList<Composante> listeComposantes, Activite[] listeActivites, JSONObject baseDonneeObjet){
        this.userView = userView;
        this.listeUsers = listeUsers;
        this.listeFournisseurs = listeFournisseurs;
        this.listeComposantes = listeComposantes;
        this.listeActivites = listeActivites;
        this.baseDonneeObjet = baseDonneeObjet;

    }

    public void userMenu(int index) throws IOException, ParseException {

        JSONArray listeUtilisateursJson = (JSONArray) baseDonneeObjet.get("Users");

        //System.out.println(listeUtilisateursJson.get(index));
        userView.displayMessage("Bienvenue " + listeUsers.get(index).getUsername() + "!");

        int choix = userView.displayUserMenu();
        switch (choix) {
            case 1:
                requetesPubliques(index);
                break;
            case 2:
                fonctionsUtilisateur(index);
                break;
            case 3:
                userView.closeScanner();
                userView.displayMessage("A la prochaine!");
                break;

            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 3.");
        }


    }
    private void fonctionsUtilisateur(int index) throws IOException, ParseException {


        int choix = userView.displayUserOptions();
        switch (choix) {
            case 1:

                userView.displayMessage("Nouveau nom d'utilisateur : ");
                String nom = userView.getString();
                userView.displayMessage("Nouveau password : ");
                String passwd = userView.getString();
                userView.displayMessage("Nouveau email : ");
                String mail = userView.getString();
                userView.displayMessage("Recevoir notifications par email? (true/false) : ");
                Boolean notifs = Boolean.parseBoolean(userView.getString());

                listeUsers.get(index).modifierProfil(nom, passwd, mail, notifs, index);
                endingMenuUser(index);

                break;
            case 2:

                int choice = userView.displayRobotOptions();
                switch(choice){
                    case 1: listeUsers.get(index).afficherListeRobots();
                        endingMenuUser(index);
                        break;
                    case 2:

                        userView.displayMessage("Numero de serie");
                        int numSerie = userView.getInt();
                        userView.displayMessage("Nom");
                        String nomRobot = userView.getString();
                        listeUsers.get(index).enregistrerRobot(numSerie, nomRobot, index);
                        endingMenuUser(index);
                        break;
                    case 3:

                        userView.displayMessage("Nom du robot a supprimer");
                        String nomRob = userView.getString();
                        listeUsers.get(index).supprimerRobot(nomRob, index);
                        endingMenuUser(index);
                        break;
                    default:
                        userView.displayMessage("Veuillez entrer un nombre entre 1 et 3.");
                        break;
                }
                break;


            case 3:


                int choix1 = userView.displayActivityOptions();
                switch(choix1) {
                    case 1:
                        listeUsers.get(index).afficherActivites();
                        endingMenuUser(index);
                        break;
                    case 2:

                        userView.displayMessage("Nom de l'activite a supprimer");
                        String nomActivite = userView.getString();
                        listeUsers.get(index).getActivites().remove(nomActivite);
                        for(int i = 0 ; i< listeActivites.length ; i++){
                            if(Objects.equals(listeActivites[i].getNom(), nomActivite)){
                                listeUsers.get(index).supprimerActivite(listeActivites[i], index);
                                userView.displayMessage("Activite Supprimee!");
                                break;
                            }

                        }
                        System.out.println(baseDonneeObjet);
                        endingMenuUser(index);

                        break;
                    case 3:
                        userView.displayMessage("Nom de l'activite a ajouter");
                        String nomA = userView.getString();
                        listeUsers.get(index).getActivites().add(nomA);

                        for(int i = 0 ; i< listeActivites.length ; i++){
                            if(Objects.equals(listeActivites[i].getNom(), nomA)){
                                listeUsers.get(index).ajouterActivite(listeActivites[i], index);
                                userView.displayMessage("Activite ajoutee!");
                                break;
                            }

                        }
                        System.out.println(baseDonneeObjet);
                        endingMenuUser(index);
                        break;
                    default:
                        userView.displayMessage("Veuillez entrer un nombre entre 1 et 3.");

                }

            case 4:




                int choixVue = userView.displayRobotStatus();
                switch(choixVue) {
                    case 1:
                        listeUsers.get(index).afficherEtats(0);
                        break;
                    case 2:
                        listeUsers.get(index).afficherEtats(1);
                        break;

                    default:
                        userView.displayMessage("Veuillez entrer un nombre entre 1 et 2.");

                }

                endingMenuUser(index);
                break;

            case 5:

                listeUsers.get(index).afficherNotifications();
                endingMenuUser(index);
                break;
            case 6:

                //Acheter composante
                break;
            default:
                userView.displayMessage("Veuillez entrer un nombre entre 1 et 6.");
        }

    }
    protected void requetesPubliques(int index) throws IOException, ParseException {



        int choix = userView.showPublicRequestMenu();
        switch (choix) {
            case 1:
                afficherListeUtilisateur();


                break;
            case 2:

                System.out.println("Veuillez entrer un nom d'utilisateur a rechercher");
                rechercherUtilisateur(userView.getString());


                break;
            case 3:

                System.out.println("Veuillez entrer un nom d'utilisateur a afficher le profil");
                afficherProfilUtilisateur(userView.getString());


                break;
            case 4:
                afficherListeActivites();

                break;
            case 5:
                afficherListeFournisseurs();

                break;
            case 6:

                System.out.println("Veuillez entrer un nom de fournisseur a rechercher");
                chercherFournisseur(userView.getString());


                break;
            case 7:

                System.out.println("Veuillez entrer un nom de fournisseur a afficher le profil");
                afficherProfileFournisseur(userView.getString());


                break;
            case 8:

                //TODO
                int opt = userView.displayComposanteSearchOptions();
                System.out.println("Veuillez entrer un nom, type ou nom de fournisseur d'une composante");
                switch(opt){
                    case 0:

                }


                break;
            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 9.");
        }
        endingMenuUser(index);


    }
    protected void endingMenuUser(int index) throws IOException, ParseException {

        int choix = userView.showEndingScreen();

        switch (choix) {
            case 1:

                userMenu(index);
                break;

            case 2:

                userView.closeScanner();
                System.out.println("A la prochaine!");
                break;


        }

    }

}
