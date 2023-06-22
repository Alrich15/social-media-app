package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.entity.Users;
import com.socialmedia.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepo userRepo;

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
	public void updateUser(Integer userId, String bio) {
		userRepo.updateUser(userId, bio);		
	}

}
