package com.masswl.pi.services;

import java.util.Date;
import java.util.List;

import com.masswl.pi.entities.Role;
import com.masswl.pi.entities.SexeType;
import com.masswl.pi.entities.User;



public interface IUserService {
	

	boolean deleteUser(long id);
	List<User> retrieveAllUsers();
	User retrieveUserById(long id);
	public User updateUser(User user) throws Exception;
	public User getUserById(long id) throws Exception;
    public User activateUser (User user) throws Exception;
	public User desactivateUser (User user) throws Exception;
	List<User> retrieveUserBySexe(SexeType sexeUser);
	List<User> retrieveUserByState(boolean stateUser);
	List<User> retrieveUserByAdress(String adressUser);
	List<User> retrieveUserByDate(Date birthDateUser);



	
}
