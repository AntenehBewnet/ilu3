package utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	
    public static <T> T extraire(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide.");
        }

        Random random = new Random();
        int index = random.nextInt(liste.size());

        return liste.remove(index);
    }

    // b. Version utilisant un ListIterator
    public static <T> T extraireAvecIterator(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste est vide.");
        }     
        Random random = new Random();
        int index = random.nextInt(liste.size());       
        ListIterator<T> iterator = liste.listIterator();
        T element = null;

        for (int i = 0; i <= index; i++) {
            element = iterator.next();
        }     
        iterator.remove();
        return element;
    }
    
    
    
    public static <T> List<T> melanger(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide.");
        }

   
        List<T> listeMelangee = new ArrayList<>();

        
        while (!liste.isEmpty()) {
            T element = extraire(liste);
            listeMelangee.add(element);
        }

        return listeMelangee;
    }
    public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
        
        if (liste1.size() != liste2.size()) {
            return false;
        }

        for (T element : liste1) {
            int frequencyListe1 = Collections.frequency(liste1, element);
            int frequencyListe2 = Collections.frequency(liste2, element);

            if (frequencyListe1 != frequencyListe2) {
                return false;
            }
        }
        return true;
    }
    public static <T> List<T> rassembler(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide.");
        }

        List<T> listeRassemblee = new ArrayList<>();
        List<T> elementsDejaTraites = new ArrayList<>(); 
  
        for (T element : liste) {
            if (!elementsDejaTraites.contains(element)) {
              
                for (T elem : liste) {
                    if (elem.equals(element)) {
                        listeRassemblee.add(elem);
                    }
                }
                elementsDejaTraites.add(element);
            }
        }

        return listeRassemblee;
    }
    
    /*
    public <T> void ajouterElementsEgaux(List<T> liste, T element) {
    	 for (T elem : liste) {
             if (elem.equals(element)) {
                 listeRassemblee.add(elem);
             }
         }
    }
    */
    
    
    
    public static <T> boolean verifierRassemblement(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide.");
        }

        // Utiliser un premier ListIterator pour parcourir la liste
        ListIterator<T> it1 = liste.listIterator();
        
        
        for (Iterator it3 = liste.iterator(); it3.hasNext();) {
			T currentValue = (T) it3.next();
			
			
		}
        
        
        
        
        
        
        

        while (it1.hasNext()) {
            T currentValue = it1.next();

            // Utiliser un second ListIterator pour parcourir le reste de la liste
            ListIterator<T> it2 = liste.listIterator(it1.nextIndex());

            while (it2.hasNext()) {
                T nextValue = it2.next();
                if (nextValue.equals(currentValue)) {
                    return false;
                }
            }
        }
        return true;
    }
}






