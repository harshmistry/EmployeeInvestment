package com.mastek.investment.exception;

public class InvestmentException extends Throwable{

	public InvestmentException(String s)
	{
		System.out.println(s+"\n"+getMessage());
	}
}
