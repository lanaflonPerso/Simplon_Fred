package fr.simplon.bonjour;

public class App {

	public static void main(String[] args) {
		Bonjour hello = new Bonjour();
		hello.setMessage("Coucou !");
		System.out.println(hello.getMessage());

		Bonjour ola = new Bonjour();
		ola.setMessage("Hello !");
		System.out.println(ola.getMessage());
	}
}
