package sortingalgorithms;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BogoSort extends SortingAlgorithm {
	
	@Override
	public String getTimeComplexity() {
		return "O(n * n!)";
	}
	
	@Override
	public <T> void sort(List<T> list, Comparator<? super T> c) {
		Random rand = new Random();
		
		while (true) {
			boolean failed = false;
			for (int i = 0; i < list.size() - 1; i++) { //check if list is in order
				if (!inCorrectOrderOrEqual(list, i, i + 1, c)) {
					failed = true;
					break;
				}
			}
			
			if (!failed) {
				break; //is sorted
			}
			
			SortingHelperFunctions.shuffleList(list, rand); //shuffle
		}
	}
}
