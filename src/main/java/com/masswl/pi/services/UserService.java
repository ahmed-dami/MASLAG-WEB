package com.masswl.pi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masswl.pi.entities.Role;
import com.masswl.pi.entities.SexeType;
import com.masswl.pi.entities.User;
import com.masswl.pi.repository.RoleRepository;
import com.masswl.pi.repository.UserRepository;


@Service
public class UserService implements IUserService {
	
	
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	

	@Override
	public boolean deleteUser(long id) {
		if (userRepository.existsById(id)){
			userRepository.deleteById(id);
			return true;
		}else
		return false;
	}
	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User retrieveUserById(long idUs) {
		return userRepository.findById(idUs).get();
	}
	@Override
	public User updateUser(User user) throws Exception {
		User users = userRepository.findByid(user.getId());
		if (users!=null) {
			return userRepository.save(user);
		} else {
			throw new Exception("No the user record exist");
		}
	}
	@Override
	public User getUserById(long id) throws Exception {
		return userRepository.findByid(id);
	}
	@Override
	public User activateUser (User user) throws Exception {
		user.setStateUser(true);
		return updateUser(user);
	}

	@Override
	public User desactivateUser (User user) throws Exception {
		user.setStateUser(false);
		return updateUser(user);
	}
	@Override
	public List<User> retrieveUserBySexe(SexeType sexeUser) {
		return userRepository.findBySexeUser(sexeUser);
	}

	@Override
	public List<User> retrieveUserByState(boolean stateUser) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> retrieveUserByAdress(String adressUser) {
		return userRepository.findByAdressUser(adressUser);
	}
	@Override
	public List<User> retrieveUserByDate(Date birthDateUser) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
