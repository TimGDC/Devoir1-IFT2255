/**
 * Represente une composante d'un robot. Les fournisseurs ont des composantes qu'ils vendent.
 */
public class Composante {
    private String nom;
    private String type;
    private String description;
    private float prix;



    private String fournisseur;
    private int quantite;
    /**
     * Constructeur d'une composante specifique.
     * @param nom le nom de la composante
     * @param type son type
     * @param description sa description
     * @param prix son prix en float
     * @param fournisseur le fournisseur qui a cette composante dans son inventaire
     * @param quantite la quantite disponible de cette composante
     */
    public Composante(String nom, String type, String description, float prix, String fournisseur, int quantite) {

        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
        this.fournisseur = fournisseur;
        this.quantite = quantite;
    }
    /**
     * Constructeur de base
     */
    public Composante(){}

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
    /**
     * Override de la methode toString pour formatter un string avec les infos d'une composante
     * @return une string qui indique nom, type, description, prix et fournisseur de la composante
     */
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
    public void setDescription(String description) {
        this.description = description;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }
}