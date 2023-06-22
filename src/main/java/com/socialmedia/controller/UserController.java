package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.entity.Users;
import com.socialmedia.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("social-media/user")
public class UserController {

	@Autowired
	private IUserService userServ;
	
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) {
		return userServ.registerUser(user);
	}
	
	@GetMapping("/view")
	public List<Users> getUsers(){
		return userServ.getUsers();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") Integer userId) {
		userServ.deleteUser(userId);
	}
	
	@PutMapping("update/{id}/{bio}")
	public void updateUserBio(@PathVariable("id") Integer userId, @PathVariable("bio") String bio) {
		 userServ.updateUser(userId,bio);
	}
	
}
