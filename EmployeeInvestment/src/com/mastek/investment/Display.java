package com.mastek.investment;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mastek.investment.exception.EmployeeNotFoundException;
import com.mastek.investment.exception.InvestmentException;



public class Display {
	private Collections collection=new Collections();
	private Map<Integer,Employee> empMap;
	private Map<Integer,Investment> invstSubmitMap;
	private List<Investment> investmentList;
	Set<Integer> empIdSet;
	private Investment currentInvestment;
	private Investment investmentSubmit;
	
	
	public void displayEmployee(int empId) throws EmployeeNotFoundException{
		System.out.println("\n\n---------------------------------------------------------Employee id :"+empId+" information ----------------------------------------------------------------------------------------------------------------------------");
		if(collection.getEmployeeMap().containsKey(empId) && collection.getEmployeeMap().get(empId) instanceof Executive){
			display();
			System.out.print(empId+"\t\t\t"+collection.getEmployeeMap().get(empId).getName()+"\t\t\t\t"
					+collection.getEmployeeMap().get(empId).getSalary()+"\t\t\t"+
					+collection.getEmployeeMap().get(empId).getPhNo()+"\t\t\t"
					+collection.getEmployeeMap().get(empId).getPanNo());
		}
		else
			throw new EmployeeNotFoundException("No such employee id exist !!!!");
	}
	
	public void displayAllEmployee() throws EmployeeNotFoundException {
		empMap=collection.getEmployeeMap();
		
		empIdSet=empMap.keySet();
			for(int empId : empIdSet){
				
					displayEmployee(empId);
				
				System.out.println();
			}
	}
	
	void display(){
			System.out.println("\n\nEmp_Id\t\t\tName\t\t\t\t\t\tSalary\t\t\tPhone_No\t\t\tPan_No");
			System.out.println("------\t\t\t----\t\t\t\t\t\t------\t\t\t--------\t\t\t------");
	}
	
	public void displayInvestmentHistory(int empId) throws InvestmentException, EmployeeNotFoundException{
			
			investmentList=collection.getEmpHistoryInvestment(empId);
			if(collection.getEmployeeMap().containsKey(empId) && collection.getEmployeeMap().get(empId) instanceof Executive){
				displayEmployee(empId);
				System.out.println("\n\n\n==================================================Employee Id : "+empId+"  previous declaration =============================================================================================================================\n");
				System.out.println("Date\t\tCity\t\tInfrastructure Bond\tLife Insurance\tMutual Fund\tPension Fund\tProvident Fund"
								+"\tMediclaim Senior\tMediclaim Non_Senior\tMedical Bill\tHouse Rent\tHRA");
				System.out.println("----\t\t----\t\t-------------------\t--------------\t-----------\t------------\t--------------"
								+"\t----------------\t--------------------\t------------\t----------\t---");
				for(int i=0;i<investmentList.size();i++){
					System.out.print(investmentList.get(i).getInvestDate()+"\t"+investmentList.get(i).getCity()+"\t\t"+investmentList.get(i).getInfrastructureBond()
							+"\t\t\t"+investmentList.get(i).getLifeInsurance()+"\t\t"+investmentList.get(i).getMutualFund()+"\t\t"+investmentList.get(i).getPensionFund()
							+"\t\t"+investmentList.get(i).getProvidentFund()+"\t\t"+investmentList.get(i).getMediclaimSenior()+"\t\t\t"+investmentList.get(i).getMediclaimNonSenior()
							+"\t\t\t"+investmentList.get(i).getMedicalBills()+"\t\t"+investmentList.get(i).getHouseRent()+"\t\t"+TaxCalculation.calculateHra(collection.getEmployeeMap().get(empId).getSalary(), investmentList.get(i).getCity()));
					System.out.println();
				}
				System.out.println("\n===============================================================================================================================================================================================================================");
			}
		
	}
	
	public void displayCurrentInvestment(int empId) throws InvestmentException, EmployeeNotFoundException{
			
			currentInvestment=collection.getCurrentInvestment(empId);
			if(collection.getEmployeeMap().containsKey(empId) && collection.getEmployeeMap().get(empId) instanceof Executive){
				displayEmployee(empId);
				System.out.println("\n\n\n==================================================Employee Id : "+empId+" current declaration ==========================================================================================================================\n");
				System.out.println("Date\t\tCity\t\tInfrastructure Bond\tLife Insurance\tMutual Fund\tPension Fund\tProvident Fund"
								+"\tMediclaim Senior\tMediclaim Non_Senior\tMedical Bill\tHouse Rent\tHRA");
				System.out.println("----\t\t----\t\t-------------------\t--------------\t-----------\t------------\t--------------"
								+"\t----------------\t--------------------\t------------\t----------\t---");
				
					System.out.print(currentInvestment.getInvestDate()+"\t"+currentInvestment.getCity()+"\t\t"+currentInvestment.getInfrastructureBond()
							+"\t\t\t"+currentInvestment.getLifeInsurance()+"\t\t"+currentInvestment.getMutualFund()+"\t\t"+currentInvestment.getPensionFund()
							+"\t\t"+currentInvestment.getProvidentFund()+"\t\t"+currentInvestment.getMediclaimSenior()+"\t\t\t"+currentInvestment.getMediclaimNonSenior()
							+"\t\t\t"+currentInvestment.getMedicalBills()+"\t\t"+currentInvestment.getHouseRent()+"\t\t"+TaxCalculation.calculateHra(collection.getEmployeeMap().get(empId).getSalary(), currentInvestment.getCity()));
					System.out.println();
				
				System.out.println("\n=================================================================================================================================================================================================================");
			}
		
	}
	
	
	public void displayInvestmentSubmit(int empId) throws InvestmentException, EmployeeNotFoundException{
			
			investmentSubmit=collection.getInvestmentSubmit(empId);
			if(collection.getEmployeeMap().containsKey(empId) && collection.getEmployeeMap().get(empId) instanceof Executive){
				displayEmployee(empId);
				System.out.println("\n\n\n==================================================Employee Id : "+empId+" declaration submitted ==========================================================================================================\n");
				System.out.println("Date\t\tCity\t\tInfrastructure Bond\tLife Insurance\tMutual Fund\tPension Fund\tProvident Fund"
								+"\tMediclaim Senior\tMediclaim Non_Senior\tMedical Bill\tHouse Rent\tHRA");
				System.out.println("----\t\t----\t\t-------------------\t--------------\t-----------\t------------\t--------------"
								+"\t----------------\t--------------------\t------------\t----------\t---");
				
					System.out.print(investmentSubmit.getInvestDate()+"\t"+investmentSubmit.getCity()+"\t\t"+investmentSubmit.getInfrastructureBond()
							+"\t\t\t"+investmentSubmit.getLifeInsurance()+"\t\t"+investmentSubmit.getMutualFund()+"\t\t"+investmentSubmit.getPensionFund()
							+"\t\t"+investmentSubmit.getProvidentFund()+"\t\t"+investmentSubmit.getMediclaimSenior()+"\t\t\t"+investmentSubmit.getMediclaimNonSenior()
							+"\t\t\t"+investmentSubmit.getMedicalBills()+"\t\t"+investmentSubmit.getHouseRent()+"\t\t"+TaxCalculation.calculateHra(collection.getEmployeeMap().get(empId).getSalary(), currentInvestment.getCity()));
					System.out.println();
				
				System.out.println("\n======================================================================================================================================================================================================");
			}
		
		
	}
	
	public void displayInvestmentSubmit() throws InvestmentException, EmployeeNotFoundException{
		
		invstSubmitMap=collection.getInvestSubmitMap();
		empIdSet=invstSubmitMap.keySet();
		if(invstSubmitMap.isEmpty())
			System.err.println("--------- No investment proof submitted by any employee(s)-----");
		else{
			for(int eId:empIdSet){
				if(collection.getEmployeeMap().containsKey(eId) && collection.getEmployeeMap().get(eId) instanceof Executive){
					//displayEmployee(eId);
					investmentSubmit=invstSubmitMap.get(eId);
					System.out.println("\n\n\n==================================================Employee Id : "+eId+" declaration submitted ==========================================================================================================\n");
					System.out.println("Date\t\tCity\t\tInfrastructure Bond\tLife Insurance\tMutual Fund\tPension Fund\tProvident Fund"
									+"\tMediclaim Senior\tMediclaim Non_Senior\tMedical Bill\tHouse Rent\tHRA");
					System.out.println("----\t\t----\t\t-------------------\t--------------\t-----------\t------------\t--------------"
									+"\t----------------\t--------------------\t------------\t----------\t---");
					
						System.out.print(investmentSubmit.getInvestDate()+"\t"+investmentSubmit.getCity()+"\t\t"+investmentSubmit.getInfrastructureBond()
								+"\t\t\t"+investmentSubmit.getLifeInsurance()+"\t\t"+investmentSubmit.getMutualFund()+"\t\t"+investmentSubmit.getPensionFund()
								+"\t\t"+investmentSubmit.getProvidentFund()+"\t\t"+investmentSubmit.getMediclaimSenior()+"\t\t\t"+investmentSubmit.getMediclaimNonSenior()
								+"\t\t\t"+investmentSubmit.getMedicalBills()+"\t\t"+investmentSubmit.getHouseRent()+"\t\t"+TaxCalculation.calculateHra(collection.getEmployeeMap().get(eId).getSalary(), currentInvestment.getCity()));
						System.out.println();
					
					System.out.println("\n======================================================================================================================================================================================================");
				}
			}
		}
	}	
}