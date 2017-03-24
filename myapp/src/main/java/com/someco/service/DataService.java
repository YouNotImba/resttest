package com.someco.service;

import java.util.Set;

import com.someco.entity.Data;

/**
 * @author ikarmatsky
 *
 */
public interface DataService {

	boolean persist(String data);
	
	Set<String> getRandomData();
}
