package com.masswl.pi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masswl.pi.entities.Comment;
import com.masswl.pi.repository.CommentRepository;
import com.masswl.pi.repository.PostRepository;
import com.masswl.pi.services.ICommentService;




@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired 
	ICommentService commentService;
	@Autowired 
	CommentRepository commentRepository;
	
	//http://localhost:8082/SpringMVC/servlet/comment/add-Comment/1/2
	@PostMapping("/add-Comment/{idUser}/{idPost}")
	public void ajouterEtaffecterListeComment(@RequestBody Comment comment,@PathVariable ("idUser") Long idUser,@PathVariable ("idPost") Long idPost){
		commentService.ajouterEtaffecterListeComment(comment,idUser,idPost) ;
 	
 			
 		}
	//http://localhost:8082/SpringMVC/servlet/comment/retrieve-all-comments
	@GetMapping("/retrieve-all-comments")
	@ResponseBody
	public List<Comment> getComments(){
		return commentService.retrieveAllComments();
	}
	//http://localhost:8082/SpringMVC/servlet/comment/delete-comment/2
	@DeleteMapping("/delete-comment/{id-comment}")
	@ResponseBody
	public void deleteComment(@PathVariable("id-comment") Long idComment){
		commentService.deleteComment(idComment);
	}
	
	@PutMapping("/update-comment/{idComment}")
	@ResponseBody
	public  ResponseEntity<Comment> updateComment(@PathVariable Long idComment ,@RequestBody Comment commentDetails) {
		Comment updateComment= commentRepository.findById(idComment).orElse(null);
		updateComment.setComContent(commentDetails.getComContent());
		
		commentRepository.save(updateComment);
		return ResponseEntity.ok(updateComment);
			
	

}
}
