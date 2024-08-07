import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

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
                        endingMenuUser(index);

                        break;
                    case 3:
                        userView.displayMessage("Nom de l'activite a ajouter");
                        String nomA = userView.getString();

                        for(int i = 0 ; i< listeActivites.length ; i++){
                            if(Objects.equals(listeActivites[i].getNom(), nomA)){
                                listeUsers.get(index).getActivites().add(listeActivites[i]);
                                listeUsers.get(index).ajouterActivite(listeActivites[i], index);
                                userView.displayMessage("Activite ajoutee!");
                                break;
                            }

                        }
                        endingMenuUser(index);
                        break;
                    default:
                        userView.displayMessage("Veuillez entrer un nombre entre 1 et 3.");

                }break;

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
                userView.displayMessage("Entrez le nom de la composante a acheter : ");
                String nomComposante = userView.getString();
                String fournisseurComposante = "";
                boolean compExiste = false;
                int fournisseurIndex = 0;
                int composanteIndex = 0;

                //Trouve le fournisseur de la composante
                for(Composante comp : listeComposantes){
                    if(Objects.equals(comp.getNom(), nomComposante)){
                        fournisseurComposante = comp.getFournisseur();
                        compExiste = true;

                    }
                }
                for(int i = 0 ; i < listeFournisseurs.size() ; i++){
                    if(Objects.equals(fournisseurComposante, listeFournisseurs.get(i).getUsername())){
                        fournisseurIndex = i;
                    }
                }

                //Cherche index de la composante dans la liste de composante de X fournisseur
                Fournisseur fournisseurActuel = listeFournisseurs.get(fournisseurIndex);
                for(int j = 0 ; j< fournisseurActuel.getListeComposante().size() ; j++){

                    if(Objects.equals(nomComposante, fournisseurActuel.getListeComposante().get(j).getNom())){
                        composanteIndex = j;
                    }
                }

                if(compExiste){

                    userView.displayMessage("Entrez la quantitee a acheter de cette composante : ");
                    int qttComp = userView.getInt();

                    if(qttComp <= listeFournisseurs.get(fournisseurIndex).getListeComposante().get(composanteIndex).getQuantite()){
                        //MODIFIER INVENTAIRE + NOTIF FOURNISSEUR
                        listeUsers.get(index).acheterComposante(listeFournisseurs, fournisseurIndex, qttComp, composanteIndex);
                        userView.displayMessage("Achat de composante effectue!");
                        endingMenuUser(index);

                    }else{
                        userView.displayMessage("Le fournisseur n'a pas assez de stock!");
                        endingMenuUser(index);

                    }

                }else{
                    userView.displayMessage("Cette composante n'existe pas!");
                    endingMenuUser(index);

                }

                break;

            case 7:
                // Trouver composante
                userView.displayMessage("Veuillez entrer le nom, le type, ou le fournisseur de la composante.");
                ArrayList<Composante> composantes = chercherComposante(userView.getString());
                if (composantes.isEmpty()) {
                    userView.displayMessage("La composante recherchee n'existe pas");
                    endingMenuUser(index);}
                else{
                    System.out.println("Resultats recherche");
                    for (Composante composante : composantes) {
                        System.out.println("Nom: " + composante.getNom() + "    " + "Type: " + composante.getType());
                    }
                    int choix3 = userView.displaySearchingOptions();
                    switch(choix3){
                        case 1:
                            for (Composante composante : composantes) {
                                System.out.println("Nom: "+composante.getNom());
                                System.out.println("Type: "+composante.getType());
                                System.out.println("Description: "+composante.getDesc());
                                System.out.println("Fournisseur: "+composante.getFournisseur());
                                System.out.println("Prix: "+composante.getPrix());
                                System.out.println("--------------------------------------------------------------");
                            }
                            endingMenuUser(index);
                            break;
                        case 2:
                            userMenu(index);
                            break;
                        case 3:
                            userView.closeScanner();
                            System.out.println("A la prochaine!");
                            break;
                    }}break;
            case 8:
                // Trouver fournisseur
                System.out.println("Veuillez entrer le nom, type ou adresse du fournisseur.");
                ArrayList<Fournisseur> fournisseurs = chercherFournisseur(userView.getString());
                if (fournisseurs.isEmpty()) {
                    System.out.println("Le fournisseur recherche n'existe pas");
                    endingMenuUser(index);}
                else{
                    System.out.println("Resultats recherche");
                    for (Fournisseur fournisseur : fournisseurs) {
                        System.out.println("Nom: " + fournisseur.getUsername() + "    " + "Type: " + fournisseur.getType());
                    }
                    int choix2 = userView.displaySearchingOptions();
                    switch(choix2){
                        case 1:
                            for (Fournisseur fournisseur : fournisseurs) {
                                System.out.println("Nom: "+fournisseur.getUsername());
                                System.out.println("Type: "+fournisseur.getType());
                                System.out.println("Adresse: "+fournisseur.getAdresse());
                                System.out.println("Email: "+fournisseur.getEmail());
                                System.out.println("Capacite Fabrication: "+fournisseur.getCapaciteFabrication());
                                System.out.println("Composantes: ");System.out.println(fournisseur.getListeComposanteDeepString());
                                System.out.println("--------------------------------------------------------------");
                            }
                            endingMenuUser(index);
                            break;
                        case 2:
                            userMenu(index);
                            break;
                        case 3:
                            userView.closeScanner();
                            System.out.println("A la prochaine!");
                            break;
                    }}break;
            default:
                userView.displayMessage("Veuillez entrer un nombre entre 1 et 8.");
        }
    }

    protected ArrayList<Composante> chercherComposante(String recherche) {
        ArrayList<Composante> composantes = new ArrayList<>();
        for(Composante comp : listeComposantes){
            if(Objects.equals(recherche, comp.getNom()) || Objects.equals(recherche, comp.getType()) || Objects.equals(recherche, comp.getFournisseur())) {
                composantes.add(comp);
            }
        }
        return composantes;
    }

    protected ArrayList<Fournisseur> chercherFournisseur(String recherche) {
        ArrayList<Fournisseur> fourns = new ArrayList<>();
        for(Fournisseur fourn : listeFournisseurs) {
            if (Objects.equals(recherche, fourn.getAdresse()) || Objects.equals(recherche, fourn.getType()) || Objects.equals(recherche, fourn.getUsername())) {
                fourns.add(fourn);
            }
        }
        return fourns;

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

                System.out.println("Veuillez entrer un nom de fournisseur a afficher le profil");
                afficherProfileFournisseur(userView.getString());

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
