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
	public void testInsertOneThing() {
		// it's impossible to test size fully without also calling insert...
		SetADT<String> one = new JavaSet<>();
		one.insert("A");
		assertEquals(one.size(), 1);
	}

	@Test
	public void testInsertRepeated() {
		SetADT<String> pets = new JavaSet<>();
		assertEquals(pets.size(), 0);
		pets.insert("dog");
		assertEquals(pets.size(), 1);
		pets.insert("goldfish");
		assertEquals(pets.size(), 2);
		pets.insert("dog");
		assertEquals(pets.size(), 2);
	}

	@Test
	public void testContains() {
		SetADT<String> things = new JavaSet<>();
		things.insert("A");
		things.insert("B");
		things.insert("C");
		things.insert("D");
		things.insert("E");
		assertFalse(things.contains("2"));
		assertTrue(things.contains("E"));
	}

	@Test
	public void testRemove() {
		SetADT<String> things = new JavaSet<>();
		things.insert("bamboo");
		things.insert("sunlight");
		things.remove("bamboo");
		assertFalse(things.contains("banboo"));
		assertTrue(things.contains("sunlight"));
		assertFalse(things.contains("moon"));

		// or you can do this
		SetADT<String> expected = new JavaSet<>();
		expected.insert("sunlight");
		assertEquals(things, expected);
	}

}
