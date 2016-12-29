import java.util.*;

public class Assignment implements PrefixMap {
	
	/* Reference Used As Follow:
	 * http://algs4.cs.princeton.edu/52trie/TrieST.java.html
	 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
	 * http://blog.csdn.net/beiyetengqing/article/details/7856113
	 * https://www.tutorialspoint.com/java/java_characters.htm
	 * https://leetcode.com/articles/implement-trie-prefix-tree/#solutionr
	 * https://edstem.com.au/courses/254/discussion
	 */
	
	private static final int max_children = 4;
	
	private Node root;
	
	private int numberOfItems = 0; // number of item in the prefix tree
	private int prefix_num = 0; // number of unique prefix
	private int  sum = 0; // sum of all length of all key

	private class Node {
		
		Node[] children;
		Node parent;
		String value;
		
	    // Node Constructor
	    private Node() {
	        children = new Node[max_children];
	        this.value = value;
	        this.parent = parent;
	    }
	    
	    // check if the node has children or not
	    private boolean has_child(){
	    	for(int i = 0; i < max_children; i++){
	    		if(children[i] != null){
	    			return true;
	    		}
	    	}
	    	return false;
	    }

	}
	
	/*
	 * The default constructor will be called by the tests on Ed
	 */
	public Assignment() {
		root = new Node();
	}
	
	@Override
	public int size() {
		
		return numberOfItems;
	}

	@Override
	public boolean isEmpty() {
		
		if(numberOfItems == 0){
			return true;
		}
		return false;
	}
	
	// check if the input key is valid
	private String checkKey(String key){

		// Check if the key is consist of "A","C","G","T"
		if(key.matches("[ACGT]*")== false) throw new MalformedKeyException();
		
		return key;
	}
	
	/*
	 * Get the value corresponding to the key (or null if the key is not found)
	 */
	@Override
	public String get(String key) {
		
		Node temp = root;
		// check if the key is null or not
		if(key == null) throw new IllegalArgumentException();
		// check if the key is valid or not
		checkKey(key);
		
		temp = get(temp,key);
		if(temp == null) return null;
		
		return temp.value;
	}
	
	// Helper for getting the node containing the key
	private Node get(Node root, String key) {
		if(root == null) return null;
		for(int i = 0; i < key.length(); i++){
			int cursor = toIndex(key.charAt(i));
				root = root.children[cursor];
			}
		return root;
	}

	// Method for putting key and value into the trie
	@Override
	public String put(String key, String value) {
		
		checkNull(key,value);
		checkKey(key);

		Node curr = root;
		String old;
		
		for(int i = 0 ; i < key.length(); i++){
			
			// Create new node if no children is found
			if(curr.children[toIndex(key.charAt(i))]== null){
				curr.children[toIndex(key.charAt(i))] = new Node();
				curr.children[toIndex(key.charAt(i))].parent = curr; // set previous as parent
				prefix_num++;
			}
			
			// children already exist
			curr = curr.children[toIndex(key.charAt(i))];		
		}
		sum = sum + key.length();
		
		// Increase the size of prefix tree
		numberOfItems ++;
		
		// Set the new value and keep old value in old
		old = curr.value;
		curr.value = value;
		
		return old;
	}
	
	/*
	 * Remove the value corresponding to the given key from the data structure,
	 * if it exists. Return the old value, or null if no value was found.
	 */
	@Override
	public String remove(String key) {

		if(key == null) throw new IllegalArgumentException();
		checkKey(key);
		
		Node current = root;
		String old;
		
		for(int i = 0; i < key.length(); i++){
			int cursor = toIndex(key.charAt(i));
			if(current.children[cursor] == null){
				return null;
			}
			current= current.children[cursor];
		}
		
		// keep the old value
		old = current.value;
		// delete the node by setting its parents and value to null
		current.value = null; 
		current.parent = null;
		numberOfItems--; // decrease the size of trie upon removal
		prefix_num--; // decrease the number of prefix count upon removal
		sum = sum - key.length();
		
		return old;
	}

	
	/*
	 * This method count how many key is matching with the input prefix.
	 * By iterating through the trie, the count appended every time a matched key is found.
	 * @see PrefixMap#countKeysMatchingPrefix(java.lang.String)
	 */
	@Override
	public int countKeysMatchingPrefix(String prefix) {
		
		int count = 0;
		
		if(prefix == null) throw new IllegalArgumentException();
		checkKey(prefix);
		
		Node cur = root;
		cur = get(cur,prefix); // Get the node with the prefix
		
		count = CountKeyMatchingPrefix(cur,count);
		
		return count;
	}

	// Helper method for countKeysMatchingPrefix
	private int CountKeyMatchingPrefix(Node cur, int count) {
		
		if(cur == null) return 0;
		
		// check from the beginning of the tree
		if(cur.has_child() == true){
			// Increment every time a match is spotted.
			if(cur.value != null){
				count++;
			}
			// Go to next children
			for(Node temp : cur.children){
				if(cur != null){
					count = count + CountKeyMatchingPrefix(temp,0);
				}
			}
		}
		
		// at the end of the tree return 0 if null else 1
		if(cur.has_child() == false){
			if(cur.value != null){ 
				return 1;
			}else{
				return 0;
			}
		}
		
		return count;
	}

	
	/*
	 * This method create a list of key which are matching pairs to a prefix
	 * After scanning through the trie , all the matching key will be added to the list
	 * and returned the list at the end.
	 * @see PrefixMap#getKeysMatchingPrefix(java.lang.String)
	 */
	@Override
	public List<String> getKeysMatchingPrefix(String prefix) {

		if(prefix == null) throw new IllegalArgumentException();
		checkKey(prefix);
		
		Node curr = get(root,prefix);
		List<String> matched = new ArrayList<String>();
		
		
		
 		return matched;
	}
	
	

	@Override
	public int countPrefixes() {
		
		return prefix_num;
	}
	
	@Override
	public int sumKeyLengths() {
	
		return sum;
	}
	
    // get the index for key location in children[]
    private int toIndex(char c){
    	int index = -1;
    	switch(c){
    		case 'A' : return index = 0;

    		case 'C' : return index = 1;

    		case 'G' : return index = 2;
    		
    		case 'T' : return index = 3;
    			
    	}
    	
		return c;
    }
    
    
    // check If key and value is empty or not
	private void checkNull(String key, String value) {
		
		if(key == null){
			throw new IllegalArgumentException();
		}
		if(value == null){
			throw new IllegalArgumentException();
		}
		
	}
	
}


