package com.socialmedia.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	private String name;
	private String userName;
	private String password;
	private String bio;
	private String followers;
	private String following;
	
//	@OneToOne(cascade = {CascadeType.ALL } )
//	@JoinColumn(name ="post_id")
//	private List<PostDetails> postDetails;
	
	
}
