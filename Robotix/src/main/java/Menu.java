import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Menu {


    private ArrayList<User> listeUsers;
    private ArrayList<Fournisseur> listeFournisseurs;
    private ArrayList<Composante> listeComposantes;
    private final Activite[] listeActivites;
    private final String[] listeInterets;
    private final String baseDonneePath = "src/main/java/org/json/BaseDonnee.json";
    private Object obj;
    private JSONObject baseDonneeObjet;
    private int jsonIndex;

    public Menu(ArrayList<User> listeUsers, ArrayList<Fournisseur> listeFournisseurs, ArrayList<Composante> listeComposantes, Activite[] listeActivites, String[] listeInterets) throws IOException, ParseException {

        this.listeUsers = listeUsers;
        this.listeFournisseurs = listeFournisseurs;
        this.listeComposantes = listeComposantes;
        this.listeActivites = listeActivites;
        this.listeInterets = listeInterets;
        this.obj = new JSONParser().parse(new FileReader("src/main/java/BaseDonnee.json"));
        this.baseDonneeObjet = (JSONObject) obj;
        startScanner();
    }

    private void startScanner() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Se connecter");
        System.out.println("2 - Creer un compte");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer soit 1 ou 2");
            scanner.next();
        }
        choix = scanner.nextInt();

        switch (choix) {
            case 1:

                login();
                scanner.close();
                break;
            case 2:

                signup();
                scanner.close();
                break;
            default:
                System.out.println("Veuillez entrer soit 1 ou 2.");
                startScanner();
        }

        scanner.close();
    }

    private void login() throws IOException, ParseException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Entrez votre nom d'utilisateur : ");
        String utilisateur = scanner1.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String password = scanner1.nextLine();
        Boolean trouver = false;
        for(User user : listeUsers){

            if (Objects.equals(user.getUsername(), utilisateur) && Objects.equals(user.getPassword(), password)) {
                int index = listeUsers.indexOf(user);

                appMenu(index, "user");
                trouver = true;
                scanner1.close();
                break;
            }
        }
        if(!trouver) {
            for (Fournisseur fourn : listeFournisseurs) {
                if (Objects.equals(fourn.getUsername(), utilisateur) && Objects.equals(fourn.getPassword(), password)) {
                    int index = listeFournisseurs.indexOf(fourn);
                    appMenu(index, "fournisseur");
                    trouver = true;
                    scanner1.close();
                }
            }
        }
        if (!trouver) {
            System.out.println("Utilisateur ou mot de pass incorrect.");

            login();
            scanner1.close();
        }
    }
    private  void signup() throws IOException, ParseException {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Creation d'un nouveau compte:");
        System.out.println("1 - Utilisateur");
        System.out.println("2 - Fournisseur");

        int choix;
        while (!scanner2.hasNextInt()) {
            System.out.println("Veuillez entrer 1 ou 2");
            scanner2.next();
        }
        choix = scanner2.nextInt();

        switch(choix){
            case 1:
                Scanner scan22 = new Scanner(System.in);
                System.out.print("Nom d'utilisateur : ");
                String nom = scan22.nextLine();

                for(User utilisateurs : listeUsers){
                    if(Objects.equals(utilisateurs.getUsername(), nom)){
                        System.out.println("Ce username est deja pris!");
                        signup();
                        break;
                    }
                }

                System.out.print("Mot de passe : ");
                String pass = scan22.nextLine();

                System.out.print("Adresse email : ");
                String email = scan22.nextLine();

                System.out.print("Voulez vous recevoir les notifications par email? (true/false)");
                Boolean notificationsEmail = scan22.nextBoolean();




                //Ajout dans la base de donnees
                JSONObject nouvelUtilisateurObjet = new JSONObject();
                nouvelUtilisateurObjet.put("password", pass);
                nouvelUtilisateurObjet.put("email", email);
                nouvelUtilisateurObjet.put("username", nom);
                nouvelUtilisateurObjet.put("notificationsEmail", notificationsEmail);

                JSONArray listeUtilisateurs = (JSONArray) baseDonneeObjet.get("Users");
                listeUtilisateurs.add(nouvelUtilisateurObjet);
                try (FileWriter file = new FileWriter("src/main/java/BaseDonnee.json")) {
                    file.write(baseDonneeObjet.toJSONString());
                }

                //Fin ajout base
                User nouvelUtilisateur = new User(nom, pass, email);
                listeUsers.add(nouvelUtilisateur);
                System.out.println("Creation de compte reussi!");
                //System.out.println(listeUsers.size());
                login();
                scan22.close();
                scanner2.close();
                break;
            case 2:
                Scanner scan23 = new Scanner(System.in);
                System.out.print("Nom d'utilisateur : ");
                String util = scan23.nextLine();

                for(Fournisseur fourn : listeFournisseurs){
                    if(Objects.equals(fourn.getUsername(), util)){
                        System.out.println("Ce username est deja pris!");
                        signup();
                        break;
                    }
                }

                System.out.print("Mot de passe : ");
                String password = scan23.nextLine();

                System.out.print("Adresse email : ");
                String emailadress = scan23.nextLine();

                System.out.print("Adresse de la companie : ");
                String adresse = scan23.nextLine();

                System.out.print("Type de composantes : ");
                String type = scan23.nextLine();

                System.out.print("Quantite de production : ");
                while (!scan23.hasNextInt()) {
                    System.out.println("Veuillez entrer soit 1 ou 2");
                    scan23.next();
                }
                int quantite = scan23.nextInt();
                Fournisseur nouveauFournisseur = new Fournisseur(util, password, emailadress, adresse, type, quantite);
                listeFournisseurs.add(nouveauFournisseur);
                JSONObject nouveauFournisseurObjet = new JSONObject();
                nouveauFournisseurObjet.put("password", password);
                nouveauFournisseurObjet.put("email", emailadress);
                nouveauFournisseurObjet.put("username", util);
                nouveauFournisseurObjet.put("adresse", adresse);
                nouveauFournisseurObjet.put("type", type);
                nouveauFournisseurObjet.put("quantite", quantite);

                JSONArray listeFournisseurs = (JSONArray) baseDonneeObjet.get("Fournisseurs");
                listeFournisseurs.add(nouveauFournisseurObjet);
                try (FileWriter file = new FileWriter("src/main/java/BaseDonnee.json")) {
                    file.write(baseDonneeObjet.toJSONString());
                }

                System.out.println("Creation de compte reussi!");
                login();
                scan23.close();
                scanner2.close();
                break;



        }
    }
    private void appMenu(int index, String privileges) throws IOException, ParseException {

        JSONArray listeUtilisateursJson = (JSONArray) baseDonneeObjet.get("Users");
        System.out.println(listeUtilisateursJson.get(0));
        for(int i=0 ; i<listeUtilisateursJson.size(); i++){
            JSONObject userActuel = (JSONObject) listeUtilisateursJson.get(i);
            if(userActuel.get("username") == listeUsers.get(index).getUsername()){
                this.jsonIndex = i;
            }
        }
        Scanner scanner3 = new Scanner(System.in);
        if(Objects.equals(privileges, "user")){
            System.out.println("Bienvenue " + listeUsers.get(index).getUsername() + "!");
        }
        else{
            System.out.println("Bienvenue " + listeFournisseurs.get(index).getUsername() + "!");
        }

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Requetes publiques");
        System.out.println("2 - Fonctionalites pour utilisateurs");

        if(Objects.equals(privileges, "fournisseur")){
            System.out.println("3 - Fonctionalites pour fournisseurs");
        }


        int choix;
        while (!scanner3.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner3.next();
        }
        choix = scanner3.nextInt();
        switch (choix) {
            case 1:
                requetesPubliques(index, privileges);
                break;
            case 2:
                fonctionsUtilisateur(index, privileges);
                break;
            case 3:
                fonctionsFournisseur(index, privileges);
                break;

            default:
                System.out.println("Veuillez entrer un nombre valide.");
        }
        //System.out.println("Voulez vous executer une autre requete, ou bien sortir de l'application?");

    }
    private  void requetesPubliques(int index, String privileges) throws IOException, ParseException {

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Recuperer la liste des utilisateurs");
        System.out.println("2 - Rechercher un utilisateur");
        System.out.println("3 - Voir le profil d'un utilisateur");
        System.out.println("4 - Recuperer la liste des activites");
        System.out.println("5 - Recuperer la liste des fournisseurs");
        System.out.println("6 - Rechercher un fournisseur");
        System.out.println("7 - Voir le profil d'un fournisseur");
        System.out.println("8 - Rechercher une composante");

        int choix;
        while (!scanner4.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner4.next();
        }
        choix = scanner4.nextInt();
        switch (choix) {
            case 1:
                afficherListeUtilisateur();
                endingMenu(index, privileges);
                scanner4.close();
                break;
            case 2:
                Scanner scanTest = new Scanner(System.in);
                System.out.println("Veuillez entrer un nom d'utilisateur a rechercher");
                String util = scanTest.nextLine();
                rechercherUtilisateur(util);
                endingMenu(index, privileges);
                scanner4.close();
                scanTest.close();
                break;
            case 3:
                Scanner scanTest1 = new Scanner(System.in);
                System.out.println("Veuillez entrer un nom d'utilisateur a afficher le profil");
                String prof = scanTest1.nextLine();
                afficherProfilUtilisateur(prof);
                endingMenu(index, privileges);
                scanner4.close();
                scanTest1.close();
                break;
            case 4:
                afficherListeActivites();
                endingMenu(index, privileges);
                scanner4.close();
                break;
            case 5:
                afficherListeFournisseurs();
                endingMenu(index, privileges);
                scanner4.close();
                break;
            case 6:
                Scanner scanTest2 = new Scanner(System.in);
                System.out.println("Veuillez entrer un nom de fournisseur a rechercher");
                String fourn = scanTest2.nextLine();
                chercherFournisseur(fourn);
                endingMenu(index, privileges);
                scanner4.close();
                scanTest2.close();
                break;
            case 7:
                Scanner scanTest3 = new Scanner(System.in);
                System.out.println("Veuillez entrer un nom de fournisseur a afficher le profil");
                String profil = scanTest3.nextLine();
                afficherProfileFournisseur(profil);
                endingMenu(index, privileges);
                scanner4.close();
                scanTest3.close();
                break;
            case 8:
                Scanner scanTest4 = new Scanner(System.in);
                System.out.println("Veuillez entrer un nom, type ou nom de fournisseur d'une composante");
                String comp = scanTest4.nextLine();
                chercherComposante(comp);
                endingMenu(index, privileges);
                scanner4.close();
                scanTest4.close();
                break;
            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 9.");
        }


    }
    private void endingMenu(int index, String privileges) throws IOException, ParseException {
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Que voulez vous faire a present?");
        System.out.println("1 - Revenir au menu precedent");
        System.out.println("2 - Quitter l'application");

        int choix;
        if (scanner6.hasNextInt()) {
            choix = scanner6.nextInt();
            switch (choix) {
                case 1:
                    appMenu(index, privileges);
                    scanner6.close();
                    break;
                default:
                    System.out.println("A la prochaine!");
                    scanner6.close();
                    break;

            }
        } else {

            System.out.println("Erreur: Veuillez entrer un nombre entier (1 ou 2)");
        }

    }
    private void fonctionsUtilisateur(int index, String privileges) throws IOException, ParseException {
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Modifier son profil");
        System.out.println("2 - Gerer sa flotte");
        System.out.println("3 - Gerer ses activites");
        System.out.println("4 - Voir l'etat de mes robots");
        System.out.println("5 - Voir ses notifications");
        System.out.println("6 - Acheter une composante");

        char choix;

        choix = (char) scanner5.nextInt();
        switch (choix) {
            case 1:
                Scanner funcScan1 = new Scanner(System.in);
                System.out.println("Nouveau nom d'utilisateur");
                String nom = funcScan1.nextLine();
                System.out.println("Nouveau password");
                String passwd = funcScan1.nextLine();
                System.out.println("Nouveau email");
                String mail = funcScan1.nextLine();
                listeUsers.get(index).modifierProfil(nom, passwd, mail, jsonIndex);
                endingMenu(index,privileges);
                scanner5.close();
                funcScan1.close();
                break;
            case 2:
                Scanner funcScan2 = new Scanner(System.in);
                System.out.println("Veuillez choisir une option : ");
                System.out.println("1 - Afficher ses robots");
                System.out.println("2 - Enregistrer un robots");
                System.out.println("3 - Supprimer un robots");
                while (!funcScan2.hasNextInt()) {
                    System.out.println("Veuillez entrer un nombre valide");
                    funcScan2.next();
                }
                int choice = funcScan2.nextInt();
                switch(choice){
                    case 1: listeUsers.get(index).afficherListeRobots();
                        endingMenu(index, privileges);
                        funcScan2.close();
                        scanner5.close();
                        break;
                    case 2:
                        Scanner funcScan21 = new Scanner(System.in);
                        System.out.println("Numero de serie");
                        int numSerie = funcScan21.nextInt();
                        Scanner funcScan211 = new Scanner(System.in);
                        System.out.println("Nom");
                        String nomRobot = funcScan211.nextLine();
                        listeUsers.get(index).enregistrerRobot(numSerie, nomRobot, jsonIndex);

                        endingMenu(index, privileges);
                        funcScan21.close();
                        funcScan211.close();
                        funcScan2.close();
                        scanner5.close();
                        break;
                    case 3:
                        Scanner funcScan22 = new Scanner(System.in);
                        System.out.println("Nom du robot a supprimer");
                        String nomRob = funcScan22.nextLine();
                        listeUsers.get(index).supprimerRobot(nomRob, jsonIndex);
                        endingMenu(index, privileges);
                        funcScan22.close();
                        funcScan2.close();
                        scanner5.close();
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 3.");
                        break;
                }



            case 3:

                Scanner funcScan4 = new Scanner(System.in);
                System.out.println("Veuillez choisir une option : ");
                System.out.println("1 - Afficher activites");
                System.out.println("2 - Supprimer activites");
                System.out.println("3 - Ajouter activites");

                while (!funcScan4.hasNextInt()) {
                    System.out.println("Veuillez entrer un nombre valide");
                    funcScan4.next();
                }
                int choice2 = funcScan4.nextInt();
                switch(choice2) {
                    case 1:
                        listeUsers.get(index).afficherActivites();
                        endingMenu(index,privileges);
                        funcScan4.close();
                        scanner5.close();
                        break;
                    case 2:
                        Scanner funcScan41 = new Scanner(System.in);
                        System.out.println("Nom de l'activite a supprimer");
                        String nomActivite = funcScan41.nextLine();
                        listeUsers.get(index).getActivites().remove(nomActivite);
                        endingMenu(index, privileges);
                        funcScan41.close();
                        funcScan4.close();
                        scanner5.close();
                        break;
                    case 3:
                        Scanner funcScan42 = new Scanner(System.in);
                        System.out.println("Nom de l'activite a ajouter");
                        String nomA = funcScan42.nextLine();
                        listeUsers.get(index).getActivites().add(nomA);

                        for(int i = 0 ; i< listeActivites.length ; i++){
                            if(Objects.equals(listeActivites[i].getNom(), nomA)){
                                listeUsers.get(index).ajouterActivite(listeActivites[i], jsonIndex);
                                System.out.println("Activite ajoutee!");
                                break;
                            }

                        }
                        endingMenu(index, privileges);
                        funcScan42.close();
                        funcScan4.close();
                        scanner5.close();
                        break;
                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 3.");
                        break;
                }

            case 4:
                Scanner funcScann = new Scanner(System.in);
                System.out.println("Veuillez choisir une option : ");
                System.out.println("1 - Afficher vue generale");
                System.out.println("2 - Afficher vue complete");


                while (!funcScann.hasNextInt()) {
                    System.out.println("Veuillez entrer un nombre valide");
                    funcScann.next();
                }
                int choixVue = funcScann.nextInt();
                switch(choixVue) {
                    case 1:
                        listeUsers.get(index).afficherEtats(0);
                        funcScann.close();
                        scanner5.close();
                        break;
                    case 2:
                        listeUsers.get(index).afficherEtats(1);
                        funcScann.close();
                        scanner5.close();
                        break;

                    default:
                        System.out.println("Veuillez entrer un nombre entre 1 et 2.");
                        break;
                }

                endingMenu(index, privileges);
                scanner5.close();
                break;

            case 5:

                listeUsers.get(index).afficherNotifications();
                endingMenu(index, privileges);
                scanner5.close();
                break;
            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 9.");
        }

    }
    private  void fonctionsFournisseur(int index, String privileges) throws IOException, ParseException {

        Scanner scanner7 = new Scanner(System.in);
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Modifier son profil");
        System.out.println("2 - Gerer ses composantes");
        System.out.println("3 - Enregistrer une composante");

        int choix;
        while (!scanner7.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner7.next();
        }
        choix = scanner7.nextInt();
        switch (choix) {
            case 1:
                Scanner fourScan = new Scanner(System.in);
                System.out.print("Nouveau nom d'utilisateur : ");
                String util = fourScan.nextLine();

                System.out.print("Nouveau mot de passe : ");
                String password = fourScan.nextLine();

                System.out.print("Nouvelle adresse email");
                String emailadress = fourScan.nextLine();

                System.out.print("Nouvelle Adresse de la companie");
                String adresse = fourScan.nextLine();

                System.out.print("Nouveau type de composantes");
                String type = fourScan.nextLine();

                System.out.print("Nouvelle quantite de production");
                while (!fourScan.hasNextInt()) {
                    System.out.println("Veuillez entrer soit 1 ou 2");
                    fourScan.next();
                }
                int quantite = fourScan.nextInt();
                listeFournisseurs.get(index).modifierProfilFournisseur(util,password,emailadress,adresse,type,quantite);
                System.out.println("Mise a jour du compte reussi!");
                endingMenu(index,privileges);
                fourScan.close();
                break;
            case 2:

                gererComposantes(index, privileges);
                endingMenu(index,privileges);
                scanner7.close();
                break;
            case 3:
                Scanner fourScan1 = new Scanner(System.in);
                System.out.print("Nom de la composante");
                String nomComp = fourScan1.nextLine();
                System.out.print("Type de la composante");
                String typeComp = fourScan1.nextLine();
                System.out.print("Description de la composante");
                String descComp = fourScan1.nextLine();
                System.out.print("Prix de la composante");
                int prixComp = fourScan1.nextInt();
                listeFournisseurs.get(index).enregistrerComposante(nomComp, typeComp, descComp, prixComp, listeFournisseurs.get(index).getUsername());
                endingMenu(index, privileges);
                fourScan1.close();
                scanner7.close();
                break;

            default:
                System.out.println("Veuillez entrer un nombre entre 1 et 9.");
        }

    }
    public void gererComposantes(int index, String privileges) throws IOException, ParseException {

        Scanner scanner8 = new Scanner(System.in);
        System.out.println("Que souhaitez vous faire?");
        System.out.println("1 - Afficher mes composantes");
        System.out.println("2 - Supprimer une composante");
        System.out.println("3 - Modifier une composante");
        int choixFournisseur;
        while (!scanner8.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner8.next();
        }
        choixFournisseur= scanner8.nextInt();
        switch (choixFournisseur){
            case 1: listeFournisseurs.get(index).afficherComposante();
                endingMenu(index, privileges);
                scanner8.close();
                break;
            case 2:
                System.out.print("Index de la composante a supprimer?");
                int i = scanner8.nextInt();
                listeFournisseurs.get(index).supprimerComposante(i);
                endingMenu(index, privileges);
                scanner8.close();
                break;
            case 3:
                Scanner fourn4 = new Scanner(System.in);
                System.out.print("Index de la composante a modifier?");
                int j = fourn4.nextInt();
                System.out.print("Nom de la composante");
                String nomComp = fourn4.nextLine();
                System.out.print("Type de la composante");
                String typeComp = fourn4.nextLine();
                System.out.print("Description de la composante");
                String descComp = fourn4.nextLine();
                System.out.print("Prix de la composante");
                int prixComp = fourn4.nextInt();
                listeFournisseurs.get(index).modifierComposante(j,nomComp,typeComp, descComp, prixComp);
                endingMenu(index, privileges);
                fourn4.close();
                scanner8.close();
                break;

        }


    }
    public void afficherListeUtilisateur(){
        System.out.println("Liste d'utilisateurs : ");
        for(User user : listeUsers){
            System.out.println(user.getUsername());
        }
    }
    public void rechercherUtilisateur(String nom){
        for(User user : listeUsers) {
            if (Objects.equals(user.getUsername(), nom)) {
                System.out.println("Cet utilisateur existe!");
                break;
            }
        }
    }
    public void afficherProfilUtilisateur(String nom){
        for(User user : listeUsers){
            if(Objects.equals(user.getUsername(), nom)){
                System.out.println("Voici le profil de l'utilisateur " + user.getUsername());
                System.out.println("Email : " + user.getEmail());
                user.afficherListeRobots();
                user.afficherActivites();
            }

        }

    }

    public void afficherListeActivites(){
        System.out.println("Liste de toutes les activites");
        for(Activite act : listeActivites){
            System.out.println(act.getNom());
        }
    }


    public void afficherListeFournisseurs(){
        System.out.println("Liste de tous les fournisseurs");
        for(Fournisseur fourn : listeFournisseurs){
            System.out.println(fourn.getUsername());
        }
    }

    public void chercherFournisseur(String recherche){
        String mot = recherche;
        for(Fournisseur fourn : listeFournisseurs){
            if(Objects.equals(mot, fourn.getAdresse()) || Objects.equals(mot, fourn.getType()) || Objects.equals(mot, fourn.getUsername())){
                System.out.println("Le fournisseur " + fourn.getUsername() + " existe sur cette platforme!");
            }
        }
    }
    public void afficherProfileFournisseur(String nom){

        for(Fournisseur fourn : listeFournisseurs){
            if(Objects.equals(fourn.getUsername(), nom)) {
                System.out.println("Voici le profil du fournisseur " + fourn.getUsername());
                System.out.println("Email : " + fourn.getAdresse());
                System.out.println("Capacite production : " + fourn.getCapaciteFabrication());
                fourn.afficherComposante();

            }
        }

    }

    public void chercherComposante(String recherche){
        String mot = recherche;
        for(Composante comp : listeComposantes){
            if(Objects.equals(mot, comp.getNom()) || Objects.equals(mot, comp.getType()) || Objects.equals(mot, comp.getFournisseur())){
                System.out.println("La composante " + comp.getNom() + " est disponible sur cette platforme, vendue par " + comp.getFournisseur() +
                        " pour un prix de " + comp.getPrix() + "$");
            }
        }
    }

}

