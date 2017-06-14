package fr.ville;

public class App {

	public static void main(String args[]) {
		Ville v1 = new Ville("Lyon", 1500000);
		Ville v2 = new Ville("Bobigny");
		Capitale c1 = new Capitale("Paris", "France", 10000000);
		Capitale c2 = new Capitale("Ouagadougou", "Burkina-Faso");
		System.out.println(v1.VillePresenteToi());
		System.out.println(v2.VillePresenteToi());
		System.out.println(c1.CapitalePresenteToi());
		System.out.println(c2.CapitalePresenteToi());
	}

}