

public class Vehicule {
	protected String marque;
	protected String modele;
	protected String immatriculation;
	protected int volume;

	public Vehicule(String marque, String modele, String immatriculation, int volume) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.volume = volume;
	}

	public String getMarque() {
		return marque;
	}

	public String getModele() {
		return modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public int getVolume() {
		return volume;
	}
}
