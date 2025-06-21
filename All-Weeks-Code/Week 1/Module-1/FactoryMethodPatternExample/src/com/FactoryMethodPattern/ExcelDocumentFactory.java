package com.FactoryMethodPattern;

public class ExcelDocumentFactory extends DocumentFactory<ExcelDocument>{
	public ExcelDocument createDocument() {
		return new ConcreteExcelDocument();
	}
}
