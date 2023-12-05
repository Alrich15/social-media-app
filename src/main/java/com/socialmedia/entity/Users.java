package com.socialmedia.entity;

import java.sql.Date;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.socialmedia.dto.UserPostDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "Users.getAllPostsbyUId",
query =   "select  r.user_id, r.following_id, u.user_name, p.caption, p.comments, p.creator_date, p.img_url, p.likes from relation r"
		+ " inner join users u ON u.user_id = r.user_id"
		+ " inner join post_details p ON p.u_id = u.user_id"
		+ " where u.user_id=:id",
resultSetMapping = "Mapping.UserPostDetails")
@SqlResultSetMapping(name = "Mapping.UserPostDetails",
//	 entities = @EntityResult(targetClass = UserPostDetails.class, 
//	 fields= {
//			 @FieldResult(name = "userId", column="user_id"),
//			 @FieldResult(name = "followingId", column="following_id"),
//			 @FieldResult(name = "userName", column="user_name"),
//			 @FieldResult(name = "comments", column="comments"),
//			 @FieldResult(name = "creatorDate", column="creator_date"),
//			 @FieldResult(name = "caption", column="caption"),
//			 @FieldResult(name = "imgUrl", column="img_url"),
//			 @FieldResult(name = "likes", column="likes"),
//	 })
   classes = @ConstructorResult(targetClass = UserPostDetails.class,
                                columns = {
                                		@ColumnResult(name = "user_id", type=Integer.class),
                                           @ColumnResult(name = "following_id", type=Integer.class),
                                           @ColumnResult(name = "user_name"),
                                           @ColumnResult(name = "comments"),
                                           @ColumnResult(name = "creator_date", type=Date.class),
                                           @ColumnResult(name = "caption"),
                                           @ColumnResult(name = "img_url"),
                                           @ColumnResult(name = "likes")})
)


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",message = "Please enter password in given condition.")
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
	@JoinColumn(name ="u_id", referencedColumnName="userId", nullable=false)
	private List<PostDetails> postDetails=new ArrayList<>();
	

	
	
}
