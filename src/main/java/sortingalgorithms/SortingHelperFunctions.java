package sortingalgorithms;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SortingHelperFunctions {
	/*
	 * Compares two elements. Returns true if they are already in order.
	 */
	public static <T> boolean compare(T first, T second, Comparator<? super T> c) {
		if (c == null) {
			Comparator comp = Comparator.naturalOrder();
			return comp.compare(first, second) <= 0;
		}
		return c.compare(first, second) <= 0;
	}
	
	public static void swap(List list, int i, int j) {
		if (i == j) {
			return;
		}
		list.set(i, list.set(j, list.get(i)));
	}
	
	public static void shuffleList(List list, Random rand) { //Fisher–Yates shuffle
		for (int i = list.size() - 1; i > 0; i--) {
			swap(list, i, rand.nextInt(i));
		}
		
		//equivalent:
		/*for (int i = 0; i < list.size() - 1; i++) {
			swap(list, i, rand.nextInt(list.size() - i) + i);
		}*/
	}
	
	public static <T> boolean isSorted(List<T> list, Comparator<? super T> c) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (!compare(list.get(i), list.get(i + 1), c)) {
				return false;
			}
		}
		return true;
	}
}
