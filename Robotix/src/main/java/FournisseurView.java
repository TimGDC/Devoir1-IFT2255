/**
 * Responsable pour l'affichage de tout ce qui est rapport avec le fournisseur.
 * Contient principalement des methodes qui retourne le choix du fournisseur et qui affiche les choix possibles
 */
public class FournisseurView extends View{
    /**
     * Affiche le menu du fournisseur
     * @return le choix du fournisseur parmi les options
     */
    public int displayFournisseurMenu(){

        System.out.println("Veuillez choisir une option");
        System.out.println("1 - Requetes publiques");
        System.out.println("2 - Fonctionalites pour fournisseurs");
        System.out.println("3 - Quitter l'application");
        return getInt();

    }
    /**
     * Affiche le menu des fonctionnalites pour fournisseur
     * @return le choix du fournisseur
     */
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
