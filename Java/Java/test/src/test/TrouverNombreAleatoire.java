package test;
import java.util.Scanner;

public class TrouverNombreAleatoire {
	
	public static void saisirNombre() {
		boolean match = false;
		int nombreAleatoire = 1 + (int)(Math.random() * 8);
		Scanner saisie = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("Entrez un nombre : ");
			int nombre = saisie.nextInt();
			if (nombre < nombreAleatoire) {
				System.out.println("Trop bas !");
				}
			if (nombre > nombreAleatoire) {
				System.out.println("Trop haut !");
				}
			if (nombre == nombreAleatoire) {
				System.out.println("Trouvé !");
				match = true;
				break;
				}
			System.out.println();
		}
		if (match) {
			System.out.println("Le jeu est terminé, il falait effectivement trouver : " + nombreAleatoire);
		} else {
			System.out.println("Le jeu est terminé, il falait trouver : " + nombreAleatoire);
		}
		saisie.close();
	}

	public static void main(String[] args) {
		saisirNombre();
	}

}