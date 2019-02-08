package codingpractice.ctci.arraynstring;

public class StringCompression {
	public String doStringComparission(String msg) {
		StringBuilder compressedMsg = new StringBuilder();
		
		char currChar = ' ';
		char prevChar = msg.charAt(0);
		int repeatCharCount = 1;
		
		for(int i = 1; i < msg.length(); i++) {
			currChar = msg.charAt(i);
			// if equal increment count and move on
			if( currChar == prevChar)
				repeatCharCount++;
			else {
				// if not equal 
				//wrap up previous data to compressMsg, 
				compressedMsg.append(prevChar);
				compressedMsg.append(repeatCharCount);
				
				//reset currChar and repeatCount, 
				prevChar = currChar;
				repeatCharCount = 1;
			}
		}
		
		// append the last set of data
		compressedMsg.append(currChar);
		compressedMsg.append(repeatCharCount);
		
		// compare if compressed msg is shorter than orig msg.
		if(compressedMsg.length() < msg.length())
			return compressedMsg.toString();
		else 
			return msg;
	}
}
