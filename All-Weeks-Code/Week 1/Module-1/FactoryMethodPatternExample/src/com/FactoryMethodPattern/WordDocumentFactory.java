package com.FactoryMethodPattern;

public class WordDocumentFactory extends DocumentFactory<WordDocument>{
	public WordDocument createDocument() {
		return new ConcreteWordDocument();
	}
}
