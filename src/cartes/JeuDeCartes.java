package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes = {new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new FinLimite(), 6),
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1)};

	

	
	public String affichageJeuDeCartes() {
		StringBuilder sb = new StringBuilder("");
		for (Configuration configuration : typesDeCartes) {
			sb.append(configuration.nbExemplaires + " " + configuration.carte + "\n");		
		}
		return sb.toString();		
	} 
	
	public Carte[] donnerCartes() {
		int nbrCarte = 0;
		for (Configuration configuration : typesDeCartes) {
			nbrCarte += configuration.nbExemplaires;
		}
		Carte[] tousLesCartes = new Carte[nbrCarte];
		
		
		for (int indice = 0,j=0; j < typesDeCartes.length; j++) {
			Configuration config = typesDeCartes[j];
			for (int i = 0; i < config.nbExemplaires; i++,indice++) {
				tousLesCartes[indice] = config.getCarte();
			}
			
		}
		
		return tousLesCartes;
		
	}
	
	
	
	public boolean checkCount() {
	
	
	for (Configuration carte : typesDeCartes) {
		
		Carte[] cartes = donnerCartes();	
		int nbrAttendu = carte.nbExemplaires;
		int nbr = 0;
			
			for (Carte c : cartes) {
				if (c.equals(carte.carte)) {
					nbr++;
				}
			}
		if (nbr != nbrAttendu) {
			System.out.println("Erreur : " + carte.carte + " attendue " + nbrAttendu + " fois, trouvée " + nbr + " fois.");
			return false;
		}
		
		}
	return true;
	}
	
	
	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

	}

}
