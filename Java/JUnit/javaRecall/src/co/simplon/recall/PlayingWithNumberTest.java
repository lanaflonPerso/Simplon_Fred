package co.simplon.recall;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayingWithNumberTest {
	static PlayingWithNumber playing;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		playing = new PlayingWithNumber();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addingTwoNumbers() {
		assertEquals(30, PlayingWithNumber.addingTwoNumbers(10, 20));
	}

	@Test
	public void addingThreeNumbers() {
		assertEquals(60, PlayingWithNumber.addingThreeNumbers(10, 20, 30));
	}

	@Test
	public void addingSeveralNumbers() {
		assertEquals(30, PlayingWithNumber.addingSeveralNumbers(10, 20));
		assertEquals(60, PlayingWithNumber.addingSeveralNumbers(10, 20, 30));
		assertEquals(7936, PlayingWithNumber.addingSeveralNumbers(256, 512, 1024, 2048, 4096));
	}
	
	/**
	 * takes all elements except the first 3
	 */
	@Test
	public void allElementsExceptFirstThree() {
		int arrayIn[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int arrayOut[] = {4, 5, 6, 7, 8 };
		assertArrayEquals(arrayOut, PlayingWithNumber.allElementsExceptFirstThree(arrayIn));
	}

	/**
	 * adds an element to the beginning of an array
	 */
	@Test
	public void addElementToBeginning() {
		int arrayIn[] = { 2, 3, 4, 5 };
		int arrayOut[] = {1, 2, 3, 4, 5 };
		assertArrayEquals(arrayOut, PlayingWithNumber.addElementToBeginning(arrayIn,1));
	}
	/**
	 * makes numbers negative
	 */
	@Test
	public void makeNegative() {
		assertEquals(new Float(-4.52),PlayingWithNumber.makeNegative(new Float(4.52)));
		assertEquals(new Float(-8),PlayingWithNumber.makeNegative(new Float(-8)));
	}
	
	/**
	 * calculate amount of invoice
	 */
	@Test
	public void calculateInvoiceAmount() {
		float arrayFloat[] = { 2.2f, 3.3f, 4.4f, 5.5f };
		playing.calculateInvoiceAmount(arrayFloat,20);
		assertEquals(playing.includingTaxe,18.48f,0.0f);
		assertEquals(playing.vat,3.08f,0.0f);
		assertEquals(playing.excludingtaxe,15.4f,0.0f);
	}	
	
	/*
	 * gets elements lower than six
	 */
	@Test
	public void getElementsLowerThanSix() {
		String[] arrayIn = {"1", "3", "50", "4", "1", "2", "6", "2", "10", "3", "7"};
		String[] arrayOut = {"1", "2", "3", "4", "6"};
		assertArrayEquals(arrayOut, PlayingWithNumber.getElementsLowerThanSix(arrayIn));
	}
	
	/**
	 * ecrire l'algorithme du tri par selection
	 */
	@Test
	public void sortTabBySelection() {
		playing.sortTab = new int[] {0,23,52,17,-5,17,15,9,16};
		int[] resultArray = {-5,0,9,15,16,17,17,23,52};
		playing.sortTabBySelection();
		assertArrayEquals(resultArray, playing.sortTab);
	}
	
	/**
	 * ecrire l'algorithme du tri par insertion
	 */
	@Test
	public void sortTabByInsertion() {
		int[] arrayIn = {0,23,52,17,-5,17,15,9,16};
		int[] arrayOut = {-5,0,9,15,16,17,17,23,52};
		assertArrayEquals(arrayOut, PlayingWithNumber.sortTabByInsertion(arrayIn));
	}
	
	/**
	 * ecrire l'algorithme du tri bulle
	 */
	@Test
	public void sortTabByBubble() {
		playing.sortTab = new int[] {0,23,52,17,-5,17,15,9,16};
		int[] resultArray = {-5,0,9,15,16,17,17,23,52};
		playing.sortTabByBubble();;
		assertArrayEquals(resultArray, playing.sortTab);
	}
	
	/**
	 * ecrire l'algorithme d'une recherche dichotomique
	 */
	@Test
	public void findIndexByDichotomy() {
		int[] arrayIn = {-5,0,9,15,16,17,17,23,52};
		assertEquals(7, PlayingWithNumber.findIndexByDichotomy(23,arrayIn));
		assertEquals(1, PlayingWithNumber.findIndexByDichotomy(0,arrayIn));
		assertEquals(8, PlayingWithNumber.findIndexByDichotomy(52,arrayIn));
		assertEquals(4, PlayingWithNumber.findIndexByDichotomy(16,arrayIn));
		assertEquals(0, PlayingWithNumber.findIndexByDichotomy(-5,arrayIn));
		assertEquals(-1, PlayingWithNumber.findIndexByDichotomy(10,arrayIn));
	}
	
	/**
	 * rounds up a number
	 */
	@Test
	public void roundUp() {
		assertEquals(3, PlayingWithNumber.roundUp(3.10f));
		assertEquals(24, PlayingWithNumber.roundUp(23.76f));
		assertEquals(10, PlayingWithNumber.roundUp(9.5f));
	}

	/**
	 * donner le dernier jour du mois
	 */
	@Test
	public void findAllLastDayMonth() {
		assertEquals(31, PlayingWithNumber.findLastDayOfMonth(07, 2017));
		assertEquals(30, PlayingWithNumber.findLastDayOfMonth(11, 2017));
		assertEquals(28, PlayingWithNumber.findLastDayOfMonth(02, 2017));
		assertEquals(29, PlayingWithNumber.findLastDayOfMonth(02, 2016));
		assertEquals(29, PlayingWithNumber.findLastDayOfMonth(02, 2000));
		assertEquals(28, PlayingWithNumber.findLastDayOfMonth(02, 2100));
	}
	
	/**
	 * finds the factorial of a number
	 */
	@Test
	public void factorial() {
		assertEquals(120, PlayingWithNumber.factorial(5)); // = 5 * 4 * 3 * 2 * 1
	}
	
	/**
	 * converts Fahrenheit to Celsius rounding to the nearest integer
	 */
	@Test
	public void convertToCelsius() {
		assertEquals(0, PlayingWithNumber.convertToCelsius(32));
		assertEquals(13, PlayingWithNumber.convertToCelsius(55));
	}

}
