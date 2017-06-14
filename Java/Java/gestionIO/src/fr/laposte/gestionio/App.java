package fr.laposte.gestionio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> ligne = new ArrayList<>(); 
		ArrayList<String> caracteristique = new ArrayList<>(); 
//		File monFichier = new File("/home/fcouriol/Documents/Simplon_Fred/java/gestionIO/src/fr/laposte/gestionio/monFichierDeTest.txt");
		File monFichier = new File("C:/Data/_Simplon/Simplon_Fred/java/gestionIO/src/fr/laposte/gestionio/monFichierDeTest.txt");
		Scanner scan = new Scanner(monFichier);
		int i=0;
		caracteristique.add("Nom");
		caracteristique.add("Race");
		caracteristique.add("Age");
		caracteristique.add("Taille");
		caracteristique.add("Nourriture");
		caracteristique.add("Particularité");
		while (scan.hasNextLine()) {
//			System.out.println(scan.nextLine());			
			ligne.add(scan.nextLine());
//			ligne.get(i);
			i++;
		}
		System.out.println();
		System.out.println("Infos sur mon chien :");
		System.out.println();
		i=0;
		for (String info : ligne) {
			if (i == 0) System.out.printf("\t%-15s %s.\n" ,"Nom", ": " + info);
			if (i == 1) System.out.printf("\t%-15s %s.\n" ,"Race", ": " + info);
			if (i == 2) System.out.printf("\t%-15s %s.\n" ,"Age",": " + info);
			if (i == 3) System.out.printf("\t%-15s %s.\n" ,"Taille",": " + info);
			if (i == 4) System.out.printf("\t%-15s %s.\n" ,"Nourriture",": " + info);
			if (i == 5) System.out.printf("\t%-15s %s.\n" ,"Particularité",": " + info);
			i++;
		}
		scan.close();
	}

}
