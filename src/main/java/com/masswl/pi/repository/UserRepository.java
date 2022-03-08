package com.masswl.pi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masswl.pi.entities.SexeType;
import com.masswl.pi.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	User findByid(long id);
	List<User> findBySexeUser(SexeType sexeUser);
	List<User> findByAdressUser(String adressUser);


	
	
}