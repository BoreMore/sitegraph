package sitegraph;

import java.io.IOException;

/**
 * Class to test the SiteScraper class.
 */
public class SiteScraperTester {

	/**
	 * Method to test the SiteScraper class.
	 * @param args not used
	 * @throws IOException if there is an error in connecting to the url
	 */
	public static void main(String[] args) throws IOException {
		// update idea:
		// pass in percentage of links to visit if depth is greater than 1
		SiteScraper myScraper = new SiteScraper();
		
		myScraper.gatewayLink("https://github.com/", 1, true);
		myScraper.gatewayLink("https://github.com/BoreMore", 1, true);

		System.out.println(myScraper.constructDOT());
		
	}

}
