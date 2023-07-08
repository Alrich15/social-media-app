package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Users;
import com.socialmedia.vo.UsersVO;

@Repository
public interface IUserRepo extends JpaRepository<Users, Integer>{

	@Query(value="UPDATE users SET bio=:userBio WHERE user_id=:userId", nativeQuery=true)
	void updateUser(@Param("userId")Integer userId, @Param("userBio") String bio);

	@Query(value = "select u from Users u where u.userName =:userName and u.password=:password")
	Users findUserByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);

//	@Query("SELECT r FROM relation r"
//			+ " WHERE r.user_id=:id ")
//	List<Users> getFollowersById(@Param("id")Integer userId);

}
