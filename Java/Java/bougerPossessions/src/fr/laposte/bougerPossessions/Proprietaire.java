package fr.laposte.bougerPossessions;

import java.util.ArrayList;

public class Proprietaire {

	public static void main(String[] args) {
		
		ArrayList<IMouvement> mesPossessions = new ArrayList<>();
		
		Voiture MaBagnole = new Voiture();
		Oie monOie = new Oie();
		monOie.setNom("Gertrude");
		Pingouin monPingouin = new Pingouin();
		monPingouin.setNom("Coladoo");

		mesPossessions.add(MaBagnole);
		mesPossessions.add(monOie);
		mesPossessions.add(monPingouin);

		bougerMesPossessions(mesPossessions);
		
	}
	
	public static void bougerMesPossessions(ArrayList<IMouvement> liste) {
		Dresseur monDresseur = new Dresseur();		
		monDresseur.faireBouger(liste);
	}

}
