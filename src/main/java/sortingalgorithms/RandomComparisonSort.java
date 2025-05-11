package sortingalgorithms;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomComparisonSort extends SortingAlgorithm {
	
	@Override
	public String getTimeComplexity() {
		return "O(VERY BAD)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		Random rand = new Random();
		while (!SortingHelperFunctions.isSorted(list, c)) {
			while (true) {
				int first = rand.nextInt(list.size());
				int second = rand.nextInt(list.size());
				if (!inCorrectOrderOrEqual(list, first, second, c)) {
					swap(list, first, second);
					break;
				}
			}
		}
	}
}
