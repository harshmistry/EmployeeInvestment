package com.mastek.investment.exception;

public class EmployeeNotFoundException extends Throwable{

	public EmployeeNotFoundException(String s)
	{
		System.out.println(s+"\n"+getMessage());
	}
	
}
