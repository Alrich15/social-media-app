package com.socialmedia.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PostDetails {

	@Id
	private Integer postId;
	
	private String imgUrl;
	private String caption;
	private String comments;
	private int likes=0;
	private LocalDate creatorDate=LocalDate.now();
	
}
