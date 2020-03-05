package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {

	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}

	@Test
	public void testSize() {
		SetADT<String> things = new JavaSet<>();
		things.insert("A");
		things.insert("B");
		things.insert("c");
		things.insert("d");
		assertEquals(things.size(), 4);
	}

	@Test
	public void testInsertOneThing() {
		// it's impossible to test size fully without also calling insert...
		SetADT<String> one = new JavaSet<>();
		one.insert("A");
		assertEquals(one.size(), 1);
	}

	@Test
	public void testInsertRepeated() {
		SetADT<String> pets = new JavaSet<>();
		pets.insert("goldfish");
		pets.insert("dog");
		assertEquals(pets.size(), 2);
		pets.insert("dog");
		assertEquals(pets.size(), 2);
	}

	@Test
	public void testContains() {
		SetADT<String> things = new JavaSet<>();
		things.insert("A");
		things.insert("B");
		assertTrue(things.contains("A"));
	}

	@Test
	public void testContainsNotIn() {
		SetADT<String> things = new JavaSet<>();
		things.insert("A");
		things.insert("B");
		assertFalse(things.contains("2"));
	}

	@Test
	public void testRemove() {
		SetADT<String> things = new JavaSet<>();
		things.insert("bamboo");
		things.insert("sunlight");
		things.remove("bamboo");
		assertFalse(things.contains("bamboo"));
	}

	@Test
	public void testRemoveSecondMethod() {
		SetADT<String> things = new JavaSet<>();
		things.insert("bamboo");
		things.insert("sunlight");
		things.remove("bamboo");

		SetADT<String> expected = new JavaSet<>();
		expected.insert("sunlight");

		assertEquals(things, expected);
	}

}
