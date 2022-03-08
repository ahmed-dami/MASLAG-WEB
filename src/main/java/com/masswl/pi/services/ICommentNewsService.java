package com.masswl.pi.services;

import java.util.List;

import com.masswl.pi.entities.CommentNews;


public interface ICommentNewsService {
	
	
	CommentNews addCommentNews (CommentNews commentNews) ;
	CommentNews updateCommentNews(CommentNews commentNews) ;
	boolean deleteCommentNews(long idCommN);
	List<CommentNews> retrieveAllCommentNews();
	CommentNews retrieveCommentNewsById(long idCommN);

}
