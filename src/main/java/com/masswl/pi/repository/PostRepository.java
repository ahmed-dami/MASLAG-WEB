package com.masswl.pi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.masswl.pi.entities.Post;



@Repository

public interface PostRepository extends CrudRepository<Post,Long> {

	
	
	@Query("SELECT p FROM Post p WHERE p.postContent LIKE %?1% OR p.users.nom LIKE %?1% order by p.postDate desc")
	public List<Post> findPostByDescription(String pattern);
	
	
	@Query("SELECT COUNT(p) FROM Post p WHERE p.users.id =:id")
	public int countPostUser(@Param("id")Long postid);
	
	
	@Modifying
	@Transactional   
	@Query("UPDATE Post p SET p.views = :views+1 WHERE p.id=:id")
	public int updateViewCountPost(@Param("views")int view , @Param("id")long id);
}
