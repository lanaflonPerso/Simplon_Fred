package fr.animal;

public class App {
	
	// main sert à lancer le programme.
	public static void main(String[] args) {
		Animal chien1 = new Animal();
		Animal chien2 = new Animal();
		Animal chien3 = new Animal();
		
		chien1.setNom("Idéfix");
		chien2.setNom("Snoopy");
		chien3.setNom("Princesse");
		
		chien1.setRace("Pittbull");
		chien2.setRace("Doberman");
		chien3.setRace("Berger allemand");
		
		chien1.setAge(5);
		chien2.setAge(3);
		chien3.setAge(7);
		
		chien1.setTaille("1m65");
		chien2.setTaille("1m73");
		chien3.setTaille("1m94");
		
		chien1.SeDecrire();
		chien2.SeDecrire();
		chien3.SeDecrire();
		
//		complete(chien1);
	}
	
//	public void complete(Animal chien) {
//		System.out.println(chien.getNom + ", " + chien.getRace + " " + chien.getAge + chien.getTaille);
//	}

}
