package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur{
	
	private List<Carte> main;
	
	public MainJoueur() {
		this.main = new ArrayList<Carte>();
	}
	
	public void jouer(Carte carte) {
		main.remove(carte);
	}
	
	public void prendre(Carte carte) {
		assert main.contains(carte);
		main.add(carte);
	}

	@Override
	public String toString() {
		return "MainJoueur [main=" + main + "]";
	}

}
