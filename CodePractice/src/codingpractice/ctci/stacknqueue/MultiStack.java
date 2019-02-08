package codingpractice.ctci.stacknqueue;

public class MultiStack {
	private final static int INIT_STACK_SIZE = 6;
	private int[] data;
	
	private int stackCount;
	private int[] stackSizes;
	
	public MultiStack(int stackCount) {
		this.data = new int[INIT_STACK_SIZE * stackCount];
		this.stackCount = stackCount;
		this.stackSizes = new int[stackCount];
	}
	
	public void push(int stackNum, int element) {
		// insert data into the index where the size pointed to
		ensureDataSizeCapacity(stackNum, getStackSize(stackNum));
		
		data[getDataIndex(stackNum, getStackSize(stackNum))] = element;
		stackSizes[stackNum - 1] = (getStackSize(stackNum) + 1);
	}
	
	public int pop(int stackNum) {
		// get element from stackSize - 1;
		stackSizes[stackNum - 1] = (getStackSize(stackNum) - 1);
		return data[getDataIndex(stackNum, getStackSize(stackNum))];
	}
	
	public int peek(int stackNum) {
		return data[getDataIndex(stackNum, getStackSize(stackNum) - 1)];
	}
	
	public boolean isEmpty(int stackNum) {
		return stackSizes[stackNum - 1] <= 0;
	}
	
	private void ensureDataSizeCapacity(int stackNum, int stackIndex) {
		if(data.length < getDataIndex(stackNum, stackIndex)) {
			int[] newArray = new int[data.length * 2];
			
			for(int i = 0; i < data.length; i++) {
				newArray[i] = data[i];
			}
			
			data = newArray;
		}
	}
	
	private int getDataIndex(int stackNum, int stackIndex) {
		return ((stackIndex * stackCount) + (stackNum - 1));
	}
	
	private int getStackSize(int stackNum) {
		return stackSizes[stackNum - 1];
	}
}
