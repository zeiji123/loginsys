package com.hq.demo.loginsys.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
   //自动增长的逻辑主键
	@Id
	@GeneratedValue
	private Long id;
	//用户名
	@Column(length=10,nullable=false,unique=true)
	private String name;
	//密码
	@Column(length=18,nullable=false,unique=true)
	private String password;
	
	private Long getId(){
		return id;
	}
	private void setId(Long id){
		this.id=id;
	}
	private String getName(){
		return name;
	}
	private void setName(String name){
		this.name=name;
	}
	private String getPassword(){
		return password;
	}
	private void setPassword(String password){
		this.password=password;
	}
	
	
	
}
