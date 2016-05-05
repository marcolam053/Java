import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import java.io.*;
public class HashMap<K extends Comparable<K>, V> {
	    
    
	private int multiplier;
	private int modulus;
	private int hashMapSize;
	private HashMapNode[] StoreNode;
	private int numberofitems;
	public V value;
	
	//For collision scenario
	private int putCollisions;
	private int totalCollisions;
	private int maxCollisions;
	
	
	// construct a HashMap with 4000 places and given hash parameters
    public HashMap(int multiplier, int modulus){
    	this.multiplier = multiplier;
    	this.modulus = modulus;   
    	this.numberofitems = 0;
    	this.StoreNode = new HashMapNode[4000];
    	
    	this.putCollisions = 0;
    	this.maxCollisions = 0;
    	this.totalCollisions = 0;
    }
    // construct a HashMap with given capacity and given hash parameters
    public HashMap(int hashMapSize, int multiplier, int modulus){
    	this.multiplier = multiplier;
    	this.modulus = modulus;
    	this.hashMapSize = hashMapSize;
    	this.numberofitems = 0;
    }
    // hashing
    public int hash(K key){
    	return Math.abs(key.hashCode());
    }
    
    // size (return the number of nodes currently stored in the map)
    public int size(){
    	return this.numberofitems;
    }
    public boolean isEmpty(){
    	return this.numberofitems==0;
    }
    
    // interface methods
    public List<K> keys(){
    	List<K> keys = new ArrayList<K>();
    	for(int j = 0; j< this.StoreNode.length; j++ ){
    		if(this.StoreNode[j] != null){
    			keys.add((K) this.StoreNode[j].getKey());
    		}
    	}
    	return keys;
    }
    
    @SuppressWarnings("unchecked")
	public V put(K key, V value) {
        V a =  null;
        int index = hash(key) % StoreNode.length;
		if(StoreNode[index] == null)
		{
			numberofitems += 1;
			a = null;
		}
		else
		{
			a = (V) StoreNode[index].value;
		}
		StoreNode[index] = new HashMapNode<K, V>(key, value);
		return a;
	}
	public V get(K key){
		int index = hash(key) % StoreNode.length;
		HashMapNode<K, V> entry = StoreNode[index];
        if (entry == null) {
            return null;
        }   
        if (!entry.getKey().equals(key)) {
            return null;
        } 
		return entry.value;	
	}
    		
    	
    
    public V remove(K key){
		int index = hash(key) % StoreNode.length;
		V re = null;
		HashMapNode<K, V> entry = StoreNode[index];
        if (entry != null) {
            numberofitems -= 1;
            re = entry.value;
            StoreNode[index] = null;
        }   
        return re;
	}
    
    public void resetStatistics(){
    	this.maxCollisions = 0;
    	this.putCollisions = 0;
    	this.totalCollisions =0;
    }
    
    public int putCollisions(){
    	return putCollisions;
    	
   }
    
    public int totalCollisions(){
    	return totalCollisions;
    }
    
     public int maxCollisions(){
    	 return maxCollisions;
    	
    }
    
  }