package com.socialmedia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.dto.UserPostDetails;
import com.socialmedia.entity.Users;
import com.socialmedia.repository.IRelationRepo;
import com.socialmedia.repository.IUserRepo;
import com.socialmedia.vo.UsersIVO;
import com.socialmedia.vo.UsersVO;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IRelationRepo relationRepo;

	@Override
	public Users registerUser(Users user) {
		return userRepo.save(user);
	}

	@Override
	public List<Users> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
	
	}

	@Override
	public Users updateUser(Users user) {
		
		return userRepo.updateUser(user.getUserId(), user.getName(), user.getBio(), user.getEmail(), user.getUserName());		
	}

	@Override
	public List<UserDTO> getFollowersById(Integer userId) {
		return relationRepo.getFollowersById(userId);
	}

	@Override
	public UsersVO login(@Valid UsersIVO user) {
		Users userValidate = userRepo.findUserByUsernameAndPassword(user.getUserName(),user.getPassword());
		
		UsersVO userLogin = new UsersVO();
		if(userValidate != null) {	
			userLogin.setEmail(userValidate.getEmail());
			userLogin.setUsername(userValidate.getUserName());
			userLogin.setPassword(userValidate.getPassword());
		}
		return userLogin;
	}

	@Override
	public List<UserPostDetails> getAllPostsByUId(Integer userId) {
		// TODO Auto-generated method stub
		return userRepo.getAllPostsbyUId(userId);
	}

}
