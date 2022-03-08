package com.masswl.pi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.masswl.pi.entities.Liking;
import com.masswl.pi.repository.PostRepository;
import com.masswl.pi.services.ILikingService;



@RestController
@RequestMapping("/liking")
public class LikiningController {
	@Autowired 
	ILikingService likingService;
	
	@Autowired
	PostRepository postRepository;
	
	//http://localhost:8082/SpringMVC/servlet/post/add-posts/1
	@PostMapping("/add-like/{id-user}/{id-post}")
	public ResponseEntity<String> ajouterEtaffecterListePosts(@RequestBody Liking like,@PathVariable(value = "id-user") Long idUser,
			@PathVariable(value="id-post")Long idPost) 
	{
		if(likingService.addLiking(like, idUser,idPost)) {
			return new ResponseEntity<String>("Nice your like is added :)",HttpStatus.OK);

		}
		else {
			return new ResponseEntity<String>("Sorry you already like this post  :)",HttpStatus.OK);

		}

	}

	//http://localhost:8082/SpringMVC/servlet/post/delete-post/3
	@DeleteMapping("/delete-like/{id-like}")
	@ResponseBody
	public ResponseEntity<String> deleteLike(@PathVariable("id-like") Long id){
		likingService.deleteLiking(id);
		return new ResponseEntity<String>("Like deleted with success   :)",HttpStatus.OK);
	}
	
	@GetMapping("like-post/{id-post}")
	public ResponseEntity<List<Liking>>getLikingsByPostId(@PathVariable(value = "id-post")Long idPost) {
		if(!likingService.getLikingsByPostId(idPost).isEmpty())
			
			return new ResponseEntity<List<Liking>>(likingService.getLikingsByPostId(idPost),HttpStatus.OK);
		else
			return null;
			
			

	}
	 
	@GetMapping("like-user/{id-user}")
	public ResponseEntity<List<Liking>>getLikesByUserId(@PathVariable(value = "id-user")Long idUser) {
		
	if(!likingService.getLikingsByPostId(idUser).isEmpty())
			
			return new ResponseEntity<List<Liking>>(likingService.getLikingsByUserId(idUser),HttpStatus.OK);
		else
			return null;
				}
		

}
