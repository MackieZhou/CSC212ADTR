package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

// Wow, this class really needs some comments...
/**
 * This class gives you union, intersection, or word count of sets of strings
 * 
 * @author MackieZhou
 *
 */
public class Challenges {

	/**
	 * output the union of two sets of strings
	 * 
	 * @param left  - the first set of strings
	 * @param right - the second set of strings
	 * @return the union of left and right
	 */
	public static SetADT<String> union(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		// add everything in left into union
		for (String i : left) {
			output.insert(i);
		}
		// add everything in right into union
		for (String i : right) {
			output.insert(i);
		}
		return output;
	}

	/**
	 * output the intersection of two sets of strings
	 * 
	 * @param left  - the first set of strings
	 * @param right - the second set of strings
	 * @return the intersection of left and right
	 */
	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String i : left) {
			if (right.contains(i)) {
				output.insert(i);
			}
		}
		return output;
	}

	/**
	 * count the number of existence of each word in the input list of strings
	 * 
	 * @param words - a list of words that you want to count
	 * @return map - key is the word, value is the count
	 */
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();

		for (String i : words) {
			if (output.get(i) == null) {
				output.put(i, 1);
			} else {
				output.put(i, output.get(i) + 1);
			}
		}

		return output;
	}
}
