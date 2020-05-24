package sitegraph;

import java.io.IOException;

public class SiteScraperTester {

	public static void main(String[] args) throws IOException {
		
		// update idea:
		// pass in percentage of links to visit if depth is greater than 1
		SiteScraper myScraper = new SiteScraper("http://www.cobbk12.org/wheeler/", 1);
		
		myScraper.gatewayLink();

		System.out.println(myScraper.constructDOT());
		
	}

}
