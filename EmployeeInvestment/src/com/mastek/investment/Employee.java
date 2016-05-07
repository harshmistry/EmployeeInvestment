package com.mastek.investment;

public abstract class Employee {
	private static int empId;
	private Name name;
	private int phNo;
	private int salary;
	private String panNo;
	
	{
		Employee.empId+=1;
	}
	
	//****************** constructors ******************************//
	public Employee() {
		
	}

	public Employee(Name name, int phNo, int salary, String panNo) {
		super();
		this.name = name;
		this.phNo = phNo;
		this.salary = salary;
		this.panNo = panNo;
	}
	
	//********************* getters/setters ***************************//

	public int getEmpId() {
		return empId;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getPhNo() {
		return phNo;
	}

	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	

}
