package com.masswl.pi.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masswl.pi.entities.News;
import com.masswl.pi.repository.NewsRepository;
import com.masswl.pi.repository.UserRepository;

@RestController
@RequestMapping({ "/news" })
@CrossOrigin(origins = "*")
public class NewsController {

	private final UserRepository userRepository;
	private final NewsRepository newsRepository;

	@Autowired
	public NewsController(UserRepository userRepository, NewsRepository newsRepository) {
		this.userRepository = userRepository;
		this.newsRepository = newsRepository;
	}

	@GetMapping("/list")
	public List<News> getAllNews() {
		return (List<News>) newsRepository.findAll();
	}

	@PostMapping("/add/{userId}")
	News createNews(@PathVariable(value = "userId") Long userId, @Valid @RequestBody News news) {
		return userRepository.findById(userId).map(user -> {
			news.setUser(user);
			return newsRepository.save(news);
		}).orElseThrow(() -> new IllegalArgumentException("userId" + userId + " not found"));
	}

	@PutMapping("/update/{userId}/{newsId}")
	public News updateNews(@PathVariable(value = "userId") Long userId, @PathVariable(value = "newsId") Long newsId,
			@Valid @RequestBody News newsRequest) {
		if (!userRepository.existsById(userId)) {
			throw new IllegalArgumentException("userId " + userId + " not found");
		}
		return newsRepository.findById(newsId).map(news -> {
			news.setDescriptionNews(newsRequest.getDescriptionNews());
			news.setPicture(newsRequest.getPicture());
			return newsRepository.save(news);
		}).orElseThrow(() -> new IllegalArgumentException("newsId " + newsId + "not found"));
	}

	@DeleteMapping("/delete/{newsId}")
	public ResponseEntity<?> deleteNews(@PathVariable(value = "newsId") Long newsId) {
		return newsRepository.findById(newsId).map(news -> {
			newsRepository.delete(news);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException(" News not found with id " + newsId));
	}

}
