package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.entity.PostDetails;
import com.socialmedia.service.IPostService;


@CrossOrigin
@RestController
@RequestMapping("/social-media")
public class PostController {

	@Autowired
	private IPostService postServ;
	
	@PostMapping("/post/upload")
	public ResponseEntity<PostDetails> uploadPost(@RequestBody PostDetails postDetails) {
	return new ResponseEntity<>(postServ.uploadPost(postDetails), HttpStatus.CREATED);
	}
	
	@GetMapping("/post/view")
	public ResponseEntity<List<PostDetails>> viewAllPosts(){
		return new ResponseEntity<>(postServ.viewAllPosts(), HttpStatus.OK);
	}
	
	@GetMapping("/post/view/{id}")
	public ResponseEntity<PostDetails> viewPostById(@PathVariable("id")Integer postId){
		return new ResponseEntity<>(postServ.viewPostById(postId),HttpStatus.OK);
		
	}
	
	@PatchMapping("post/likes/{id}/{likes}")
	public ResponseEntity<Void> updateLikes(@PathVariable("id")Integer postId,@PathVariable("likes") Integer likes) {
		 postServ.updateLikes(postId, likes);
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("post/delete/{id}")
	public ResponseEntity<Void> deletePostById(@PathVariable("id")Integer postId) {
		 postServ.deletePostById(postId);
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
}
