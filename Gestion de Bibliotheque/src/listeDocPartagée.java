import Document.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listeDocPartagée {
    private static final List<Document> liste = new ArrayList<>();

    public static void ajouterElement(Document doc) {
        liste.add(doc);
    }
    public static void supprimerElement(Document doc){
        liste.remove(doc);
    }
    public static List<Document> getListeImmuable() {
        return Collections.unmodifiableList(liste);
    }

    public static void afficherListePartagee() {
        if (liste.isEmpty()) {
            System.out.println("Il n'y a aucun document actuellement");
        }
        else {
            System.out.println("Liste des documents:");
            for (Document doc : getListeImmuable()) {
                if (doc instanceof Livre){
                    System.out.println("Type: Livre");
                    doc.afficheCaracDocument();
                }
                if (doc instanceof Cd){
                    System.out.println("Type: Cd");
                    doc.afficheCaracDocument();
                }
                if (doc instanceof ThesePFE){
                    System.out.println("Type: Thèse PFE");
                    doc.afficheCaracDocument();
                }

            }
        }
    }
    public static void afficherListePartageeAdh() {
        if (liste.isEmpty()) {
            System.out.println("Il n'y a aucun document actuellement");
        }
        else {
            System.out.println("Liste des documents:");
            for (Document doc : getListeImmuable()) {
                if (doc instanceof Livre){
                    System.out.println("Type: Livre");
                    doc.afficheCaracDocumentAdh();
                }
                if (doc instanceof Cd){
                    System.out.println("Type: Cd");
                    doc.afficheCaracDocumentAdh();
                }
                if (doc instanceof ThesePFE){
                    System.out.println("Type: Thèse PFE");
                    doc.afficheCaracDocumentAdh();
                }

            }
        }
    }
}
