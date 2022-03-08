package com.masswl.pi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masswl.pi.entities.Post;
import com.masswl.pi.entities.User;
import com.masswl.pi.repository.PostRepository;
import com.masswl.pi.repository.UserRepository;




@Service
public class PostServiceImpl implements IPostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Post> retrieveAllPosts() {
		return (List<Post>) postRepository.findAll();
		
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
		
	}


		
	

	@Override
	public void ajouterEtaffecterListePosts(Post post, Long idUser) {
		 User User = userRepository.findById(idUser).orElse(null);
         post.setUsers(User);
         //String test = "ya5i";
         List<String> badWords = new ArrayList<>();
         badWords.add("fuck");
         badWords.add("shit");
         badWords.add("nigga");
         badWords.add("boobs");
         badWords.add("ass");
         
         // 
         if(post.getPostContent() != null) {
        	 badWords.forEach(elem -> {
            	 StringBuilder replacementString = new StringBuilder() ;
            	 replacementString.append(elem.charAt(0));
            	 for(int i =0;i<elem.length()-2;i++) {
            		 replacementString.append("*");
            	 }
            	 replacementString.append(elem.charAt(elem.length()-1));
            	 System.out.println("replacement string: "+replacementString);
            	 post.setPostContent(post.getPostContent().replaceAll(elem, replacementString.toString()));
            	 
             });
         }
         
         System.out.println(post.getPostContent());
         
// 		String newTest = "";
// 		if(test.length() >=1) {
// 			StringBuilder res = new StringBuilder();
// 			res.append(test.charAt(0)); 
// 			
// 			for(int i =0 ; i<test.length() -2; ++i) {
// 				res.append('*');
// 			}
// 			
// 			res.append(test.charAt(test.length() - 1 ));
// 			newTest = res.toString();
// 			
// 		}
 		
 		
// 		System.out.println(test);
// 		if(post.getPostContent().contains(test)) {
// 			System.out.println("Il y a des mauvais mots ["+newTest+"]");
// 		}
// 		else 
// 		
// 		 postRepository.save(post);	
//		}
         
	}
	

//	//@Override
//	public Post addPost(Post p) {
//		
//		postRepository.save(p);
//
//	}

	@Override
	public List<Post> searchPosts(String pattern) {
		// TODO Auto-generated method stub
		return postRepository.findPostByDescription(pattern);
	}

	@Override
	public int countPostUser(long idUser) {
		
		return postRepository.countPostUser(idUser);
	}

	@Override
	public Post addPost(Post p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(long id) {
		// TODO Auto-generated method stub
		Post p = postRepository.findById(id).get();
		int countViews =0;
		
		if(p == null) return null;
		
		p.setViews(p.getViews()+1);
		//
		countViews = postRepository.updateViewCountPost(p.getViews() -1, id);
		countViews++;
		
		return p;
		
		
	}

	@Override
	public Map<Long, Integer> getPostsbyViewes() { 
		
		List<Long>listId = new ArrayList<>();
		List<Integer>listViews = new ArrayList<>();
		//init map 
		Map<Long,Integer>map = new HashMap<>();
		
		for(Post p : postRepository.findAll()) {
			listId.add(p.getIdPost());
			listViews.add(p.getViews());
		}
		List<Integer>sortedList = new ArrayList<>(listViews);
		
		Collections.sort(sortedList);
		for(int i = 0 ; i< 2; i++) {
			int max = sortedList.get(sortedList.size()-1);
			long postid= listId.get(listViews.indexOf(max));
			map.put(postid, max);
			
			System.out.println("post numbero :"+postid+  " ---------- views :"+max);
			sortedList.remove(sortedList.size() -1)  ;
			listViews.set(listViews.indexOf(max),-1);
		}
		
		return map;
		
	
	}
		
	}
	


