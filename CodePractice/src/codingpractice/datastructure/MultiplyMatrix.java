package codingpractice.datastructure;

public class MultiplyMatrix {
	public int[][] multiplyMatrix(int[][] a, int[][] b){
		int[][] product = new int[a.length][a[0].length];
		
		// iterate through product table
		for(int row = 0; row < a.length; row++) {
			for(int col = 0; col < a[0].length; col++) {
				int sum = 0;
				for(int i = 0; i < a.length; i++) {
					sum += a[row][i] * b[i][col];
				}
				product[row][col] = sum;
			}
		}
		
		return product;
	}
}
