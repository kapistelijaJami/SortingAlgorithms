package sortingalgorithms;

import java.util.Comparator;
import java.util.List;

public class BubbleSort extends SortingAlgorithm {
	
	@Override
	public String getTimeComplexity() {
		return "O(n^2)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		for (int max = list.size(); max > 0; max--) {
			int lastSwapPos = 0;
			
			for (int i = 0; i < max; i++) { //finds the largest between 0 (inclusive) and max (exclusive), and moves it to the right
				if (swapRightIfNecessary(list, i, c)) {
					lastSwapPos = i;
				}
			}
			
			if (lastSwapPos == 0) break;
		}
    }
	
	private <T> boolean swapRightIfNecessary(List<T> list, int i, Comparator<? super T> c) {
		if (i == list.size() - 1) {
			return false;
		}
		
		if (!inCorrectOrderOrEqual(list, i, i + 1, c)) {
			swap(list, i, i + 1);
			return true;
		}
		return false;
	}
}
