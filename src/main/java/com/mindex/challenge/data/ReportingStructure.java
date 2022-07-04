package com.mindex.challenge.data;

public class ReportingStructure {
	
	/*
	 * this is a class i wrote not too much to say here its a pretty straightforward object class
	 */
		
	private Employee employee;
	private int numberOfReports;
	
	public ReportingStructure(Employee employee, int numberOfReports) {
		this.employee = employee;
		this.numberOfReports = numberOfReports;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getNumberOfReports() {
		return numberOfReports;
	}

	public void setNumberOfReports(int numberOfReports) {
		this.numberOfReports = numberOfReports;
	}

}
