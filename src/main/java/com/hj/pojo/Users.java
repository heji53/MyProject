package com.hj.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@GeneratedValue   //@GeneratedValue(strategy=GenerationType.UUID)
	private Integer id;

	private String name;

	@NotBlank(message = "性别必填")
	private String sex;

	@NotBlank(message = "地址必填")
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {

		return "Users [id=" + id + ", name=" + name + ", sex=" + sex + ", address=" + address + "]";
	}

	public Users(Integer id, String sex, String name, String address) {
		this.id = id;

		this.sex = sex;

		this.name = name;

		this.address = address;
	}

	public Users() {
	}

	public void updateByObj(Users user) {
		
		  if(user.getId()!=null) 
			  this.id=user.getId();
		 
		System.out.println("YYYYYYYY="+this.id);
		  if(user.getName()!=null&&!user.getName().equals(""))
			  this.name=user.getName();
		  if(user.getAddress()!=null&&!user.getAddress().equals(""))
			  this.address=user.getAddress();
		  if(user.getSex()!=null&&!user.getSex().equals(""))
			  this.sex=user.getSex();
	}

}
	
	

