# sitegraph
Creates a directed graph using links on a website

## How To Use
1. Construct SiteScraper object with specified url to scrape and a depth (how many of the link's links to scrape). For example, a depth of 1 will only scrape the supplied url, while a depth of 2 will scrape the specified url AND all the links found on the specified url. A smaller depth is recommended for pages with lots of links.
2. Call gatewayLink method on the object to initialize scraping. 
3. Call constructDOT method on the object to generate a DOT file. **This program will only generate a DOT file for now. To view a visual representation of the graph, use Graphviz or an online version of Graphviz.**

## Credits
Site graphing idea given by [Sanjay Srihari](https://github.com/sanjaysrihari)
