package com.masswl.pi.services;

import java.util.List;
import com.masswl.pi.entities.News;


public interface INewsService {

	News addNews (News news) ;
	News updateNews(News news) ;
	boolean deleteNews(long idNe);
	List<News> retrieveAllNews();
	News retrieveNewsById(long idNe);

}
