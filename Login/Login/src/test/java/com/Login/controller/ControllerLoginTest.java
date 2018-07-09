package com.Login.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import com.Login.service.IUserServiceImpl;
import com.Login.dao.UserDaoImpl;
import com.Login.entity.User;
import com.Login.exception.UserNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class ControllerLoginTest {

    private static final String EMAIL_ID = "abc@gmail.com";
    
    private User user;
    
    private List<User> users;
    @Mock
    private UserDaoImpl userDao;

    @InjectMocks
    private IUserServiceImpl service;

    @Before
    public void init() throws Exception{
    	
    	this.user=Mockito.mock(User.class);
    	Mockito.doReturn("sandhya").when(this.user).getFirstName();
    	Mockito.doReturn("sandhya@gmail.com").when(this.user).getEmail();
        MockitoAnnotations.initMocks(this);
        users= new ArrayList<User>();
        users.add(user);            
    }
    
    @Test
    public void test_get_all_users() throws Exception {
       Mockito.doReturn(users).when(this.userDao).getUsers();
       List<User> actualUsers=service.getUsers();
       assertEquals(user.getEmail(), actualUsers.get(0).getEmail());
    }
    
    @Test
	public void testGetUser() throws Exception {		
		Mockito.doReturn(user)
		 .when(userDao)
		 .getUser("sandhya@gmail.com");
		User user=service.getUser("sandhya@gmail.com");
		assertEquals("sandhya@gmail.com", user.getEmail());
	}
    
    @Test(expected = UserNotFoundException.class)
	public void testGetUserNotFound() throws Exception {	
		Mockito.doThrow(UserNotFoundException.class)
		.when(this.userDao)
		.getUser(EMAIL_ID);
	    this.service.getUser(EMAIL_ID);
	}
    
    @Test
	public void testDeleteUser() throws Exception {
		Mockito.doNothing()
		 .when(userDao)
		 .deleteUser("sandhya@gmail.com");
		service.deleteUser("sandhya@gmail.com");
		verify(userDao,times(1)).deleteUser("sandhya@gmail.com");
	}

	@Test
	public void testUpdateUser() throws Exception {
		Mockito.doReturn(user)
		 .when(userDao)
		 .updateUser(Mockito.any(User.class));	
		assertEquals(user,service.updateUser(user));
	}

	@Test
	public void testAddUser() throws Exception {
		Mockito.doReturn(user)
		 .when(userDao)
		 .createUser(Mockito.any(User.class));
		assertEquals(user,service.createUser(user));
	}
}
   