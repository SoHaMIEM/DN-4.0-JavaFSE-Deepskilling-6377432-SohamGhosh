package com.FactoryMethodPattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentFactory<WordDocument> wordFactory = new WordDocumentFactory();
		DocumentFactory<PdfDocument> pdfFactory = new PdfDocumentFactory();
		DocumentFactory<ExcelDocument> excelFactory = new ExcelDocumentFactory();
		ExcelDocument excel = (ExcelDocument)excelFactory.createDocument();
		PdfDocument pdf = (PdfDocument)pdfFactory.createDocument();
		WordDocument word = (WordDocument)wordFactory.createDocument();
		excel.excelOpen();
		word.wordOpen();
		pdf.pdfOpen();
		
		
	}

}
