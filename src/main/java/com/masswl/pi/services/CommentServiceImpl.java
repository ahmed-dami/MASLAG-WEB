package com.masswl.pi.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masswl.pi.entities.Comment;
import com.masswl.pi.entities.Post;
import com.masswl.pi.entities.User;
import com.masswl.pi.repository.CommentRepository;
import com.masswl.pi.repository.PostRepository;
import com.masswl.pi.repository.UserRepository;


@Service
public class CommentServiceImpl implements ICommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public void ajouterEtaffecterListeComment(Comment comment, Long idPost, Long idUser) {
		
			 Post post = postRepository.findById(idPost).orElse(null);
	         User user = userRepository.findById(idUser).orElse(null);
	         comment.setPosts(post);
	         comment.setUsers(user);
	         commentRepository.save(comment);	
			
		}
	@Override
	public List<Comment> retrieveAllComments() {
		return (List<Comment>) commentRepository.findAll();
		
	}
	@Override
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
		
	}
	
	
		
	}

	


