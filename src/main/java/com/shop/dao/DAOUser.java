package com.shop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.User;

@Transactional
public interface DAOUser extends CrudRepository<User, Long> {
  public List<User> findAll();
  public List<User> findAllById(Long id);
  
  public Optional<User> findByUsername(String username);
  
  @Query(
		  "select COUNT(*) "
		  + "from User u WHERE u.username = ?1 AND "
		  + "u.password = ?2"
			  		)
  			Integer findUser(String username, String password);

@Query(
		  "select id "
		  + "from User u WHERE u.username = ?1 AND "
		  + "u.password = ?2"
			  		)
			Long findUserId(String username, String password);
}