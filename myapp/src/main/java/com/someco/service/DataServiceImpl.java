package com.someco.service;

import java.util.Set;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.someco.entity.Data;
import com.someco.repository.DataRepository;

/**
 * @author ikarmatsky
 *
 */
@Service ("dataService")
public class DataServiceImpl implements DataService{

	private static final Log LOG = LogFactory.getLog(DataServiceImpl.class);
	
	@Autowired
	@Qualifier ("dataRepository")
	private DataRepository dataRepository;

	public DataRepository getDataRepository() {
		return dataRepository;
	}

	public void setDataRepository(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean persist(String entity) {
		
		try{
			dataRepository.persist(new Data(UUID.randomUUID(),entity));
			return true;
		} catch (Exception e) {
			LOG.error("ERROR SAVING DATA",e);
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<String> getRandomData() {
		return dataRepository.getRandomData();
	}
	
	
}
