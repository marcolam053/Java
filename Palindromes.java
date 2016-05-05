public class Palindromes {
	/**
	 * Returns true if word is a palindrome, false if not
	 */
	public static boolean isPalindrome(String word) {
		
		// How you make a stack
		
		Stack<Character> stack = new BasicStack<Character>();
		
		// Pushing the characters of the words into the stack
		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}
		
		// If one letter is different, then it is not a palindrome
		for (int j = 0; j < stack.size(); j++) {
			if (stack.pop() != word.charAt(j)){
				return false;
			}
		}
		return true;
		
	}
	
	
    public static boolean isPalindromeSentence(String sentence){
		
    	Stack<Character> stack = new BasicStack<Character>();
    	
    	sentence = sentence.toLowerCase();
    	//
    	sentence = sentence.replaceAll("\\s+",""); // removes all white spaces
    	sentence = sentence.replaceAll("\\p{P}", ""); // removes non-letters

    	
    	for (int i = 0; i < sentence.length(); i++) {
			stack.push(sentence.charAt(i));
		}
    	
    	// If one letter is different, then it is not a palindrome
    			for (int j = 0; j < stack.size(); j++) {
    				if (stack.pop() != sentence.charAt(j)){
    					return false;
    				}
    			}
    			return true;
    	
    	
    }

}
