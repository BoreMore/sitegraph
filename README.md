# sitegraph
Creates a directed graph using links on a website

## How To Use
1. Construct SiteScraper object.
```
SiteScraper myScraper = new SiteScraper();
```
2. Call gatewayLink method on the object to initialize scraping with the specified url to scrape, depth (how many layers of the supplied url's links to scrape), and whether to get the title of all links. 
    * A depth of 1 will only scrape the supplied url, while a depth of 2 will scrape the specified url AND all the links found on the specified url. A smaller depth is recommended for pages with lots of links.
    * Setting getAllTitles to true requires scraping **all** links for the title tag. This may greatly increase the time needed for the program to finish running, especially if the depth is greater.
```
myScraper.gatewayLink("https://github.com/", 1, true);
```
3. Call constructDOT method on the object to generate a DOT file. **This program will only generate a DOT file for now. To view a visual representation of the graph, use Graphviz or an online version of Graphviz.**
```
System.out.println(myScraper.constructDOT());
```

## Credits
Site graphing idea given by [Sanjay Srihari](https://github.com/sanjaysrihari)
