package codingpractice.ctci.recursionanddynamicprogramming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class FindPathToEndPoint {
	private static final int INVALID_VALUE = 9;
	
	public List<Point> findPathToEnd(int[][] grid){
		List<Point> path = new ArrayList<>();
		
		findPath(grid, 0, 0, path);
		
		path.add(new Point(0,0));
		
		return path;
	}
	
	private Point findPath(int[][] grid, int i, int j, List<Point> path) {
		if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0)
			return null;
		if(grid[i][j] == INVALID_VALUE)
			return null;
		if(i == grid.length - 1 && j == grid[0].length - 1)
			return new Point(i, j);
		
		// travel deep into bottom
		Point bottomPath = findPath(grid, i + 1, j, path);
		
		// travel deep into right if bottom doesn't reach
		Point rightPath = null;
		if(bottomPath == null)
			rightPath = findPath(grid, i, j + 1, path);
		
		// return my current point if any of the return from bottom or right is valid, else retur null.
		if(bottomPath == null && rightPath == null)
			return null;
		
		// check which point is valid, and add the valid point into path.  If both valid, just add one 
		Point validPoint = bottomPath == null ? rightPath : bottomPath;
		
		path.add(validPoint);
		
		return new Point(i,j);
	}
}
