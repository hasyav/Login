package com.Login.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Login.entity.User;

@Repository
public class UserDaoImpl implements UserDaoInterface {
	
	@Autowired
	LoginRepository loginrepo;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stubs
		return loginrepo.findAll();
	}
	@Override
	public User getUser(String userId) {
		return loginrepo.findOne(userId);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return loginrepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return loginrepo.save(user);
	}
	@Override
	public void deleteUser(String userId) {
		loginrepo.delete(userId);;
		
	}

	

}
