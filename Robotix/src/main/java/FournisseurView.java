public class FournisseurView extends View{

    public int displayFournisseurMenu(){

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Requetes publiques");
        System.out.println("2 - Fonctionalites pour fournisseurs");
        System.out.println("3 - Quitter l'application");


        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }
    public int displayFournisseurOptions(){

        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Modifier son profil");
        System.out.println("2 - Gerer ses composantes");
        System.out.println("3 - Enregistrer une composante");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }
    public int displayComposanteOptions(){
        System.out.println("Que souhaitez vous faire?");
        System.out.println("1 - Afficher mes composantes");
        System.out.println("2 - Supprimer une composante");
        System.out.println("3 - Modifier une composante");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide");
            scanner.next();
        }
        int choix= scanner.nextInt();
        scanner.nextLine();
        return choix;
    }
}
