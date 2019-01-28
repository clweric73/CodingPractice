package codingpractice.coursera.dividenconquer;

public class NumberOfInversionCount{
	private long inversionCount;
	
	public NumberOfInversionCount(){
		this.inversionCount = 0;
	}
	
	public int[] countInversion(int[] origArray) {
		return mergeSort(origArray, 0, origArray.length - 1);
	}

	private int[] mergeSort(int[] origArray, int startIndex, int endIndex) {
		if(startIndex >= endIndex)
			return new int[] {origArray[startIndex]};
		
		int mid = ((endIndex - startIndex) / 2) + startIndex;
		int[] leftArray = mergeSort(origArray, startIndex, mid);
		int[] rightArray = mergeSort(origArray, mid+1, endIndex);
		
		return mergeArrays(leftArray, rightArray);
	}
	
	private int[] mergeArrays(int[] arrayA, int[] arrayB) {
		int[] ret = new int[arrayA.length + arrayB.length];
		
		int indexA = 0;
		int indexB = 0;
		for(int i = 0; i < ret.length; i++) {
			if(indexA == arrayA.length) {
				ret[i] = arrayB[indexB];
				indexB++;
				continue;
			} else if (indexB == arrayB.length) {
				ret[i] = arrayA[indexA];
				indexA++;
				continue;
			}
			
			if(arrayA[indexA] <= arrayB[indexB]) {
				ret[i] = arrayA[indexA];
				indexA++;
			}
			else {
				ret[i] = arrayB[indexB];
				inversionCount += (arrayA.length - indexA);
				indexB++;
			}
		}
		
		return ret;
	}
	
	public long getInversionCount() {
		return inversionCount;
	}
}
