package com.masswl.pi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.masswl.pi.entities.Role;
import com.masswl.pi.entities.User;
import com.masswl.pi.services.IUserService;
import com.masswl.pi.services.UserService;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping({ "/user" })
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	IUserService iuserService;

	@PreAuthorize("hasAuthority('ADMINSTRATOR')")
	@GetMapping("/list")
	@ResponseBody
	public List<User> getAllUser() {
		return userService.retrieveAllUsers();
	}
	@PreAuthorize("hasAuthority('ADMINSTRATOR')")
	@DeleteMapping("/delete/{userId}")
	@ResponseBody
	public Boolean deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return true;
	}
	@PutMapping("/UpdateUser")
	@ResponseBody
	public User updateUser(@RequestBody User user) throws Exception {
		User userinthedatabase = userService.getUserById(user.getId());
		if (!encoder.encode(user.getPassword()).equals(userinthedatabase.getPassword())) {
			user.setPassword(encoder.encode(user.getPassword()));
		}
		return userService.updateUser(user);
	}
	@GetMapping("/{idUser}")
	public User getUserById(@PathVariable("idUser") long id) throws Exception {
		return userService.getUserById(id);
	}

	@GetMapping("/retrieve-user-by-sexe/{user-sexe}")
	@ResponseBody
	public List<User> retrieveUserBySexe(@PathVariable("user-sexe") com.masswl.pi.entities.SexeType sexeUser) {
		return userService.retrieveUserBySexe(sexeUser);
	}
	
	
		@GetMapping("/retrieve-user-by-adress/{user-adress}")
		@ResponseBody
		public List<User> retrieveUserByAdress(@PathVariable("user-adress") String adressUser) {
		return userService.retrieveUserByAdress(adressUser);
		}
		

		
		
}
