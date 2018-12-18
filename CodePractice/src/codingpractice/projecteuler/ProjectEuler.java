package codingpractice.projecteuler;

public class ProjectEuler {
	public static void main(String[] args) {
//		System.out.println(largestProductInASeries(13,
//				"73167176531330624919225119674426574742355349194934"
//						+ "96983520312774506326239578318016984801869478851843"
//						+ "85861560789112949495459501737958331952853208805511"
//						+ "12540698747158523863050715693290963295227443043557"
//						+ "66896648950445244523161731856403098711121722383113"
//						+ "62229893423380308135336276614282806444486645238749"
//						+ "30358907296290491560440772390713810515859307960866"
//						+ "70172427121883998797908792274921901699720888093776"
//						+ "65727333001053367881220235421809751254540594752243"
//						+ "52584907711670556013604839586446706324415722155397"
//						+ "53697817977846174064955149290862569321978468622482"
//						+ "83972241375657056057490261407972968652414535100474"
//						+ "82166370484403199890008895243450658541227588666881"
//						+ "16427171479924442928230863465674813919123162824586"
//						+ "17866458359124566529476545682848912883142607690042"
//						+ "24219022671055626321111109370544217506941658960408"
//						+ "07198403850962455444362981230987879927244284909188"
//						+ "84580156166097919133875499200524063689912560717606"
//						+ "05886116467109405077541002256983155200055935729725"
//						+ "71636269561882670428252483600823257530420752963450"));
		System.out.println(totalPathToSqureGrid(20));
	}

	// P1
	public static int multiplesOf3and5() {
		int sum = 0;

		for (int i = 1; (3 * i) < 1000; i++) {
			sum += (3 * i);
		}

		for (int i = 1; (5 * i) < 1000; i++) {
			if ((5 * i) % 3 != 0)
				sum += (5 * i);
		}

		return sum;
	}

	// P2
	public static int evenFibonacciNumbers() {
		int limit = 4000000;
		int sum = 2;

		int firstNum = 1;
		int secondNum = 2;
		int currNum = 0;

		for (int i = 3; secondNum < limit; i++) {
			currNum = firstNum + secondNum;

			if (currNum % 2 == 0 && currNum < limit)
				sum += currNum;

			firstNum = secondNum;
			secondNum = currNum;
		}

		return sum;
	}

	// P3
	public static int largestPrimeFactor() {
		long num = 600851475143L / 2;
		int prime = 5;

		for (int i = 5; i * i < num; i++) {
			if ((num % i) == 0 && isPrime(i)) {
				prime = i;
			}
		}

		return prime;
	}

	private static boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// P8
	private static long largestProductInASeries(int adjCount, String digits) {
		long productOfDigits = 1;
		long productOfNewDigits = 1;

		for (int i = 0; i < digits.length() - adjCount; i++) {
			productOfNewDigits = 1;
			
			for (int j = i; j < adjCount + i; j++){
				productOfNewDigits *= Integer.valueOf(String.valueOf(digits.charAt(j)));
			}

			if (productOfNewDigits > productOfDigits)
				productOfDigits = productOfNewDigits;
		}

		return productOfDigits;
	}
	
	// P16
	public static long totalPathToSqureGrid(int size){
		long[][] grid = new long[size+1][size+1];
		return travelDownAndRightIterative(grid);
	}
	
	private static int travelDownAndRight(long[][] grid, int row, int col){
		if(row == grid.length -1 && col == grid[0].length-1)
			return 1;
		if(row >= grid.length || col >= grid[0].length)
			return 0;
		
		
		return travelDownAndRight(grid, row + 1, col) + travelDownAndRight(grid, row, col + 1);

	}
	
	private static long travelDownAndRightIterative(long[][] grid){
		grid[grid.length -1][grid[0].length -1] = 1;
		for(int i = grid.length -1; i >= 0; i--){
			for(int j = grid[0].length -1; j >= 0; j--){
				grid[i][j] += sumDownAndRight(grid, i, j);
			}
		}
		return grid[0][0];
	}
	
	private static long sumDownAndRight(long[][] grid, int row, int col){
		long down = 0;
		long right = 0;
		if(row + 1 >= grid.length)
			down = 0;
		else
			down = grid[row + 1][col];
		
		if(col + 1 >= grid[0].length)
			right = 0;
		else 
			right = grid[row][col + 1];
		
		return down + right;
	}
}
