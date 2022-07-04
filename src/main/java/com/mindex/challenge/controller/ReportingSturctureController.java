package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingSturctureService;

/*
 * this is a class i wrote to be able to get a ReportingSturcture using a rest endpoint
 */

@RestController
public class ReportingSturctureController {
	private static final Logger LOG = LoggerFactory.getLogger(ReportingSturctureController.class);
	
	@Autowired
	private ReportingSturctureService reportingStructureService;
	@Autowired
    private EmployeeService employeeService;
	
	// mapped to a get request one example would be http://localhost:8080/reportingsturcture/16a596ae-edd3-4847-99fe-c4518e82c86f in the browser
    @GetMapping("/reportingsturcture/{id}")
    public ReportingStructure getEmployeeReportingSturcture(@PathVariable String id) {
        LOG.debug("Received ReportingSturcture request for employee id", id);

        Employee employee = employeeService.read(id); // use service to get employee from db
        return reportingStructureService.getEmployeeReportingSturcture(employee); // uses service to determine ReportingSturcture
    }

}
