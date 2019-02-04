package codingpractice.datastructure;

public class QueueUsingArray implements Queue {
	private static final int INITAL_ARRAY_SIZE = 6;
	private int[] data;
	private int queueSize;
	private int headIndex;
	private int tailIndex;
	
	public QueueUsingArray(){
		this.data = new int[INITAL_ARRAY_SIZE];
		this.queueSize = 0;
		this.headIndex = 0;
		this.tailIndex = 0;
	}
	
	@Override
	public void enQueue(int element) throws Exception{
		if(queueSize >= data.length){
			extendArraySizeAndCopy();
		}
		
		data[tailIndex] = element;
		tailIndex++;
		queueSize++;
		
		// check if tail exceeded array size
		if(tailIndex >= data.length){
			tailIndex = 0;
		}
	}

	@Override
	public int deQueue() throws Exception{
		if(queueSize <= 0)
			throw new Exception("Queue is empty.");
		
		// return headIndex element
		int ret = data[headIndex];
		headIndex++;
		queueSize--;
		
		// move headIndex element
		if(headIndex >= data.length)
			headIndex = 0;
		
		return ret;
	}

	@Override
	public int getSize() {
		return queueSize;
	}

	private void extendArraySizeAndCopy() throws Exception{
		int[] newArray = new int[data.length * 2];
		for(int i = 0; i < data.length; i++){
			newArray[i] = data[headIndex];
			headIndex++;
			if(headIndex >= data.length)
				headIndex = 0;
		}
		
		data = newArray;
		headIndex = 0;
		tailIndex = queueSize;
		
	}
}
