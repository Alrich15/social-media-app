package com.socialmedia.service;

import java.util.List;

import javax.validation.Valid;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.dto.UserPostDetails;
import com.socialmedia.entity.Users;
import com.socialmedia.vo.UsersIVO;
import com.socialmedia.vo.UsersVO;

public interface IUserService {

	Users registerUser(Users user);

	List<Users> getUsers();

	void deleteUser(Integer userId);

	Users updateUser(Users user);

	List<UserDTO> getFollowersById(Integer userId);

	UsersVO login(@Valid UsersIVO user);

	List<UserPostDetails> getAllPostsByUId(Integer userId);

}
