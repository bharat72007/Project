package main.org.java.crawler.exceptions;

public class InvalidURLException extends Exception {
	private String mesg;
	private Throwable th;
	
	public InvalidURLException(String mesg, Throwable th){
		this.mesg = mesg;
		this.th =th;
	}
	
	public InvalidURLException(String mesg){
		this.mesg = mesg;
	}

}
