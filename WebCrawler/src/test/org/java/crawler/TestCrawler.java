package test.org.java.crawler;

import java.io.IOException;

import main.org.java.crawler.Init;
import main.org.java.crawler.exceptions.InvalidMaxPagesCount;
import main.org.java.crawler.exceptions.InvalidURLException;

import org.junit.Test;

public class TestCrawler {

	@Test
	public void testValidURLAndValidMaxPageCount() throws IOException, InvalidMaxPagesCount, InvalidURLException {
		Init.init("http://www.mkyong.com/unittest/junit-4-tutorial-1-basic", 5);
	}
	
	@Test(expected=InvalidURLException.class)
	public void testInValidURLAndValidMaxPageCount() throws IOException, InvalidMaxPagesCount, InvalidURLException {
		Init.init("http://www.mkyong.com//unittest/junit-4-tutorial-1-basic", 5);
	}
	
	@Test(expected=InvalidMaxPagesCount.class)
	public void testValidURLAndInValidMaxPageCount() throws IOException, InvalidMaxPagesCount, InvalidURLException {
		Init.init("http://www.mkyong.com/unittest/junit-4-tutorial-1-basic", -1);
	}
	

}
