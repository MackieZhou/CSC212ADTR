package edu.smith.cs.csc212.adtr;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class ChallengesTest {

	@Test
	public void testUnionSimple() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();

		left.insert("A");
		left.insert("B");
		right.insert("B");
		right.insert("C");

		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");
		expected.insert("C");

		Assert.assertEquals(expected, Challenges.union(left, right));
	}

	@Test
	public void testUnionNoRepeat() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();

		left.insert("A");
		left.insert("B");
		right.insert("C");
		right.insert("D");

		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");
		expected.insert("C");
		expected.insert("D");

		Assert.assertEquals(expected, Challenges.union(left, right));
	}

	@Test
	public void testUnionSameSets() {
		SetADT<String> left = new JavaSet<>();
		left.insert("A");
		left.insert("B");

		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");

		Assert.assertEquals(expected, Challenges.union(left, left));
	}

	@Test
	public void testUnionOneEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		left.insert("A");
		left.insert("B");

		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");

		Assert.assertEquals(expected, Challenges.union(left, right));
	}

	@Test
	public void testUnionBothEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		SetADT<String> expected = new JavaSet<>();

		Assert.assertEquals(expected, Challenges.union(left, right));
	}

	@Test
	public void testIntersectionSimple() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();

		left.insert("A");
		left.insert("B");
		right.insert("B");
		right.insert("C");

		SetADT<String> expected = new JavaSet<>();
		expected.insert("B");

		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}

	@Test
	public void testIntersectionNoRepeat() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();

		left.insert("A");
		left.insert("B");
		right.insert("C");

		SetADT<String> expected = new JavaSet<>();

		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}

	@Test
	public void testIntersectionSubset() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();

		left.insert("A");
		left.insert("B");
		left.insert("C");
		left.insert("D");
		right.insert("B");
		right.insert("C");

		SetADT<String> expected = new JavaSet<>();
		expected.insert("B");
		expected.insert("C");

		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}

	@Test
	public void testIntersectionOneEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();

		left.insert("A");
		left.insert("B");
		left.insert("C");
		left.insert("D");

		SetADT<String> expected = new JavaSet<>();

		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}

	@Test
	public void testIntersectionBothEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();

		SetADT<String> expected = new JavaSet<>();

		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}

	@Test
	public void testWordCountSimple() {
		ListADT<String> example = new JavaList<>();
		for (String word : new String[] { "a", "b", "a", "b", "c", "d" }) {
			example.addBack(word);
		}
		MapADT<String, Integer> expected = new JavaMap<>();
		expected.put("a", 2);
		expected.put("b", 2);
		expected.put("c", 1);
		expected.put("d", 1);

		Assert.assertEquals(expected, Challenges.wordCount(example));
	}

	@Test
	public void testWordCountEmpty() {
		ListADT<String> example = new JavaList<>();
		MapADT<String, Integer> expected = new JavaMap<>();

		Assert.assertEquals(expected, Challenges.wordCount(example));
	}

	@Test
	public void testWordCountOneEntry() {
		ListADT<String> example = new JavaList<>();
		example.addBack("a");

		MapADT<String, Integer> expected = new JavaMap<>();
		expected.put("a", 1);

		Assert.assertEquals(expected, Challenges.wordCount(example));
	}

}
