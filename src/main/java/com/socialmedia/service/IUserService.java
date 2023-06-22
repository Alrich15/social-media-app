package com.socialmedia.service;

import java.util.List;

import com.socialmedia.entity.Users;

public interface IUserService {

	Users registerUser(Users user);

	List<Users> getUsers();

	void deleteUser(Integer userId);

	void updateUser(Integer userId, String bio);

}
