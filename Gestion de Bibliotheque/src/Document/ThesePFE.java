package Document;

public class ThesePFE extends Document {
    private String universite;
    private String encadrant;

    public ThesePFE(String titre, String auteur, int nbExemplaire, String ref,String universite, String encadrant){
        super(titre, auteur, nbExemplaire,ref);
        this.encadrant=encadrant;
        if (universite == null || universite.trim().isEmpty()) {
            System.out.println("L'université ne peut pas être vide.");
            this.universite = "Inconnu";
        } else {
            this.universite = universite;
        }
    }
    @Override
    public void afficheCaracDocument() {
        System.out.println("Titre : "+this.getTitre());
        System.out.println("Auteur : "+this.getAuteur());
        System.out.println("Université : "+this.universite);
        System.out.println("Étudiant : "+this.getAuteur());
        System.out.println("Encadrant : "+this.encadrant);
        System.out.println("Nombre d'exemplaire : "+this.getNbexemplaire());
        if (getRefCatalogue() == null) {
            System.out.println("Catalogue: Non classé");
        } else {
            System.out.printf("Référence catalogue: %s\n", getRefCatalogue());
        }
        System.out.println("------------------------------");
    }
    public void afficheCaracDocumentAdh() {
        System.out.println("Titre : "+this.getTitre());
        System.out.println("Auteur : "+this.getAuteur());
        System.out.println("Université : "+this.universite);
        System.out.println("Étudiant : "+this.getAuteur());
        System.out.println("Encadrant : "+this.encadrant);
        if (getRefCatalogue() == null) {
            System.out.println("Catalogue: Non classé");
        } else {
            System.out.printf("Référence catalogue: %s", getRefCatalogue());
        }
        System.out.println("------------------------------");
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }
    public void setEncadrant(String encadrant) {
        this.encadrant = encadrant;
    }
}
