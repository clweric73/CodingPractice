package codingpractice.coursera.dividenconquer;

public class MultiplyMatrixRecur {
	public int[][] multiplyMatrix(int[][] matrixA, int[][] matrixB){
		if(matrixA.length == 1) {
			return new int[][] {{matrixA[0][0] * matrixB[0][0]}};
		}
			
		// {{AE + BG, AF + BH}, {CE + DG, CF + DH}}
		int[][] ae = multiplyMatrix(getTopLeftMatrix(matrixA), getTopLeftMatrix(matrixB));
		int[][] bg = multiplyMatrix(getTopRightMatrix(matrixA), getBottomLeftMatrix(matrixB));
		int[][] af = multiplyMatrix(getTopLeftMatrix(matrixA), getTopRightMatrix(matrixB));
		int[][] bh = multiplyMatrix(getTopRightMatrix(matrixA), getBottomRightMatrix(matrixB));
		int[][] ce = multiplyMatrix(getBottomLeftMatrix(matrixA), getTopLeftMatrix(matrixB));
		int[][] dg = multiplyMatrix(getBottomRightMatrix(matrixA), getBottomLeftMatrix(matrixB));
		int[][] cf = multiplyMatrix(getBottomLeftMatrix(matrixA), getTopRightMatrix(matrixB));
		int[][] dh = multiplyMatrix(getBottomRightMatrix(matrixA), getBottomRightMatrix(matrixB));
		
		int[][] product = new int[matrixA.length][matrixA.length];
		
		fillTopLeftMatrix(product, sumMatrix(ae, bg));
		fillTopRightMatrix(product, sumMatrix(af, bh));
		fillBottomLeftMatrix(product, sumMatrix(ce, dg));
		fillBottomRightMatrix(product, sumMatrix(cf, dh));
		
		return product;
	}
	
	private int[][] sumMatrix(int[][] matrixA, int[][] matrixB) {
		
		int[][] sum = new int[matrixA.length][matrixA.length];
		for(int row = 0; row < matrixA.length; row++) {
			for(int col = 0; col < matrixA[0].length; col++) {
				sum[row][col] = matrixA[row][col] + matrixB[row][col];
			}
		}
		
		return sum;
	}
	
	public int[][] getTopLeftMatrix(int[][] matrix){
		int halfSize = matrix.length/2;
		int[][] subMatrix = new int[halfSize][halfSize];
		
		for(int row = 0; row < halfSize; row++) {
			for(int col = 0; col < halfSize; col++) {
				subMatrix[row][col] = matrix[row][col];
			}
		}
		
		return subMatrix;
	}
	
	public int[][] getTopRightMatrix(int[][] matrix){
		int halfSize = matrix.length/2;
		int[][] subMatrix = new int[halfSize][halfSize];
		
		for(int row = 0; row < halfSize; row++) {
			for(int col = halfSize; col < matrix.length; col++) {
				subMatrix[row][col - halfSize] = matrix[row][col];
			}
		}
		
		return subMatrix;
	}
	
	public int[][] getBottomLeftMatrix(int[][] matrix){
		int halfSize = matrix.length/2;
		int[][] subMatrix = new int[halfSize][halfSize];
		
		for(int row = halfSize; row < matrix.length; row++) {
			for(int col = 0; col < halfSize; col++) {
				subMatrix[row - halfSize][col] = matrix[row][col];
			}
		}
		
		return subMatrix;
	}
	
	public int[][] getBottomRightMatrix(int[][] matrix){
		int halfSize = matrix.length/2;
		int[][] subMatrix = new int[halfSize][halfSize];
		
		for(int row = halfSize; row < matrix.length; row++) {
			for(int col = halfSize; col < matrix.length; col++) {
				subMatrix[row - halfSize][col - halfSize] = matrix[row][col];
			}
		}
		
		return subMatrix;
	}
	
	public void fillTopLeftMatrix(int[][] dest, int[][] src){
		for(int row = 0; row < src.length; row++) {
			for(int col = 0; col < src[0].length; col++) {
				dest[row][col] = src[row][col];
			}
		}
	}
	
	public void fillTopRightMatrix(int[][] dest, int[][] src){
		int halfSize = src.length;
		for(int row = 0; row < src.length; row++) {
			for(int col = 0; col < src[0].length; col++) {
				dest[row][col + halfSize] = src[row][col];
			}
		}
	}
	
	public void fillBottomLeftMatrix(int[][] dest, int[][] src){
		int halfSize = src.length;
		for(int row = 0; row < src.length; row++) {
			for(int col = 0; col < src[0].length; col++) {
				dest[row + halfSize][col] = src[row][col];
			}
		}	
	}
	
	public void fillBottomRightMatrix(int[][] dest, int[][] src){
		int halfSize = src.length;
		for(int row = 0; row < src.length; row++) {
			for(int col = 0; col < src[0].length; col++) {
				dest[row + halfSize][col + halfSize] = src[row][col];
			}
		}
	}
}
