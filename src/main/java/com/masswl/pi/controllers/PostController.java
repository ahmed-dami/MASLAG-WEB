package com.masswl.pi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masswl.pi.entities.Post;
import com.masswl.pi.repository.PostRepository;
import com.masswl.pi.services.IPostService;





@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired 
	IPostService postService;
	
	@Autowired
	PostRepository postRepository;
	
	//http://localhost:8082/SpringMVC/servlet/post/add-posts/1
	@PostMapping("/add-posts/{id-user}")
	public void ajouterEtaffecterListePosts(@RequestBody Post post,@PathVariable(value = "id-user") Long idUser ) 
	{
		postService.ajouterEtaffecterListePosts(post, idUser);

	}
	//http://localhost:8082/SpringMVC/servlet/post/retrieve-all-posts
	@GetMapping("/retrieve-all-posts")
	@ResponseBody
	public List<Post> getPosts(){
		return postService.retrieveAllPosts();
	}
	//http://localhost:8082/SpringMVC/servlet/post/delete-post/3
	@DeleteMapping("/delete-post/{id-post}")
	@ResponseBody
	public void deletePost(@PathVariable("id-post") Long id){
		postService.deletePost(id);
	}
	
	@PostMapping("/add-post")
	@ResponseBody
	public Post addPost(@RequestBody Post p){
		return postService.addPost(p);
	}
	
	//http://localhost:8082/SpringMVC/servlet/post/update-post/2
	
	@PutMapping("/update-post/{idPost}")
	@ResponseBody
	public  ResponseEntity<Post> updatePost(@PathVariable Long idPost ,@RequestBody Post postDetails) {
		Post updatePost= postRepository.findById(idPost).orElse(null);
		updatePost.setPostContent(postDetails.getPostContent());
		updatePost.setMediaType(postDetails.getMediaType());
	
		postRepository.save(updatePost);
		return ResponseEntity.ok(updatePost);
		
	}
	//http://localhost:8082/SpringMVC/servlet/post/search-post?pattern=evenement
	@GetMapping("/search-post")
	public List<Post>postSearch(@RequestParam("pattern")String pattern){
		
		System.out.println("my pattern : "+pattern);
		
		return postService.searchPosts(pattern);
	}
	
	//http://localhost:8082/SpringMVC/servlet/post/count-user-post/2
	@GetMapping("/count-user-post/{id}")
	public int countPostUser(@PathVariable("id")long idUser){
		 
		
		return postService.countPostUser(idUser);
	}
	
	//http://localhost:8082/SpringMVC/servlet/post/search-post?pattern=evenement
	@GetMapping("/get-post/{id}")
	public Post getPostById(@PathVariable("id")long idPost){
		
		
		return postService.getPostById(idPost);
	}
	
	@GetMapping("/Top2-posts")
	public String top2PostsByViews() {
		String res = "";
		for(Map.Entry map :postService.getPostsbyViewes().entrySet()) {
			res = res +"post numbero :"+map.getKey()+  " ----------  views :"+map.getValue()+"\n";

		}
		return res;
	} 
}
