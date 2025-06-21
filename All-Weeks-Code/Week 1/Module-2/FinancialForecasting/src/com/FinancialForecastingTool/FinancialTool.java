package com.FinancialForecastingTool;

public class FinancialTool {

	private double futureValue;
	
	public void financialForecast(double presentValue, double growthRate, int timePeriod) {
	
		ForecastingTool future = new ForecastingTool();
		futureValue = future.futureForecast(presentValue, growthRate, timePeriod);
		
		System.out.println("Principal Amount="+String.format("%.2f", presentValue)+", Time Period="+timePeriod+","
				+ " Annual Growth Rate="+growthRate+", Future Value="+String.format("%.2f", futureValue)+"\n");
	
	}

}
