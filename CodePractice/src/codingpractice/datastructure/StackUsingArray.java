package codingpractice.datastructure;

public class StackUsingArray implements Stack {
	private static final int ARRAY_INIT_SIZE = 6;
	private int[] data;
	private int stackSize;
	
	public StackUsingArray(){
		this.data = new int[ARRAY_INIT_SIZE];
		this.stackSize = 0;
	}
	
	@Override
	public void push(int element) {
		if(stackSize >= data.length){
			// extend array and copy all elements
			extendArrayAndCopyElements();
		}
		
		data[stackSize] = element;
		stackSize++;
	}

	@Override
	public int pop() throws Exception {
		if(stackSize <= 0)
			throw new Exception("Stack is empty.");
		
		stackSize--;
		
		return data[stackSize];
	}

	@Override
	public int getSize() {
		return stackSize;
	}

	private void extendArrayAndCopyElements(){
		int[] newArray = new int[data.length * 2];
		
		for(int i = 0; i < data.length; i++)
			newArray[i] = data[i];
		
		this.data = newArray;
	}
}
