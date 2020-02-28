package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {

	// You might want this; if you're using Map<String, Integer> anywhere...
	// JUnit has an assertEquals(Object, Object) and an assertEquals(int, int).
	// When you give it assertEquals(Integer, int) it doesn't know which to use (but
	// both would be OK!)
	// This method gets around that by forcing the (int, int) version.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
		// Assert.assert
	}

	@Test
	public void testSize() {
		MapADT<String, String> things = new JavaMap<>();
		// size should give the number of keys
		things.put("dog", "black dog");
		assertFalse(things.size() == 2);
		assertTrue(things.size() == 1);
	}

	@Test
	public void testPut() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");
		assertTrue(things.size() == 2);	
	}

	@Test
	public void testGet() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");
		assertEquals(things.get("fish"), "salmon");
		assertEquals(things.get("dog"), "black dog");

		// the new value of the same key overwrites the first value
		things.put("dog", "white dog");
		assertFalse(things.get("dog") == "black dog");
	}

	@Test
	public void testRemove() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");

		// remove using a key
		things.remove("fish");
		assertNull(things.get("fish"));

		// if you want to remove using a value, it shouldn't work
		things.remove("black dog");
		assertEquals(things.get("dog"), "black dog");
	}
}
