package sitegraph;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 * Class that stores all the nodes and edges for the sitegraph.
 */
public class Graph {
	
	private ArrayList<Edges> edges;
	private ArrayList<Node> nodes;
	
	/**
	 * Constructs a Graph object and initializes ArrayList instance variables.
	 */
	public Graph() {
		edges = new ArrayList<Edges>();
		nodes = new ArrayList<Node>();
	}
	
	/**
	 * Adds Node object to nodes ArrayList.
	 * @param node Node object to add to ArrayList
	 */
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	/**
	 * Adds Edges object to edges ArrayList.
	 * @param edge Edges object to add to ArrayList
	 */
	public void addEdge(Edges edge) {
		edges.add(edge);
	}
	
	/**
	 * Constructs DOT file using nodes and edges.
	 * @return the file location if successful or error message if unsuccessful
	 */
	public String constructDOT() {
		try {
			String randString = RandomStringUtils.randomAlphanumeric(3);
			File myObj = new File(String.format("sitegraph%s.gv", randString));
			if (myObj.createNewFile()) {
				
				FileWriter myWriter = new FileWriter(String.format("sitegraph%s.gv", randString));
				
				myWriter.write("strict digraph sitegraph {\r\n");
				for (Node n : nodes) {
					myWriter.write(String.format("\t\"%s\" [label=\"%s\"];\r\n", n.getURL(), n.getTitle().replace("\"", "")));
				}
				for (Edges e : edges) {
					myWriter.write(String.format("\t\"%s\" -> \"%s\";\r\n", e.getSource(), e.getTarget()));
				}
				myWriter.write("}");
				myWriter.close();
				return myObj.getAbsolutePath();
			} else {
				return "File already exists.";
			}
	    } catch (IOException e) {
	    	return "An error occurred.";
	    }
		 
	}
	
}
