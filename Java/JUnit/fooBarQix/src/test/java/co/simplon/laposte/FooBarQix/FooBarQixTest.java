package co.simplon.laposte.FooBarQix;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class FooBarQixTest {

	private static FooBarQix foobarqix;
	
	@BeforeClass
	public static void initialiser() {
		foobarqix = new FooBarQix();
	}
	
	@Test
	public void FooBarQix() {
		assertEquals("1", foobarqix.calculerCorrespondance(1));
		assertEquals("2", foobarqix.calculerCorrespondance(2));
		assertEquals("Foo", foobarqix.calculerCorrespondance(6));
		assertEquals("FooQix", foobarqix.calculerCorrespondance(21));
		assertEquals("BarBar", foobarqix.calculerCorrespondance(25));
	}

	@Test
	public void Sommiel() {
		assertEquals("1", foobarqix.sommiel(1));
		assertEquals("3", foobarqix.sommiel(2));
		assertEquals("6", foobarqix.sommiel(3));
		assertEquals("10", foobarqix.sommiel(4));
		assertEquals("15", foobarqix.sommiel(5));

	}
		
	@Test
	@Ignore
	public void Fibonacci() {
		assertEquals("1", foobarqix.fibonacci(1));
		assertEquals("2", foobarqix.fibonacci(2));
		assertEquals("3", foobarqix.fibonacci(3));
		assertEquals("5", foobarqix.fibonacci(4));
		assertEquals("8", foobarqix.fibonacci(5));
	}
		
}
