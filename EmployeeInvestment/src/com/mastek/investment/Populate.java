package com.mastek.investment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;


import com.mastek.investment.exception.InvestmentException;



public class Populate {
	/**
	 * Methods
	 * (1)populateEmployee() --> called to populate employees in the system statically
	 * (2)populateAdmin() --> called to populate admin in the system statically
	 * (3)declareInvestment() --> called to make investment declaration
	 * (4)submitInvestment() --> called to submit investment proof
	 */
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
	private Investment makeInvestment;
	private Investment submitInvestment;
	private Calendar calendar;
	
	private	Collections collection=new Collections();
	//private Map<Integer, Employee> empMap=new HashMap<Integer, Employee>();
	
	//************************* constructor **********************************************//
	public Populate() {
		calendar=Calendar.getInstance();  //calendar is instantiated to check the declaration and submission condition
	}
	public void setEmpId(int eId){
		this.empId=eId;      //so that user does not have to enter employee id again
	}
	public void populateEmployee(){
		
		Employee emp=new Executive();
		emp.setName(new Name("Allen","Luther","King"));
		emp.setPanNo("BX1234A");
		emp.setPhNo(98542102);
		emp.setSalary(12000);
		collection.setEmpMap(emp.getEmpId(), emp);
		
		emp=new Executive();
		emp.setName(new Name("Sir","Vivian","Richard"));
		emp.setPanNo("AX1434F");
		emp.setPhNo(98658210);
		emp.setSalary(32000);
		collection.setEmpMap(emp.getEmpId(), emp);
		
		emp=new Executive();
		emp.setName(new Name("Steve","Allen","Waugh"));
		emp.setPanNo("AC1467Q");
		emp.setPhNo(96587452);
		emp.setSalary(33625);
		collection.setEmpMap(emp.getEmpId(), emp);
		
		
	}
	public void populateAdmin(){
		Employee admin=new Admin();
		admin.setName(new Name("Admin","Martyr","Lex"));
		admin.setPhNo(98542102);
		collection.setEmpMap(admin.getEmpId(),admin);
	}
	
	void acceptInvestmentAmount() throws IOException{
		/**
		 * Used to accept declaration amount from user
		 */
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		boolean inputCompleted=false;
		/*System.out.print("Enter employee id : ");
		empId=Integer.parseInt(input.readLine());*/
		do{    //will run till user does not enters appropriate amount 
			try{
				System.out.print("Enter lifeInsurance amount : ");
				lifeInsurance=Double.parseDouble(input.readLine());
				if(lifeInsurance<0){     //if negative values are entered, then user is asked to enter amount again 
					System.out.println("Negative value found............re-enter");
					continue;          //to directly execute do loop without executing statements below
				}
				
				System.out.print("Enter providentFund amount : ");
				providentFund=Double.parseDouble(input.readLine());
				if(providentFund<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				
				System.out.print("Enter pensionFund amount : ");
				pensionFund=Double.parseDouble(input.readLine());
				if(pensionFund<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				
				System.out.print("Enter mutualFund amount : ");
				mutualFund=Double.parseDouble(input.readLine());
				if(mutualFund<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				
				System.out.print("Enter infrastructureBond amount : ");
				infrastructureBond=Double.parseDouble(input.readLine());
				if(infrastructureBond<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				
				System.out.print("Enter mediclaim for senior amount : ");
				mediclaimSenior=Double.parseDouble(input.readLine());
				if(mediclaimSenior<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				
				System.out.print("Enter mediclaim for non_senior amount : ");
				mediclaimNonSenior=Double.parseDouble(input.readLine());
				if(mediclaimNonSenior<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				
				System.out.print("Enter medicalBills amount : ");
				medicalBills=Double.parseDouble(input.readLine());
				if(medicalBills<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				System.out.print("Enter houseRent amount : ");
				houseRent=Double.parseDouble(input.readLine());
				if(houseRent<0){
					System.out.println("Negative value found............re-enter");
					continue;
				}
				
				if(houseRent!=0){  //not to provide the option of selecting city if he does not enters house rent
					boolean cityNotSelected=true;
					do{          //will run till user selects appropriate city
						System.out.println("Select city :\n1.Mumbai\t2.Chennai\t3.Pune ");
						System.out.print("Select option(1/2/3)  : ");
						int opt=Integer.parseInt(input.readLine());
						
						switch(opt){
						case 1:
							city="Mumbai";
							cityNotSelected=false;
							break;
						case 2:	
							city="Chennai";
							cityNotSelected=false;
							break;
						case 3:
							city="Pune";
							cityNotSelected=false;
							break;
						default:
							System.out.println("Invalid option.............Select again");
							cityNotSelected=true;
							break;
						}
					}
					while(cityNotSelected);
				}
				else
					city="";
				//if(lifeInsurance<0||)
				inputCompleted=true;
				}catch(NumberFormatException e){
					inputCompleted=false;
					System.err.println("\nPlease enter a number");
				}
		}while(!inputCompleted);
	}
//*************************************** declaring investment **********************************************************************//	
	
	public void declareInvestment() throws IOException, InvestmentException{
		System.out.println("================ Investment declaration page =========================");
		//if(calendar.get(Calendar.DATE)>=2&&calendar.get(Calendar.DATE)<=20)  //to check the system date 
		if(calendar.get(Calendar.DATE)>=1&&calendar.get(Calendar.DATE)<=31){
			acceptInvestmentAmount();
			if(TaxCalculation.is80CValid(lifeInsurance, providentFund, pensionFund, mutualFund, infrastructureBond)){
				if(TaxCalculation.is80DNonSenrValid(mediclaimNonSenior)){
					if(TaxCalculation.is80DSenrValid(mediclaimSenior)){
						if(TaxCalculation.isMedicalBillValid(medicalBills)){
							makeInvestment=new Investment();
							
							makeInvestment.setInfrastructureBond(infrastructureBond);
							makeInvestment.setLifeInsurance(lifeInsurance);
							makeInvestment.setMutualFund(mutualFund);
							makeInvestment.setPensionFund(pensionFund);
							makeInvestment.setProvidentFund(providentFund);
							
							makeInvestment.setMediclaimNonSenior(mediclaimNonSenior);
							makeInvestment.setMediclaimSenior(mediclaimSenior);
							
							makeInvestment.setMedicalBills(medicalBills);
							
							makeInvestment.setCity(city);
							makeInvestment.setHouseRent(houseRent);
							collection.setCurrentInvestment(empId, makeInvestment);
						
						}
						else
							throw new InvestmentException("Medical bill value exceeded Rs.15,000");
					}
					else
						throw new InvestmentException("Mediclaim for senior exceeded Rs.20,000");
				}
				else
					throw new InvestmentException("Mediclaim for non_senior exceeded Rs.15,000");
			}
			else
				throw new InvestmentException("Total amount for 80 D exceeded Rs.1,00,000");
		}
		else
			throw new InvestmentException("Investment must be declared between 2 and 20 of each month");
	}

	
//*************************************** submitting investment **********************************************************************//
	
	public void submitInvestment() throws IOException, InvestmentException{
		if(collection.getCurrentInvestment(empId)!=null){         //to check if that employee has declared before submitting values
			System.out.println("================ Investment submission page =========================");
			//if(calendar.get(Calendar.MONTH)==Calendar.MARCH){
			if(calendar.get(Calendar.MONTH)==Calendar.OCTOBER){
				//if(calendar.get(Calendar.DATE)>=21 && calendar.get(Calendar.DATE)<=31){
				if(calendar.get(Calendar.DATE)>=1 && calendar.get(Calendar.DATE)<=31){
					acceptInvestmentAmount();
					if(TaxCalculation.is80CValid(lifeInsurance, providentFund, pensionFund, mutualFund, infrastructureBond)){
						if(TaxCalculation.is80DNonSenrValid(mediclaimNonSenior)){
							if(TaxCalculation.is80DSenrValid(mediclaimSenior)){
								if(TaxCalculation.isMedicalBillValid(medicalBills)){
									submitInvestment=new Investment();
									
									submitInvestment.setInfrastructureBond(infrastructureBond);
									submitInvestment.setLifeInsurance(lifeInsurance);
									submitInvestment.setMutualFund(mutualFund);
									submitInvestment.setPensionFund(pensionFund);
									submitInvestment.setProvidentFund(providentFund);
									
									submitInvestment.setMediclaimNonSenior(mediclaimNonSenior);
									submitInvestment.setMediclaimSenior(mediclaimSenior);
									
									submitInvestment.setMedicalBills(medicalBills);
									
									submitInvestment.setCity(city);
									submitInvestment.setHouseRent(houseRent);
									collection.setInvestmentSubmit(empId, submitInvestment);
								
								}
								else
									throw new InvestmentException("Medical bill value exceeded Rs.15,000");	
							}
							else
								throw new InvestmentException("Mediclaim for senior exceeded Rs.20,000");
						}
						else
							throw new InvestmentException("Mediclaim for non_senior exceeded Rs.15,000");
					}
					else
						throw new InvestmentException("Total amount for 80 D exceeded Rs.1,00,000");
				}
				else 
					throw new InvestmentException("Investment submission to be made between 21 and 31 of March");
			}
			else
				throw new InvestmentException("Investment submission to be made between 21 and 31 of March");
		}
		else
			throw new InvestmentException("Cannot submit proof(s) as no investment is declared by employee id : "+empId);
	}	
}
