package sortingalgorithms;

import java.util.Comparator;
import java.util.List;

public class SelectionSort extends SortingAlgorithm {
	
	@Override
	public String getTimeComplexity() {
		return "O(n^2)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		for (int i = 0; i < list.size(); i++) {
			int idx = selectFrom(list, i, c);
			if (i != idx) {
				swap(list, i, idx);
			}
		}
	}
	
	/**
	 * Selects the smallest from i index (inclusive) forward and returns its index.
	 * @param <T>
	 * @param list
	 * @param i
	 * @param c
	 * @return 
	 */
	private <T> int selectFrom(List<T> list, int i, Comparator<? super T> c) {
		T first = list.get(i);
		int minIdx = i;
		i++;
		
		for (; i < list.size(); i++) {
			T temp = list.get(i);
			if (!inCorrectOrderOrEqual(first, temp, c)) {
				first = temp;
				minIdx = i;
			}
		}
		return minIdx;
	}
}
