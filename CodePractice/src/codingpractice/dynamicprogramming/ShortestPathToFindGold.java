package codingpractice.dynamicprogramming;

public class ShortestPathToFindGold {
	private static final int LAND_VALUE = 1;
	private static final int WATER_VALUE = 0;
	private static final int GOLD_VALUE = 9;
	
	public int shortestPathToFindGold(int[][] grid, int row, int col) {
		if(row >= grid.length || col >= grid[0].length)
			return -1;
		if(grid[row][col] == GOLD_VALUE)
			return 1;
		if(grid[row][col] == WATER_VALUE)
			return -1;
		
		int retFromDown = 0;
		int retFromRight = 0;
		retFromDown = shortestPathToFindGold(grid, row + 1, col);
		retFromRight = shortestPathToFindGold(grid, row, col + 1);
		
		if(retFromDown == -1 && retFromRight == -1)
			return -1;
		else if (retFromDown == -1)
			return retFromRight + 1;
		else if (retFromRight == -1)
			return retFromDown + 1;
		else 
			return (Math.min(retFromDown, retFromRight) + 1);
	}
}
