
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader("src/main/java/BaseDonnee.json"));
        JSONObject baseDonneeObjet = (JSONObject) obj;
        ArrayList<User> listeUsers = new ArrayList<>();
        ArrayList<Fournisseur> listeFournisseurs = new ArrayList<>();
        ArrayList<Composante> listeComposantes = new ArrayList<>();
        Activite[] listeActivites = new Activite[8];

        JSONArray activitesJSON = (JSONArray) baseDonneeObjet.get("Activites");

        for(int i = 0 ; i<activitesJSON.size() ; i++){

            JSONObject nouvelleActivite = (JSONObject) activitesJSON.get(i);
            Activite activite = new Activite();

            String nom = (String) nouvelleActivite.get("nom");
            activite.setNom(nom);

            Long dureeLong = (Long) nouvelleActivite.get("duree");
            int duree = dureeLong.intValue();
            activite.setDuree(duree);

            String description = (String) nouvelleActivite.get("description");
            activite.setDescription(description);

            String interet = (String) nouvelleActivite.get("interet");
            activite.setInteret(interet);

            String status = (String) nouvelleActivite.get("status");
            activite.setStatus(status);

            listeActivites[i] = activite;
        }

        JSONArray usersJSON = (JSONArray) baseDonneeObjet.get("Users");

        for(int j = 0 ; j<usersJSON.size() ; j++){

            JSONObject nouveauUser = (JSONObject) usersJSON.get(j);
            User user = new User();
            String username = (String) nouveauUser.get("username");
            String password = (String) nouveauUser.get("password");
            String email = (String) nouveauUser.get("email");
            Boolean notificationsEmail = (Boolean) nouveauUser.get("notificationsEmail");

            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setNotificationsEmail(notificationsEmail);

            JSONArray robots = (JSONArray) nouveauUser.get("robots");
            for(int j1 = 0; j1< robots.size(); j1++){

                JSONObject nouveauRobot = (JSONObject) robots.get(j1);
                Robot robot = new Robot();

                String nomR = (String) nouveauRobot.get("nom");
                robot.setNom(nomR);

                Long batterieLong = (Long) nouveauRobot.get("batterie");
                int batterie = batterieLong.intValue();
                robot.setBatterie(batterie);

                Long vitesseLong = (Long) nouveauRobot.get("vitesse");
                int vitesse = vitesseLong.intValue();
                robot.setVitesse(vitesse);

                Long numeroSerieLong = (Long) nouveauRobot.get("numeroSerie");
                int numeroSerie = numeroSerieLong.intValue();
                robot.setNumeroSerie(numeroSerie);

                Long consommationCPULong = (Long) nouveauRobot.get("consommationCPU");
                int consommationCPU = consommationCPULong.intValue();
                robot.setConsommationCPU(consommationCPU);

                Long consommationMemoireLong = (Long) nouveauRobot.get("consommationMemoire");
                int consommationMemoire = consommationMemoireLong.intValue();
                robot.setConsommationMemoire(consommationMemoire);

                JSONArray position = (JSONArray) nouveauRobot.get("position");
                Long positionXLong = (Long) position.get(0);
                int positionX = positionXLong.intValue();

                Long positionYLong = (Long) position.get(1);
                int positionY = positionYLong.intValue();

                Long positionZLong = (Long) position.get(2);
                int positionZ = positionZLong.intValue();

                int[] pos = {positionX, positionY, positionZ};

                robot.setPosition(pos);

                user.ajouterRobotListe(robot);

            }

            JSONArray activites = (JSONArray) nouveauUser.get("activites");
            for(int j2 = 0; j2 < activites.size() ; j2++){

                JSONObject nouvelleA = (JSONObject) activites.get(j2);
                Activite act = new Activite();

                String nomA = (String) nouvelleA.get("nom");
                act.setNom(nomA);

                Long dureeALong = (Long) nouvelleA.get("duree");
                int dureeA = dureeALong.intValue();
                act.setDuree(dureeA);

                String descriptionA = (String) nouvelleA.get("description");
                act.setDescription(descriptionA);

                String interetA = (String) nouvelleA.get("interet");
                act.setInteret(interetA);

                String statusA = (String) nouvelleA.get("status");
                act.setStatus(statusA);

                user.ajouterActiviteListe(act);

            }

            listeUsers.add(user);

        }

        JSONArray fournisseursJSON = (JSONArray) baseDonneeObjet.get("Fournisseurs");

        for(int k = 0 ; k<fournisseursJSON.size() ; k++){

            JSONObject nouveauFournisseur = (JSONObject) fournisseursJSON.get(k);
            Fournisseur fournisseur = new Fournisseur();

            String username = (String) nouveauFournisseur.get("username");
            fournisseur.setUsername(username);

            String password = (String) nouveauFournisseur.get("password");
            fournisseur.setPassword(password);

            String email = (String) nouveauFournisseur.get("email");
            fournisseur.setEmail(email);

            Boolean notificationsEmail = (Boolean) nouveauFournisseur.get("notificationsEmail");
            fournisseur.setNotificationsEmail(notificationsEmail);

            String adresse = (String) nouveauFournisseur.get("adresse");
            fournisseur.setAdresse(adresse);

            String type = (String) nouveauFournisseur.get("type");
            fournisseur.setType(type);

            Long productionLong = (Long) nouveauFournisseur.get("production");
            int production = productionLong.intValue();
            fournisseur.setCapaciteFabrication(production);

            JSONArray composantes = (JSONArray) nouveauFournisseur.get("composantes");

            for(int k1 = 0 ; k1 < composantes.size() ; k1++){

                JSONObject nouvelleComp = (JSONObject) composantes.get(k1);
                Composante composante = new Composante();

                String nomC = (String) nouvelleComp.get("nom");
                composante.setNom(nomC);

                String typeC = (String) nouvelleComp.get("type");
                composante.setType(typeC);

                String fournisseurC = (String) nouvelleComp.get("fournisseur");
                composante.setFournisseur(fournisseurC);

                String descriptionC = (String) nouvelleComp.get("description");
                composante.setDescription(descriptionC);

                Double prixCLong = (Double) nouvelleComp.get("prix");
                int prixC = prixCLong.intValue();
                composante.setPrix(prixC);

                Long quantiteCLong = (Long) nouvelleComp.get("quantite");
                int quantiteC = quantiteCLong.intValue();
                composante.setQuantite(quantiteC);

                fournisseur.ajouterComposanteListe(composante);

            }

            listeFournisseurs.add(fournisseur);


        }

        for(Fournisseur fourn : listeFournisseurs){
            listeComposantes.addAll(fourn.getListeComposante());
        }



        View view = new View();
        Controller controller = new Controller(view, listeUsers, listeFournisseurs, listeComposantes, listeActivites, baseDonneeObjet);
        controller.start();
    }

}
