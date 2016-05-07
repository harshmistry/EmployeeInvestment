package com.mastek.investment.exception;

public class InvalidLoginException extends Throwable{

	public InvalidLoginException()
	{
		
	}
	
	public InvalidLoginException(String s)
	{
		System.out.println(s+"\n"+getMessage());
	}
}
