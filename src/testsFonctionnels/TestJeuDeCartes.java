package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		//System.out.println(jeu.affichageJeuDeCartes());
		System.out.println(jeu.donnerCartes());
		for (Carte c : jeu.donnerCartes()) {
			System.out.println(c);
		}

	}

}
