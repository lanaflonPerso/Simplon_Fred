package division;
import java.util.Scanner;

public class TestException {

	public static float diviserDeuxNombre() throws Exception {
		Scanner sc = null;
		String str1, str2;
		int nb1, nb2;
		float resultat = 0;
		try {
			// lecture des nombres
			sc = new Scanner(System.in);
			System.out.println("dividende :");
			str1 = sc.nextLine();
			System.out.println("diviseur :");
			str2 = sc.nextLine();

			// conversion en entier
			nb1 = Integer.parseInt(str1);
			nb2 = Integer.parseInt(str2);

			//divison
			resultat = nb1 / nb2;

		} catch (NumberFormatException e) { //exception déclenchée quand la string ne contient pas de chiffre
			System.out.println("une des valeurs n'est pas numérique !");
			throw new Exception("non numérique");
		} catch (ArithmeticException e) { //exception déclenchée par une division par zéro
			System.out.println("Division par zéro !");
		} finally { // tout le temps exécuté
			sc.close(); // fermeture de l'input stream

		}
		return resultat;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float divison ;
		try {
			divison = diviserDeuxNombre();
			System.out.println("le résultat de la divison est : " + divison);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("erreur de calcul");
		}

	}

}
