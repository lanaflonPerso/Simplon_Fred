package co.simplon.recall;

import java.util.Arrays;
import java.util.Calendar;

public class PlayingWithNumber {
	protected float includingTaxe;
	protected float excludingtaxe;
	protected float vat;
	protected int[] sortTab;

	public static long addingTwoNumbers(long number1, long number2) {
		return number1 + number2;
	}

	public static long addingThreeNumbers(long number1, long number2, long number3) {
		return number1 + number2 + number3;
	}
	

	public static long addingSeveralNumbers(final long... numbers) {
		long somme = 0;
		for (long nb : numbers) somme += nb;
		return somme;
	}

	public static int[] allElementsExceptFirstThree(int array[]) {
		int[] liste = new int[array.length - 3];
		for (int i = 3; i < array.length; i++) {
			liste[i-3] = array[i];
		}
		return liste;
	}

	public static int[] addElementToBeginning(int array[], int element) {
		int[] liste = new int[array.length + 1];
		liste[0] = element;
		for (int i = 0; i < array.length; i++) {
			liste[i + 1] = array[i];
		}
		return liste;
	}

	public static Float makeNegative(Float number) {
		return -Math.abs(number);
	}

	public void calculateInvoiceAmount(float ttcAmount[], float tva) {
		this.excludingtaxe = 0;
		for (int i = 0; i < ttcAmount.length; i++) {
			this.excludingtaxe += ttcAmount[i];
		}
		this.includingTaxe = this.excludingtaxe * (100 + tva) / 100;
		this.vat = this.includingTaxe - this.excludingtaxe;
	}

	public static String[] getElementsLowerThanSix(String[] array) {
		String[] result;
		String mot = array[0];
		for (String elm : array) {
			if (Integer.parseInt(elm) < 7) {
				if (mot.indexOf(elm) == -1) {
					mot = mot + "," + elm;
				}
			}
		}
		result = mot.split(",");
		Arrays.sort(result);
		return result;
	}

	public void sortTabBySelection() {
		int min;
		int val;
		for (int i = 0; i < this.sortTab.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < this.sortTab.length; j++) {
				if (this.sortTab[j] < this.sortTab[min]) {
					min = j;
				}
			}
			val = this.sortTab[min];
			this.sortTab[min] = this.sortTab[i];
			this.sortTab[i] = val;
		}
	}

	public static int[] sortTabByInsertion(int[] array) {
		int val;
		for (int i = 1; i < array.length; i++) {
			val = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (val < array[j]) {
					array[j + 1] = array[j];
					array[j] = val;
				}
			}
		}
		return array;
	}

	public void sortTabByBubble() {
		boolean tabloTrie = false;
		int val;
		while (tabloTrie == false) {
			tabloTrie = true;
			for (int i = 0; i < this.sortTab.length - 1; i++) {
				if (this.sortTab[i + 1] < this.sortTab[i]) {
					tabloTrie = false;
					val = this.sortTab[i];
					this.sortTab[i] = this.sortTab[i + 1];
					this.sortTab[i + 1] = val;
				}
			}
		}
		
	}

	public static int findIndexByDichotomy(int element, int[] array) {
		int b = 0, b1 = 0, b2 = array.length - 1;
		Arrays.sort(array);
		while (b >= 0) {
			b = Math.round((b1 + b2) / 2);
			if (element == array[b1]) return b1;
			if (element == array[b2]) return b2;
			if (element == array[b])  return b;
			if (b2 - b1 == 1) return -1;
			if (element > array[b]) b1 = b;
			if (element < array[b]) b2 = b;
		}
		return -1;
	}

	public static int roundUp(float number) {
		return Math.round(number);
	}

	public static int findLastDayOfMonth(int month, int year) {
	      Calendar date = Calendar.getInstance();
	      date.set(year, month, 0);
		return date.get(Calendar.DAY_OF_MONTH);
	}

	public static int factorial(int number) {
		if (number == 1) {return 1;}
		return number * factorial(number-1);
	}

	public static int convertToCelsius(int temperature) {
		return roundUp(((float) temperature - 32)*5/9);
	}
}
