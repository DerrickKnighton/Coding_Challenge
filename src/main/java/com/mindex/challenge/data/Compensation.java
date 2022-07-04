package com.mindex.challenge.data;

public class Compensation {
	
	/*
	 * This is a class i made pretty straightforward object class realistically i would use a different type for the date but 
	 * i thought a string would work
	 */
	private Employee employee;
	private double salary;
	private String date;
	
	public Compensation(Employee employee, double salary, String date) {
		this.setEmployee(employee);
		this.salary = salary;
		this.setDate(date);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


}
