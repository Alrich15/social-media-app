package com.socialmedia.service;

import java.util.List;

import com.socialmedia.entity.PostDetails;

public interface IPostService {

	PostDetails uploadPost(PostDetails postDetails);

	List<PostDetails> viewAllPosts();

	void updateLikes(Integer postId, Integer likes);

	void deletePostById(Integer postId);

	
}
