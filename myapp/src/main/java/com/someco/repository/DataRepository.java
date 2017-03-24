package com.someco.repository;

import java.util.Set;

import com.someco.entity.DomainObject;

/**
 * @author ikarmatsky
 *
 */
public interface DataRepository<T extends DomainObject> {

	public void persist(T entity);
	
	public void delete(T entity);
	
	public Set<String> getRandomData();
}
