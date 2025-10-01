package jeu;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


import cartes.Carte;

public class Sabot implements Iterable<Carte>{

	private Carte[] cartes;
	private int nbCartes;
	private int conccurentMod;
	
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		nbCartes = cartes.length;
		conccurentMod = 0;
		
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
            throw new IllegalStateException("Capacité maximale du sabot atteinte");
        }
		cartes[nbCartes] = carte;
		nbCartes++;
	}


	@Override
	public Iterator<Carte> iterator() {
		// TODO Auto-generated method stub
		return new SabotIterator();
	}
	
	
	
	private class SabotIterator implements Iterator<Carte>{
		private int curseur;
		private int conccurent;
		private boolean removable;
		
		public SabotIterator() {
			curseur = 0;
			conccurent = conccurentMod;
			removable = true;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curseur < nbCartes;
		}

		@Override
		public Carte next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (conccurent != conccurentMod) {
				throw new ConcurrentModificationException();
			}
			removable = true;
			return cartes[curseur++];
		}
		
		@Override
		public void remove() {
			if (conccurent != conccurentMod || !removable) {
				throw new ConcurrentModificationException();
			}
			if (curseur == 0) {
				throw new NoSuchElementException();
			}
			for (int i = curseur; i < nbCartes-1; i++) {
				cartes[i-1] = cartes[i];
			}
			nbCartes--;
			conccurent++;
			removable = false;
			
		}

	}
	
	
	
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte carte = it.next();
		it.remove();
		return carte;
	}
	
	
	

}
