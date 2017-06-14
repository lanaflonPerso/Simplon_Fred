package fr.librairie;

public class Livre {

	private String isbn;
	private String auteur;
	private String titre;
	private String prix;
	private String moteur;

	public Livre(String isbn, String auteur, String titre, String prix) {
			this.isbn = isbn;
			this.auteur= auteur;
			this.titre = titre;
			this.prix = prix;
			this.moteur = "$" + isbn + "$" + auteur + "$" + titre + "$" + prix + "$";
	}

	public String getIsbn() {
		return isbn;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getTitre() {
		return titre;
	}

	public String getPrix() {
		return prix;
	}

	public String getMoteur() {
		return moteur;
	}


}
