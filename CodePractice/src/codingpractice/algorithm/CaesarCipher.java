package codingpractice.algorithm;

public class CaesarCipher{
	public String decrypt(String cipher, int shiftedCount) throws Exception{
		char[] cipherArray = cipher.toCharArray();
		
		for(int i = 0; i < cipherArray.length; i++)
			cipherArray[i] = shiftChar(cipherArray[i], shiftedCount);
		
		return new String(cipherArray);
	}
	
	private char shiftChar(char origChar, int shiftedCount) throws Exception{
		if(origChar == ' ')
			return origChar;
		
		// ensure shifted count is within 26
		shiftedCount = shiftedCount % 26;
		
		int origAsciiChar = (int)origChar;
		int shiftedAsciiChar = origAsciiChar + shiftedCount;
		// check lower case 
		int zAscii = 'z';
		int aAscii = 'a';
		int ZAscii = 'Z';
		int AAscii = 'A';
		
		if(origAsciiChar >= aAscii && origAsciiChar <= zAscii) {
			// lower case character
			// handle shifted char that needs rotation
			if(shiftedAsciiChar > zAscii) 
				shiftedAsciiChar = ((shiftedAsciiChar - zAscii) + (aAscii - 1));
			else if(shiftedAsciiChar < aAscii)
				shiftedAsciiChar = (zAscii + 1) - (aAscii - shiftedAsciiChar);

		} else if (origAsciiChar >= AAscii && origAsciiChar <= ZAscii) {
			// upper case character
			// handle shifted char that needs rotation
			if(shiftedAsciiChar > ZAscii) 
				shiftedAsciiChar = ((shiftedAsciiChar - ZAscii) + (AAscii - 1));
			else if(shiftedAsciiChar < AAscii)
				shiftedAsciiChar = (ZAscii + 1) - (AAscii - shiftedAsciiChar);
		} else 
			throw new Exception("Non-alphabet character.");
		
		return (char)shiftedAsciiChar;
	}
}
