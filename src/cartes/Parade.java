package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getNomParade();
	}
	
	@Override
    public boolean equals(Object obj) {
		super.equals(obj);
        Carte autre = (Carte) obj;
        return this.type == autre.type;                // même type logique
    }
	

}
