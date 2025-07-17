package com.FinancialForecastingTool;

public class ForecastingTool {

	public double futureForecast(double presentValue, double growthRate, int timePeriod) {
		
		if (timePeriod <= 0) {
			
			return presentValue;
		
		}
		
		return futureForecast(presentValue, growthRate, (timePeriod - 1)) * (1 + growthRate);
		
	}
	
}
