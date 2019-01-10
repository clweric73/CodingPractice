package codingpractice.search;

public class BinarySearch {
	public boolean isElementFound(int[] sortedElements, int element) {
		boolean isFound = false;
		
		int start = 0;
		int end = (sortedElements.length - 1);
		int mid;
		
		while(start <= end) {
			mid = ((start + end) / 2);
			if(sortedElements[mid] == element)
				return true;
			else if(element > sortedElements[mid]) {
				start = mid + 1;
			} else 
				end = mid - 1;
		}
		
		return isFound;
	}
}
