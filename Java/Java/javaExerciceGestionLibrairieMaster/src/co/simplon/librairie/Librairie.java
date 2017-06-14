package co.simplon.librairie;

import java.util.ArrayList;

public class Librairie {
	private ArrayList<Livre> stock;

	/**
	 * 
	 */
	public Librairie() {
		super();
		this.stock = new ArrayList<>();
	}

	private Livre creerLivre(String nom, String auteur, String isbn, float prix) {
		return new Livre(nom, auteur, isbn, prix);
	}

	public void constituerStock() {
		this.stock.add(creerLivre("Chanson douce", "Leila Slimani", "3289080", 25));
		this.stock.add(creerLivre("Petit pays", "Gaël Faye", "4332438", 32));
		this.stock.add(creerLivre("L'autre qu'on adorait", "Catherine Cusset", "9067453", 19));
		this.stock.add(creerLivre("Cannibales", "Régis Jauffret", "8976383", 12));
		this.stock.add(creerLivre("Babylone", "Yasmina Reza", "1234546", 20));
		this.stock.add(creerLivre("Le Dieu du carnage", "Yasmina Reza", "8763903", 6));
		this.stock.add(creerLivre("California girls", "Simon Liberati", "5656834", 20));
		this.stock.add(creerLivre("La tour de Babylone", "Ted Chiang", "5226834", 9));

	}

	public void afficherstock() {
		for (Livre livre : stock) {
			livre.sePresenter();
		}

	}

}
