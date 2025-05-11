package sortingalgorithms;

import java.util.List;

public class Heap<T> {
	private List<T> list;
	private int size; //this is used for separating the sorted part and heap part
	
	public Heap(List<T> list) {
		this.list = list;
		size = list.size();
	}
	
	public boolean isInside(int i) {
		return i >= 0 && i < size;
	}
	
	public int parent(int i) {
		return (int) (i - 1) / 2; //rounds down
	}
	
	public int leftChild(int i) {
		return 2 * i + 1;
	}
	
	public int rightChild(int i) {
		return 2 * i + 2;
	}
	
	public T getParent(int i) {
		i = parent(i);
		if (!isInside(i)) {
			return null;
		}
		return list.get(i);
	}
	
	public T getLeftChild(int i) {
		i = leftChild(i);
		if (!isInside(i)) {
			return null;
		}
		return list.get(i);
	}
	
	public T getRightChild(int i) {
		i = rightChild(i);
		if (!isInside(i)) {
			return null;
		}
		return list.get(i);
	}
	
	public T get(int i) {
		return list.get(i);
	}
	
	public List<T> getList() {
		return list;
	}
	
	public boolean hasLeftChild(int i) {
		return isInside(leftChild(i));
	}
	
	public boolean hasRightChild(int i) {
		return isInside(rightChild(i));
	}
	
	public boolean hasChildren(int i) {
		return hasLeftChild(i) || hasRightChild(i);
	}
	
	public int size() {
		return size;
	}
	
	@Deprecated
	public int listSize() { //Not using this in the sorting algorithm
		return list.size();
	}
	
	public void decreaseSize() {
		size--;
	}
	
	public void increaseSize() {
		size++;
	}
}
