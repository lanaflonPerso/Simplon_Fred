package test;

public class BoucleFizzBuzz {
	
	public static void test() {
		for (int val = 1; val <= 20; val++) {
			if ((val % 3 == 0) && (val % 5 == 0)) {System.out.format("%2d", val);System.out.println(" - FizzBuzz");}
			else if (val % 3 == 0) {System.out.format("%2d", val);System.out.println(" - Fizz");}
			else if (val % 5 == 0) {System.out.format("%2d", val);System.out.println(" - Buzz");}
			else {System.out.format("%2d \n", val);}
		}
	}

	public static void main(String[] args) {
		test();
	}

}