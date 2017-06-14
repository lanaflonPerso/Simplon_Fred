package co.simplon;

import java.text.ParseException;

public class AfficheResultats {
	protected JourNonTravaille jour;

	public AfficheResultats() throws ParseException {
		jour = new JourNonTravaille();
		affiche();
	}

	public AfficheResultats(String stringJour) throws ParseException {
		jour = new JourNonTravaille(stringJour);
		affiche();
	}

	public AfficheResultats(String stringJour, int confRepos) throws ParseException {
		jour = new JourNonTravaille(stringJour, confRepos);
		affiche();
	}

	public AfficheResultats(String stringJour, int confRepos, int confFerie) throws ParseException {
		jour = new JourNonTravaille(stringJour, confRepos);
		jour.setIntListeJoursFeriesTravailles(confFerie);
		affiche();
	}

	private void affiche() {
		String repos      = "Non";
		String ferie      = "Non";
		String jnt        = "Non";
		if (jour.isDateEnCoursEstReposHebdomadaire()) {repos = "Oui";}
		if (jour.isDateEnCoursEstFeriee()) {ferie = "Oui";}
		if (jour.isDateEnCoursEstNonTravaillee()) {jnt = "Oui";}
//		System.out.printf("%-40s%s%s%n","Date trait�e"," : ", jour.stringDateEnCours);
		System.out.printf("%-40s%s%s %d %s %d   %s%n","Date litterale", " : ",jour.getStringJourDateEnCours(), jour.getIntJourDateEnCours(), jour.getStringMoisDateEnCours(), jour.getIntAnneeDateEnCours(),jour.getStringJourFerieDateEnCours());
		System.out.printf("%-40s%s%s%n", "Ce jour est-il f�ri�", " : ", ferie);
		System.out.printf("%-40s%s%s%n","Est-ce un jour de repos hebdomadaire", " : ", repos);
		System.out.printf("%-40s%s%s%n","Est-ce un jour non travaill�", " : ", jnt);
//		System.out.printf("%s%d est %s%s%n", "La date de Paques pour l'ann�e ", jour.getIntAnneeDateEnCours(), " : ", jour.getStringListeDateJoursFeries()[1]);
//		System.out.printf("%-40s%s%s%n","Date typ�e Calendar", " : ", jour.getCalendarDateEnCours());
//		System.out.printf("%-40s%s%s%n","Date typ�e Date", " : ", jour.getDateDateEnCours());
//		System.out.printf("%-40s%s%s%n","Date typ�e texte", " : ", jour.getStringDateEnCours());
//		System.out.println();
		System.out.println("**************************************************************************************************");
//		System.out.println();
	}

}
