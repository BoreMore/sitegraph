package sitegraph;

import org.jsoup.Jsoup;
//import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SiteScraper {
	private String mainURL;
	private int depth;
	private Graph siteGraph;
	
	public SiteScraper(String webURL, int linkDepth) {
		mainURL = webURL;
		depth = linkDepth;
		siteGraph = new Graph();
	}

	public String getURL() {
		return mainURL;
	}
	
	public Elements scrapeLinks(Elements links) throws IOException {
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
			
			return scrapeLinks(newLinks);
		} else {
			/*for (Element link : links) {
				try {
					String hrefAttr = link.attr("abs:href");
					if (link.attr("abs:href") != null && link.attr("abs:href").length() > 0) {
						
						Document doc = Jsoup.connect(link.attr("abs:href")).get();
						
						Node newNode = new Node(hrefAttr, doc.title());
						siteGraph.addNode(newNode);
						
					}
				} catch (Exception e) {
				    
				}
			}*/
			return links;
		}
		
	}
	
	public void gatewayLink() throws IOException {
		
		Element el = new Element("a");
		el.attr("href", mainURL);
		Elements mainLink = new Elements();
		mainLink.add(el);
		
		scrapeLinks(mainLink);
		
		//System.out.println(allLinks);
        
        //return "";
	}
	
	public Graph getGraph() {
		return siteGraph;
	}
	
	public ArrayList<Edges> getGraphEdges() {
		return siteGraph.getEdges();
	}
	
	public ArrayList<Node> getGraphNodes() {
		return siteGraph.getNodes();
	}
	
	public String constructDOT() {
		return siteGraph.constructDOT();
	}
	
}
