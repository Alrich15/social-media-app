package com.socialmedia.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDetails {


	private Integer userId;
	private Integer followingId;
	private String userName;
	private String comments;
	private Date creatorDate;
	private String caption;
	private String imgUrl;
	private int likes;
}
