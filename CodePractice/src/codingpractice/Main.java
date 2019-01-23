package codingpractice;

import java.math.BigInteger;
import java.util.Arrays;

import codingpractice.algorithm.CaesarCipher;
import codingpractice.algorithm.FibonacciNumber;
import codingpractice.algorithm.FibonacciNumberIter;
import codingpractice.algorithm.FibonacciNumberRecur;
import codingpractice.algorithm.KaratsubaMultiplication;
import codingpractice.datastructure.BinaryTree;
import codingpractice.datastructure.MultiplyMatrix;
import codingpractice.datastructure.Node;
import codingpractice.dynamicprogramming.AllPossibleCharactersFromNumber;
import codingpractice.dynamicprogramming.MakeChange;
import codingpractice.dynamicprogramming.Permutations;
import codingpractice.dynamicprogramming.ShortestPathToFindGold;
import codingpractice.search.BfsInorderTreeTraversalRecursive;
import codingpractice.search.BfsInorderTreeTraversalStack;
import codingpractice.search.BfsPostorderTreeTraversalRecursive;
import codingpractice.search.BfsPostorderTreeTraversalStack;
import codingpractice.search.BfsPreorderTreeTraversalRecursive;
import codingpractice.search.BfsPreorderTreeTraversalStack;
import codingpractice.search.BinarySearch;
import codingpractice.search.DisplayData;
import codingpractice.sort.MergeSort;
import codingpractice.sort.QuickSort;
import codingpractice.sort.Sort;

public class Main {

	public static void main(String[] args) throws Exception {
//		BinaryTree bTree = new BinaryTree();
//		Node root = bTree.generateStructureWithRandomData();
//		
//		TraversalTreeRecursive(root);
//		TraversalTreeStack(root);
//		MakeChange m = new MakeChange();
//		System.out.println(m.howManyWaysToMakeChange(new int[] {25, 10, 5, 1}, 27));
		
		int[] a = new int[]{3,7,2,1,6,9,3,3,9};
		//Sort s = new QuickSort();
		Sort s = new MergeSort();
		int[] b = s.sortArray(a);
		System.out.println(Arrays.toString(b));
		
//		int[][] grid = {{1,1,0,0,1,0}, {1,1,0,0,1,1}, {0,1,1,9,1,1}, {1,1,1,1,1,1}, {1,1,1,1,1,1}};
//		ShortestPathToFindGold finder = new ShortestPathToFindGold();
//		System.out.println(finder.shortestPathToFindGold(grid, 0, 0));
		
//		String cipher = "bcdefghijklmnopqrstuvwxyza";
//		CaesarCipher decryptEngin = new CaesarCipher();
//		System.out.println(decryptEngin.decrypt(cipher, -27));
//		
//		int term = 13;
//		FibonacciNumber fib = new FibonacciNumberIter();
//		System.out.println("Fib term " + term + " = " + fib.findFib(term));
//		
//		fib = new FibonacciNumberRecur();
//		System.out.println("Fib term " + term + " = " + fib.findFib(term));
//		MakeChange mc = new MakeChange();
//		int[] coinTypes = new int[] {25,10,5,1};
//		int ways = mc.howManyWaysToMakeChange(coinTypes, 27);
//		System.out.println(ways + " ways to make change.");
		
//		AllPossibleCharactersFromNumber a = new AllPossibleCharactersFromNumber();
//		a.printAllPossibleCharacters(new int[] {2,3,4});
		
//		char[] chars = new char[] {'A', 'B', 'C'};
//		Permutations perm = new Permutations();
//		perm.showPermutationWithRepeat(chars, "");
//		System.out.println("======================");
//		perm.showPermutationNoRepeat(chars, 0, "");
		
//		int[] nums = new int[] {1,4,5,10,20,100,200};
//		BinarySearch search = new BinarySearch();
//		System.out.println(search.isElementFound(nums, 103));
		
		//BigInteger num1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
		//BigInteger num2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
//		KaratsubaMultiplication mult = new KaratsubaMultiplication();
//		BigInteger num1 = new BigInteger("5678");
//		BigInteger num2 = new BigInteger("4321");
//		System.out.println(mult.karatsubaMult(num1, num2));
		
		int[][] arrayA = new int[][] {{3,2},{7,8}};
		int[][] arrayB = new int[][] {{1,3},{2,6}};
		MultiplyMatrix matrixCalc = new MultiplyMatrix();
		System.out.println(Arrays.deepToString(matrixCalc.multiplyMatrix(arrayA, arrayB)));
	}

	private static void TraversalTreeStack(Node root) {
		System.out.println("\n== Pre Order ==");
		
		DisplayData  treeDisplay = new BfsPreorderTreeTraversalStack();
		treeDisplay.displayData(root);
		
		System.out.println("\n== Post Order ==");
		
		treeDisplay = new BfsPostorderTreeTraversalStack();
		treeDisplay.displayData(root);
		
		System.out.println("\n== In Order ==");
		
		treeDisplay = new BfsInorderTreeTraversalStack();
		treeDisplay.displayData(root);
	}

	private static void TraversalTreeRecursive(Node root) {
		System.out.println("== Pre Order ==");
		
		DisplayData treeDisplay = new BfsPreorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
		
		System.out.println("\n== Post Order ==");
		
		treeDisplay = new BfsPostorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
		
		System.out.println("\n== In Order ==");
		
		treeDisplay = new BfsInorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
	}

}
