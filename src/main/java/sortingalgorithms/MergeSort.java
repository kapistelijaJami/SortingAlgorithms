package sortingalgorithms;

import java.util.Comparator;
import java.util.List;

public class MergeSort extends SortingAlgorithm {
	private Object[] arr;
	
	@Override
	public String getTimeComplexity() {
		return "O(n log n)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		arr = (T[]) new Object[list.size()];
		sortRecursive(list, 0, list.size(), c);
	}
	
	/**
	 * Sorts the part between low and high.
	 * @param <T>
	 * @param list
	 * @param low inclusive
	 * @param high exclusive
	 * @param c 
	 */
	private void sortRecursive(List list, int low, int high, Comparator c) {		
		if (low == high - 1) { //only one element in this part, which is already sorted
			return;
		}
		
		int mid = (low + high) / 2;
		sortRecursive(list, low, mid, c); //sort from low to mid
		sortRecursive(list, mid, high, c); //sort from mid to high
		
		//at this point both the parts are sorted, they just need to be merged
		
		merge(list, low, mid, high, c);
	}
	
	/**
	 * Merges the two parts of the list between low and high with mid separating the parts.
	 * Uses temporary array for the merging process.
	 * @param list
	 * @param low inclusive
	 * @param mid exclusive as upper bound, and inclusive as lower bound
	 * @param high exclusive
	 * @param c 
	 */
	private void merge(List list, int low, int mid, int high, Comparator c) {
		int count = 0;
		
		for (int i = low, j = mid; i < mid || j < high; count++) { //goes through both of the parts one at a time adding smaller element to the array
			int idx;
			
			if (i >= mid) { //low part has been fully added already, so add j
				idx = j++;
			} else if (j >= high) { //high part has been fully added already, so add i
				idx = i++;
			} else if (inCorrectOrderOrEqual(list, i, j, c)) { //i should be first
				idx = i++;
			} else { //j should be first
				idx = j++;
			}
			
			arr[count] = list.get(idx);
		}
		
		for (int i = 0; i < count; i++) {
			list.set(low + i, arr[i]);
			swaps++;
		}
	}
}
