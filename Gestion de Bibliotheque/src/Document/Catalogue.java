package Document;

import java.util.ArrayList;

public class Catalogue {
    private String libelle;
    private String ref;
    private int nbDoc = 0;
    private ArrayList<Document> docs = new ArrayList<>();

    public Catalogue(String libelle, String ref) {
        this.libelle = libelle;
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setLibelle(String lib) {
        this.libelle = lib;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }


    public void afficheCaracCatalogueRef(String ref) {
        System.out.printf("Libellé : %s\nRéférence : %s\nNombre de document : %d\n", this.libelle, this.ref, this.nbDoc);
        if (docs.isEmpty()) {
            System.out.println("Aucun document dans ce catalogue");
        } else {
            for (int i = 0; i < docs.size(); i++) {
                if (docs.get(i).getRefCatalogue().equals(ref)) {
                    System.out.println("\nDocument n°" + (i + 1) + ":");
                    docs.get(i).afficheCaracDocument();
                }
            }
        }
    }
    public void afficheCaracCatalogue(){
        System.out.printf("----------------------\nLibellé : %s\nRéférence : %s\nNombre de document : %d\n----------------------\n", this.libelle, this.ref, this.nbDoc);
    }

        public void ajouterDocumentACatalogue(Document doc){
            if (doc != null) {
                this.docs.add(doc);
                this.nbDoc++;
                System.out.println("Document ajouté au catalogue : " + this.libelle);
            } else {
                System.out.println("Document invalide, l'ajout a échoué.");
            }
        }
}

