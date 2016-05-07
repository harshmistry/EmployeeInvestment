package com.mastek.investment;

public class Executive extends Employee{
	private boolean investmentApproved;
	public Executive() {
		super();
	}
	
	public Executive(Name name, int phNo, int salary, String panNo) {
		super(name, phNo, salary, panNo);
	}

	public boolean isInvestmentApproved() {
		return investmentApproved;
	}

	public void setInvestmentApproved(boolean investmentApproved) {
		this.investmentApproved = investmentApproved;
	}
	

}
