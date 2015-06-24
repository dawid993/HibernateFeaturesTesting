package com.bieniek.revision.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phones 
{
	private long id;
	private String type;
	private String number;
	private User user;
	
	public long getId() 
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public void setNumber(String number) 
	{
		this.number = number;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user) 
	{
		this.user = user;
	}
}
