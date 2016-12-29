import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Prefix_Test {

	@Test
	public void testPutExample() {
		Assignment trie = new Assignment();
		trie.put("GAT", "a");
		trie.put("GATA", "b");
		trie.put("GATT", "c");
		trie.put("GATTA", "d");
		assertEquals(4,trie.size());
	}
	
	@Test
	public void testPutNull_key(){
		Assignment trie = new Assignment();
		try{
			trie.put(null,"a");
			fail("Expected an IllegalArgumentException to be thrown");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testPutNull_value(){
		Assignment trie = new Assignment();
		try{
			trie.put("GAT",null);
			fail("Expected an IllegalArgumentException to be thrown");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testPut_MalFormedKey(){
		Assignment trie = new Assignment();
		try{
			trie.put("$$","b");
			trie.put("BDEF","b");
			fail("Expected an MalformedKeyException to be thrown");
		}catch(MalformedKeyException e){
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testPut_Replace(){
		Assignment trie = new Assignment();
		// insert original key and value
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");

		// replace "d" with "e"
		trie.put("GATT", "e");
		// checking if the size stay the same
		// checking if the new value is returned
		assertEquals("e",trie.get("GATT"));
	}
	
	@Test
	public void testGet(){
		Assignment trie = new Assignment();
		trie.put("GAT", "a");
		trie.put("GATA", "b");
		trie.put("GATT", "c");
		trie.put("GATTA", "d");
		
		assertEquals("a",trie.get("GAT"));
	}
	
	@Test
	public void testGetNull(){
		Assignment trie = new Assignment();
		trie.put("GAT", "a");
		trie.put("GATA", "b");
		trie.put("GATT", "c");
		trie.put("GATTA", "d");
		
		try{
			trie.get(null);
			fail("Expected an IllegalArgumentException to be thrown");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testGet_MalFormedKey(){
		Assignment trie = new Assignment();
		trie.put("A", "b");
		try{
			trie.get("$$");
			fail("Expected an MalformedKeyException to be thrown");
		}catch(MalformedKeyException e){
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testGetNonExist(){
		Assignment trie = new Assignment();
		trie.put("GAT", "a");
		trie.put("GATA", "b");
		trie.put("GATT", "c");
		trie.put("GATTA", "d");
		assertEquals(null,trie.get("A"));
	}
	
	@Test
	public void testRemove(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		trie.remove("G");
		assertEquals(3,trie.size());
		assertEquals(null,trie.get("G"));
	}
	
	@Test
	public void testRemove_Malformed(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		try{
			trie.remove("D");
			fail("Expected Malformed Key Exception.");
		}catch(MalformedKeyException e){
			e.printStackTrace();
		}	
	}
	@Test
	public void testRemoveNonExisting(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		trie.remove("G");
		assertEquals(null,trie.remove("G"));
	}
	
	@Test
	public void testRemove_null(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		try{
			trie.remove(null);
			fail("Expected Illegal Argument Exception.");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}	
	}
	
	
	@Test
	public void testPutGetRemove(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		trie.remove("GAT");
		trie.remove("GA");
		assertEquals(2,trie.size());
		assertEquals(null,trie.get("GA"));
		assertEquals("a",trie.get("G"));
	}
	
	@Test
	public void testCountKeyMatchingPrefix(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");

		assertEquals(4,trie.countKeysMatchingPrefix("G"));
	}
	
	@Test
	public void testCountKeyMatchingPrefix_remove(){
		Assignment trie = new Assignment();
		trie.put("GAT", "a");
		trie.put("GATTC","b");
		trie.put("GATTACA", "c");
		trie.remove("GAT");

		assertEquals(2,trie.countKeysMatchingPrefix("G"));
	}
	
	@Test
	public void testgetKeysMatchingPrefix_Malformed(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");

		try{
			trie.getKeysMatchingPrefix("X");
			fail("Expected MalformedKey Exception");
		}catch(MalformedKeyException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetKeysMatchingPrefix_null(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");

		try{
			trie.getKeysMatchingPrefix(null);
			fail("Expected IllegalArgument Exception");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetKeysMatchingPrefix(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		List<String> match = new ArrayList<String>();
		match.add("G");
		assertEquals(match,trie.getKeysMatchingPrefix("G"));
	}
	
	@Test
	public void testgetKeysMatchingPrefix_remove(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		trie.remove("G");
		List<String> match = new ArrayList<String>();
		assertEquals(null,trie.getKeysMatchingPrefix("G"));
	}
	
	
	@Test
	public void testCountPrefix(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		assertEquals(4,trie.countPrefixes());
	}
	
	@Test
	public void testCountPrefix_remove(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		trie.remove("GATT");
		assertEquals(3,trie.countPrefixes());
	}
	@Test
	public void testCountPrefix_remove_insert(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		trie.remove("GATT");
		trie.put("A", "e");
		assertEquals(4,trie.countPrefixes());
	}
	
	@Test
	public void testSize(){
		Assignment trie = new Assignment();
		trie.put("G", "a");
		trie.put("GA","b");
		trie.put("GAT", "c");
		trie.put("GATT", "d");
		
		assertEquals(4,trie.size());
	}
	
	@Test
	public void testSumKeyLength_add(){
		Assignment trie = new Assignment();
		trie.put("GAT", "a");
		trie.put("GATTC","b");
		trie.put("GATTACA", "c");

		assertEquals(15,trie.sumKeyLengths());
	}
	
	@Test
	public void testSumKeyLength_remove(){
		Assignment trie = new Assignment();
		trie.put("GAT", "a");
		trie.put("GATTC","b");
		trie.put("GATTACA", "c");
		trie.remove("GAT");
		
		assertEquals(12,trie.sumKeyLengths());
	}
	
	
}

