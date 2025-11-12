package cartes;

public abstract class Carte {
    protected Type type;

    

    public Type getType() {
        return type;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                  // même objet
        if (obj == null || getClass() != obj.getClass()) return false;  // pas le même type
        Carte autre = (Carte) obj;
        return this.type == autre.type;                // même type logique
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

}
