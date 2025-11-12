package cartes;

public abstract class Carte {
    protected Type type;

    

    public Type getType() {
        return type;
    }
    
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() != obj.getClass();                // même type logique
    }

   

}
