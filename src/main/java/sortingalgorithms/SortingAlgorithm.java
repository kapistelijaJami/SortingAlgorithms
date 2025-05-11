package sortingalgorithms;

import java.util.Comparator;
import java.util.List;
import static sortingalgorithms.Main.createList;
import static sortingalgorithms.Main.printList;
import static sortingalgorithms.Main.printTimeDifference;

public abstract class SortingAlgorithm {
	protected long comparisons = 0;
	protected long swaps = 0;
	
	public void run(long seed, int length, boolean printStats) {
		System.out.println("\n-------------------------------------");
		
		System.out.println("");
		System.out.println(this.getClass().getSimpleName() + " " + getTimeComplexity() + ":\n");
		List<Integer> list = createList(seed, length);
		printList(list);
		
		printTimeDifference(null);
		if (printStats) {
			sortPrint(list, null);
		} else {
			sort(list);
		}
		printTimeDifference("time", " ms");
		printList(list);
		
		System.out.println("");
		printTimeDifference(null);
		if (printStats) {
			sortPrint(list, Comparator.reverseOrder());
		} else {
			sort(list, Comparator.reverseOrder());
		}
		printTimeDifference("time reverse", " ms");
		printList(list);
	}
	
	public abstract String getTimeComplexity();
	public <T> void sort(List<T> list) {
		sort(list, null);
	}
	public abstract <T> void sort(List<T> list, Comparator<? super T> c);
	
	public <T> void sortPrint(List<T> list) {
		sortPrint(list, null);
	}
	
	public <T> void sortPrint(List<T> list, Comparator<? super T> c) {
		resetStats();
		sort(list, c);
		printStats();
	}
	
	/**
	 * Compares two elements.
	 * Returns true if they are already in order, are equal, or second is null.
	 * Assumes the first one is inside the list.
	 * @param <T>
	 * @param list
	 * @param first
	 * @param second
	 * @param c
	 * @return 
	 */
	public <T> boolean inCorrectOrderOrEqual(List<T> list, int first, int second, Comparator<? super T> c) {
		comparisons++;
		if (!isInside(list, second)) {
			return true;
		}
		return SortingHelperFunctions.compare(list.get(first), list.get(second), c);
	}
	
	public <T> boolean firstIsSmallerOrEqual(List<T> list, int first, int second, Comparator<? super T> c) { //alias for inCorrectOrder
		return SortingAlgorithm.this.inCorrectOrderOrEqual(list, first, second, c);
	}
	
	public <T> boolean inCorrectOrderOrEqual(T first, T second, Comparator<? super T> c) {
		comparisons++;
		if (second == null) {
			return true;
		}
		return SortingHelperFunctions.compare(first, second, c);
	}
	
	public <T> boolean firstIsSmallerOrEqual(T first, T second, Comparator<? super T> c) { //alias for inCorrectOrder
		return inCorrectOrderOrEqual(first, second, c);
	}
	
	/**
	 * Returns the one which should be ordered first according to the comparator.
	 * @param <T>
	 * @param first
	 * @param second
	 * @param c
	 * @return 
	 */
	public <T> T getFirstInOrder(T first, T second, Comparator<? super T> c) {
		comparisons++;
		if (second == null) {
			return first;
		}
		return SortingHelperFunctions.compare(first, second, c) ? first : second;
	}
	
	/**
	 * Returns the index of the one which should be ordered first according to the comparator.
	 * Assumes the first one is inside the list.
	 * @param <T>
	 * @param list
	 * @param first
	 * @param second
	 * @param c
	 * @return 
	 */
	public <T> int getFirstIdxInOrder(List<T> list, int first, int second, Comparator<? super T> c) {
		comparisons++;
		if (!isInside(list, second)) {
			return first;
		}
		return SortingHelperFunctions.compare(list.get(first), list.get(second), c) ? first : second;
	}
	
	public <T> int getFirstIdxInOrder(Heap<T> heap, int first, int second, Comparator<? super T> c) {
		comparisons++;
		if (!heap.isInside(second)) {
			return first;
		}
		return SortingHelperFunctions.compare(heap.get(first), heap.get(second), c) ? first : second;
	}
	
	public <T> void swap(List<T> list, int i, int j) {
		if (i == j) {
			return;
		}
		SortingHelperFunctions.swap(list, i, j);
		swaps++;
	}
	
	public void printStats() {
		System.out.println("Comparisons: " + comparisons + ", swaps: " + swaps);
	}
	
	public void resetStats() {
		comparisons = 0;
		swaps = 0;
	}
	
	protected boolean isInside(List list, int i) {
		return i >= 0 && i < list.size();
	}
}
