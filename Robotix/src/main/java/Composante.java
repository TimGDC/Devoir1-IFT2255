public class Composante {
    private String nom;
    private String type;
    private String description;
    private int prix;
    private String fournisseur;

    public Composante(String nom, String type, String description, int prix, String fournisseur) {

        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    public String getNom() {

        return this.nom;
    }

    public String getType() {

        return this.type;
    }

    public String getDesc() {

        return this.description;
    }

    public int getPrix() {

        return this.prix;
    }

    public String getFournisseur() {

        return this.fournisseur;
    }

    public void setNom(String nouveauNom) {

        this.nom = nouveauNom;
    }

    public void setType(String nouveauType) {

        this.type = nouveauType;
    }

    public void setDesc(String nouvelleDescription) {

        this.description = nouvelleDescription;
    }

    public void setPrix(int nouveauPrix) {

        this.prix = nouveauPrix;
    }
}