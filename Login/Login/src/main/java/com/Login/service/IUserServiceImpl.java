package com.Login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.entity.User;
import com.Login.dao.UserDaoInterface;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	private UserDaoInterface userDaoInterface;

	@Override
	public List<User> getUsers() {                 
		// TODO Auto-generated method stub
		return userDaoInterface.getUsers();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userDaoInterface.getUser(userId);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.updateUser(user);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userDaoInterface.deleteUser(userId);
	}

}
