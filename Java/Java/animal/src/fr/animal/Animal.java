// Package :
package fr.animal;


// Class :
public class Animal {
	
	// Propriétés :
	private String Race;	
	private String Nom;
	private int Age;
	private String Taille;
	
	
	
	// Methode (Constructeur) - Spécifique - Le cas présent, correspond au constructeur par défaut :
	public Animal() {
		Race = null;
		Nom = null;
		Age = 0;
		Taille = null;
	}
	
	
	
	// Méthode :
	public void SeDecrire() {
		System.out.println("Je m'appelle " + this.Nom + ", je suis un " + this.Race + " de " + this.Age + " ans mesurant " + this.Taille + ".");
	}
	
	
	
	// Méthodes (Assesseurs) - Englobe les Setters et Getters :
	
		// Les Setters :
	public void setRace(String race) {
		Race = race;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public void setAge(int age) {
		Age = age;
	}

	public void setTaille(String taille) {
		Taille = taille;
	}
	
	
		// Les Getters :
	public String getRace() {
		return "je suis un " + Race;
	}

	public String getNom() {
		return "Je m'appelle " + Nom;
	}

	public String getAge() {
		return "de " + Integer.toString(Age) + " ans";
	}

	public String getTaille() {
		return "mesurant " + Taille;
	}
}
