package fr.pokemon;

public class Cartes {
	int numero;
	String carte;
	
	public Cartes(int numero) {
		this.numero = numero;
	}

	
	public String getCarte() {
		String valeur = "Carte NÂ° " + Integer.toString(this.numero) + " inconnue.";
		Pokemon pokemon = new Pokemon(this.numero);
		Attaque attaque1 = new Attaque(this.numero, 1);
		Attaque attaque2 = new Attaque(this.numero, 2);
		Faiblesse faiblesse = new Faiblesse(this.numero);
		if (pokemon.getNom() != "Inconnu") {
			valeur = "Description carte N° " + Integer.toString(this.numero) + "\n\n" + pokemon.seDecrire() + 
					"\n\nAttaque 1 : " + attaque1.seDecrire() + 
					"\n\nAttaque 2 : " + attaque2.seDecrire() + 
					"\n\nFaiblesse : " + faiblesse.seDecrire();
		}
		return valeur;
	}

}
