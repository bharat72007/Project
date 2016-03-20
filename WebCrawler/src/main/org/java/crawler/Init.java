package main.org.java.crawler;

import java.io.IOException;

import lombok.extern.log4j.Log4j;
import main.org.java.crawler.exceptions.InvalidMaxPagesCount;
import main.org.java.crawler.exceptions.InvalidURLException;

import org.apache.commons.validator.UrlValidator;

@Log4j
public class Init {
	
	public static void init(String URL, int max_Page_Visit) throws IOException, InvalidMaxPagesCount, InvalidURLException{
		
		UrlValidator urlValidator = new UrlValidator();
		if(false == urlValidator.isValid(URL)){
			throw new InvalidURLException("Invalid URL");
		}
		else if(0 > max_Page_Visit){
			
			throw new InvalidMaxPagesCount("Invalid Number of Max Pages to be Crawled");
		}
		else if(0 == max_Page_Visit ){
			log.error("Number of Pages to be Visited are 0");
		}
		
		Bot crawlerBot = new Bot(URL, max_Page_Visit); 
		crawlerBot.startCrawling();
		crawlerBot.printFetchedLinks();
	}

}
