package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class JavaListTest {

	/**
	 * Make a new empty list.
	 * 
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}

	/**
	 * Helper method to make a full list.
	 * 
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}

	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}

	@Test(expected = EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}

	@Test(expected = EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}

	@Test(expected = EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}

	// test for addBack
	@Test
	public void testAddBack() {
		ListADT<String> data = makeFullList();
		data.addBack("new");
		assertEquals(data.getIndex(4), "new");
	}

	// test for addBack - add a repeat value
	@Test
	public void testAddBackRepeat() {
		ListADT<String> data = makeFullList();
		data.addBack("d");
		assertEquals(data.getIndex(4), "d");
	}

	// test for addBack: size of the list +1
	@Test
	public void testAddBackSize() {
		ListADT<String> data = makeFullList();
		int size = data.size();
		data.addBack("new");
		int newSize = data.size();
		assertEquals(size + 1, newSize);
	}

	// test for removeBack - remove the right value
	@Test
	public void testRemoveBackValue() {
		ListADT<String> data = makeFullList();
		String last = data.removeBack();
		assertEquals(last, "d");
	}

	// test for removeBack - makes the list size -1
	@Test
	public void testRemoveBackSize() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		data.removeBack();
		assertEquals(data.size(), 2);
	}

	// test for removeIndex - remove the right value
	@Test
	public void testRemoveIndexValue() {
		ListADT<String> data = makeFullList();
		String c = data.removeIndex(2);
		assertEquals(c, "c");
	}

	// test for removeIndex - following values slide to the left
	@Test
	public void testRemoveIndexSlideLeft() {
		ListADT<String> data = makeFullList();
		data.removeIndex(1);
		assertEquals(data.getIndex(1), "c");
	}

	// test for removeIndex - makes the list size -1
	@Test
	public void testRemoveIndexSize() {
		ListADT<String> data = makeFullList();
		data.removeIndex(1);
		assertEquals(data.size(), 3);
	}

	// test for removeFront - remove the right value
	@Test
	public void testRemoveFront() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		assertEquals(data.getFront(), "b");
	}

	// test for removeFront - list size -1
	@Test
	public void testRemoveFrontSize() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		assertEquals(data.size(), 3);
	}

	// test for addIndex
	@Test
	public void testAddIndex() {
		ListADT<String> data = makeFullList();
		data.addIndex(2, "add");
		assertEquals(data.getIndex(2), "add");
	}

	// test for addIndex - add a repeat value
	@Test
	public void testAddIndexRepeat() {
		ListADT<String> data = makeFullList();
		data.addIndex(2, "a");
		assertEquals(data.getIndex(2), "a");
	}

	// test for addIndex - the values slide to the right
	@Test
	public void testAddIndexSlideRight() {
		ListADT<String> data = makeFullList();
		String that = data.getIndex(2);
		data.addIndex(2, "add");
		assertEquals(data.getIndex(3), that);
	}

	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}

	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}

	@Test(expected = EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}

	@Test(expected = EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}

	@Test(expected = BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}

	@Test(expected = BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}

	@Test(expected = BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size() * 2);
	}

	@Test(expected = BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size() * 2, "the");
	}

	@Test(expected = BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size() + 1, "the");
	}

	@Test(expected = BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}

	@Test
	public void testSetIndex() {
		ListADT<String> data = makeFullList();
		data.setIndex(1, "blablabla");
		assertEquals(data.getIndex(1), "blablabla");
	}

	// you cannot setIndex to an index out of range
	@Test(expected = BadIndexError.class)
	public void testSetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.setIndex(data.size(), "wrong");
	}

	// you cannot setIndex to a negative index
	@Test(expected = BadIndexError.class)
	public void testSetIndexLow() {
		ListADT<String> data = makeFullList();
		data.setIndex(-1, "wrong");
	}

	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}

	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}

	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
