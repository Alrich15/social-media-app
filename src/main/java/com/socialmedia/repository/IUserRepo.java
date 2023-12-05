package com.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialmedia.dto.UserPostDetails;
import com.socialmedia.entity.Users;

@Repository
public interface IUserRepo extends JpaRepository<Users, Integer>{
//	.getUserId(), user.getName(), user.getBio(), user.getEmail(), user.getUserName()
	@Query(value="UPDATE users SET bio=:userBio, name=:nameuser, email=:userEmail, user_name=:userName WHERE user_id=:userId", nativeQuery=true)
	Users updateUser(@Param("userId")Integer userId,@Param("nameuser") String name, @Param("userBio") String bio, @Param("userEmail") String email, @Param("userName") String uName);

	@Query(value = "select u from Users u where u.userName=:userName and u.password=:password")
	Users findUserByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);

//	@Query("SELECT r FROM relation r"
//			+ " WHERE r.user_id=:id ")
//	List<Users> getFollowersById(@Param("id")Integer userId);

	@Query(nativeQuery=true)
	List<UserPostDetails> getAllPostsbyUId(@Param("id") Integer userId);
	
}


//get all posts for user_id
//select * from post_details p, users u where u.user_id = p.u_id AND u.user_id=30

//get all follower posts of user_id
//select  r.user_id, r.following_id, u.user_name, p.caption, p.comments, p.creator_date, p.img_url, p.likes from relation r
//inner join users u ON u.user_id = r.user_id
//inner join post_details p ON p.u_id = u.user_id
//where u.user_id = 35