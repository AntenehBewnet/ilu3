package jeu;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;

public class MainJoueur{
	
	private List<Carte> main = new LinkedList<Carte>();

	
	public void jouer(Carte carte) {
		main.remove(carte);
	}
	
	public void prendre(Carte carte) {
		assert main.contains(carte);
		main.add(0,carte);
	}

	@Override
	public String toString() {
		return "MainJoueur [main=" + main + "]";
	}

}
