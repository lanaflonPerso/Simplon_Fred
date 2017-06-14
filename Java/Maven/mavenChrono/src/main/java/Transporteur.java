
public class Transporteur extends Vehicule {
	protected String energie = "Electrique";
	protected String distance = "Courte";
	protected int nbChaufeur = 1;
	protected String horaire = "Jour";

	public Transporteur(String marque, String modele, String immatriculation, int volume, int nbChaufeur) {
		super(marque, modele, immatriculation, volume);
		if (nbChaufeur == 1) {
			energie = "Electrique";
			distance = "Courte";
			horaire = "Jour";
		} else {
			energie    = "Diesel";
			distance   = "Longue";
			nbChaufeur = 2;
			horaire    = "Nuit";
		}
	}

	public String getEnergie() {
		return energie;
	}

	public String getDistance() {
		return distance;
	}

	public int getNbChaufeur() {
		return nbChaufeur;
	}

	public String getHoraire() {
		return horaire;
	}

//	public String getMarque() {
//		return super.getMarque();
//	}
//
//	public String getModele() {
//		return super.getModele();
//	}
//
//	public String getImmatriculation() {
//		return super.getImmatriculation();
//	}
//
//	public int getVolume() {
//		return super.getVolume();
//	}

}
