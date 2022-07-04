package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;

/*
 * Service class for compensation class adds new compensations and can also read them i didnt add any checks to make sure the vars were formed in a correct way
 * but i think this works for now
 */

@Service
public class CompensationServiceImpl implements CompensationService{
	
	private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
	
	@Autowired
	private CompensationRepository compensationRepository;
	
	@Autowired
    private EmployeeService employeeService;

	@Override
	public Compensation create(String id,String salary,String date) { // this parses the parameters and adds them to the db
		LOG.debug("id:" + id + " salary:" + salary + " date:" + date);
		double salaryDouble=Double.parseDouble(salary);		
		Compensation compensation = new Compensation(employeeService.read(id), salaryDouble, date);
        compensationRepository.insert(compensation);
        LOG.debug("new compensation created for" + compensation.getEmployee().getFirstName());
		return compensation;
	}

	@Override
	public Compensation read(String id) { // get an employee by id from the db
		Employee employee = employeeService.read(id);
		return compensationRepository.findByEmployee(employee);
	}


}
