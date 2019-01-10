package codingpractice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleCharactersFromNumber {
	public void printAllPossibleCharacters(int[] numbers) {
		List<String> sList = new ArrayList<String>();
		printChars(numbers, 0, "", sList);
		
		System.out.println(sList);
	}
	
	private void printChars(int[] numbers, int index, String s, List<String> sList) {
		if(index == numbers.length) {
			sList.add(s);
			return;
		}
		
		char[] characters = getChars(numbers[index]);
		index++;
		for(int i = 0; i < characters.length; i++)
			printChars(numbers, index, s + characters[i], sList);
	}
	
	private char[] getChars(int number) {
		char[] ret;
		
		switch(number) {
		case 1:
			ret = new char[] {'.', '/', '@'};
			break;
		case 2:
			ret = new char[] {'A', 'B', 'C'};
			break;
		case 3:
			ret = new char[] {'D', 'E', 'F'};
			break;
		case 4: 
			ret = new char[] {'G', 'H', 'I'};
			break;
		case 5:
			ret = new char[] {'J', 'K', 'L'};
			break;
		case 6:
			ret = new char[] {'M', 'N', 'O'};
			break;
		case 7:
			ret = new char[] {'P', 'Q', 'R', 'S'};
			break;
		case 8:
			ret = new char[] {'T', 'U', 'V'};
			break;
		case 9:
			ret = new char[] {'W', 'X', 'Y', 'Z'};
			break;
		default:
			ret = new char[] {};
			break;
		}
		
		return ret;
	}
}
