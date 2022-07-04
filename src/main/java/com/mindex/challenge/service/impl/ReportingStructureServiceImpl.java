package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingSturctureService;

/*
 * This is one of the classes i made, in a nutshell it generates a reporting structure just a note this should work fine
 * with the assumption there is no loop in the tree ie a lower node connects to an upper node i didnt want to write that part because i didnt feel it 
 * necessary based on the project description but basically it would be logic to check if you have looped back around by adding previous nodes to a list to keep 
 * track or along those lines also didnt add any checks to make sure the vars were formed in the right way but i think this works for now
 */

@Service
public class ReportingStructureServiceImpl implements ReportingSturctureService{
	
	@Autowired
    private EmployeeService employeeService; // need this because i have to use employee ids to fetch the directreports they have after first employee
	
	private int numberOfReports = 0; // starts at 0 will be reset in getEmployeeReportingSturcture after number of reports is found

	@Override
	public ReportingStructure getEmployeeReportingSturcture(Employee employee) {
		ReportingStructure reportingSturcture = new ReportingStructure(employee,findNumberOfReports(employee)); // creating new ReportingSturcture to return calling findNumberOfReports to get number of reports 
		numberOfReports = 0;
		return reportingSturcture;
	}
		
	private int findNumberOfReports(Employee employee2) { // this is a recursive method to parse the direct reports tree Structure
		System.out.println(employee2.getEmployeeId());
		System.out.println(employeeService.read(employee2.getEmployeeId()));
		
		if(employee2.getDirectReports() == null) { // terminate some call if it has no direct reports classic recursion
			System.out.println("here in the terminating condition");
			return numberOfReports;
		}
		
		else {
			System.out.println("Here in adding condition");
			numberOfReports += employee2.getDirectReports().size(); // add all direct reports of current employee to the number we want to return
			for(int i = 0; i < employee2.getDirectReports().size(); i++) { // go through all direct reports of current employee start the recursion calls
				findNumberOfReports(employeeService.read(employee2.getDirectReports().get(i).getEmployeeId()));
			}
			
		}
		
		return numberOfReports;
	}

}
