package com.mastek.investment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mastek.investment.exception.EmployeeNotFoundException;
import com.mastek.investment.exception.InvalidLoginException;
import com.mastek.investment.exception.InvestmentException;

public class LoginTest {
	public static void login(Populate populate) throws IOException,
														InvalidLoginException{
		/**
		 * It accepts object of Populate class because employees are populated from main class, and to access 
		 * those employees same object is required
		 * 
		 * It accepts employee id and password for authentication, and based on Executive or Admin class it
		 * displays various options 
		 * 
		 * operationPerformed --> default value=false
		 * 				--> used to provide another chance to user to login again
		 * 				--> if Executive or Admin selects appropriate options from menu, then it becomes true
		 * 					and he does not have to login again
		 * 
		 * validEmpId --> becomes false if user enters a string instead of number
		 * 
		 *logOut --> default value="n"
		 *		--> used to track if user wants to log out from his account
		 *
		 *mainLogOut --> default value="n"
		 *		--> used to track if user wants to log out from the system
		 *
		 *optionNotSelected --> default value=true
		 *		--> used to keep track if user have selected appropriate option from menu
		 *		-->it controls inner do-while loop
		 *
		 *only one instance of Display class is created throughout the program (in this class)	
		 */
		int option;
		int logoutAttempt=0;
		int empId=0;
		boolean operationPerformed=false;
		boolean validEmpId;
		String logOut="n";
		String mainLogOut="n";
		Collections collection=new Collections();
		Display display=new Display();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.println();                               //to set OutStream
		System.err.println();								//to set ErrorStream
		do{     //will execute till user does not enter to log out from the system  
			System.out.println("\n=============== Sign in page ===========================");
			do{      //will execute till user does not enters integer for empId    
				try{
					validEmpId=true;     //by default it is assumed that user will enter correct valid empId
					System.out.print("Enter employee id: ");
					empId=Integer.parseInt(input.readLine());
				}catch(NumberFormatException e){
					System.out.println("\t\tEmployee Id must be a number.........please re-enter");
					validEmpId=false;
				}
			}while(!validEmpId);
			System.out.print("Enter password: ");
			String password=input.readLine();
			if(loginAuth(empId,password)){
				try{
				populate.setEmpId(empId);   //initializing empId so that it can be used in Populate class to declare and submit investment
				boolean optionNotSelected=true;
				if(collection.getEmployee(empId) instanceof Executive){
					do{     //will execute till user does not enters to logout from his account
						do{      //will execute till user does not selects appropriate option from menu,
							try{           //inner try to catch InvestmentException,EmployeeNotFoundException or NumberFormatException raised by any of the case
								mainLogOut="n";
								System.out.println("\n=================Welcome "+collection.getEmployee(empId).getName()+" ==========================");
								System.out.println("----Select option ------");
								System.out.println("1.Make investment declaration\n2.Submit investment proof\n3.View current declaration\n4.View previous investments\n5.Check approval status");
								System.out.print("option: ");
								option=Integer.parseInt(input.readLine());
								switch(option){
								case 1:
									optionNotSelected=false;
									operationPerformed=true;
									populate.declareInvestment();   //if employee wants to declare new Investment 
									break;
								case 2:
									optionNotSelected=false;
									operationPerformed=true;
									populate.submitInvestment();   //if employee wants to submit proof for investment declared
									break;
								case 3:
									optionNotSelected=false;
									operationPerformed=true;
									display.displayCurrentInvestment(empId);  //if employee wants to view his current declaration
									break;
								case 4:
									optionNotSelected=false;
									operationPerformed=true;
									display.displayInvestmentHistory(empId);  //if employee wants to view his previous declaration
									break;
								case 5:
									optionNotSelected=false;
									operationPerformed=true;
									if(collection.getInvestmentApproved(empId)!=null)
										System.out.println("Investment for employee id: "+empId+" is approved");
									break;
								default :
									System.out.println("Invalid option selected");
									optionNotSelected=true;
									}
							}catch(InvestmentException e){
								System.err.println(e.getMessage());
							}
							catch(EmployeeNotFoundException e){
								System.err.println(e.getMessage());
							}
							catch(NumberFormatException e){
								System.err.println("Please enter a number !!!");
							}
						}while(optionNotSelected);
						System.out.println("----------------------------"+collection.getEmployee(empId).getName()+" do you want to perform any other operation (y/n) :");
						logOut=input.readLine();
					}while(logOut.equalsIgnoreCase("y"));
					System.out.println("Do you want to login again (y/n) :");
					mainLogOut=input.readLine();
					if(mainLogOut.equalsIgnoreCase("n"))
						System.out.println("\n================  THANK YOU =====================");
				}
				
				else if(collection.getEmployee(empId) instanceof Admin){
					logOut="n";
					do{
						do{
							try{
								mainLogOut="n";
								System.out.println("\n=================Welcome "+collection.getEmployee(empId).getName()+" ==========================");
								System.out.println("----Select option ------");
								System.out.println("1.View investment submitted\n2.Approve investment");
								System.out.print("option: ");
								option=Integer.parseInt(input.readLine());
								int empIdView;
								switch(option){
								case 1:
									optionNotSelected=false;
									operationPerformed=true;
									//System.out.println("Enter employee id whose investment is to be viewed : ");
									//empIdView=Integer.parseInt(input.readLine());
									//display.displayInvestmentSubmit(empIdView);
									display.displayInvestmentSubmit();
									break;
								case 2:
									optionNotSelected=false;
									operationPerformed=true;
									System.out.println("Enter employee id whose investment is to be approved : ");
									empIdView=Integer.parseInt(input.readLine());
									collection.setInvestmentApproved(empIdView, collection.getInvestmentSubmit(empIdView));
									System.out.println("Investment of employee id: "+empIdView+" approved successfully !!!");
									break;
								default :
									System.out.println("Invalid option selected");
									optionNotSelected=true;
								}
							}catch(InvestmentException e){
								System.err.println(e.getMessage());
							}
							catch(EmployeeNotFoundException e){
								System.err.println(e.getMessage());
							}
							catch(NumberFormatException e){
								System.err.println("Please enter a number !!!");
							}
						}while(optionNotSelected);
						System.out.println();
						System.out.println("\n\n----------------------------"+collection.getEmployee(empId).getName()+" do you want to perform any other operation (y/n) :");
						logOut=input.readLine();
					}while(logOut.equalsIgnoreCase("y"));
					System.out.println("Do you want to login again (y/n) :");
					mainLogOut=input.readLine();
					if(mainLogOut.equalsIgnoreCase("n"))
						System.out.println("\n=============THANK YOU =================");
				}
				}catch(EmployeeNotFoundException e){
					System.err.println("\n"+e.getMessage());
				}
			}
			else{  //when invalid login credentials are entered, this block gets executed
				if(!operationPerformed){
					logoutAttempt++;
					if(logoutAttempt==3){
						logoutAttempt=0;
						throw new InvalidLoginException("Exceeded 3 login attempts.........please try again later!");
					}
					else{
						System.out.println("\t\tInvalid login credentials");
						System.out.println("\tYou have "+(3-logoutAttempt)+" login attempt(s) remaining");
						mainLogOut="y";
					}
				}
					
			}
				
		}while(mainLogOut.equalsIgnoreCase("y"));
		
	}
	static boolean loginAuth(int empId,String pass) throws IOException {
		/**
		 * It accepts employee id and password from login(), and compares it with value stored in a text 
		 * file for authentication
		 * 
		 * returns true if credentials are valid
		 * else return false
		 * 
		 * inFile --> used to read from a File
		 * inBuffer --> used to buffer the characters from file
		 */
		boolean logInFound=false;
		
		FileReader inFile=null;
		BufferedReader inBuffer=null;
		
		/*inBuffer=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter login id :");
		String logId=inBuffer.readLine();
		System.out.println("Enter password :");
		String pass=inBuffer.readLine();*/
		
		try{
			inFile=new FileReader("LoginPass.txt");
			inBuffer=new BufferedReader(inFile);
			String line=null;
			while(true){  //will run till end of file is reached or match is found 
				line=inBuffer.readLine();
				if(line==null){//End of file
					break;
				}
				else if(line.equals(empId+" "+pass)){
					logInFound=true;
					break;
				
				}
				
			}
		//	return logInFound;
		
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Please check the file name !!!");
		}
		catch(IOException ioe){
			System.out.println("your HDD seems to be corrupted !!!");
		}
		finally{
		
			try {
				inBuffer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try{
				inFile.close();
				
			}
			catch(Exception ignored){
				
			}
			
		}
		return logInFound;

	}

}
