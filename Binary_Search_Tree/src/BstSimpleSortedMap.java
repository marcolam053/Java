public class BstSimpleSortedMap implements SimpleSortedMap {
	
	private class MySimpleEntry implements SimpleEntry {
		
		private final Integer key;
		private final String value;
		private MySimpleEntry left;
		private MySimpleEntry right;
		private MySimpleEntry parent;
		
		MySimpleEntry(Integer key, String value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		@Override
		public Integer getKey() { return key; }

		@Override
		public String getValue() { return value; }
		
		protected MySimpleEntry getLeft() { return left; }
		protected MySimpleEntry getRight() { return right; }
		protected MySimpleEntry getParent() { return parent; }

		protected void setLeft(MySimpleEntry entry) { left = entry; }
		protected void setRight(MySimpleEntry entry) { right = entry; }
		protected void setParent(MySimpleEntry entry) { parent = entry; }
	}

	private int size;
	private MySimpleEntry root;
	
	public BstSimpleSortedMap() {
		size = 0;
		root = null;
	}
	
	// attaches the subtree rooted at 'child', to the parent
	private void attachLeft(MySimpleEntry parent, MySimpleEntry child) {
		if(child != null) { child.setParent(parent); }
		if(parent != null) { parent.setLeft(child); }
	}

	// attaches the subtree rooted at 'child', to the parent
	private void attachRight(MySimpleEntry parent, MySimpleEntry child) {
		if(child != null) { child.setParent(parent); }
		if(parent != null) { parent.setRight(child); }
	}

	//////////////////////////
	// Map ADT methods:
	//////////////////////////
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String get(Integer k) {
		return get(k, root);
	}
	
	private String get(Integer k, MySimpleEntry subtreeRoot) {
		// base case: empty subtree
		if(subtreeRoot == null) {
			// k isn't in this subtree
			return null;
		}
		
		// base case: k matches the key in the current entry
		if(k.compareTo(subtreeRoot.getKey()) == 0) {
			// TODO: return the value
			return null;
		}
		// recursive case: k < the current entry
		else if(k.compareTo(subtreeRoot.getKey()) < 0) {
			// TODO: return the result of recursing to the left
			return null;
		}
		// recursive case: k > the current entry
		else {
			// TODO: return the result of recursing to the right
			return null;
		}
	}

	@Override
	public String put(Integer k, String v) {
		// We will implement this recursively.
		
		// If the key already exists, we will need to return the old value
		String oldValue = get(k);
		
		// Replace the subtree rooted at 'root' with
		// the resulting subtree after doing the put
		root = put(k, v, root);
		
		return oldValue;
	}
	
	// Recursive helper method for put
	// Returns the subtree rooted at entry after performing the put
	private MySimpleEntry put(Integer k, String v, MySimpleEntry subtreeRoot) {
		// base case: the key wasn't in the subtree
		if(subtreeRoot == null) {
			// we have reached a null subtree, where k should be
			//TODO: create a new entry
			//TODO: increment the size variable
			//TODO: return the new entry
			return null;
		}

		// base case: k matches the one in the current entry
		if(k.compareTo(subtreeRoot.getKey()) == 0) {
			// TODO: create a new entry
			// TODO: attach the left child of the current entry to it			
			// TODO: attach the right child of the current entry to it			
			// TODO: return the new subtree
			return null;
		}
		// recursive case: k < the current entry
		else if(k.compareTo(subtreeRoot.getKey()) < 0) {
			// TODO: get the subtree resulting from recursing left
			// TODO: attach that subtree to the current entry
			// TODO: return the modified entry
			return null;
		}
		// recursive case: k > the current entry
		else {
			// TODO: get the subtree resulting from recursing right
			// TODO: attach that subtree to the current entry
			// TODO: return the modified entry
			return null;
		}
	}	

	@Override
	public String remove(Integer k) {
		// TODO implement this in exercise 2
		// Implement it recursively.
		return null;
	}

	@Override
	public Iterable<Integer> keySet() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Iterable<String> values() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Iterable<SimpleEntry> entrySet() {
		throw new java.lang.UnsupportedOperationException();
	}

	//////////////////////////
	// SortedMap ADT methods:
	//////////////////////////
	
	@Override
	public SimpleEntry firstEntry() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry lastEntry() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry ceilingEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry floorEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry lowerEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry higherEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Iterable<Integer> subMap(Integer fromKey, Integer toKey) {
		throw new java.lang.UnsupportedOperationException();
	}
	
}

