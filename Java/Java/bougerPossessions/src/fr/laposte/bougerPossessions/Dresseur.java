package fr.laposte.bougerPossessions;

import java.util.ArrayList;

public class Dresseur {

	public void faireBouger(ArrayList<IMouvement> laListe) {
		for (IMouvement mouvement : laListe) {
			mouvement.bouger();
		}
	}
}
