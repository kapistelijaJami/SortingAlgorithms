package sortingalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static final long SEED = 1234567; //def: 1234567
	public static final int LENGTH = 50000; //def: 50000
	public static final boolean PRINT_ALL_ITEMS = false;
	public static final boolean PRINT_STATS = true;
	public static long time = System.nanoTime();
	
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		QuickSort quickSort = new QuickSort();
		MergeSort mergeSort = new MergeSort();
		SelectionSort selectionSort = new SelectionSort();
		InsertionSort insertionSort = new InsertionSort();
		HeapSort heapSort = new HeapSort();
		BogoSort bogoSort = new BogoSort();
		RandomComparisonSort randomComparisonSort = new RandomComparisonSort();
		
		mergeSort.sort(createList(SEED, LENGTH), null); //additional sorting so the time is better for the next runs.
		//for some reason the first sort is always slower no matter what.
		
		mergeSort.run(SEED, LENGTH, PRINT_STATS);
		quickSort.run(SEED, LENGTH, PRINT_STATS);
		heapSort.run(SEED, LENGTH, PRINT_STATS);
		selectionSort.run(SEED, LENGTH, PRINT_STATS);
		insertionSort.run(SEED, LENGTH, PRINT_STATS);
		bubbleSort.run(SEED, LENGTH, PRINT_STATS);
		
		//bogoSort.run(SEED, LENGTH, PRINT_STATS); //this takes way too long (but seems to be faster than RandomComparisonSort, actually might not be faster, not sure)
		//randomComparisonSort.run(SEED, LENGTH, PRINT_STATS); //this takes WAY too long
	}
	
	public static List<Integer> createList(long seed, int length) {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= length; i++) {
			list.add(i);
		}
		
		SortingHelperFunctions.shuffleList(list, new Random(seed));
		return list;
	}
	
	public static <T> void printList(List<T> list) {
		if (!PRINT_ALL_ITEMS) {
			return;
		}
		
		for (T i : list) {
			System.out.println(i);
		}
		System.out.println("");
	}
	
	public static void printTimeDifference(String text) {
		printTimeDifference(text, "");
	}
	
	public static void printTimeDifference(String text, String ending) {
		long t = System.nanoTime() - time;
		
		if (text == null) {
			//nothing
		} else if (text.isEmpty()) {
			System.out.println(nsToMs(t) + ending);
		} else {
			System.out.println(text + ": " + nsToMs(t) + ending);
		}
		time = System.nanoTime();
	}
	
	private static double nsToMs(long ns) {
		return ns / 1e6;
	}
}
