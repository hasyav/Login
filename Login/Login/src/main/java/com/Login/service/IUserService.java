package com.Login.service;

import java.util.List;

import com.Login.entity.User;

public interface IUserService {
	public List<User> getUsers();
	public User getUser(String userId);
	public User createUser(User user);
	public User updateUser(User user);
	public void deleteUser(String userId);
}
