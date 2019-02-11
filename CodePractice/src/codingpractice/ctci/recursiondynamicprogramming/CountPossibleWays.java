package codingpractice.ctci.recursiondynamicprogramming;

public class CountPossibleWays {
	public int possibleWays(int[] choice, int currChoice, int remainder){
		if(remainder == 0)
			return 1;
		if(remainder < 0 || currChoice >= choice.length)
			return 0;
		
		int ways = 0;
		// reduce remainder while in the loop.
		while(remainder >= 0){
			ways += possibleWays(choice, currChoice + 1, remainder);
			remainder -= choice[currChoice];
		}
		
		return ways;
	}
}
