package com.masswl.pi.services;

import java.util.List;
import java.util.Map;

import com.masswl.pi.entities.Post;



public interface IPostService {
	
	public void ajouterEtaffecterListePosts(Post post, Long idUser);
	
	List<Post> retrieveAllPosts();
	void deletePost(Long id);
	
	Post getPostById(long id);
	Post addPost(Post p);
	
	
	public List<Post>searchPosts(String pattern);
	
	
	
	public int countPostUser(long idUser);
	
	
	public Map<Long,Integer>getPostsbyViewes();

}
