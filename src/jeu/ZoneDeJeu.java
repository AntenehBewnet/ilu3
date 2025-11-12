package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {

	private List<Carte> pileLimiteVitesse= new LinkedList<>();
	private List<Carte> pileDeBataille= new LinkedList<>();
	private Set<Carte> collectiondeBornes = new HashSet<>();


	public void deposer(Carte c) {
		if (c instanceof Borne) {
			collectiondeBornes.add(c);
		} else if (c instanceof Bataille) {
			pileDeBataille.add(0, c);
		} else if (c instanceof Limite) {
			pileLimiteVitesse.add(0, c);
		}
	}

	public int donnerLimitationVitesse() {
		if (pileLimiteVitesse.isEmpty()) {
			return 200;
		}
		Carte sommet = pileLimiteVitesse.get(0);

		if (sommet instanceof FinLimite) {
			return 200;
		} else {
			return 50;
		}
	}

	public int donnerKmParcourus() {
		int km = 0;
		for (Carte carte : collectiondeBornes) {
			if (carte instanceof Borne borne) {
				km += borne.getKm();
			}
		}
		return km;
	}

	public boolean peutAvancer() {
		if (pileDeBataille.isEmpty()) {
			return false;
		}
		Carte sommet = pileDeBataille.get(0);
		return sommet.equals(Cartes.FEU_VERT);
	}

	public boolean estDepotFeuVertAutorise() {
		if (pileDeBataille.isEmpty()) {
			return true;
		}
		Carte sommet = pileDeBataille.get(0);
		return sommet.equals(Cartes.FEU_ROUGE) || sommet instanceof Parade && !sommet.equals(Cartes.FEU_VERT);
	}

	public boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && borne.getKm() < donnerLimitationVitesse()
				&& (donnerKmParcourus() + borne.getKm()) < 1000;
	}

	public boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite) {
			return pileLimiteVitesse.isEmpty() || pileLimiteVitesse.get(0) instanceof FinLimite;
		}

		if (limite instanceof FinLimite) {
			return !pileLimiteVitesse.isEmpty() && pileLimiteVitesse.get(0) instanceof DebutLimite;
		}

		return false;
	}

	public boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque) {
			return peutAvancer();
		}
		if (bataille instanceof Parade) {
			// Cas 1 : Feu Vert
			if (bataille.equals(Cartes.FEU_VERT)) {
				Carte sommet = pileDeBataille.isEmpty() ? null : pileDeBataille.get(0);
				return pileDeBataille.isEmpty() || (sommet instanceof Attaque && sommet.equals(Cartes.FEU_ROUGE))
						|| (sommet instanceof Parade && !sommet.equals(Cartes.FEU_VERT));
			}
			// Cas 2 : Autre parade
			return !pileDeBataille.isEmpty() && pileDeBataille.get(0) instanceof Attaque
					&& pileDeBataille.get(0).getClass().equals(bataille.getClass());
		}
		return false;
	}

	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		}
		if (carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		}
		if (carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		}
		return false;
	}

}
