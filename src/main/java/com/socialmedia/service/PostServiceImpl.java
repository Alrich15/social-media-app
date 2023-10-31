package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.entity.PostDetails;
import com.socialmedia.repository.IPostRepo;

@Service
public class PostServiceImpl implements IPostService{

	@Autowired
	private IPostRepo postRepo;

	@Override
	public PostDetails uploadPost(PostDetails postDetails) {
		return postRepo.save(postDetails);
	}

	@Override
	public List<PostDetails> viewAllPosts() {
		return postRepo.findAll();
	}

	@Override
	public void updateLikes(Integer postId, Integer likes) {
		 postRepo.updateLikes(postId, likes);
	}

	@Override
	public void deletePostById(Integer postId) {
		 postRepo.deleteById(postId);
		
	}

	@Override
	public PostDetails viewPostById(Integer postId) {
		return postRepo.findById(postId).get();
	}
	
	
	
}

