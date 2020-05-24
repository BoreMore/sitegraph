package sitegraph;

public class Node {
	
	private String title;
	private String url;
	
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
	
}
