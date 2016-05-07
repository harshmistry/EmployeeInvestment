package com.mastek.investment;

public class TaxCalculation{
	//returns true if business logic is satisfied
	public static boolean is80CValid(double lifeInsurance,double providentFund,double pensionFund,double mutualFund,double infrastructureBond){
		double cal80C=lifeInsurance+providentFund+pensionFund+mutualFund+infrastructureBond;
		if(cal80C<=100000)
			return true;
		else
			return false;
	}
	public static boolean is80DSenrValid(double mediclaimSenior){
		if(mediclaimSenior<=20000)
			return true;
		else
			return false;
	}
	public static boolean is80DNonSenrValid(double mediclaimNonSenior){
		if(mediclaimNonSenior<=15000)
			return true;
		else
			return false;
	}
	public static boolean isMedicalBillValid(double medicalBill){
		return is80DNonSenrValid(medicalBill);
	}
	public static double calculateHra(double salary,String city){
		if(city.equalsIgnoreCase("Mumbai")||city.equalsIgnoreCase("Chennai"))
			return salary*0.5;
		else if(city.equalsIgnoreCase("Pune"))
			return salary*0.4;
		else
			return 0;
	}	
}
