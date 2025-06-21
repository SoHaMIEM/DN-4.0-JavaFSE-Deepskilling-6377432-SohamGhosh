package com.SingletonPattern;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger1 = Logger.getInstance();
		Logger logger2 = Logger.getInstance();
		
		if(logger1==logger2) {
			System.out.println("Both logger1 and logger2 are the same instance.");
		}
		else {
			System.out.println("Both logger1 and logger2 are different instances.");
		}
	}

}
