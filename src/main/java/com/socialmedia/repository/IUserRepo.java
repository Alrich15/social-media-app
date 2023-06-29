package com.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Users;

@Repository
public interface IUserRepo extends JpaRepository<Users, Integer>{

	@Query(value="UPDATE users SET bio=:userBio WHERE user_id=:userId", nativeQuery=true)
	void updateUser(@Param("userId")Integer userId, @Param("userBio") String bio);

//	@Query("SELECT r FROM relation r"
//			+ " WHERE r.user_id=:id ")
//	List<Users> getFollowersById(@Param("id")Integer userId);

}
