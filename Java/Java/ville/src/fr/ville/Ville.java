package fr.ville;

public class Ville {
	private String nom; //le nom ne sera accessible que par la classe Ville, et pas par la classe Capitale
	protected int nbHab; //le nombre d'habitant sera accessible par la classe Capitale

	public Ville(String leNom) {
		nom = leNom.toUpperCase(); //ainsi tous le noms de ville seront en majuscule
		nbHab = -1; //-1 signifie que le nombre d'habitant est inconnu
	}

	public Ville(String leNom, int leNbHab) {
		nom = leNom.toUpperCase();
		if (leNbHab < 0) {
			System.out.println("Un nombre d'habitant doit être positif.");
			nbHab = -1;
		} else {
			nbHab = leNbHab;
		}
	}

	public String getNom() {
		return nom;
	}

	//pas d'accesseur en écriture pour le nomÆ il est impossible de changer le nom d'une ville
	public int getNbHab() {
		return nbHab;
	}
	public void setNbHab(int nvNbHab) {
		if (nvNbHab < 0) {
			System.out.println("Un nombre d'habitant doit être positif. La modification n'a pas été prise en compte");
		} else {
			nbHab = nvNbHab;
		}
	}

	public String VillePresenteToi() {
		String presente = "Ville " + nom + " nombre d'habitants ";
		if (nbHab == -1) {
			presente = presente + "inconnu";
		} else {
			presente = presente + " = " + nbHab;
		}
		return presente;
	}
}
