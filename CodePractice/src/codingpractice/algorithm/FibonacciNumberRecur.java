package codingpractice.algorithm;

public class FibonacciNumberRecur implements FibonacciNumber {
	/* (non-Javadoc)
	 * @see codingpractice.algorithm.FibonacciNumber#findFib(int)
	 */
	@Override
	public int findFib(int term) {
		if(term == 1)
			return 0;
		if(term == 2)
			return 1;
		
		return findFib(term -1) + findFib(term - 2);
	}
}
