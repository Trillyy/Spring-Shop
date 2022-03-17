package com.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Cart;
import com.shop.model.CartQuery;
import com.shop.model.User;

@Transactional
public interface DAOCart extends CrudRepository<Cart, Long> {
  public List<Cart> findAll();
  public Cart findByUser(User u);
  public List<Cart> findAllById(Long id);
  public void deleteAllById(Long id);
  
  @Query(
		  "select new com.shop.model.CartQuery(p.id,pq.quantity, p.category, p.discount, p.image, p.name, p.price, c.id as cartid, pq.id as pqid) "
		  + "from com.shop.model.Cart c INNER JOIN ProductQuantity pq "
			  		+ "on c.id = cart_id INNER JOIN com.shop.model.Product p on p.id = pq.p WHERE user_id = ?1"
			  		)
  			ArrayList<CartQuery> findCartByUser(Long id);
}