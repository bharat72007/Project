package main.org.java.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.extern.log4j.Log4j;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Log4j
public class Bot {
	
	private List<String> uniqueURLS = null;
	private Integer max_Pages_To_Crawl = 0;
	
	public Bot(String URL, int max_Pages_To_Crawl){
		this.uniqueURLS = new ArrayList<String>();
		this.uniqueURLS.add(URL);
		this.max_Pages_To_Crawl = max_Pages_To_Crawl;
	}
	
	/**
	 * Actual Logic which access the URL, get the HTML Content, 
	 * fetches all the links & put them into Cache. 
	 * Third Party Library is being used to perform all the 
	 * Scraping Logic
	 * @param URL
	 * @throws IOException
	 */
	private void retrieveHTML(String URL) throws IOException{
		Connection connection = Jsoup.connect(URL);
		Document htmlDocument = connection.get();
		//Retrieve All Href's from the HTML Document. and put them into isVisited List.
		Elements linksOnPage = htmlDocument.select("a[href]");
		Element ele = null;
		int size = linksOnPage.size();
		for(int i=0;i<size;i++){
			ele = linksOnPage.get(i);
			if(!uniqueURLS.contains(ele.absUrl("href"))){
				uniqueURLS.add(ele.absUrl("href"));
			}
		}
	}
	
	/**
	 * Method to invoke the actual Crawling, Iterating through all the 
	 * URLS present in the Cache named: visitedURLS.
	 * @throws IOException
	 */
	public void startCrawling() throws IOException{
		int currentPageCount = 0;
		while(this.max_Pages_To_Crawl > currentPageCount){
			if(null == uniqueURLS.get(currentPageCount)){
				return;
			}
			retrieveHTML(uniqueURLS.get(currentPageCount));
			if(currentPageCount >= this.uniqueURLS.size()){
				return;
			}
			currentPageCount ++;
		}
	}
	
	/**
	 * Print All the fetched Links By Bot.
	 */
	public void printFetchedLinks(){
		Iterator<String> itr = this.uniqueURLS.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
