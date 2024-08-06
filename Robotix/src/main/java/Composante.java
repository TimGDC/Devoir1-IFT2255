public class Composante {
    private String nom;
    private String type;
    private String description;
    private float prix;
    private String fournisseur;
    private int quantite;

    public Composante(String nom, String type, String description, float prix, String fournisseur, int quantite) {

        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
        this.fournisseur = fournisseur;
        this.quantite = quantite;
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

    public float getPrix() {

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

    public void setPrix(float nouveauPrix) {

        this.prix = nouveauPrix;
    }
    @Override
    public String toString() {
        return String.format("Nom: %s, Type: %s, Description: %s, Prix: %.2f, Fournisseur: %s",
                nom, type, description, prix, fournisseur);
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}