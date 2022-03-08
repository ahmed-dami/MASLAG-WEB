package com.masswl.pi.entities;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Liking  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReact;
	
	@JsonIgnore

	@ManyToOne
	User users;
	
	@JsonIgnore

	@ManyToOne
	Post posts;
	
	
	@JsonIgnore
	@ManyToOne
	Comment comments;
	
	private LocalDateTime reactDate;

	public Long getIdReact() {
		return idReact;
	}

	public void setIdReact(Long idReact) {
		this.idReact = idReact;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Post getPosts() {
		return posts;
	}

	public void setPosts(Post posts) {
		this.posts = posts;
	}

	public Comment getComments() {
		return comments;
	}

	public void setComments(Comment comments) {
		this.comments = comments;
	}

	public LocalDateTime getReactDate() {
		return reactDate;
	}

	public void setReactDate(LocalDateTime reactDate) {
		this.reactDate = reactDate;
	}

	public Liking(Long idReact, User users, Post posts, Comment comments, LocalDateTime reactDate) {
		super();
		this.idReact = idReact;
		this.users = users;
		this.posts = posts;
		this.comments = comments;
		this.reactDate = reactDate;
	}

	public Liking() {
		super();
	}
	


}
