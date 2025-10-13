package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


import cartes.Carte;

public class Sabot implements Iterable<Carte>{

	private Carte[] cartes;
	private int nbCartes;
	private int nbrOpereation;
	
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
		private int curseur;
		private boolean removable;
		private int nbrOperationRefference;
		
		public SabotIterator() {
			curseur = 0;
			removable = true;
			nbrOperationRefference = nbrOpereation;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curseur < nbCartes;
		}

		@Override
		public Carte next() {
			if (!hasNext()) {
				throw new NoSuchElementException("la liste est fini");
			}
			removable = true;
			return cartes[curseur++];
		}
		
		@Override
		public void remove() {
			if (nbrOpereation != nbrOperationRefference || !removable) {
				throw new ConcurrentModificationException("liste d�ja modifi�");
			}
			if (curseur == 0) {
				throw new NoSuchElementException("liste vide");
			}
			for (int i = curseur; i < nbCartes-1; i++) {
				cartes[i-1] = cartes[i];
			}
			nbCartes--;
			nbrOpereation++;
			nbrOperationRefference++;
			removable = false;
			
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
