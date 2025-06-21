package com.FactoryMethodPattern;

public abstract class DocumentFactory<T> {
	public abstract T createDocument();
}
