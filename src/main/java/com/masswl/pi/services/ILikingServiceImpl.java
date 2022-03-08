package com.masswl.pi.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masswl.pi.entities.Liking;
import com.masswl.pi.entities.Post;
import com.masswl.pi.entities.User;
import com.masswl.pi.repository.LikingRepository;
import com.masswl.pi.repository.PostRepository;
import com.masswl.pi.repository.UserRepository;



@Service
public class ILikingServiceImpl implements ILikingService {
	
	@Autowired
	LikingRepository likingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;
	

	@Override
	public Boolean addLiking(Liking l, long idUser, long idPost) {
		
		
		if(isLikeExists(idUser, idPost) == true) {
			return false;
		}
		
		else {
			User user =  userRepository.findById(idUser).get();

			Post post =  postRepository.findById(idPost).get();
			
			l.setUsers(user);
			l.setPosts(post);
			LocalDateTime creationDate = LocalDateTime.now();
			l.setReactDate(creationDate);
			likingRepository.save(l);
			return true;
		}
	}

	@Override
	public void deleteLiking(long id) {
		// TODO Auto-generated method stub
		likingRepository.deleteById(id);
		
	}

	@Override
	public List<Liking> getLikingsByPostId(long id) {
		// TODO Auto-generated method stub
		return likingRepository.getLikesByPostId(id);
	}

	@Override
	public List<Liking> getLikingsByUserId(long id) {
		return likingRepository.getLikesByUserId(id);
	}

	@Override
	public boolean isLikeExists(long idUser, long idPost) {
		int count = likingRepository.isLikeExists(idPost, idUser);
		
		if(count == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int countLikingByPost(int id) {
		List<Liking> likes = likingRepository.getLikesByPostId(id);
		return likes.size();
	
	}
	
	

}
