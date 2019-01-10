package codingpractice.dynamicprogramming;

public class Permutations {
	public void showPermutationWithRepeat(char[] chars, String s) {
		if(s.length() >= chars.length) {
			System.out.println(s);
			return;
		}
		
		for(int i = 0; i < chars.length; i++) {
			showPermutationWithRepeat(chars, s + chars[i]);
		}
	}
	
	public void showPermutationNoRepeat(char[] chars, int index, String s) {
		if(index >= chars.length) {
			System.out.println(s);
			return;
		}
		
		for(int i = index; i < chars.length; i++) {
			swapChar(chars, index, i);
			showPermutationNoRepeat(chars, (index + 1), s + chars[index]);
		}
	}
	
	private void swapChar(char[] chars, int index1, int index2) {
		char temp = chars[index1];
		chars[index1] = chars[index2];
		chars[index2] = temp;
	}
}
