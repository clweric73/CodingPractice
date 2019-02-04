package codingpractice.datastructure;

// Max Heap
public class Heap {
	private static final int INIT_ARRAY_SIZE = 6;
	private int[] data;
	private int size;
	
	public Heap(){
		this.data = new int[INIT_ARRAY_SIZE];
		this.size = 0;
	}
	
	public void insert(int element){
		// extend array size if bigger
		ensureArraySizeCapable();
		
		data[size] = element;
		size++;
		
		shiftAddedElementUp();
	}
	
	public int remove() throws Exception{
		if (size == 0)
			throw new Exception("Heap is empty");
		
		int ret = data[0];
		data[0] = data[size -1];
		size--;
		
		shiftRootElementDown();
		
		return ret;
	}
	
	private int getLeftChildIndex(int currentIndex){
		return ((currentIndex * 2) + 1);
	}
	
	private int getRightChildIndex(int currentIndex){
		return ((currentIndex * 2) + 2);
	}
	
	private int getParentIndex(int currentIndex){
		return ((currentIndex - 1) / 2);
	}
	
	private boolean hasLeftChild(int currentIndex){
		return getLeftChildIndex(currentIndex) < size;
	}
	
	private boolean hasRightChild(int currentIndex){
		return getRightChildIndex(currentIndex) < size;
	}
	
	private boolean hasParent(int currentIndex){
		return getParentIndex(currentIndex) >= 0;
	}
	
	private void swap(int indexA, int indexB){
		int value = data[indexA];
		data[indexA] = data[indexB];
		data[indexB] = value;
	}
	
	private void ensureArraySizeCapable(){
		if(size >= data.length){
			int[] newArray = new int[data.length * 2];
			
			for(int i = 0; i < data.length; i++){
				newArray[i] = data[i];
			}
			
			data = newArray;
		}
	}
	
	private void shiftAddedElementUp(){
		int currentIndex = size - 1;
		
		while(hasParent(currentIndex) && data[getParentIndex(currentIndex)] < data[currentIndex]){
			swap(currentIndex, getParentIndex(currentIndex));
			currentIndex = getParentIndex(currentIndex);
		}
	}
	
	private void shiftRootElementDown(){
		int currentIndex = 0;
		
		// check left child is the same as check if there is any children
		while(hasLeftChild(currentIndex)){
			int biggestChildIndex = getLeftChildIndex(currentIndex);
			// check rigth child
			if(hasRightChild(currentIndex) && data[getRightChildIndex(currentIndex)] > data[getLeftChildIndex(currentIndex)])
				biggestChildIndex = getRightChildIndex(currentIndex);
			
			if(data[currentIndex] > data[biggestChildIndex])
				break;
			else{
				swap(currentIndex, biggestChildIndex);
				currentIndex = biggestChildIndex;
			}
		}
	}
}
