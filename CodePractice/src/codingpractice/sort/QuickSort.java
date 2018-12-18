package codingpractice.sort;

public class QuickSort implements Sort {

	@Override
	public int[] sortArray(int[] origArray) {
		quickSort(origArray, 0, (origArray.length - 1));
		return origArray;
	}
	
	private void quickSort(int[] origArray, int startIndex, int endIndex){
		if(startIndex >= endIndex)
			return;
		
		int pivotValue = origArray[startIndex];
		int left = startIndex;
		int right = endIndex;
		
		while(left <= right){
			if(origArray[left] >= pivotValue && origArray[right] <= pivotValue){
				swap(origArray, left, right);
				left++;
				right--;
			} else if (origArray[left] < pivotValue)
				left++;
			else if (origArray[right] > pivotValue)
				right--;	
		}
		quickSort(origArray, startIndex, left - 1);
		quickSort(origArray, left, endIndex);
	}
	
	private void swap(int[] array, int firstIndex, int secondIndex){
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
}
