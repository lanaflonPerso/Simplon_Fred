package fr.pokemon;

public class Pokemon {	
	private String couleur;
	private String nom;
	private String niveau;
	private int PV;
	private int retraite;
	private int numero;
	
	
	public Pokemon(int numero) {
		this.numero = numero;
	}
	
	public String seDecrire() {
		return getNom() + "\n" + getCouleur() + "\n" + getNiveau() + "\n" + getPV() + "\n" + getRetraite();
	}

		public String getCouleur() {
			if (this.numero ==  3 || this.numero ==  4 || this.numero ==  5)  {couleur = "vert";}
			if (this.numero == 12 || this.numero == 13 || this.numero == 14)  {couleur = "bleu";}
			if (this.numero ==  8 || this.numero ==  9 || this.numero == 10)  {couleur = "rouge";}
			return "Couleur = " + couleur;
		}


		
		public String getNom() {
			String valeur = "Inconnu";
			nom = "";
			if (this.numero ==  3) {nom = "Marisson";}
			if (this.numero ==  4) {nom = "Boguérisse";}
			if (this.numero ==  5) {nom = "Blindépique";}
			if (this.numero == 12) {nom = "Grenousse";}
			if (this.numero == 13) {nom = "Croâporal";}
			if (this.numero == 14) {nom = "Crapousse";}
			if (this.numero ==  8) {nom = "Feunnec";}
			if (this.numero ==  9) {nom = "Roussil";}
			if (this.numero == 10) {nom = "Goupelin";}
			if (nom != "") {valeur = "Nom = " + nom;}
			return valeur;
		}




		public String getNiveau() {
			if (this.numero ==  3 || this.numero == 12 || this.numero ==  8)  {niveau = "BASE";}
			if (this.numero ==  4 || this.numero == 13 || this.numero ==  9)  {niveau = "NIVEAU 1";}
			if (this.numero ==  5 || this.numero == 14 || this.numero == 10)  {niveau = "NIVEAU 2";}
			return "Niveau = " + niveau;
		}




		public String getPV() {
			if (this.numero ==  3 || this.numero == 12 || this.numero ==  8) {PV = 60;}
			if (this.numero == 13 || this.numero ==  9) {PV = 80;}
			if (this.numero ==  4) {PV = 90;}
			if (this.numero ==  5) {PV = 150;}
			if (this.numero == 14) {PV = 120;}
			if (this.numero == 10) {PV = 140;}
			return "Point de vie = " + Integer.toString(PV);
		}




		public String getRetraite() {
			if (this.numero ==  3 || this.numero == 12 || this.numero == 13 || this.numero ==  8) {retraite = 1;}
			if (this.numero ==  4 || this.numero == 14 || this.numero ==  9) {retraite = 2;}
			if (this.numero ==  5) {retraite = 4;}
			if (this.numero == 10) {retraite = 3;}
			return "Retraite = " + Integer.toString(retraite);
		}




		public int getNumero() {
			return numero;
		}
		
		
	}
