package fr.librairie;
import java.util.Scanner;

public class App {
 
	public static void main(String[] args) {	

		
		Librairie inventaire = new Librairie();
		inventaire.remplir();
		Scanner saisie = new Scanner(System.in);

		while (true) {
			System.out.println("\nEntrez le terme recherché : ");
			String recherche = saisie.nextLine();
			if (recherche == "fin") {
				saisie.close();
				break;
			} else {
				inventaire.rechercher(recherche);
			}
		}
	}

}
