package sortingalgorithms;

import java.util.Comparator;
import java.util.List;

public class InsertionSort extends SortingAlgorithm {
	
	@Override
	public String getTimeComplexity() {
		return "O(n^2)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		for (int i = 1; i < list.size(); i++) {
			insert(list, i, c);
		}
	}
	
	private <T> void insert(List<T> list, int i, Comparator<? super T> c) {
		for (; i > 0; i--) {
			if (!inCorrectOrderOrEqual(list, i - 1, i, c)) {
				swap(list, i - 1, i);
			} else {
				return;
			}
		}
	}
}
