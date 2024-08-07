/**
 * Represente une activite qu'un utilisateur peut participer a avec ses robots.
 * Une activite a un nom, une duree, une description, un interet, et un statut (en cours, terminee, ...)
 */
public class Activite {

    private String nom;
    private int duree;
    private String description;
    private String interet;
    private String status;

    /**
     * Constructeur d'une activite
     * @param nom le nom de l'activite
     * @param duree la duree de cette activite
     * @param description sa description
     * @param interet son interet
     * @param status le status de l'activte (en cours, terminee, non-debutee)
     */
    public Activite(String nom, int duree, String description, String interet, String status){
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.interet = interet;
        this.status = status;
    }
    /**
     * Construceur de base, sans parametres
     */
    public Activite(){

    }

    public int getDuree() {
        return duree;
    }

    public String getDescription() {
        return description;
    }

    public String getInteret() {
        return interet;
    }

    public String getNom() {
        return nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setInteret(String interet) {
        this.interet = interet;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
