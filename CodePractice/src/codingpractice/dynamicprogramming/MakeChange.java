package codingpractice.dynamicprogramming;

public class MakeChange {
	public int howManyWaysToMakeChange(int[] coins, int cents) {
		return makeChange(coins, cents, 0, "");
	}
	
	private int makeChange(int[] coins, int total, int index, String c) {
		if(total == 0) {
			System.out.println(c);
			return 1;
		}
	
		if(index >= coins.length)
			return 0;
		
		int ways = 0;
		int coinSum = 0;
		
		while(coinSum <= total) {
			ways += makeChange(coins, total - coinSum, index + 1, c);
			c = c + coins[index] + ", ";
			coinSum += coins[index];
		}
		
		return ways;
	}
}	
