package codingpractice.ctci.recursionanddynamicprogramming;

public class FindMagicIndex {
	public int findMagicIndexFromSortedArrayRec(int[] sArray) {
		return findMagicIndexFromSortedArrayRec(sArray, 0, sArray.length - 1);
	}
	
	private int findMagicIndexFromSortedArrayRec(int[] sArray, int min, int max) {
		if(min > max)
			return -1;
		
		int mid = (max + min) / 2;
		
		//if mid is magic just return index
		if(sArray[mid] == mid)
			return mid;
		
		int recurRet = 0;
		// if sArray[mid] is > than expected mid value, check left
		if(sArray[mid] > mid)
			recurRet = findMagicIndexFromSortedArrayRec(sArray, min, mid - 1);
		else
			// if sArray[mid] is < than expected mid value, check right
			recurRet = findMagicIndexFromSortedArrayRec(sArray, mid + 1, max);
		
		return recurRet;
	}
	
	public int findMagicIndexFromSortedArrayItr(int[] sArray) {
		if(sArray == null | sArray.length == 0)
			return -1;
		
		int min = 0;
		int max = (sArray.length - 1);
		int mid = -1;
		
		while(min <= max) {
			mid = (max + min) / 2;
			if(sArray[mid] == mid)
				return mid;
			else if (sArray[mid] > mid) {
				// check left side
				max = mid - 1;
			} else {
				// sArray[mid] < mid, check right side
				min = mid + 1;
			}
		}
		
		return mid;
	}
}
