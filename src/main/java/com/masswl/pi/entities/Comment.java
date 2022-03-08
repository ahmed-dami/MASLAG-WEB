package com.masswl.pi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Comment  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idComment;
	@Temporal(TemporalType.DATE)
	private Date comDate;
	private String comContent;				
	@ManyToOne
	User users;
	@ManyToOne
	Post posts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="comments")
	private List <Liking> likings;

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
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

	public List<Liking> getLikings() {
		return likings;
	}

	public void setLikings(List<Liking> likings) {
		this.likings = likings;
	}

	public Comment(Long idComment, Date comDate, String comContent, User users, Post posts, List<Liking> likings) {
		super();
		this.idComment = idComment;
		this.comDate = comDate;
		this.comContent = comContent;
		this.users = users;
		this.posts = posts;
		this.likings = likings;
	}

	public Comment() {
		super();
	}
	
	
	
	
	
	
	
}
