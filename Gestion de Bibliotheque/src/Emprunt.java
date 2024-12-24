import Document.Document;

import java.time.LocalDate;

public class Emprunt {
    private String idAdherant;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
    private Document doc;
    private StatutEmprunt statut;
    private static int codeEmp=1;
    private int codeaux=codeEmp;
    protected enum StatutEmprunt {
        EN_COURS, TERMINE
    }

    public Emprunt(String idAdherant, LocalDate dateEmprunt, LocalDate dateRetour, StatutEmprunt statut, Document doc) {
        this.idAdherant = idAdherant;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.statut = statut;
        this.doc = doc;
    }

    public String getIdAdherant() {
        return idAdherant;
    }

    public int getCodeaux() {
        return codeaux;
    }

    public int getCodeEmp() {
        return codeEmp;
    }

    public void setCodeEmp(int codeEmp) {
        this.codeEmp = codeEmp;
    }

    public Document getDoc() {
        return doc;
    }

    public void setIdAdherant(String idAdherant) {
        this.idAdherant = idAdherant;
    }

    public LocalDate getDateRetour() {
        return this.dateRetour;
    }
    public void setStatut(StatutEmprunt statut) {
        this.statut = statut;
    }

    public void afficheEmprunt() {
        System.out.println("------------------------------\nID de l'adhérant: " + this.idAdherant);
        System.out.println("Document : ");
        if (doc != null) {
            doc.afficheCaracDocumentAdh();
        }
        System.out.println("Code Emprunt : "+ this.codeaux);
        System.out.println("Date d'emprunt : " + dateEmprunt + "\nDate de retour: " + dateRetour);
        System.out.println("Statut : " + statut);
    }

    public String toString() {
        return "Emprunt{" +
                "idAdherant='" + idAdherant + '\'' +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetour=" + dateRetour +
                ", statut=" + statut +
                ", doc=" + doc +
                '}';

    }
}