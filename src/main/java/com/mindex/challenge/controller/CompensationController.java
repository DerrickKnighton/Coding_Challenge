package com.mindex.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/*
 * Controller for compensation objects
 */

@RestController
public class CompensationController {
	
	@Autowired
	CompensationService compensationService;
	
	
	/* example request body for the put mapping
	 * {
        "employee": {
          "employeeId": "b7839309-3348-463b-a7e3-5de1c168beb3",
          "firstName": "Paul",
          "lastName": "McCartney",
          "position": "Developer I",
          "department": "Engineering",
          "directReports": null
       },
       "salary": 2000000,
       "date": "01221998"
}
	 */
	@PutMapping("/compensation")
    public Compensation create(@RequestParam String id, @RequestParam String salary, @RequestParam String date) { // endpoint to create a compensation object
        return compensationService.create(id,salary,date);
    }
	
	@GetMapping("/compensation/{id}") // endpoint to get a compensation object
    public Compensation read(@PathVariable String id) {
        return compensationService.read(id);
    }	

}
