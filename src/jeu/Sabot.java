package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


import cartes.Carte;

public class Sabot implements Iterable<Carte>{

	private Carte[] cartes;
	private int nbCartes;
	private int nbrOpereation = 0;
	
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		nbCartes = cartes.length;
		
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
            throw new IllegalStateException("Capacite maximale du sabot atteinte");
        }
		cartes[nbCartes] = carte;
		nbCartes++;
	}


	@Override
	public Iterator<Carte> iterator() {
		return new SabotIterator();
	}
	
	
	
	private class SabotIterator implements Iterator<Carte>{
		private int curseur = 0;
		private boolean removable = true;
		private int nbrOperationRefference = nbrOpereation;

		@Override
		public boolean hasNext() {
			return curseur < nbCartes;
		}

		@Override
		public Carte next() {
			if (!hasNext()) {
				throw new NoSuchElementException("la liste est fini");
			}
			concurrentModification();
			removable = true;
			nbrOpereation++;
			nbrOperationRefference++;
			return cartes[curseur++];
		}
		
		@Override
		public void remove() {
			concurrentModification();
			if (!removable) {
				throw new IllegalStateException();
			}
			for (int i = curseur -1 ; i < nbCartes-1; i++) {
				cartes[i] = cartes[i+1];
			}
			curseur--;
			nbCartes--;
			nbrOpereation++;
			nbrOperationRefference++;
			removable = false;
			
		}
		
		public void concurrentModification() {
			if (nbrOpereation != nbrOperationRefference) {
				throw new ConcurrentModificationException("liste déja modifié");
			}
		}

	}
	
	
	
	public Carte piocher() {
		if (estVide()) {
            throw new NoSuchElementException("Le sabot est vide");
        }
		Iterator<Carte> it = iterator();
		Carte carte = it.next();
		it.remove();
		return carte;
	}
	
	
	

}
