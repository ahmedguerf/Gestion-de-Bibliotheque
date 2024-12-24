import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listeEmpPartagée {
    private static final List<Emprunt> liste = new ArrayList<>();

    public static void ajouterElement(Emprunt emp) {
        liste.add(emp);
    }
    public static List<Emprunt> getListeImmuable() {
        return Collections.unmodifiableList(liste);
    }
    public static void afficherListeEmprunts() {
        if (liste.isEmpty())
        {
            System.out.println("Il n'y a aucun emprunt pour le moment");
        }
        else
        {
            System.out.println("Liste des emprunts:");
            for (Emprunt emp : liste) {
                emp.afficheEmprunt();
            }
        }
    }
}
