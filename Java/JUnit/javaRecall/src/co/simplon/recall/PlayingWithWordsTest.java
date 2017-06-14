package co.simplon.recall;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayingWithWordsTest {
	static PlayingWithWords playing;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		playing = new PlayingWithWords();
	}

	/**
	 * selects elements starting with a
	 */
	@Test
	public void selectElementsStartingWithA() {
		String arrayIn[] = { "bananas", "apples", "pears", "avocados" };
		ArrayList<String> resultat = new ArrayList<String>();
		resultat.add("apples");
		resultat.add("avocados");

		assertEquals(resultat, PlayingWithWords.selectElementsStartingWithA(arrayIn));
	}

	/**
	 * selects elements starting with a vowel
	 */
	@Test
	public void selectElementsStartingWithVowel() {
		String arrayIn[] = { "john", "david", "omar", "fred", null, "idris", "angela" };
		ArrayList<String> resultat = new ArrayList<String>();
		resultat.add("omar");
		resultat.add("idris");
		resultat.add("angela");

		assertEquals(resultat, PlayingWithWords.selectElementsStartingWithVowel(arrayIn));
	}

	/**
	 * removes null values from an array
	 */
	@Test
	public void removeNullElements() {
		String arrayIn[] = { "a", "b", null, null, "false", "null" };
		String arrayOut[] = { "a", "b", "false", "null" };
		assertArrayEquals(arrayOut, PlayingWithWords.removeNullElements(arrayIn));
	}

	/**
	 * reverses the letters of each element in an array
	 */
	@Test
	public void reverseWordsInArray() {
		String arrayIn[] = { "dog", "monkey", "elephant", "kayak" };
		String arrayOut[] = { "god", "yeknom", "tnahpele", "kayak" };
		assertArrayEquals(arrayOut, PlayingWithWords.reverseWordsInMyStringArray(arrayIn));
	}

	/**
	 * reverses the order of each element in an array
	 */
	@Test
	public void reverseOrderInArray() {
		playing.myStringArray = "dog,monkey,elephant,kayak".split(",");
		String arrayOut[] = { "kayak", "elephant", "monkey", "dog" };
		playing.reverseOrderInArray();
		assertArrayEquals(arrayOut, playing.myStringArray);
	}

	/**
	 * makes every possible pairing of students
	 */
	@Test
	public void everyPossiblePair() {
		String arrayIn[] = { "Jon", "Tyrion", "Daenerys" };
		String arrayOut[][] = { { "Daenerys", "Jon" }, { "Daenerys", "Tyrion" }, { "Jon", "Tyrion" } };
		assertArrayEquals(arrayOut, PlayingWithWords.everyPossiblePair(arrayIn));
	}

	/**
	 * sorts an array by the last letter of each word
	 */
	@Test
	public void sortByLastLetter() {
		String arrayIn[] = { "Lannister", "Stark", "Greyjoy", "Targaryen" };
		ArrayList<String> resultat = new ArrayList<String>();
		resultat.add("Stark");
		resultat.add("Targaryen");
		resultat.add("Lannister");
		resultat.add("Greyjoy");
//		assertEquals(resultat, PlayingWithWords.selectElementsStartingWithVowel(arrayIn));
		assertEquals(resultat, PlayingWithWords.sortByLastLetter(arrayIn));
	}
	
	/**
	 * gets the first half of a string
	 */
	@Test
	public void  getFirstHalf() {
		assertEquals("dra", PlayingWithWords.getFirstHalf("dragon"));
		assertEquals("sna", PlayingWithWords.getFirstHalf("snake"));
	}
	
	/**
	 * get the word without a letter upper and lower (ex:"a" and "A")
	 */
	@Test
	public void  exportWordWithoutALetter() {
		String arrayIn[] = { "Lannister", "Stark", "Greyjoy", null, "Targaryen", "Arthur" };
//		assertEquals("", PlayingWithWords.exportWordWithoutALetter(arrayIn, 'a'));
//		assertEquals(null, PlayingWithWords.exportWordWithoutALetter(arrayIn, 'z'));
		assertEquals("Greyjoy", PlayingWithWords.exportWordWithoutALetter(arrayIn, 'a'));
		assertEquals("Lannister, Stark, Greyjoy, Targaryen, Arthur", PlayingWithWords.exportWordWithoutALetter(arrayIn, 'z'));
	}	
	
	/**
	 * counts elements in an text that are palindrome word
	 */
	@Test
	public void  numberOfPalindromeWords() {
		String text = "search palindromes in this text : 'kayak', 'noon', 'khaleesi', 'hodor', 'racecar', 'a', 'tattarrattat', " ;
		assertEquals(5, PlayingWithWords.numberOfPalindromeWord(text));
	}	
	
	/**
	 * counts elements in an text that are palindrome text
	 */
	@Test
	public void  numberOfPalindromeText() {
		String text = "'All the world's a stage', 'rail at a liar', 'Tis the time's plague when madmen lead the blind', 'Did Hannah see bees ? Hannah did', 'Sums are not set as a test on Erasmus' " ;
		assertEquals(3, PlayingWithWords.numberOfPalindromeText(text));
	}	

	/**
	 * returns the shortest word
	 */
	@Test
	public void  shortestWord() {
		String text = "winter is coming";
		assertEquals("is", PlayingWithWords.shortestWord(text));
	}	

	/**
	 * returns the first longest word
	 */
	@Test
	public void  longestWord() {
		String text = "Hey birds, winter is coming with snow.";
		assertEquals("winter", PlayingWithWords.longestWord(text));
	}	
	
	/**
	 * 'gets all letters in an array of words
	 */
	@Test
	public void  getAllLetters() {
		String[] array = {"cat", "dog", "fish", "cat"};
		assertEquals("acdfghiost", PlayingWithWords.getAllLetters(array));
	}	
	
	/**
	 * removes capital letters from a string
	 */
	@Test
	public void  removeCapitals() {
		String text = "Hello Kitty";
		assertEquals("ello itty", PlayingWithWords.removeCapitals(text));
	}	
	
	/**
	 * formats a date nicely
	 */
	@Test
	public void  formatDateNicely() {
		String text = "2016-10-04";
		assertEquals("04/10/2016", PlayingWithWords.formatDateNicely(text));
	}	
	
	/**
	 * gets the domain name from an email address
	 */
	@Test
	public void  getDomainName() {
		assertEquals("makersacademy", PlayingWithWords.getDomainName("spike@makersacademy.com"));
		assertEquals("ssh.makersacademy", PlayingWithWords.getDomainName("spike@ssh.makersacademy.com"));
	}	

	/**
	 * titleizes a string
	 */
	@Test
	public void  titleize() {
		assertEquals("The Lion the Witch and the Wardrobe", PlayingWithWords.titleize("the lion the witch and the wardrobe"));
		assertEquals("The Lion the Witch. And the Wardrobe", PlayingWithWords.titleize("the lion the witch. and the wardrobe"));
	}	
	
	/**
	 * checks a string for special characters
	 */
	@Test
	public void  checkForSpecialCharacters() {
		assertFalse(PlayingWithWords.checkForSpecialCharacters("ABCdef123"));
		assertTrue(PlayingWithWords.checkForSpecialCharacters("ABC@dsklfj!"));
	}	
	
	/**
	 * finds all possible anagrams of a word
	 */
	@Test
	public void  findAnagrams() {
		String[] result1 = {"adm", "amd", "dam", "dma", "mad", "mda"};
		String[] result2 = {"am", "ma"};
		assertArrayEquals(result1, PlayingWithWords.findAnagrams("mad"));
		assertArrayEquals(result2, PlayingWithWords.findAnagrams("ma"));
	}	
	
	/**
	 * for each letter, find its position in the alphabet
	 */
	@Test
	public void  letterPosition() {
		int[] result = {8, 5, 12, 12, 15, 11, 9, 20, 20, 25};
		assertArrayEquals(result, PlayingWithWords.letterPosition("HelloKitty"));
	}	
}
