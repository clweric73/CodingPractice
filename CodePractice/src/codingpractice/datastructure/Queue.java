package codingpractice.datastructure;

public interface Queue {
	public void enQueue(int element) throws Exception;
	public int deQueue() throws Exception;
	public int getSize();
}
