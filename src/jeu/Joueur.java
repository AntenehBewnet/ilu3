package jeu;

import cartes.Carte;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
	private MainJoueur main;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return nom.equals(joueur.nom);
		}
		return false;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + "]";
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	
	public Carte prendreCarte(Sabot sabot) {
		if (sabot == null || sabot.estVide()) {
            return null;
        }
		Carte carte = sabot.piocher();
		donner(carte);
		return carte;
	}
	
	public void deposer(Carte c) {
		zoneDeJeu.deposer(c);
	}
	
	public int donnerKmParcourus() {
        return zoneDeJeu.donnerKmParcourus();
    }

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public MainJoueur getMain() {
		return main;
	}
	
    public boolean estDepotAutorise(Carte carte) {
        return zoneDeJeu.estDepotAutorise(carte);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
