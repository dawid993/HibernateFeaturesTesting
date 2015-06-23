package com.bieniek.revision.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T,ID extends Serializable> 
{
	public void create(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T read(ID id);
	
	public List<T> readAllEntities();
	
	public void deleteAll();
	
}
