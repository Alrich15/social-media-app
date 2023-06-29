package com.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.entity.Relation;

@Repository
public interface IRelationRepo extends JpaRepository<Relation, Integer> {

	@Query(nativeQuery = true)
	List<UserDTO> getFollowersById(@Param("id") Integer userId);
}
