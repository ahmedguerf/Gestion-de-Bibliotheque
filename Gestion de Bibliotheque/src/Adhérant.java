import Document.Document;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;


public class Adhérant {
    private String nom;
    private String prenom;
    private String id;
    private Emprunt[] empsadh = new Emprunt[3];

    public Adhérant(String nom, String prenom, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }

    private LocalDate saisirDateRetour() {
        Scanner x = new Scanner(System.in);
        LocalDate dateRetour = null;
        boolean valide = false;
        while (valide == false) {
            try {
                String dateRetour_ch = x.nextLine();
                DateTimeFormatter formatadequat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dateRetour = LocalDate.parse(dateRetour_ch, formatadequat);
                valide = true;
            } catch (DateTimeParseException e) {
                System.out.println("Date invalide, la format requise est: dd-mm-yyyy");
            }
        }
        return dateRetour;
    }

    public Emprunt[] getEmpsadh() {
        return empsadh;
    }

    public void emprunterDocument(Document doc) {
        if (empruntPossible(doc)) {
            LocalDate dateEmprunt = LocalDate.now();
            System.out.print("Saisir la date de retour de cette format (dd-MM-yyyy) : ");
            LocalDate dateRetour = saisirDateRetour();
            if (dateRetour.isBefore(dateEmprunt)) {
                System.out.println("La date de retour doit être après la date d'emprunt.");
                System.out.print("Saisir la date de retour de cette format (dd-MM-yyyy) : ");
                return;
            }
            Emprunt p = new Emprunt(this.id, dateEmprunt, dateRetour, Emprunt.StatutEmprunt.EN_COURS, doc);
            listeEmpPartagée.ajouterElement(p);
            p.setCodeEmp(p.getCodeEmp() + 1);
            doc.setNbExemplaire(doc.getNbexemplaire() - 1);
            for (int i = 0; i < empsadh.length; i++) {
                if (empsadh[i] == null) {
                    empsadh[i] = p;
                    break;
                }
            }
            System.out.println("Emprunt réalisé avec succès");
        }
    }

    private boolean empruntPossible(Document doc) {
        int k=0;
        for (int i = 0; i < empsadh.length; i++) {
            if (empsadh[i] != null && empsadh[i].getDoc() == doc) {
                System.out.println("Vous avez déjà emprunté ce document.");
                return false;
            }
            if (empsadh[i] != null) k++;
        }
        if (k ==3){
            System.out.println("Vous avez atteint le nombre maximal d'emprunts autorisés");
            return false;
        }
        return doc.getNbexemplaire() > 0;
    }


    public Document rechercheDocument(String titre) {
        titre = titre.toLowerCase().trim();
        for (int i = 0; i < listeDocPartagée.getListeImmuable().size(); i++) {
            Document docaux = listeDocPartagée.getListeImmuable().get(i);
            String titreaux = docaux.getTitre().toLowerCase().trim();
            if (titreaux.equals(titre))
                return docaux;
        }
        return null;
    }

    public void cloturerEmprunt(int codeEmp) {
        for (int i = 0; i < empsadh.length; i++) {
            if (empsadh[i] != null && empsadh[i].getCodeaux() == codeEmp) {
                empsadh[i].getDoc().setNbExemplaire(empsadh[i].getDoc().getNbexemplaire() + 1);
                System.out.println("Document retourné, nombre d'exemplaires mis à jour.");

                empsadh[i] = null;
                Emprunt p = rechercheEmprunt(codeEmp);
                if (p != null){
                    p.setStatut(Emprunt.StatutEmprunt.TERMINE);
                    System.out.println("Emprunt cloturé avec succés\n");
                    break;
                }
                else {
                    System.out.println("L'emprunt n'éxiste pas..");
                }
            }
        }
    }



    private Emprunt rechercheEmprunt(int codeEmp) {
        if (listeEmpPartagée.getListeImmuable().isEmpty()) {
            return null;
        }
        for (int i = 0; i < listeEmpPartagée.getListeImmuable().size(); i++) {
            if (listeEmpPartagée.getListeImmuable().get(i).getCodeaux() == codeEmp) {
                return listeEmpPartagée.getListeImmuable().get(i);
            }
        }
        return null;
    }


    public void afficheEmpruntEnCours(){
        int k=0;
        for (int i = 0; i < empsadh.length; i++) {
            if (empsadh[i] != null){
                empsadh[i].afficheEmprunt();
            }
            if (empsadh[i] == null){
                k++;
            }
        }
        if (k==3) System.out.println("Vous n'avez aucun emprunt pour le moment..");
    }
    private boolean verifRetardSeulEmprunt(Emprunt p) {
        LocalDate dateActuelle = LocalDate.now();
        long retard=ChronoUnit.DAYS.between(dateActuelle, p.getDateRetour());
        return retard<0;
    }

    // A verifier nrmlment cbn
    public void verifRetard(){
        int ret=0;
        for(int i=0; i<3; i++){
            if(empsadh[i] != null && verifRetardSeulEmprunt(empsadh[i])){
                System.out.println("Emprunt n°"+(empsadh[i].getCodeEmp())+" est en retard");
                empsadh[i].afficheEmprunt();
                ret++;
            }
        }
        if (ret == 0){
            System.out.println("Vous n'avez aucun document en retard ..");
        } else {
            System.out.printf("Vous avez %d documents en retard..", ret);
        }
    }
    public void afficheInfosAdherent() {
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("ID: " + id);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
