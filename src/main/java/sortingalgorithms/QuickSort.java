package sortingalgorithms;

import java.util.Comparator;
import java.util.List;

public class QuickSort extends SortingAlgorithm {
	
	@Override
	public String getTimeComplexity() {
		return "O(n^2)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		sortRecursive(list, 0, list.size() - 1, c);
    }
	
	/**
	 * Sorts the part between low and high.
	 * @param <T>
	 * @param list
	 * @param low inclusive
	 * @param high inclusive
	 * @param c 
	 */
	private <T> void sortRecursive(List<T> list, int low, int high, Comparator<? super T> c) {
		if (low >= high) { //only one element in this part, which is already sorted
			return;
		}
		
		int partitionIndex = partition(list, low, high, c);
		//partitionIndex is now at the right location.
		//All elements left and right from partitionIndex are on correct side.
		
		sortRecursive(list, low, partitionIndex - 1, c);
		sortRecursive(list, partitionIndex + 1, high, c);
    }
	
	/**
	 * Chooses a pivot between low and high.
	 * Moves all items smaller than pivot to the left side of pivot, and all bigger than pivot to the right side.
	 * Pivot will be at the correct location after.
	 * @param <T>
	 * @param list
	 * @param low inclusive
	 * @param high inclusive
	 * @param c
	 * @return 
	 */
	private <T> int partition(List<T> list, int low, int high, Comparator<? super T> c) {
		swap(list, (high + low) / 2, high); //take the mid element, and swap it to last, it will be the pivot
		int pivot = high;
		
		//low keeps track of the lowest index where next smaller than pivot will be moved. And at the end, the pivot itself.
		//anything lower than current low is already all smaller than pivot in this partition
		
		for (int i = low; i < high; i++) {
			if (inCorrectOrderOrEqual(list, i, pivot, c)) { //element at i is smaller than pivot
				swap(list, low, i);
				low++;
			}
		}
		
		swap(list, low, pivot); //move pivot to the correct spot
		
		return low;
	}
}
