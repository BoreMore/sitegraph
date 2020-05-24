package sitegraph;

/*import java.util.LinkedHashSet;
import java.util.Set;*/

public class Node {
	
	private String title;
	private String url;
	//private ArrayList<Integer> edges = new ArrayList<Integer>();
	
	/*public Node(String URL) {
		url = URL;
	}*/
	
	public Node(String URL, String title) {
		url = URL;
		this.title = title;
	}
	
	public String getURL() {
		return url;
	}
	
	public String getTitle() {
		return title;
	}
	
	/*public void addEdge(int arrayIndex) {
		edges.add(arrayIndex);
	}*/
	
	/*public void UpdateTitle(String titleTag) {
		title = titleTag;
	}*/
	
	// from https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/ 
	/*public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
		Set<Integer> set = new LinkedHashSet<Integer>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
	}*/
	
}
