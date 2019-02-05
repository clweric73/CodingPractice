package codingpractice.ctci.arraynstring;

public class OneAway {
	public boolean isOneOperationAway(String msgA, String msgB) {
		// more than 2 op return false right away
		if(Math.abs(msgA.length() - msgB.length()) > 1)
			return false;
		
		boolean isMisMatchFound = false;
		// if size equal, just do a index to index comparsion
		if(msgA.length() == msgB.length()) {
			for(int i = 0; i < msgA.length(); i++) {
				if(msgA.charAt(i) != msgB.charAt(i)) {
					if(isMisMatchFound)
						return false; // 2 mismatches
					else
						isMisMatchFound = true;
				} 
			}
			
			return true;
		}
		
		// if size not equal, iterate long msg and allow one mismatch.
		String shorterMsg = msgA.length() > msgB.length() ? msgB : msgA;
		String longerMsg = msgA.length() < msgB.length() ? msgB : msgA;
		int shortMsgIndex = 0;
		int longMsgIndex = 0;
		
		while(longMsgIndex < longerMsg.length() && shortMsgIndex < shorterMsg.length()) {
			// if char equals, move on
			if(longerMsg.charAt(longMsgIndex) == shorterMsg.charAt(shortMsgIndex)) {
				longMsgIndex++;
				shortMsgIndex++;
			} else {
				// if not equal update mismatch flag
				if(isMisMatchFound)
					return false;
				else {
					isMisMatchFound = true;
					longMsgIndex++;
				}
			}
		}
		
		return true;
	}
}
