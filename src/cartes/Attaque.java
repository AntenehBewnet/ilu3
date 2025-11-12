package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getNomAttaque();
	}

	
	@Override
    public boolean equals(Object obj) {
		super.equals(obj);
        Carte autre = (Carte) obj;
        return this.type == autre.type;                // même type logique
    }
	
}
