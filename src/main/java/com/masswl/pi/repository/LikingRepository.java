package com.masswl.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masswl.pi.entities.Liking;






@Repository
public interface LikingRepository extends CrudRepository<Liking,Long>{
	
	
	@Query("SELECT l FROM Liking l WHERE l.users.id =:id order by l.reactDate desc")
	public List<Liking>getLikesByUserId(@Param("id") long id);
	
	
	@Query("SELECT l FROM Liking l WHERE l.posts.id =:id order by l.reactDate desc")
	public List<Liking>getLikesByPostId(@Param("id") long id);
	
	
	@Query("SELECT COUNT(1) from Liking l WHERE l.users.id =:idUser and l.posts.id =:idPost")
	public int isLikeExists(@Param("idPost") long idPost ,@Param("idUser") long idUser);

}
