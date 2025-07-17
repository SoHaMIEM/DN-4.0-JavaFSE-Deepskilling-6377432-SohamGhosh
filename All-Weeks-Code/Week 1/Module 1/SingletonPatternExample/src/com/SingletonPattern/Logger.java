package com.SingletonPattern;

public class Logger {
	private static Logger logger;
	
	private Logger() {
		System.out.println("This is the private Constructor of Logger class");	
	}
	
	public static Logger getInstance() {
		if(logger == null) {
			logger = new Logger();
		}
		return logger;
	}
	
}	

