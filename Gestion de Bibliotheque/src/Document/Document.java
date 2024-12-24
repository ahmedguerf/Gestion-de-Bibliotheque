package Document;

public abstract class Document {
    private String titre;
    private String auteur;
    protected int nbExemplaire=0;
    private String refCatalogue;

    public Document(String titre, String auteur, int nbExemplaire, String refCatalogue){
        this.titre=titre;
        this.auteur=auteur;
        this.nbExemplaire=nbExemplaire;
        this.refCatalogue=refCatalogue;
    }
    public abstract void afficheCaracDocument();
    public abstract void afficheCaracDocumentAdh();

    public void setTitre(String titre) {
        if(titre!=null){
        this.titre = titre;
        }
        else {
            System.out.println("Tu dois saisir le titre");
        }
    }
    public String getTitre(){
        return this.titre;
    }
    public void setAuteur(String auteur){
        if(titre!=null){
            this.auteur = auteur;
        }
        else {
            System.out.println("Tu dois saisir l'auteur");
        }
    }

    public String getAuteur() {
        return auteur;
    }

    public void setRefCatalogue(String ref){
        if(ref!=null && ref.trim()!=null) {
            this.refCatalogue = ref;
        }
        else{
            this.refCatalogue=null;
        }
    }
    public void setNbExemplaire(int n){
        if (n>0) {
            this.nbExemplaire=n;
        }
        else {
            System.out.println("Le nombre d'exemplaire doit etre positif");
        }
    }
    public int getNbexemplaire(){
        return this.nbExemplaire;
    }
    public String getRefCatalogue(){
        return refCatalogue;
    }
}
