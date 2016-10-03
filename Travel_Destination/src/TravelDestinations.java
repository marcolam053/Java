import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.*;

public class TravelDestinations {

	private Graph<String, Integer> graph;

	public TravelDestinations(Graph<String, Integer> graph) {
		this.graph = graph;
	}
	

	/**
	 * Return the name of the country reached by the cheapest direct flight from
	 * fromCountry. If there is a tie, return any destination with that minimal
	 * price. If no flights depart this country, return null
	 */
	public String cheapestDirectFlight(String fromCountry) {
		
		Vertex<String> source = findVertex(fromCountry);
		
		int Min_Edge = Integer.MAX_VALUE;
		Vertex<String> end = null;
		
		for(Edge<Integer> e : graph.outgoingEdges(source)){
			if(e.getElement() < Min_Edge){
				Min_Edge = e.getElement();
				end = graph.opposite(source, e);
			}
		}
		return end == null ? null : end.getElement();
	}

	private Vertex<String> findVertex(String fromCountry) {
		for(Vertex<String> v : graph.vertices()){
			if(v.getElement().equals(fromCountry)){
				return v;
			}
		}
		return null;
	}


	/**
	 * Return the minimal cost to get to toCountry from fromCountry. If
	 * fromCountry cannot be reached, then return Integer.MAX_VALUE
	 */
	public int shortestPathCost(String fromCountry, String toCountry) {
		// TODO: implement this
		
		HashMap<Vertex<String>,Integer> D = new HashMap<Vertex<String>,Integer>();
		PriorityQueue<SimpleEntry<Integer, Vertex<String>>> Q = new PriorityQueue<SimpleEntry<Integer, Vertex<String>>>(Comparator.comparing(SimpleEntry::getKey));
		Vertex<String>[] key;
		
		// Initialize D(S) & D(v) & Q
		for(Vertex<String> v : graph.vertices()){
			if(v.getElement().equals(fromCountry)){
				D.put(v, 0); //D(s) = 0
				SimpleEntry<Integer,Vertex<String>> first = new SimpleEntry<Integer,Vertex<String>>(0,v);
				Q.add(first);
			}else{
				D.put(v, Integer.MAX_VALUE);
			}
		}
		
		while(!Q.isEmpty()){
			SimpleEntry<Integer,Vertex<String>> u = Q.poll();
			
			for(Edge<Integer> e: graph.outgoingEdges(u.getValue())){
				key = graph.endVertices(e);
				// if D(u) < D(v) -  w(u,v) 
				if( D.get(u.getValue()) < D.get(key[1]) - graph.getEdge(u.getValue(), key[1]).getElement()){
					int value = D.get(u.getValue()) + graph.getEdge(u.getValue(), key[1]).getElement();
					D.put(key[1], value);
					SimpleEntry<Integer,Vertex<String>> old = new SimpleEntry<Integer,Vertex<String>>(D.get(key[1]),key[1]);
					Q.remove(old);
					SimpleEntry<Integer,Vertex<String>> n_ew = new SimpleEntry<Integer,Vertex<String>>(D.get(key[1]),key[1]);
					Q.add(n_ew);
				}
			}
		}
		
		for(Vertex<String> v : graph.vertices()){
			if(v.getElement().equals(toCountry)){
				return D.get(v);
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	

	/**
	 * Return a path which has the minimal cost to get to toCountry from
	 * fromCountry. If fromCountry cannot be reached, then return null
	 */
	public List<String> shortestPath(String fromCountry, String toCountry) {
		// TODO: implement this
		return null;
	}
	
}