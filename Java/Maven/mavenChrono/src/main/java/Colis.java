
public class Colis {
	private int taille;
	private String gabarit;

	public Colis(int taille) {
		this.taille = taille;
		if (taille > 30) {
			gabarit = "Gros";
		} else {
			gabarit = "Petit";
		}
	}

	public Colis() {
		this.taille = 0;
		this.gabarit = "Petit";
	}

	public int getTaille() {
		return taille;
	}

	public String getGabarit() {
		return gabarit;
	}

}
