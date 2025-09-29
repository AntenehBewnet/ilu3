package cartes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JeuDeCartes {
	
	private List<Configuration> typesDeCartes = new ArrayList<>();

	public JeuDeCartes() {
		typesDeCartes.addAll(List.of(new Configuration(new Borne(25), 10),
				new Configuration(new Borne(50), 10),
				new Configuration(new Borne(75), 10),
				new Configuration(new Borne(100), 10),
				new Configuration(new Borne(200), 10),
				new Configuration(new Parade(Type.FEU), 14),
				new Configuration(new Parade(Type.FEU), 6),
				new Configuration(new Parade(Type.ESSENCE), 6),
				new Configuration(new Parade(Type.ACCIDENT), 6),
				new Configuration(new Parade(Type.ACCIDENT), 6),
				new Configuration(new Attaque(Type.FEU), 5),
				new Configuration(new Attaque(Type.FEU), 4),
				new Configuration(new Attaque(Type.ESSENCE), 3),
				new Configuration(new Attaque(Type.CREVAISON), 3),
				new Configuration(new Attaque(Type.ACCIDENT), 3),
				new Configuration(new Botte(Type.FEU), 1),
				new Configuration(new Botte(Type.ESSENCE), 1),
				new Configuration(new Botte(Type.CREVAISON), 1),
				new Configuration(new Botte(Type.ACCIDENT), 1)));
	}
	
	

	
	public String affichageJeuDeCartes() {
		StringBuilder sb = new StringBuilder("JEU : \n \n");
		for (Configuration configuration : typesDeCartes) {
			sb.append(configuration.nbExemplaires + " " + configuration.carte + "\n");		
		}
		return sb.toString();		
	}
	
	public Carte[] donnerCartes() {
		List<Carte> tousLesCartes = new ArrayList<>();
		
		for (Iterator<Configuration> iterator = typesDeCartes.iterator(); iterator.hasNext();) {
			Configuration config = (Configuration) iterator.next();	
			for (int i = 0; i < config.nbExemplaires ; i++) {
				tousLesCartes.add(config.carte);
			}		
		}
		return tousLesCartes.toArray(new Carte[0]);
		
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
