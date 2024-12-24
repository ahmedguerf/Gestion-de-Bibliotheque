import Document.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Bibliothécaire {
    private String nomUtil;
    private String mdp;
    private ArrayList<Catalogue> catals = new ArrayList<>(); //Pour tout les catalogues
    private ArrayList<Adhérant> adherants = new ArrayList<>();

    public Bibliothécaire(String nomUtil, String mdp) {
        this.nomUtil = nomUtil;
        this.mdp = mdp;
    }

    public boolean verifCatal(){
        return catals.isEmpty();
    }

    public void ajouteAdherant(Adhérant adh){
        adherants.add(adh);
    }

    public Adhérant rechercheAdherantCodeEmp(int CodeEmp) {
        for (int i = 0; i < adherants.size(); i++) {
            Adhérant adhaux = adherants.get(i);
            for (int j = 0; j < adhaux.getEmpsadh().length; j++) {
                if (adhaux.getEmpsadh()[j] != null && adhaux.getEmpsadh()[j].getCodeaux() == CodeEmp) {
                    return adhaux;
                }
            }
        }
        return null;
    }

    public Adhérant rechercheAdherant(String Id){
        for (int i = 0; i < adherants.size(); i++) {
            if (adherants.get(i).getId().equals(Id)){
                return adherants.get(i);
            }
        }
        return null;
    }

    public void ajouterDocument(Document doc) {
        if (rechercheDocumentTitre(doc.getTitre())==null) {
            listeDocPartagée.ajouterElement(doc);
            int pos = rechercheCatalogue((doc.getRefCatalogue()));
            if (doc.getRefCatalogue() != null) {
                if (pos != -1) {
                    Catalogue catalcible = catals.get(pos);
                    catalcible.ajouterDocumentACatalogue(doc);
                }
                else
                {
                    System.out.println("Référence de catalogue invalide, si vous voulez, vous pouvez créer un nouveau catalogue.");
                }

            }
            else System.out.println("Document ajouté avec succés");
        }
        else
        {
            Document docaux = rechercheDocumentTitre(doc.getTitre());
            docaux.setNbExemplaire(docaux.getNbexemplaire() + doc.getNbexemplaire());
            System.out.println("Le document existe, le nombre d'exemplaire maintenant est:" + docaux.getNbexemplaire());

        }
    }

    public Document rechercheDocumentTitre(String titre) {
        //Recherche par titre
        titre=titre.toLowerCase().trim();
        for (int i = 0; i < listeDocPartagée.getListeImmuable().size(); i++) {
            Document docaux=listeDocPartagée.getListeImmuable().get(i);
            String titreaux=docaux.getTitre().toLowerCase().trim();
            if (titreaux.equals(titre))
                return docaux;
        }
        return null;
    }

    public void supprimerDocument(Document doc) {
        if (rechercheDocumentTitre(doc.getTitre().toLowerCase().trim()) != null) {
            listeDocPartagée.supprimerElement(doc);
            System.out.println("Document supprimé avec succès.");
        } else {
            System.out.println("Le document n'existe pas.");
        }

    }

    public int rechercheCatalogue(String ref) {
        for (int i = 0; i < catals.size(); i++) {
            Catalogue catalaux = catals.get(i);
            String refaux = catalaux.getRef();
            if (refaux.equals(ref))
                return i;
        }
        return -1;
    }

    public void modifierInfosAdherant(Adhérant adh) {
        Scanner x = new Scanner(System.in);
        System.out.println("Modifier les informations (laisser vide pour conserver la valeur actuelle) :");
        System.out.print("Modifier nom : ");
        String nouveauNom = x.nextLine();
        if (!nouveauNom.isEmpty()) adh.setNom(nouveauNom);

        System.out.print("Modifier prénom : ");
        String nouveauPrenom = x.nextLine();
        if (!nouveauPrenom.isEmpty()) adh.setPrenom(nouveauPrenom);

        System.out.print("Modifier ID : ");
        String nouveauId = x.nextLine();
        if (!nouveauId.isEmpty()) {
            for (int i = 0; i < listeEmpPartagée.getListeImmuable().size(); i++) {
                if (listeEmpPartagée.getListeImmuable().get(i).getIdAdherant().equals(adh.getId())){
                    adh.setId(nouveauId);
                }
            }
            for (int i = 0; i < adh.getEmpsadh().length; i++) {
                if (adh.getEmpsadh()[i] != null) {
                    adh.getEmpsadh()[i].setIdAdherant(nouveauId);
                }
            }
            adh.setId(nouveauId);
        }
    }

    public Catalogue rechercheCatalogueCatal(String ref) {
        for (int i = 0; i < catals.size(); i++) {
            Catalogue catalaux = catals.get(i);
            String refaux = catalaux.getRef();
            if (refaux.equals(ref))
                return catalaux;
        }
        return null;
    }

    public void ajouteCatalogue(Catalogue catal) {
        if (rechercheCatalogue(catal.getRef())==-1) {
            catals.add(catal);
            System.out.println("Catalogue ajouté avec succès.");
        }
        else
        {
            System.out.println("Le catalogue existe déjà.");
        }
    }
    public void supprimerCatalogue(Catalogue catal){
            if (catals.contains(catal)) {
                for (Document doc : listeDocPartagée.getListeImmuable()) {
                    if (catal.getRef().equals(doc.getRefCatalogue())) {
                        doc.setRefCatalogue(null);
                    }
                }
                catals.remove(catal);
                System.out.println("Catalogue supprimé avec succès.");
            }
            else
            {
                System.out.println("Le catalogue n'existe pas.");
            }

    }
    public void afficheListeCatalogue(){
            for (int i = 0; i < catals.size(); i++) {
                catals.get(i).afficheCaracCatalogue();
            }
        }

    public void afficherEmprunts(){
        listeEmpPartagée.afficherListeEmprunts();
    }



    public void modifierCaracCatalogue(String refCatal) {
            int indexCatal = rechercheCatalogue(refCatal);
            if (indexCatal == -1) {
                System.out.println("Le catalogue n'existe pas");
            } else {
                Scanner x = new Scanner(System.in);
                boolean ok = true;
                while (ok){
                    System.out.println("\n--- Modifier les caractéristiques du catalogue ---");
                    System.out.println("1. Modifier le libellé");
                    System.out.println("2. Modifier la référence");
                    System.out.println("0. Quitter");
                    System.out.print("Votre choix : ");

                    int choix = x.nextInt();
                    x.nextLine();
                    switch (choix) {
                        case 1:
                            System.out.print("\nNouveau libellé: ");
                            String nlib = x.nextLine();
                            catals.get(indexCatal).setLibelle(nlib);
                            System.out.println("Libellé modifié avec succès");
                            break;

                        case 2:
                            System.out.print("\nNouvelle référence: ");
                            String nref = x.nextLine();
                            if(rechercheCatalogue(nref)!=-1){
                                System.out.println("Le catalogue existe déjà");
                            }
                            else {
                                //Changement des documents aussi de ce Catalogue
                                for (Document doc : listeDocPartagée.getListeImmuable()) {
                                    if (refCatal.equals(doc.getRefCatalogue())) {
                                        doc.setRefCatalogue(nref);
                                    }
                                }
                                catals.get(indexCatal).setRef(nref);
                                System.out.println("Référence modifiée avec succès.");
                            }
                            break;
                        case 0:
                            System.out.println("\nModification terminée.");
                            ok = false;
                            break;

                        default:
                            System.out.println("\nChoix invalide, veuillez réessayer.");
                    }
                }
            }

    }

}

