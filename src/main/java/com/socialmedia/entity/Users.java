package com.socialmedia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.socialmedia.dto.UserDTO;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "relation",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "following_id"))
    private List<Users> following;
	
	@JsonIgnore
	@ManyToMany(mappedBy="following")
	private List<Users> followers;
	
	//Multiple posts for single user
	@OneToMany(cascade = {CascadeType.ALL } )
	@JoinColumn(name ="u_id", referencedColumnName="userId")
	private List<PostDetails> postDetails=new ArrayList<>();
	

	
	
}
