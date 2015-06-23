package com.bieniek.revision.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User",catalog = "revision")
public class User 
{
	private long id;
	private String name;
	private String surname;
	private UserInfo userInfo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false,unique=true)
	public long getId() 
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	@Column(name = "name",nullable = false,length=30)
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Column(name = "surname",nullable = false,length=50)
	public String getSurname() 
	{
		return surname;
	}
	
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}

	@OneToOne(mappedBy = "user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public UserInfo getUserInfo() 
	{
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}
	
	
}
