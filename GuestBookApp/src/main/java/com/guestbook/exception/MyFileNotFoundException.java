package com.guestbook.exception;

public class MyFileNotFoundException extends Exception {

	public MyFileNotFoundException() {
		super();
	}
	
	public MyFileNotFoundException(String msg) {
		super(msg);
	}
}
