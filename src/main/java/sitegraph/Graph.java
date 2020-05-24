package sitegraph;

//import java.io.BufferedWriter;
import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class Graph {
	
	private ArrayList<Edges> edges;
	private ArrayList<Node> nodes;
	
	public Graph() {
		edges = new ArrayList<Edges>();
		nodes = new ArrayList<Node>();
	}
	
	public ArrayList<Edges> getEdges() {
		return edges;
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(Edges edge) {
		edges.add(edge);
	}
	
	public String constructDOT() {
		
		/*try(BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("g.dot")))) {
		    out.write("strict digraph sitegraph {"); 
		    out.newLine();

		    for(Edges e : edges) {
		    	out.write(e.v+" -> "+e.w);
		    	out.newLine();
		    }
		    out.write("}");
		}*/
		
		try {
			String randString = RandomStringUtils.randomAlphanumeric(3);
			File myObj = new File(String.format("sitegraph%s.gv", randString));
			if (myObj.createNewFile()) {
				
				//System.out.println("File created: " + myObj.getName());
				FileWriter myWriter = new FileWriter(String.format("sitegraph%s.gv", randString));
				
				myWriter.write("strict digraph sitegraph {\r\n");
				for (Node n : nodes) {
					myWriter.write(String.format("\t\"%s\" [label=\"%s (%s)\"];\r\n", n.getURL(), n.getTitle().replace("\"", ""), n.getURL()));
					//myWriter.write(n.getURL() + " [label=" + n.getTitle() + "];\r\n");
				}
				for (Edges e : edges) {
					myWriter.write(String.format("\t\"%s\" -> \"%s\";\r\n", e.getSource(), e.getTarget()));
					//myWriter.write(e.getSource() + " -> " + e.getTarget() + ";\r\n");
				}
				myWriter.write("}");
				myWriter.close();
				return myObj.getAbsolutePath();
			} else {
				return "File already exists.";
			}
		      
		    
			//System.out.println("Successfully wrote to the file.");
			
	    } catch (IOException e) {
	    	return "An error occurred.";
	    	//e.printStackTrace();
	    }
		 
	}
	
}
