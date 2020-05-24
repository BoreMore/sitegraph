package sitegraph;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Class that handles url scraping and updating the Graph.
 */
public class SiteScraper {

	private static Graph siteGraph;
	
	/**
	 * Constructs a new SiteScraper object and initializes Graph object.
	 */
	public SiteScraper() {
		siteGraph = new Graph();
	}
	
	/**
	 * Recursively scrapes page and its links for a specified depth.
	 * @param links the links to scrape
	 * @param depth how many layers of links to scrape
	 * @param getAllTitles specifies whether to get titles for the last set of links (setting this to true makes the sitegraph neater and easier to read but may greatly increase the time needed to scrape)
	 * @return the next links to scrape
	 * @throws IOException if there is an error in connecting to the url
	 */
	private static Elements scrapeLinks(Elements links, int depth, boolean getAllTitles) throws IOException {
		Elements newLinks = new Elements();
		
		if (depth > 0 && links.size() > 0) {
			for (Element link : links) {
				try {
					String hrefAttr = link.attr("abs:href");
					if (hrefAttr != null && hrefAttr.length() > 0) {
						Document doc = Jsoup.connect(hrefAttr).get();
						
						Node newNode = new Node(hrefAttr, doc.title());
						siteGraph.addNode(newNode);
						
						Elements targetLinks = doc.select("a[href]");
						
						for (Element targetLink : targetLinks) {
							String targetLinkHref = targetLink.attr("abs:href");
							if (targetLinkHref != null && targetLinkHref.length() > 0) {
								Edges newEdge = new Edges(hrefAttr, targetLink.attr("abs:href"));
								siteGraph.addEdge(newEdge);
							}
						}
						
						newLinks.addAll(targetLinks);
					}
				} catch (Exception e) {
				    
				}	
			}
			
			depth--;
			
			return scrapeLinks(newLinks, depth, getAllTitles);
		} else {
			if (getAllTitles) {
				for (Element link : links) {
					try {
						String hrefAttr = link.attr("abs:href");
						if (link.attr("abs:href") != null && link.attr("abs:href").length() > 0) {
							
							Document doc = Jsoup.connect(link.attr("abs:href")).get();
							
							Node newNode = new Node(hrefAttr, doc.title());
							siteGraph.addNode(newNode);
							
						}
					} catch (Exception e) {
					    
					}
				}
			}
				
			return links;
		}
		
	}
	
	/**
	 * Converts String url to an Element and calls scrapeLinks.
	 * @param url the url to scrape
	 * @param depth how many layers of links to scrape
	 * @param getAllTitles specifies whether to get titles for the last set of links (setting this to true makes the sitegraph neater and easier to read but may greatly increase the time needed to scrape)
	 * @throws IOException if there is an error in connecting to the url
	 */
	public void gatewayLink(String url, int depth, boolean getAllTitles) throws IOException {
		
		Element el = new Element("a");
		el.attr("href", url);
		Elements mainLink = new Elements();
		mainLink.add(el);
		
		scrapeLinks(mainLink, depth, getAllTitles);

	}
	
	/**
	 * Calls method in Graph class to construct a DOT file.
	 * @return the file location if successful or error message if unsuccessful
	 */
	public String constructDOT() {
		return siteGraph.constructDOT();
	}
	
}
