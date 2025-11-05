package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {

	private Sabot sabot;
	
	public Jeu() {
        // Récupérer le tableau de cartes de la classe JeuDeCartes
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] tableauDeCartes = jeuDeCartes.donnerCartes();
        // Transformer le tableau en liste mutable (ArrayList)
        List<Carte> listeCartes = new ArrayList<>(Arrays.asList(tableauDeCartes));

        // Mélanger la liste
        listeCartes = GestionCartes.melanger(listeCartes);

        // Transformer la liste mélangée en tableau
        Carte[] tableauMelange = listeCartes.toArray(new Carte[0]);

        // Créer le sabot avec le tableau mélangé
        this.sabot = new Sabot(tableauMelange);
    }
}
