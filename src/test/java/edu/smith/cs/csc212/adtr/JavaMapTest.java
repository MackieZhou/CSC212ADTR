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
		assertEquals(things.size(), 1);
	}

	@Test
	public void testPut() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		assertEquals(things.get("dog"), "black dog");
	}

	@Test
	public void testGet() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");
		assertEquals(things.get("fish"), "salmon");
	}

	@Test
	public void testGetNotIn() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");
		assertNull(things.get("fruit"));
	}

	@Test
	public void testGetOverride() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");
		// the new value of the same key overwrites the first value
		things.put("dog", "white dog");
		assertEquals(things.get("dog"), "white dog");
	}

	@Test
	public void testRemove() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");

		// remove using a key
		things.remove("fish");
		assertNull(things.get("fish"));
	}

	@Test
	public void testRemoveValue() {
		MapADT<String, String> things = new JavaMap<>();
		things.put("dog", "black dog");
		things.put("fish", "salmon");

		// if you want to remove using a value, it shouldn't work
		String k = things.remove("black dog");
		assertEquals(k, null);
		assertEquals(things.get("dog"), "black dog");
	}
}
