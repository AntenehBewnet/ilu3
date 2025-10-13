package cartes;

public abstract class Carte {
	
	
	protected Type type;
	  

	public Type getType() {
		return type;
	}
	
	@Override 
	public boolean equals(Object obj) {

	    if (this == obj) {
	        return true;
	    }

	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    Carte autreCarte = (Carte) obj;

	    // Vérifier si le type est null avant d'appeler equals
	    if (this.type == null && autreCarte.type == null) {
	        return true; // Les deux types sont null, donc égaux
	    }
	    if (this.type == null || autreCarte.type == null) {
	        return false; // Un seul des deux est null, donc pas égaux
	    }
	    

	    return this.type.equals(autreCarte.type);
	}


}
