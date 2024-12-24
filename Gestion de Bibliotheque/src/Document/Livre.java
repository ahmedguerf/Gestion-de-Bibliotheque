package Document;

public class Livre extends Document {
    private String ISBN;

    public Livre(String titre, String auteur, int nbExemplaire, String ISBN){
        super(titre, auteur, nbExemplaire,null);
        this.ISBN=ISBN;
    }
    public void afficheCaracDocument() {
        System.out.printf("Titre: %s\nAuteur: %s\nNombre d'exemplaires: %d\n", getTitre(), getAuteur(), nbExemplaire);
        System.out.println("ISBN: " + ISBN);
        if (getRefCatalogue() == null) {
            System.out.println("Catalogue: Non classé");
        } else {
            System.out.printf("Référence catalogue: %s\n", getRefCatalogue());
        }
        System.out.println("------------------------------");
    }
    public void afficheCaracDocumentAdh() {
        System.out.printf("Titre: %s\nAuteur: %s\n", getTitre(), getAuteur());
        System.out.println("ISBN: " + ISBN);
        if (getRefCatalogue() == null) {
            System.out.println("Catalogue: Non classé");
        } else {
            System.out.printf("Référence catalogue: %s\n", getRefCatalogue());
        }
        System.out.println("------------------------------");
    }
}
