package fr.pokemon;
//import java.util.ArrayList;

public class Attaque {
	
	private String nom;
	private int puissance;
	private String type;
	private String description;
	private int numero;
	private int ordre;

	public Attaque(int numero, int ordre) {
		this.numero = numero;
		this.ordre = ordre;
	}

	public String seDecrire() {
		return getNom() + "\n" + getPuissance() + "\n" + getType() + "\n" + getDescription();
	}
	
	public String getNom() {
		if (this.ordre == 1 && this.numero == 3)  {nom = "Fouet LIanes";}
		if (this.ordre == 2 && this.numero == 3)  {nom = "Canon Graine";}
		if (this.ordre == 1 && this.numero == 4)  {nom = "Vampigraine";}
		if (this.ordre == 2 && this.numero == 4)  {nom = "Poing Dard";}
		if (this.ordre == 1 && this.numero == 5)  {nom = "Poing Dard";}
		if (this.ordre == 2 && this.numero == 5)  {nom = "Attaque Trébuchante";}
		if (this.ordre == 1 && this.numero == 12) {nom = "Ecras'Face";}
		if (this.ordre == 2 && this.numero == 12) {nom = "Goutte à Goutte";}
		if (this.ordre == 1 && this.numero == 13) {nom = "Goutte à Goutte";}
		if (this.ordre == 2 && this.numero == 13) {nom = "Aqua-Vague";}
		if (this.ordre == 1 && this.numero == 14) {nom = "Jet d'eau";}
		if (this.ordre == 2 && this.numero == 14) {nom = "Torent";}
		if (this.ordre == 1 && this.numero == 8)  {nom = "Griffe";}
		if (this.ordre == 2 && this.numero == 8)  {nom = "Charbon Mutant";}
		if (this.ordre == 1 && this.numero == 9)  {nom = "Souffle-Feu";}
		if (this.ordre == 2 && this.numero == 9)  {nom = "Queue de Flammes";}
		if (this.ordre == 1 && this.numero == 10) {nom = "Feu Follet";}
		if (this.ordre == 2 && this.numero == 10) {nom = "Déflagration";}
		return nom;
	}

	public String getPuissance() {
		if (this.ordre == 1 && (this.numero == 3 || this.numero == 12 || this.numero == 8))  {puissance = 10;}
		if (this.ordre == 1 && (this.numero == 4 || this.numero == 9 || this.numero == 13)) {puissance = 20;}
		if (this.ordre == 2 && (this.numero == 3 || this.numero == 8 || this.numero == 12)) {puissance = 20;}
		if (this.ordre == 1 && this.numero == 14) {puissance = 30;}
		if (this.ordre == 1 && this.numero == 10) {puissance = 30;}
		if (this.ordre == 2 && this.numero == 13) {puissance = 40;}
		if (this.ordre == 2 && this.numero == 4)  {puissance = 50;}
		if (this.ordre == 1 && this.numero == 5)  {puissance = 50;}
		if (this.ordre == 2 && this.numero == 14) {puissance = 60;}
		if (this.ordre == 2 && this.numero == 9)  {puissance = 60;}
		if (this.ordre == 2 && this.numero == 5)  {puissance = 80;}
		if (this.ordre == 2 && this.numero == 10) {puissance = 120;}
		return " - Puissance = " + Integer.toString(puissance);
	}

	public String getType() {
		if (this.numero ==  3 || this.numero ==  4 || this.numero ==  5)  {type = "Plante";}
		if (this.numero == 12 || this.numero == 13 || this.numero == 14)  {type = "Eau";}
		if (this.numero ==  8 || this.numero ==  9 || this.numero == 10)  {type = "Feu";}
		return " - Type = " + type;
	}

	public String getDescription() {
		description = "Aucune";
		if (this.ordre == 1 && this.numero == 4)  {description = "Soignez 10 dégâts à ce pokemon";}
		if (this.ordre == 2 && this.numero == 5)  {description = "Lanumeroez une pièce. Si c'est face, cette attque inflige 40 dégâts supplémentaires";}
		if (this.ordre == 2 && this.numero == 13) {description = "Lanumeroez 2 pièces. Cette attaque inflige 20 dégâts supplémentaires pour chaque côté face.";}
		if (this.ordre == 1 && this.numero == 9)  {description = "Lanumeroez une pièce. Si c'est face, cette attaque inflige 20 dégâts supplémentaires";}
		if (this.ordre == 2 && this.numero == 10) {description = "Défaussez une Energie attachée à ce Pokemon";}
		return " - Description = " + description;
	}

	public int getnumero() {
		return numero;
	}

	public int getordre() {
		return ordre;
	}
}
