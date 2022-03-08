package com.masswl.pi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNe;

	@Column(name = "descriptionNews")
	private String descriptionNews;

	@Column(name = "title")
	private String title;

	@Column(name = "picture")
	private String picture;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Company_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public long getIdNe() {
		return idNe;
	}

	public void setIdNe(long idNe) {
		this.idNe = idNe;
	}

	public String getDescriptionNews() {
		return descriptionNews;
	}

	public void setDescriptionNews(String descriptionNews) {
		this.descriptionNews = descriptionNews;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public News() {
		super();
	}

	public News(long idNe, String descriptionNews, String title, String picture, User user) {
		super();
		this.idNe = idNe;
		this.descriptionNews = descriptionNews;
		this.title = title;
		this.picture = picture;
		this.user = user;
	}

	@Override
	public String toString() {
		return "News [idNe=" + idNe + ", descriptionNews=" + descriptionNews + ", title=" + title + ", picture="
				+ picture + ", user=" + user + "]";
	}

}
