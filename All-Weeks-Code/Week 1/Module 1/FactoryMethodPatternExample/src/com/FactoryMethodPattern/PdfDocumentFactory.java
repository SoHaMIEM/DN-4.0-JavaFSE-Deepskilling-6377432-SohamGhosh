package com.FactoryMethodPattern;

public class PdfDocumentFactory extends DocumentFactory<PdfDocument>{
	public PdfDocument createDocument() {
		return new ConcretePdfDocument();
	}
}
