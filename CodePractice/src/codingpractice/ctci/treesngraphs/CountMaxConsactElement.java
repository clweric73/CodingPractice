package codingpractice.ctci.treesngraphs;

import java.util.Stack;

public class CountMaxConsactElement {
	
	public int maxConsactElementCount(char[][] grid){
		boolean[][] visited = new boolean[grid.length][grid[0].length]; // default with false
		
		int maxCount = 0;
		int tempCount = 0;
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				tempCount = maxConsactElementCount(grid, row, col, visited, '\0');
				maxCount = (tempCount > maxCount) ? tempCount : maxCount;
			}
		}
		
		return maxCount;
	}
	
	private int maxConsactElementCount(char[][] grid, int i, int j, boolean[][] visited, char parentChar){
		// valid check.  color, isVisited, same char, not \0
		if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || visited[i][j] == true)
			return 0;
		
		// check if color matches.  Allow first parentChar to enter the function
		if(parentChar != grid[i][j] && parentChar != '\0')
			return 0;
		
		int consactSum = 0;
		
		// mark visited on this element
		visited[i][j] = true;
		
		// travel to top
		consactSum += maxConsactElementCount(grid, i - 1, j, visited, grid[i][j]);
		
		// travel to left
		consactSum += maxConsactElementCount(grid, i, j - 1, visited, grid[i][j]);
		
		// travel to bottom
		consactSum += maxConsactElementCount(grid, i + 1, j, visited, grid[i][j]);
		
		// travel to right
		consactSum += maxConsactElementCount(grid, i, j + 1, visited, grid[i][j]);
		
		// return sum of all values
		return (consactSum + 1);
	}
}
