package fr.laposte.bougerPossessions;

public class Pingouin extends Oiseau implements IMouvement {
	
	public void bouger() {
		System.out.println("Je suis le pingouin " + this.nom + " et je marche.");
	}
}
