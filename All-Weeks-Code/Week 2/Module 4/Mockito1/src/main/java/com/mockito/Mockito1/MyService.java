package com.mockito.Mockito1;

public class MyService
{
	ExternalApi ea;
	
	public MyService(ExternalApi ea) {
		this.ea = ea;
	}
	
    public String fetchData() {
    	return ea.getData();
    }
}
