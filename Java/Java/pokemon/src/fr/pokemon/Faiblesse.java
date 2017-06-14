package fr.pokemon;

public class Faiblesse {	
	private String type;
	private int valeur;
	private int numero;

	public Faiblesse(int numero) {
		this.numero = numero;
	}

	public String seDecrire() {
		return getType() + "\n" + getValeur();
	}
	
	public String getType() {
		if (this.numero ==  3 || this.numero ==  4 || this.numero ==  5) {type = "feu";}
		if (this.numero == 12 || this.numero == 13 || this.numero == 14) {type = "plante";}
		if (this.numero ==  8 || this.numero ==  9 || this.numero == 10) {type = "eau";}
		return type;
	}

	public String getValeur() {
		valeur = 2;
		return " - Valeur = " + Integer.toString(valeur);
	}

	public int getNumero() {
		return numero;
	}

}
