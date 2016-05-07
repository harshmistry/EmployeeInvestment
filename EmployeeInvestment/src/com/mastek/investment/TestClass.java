package com.mastek.investment;

import java.io.IOException;

import com.mastek.investment.exception.InvalidLoginException;



public class TestClass {

	public static void main(String[] args) throws IOException   {

		Populate populate=new Populate();
		populate.populateEmployee();
		populate.populateAdmin();
		try {
			LoginTest.login(populate);
		}  catch (InvalidLoginException e) {
			System.err.println("\n"+e.getMessage());
		} 
	}

}
