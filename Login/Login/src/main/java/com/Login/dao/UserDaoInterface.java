package com.Login.dao;

import java.util.List;

import com.Login.entity.User;

public interface UserDaoInterface {

	List<User> getUsers();
	
	User getUser(String userId);
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(String userId);
	
}
