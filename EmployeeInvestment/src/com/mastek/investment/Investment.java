package com.mastek.investment;

import java.util.Calendar;

public class Investment {
	private int empId;
	private double lifeInsurance;
	private double providentFund;
	private double pensionFund;
	private double mutualFund;
	private double infrastructureBond;
	private double mediclaimSenior;
	private double mediclaimNonSenior;
	private double medicalBills;
	private double houseRent;
	private String city;
	private Calendar calendar;
	
	{
		calendar=Calendar.getInstance();
	}
	//************************** constructors ***************************************************//
	public Investment() {
		
	
	}

	public Investment(double lifeInsurance, double providentFund,
			double pensionFund, double mutualFund, double infrastructureBond,
			double mediclaimSenior, double mediclaimNonSenior,
			double medicalBills, double houseRent, String city) {
		//this();
		super();
		this.lifeInsurance = lifeInsurance;
		this.providentFund = providentFund;
		this.pensionFund = pensionFund;
		this.mutualFund = mutualFund;
		this.infrastructureBond = infrastructureBond;
		this.mediclaimSenior = mediclaimSenior;
		this.mediclaimNonSenior = mediclaimNonSenior;
		this.medicalBills = medicalBills;
		this.houseRent = houseRent;
		this.city = city;
	}
	

	//******************************** getters/setters ********************************************//
	public void setEmpId(int emId){
		this.empId=emId;
	}
	public int getEmpId(){
		return empId;
	}
	public double getLifeInsurance() {
		return lifeInsurance;
	}

	public void setLifeInsurance(double lifeInsurance) {
		this.lifeInsurance = lifeInsurance;
	}

	public double getProvidentFund() {
		return providentFund;
	}

	public void setProvidentFund(double providentFund) {
		this.providentFund = providentFund;
	}

	public double getPensionFund() {
		return pensionFund;
	}

	public void setPensionFund(double pensionFund) {
		this.pensionFund = pensionFund;
	}

	public double getMutualFund() {
		return mutualFund;
	}

	public void setMutualFund(double mutualFund) {
		this.mutualFund = mutualFund;
	}

	public double getInfrastructureBond() {
		return infrastructureBond;
	}

	public void setInfrastructureBond(double infrastructureBond) {
		this.infrastructureBond = infrastructureBond;
	}

	public double getMediclaimSenior() {
		return mediclaimSenior;
	}

	public void setMediclaimSenior(double mediclaimSenior) {
		this.mediclaimSenior = mediclaimSenior;
	}

	public double getMediclaimNonSenior() {
		return mediclaimNonSenior;
	}

	public void setMediclaimNonSenior(double mediclaimNonSenior) {
		this.mediclaimNonSenior = mediclaimNonSenior;
	}

	public double getMedicalBills() {
		return medicalBills;
	}

	public void setMedicalBills(double medicalBills) {
		this.medicalBills = medicalBills;
	}

	public double getHouseRent() {
		return houseRent;
	}

	public void setHouseRent(double houseRent) {
		this.houseRent = houseRent;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public Calendar getCalendar(){
		return calendar;
	}
	public String getInvestDate(){
		String s="";
		s+=calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
		return s;
	}

}
