package fr.ville;

public class Capitale extends Ville {
	private String pays;

	//constructeurs
	public Capitale(String leNom, String lePays) {
		super(leNom); //appel du constructeur de Ville. nbHab est initialisé à –1 par ce constructeur
		pays = lePays;
	}

	public Capitale(String leNom, String lePays, int leNbHab) {
		super(leNom, leNbHab);
		pays = lePays;
	}

	//accesseurs supplémentaires
	public String getPays() {
		return pays;
	}
	public void setPays(String nomPays) {
			pays = nomPays;
		}

	//méthode presenteToi( ) redéfinie
	public String CapitalePresenteToi() {
		String presente = super.VillePresenteToi();
		presente = presente + " Capitale de " + pays;
		return presente;
	}
}
