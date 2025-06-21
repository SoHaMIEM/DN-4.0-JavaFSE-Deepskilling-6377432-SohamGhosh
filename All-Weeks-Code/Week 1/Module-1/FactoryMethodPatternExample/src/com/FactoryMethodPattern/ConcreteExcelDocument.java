package com.FactoryMethodPattern;

public class ConcreteExcelDocument implements ExcelDocument {

	@Override
	public void excelOpen() {
		// TODO Auto-generated method stub
		System.out.println("Opening Excel Document");
	}

}
