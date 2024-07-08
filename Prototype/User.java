import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class User {

    private String username;
    private String password;
    private String email;
    private ArrayList<Robot> listeRobotsUser = new ArrayList<>();
    private ArrayList<String> listeSuiveursUser = new ArrayList<>();;
    private ArrayList<String> listeInteretsUser = new ArrayList<>();;
    private ArrayList<String> listeActivitesUser = new ArrayList<>();;
    private String[] notifications = {"", ""};


    public User(String username, String password, String email){

        this.username = username;
        this.password = password;
        this.email = email;
        generationNotification();

    }

    private void generationNotification() {

        String notif1 = "Un de vos robots n'a plus de batterie!";
        String notif2 = "Un de vos robots est plein a 100%!";
        String notif3 = "Un de vos robots a une composante manquante!";
        String notif4 = "Vos composantes ont ete livrees!";
        String[] listeNotifications = {notif1, notif2, notif3, notif4};

        Random random = new Random();
        notifications[0] = listeNotifications[random.nextInt(4)];
        notifications[1] = listeNotifications[random.nextInt(4)];


    }

    public String getUsername(){

        return this.username;
    }

    public void setUsername(String user){

        this.username = user;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }

    public ArrayList<String> getSuiveurs(){
        return this.listeSuiveursUser;
    }

    public ArrayList<Robot> getListeRobots(){
        return this.listeRobotsUser;
    }
    public void afficherListeRobots(){
        System.out.println("Liste des robots : ");
        for(Robot rob : listeRobotsUser){
            System.out.println(rob.getNom());
        }
    }


    public void enregistrerRobot(int numeroSerie, String nom){

        Robot nouveauRobot = new Robot(nom, numeroSerie);
        listeRobotsUser.add(nouveauRobot);

    }

    public void supprimerRobot(int index){

        listeRobotsUser.remove(index - 1);

    }

    public void modifierProfil(String user, String pw, String email) {

        this.username = user;
        this.password = pw;
        this.email = email;

    }

    public void afficherSuiveurs(){

        System.out.println("Liste des suiveurs : ");
        for(String nom : listeSuiveursUser){
            System.out.println(nom);
        }
    }

    public void supprimerSuiveur(String nom){
        listeSuiveursUser.remove(nom);
    }

    public void afficherActivites(){
        System.out.println("Liste d'activites : ");
        for(String act : listeActivitesUser){
            System.out.println(act);
        }
    }
    public void ajouterActivite(Activite activite){

        listeActivitesUser.add(activite.getNom());

    }

    public void supprimerActivite(Activite activite){

        listeActivitesUser.remove(activite.getNom());

    }
    public void afficherInterets(){
        System.out.println("Liste d'interets : ");
        for(String interet : listeInteretsUser){
            System.out.println(interet);
        }
    }
    public void ajouterInteret(String interet){

        listeInteretsUser.add(interet);

    }

    public void supprimerInteret(String interet){

        listeInteretsUser.remove(interet);

    }

    public void suivreUtilisateur(String nom, ArrayList<User> listeUser){

        for(User user : listeUser){
            if(Objects.equals(user.getUsername(), nom)){
                if(!user.getSuiveurs().contains(this.username)){
                    user.getSuiveurs().add(this.username);
                }

            }
        }

    }

    public void afficherEtats(){
        System.out.println("Voici l'etat de tous vos robots : ");
        for(Robot robot : listeRobotsUser){
            System.out.printf("Nom : %s \nConsommation : %d V\nVitesse : %d km/h\nPosition : x=%d y=%d z=%d\n",robot.getNom(),
                    robot.getConsommation(), robot.getVitesse(), robot.getPosition()[0],robot.getPosition()[1], robot.getPosition()[2]);
        }

    }
    public void afficherMetriques(){

        int consommationTotale = 0;
        System.out.println("Liste de vos robots : ");
        for(Robot robot : listeRobotsUser){
            System.out.println(robot.getNom());
            consommationTotale += robot.getConsommation();
        }
        System.out.println("Nombre de robots dans la flotte : " + listeRobotsUser.size());
        System.out.println("Consommation totale " + consommationTotale + "V");

    }

    public void afficherNotifications(){
        System.out.println("Voici vos notifications : ");
        for(String notif : notifications){
            System.out.println(notif);
        }
    }


    public ArrayList<String> getInterets() {
        return listeInteretsUser;
    }

    public ArrayList<String> getActivites() {
        return listeActivitesUser;
    }
}
