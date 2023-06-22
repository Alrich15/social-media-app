package com.socialmedia.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialmedia.entity.PostDetails;

public interface IPostRepo extends JpaRepository<PostDetails, Integer>{

	//update likes of post
	@Transactional
	@Modifying
	@Query(value="UPDATE post_details SET likes =:like where post_id =:postId", nativeQuery=true)
	void updateLikes(@Param("postId") Integer postId,@Param("like") Integer likes);

}
