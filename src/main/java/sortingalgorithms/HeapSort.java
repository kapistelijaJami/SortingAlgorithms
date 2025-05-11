package sortingalgorithms;

import java.util.Comparator;
import java.util.List;

public class HeapSort extends SortingAlgorithm {
	
	@Override
	public String getTimeComplexity() {
		return "O(n log n)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		Heap<T> heap = heapify(list, c); //creates a MAX heap
		
		while (heap.size() > 1) { //when size is 1, it's already sorted
			
			//swaps the highest value in the heap (root) with the last in the heap,
			//creating a sorted array after the heap
			swap(heap.getList(), 0, heap.size() - 1);
			heap.decreaseSize();
			
			//sifts down the new root, so it will maintain the max heap property (parent is bigger than children)
			siftDown(heap, 0, c);
		}
	}
	
	/**
	 * Builds a MAX heap out of a list.
	 * Sift down for every node that has children in reverse order.
	 * @param <T>
	 * @param list
	 * @return 
	 */
	private <T> Heap<T> heapify(List<T> list, Comparator<? super T> c) {
		Heap<T> heap = new Heap<>(list);
		
		for (int i = heap.size() - 1; i >= 0; i--) {
			if (heap.hasChildren(i)) {
				siftDown(heap, i, c);
			}
		}
		
		return heap;
	}
	
	/**
	 * Moves the node down by switching places with the higher value of its children.
	 * @param <T>
	 * @param heap
	 * @param i
	 * @param c 
	 */
	private <T> void siftDown(Heap<T> heap, int i, Comparator<? super T> c) {
		Comparator reverse = (c == null ? Comparator.reverseOrder() : c.reversed()); //get reverse comparator to compare with MAX heap
		
		while (heap.hasChildren(i)) {
			int swapIdx = getFirstIdxInOrder(heap, heap.leftChild(i), heap.rightChild(i), reverse);
			
			if (inCorrectOrderOrEqual(heap.get(i), heap.get(swapIdx), reverse)) {
				return; //node is already bigger than its child, sift down is complete
			}
			
			swap(heap.getList(), i, swapIdx);
			i = swapIdx;
		}
	}
}
