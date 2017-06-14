package fr.librairie;
import java.util.ArrayList;
import java.util.Scanner;

public class Librairie {
	String libraire;
	String Recherche;
	ArrayList<Livre> listLivre = new ArrayList<>();
	
	public void remplir() {
		listLivre.add(new Livre("3289080", "Leila Slimani", "Chanson douce", "25"));
		listLivre.add(new Livre("4332438", "Gaël Faye", "Petit pays", "32"));
		listLivre.add(new Livre("9067453", "Catherine Cusset", "L'autre qu'on adorait", "19"));
		listLivre.add(new Livre("8976383", "Régis Jauffret", "Cannibales", "12"));
		listLivre.add(new Livre("1234546", "Yasmina Reza", "Babylone", "20"));
		listLivre.add(new Livre("8763903", "Yasmina Reza", "Le Dieu du carnage", "6"));
		listLivre.add(new Livre("5656834", "Simon Liberati", "California girls", "20"));
		listLivre.add(new Livre("5226834", "Ted Chiang", "La tour de Babylone", "9"));
	}


	public String getLibraire() {
		return libraire;
	}


	public ArrayList<Livre> getListLivre() {
//		remplir();
		return listLivre;
	}

	public void rechercher(String reference) {
		Boolean trouve = false;
//		remplir();
		for (Livre bouquin : listLivre) {
			if (bouquin.getMoteur().indexOf(reference) >= 0 || reference.equals("tout")) {
				System.out.println(
					reference + " - " + bouquin.getIsbn() + " - " + 
					bouquin.getAuteur() + " - " + 
					bouquin.getTitre() + " - " + 
					bouquin.getPrix()
						);
				trouve = true;
			} 
		}
		if (trouve == false) {
			Scanner saisie = new Scanner(System.in);
			System.out.println("Votre livre n'est pas en stock, voulez-vous que nous vous le commandions ? (O/N)");
			String reponse = saisie.next();
			if (reponse.equals("O") || reponse.equals("o")) {
				ajouterLivre();
			}
			saisie.close();
		}
	}
	
	public void ajouterLivre() {
		Scanner saisie = new Scanner(System.in);

		System.out.println("Entrez l'ISBN : ");
		String isbn = saisie.nextLine();

		System.out.println("Entrez le titre : ");
		String titre = saisie.nextLine();

		System.out.println("Entrez l'auteur  : ");
		String auteur = saisie.nextLine();

		System.out.println("Entrez le prix : ");
		String prix = saisie.nextLine();
		
		listLivre.add(new Livre(isbn, auteur, titre, prix));
		
		saisie.close();
	}
	
}
