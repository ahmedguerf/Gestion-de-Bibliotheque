package Document;

public class Cd extends Document {
    private String duree;
    private String sujet;

    public Cd(String titre, String auteur, int nbExemplaire, String ref,String duree, String sujet){
        super(titre, auteur, nbExemplaire,ref);
        this.sujet=sujet;
        if(dureeValide(duree)){
            this.duree=duree;
        }
        else {
            System.out.println("Le format doit être 'mm:ss'");
            this.duree="00:00";
        }
    }
    private boolean dureeValide(String duree){
        if (duree.matches("\\d{2}:\\d{2}")) {
            int indicept = duree.indexOf(':');
            int min = Integer.parseInt(duree.substring(0, indicept));
            int sec = Integer.parseInt(duree.substring(indicept+1));
            if (min < 0 || min > 59) {
                System.out.println("Les minutes doivent être comprises entre 00 et 59.");
                return false;
            }
            if (sec < 0 || sec > 59) {
                System.out.println("Les secondes doivent être comprises entre 00 et 59.");
                return false;
            }
            return true;
        } else {
            System.out.println("Le format de durée est invalide. Utilisez le format 'mm:ss'.");
            return false;
        }
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDuree(String duree) {
        if (dureeValide(duree)) {
            this.duree = duree;
        } else {
            System.out.println("Durée invalide. Le format doit être 'mm:ss'");
        }
    }
    @Override
    public void afficheCaracDocument() {
        // Affiche les caractéristiques spécifiques au CD
        System.out.printf("Titre: %s\nAuteur: %s\nNombre d'exemplaires: %d\n", getTitre(), getAuteur(), getNbexemplaire());
        System.out.println("Durée: "+this.duree);
        if (getRefCatalogue() == null) {
            System.out.println("Catalogue: Non classé");
        } else {
            System.out.printf("Référence catalogue: %s\n", getRefCatalogue());
        }
        System.out.println("------------------------------");
    }
    public void afficheCaracDocumentAdh() {
        // Affiche les caractéristiques spécifiques au CD
        System.out.printf("Titre: %s\nAuteur: %s\n", getTitre(), getAuteur());
        System.out.println("Durée: "+this.duree);
        if (getRefCatalogue() == null) {
            System.out.println("Catalogue: Non classé");
        } else {
            System.out.printf("Référence catalogue: %s\n", getRefCatalogue());
        }
        System.out.println("------------------------------");
    }
}
