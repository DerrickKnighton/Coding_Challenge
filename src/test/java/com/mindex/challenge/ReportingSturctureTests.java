package com.mindex.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.ReportingSturctureService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingSturctureTests {
	
	/*
	 * This is a class i made to test 3 ReportingSturctures with different employees
	 */
	
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
	private ReportingSturctureService reportingStructureService;

    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals(reportingStructureService.getEmployeeReportingSturcture(employee).getNumberOfReports(),4);
        
        Employee employee2 = employeeRepository.findByEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");
        assertNotNull(employee2);
        assertEquals(reportingStructureService.getEmployeeReportingSturcture(employee2).getNumberOfReports(),2);
        
        Employee employee3 = employeeRepository.findByEmployeeId("62c1084e-6e34-4630-93fd-9153afb65309");
        assertNotNull(employee3);
        assertEquals(reportingStructureService.getEmployeeReportingSturcture(employee3).getNumberOfReports(),0);
    }

}
