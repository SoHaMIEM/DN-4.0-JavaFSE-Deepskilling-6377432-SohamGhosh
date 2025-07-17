package com.FactoryMethodPattern;

public class ConcretePdfDocument implements PdfDocument {

	@Override
	public void pdfOpen() {
		// TODO Auto-generated method stub
		System.out.println("Opening Pdf Document");
	}

}
