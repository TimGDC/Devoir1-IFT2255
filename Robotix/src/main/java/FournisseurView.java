public class FournisseurView extends View{

    public int displayFournisseurMenu(){

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Requetes publiques");
        System.out.println("2 - Fonctionalites pour fournisseurs");
        System.out.println("3 - Quitter l'application");
        return getInt();

    }
    public int displayFournisseurOptions(){

        System.out.println("Veuillez choisir une option : ");
        System.out.println("1 - Modifier son profil");
        System.out.println("2 - Afficher mes composantes");
        System.out.println("3 - Supprimer une composante");
        System.out.println("4 - Modifier une composante");
        System.out.println("5 - Enregistrer une composante");
        return getInt();

    }
    public int displayComposanteOptions(){
        System.out.println("Que souhaitez vous faire?");
        return getInt();

    }
}
