package fr.laposte.bougerPossessions;

public class Oie extends Oiseau implements IMouvement {

	public void bouger() {
		System.out.println("Je suis l'oie " + this.nom + " et je vole.");
	}

}
