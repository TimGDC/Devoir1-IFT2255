

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class Fournisseur {

    private String username;
    private String password;
    private String email;
    private String adresse;
    private String type;
    private int capaciteFabrication;

    private ArrayList<Composante> listeComposante = new ArrayList<>();

    public Fournisseur(String user, String pw, String email, String adresse, String type, int production) throws IOException, ParseException {

        this.username = user;
        this.password = pw;
        this.email = email;
        this.adresse = adresse;
        this.type = type;
        this.capaciteFabrication = production;

    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getType() {
        return this.type;
    }

    public int getCapaciteFabrication() {
        return capaciteFabrication;
    }

    public void modifierProfilFournisseur(String user, String pw, String email, String adresse, String type, int capacite) {
        this.username = user;
        this.password = pw;
        this.email = email;
        this.adresse = adresse;
        this.type = type;
        this.capaciteFabrication = capacite;

    }

    public void enregistrerComposante(String nom, String type, String description, int prix, String fournisseur) {

        Composante nouvelleComposante = new Composante(nom, type, description, prix, fournisseur);
        listeComposante.add(nouvelleComposante);

    }

    public ArrayList<Composante> getListeComposante() {
        return this.listeComposante;
    }

    public void afficherComposante() {
        int index = 1;
        System.out.println("Liste des composantes de ce fournisseur : ");
        for (Composante comp : listeComposante) {

            System.out.println("Composante " + index);
            System.out.printf("Nom : %s \nType : %s \nDescription : %s \nPrix : %d \nFournisseur : %s\n", comp.getNom(),
                    comp.getType(), comp.getDesc(), comp.getPrix(), comp.getFournisseur());
            index += 1;

        }
    }

    public void supprimerComposante(int index) {

        listeComposante.remove(index - 1);
    }

    public void modifierComposante(int index, String nom, String type, String description, int prix) {
        Composante comp = listeComposante.get(index - 1);
        comp.setNom(nom);
        comp.setType(type);
        comp.setDesc(description);
        comp.setPrix(prix);
    }

    public String getUsername() {

        return this.username;
    }

    public void setUsername(String user) {

        this.username = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String pass) {

        this.password = pass;
    }

    public String getEmail() {
        return this.email;
    }


    public void setEmail(String mail) {
        this.email = mail;
    }
}
