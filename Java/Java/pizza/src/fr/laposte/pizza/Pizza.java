package fr.laposte.pizza;

public class Pizza extends Base {
	String nom;
	Base base;
	int nbIngredients;	
	int total;
	
	public Pizza(String nom, Base base, int nbIngredients) {
		super(nom);
		this.nom = nom;
		this.base = base;
		this.nbIngredients = nbIngredients;
	}
	
	public int calculerPrixIngredients() {
		return this.nbIngredients * 2;
	}
	
	public int prixTotal() {
		return this.calculerPrixIngredients() + this.calculerPrixBase();
	}
	
	public void sAfficher() {		
		System.out.println("La pizza " + this.nom + " est à " + this.prixTotal() + " euros.");
	}

}
