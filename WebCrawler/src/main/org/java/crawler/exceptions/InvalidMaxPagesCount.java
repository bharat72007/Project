package main.org.java.crawler.exceptions;

public class InvalidMaxPagesCount extends Exception {
	
	private String mesg;
	private Throwable th;

	public InvalidMaxPagesCount(String mesg){
		this.mesg =mesg;
	}
	
	public InvalidMaxPagesCount(String mesg, Throwable th){
		this.mesg =mesg;
		this.th =th;
	}

}
