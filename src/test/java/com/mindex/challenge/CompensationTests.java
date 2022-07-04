package com.mindex.challenge;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.mindex.challenge.service.impl.CompensationServiceImpl;

/*
 * unit tests for the compensation service
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompensationTests {

    @Autowired
    private CompensationServiceImpl compensationServiceImpl;

   
    @Test
    public void test() {
    	String id = "b7839309-3348-463b-a7e3-5de1c168beb3";
    	String salary = "2000000";
    	String date = "01221998";
    	compensationServiceImpl.create(id, salary, date);
    	
    	assertNotNull(compensationServiceImpl.read(id));
    	
    }
}
