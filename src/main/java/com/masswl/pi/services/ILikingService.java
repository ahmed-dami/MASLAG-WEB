package com.masswl.pi.services;

import java.util.List;

import com.masswl.pi.entities.Liking;



public interface ILikingService {

	
	public Boolean addLiking(Liking like, long idUser, long idPost);
	public void deleteLiking(long id);
	
	public List<Liking>getLikingsByPostId(long id);
	public List<Liking>getLikingsByUserId(long id);
	
	public boolean isLikeExists(long idUser, long idPost);
	
	public int countLikingByPost(int id);
	
	
	

}
