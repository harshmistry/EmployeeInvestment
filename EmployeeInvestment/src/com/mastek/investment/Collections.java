package com.mastek.investment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mastek.investment.exception.EmployeeNotFoundException;
import com.mastek.investment.exception.InvestmentException;

public class Collections {
	private static Map<Integer,Investment> empCurrentInvest=new HashMap<Integer,Investment>();
	private static Map<Integer,Investment> empInvestmentSubmit=new HashMap<Integer,Investment>();
	private static Map<Integer, List<Investment>> empHistoryInvest = new HashMap<Integer, List<Investment>>();
	private static Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
	private static Map<Integer,Investment> empInvestmentApproved=new HashMap<Integer, Investment>();

	public void setEmpHistoryInvestment(int empId, Investment investment) {   
		List<Investment> tempInvestList = new ArrayList<Investment>();
		if(empHistoryInvest.containsKey(empId)){
			
			tempInvestList=empHistoryInvest.get(empId);
			tempInvestList.add(investment);
			empHistoryInvest.put(empId, tempInvestList);
		}
		else{
			tempInvestList.add(investment);
			empHistoryInvest.put(empId, tempInvestList);
		}
			
	}

	public List<Investment> getEmpHistoryInvestment(int empId)
			throws InvestmentException {
		if (empHistoryInvest.containsKey(empId))
			return empHistoryInvest.get(empId);
		else
			throw new InvestmentException(
					"No investment history for employee id :" + empId);
	}

	public Map<Integer, List<Investment>> getEmpHistoryInvestmentMap() {
		return empHistoryInvest;
	}

	public void setEmpMap(int empId, Employee employee) {
		empMap.put(empId, employee);
	}

	public Employee getEmployee(int empId) throws EmployeeNotFoundException {
		if (empMap.containsKey(empId))
			return empMap.get(empId);
		else
			throw new EmployeeNotFoundException("No such employee id exist");
	}

	public Map<Integer, Employee> getEmployeeMap() {
		return empMap;
	}
	
	public void setCurrentInvestment(int empId,Investment investment){
		if(empCurrentInvest.containsKey(empId)){
			setEmpHistoryInvestment(empId,empCurrentInvest.get(empId));
			empCurrentInvest.remove(empId);
		}
			empCurrentInvest.put(empId,investment);
	}
	
	public Investment getCurrentInvestment(int empId) throws InvestmentException{
		if(empCurrentInvest.containsKey(empId))
			return empCurrentInvest.get(empId);
		else
			throw new InvestmentException("No investment declared by employee id : "+empId);
	}
	
	public void setInvestmentSubmit(int empId,Investment investment) throws  InvestmentException{
		if(empInvestmentSubmit.containsKey(empId))
			throw new InvestmentException("Investment proof already submitted by employee id :"+empId);
		else
			empInvestmentSubmit.put(empId,investment);
	/*	else if(empCurrentInvest.containsKey(empId))
			empInvestmentSubmit.put(empId,investment);
		else
			throw new InvestmentException("No investment declared by employee id : "+empId);*/
	}
	public Investment getInvestmentSubmit(int empId) throws InvestmentException, EmployeeNotFoundException{
		if(empMap.containsKey(empId)){
		if(empInvestmentSubmit.containsKey(empId))
			return empInvestmentSubmit.get(empId);
		else
			throw new InvestmentException("No investment proof submitted by employee id :"+empId);
		}
		else
			throw new EmployeeNotFoundException("No such employee id exist");
	}
	public Map<Integer,Investment> getInvestSubmitMap(){
		return empInvestmentSubmit;
	}
	
	public void setInvestmentApproved(int empId,Investment investment) throws InvestmentException{
		if(empInvestmentApproved.containsKey(empId))
			throw new InvestmentException("Investment of employee id "+empId+" already approved");
		else if(empInvestmentSubmit.containsKey(empId))
				empInvestmentApproved.put(empId,investment);
			else
				throw new InvestmentException("Cannot approve as investment proof not submitted by employee "+empId);
	}
	public Investment getInvestmentApproved(int empId) throws InvestmentException{
		if(empInvestmentApproved.containsKey(empId))
			return empInvestmentApproved.get(empId);
		else
			throw new InvestmentException("Investment of employee id "+empId+" not approved yet");
	}
	
}
