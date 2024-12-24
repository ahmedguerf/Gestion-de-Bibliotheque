import Document.*;

import java.util.Scanner;

public class BibliothequeApp {
    public static void main(String[] args) {
        Bibliothécaire bibliothécaire = new Bibliothécaire("Ahmed", "system");


        Scanner scanner = new Scanner(System.in);
        String password;
        // Menu principal
        while (true) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("Accéder en tant que : ");
            System.out.println("1. Adhérent");
            System.out.println("2. Bibliothécaire");

            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choix == 1) {
                // Menu adhérent
                boolean adhbool = true;
                while (adhbool == true){
                    menuAdherant(adhbool, bibliothécaire);
                    break;
                }

            } else if (choix == 2) {
                // Demander le mot de passe pour bibliothécaire
                System.out.print("Entrez le mot de passe du bibliothécaire : ");
                password = scanner.nextLine();
                boolean biblio = true;
                if ("system".equals(password)) {
                    while (biblio == true){
                        menuBibliothecaire(biblio);
                        break;
                    }
                } else {
                    System.out.println("Mot de passe incorrect. Accès refusé.");
                }
            } else if (choix == 0) {
                System.out.println("Au revoir!");
                break;
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }

    // Menu pour les bibliothécaires
    public static void menuBibliothecaire(boolean biblio) {
        Bibliothécaire bibliothécaire = new Bibliothécaire("Ahmed", "system");
        Scanner z = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== GESTION DE BIBLIOTHEQUE ===");
            System.out.println("1. Ajouter un nouveau document");
            System.out.println("2. Modifier un document");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Ajouter un nouveau catalogue");
            System.out.println("5. Modifier un catalogue");
            System.out.println("6. Supprimer un catalogue");
            System.out.println("7. Afficher la liste de document dans un catalogue");
            System.out.println("8. Afficher tout les catalogues");
            System.out.println("9. Afficher tout les documents disponibles");
            System.out.println("10. Afficher les emprunts");

            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choix = z.nextInt();
            z.nextLine(); // Consume the newline character

            switch (choix) {
                case 1:
                    System.out.println("Entrez les informations du nouveau document...");
                    System.out.println("Quel type de document vous souhaitez ajouter?");
                    menuAjouterDoc(bibliothécaire);
                    break;
                case 2:
                    System.out.println("Quel type de document souhaitez-vous modifier?");
                    menumodifierDoc(bibliothécaire);
                    break;
                case 3:
                    if (listeDocPartagée.getListeImmuable().size() == 0) {
                        System.out.println("La liste est actuellemnt vide...");
                    } else {
                        System.out.print("Quel document souhaitez-vous supprimer? \nVeuillez saisir le titre: ");
                        String titreaux = z.nextLine();
                        if (titreaux == null){
                            System.out.println("Titre invalide, vous devez saisir un..");
                        }else {
                            bibliothécaire.supprimerDocument(bibliothécaire.rechercheDocumentTitre(titreaux.toLowerCase().trim()));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Entrez les informations du nouveau catalogue...");
                    System.out.print("Libellé du catalogue : ");
                    String libelle = z.nextLine();
                    System.out.print("Référence du catalogue : ");
                    String ref = z.nextLine();
                    Catalogue catal = new Catalogue(libelle, ref);
                    bibliothécaire.ajouteCatalogue(catal);
                    break;
                case 5:
                    if (bibliothécaire.verifCatal()){
                        System.out.println("Il n'y a aucun catalogue pour le moment..");
                    }
                    else {
                        System.out.println("Entrez les informations à modifier du catalogue...");
                        System.out.println("Entrez la référence du catalogue à modifier : ");
                        String nref = z.nextLine();
                        bibliothécaire.modifierCaracCatalogue(nref);
                    }
                    break;
                case 6:
                    if (bibliothécaire.verifCatal()){
                        System.out.println("Il n'y a aucun catalogue pour le moment..");

                    }
                    else {
                        System.out.println("Entrez la référence du catalogue à supprimer : ");
                        String nref1 = z.nextLine();
                        bibliothécaire.supprimerCatalogue(bibliothécaire.rechercheCatalogueCatal(nref1));
                    }
                    break;
                case 7:
                    if (bibliothécaire.verifCatal()){
                        System.out.println("Il n'y a aucun catalogue pour le moment..");
                    }
                    else {
                        System.out.println("Choisir la référence du catalogue : ");
                        String nref2 = z.nextLine();
                        System.out.println("La liste des documents dans le catalogue " + nref2 + " : ");
                        Catalogue catalaux = bibliothécaire.rechercheCatalogueCatal(nref2);
                        catalaux.afficheCaracCatalogueRef(nref2);
                    }
                    break;
                case 8:
                    if (bibliothécaire.verifCatal()){
                        System.out.println("Il n'y a aucun catalogue pour le moment..");

                    } else {
                        bibliothécaire.afficheListeCatalogue();
                    }
                    break;
                case 9:
                    System.out.println("Voici la liste de tout les documents disponibles...");
                    listeDocPartagée.afficherListePartagee();
                    break;
                case 10:
                    System.out.println("Voici la liste des emprunts en cours...");
                    bibliothécaire.afficherEmprunts();
                    break;
                case 0:
                    biblio = false;
                    System.out.println("Au revoir ! ");
                    System.out.println();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void menuAjouterDoc(Bibliothécaire bibliothecaire) {
        Scanner y = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== TYPE DE DOCUMENT ===");
            System.out.println("1. Livre");
            System.out.println("2. CD");
            System.out.println("3. Thèse de PFE");
            System.out.println("0. Retour au menu principal");
            System.out.print("Votre choix : ");
            int choix = y.nextInt();
            y.nextLine();

            switch (choix) {
                case 1:
                    // Ajout d'un Livre
                    System.out.print("Titre : ");
                    String titreLivre = y.nextLine();
                    System.out.print("Auteur : ");
                    String auteurLivre = y.nextLine();
                    System.out.print("Nombre d'exemplaires : ");
                    int nbExemplairesLivre = y.nextInt();
                    y.nextLine();
                    System.out.print("ISBN : ");
                    String isbn = y.nextLine();
                    System.out.print("Référence du catalogue (laisser vide si non classé) : ");
                    String refCatalogueLivre = y.nextLine();
                    if (refCatalogueLivre.isEmpty()) refCatalogueLivre = null;
                    else if (bibliothecaire.rechercheCatalogueCatal(refCatalogueLivre) == null) {
                        refCatalogueLivre = null;
                        System.out.println("Le catalogue n'existe pas, le document sera non classé..");
                    }
                    Livre livre = new Livre(titreLivre, auteurLivre, nbExemplairesLivre, isbn);
                    livre.setRefCatalogue(refCatalogueLivre);

                    bibliothecaire.ajouterDocument(livre);
                    break;

                case 2:
                    // Ajout d'un CD
                    System.out.print("Titre : ");
                    String titreCD = y.nextLine();
                    System.out.print("Auteur : ");
                    String auteurCD = y.nextLine();
                    System.out.print("Nombre d'exemplaires : ");
                    int nbExemplairesCD = y.nextInt();
                    y.nextLine();
                    System.out.print("Durée (format mm:ss) : ");
                    String duree = y.nextLine();
                    System.out.print("Sujet : ");
                    String sujet = y.nextLine();
                    System.out.print("Référence du catalogue (laisser vide si non classé) : ");
                    String refCatalogueCD = y.nextLine();
                    if (refCatalogueCD.isEmpty()) refCatalogueCD = null;

                    Cd cd = new Cd(titreCD, auteurCD, nbExemplairesCD, refCatalogueCD,duree, sujet);
                    cd.setRefCatalogue(refCatalogueCD);
                    bibliothecaire.ajouterDocument(cd);
                    break;

                case 3:
                    // Ajout d'une Thèse de PFE
                    System.out.print("Titre : ");
                    String titreThese = y.nextLine();
                    System.out.print("Auteur : ");
                    String auteurThese = y.nextLine();
                    System.out.print("Nombre d'exemplaires : ");
                    int nbExemplairesThese = y.nextInt();
                    y.nextLine();
                    System.out.print("Université : ");
                    String universite = y.nextLine();
                    System.out.print("Encadrant : ");
                    String encadrant = y.nextLine();
                    System.out.print("Référence du catalogue (laisser vide si non classé) : ");
                    String refCatalogueThese = y.nextLine();
                    if (refCatalogueThese.isEmpty()) refCatalogueThese = null;

                    ThesePFE thesePFE = new ThesePFE(titreThese, auteurThese, nbExemplairesThese, refCatalogueThese,universite, encadrant);
                    thesePFE.setRefCatalogue(refCatalogueThese);
                    bibliothecaire.ajouterDocument(thesePFE);
                    break;

                case 0:
                    // Quitter le menu
                    System.out.println("Retour au menu principal.");
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void menumodifierDoc(Bibliothécaire bibliothecaire) {
        Scanner y = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MODIFIER UN DOCUMENT ===");
            System.out.println("1. Livre");
            System.out.println("2. CD");
            System.out.println("3. Thèse de PFE");
            System.out.println("0. Retour au menu principal");
            System.out.print("Votre choix : ");
            int choix = y.nextInt();
            y.nextLine(); // Consommer le caractère de nouvelle ligne

            switch (choix) {
                case 1:
                    // Modification d'un Livre
                    System.out.print("Entrez le titre du livre à modifier : ");
                    String titre = y.nextLine();
                    Document doc = bibliothecaire.rechercheDocumentTitre(titre);
                    if (doc == null) {
                        System.out.println("Aucun document trouvé avec ce titre.");
                        break;
                    }
                    else{
                        if (doc instanceof Livre) {
                            Livre livre = (Livre) doc;

                            System.out.println("Livre trouvé : " + livre.getTitre());
                            System.out.println("Modifier les informations (laisser vide pour conserver la valeur actuelle) :");

                            System.out.print("Nouveau titre : ");
                            String nouveauTitre = y.nextLine();
                            if (!nouveauTitre.isEmpty()) livre.setTitre(nouveauTitre);

                            System.out.print("Nouvel auteur : ");
                            String nouvelAuteur = y.nextLine();
                            if (!nouvelAuteur.isEmpty()) livre.setAuteur(nouvelAuteur);

                            System.out.print("Nouveau nombre d'exemplaires : ");
                            String nbExemplairesInput = y.nextLine();
                            if (!nbExemplairesInput.isEmpty()) {
                                int nbExemplaire = Integer.parseInt(nbExemplairesInput);
                                livre.setNbExemplaire(nbExemplaire);
                            }

                            System.out.print("Nouvelle référence catalogue : ");
                            String nouveauRef = y.nextLine();
                            if (!nouveauRef.isEmpty()) {
                                livre.setRefCatalogue(nouveauRef);
                                Catalogue catalaux = bibliothecaire.rechercheCatalogueCatal(nouveauRef);
                                catalaux.ajouterDocumentACatalogue(doc);
                            }

                            System.out.println("Modification effectuée avec succès !");
                            break;
                        }
                    }

                case 2:
                    // Modification d'un CD

                    System.out.print("Entrez le titre du Cd à modifier : ");
                    String titre2 = y.nextLine();
                    Document doc1 = bibliothecaire.rechercheDocumentTitre(titre2);
                    if (doc1 == null) {
                        System.out.println("Aucun document trouvé avec ce titre.");
                        break;
                    }else{
                        if (doc1 instanceof Cd) {
                            Cd cd = (Cd) doc1;

                            System.out.println("CD trouvé : " + cd.getTitre());
                            System.out.println("Modifier les informations (laisser vide pour conserver la valeur actuelle) :");

                            System.out.print("Nouveau titre : ");
                            String nouveauTitreCD = y.nextLine();
                            if (!nouveauTitreCD.isEmpty()) cd.setTitre(nouveauTitreCD);

                            System.out.print("Nouvel auteur : ");
                            String nouvelAuteurCD = y.nextLine();
                            if (!nouvelAuteurCD.isEmpty()) cd.setAuteur(nouvelAuteurCD);

                            System.out.print("Nouvelle durée : ");
                            String nouvelleDuree = y.nextLine();
                            if (!nouvelleDuree.isEmpty()) cd.setDuree(nouvelleDuree);

                            System.out.print("Nouveau sujet : ");
                            String nouveauSujet = y.nextLine();
                            if (!nouveauSujet.isEmpty()) cd.setSujet(nouveauSujet);

                            System.out.print("Nouvelle référence : ");
                            String nouveauRef = y.nextLine();
                            if (!nouveauRef.isEmpty()) {
                                cd.setRefCatalogue(nouveauRef);
                                Catalogue catalaux = bibliothecaire.rechercheCatalogueCatal(nouveauRef);
                                catalaux.ajouterDocumentACatalogue(doc1);
                            }

                            System.out.println("Modification effectuée avec succès !");
                        }
                        break;
                    }
                case 3:
                    System.out.print("Entrez le titre de la thèse PFE à modifier : ");
                    String titre3 = y.nextLine();
                    Document doc3 = bibliothecaire.rechercheDocumentTitre(titre3);
                    if (doc3 == null) {
                        System.out.println("Aucun document trouvé avec ce titre.");
                        break;
                    }else {
                        if (doc3 instanceof ThesePFE) {
                            ThesePFE these = (ThesePFE) doc3;
                            System.out.println("Thèse trouvée : " + these.getTitre());
                            System.out.println("Modifier les informations (laisser vide pour conserver la valeur actuelle) :");

                            System.out.print("Nouveau titre : ");
                            String nouveauTitreThese = y.nextLine();
                            if (!nouveauTitreThese.isEmpty()) these.setTitre(nouveauTitreThese);

                            System.out.print("Nouvel auteur : ");
                            String nouvelAuteurThese = y.nextLine();
                            if (!nouvelAuteurThese.isEmpty()) these.setAuteur(nouvelAuteurThese);

                            System.out.print("Nouvelle université : ");
                            String nouvelleUniversite = y.nextLine();
                            if (!nouvelleUniversite.isEmpty()) these.setUniversite(nouvelleUniversite);

                            System.out.print("Nouvel encadrant : ");
                            String nouvelEncadrant = y.nextLine();
                            if (!nouvelEncadrant.isEmpty()) these.setEncadrant(nouvelEncadrant);

                            System.out.print("Nouvelle référence : ");
                            String nouveauRef = y.nextLine();
                            if (!nouveauRef.isEmpty()) {
                                these.setRefCatalogue(nouveauRef);
                                Catalogue catalaux = bibliothecaire.rechercheCatalogueCatal(nouveauRef);
                                catalaux.ajouterDocumentACatalogue(doc3);
                            }

                            System.out.println("Modification effectuée avec succès !");
                        }
                        break;
                    }
                case 0:
                    System.out.println("Retour au menu principal.");
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    // Menu pour les adhérents
    public static void menuAdherant(boolean adh, Bibliothécaire bibliothécaire) {
        Scanner v = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== ESPACE ADHÉRENT ===");
            System.out.println("1. Consulter les documents disponibles");
            System.out.println("1. Consulter les catalogues disponibles");
            System.out.println("3. Emprunter un document");
            System.out.println("4. Retourner un document");
            System.out.println("5. Voir les emprunts en cours");
            System.out.println("6. Voir les emprunts en retard");
            System.out.println("7. Modifier informations personnelles");

            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choix = v.nextInt();
            v.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Voici la liste des documents disponibles..");
                    listeDocPartagée.afficherListePartageeAdh();
                    break;
                case 2:
                    System.out.println("Voici la liste des catalogues disponibles..");
                    bibliothécaire.afficheListeCatalogue();
                case 3:
                    if (listeDocPartagée.getListeImmuable().isEmpty()){
                        System.out.println("Aucun document n'est disponible pour le moment");
                        break;
                    }
                    else {
                        System.out.println("Veuillez entrer vos informations attentivement..");
                        System.out.print("Nom : ");
                        String nom = v.nextLine();
                        System.out.print("Prénom : ");
                        String prenom = v.nextLine();
                        System.out.print("ID : ");
                        String id1 = v.nextLine();
                        Adhérant adh1 = new Adhérant(nom, prenom, id1);
                        //Vérification si l'adhérant existe cbn
                        System.out.println("Quel document souhaitez-vous emprunter?");
                        menuEmprunterDoc(adh1, bibliothécaire);
                        break;
                    }
                case 4:
                    //Code de l'emprunt
                    System.out.print("Veuillez saisir le code de votre emprunt : ");
                    int codeEmp = v.nextInt();
                    Adhérant adh2 = bibliothécaire.rechercheAdherantCodeEmp(codeEmp);
                    if (adh2 == null){
                        System.out.println("L'emprunt n'éxiste pas");
                    }
                    else{
                        adh2.cloturerEmprunt(codeEmp);
                    }
                    break;
                case 5:
                    System.out.print("Veuillez saisir votre identifiant : ");
                    String id2 = v.nextLine();
                    Adhérant adh3 = bibliothécaire.rechercheAdherant(id2);
                    if (adh3 == null){
                        System.out.println("Vous n'avez fait aucun emprunt");
                    }
                    else {
                        System.out.println("Vos emprunts en cours ..");
                        adh3.afficheEmpruntEnCours();
                    }
                    break;
                case 6:
                    System.out.print("Veuillez saisir votre identifiant : ");
                    String id3 = v.nextLine();
                    Adhérant adh4 = bibliothécaire.rechercheAdherant(id3);
                    if (adh4 == null){
                        System.out.println("Vous n'avez fait aucun emprunt");
                    }
                    else {
                        adh4.verifRetard();
                    }
                    break;
                case 7:
                    System.out.print("Veuillez saisir votre identifiant : ");
                    String id4 = v.nextLine();
                    Adhérant adh5 = bibliothécaire.rechercheAdherant(id4);
                    if (adh5 == null){
                        System.out.println("Vous n'avez fait aucun emprunt");
                    }
                    else{
                        System.out.println("Voici vos informations actuelles : ");
                        adh5.afficheInfosAdherent();
                        bibliothécaire.modifierInfosAdherant(adh5);
                        System.out.println("Vos nouveaux informations sont biens enregistrés..");
                    }
                    break;
                case 0:
                    System.out.println("Retour au menu principal.\n");
                    adh = false;
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void menuEmprunterDoc(Adhérant adh, Bibliothécaire biblio) {
        Scanner v = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== EMPRUNTER UN DOCUMENT ===");
            System.out.println("1. Livre");
            System.out.println("2. CD");
            System.out.println("3. Thèse de PFE");
            System.out.println("0. Retour au menu principal");
            System.out.print("Votre choix : ");
            int choix = v.nextInt();
            v.nextLine();

            switch (choix) {
                case 1:
                    // Emprunter un Livre
                    System.out.print("Entrez le titre du livre : ");
                    String titreLivre = v.nextLine();
                    Document doc1 = adh.rechercheDocument(titreLivre);
                    if ((!(doc1 instanceof Livre))|| doc1 == null){
                        System.out.println("Désolé, le livre souhaité n'existe pas..");
                    }
                    else{
                        System.out.println("Livre "+adh.rechercheDocument(titreLivre).getTitre()+" trouvé..");
                        if(biblio.rechercheAdherant(adh.getId()) == null){
                            biblio.ajouteAdherant(adh);
                        }
                        adh.emprunterDocument(doc1);
                    }
                    break;
                case 2:
                    System.out.print("Entrez le titre du Cd : ");
                    String titreCd = v.nextLine();
                    Document doc2 = adh.rechercheDocument(titreCd.toLowerCase().trim());
                    if ((!(doc2 instanceof Cd))|| doc2 == null){
                        System.out.println("Désolé, le CD souhaité n'existe pas..");
                    }
                    else{
                        System.out.println("Cd "+adh.rechercheDocument(titreCd).getTitre()+" trouvé..");
                        if(biblio.rechercheAdherant(adh.getId()) != null){
                            adh.emprunterDocument(doc2);
                        }
                        else {
                            biblio.ajouteAdherant(adh);
                            adh.emprunterDocument(doc2);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Entrez le titre du Cd : ");
                    String titreThese = v.nextLine();
                    Document doc3 = adh.rechercheDocument(titreThese.toLowerCase().trim());
                    if ((!(doc3 instanceof ThesePFE)|| doc3 == null)){
                        System.out.println("Désolé, le CD souhaité n'existe pas..");
                    }
                    if(biblio.rechercheAdherant(adh.getId()) != null){
                        adh.emprunterDocument(doc3);
                    }
                    else {
                        System.out.println("Thèse "+adh.rechercheDocument(titreThese).getTitre()+" trouvé..");
                        biblio.ajouteAdherant(adh);
                        adh.emprunterDocument(doc3);
                    }
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

            }
        }
}
