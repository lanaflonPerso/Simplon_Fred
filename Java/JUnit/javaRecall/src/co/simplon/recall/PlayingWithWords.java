package co.simplon.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayingWithWords {
	public String[] myStringArray;

	public static List<String> selectElementsStartingWithA(String array[]) {
		ArrayList<String> result = new ArrayList<>();
		for (String mot : array) {
			if (mot.charAt(0) == 'a') {
				result.add(mot);
			}
		}
		return result;
	}

	public static List<String> selectElementsStartingWithVowel(String array[]) {
		ArrayList<String> result = new ArrayList<>();
		String voyelles = "aeiouy";
		for (String mot : array) {
			if (null != mot) {
				if (voyelles.indexOf(mot.substring(0, 1)) >= 0) {
					result.add(mot);
				}
			}
		}
		return result;
	}

	public static String[] removeNullElements(String array[]) {
		int i = 0;
		for (String mot : array) {
			if (null != mot) {
				i++;
			}
		}
		String result[] = new String[i];
		i = 0;
		for (String mot : array) {
			if (null != mot) {
				result[i] = mot;
				i++;
			}
		}
		return result;
	}

	public static String[] reverseWordsInMyStringArray(String array[]) {
		int i = 0;
		for (String mot : array) {
			array[i] = new StringBuffer(mot).reverse().toString();
			i++;
		}
		return array;
	}

	public void reverseOrderInArray() {
		int der = this.myStringArray.length - 1;
		String mot;
		for (int i = 0; i < (this.myStringArray.length / 2); i++) {
			mot = this.myStringArray[i];
			this.myStringArray[i] = this.myStringArray[der - i];
			this.myStringArray[der - i] = mot;
		}
	}

	public static String[][] everyPossiblePair(String array[]) {
		String[][] tablo = new String[(array.length - 1) * array.length / 2][2];
		Arrays.sort(array);
		int cpt = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				tablo[cpt][0] = array[i];
				tablo[cpt][1] = array[j];
				cpt++;
			}
		}
		return tablo;
	}

	public static List<String> sortByLastLetter(String array[]) {
		ArrayList<String> monTablo = new ArrayList<>();
		array = reverseWordsInMyStringArray(array);
		Arrays.sort(array);
		array = reverseWordsInMyStringArray(array);
		for (int i = 0; i < array.length; i++) {
			monTablo.add(array[i]);
		}
		return monTablo;
	}

	public static String getFirstHalf(String string) {		
		return string.substring(0, (string.length() + 1) / 2);
	}

	public static String exportWordWithoutALetter(String array[], char letter) {
		String result = "";
		int cpt = 0;
		for (String mot : array) {
			if (null != mot) {
				if (mot.toLowerCase().indexOf(letter) == -1) {
					if (cpt > 0) {result+=", ";}
					result += mot;
					cpt++;
				}
			}
		}
		return result;
	}

	public static int numberOfPalindromeWord(String text) {
		String array[] = text.split("[\\:,]");
		String yarra[] = reverseWordsInMyStringArray(text.split("[\\:,]"));
		int NbPalin = 0;
		for (int i = 0; i < yarra.length; i++) {
			if (array[i].trim().equals(yarra[i].trim()) && !(yarra[i].trim().equals(""))) {
				NbPalin++;
			}
		}
		return NbPalin;
	}

	public static int numberOfPalindromeText(String text) {
		String array[] = text.toLowerCase().split(",");
		String yarra[] = reverseWordsInMyStringArray(text.toLowerCase().split(","));
		int NbPalin = 0;
		for (int i = 0; i < yarra.length; i++) {
			if (array[i].replaceAll("[^a-z]","").equals(yarra[i].replaceAll("[^a-z]",""))) {
				NbPalin++;
			}
		}
		return NbPalin;
	}

	public static String shortestWord(String text) {
		String[] listeMots = text.split(" ");
		int lg =  100;
		String petitMot = "";
		for (String mot : listeMots) {
			if (mot.length() < lg) {
				petitMot = mot;
				lg = mot.length();
			}
		}
		return petitMot;
	}

	public static String longestWord(String text) {
		String[] listeMots = text.split("[ ,]+");
		int lg =  0;
		String longMot = "";
		for (String mot : listeMots) {
			if (mot.length() > lg) {
				longMot = mot;
				lg = mot.length();
			}
		}
		return longMot;
	}

	public static String getAllLetters(String[] array) {
		boolean[] alphabet = new boolean[26];
		String result = "";
		for (String mot : array) {
			mot = mot.toUpperCase();
			for (int i = 0; i < mot.length(); i++) {
				if (((int)mot.charAt(i) > 64 && (int)mot.charAt(i) < 91)) {
					alphabet[(int)mot.charAt(i) - 65] = true;
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] == true) {
				result += (char)(i + 97);
			}
		}
		return result;
	}

	public static String removeCapitals(String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			if (((int)text.charAt(i) < 65 || (int)text.charAt(i) > 90)) {
				result += text.charAt(i);
			}
		}
		return result;
	}

	public static String formatDateNicely(String text) {
			return text.substring(8, 10) + "/" + text.substring(5, 7) + "/"  + text.substring(0, 4);
	}

	public static String getDomainName(String email) {
		int arobase = -1;
		int derPoint = -1;
		String result = "";
		arobase = email.lastIndexOf("@");
		derPoint = email.lastIndexOf(".");
		if (arobase >= 0 && derPoint >= 0 && derPoint > arobase) {
			result = email.substring(arobase + 1, derPoint);
		} else {
			result = email + " incompatible !";
		}
		return result;
	}

	public static String titleize(String title) {
		String[] mots = title.toLowerCase().split(" ");
				String mot = "", espace = "";
				boolean ucase = true;
			for (int i = 0; i < mots.length; i++) {
				if (ucase == true || (!(mots[i].equals("and")) && !(mots[i].equals("the")))) {
					mots[i] = mots[i].substring(0, 1).toUpperCase() + mots[i].substring(1);
					ucase = false;
				}
			if (mots[i].substring(mots[i].length()-1).equals(".")) {
					ucase = true;
				}
				mot += espace + mots[i];
				espace = " ";
			}
			return mot;
	}

	public static boolean checkForSpecialCharacters(String string) {
		string = string.toUpperCase();
		boolean result = false;
		for (int i = 0; i < string.length(); i++) {
			if (((int)string.charAt(i) < 65 || (int)string.charAt(i) > 90) && ((int)string.charAt(i) < 48 || (int)string.charAt(i) > 57)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static int factorial(int number) {
		if (number == 1) {return 1;}
		return number * factorial(number-1);
	}

	public static String[] findAnagrams(String name) {
		int compteur = 0;
		String[] listeMots = new String[factorial(name.length())];
		char[] listeLettres = name.toCharArray();
		int[] combinaison = new int[name.length()];
	    char swappeur;
		for (int i = 0; i < name.length(); i++) {
			combinaison[i] = 0;
		}
	    listeMots[compteur] = new String(listeLettres);
	    compteur++;
	    int i = 0;
	    while (i < name.length()) {
	    	if (combinaison[i] < i) {
	    		if (i % 2 == 0) {
	    			swappeur = listeLettres[0];
	                listeLettres[0] = listeLettres[i];
	                listeLettres[i] = swappeur;
	    		} else {
	    			swappeur = listeLettres[combinaison[i]];
	                listeLettres[combinaison[i]] = listeLettres[i];
	                listeLettres[i] = swappeur;
	    		}
	    	    listeMots[compteur] = new String(listeLettres);
	    	    compteur++;
	    	    combinaison[i] += 1;
	            i = 0;
	    	} else {
	    		combinaison[i] = 0;
	            i += 1;
	    	}
	    }
	    Arrays.sort(listeMots);
	    return listeMots;
	}

	public static int[] letterPosition(String name) {
		name = name.toUpperCase();
		int[] result = new int[name.length()];
		for (int i = 0; i < name.length(); i++) {
			result[i] = (int)name.charAt(i) - 64;
		}
		return result;
	}
}
