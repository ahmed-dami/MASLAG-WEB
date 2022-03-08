package com.masswl.pi.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masswl.pi.entities.Comment;



@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

}
