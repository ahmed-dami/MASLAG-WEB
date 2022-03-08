package com.masswl.pi.repository;
import org.springframework.data.repository.CrudRepository;
import com.masswl.pi.entities.News;

public interface NewsRepository extends  CrudRepository<News, Long>{

}
