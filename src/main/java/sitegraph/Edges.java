package sitegraph;

/**
 * Class that stores which links link to what.
 */
public class Edges {
	
	private String source;
	private String target;
	
	/**
	 * Constructs Edges object to store source and target of links.
	 * @param source a url which links were scraped from
	 * @param target a link found on the url scraped
	 */
	public Edges(String source, String target) {
		this.source = source;
		this.target = target;
	}
	
	/**
	 * Gets a url that was scraped for links.
	 * @return the url that was scraped for links
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * Gets a link found on the scraped url.
	 * @return the link found on the scraped url
	 */
	public String getTarget() {
		return target;
	}

}
