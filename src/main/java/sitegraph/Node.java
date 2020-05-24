package sitegraph;

/**
 * Class that stores url and title of a site that was scraped.
 */
public class Node {
	
	private String title;
	private String url;
	
	/**
	 * Constructs Node object to store url and title.
	 * @param URL the url of the site that was scraped
	 * @param title the title tag of the site that was scraped
	 */
	public Node(String URL, String title) {
		url = URL;
		this.title = title;
	}
	
	/**
	 * Gets the url of the site.
	 * @return url of the site
	 */
	public String getURL() {
		return url;
	}
	
	/**
	 * Gets the title of the site.
	 * @return title of the site
	 */
	public String getTitle() {
		return title;
	}
	
}
