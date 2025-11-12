package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;


public class TestMethodeEquals {

	public static void main(String[] args) {
		Carte c1 = new Borne(25);
		Carte c2 = new Borne(25);
		System.out.println(c1.equals(c2));
		
		Carte c3 = new Attaque(Type.FEU);
		Carte c4 = new Attaque(Type.FEU);
		System.out.println(c3.equals(c4));
		
		Carte c5 = new Parade(Type.FEU);
		System.out.println(c4.equals(c5));
		
		
		
		Carte carte25Bornes1 = new Borne(25);
		Carte carte25Bornes2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + carte25Bornes1.equals(carte25Bornes2));
	
		Carte carteFeuxRouge1 = new Attaque(Type.FEU);
		Carte carteFeuxRouge2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? " + carteFeuxRouge1.equals(carteFeuxRouge2));
		
		Carte carteFeuxVert = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + carteFeuxRouge1.equals(carteFeuxVert));

	}

}
