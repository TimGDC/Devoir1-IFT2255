
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {


        final String[] listeInterets = {"Productivite", "Musique", "Cuisine", "Jeux", "Sport", "Cinema", "Theatre", "Arts", "Gaming", "Animaux"};
        Activite activite1 = new Activite("Menage dans la maison", 2,
                "Le robot s'occupe de faire le menage dans toutes les pieces de la maison", listeInterets[0], "en cours");
        Activite activite2 = new Activite("Musique sur speaker", 1,
                "Le robot s'occupe de faire jouer de la musique sur speaker pendant 1 heure", listeInterets[1], "en cours");
        Activite activite3 = new Activite("Cuisinner un plat", 1,
                "Le robot s'occupe de cuisinner un plat avec les ingredients fournis", listeInterets[2], "en cours");
        Activite activite4 = new Activite("Partie d'echecs", 2,
                "Le robot joue une partie d'echec contre sont utilisateur", listeInterets[3], "en cours");
        Activite activite5 = new Activite("Partie de soccer", 2,
                "Le robot prend partie a une partie de soccer", listeInterets[4], "en cours");
        Activite activite6 = new Activite("Projection d'un film", 2,
                "Le robot projette un film sur un mur", listeInterets[5], "en cours");
        Activite activite7 = new Activite("S'occuper d'un animal", 4,
                "Le robot s'occupe d'un animal de companie'", listeInterets[9], "en cours");
        final Activite[] listeActivites = {activite1, activite2, activite3, activite4, activite5, activite6, activite7};

        User user1 = new User("Tim", "123", "tim@gmail.com", true);
        //User user2 = new User("Hokann", "test", "hokann@gmail.com", true );
        //User user3 = new User("9thgenius", "discord", "9thgenius@gmail.com" , true);
        //User user4 = new User("Wudm12", "github", "wudm12@gmail.com", false );
        //User user5 = new User("Travolta", "abc", "travolta@gmail.com" );
        //User user6 = new User("Wayne", "def", "wayne@gmail.com" );
        //User user7 = new User("Bob", "ghi", "bob@gmail.com" );
        //User user8 = new User("Alice", "jkl", "alice@gmail.com" );
        //User user9 = new User("George", "mno", "george@gmail.com" );
        //User user10 = new User("Rose", "pqr", "rose@gmail.com" );
        ArrayList<User> listeUsers = new ArrayList<>();
        listeUsers.add(user1);
        //listeUsers.add(user2);
        //listeUsers.add(user3);
        //listeUsers.add(user4);
        //listeUsers.add(user5);
        //listeUsers.add(user6);
        //listeUsers.add(user7);
        //listeUsers.add(user8);
        //listeUsers.add(user9);
        //listeUsers.add(user10);


        //user1.enregistrerRobot(12345, "ROBOTIX", 0);
        //user1.ajouterActivite(activite5);

        Fournisseur fournisseur1 = new Fournisseur("Amazon", "123", "amazon@gmail.com", "123 rue Sainte-Catherine", "CPU", true, 1000);
        Fournisseur fournisseur2 = new Fournisseur("Google", "321", "google@gmail.com", "321 rue Sainte-Catherine", "CPU", true, 2000);

        //Fournisseur fournisseur2 = new Fournisseur("Cabling123", "secret", "cabling123@gmail.com", "456 rue Saint-Laurent", "Cables", 25000);
        //Fournisseur fournisseur3 = new Fournisseur("Nvidia", "qwerty", "nvidia@gmail.com", "789 rue University", "Cartes Graphiques", 500);
        //Fournisseur fournisseur4 = new Fournisseur("DigiScreen", "screen", "digiscren@gmail.com", "282 rue Jean-Brillant", "Ecrans", 2500);
        //Fournisseur fournisseur5 = new Fournisseur("Logitech", "abcdef", "logitech@gmail.com", "491 rue Jean-Louis", "Cameras", 3750);
        ArrayList<Fournisseur> listeFournisseurs = new ArrayList<>();
        listeFournisseurs.add(fournisseur1);
        listeFournisseurs.add(fournisseur2);
        //listeFournisseurs.add(fournisseur3);
        //listeFournisseurs.add(fournisseur4);
        //listeFournisseurs.add(fournisseur5);

        fournisseur1.enregistrerComposante("AMD Ryzen 7", "CPU", "CPU le plus performant sur le marche", 1599, fournisseur1.getUsername(), 0);
        fournisseur2.enregistrerComposante("Nvidia", "CPU", "CPU le moins performant sur le marche", 10.99F, fournisseur2.getUsername(), 0);

        fournisseur1.enregistrerComposante("Cable HDMI", "Cables", "Cables HDMI", 10, fournisseur1.getUsername(), 0);
        fournisseur1.enregistrerComposante("RTX 4090", "Cartes Graphiques", "Meilleure carte graphique", 2000, fournisseur1.getUsername(), 0);
        //fournisseur4.enregistrerComposante("Ecran Tactile", "Ecrans", "Ecran tactiles a tout usage", 5999, fournisseur4.getUsername());
        //fournisseur5.enregistrerComposante("4k Pro Webcam", "Cameras", "Camera a haute qualite", 200, fournisseur5.getUsername());
        ArrayList<Composante> listeComposantes = new ArrayList<>();



        for(Fournisseur fourn : listeFournisseurs){
            listeComposantes.addAll(fourn.getListeComposante());
        }


        Object obj = new JSONParser().parse(new FileReader("src/main/java/BaseDonnee.json"));
        JSONObject baseDonneeObjet = (JSONObject) obj;
        View view = new View();
        Controller controller = new Controller(view, listeUsers, listeFournisseurs, listeComposantes, listeActivites, baseDonneeObjet);
        controller.start();
    }

}
