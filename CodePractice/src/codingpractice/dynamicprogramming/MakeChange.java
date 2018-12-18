package codingpractice.dynamicprogramming;

public class MakeChange {
	public int howManyWaysToMakeChange(int[] coins, int cents) {
		return makeChange(coins, cents, 0);
	}
	
	private int makeChange(int[] coins, int total, int index) {
		if(total == 0)
			return 1;
		if ( index >= coins.length)
			return 0;
		
		int ways = 0;
		
		int coinSum = 0;
		int remain = 0;
		while(remain >= coins[index]) {
			coinSum += coins[index];
			remain = total - coinSum;
			ways += makeChange(coins, remain, index + 1);
		}
		
		return ways;
	}
}	
