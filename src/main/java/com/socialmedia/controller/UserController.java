package com.socialmedia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.dto.UserPostDetails;
import com.socialmedia.entity.Users;
import com.socialmedia.service.IUserService;
import com.socialmedia.vo.UsersIVO;
import com.socialmedia.vo.UsersVO;

@CrossOrigin
@RestController
@RequestMapping("social-media/user")
public class UserController {

	@Autowired
	private IUserService userServ;
	
	@PostMapping("/register")
	public ResponseEntity<Users> registerUser(@RequestBody Users user) {
		return new ResponseEntity<>(userServ.registerUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Users>> getUsers(){
		return new ResponseEntity<>(userServ.getUsers(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer userId) {
		userServ.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED); 
	}
	
//	@PutMapping("update/{id}/{bio}")
//	public ResponseEntity<Void> updateUserBio(@PathVariable("id") Integer userId, @PathVariable("bio") String bio) {
//		 userServ.updateUser(userId,bio);
//		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
//	}
	
	@PatchMapping("update/{id}")
	public ResponseEntity<Users> updateUser(@RequestBody Users user){
		return new ResponseEntity<>(userServ.updateUser(user), HttpStatus.ACCEPTED);
	}
	@GetMapping("/all/followers/{id}")
	public ResponseEntity<List<UserDTO>> getFollowersById(@PathVariable("id") Integer userId){
		return new ResponseEntity<>(userServ.getFollowersById(userId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<List<UserPostDetails>> getAllPostsByUId(@PathVariable("id") Integer userId){
		System.out.println("Entering");
		return new ResponseEntity<>(userServ.getAllPostsByUId(userId), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<UsersVO> login(@RequestBody @Valid UsersIVO user){
		UsersVO userLogin = userServ.login(user);
		System.out.println("entering");
		if(userLogin != null) {
			return new ResponseEntity<UsersVO>(userLogin, HttpStatus.OK);
		}
		else {
			return new ResponseEntity("User not register. Sign Up first!!", HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
