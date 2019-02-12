package codingpractice.youtube;

public class PossibleWaysToBuildString {
	public int possibleWays(String numbers) {
		int[] memo = new int[numbers.length()];
		return possibleWays(numbers, 0, memo);
	}
	
	private int possibleWays(String msg, int currIndex, int[] memo) {
		if(currIndex >= msg.length())
			return 1;
		
		// check memo
		if(memo[currIndex] != 0)
			return memo[currIndex];
		
		int ways = 0;
		// check first index and pass down to recursive 
		int charNum = Integer.valueOf(msg.substring(currIndex, currIndex + 1));
		if(getChar(charNum) != '\0') 
			ways += possibleWays(msg, currIndex + 1, memo);
		else 
			return 0;
		
		// check first two indexes and pass down to recursive
		if(currIndex + 2 <= msg.length()) {
			charNum = Integer.valueOf(msg.substring(currIndex, currIndex + 2));
			if(getChar(charNum) != '\0')
				ways += possibleWays(msg, currIndex + 2, memo);
			else 
				return 0;
		}
		
		// sum up and return
		memo[currIndex] = ways;
		
		return ways;
	}
	
	private char getChar(int num) {
		int charNum = 0;
		char ret = '\0';
		
		if(num >= 1 && num <= 26) {
			charNum = (num - 1) + 'a';
			ret = (char)charNum;
		}
		
		return ret;
	}
}
