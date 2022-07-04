package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

/*
 * this is a interface i created its pretty straightforward
 */

public interface CompensationService {
	
	Compensation create(String id,String salary,String date);
	
	Compensation read(String id);
}
