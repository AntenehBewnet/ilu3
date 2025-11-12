package cartes;

public interface Cartes {
	Carte FEU_ROUGE = new Attaque(Type.FEU);
    Carte FEU_VERT = new Parade(Type.FEU);
    Carte PRIORITAIRE = new Botte(Type.FEU);
    Carte ESSENCE = new Attaque(Type.ESSENCE);
    Carte CREVAISON = new Attaque(Type.CREVAISON);
    Carte ACCIDENT = new Attaque(Type.ACCIDENT);

}
