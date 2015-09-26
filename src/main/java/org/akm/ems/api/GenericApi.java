package org.akm.ems.api;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author anish
 *
 * @param <T>
 * @param <Pk>
 */
public interface GenericApi<T extends Serializable,Pk extends Serializable> {

	/**
	 * 
	 * @param t
	 * @return
	 */
	T save(T t);
	
	/**
	 * 
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 
	 * @param pk
	 * @return
	 */
	T findOne(Pk pk);
	
	/**
	 * 
	 * @param ts
	 * @return
	 */
	List<T> saveAll(List<T> ts);
	
	
}
