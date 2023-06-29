package com.socialmedia.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.socialmedia.dto.UserDTO;

import lombok.Data;

@NamedNativeQuery(name = "Relation.getFollowersById",
query = "SELECT u.name as name, u.user_name as user_name, u.bio as bio FROM users u, relation r WHERE r.user_id = u.user_id AND r.user_id=:id",
resultSetMapping = "Mapping.UserDTO")
@SqlResultSetMapping(name = "Mapping.UserDTO",
   classes = @ConstructorResult(targetClass = UserDTO.class,
                                columns = {@ColumnResult(name = "name"),
                                           @ColumnResult(name = "user_name"),
                                           @ColumnResult(name = "bio")}))
@Entity
@Data
public class Relation {

	@Id
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="following_id")
	private Integer followingId;
}
