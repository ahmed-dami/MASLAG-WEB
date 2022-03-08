package com.masswl.pi.services;

import java.util.List;

import com.masswl.pi.entities.Comment;




public interface ICommentService {
	 public void ajouterEtaffecterListeComment(Comment comment, Long idPost,Long idUser);	 
	 List<Comment> retrieveAllComments();
	 void deleteComment(Long id);
	 

}
