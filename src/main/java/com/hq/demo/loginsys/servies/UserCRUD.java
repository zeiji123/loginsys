package com.hq.demo.loginsys.servies;

import java.util.List;

import com.hq.demo.loginsys.domains.User;

public interface UserCRUD {
	public User getById(Long id);
	
	public User getByName(String name);
	
	public User getByPassword(String password);
	
	public void add(User user);
	
	public List<User> getAll();
	
	
}
