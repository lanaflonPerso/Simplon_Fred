package fr.laposte.pizza;

public class App {

	public static void main(String[] args) {
		Base maBase = new Base("BCF");
		Pizza maPizza = new Pizza("forestière", maBase, 3);		
		maPizza.sAfficher();

		Base maBase1 = new Base("BT");
		Pizza maPizza1 = new Pizza("romaine", maBase1, 3);		
		maPizza1.sAfficher();

	}

}
