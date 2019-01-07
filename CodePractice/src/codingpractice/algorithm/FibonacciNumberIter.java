package codingpractice.algorithm;

public class FibonacciNumberIter implements FibonacciNumber{

	@Override
	public int findFib(int term) {
		if(term == 1)
			return 0;
		if(term == 2)
			return 1;
		
		int prevNum = 0;
		int currNum = 1;
		
		for(int i = 3; i <= term; i++) {
			currNum = currNum + prevNum;
			prevNum = currNum - prevNum;
		}
			
		return currNum;
	}

}
