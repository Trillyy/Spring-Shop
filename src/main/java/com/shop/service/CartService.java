package com.shop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.DAOCart;
import com.shop.dao.DAOProd;
import com.shop.dao.DAOProdQuan;
import com.shop.dao.DAOUser;
import com.shop.model.Cart;
import com.shop.model.CartQuery;
import com.shop.model.Product;
import com.shop.model.ProductQuantity;
import com.shop.model.User;

@Service
public class CartService {
	
	@Autowired
	private DAOCart daoCart;
	@Autowired
	private DAOUser daoUser;
	@Autowired
	private DAOProd daoProd;
	@Autowired
	private DAOProdQuan daoProdQuan;
	
	@Transactional
	private void addToNewCart(Product p, int qty, User u) {
		Cart c = new Cart();
		ProductQuantity pq = new ProductQuantity(p, qty);
		c.addProduct(pq);
		c.setUser(u);
		pq.setCart(c);
		daoCart.save(c);
		daoProdQuan.save(pq);
	}
	
	@Transactional
	public List<CartQuery> getCartByUserId(Long id) {
		return daoCart.findCartByUser(id);
	}
	
	@Transactional
	public void emptyCart(Long id) {
		daoCart.deleteById(id);
		Cart c = new Cart();
		daoCart.save(c);
	}
	
	@Transactional
	public boolean userHasCart(User u) {
		return !(daoCart.findByUser(u) == null);
	}
	
	@Transactional
	public Cart getCartByUser(User u) {
		return daoCart.findByUser(u);
	}
	
	@Transactional
	public boolean cartExists(Long id) {
		return daoCart.findById(id).isPresent();
	}
	
	@Transactional
	public void addToCart(User u, Product p, int qty)  {
		Cart c;
		if(!userHasCart(u))
		{
			addToNewCart(p, qty, u);
		} else
		{
			c = getCartByUser(u);
			if(c.existInCart(p)) {
				c.addQuantity(p.getId(), qty);
			}
			else {
			ProductQuantity pq = new ProductQuantity(p, qty);
			pq.setCart(c);
			daoProdQuan.save(pq);
			c.addProduct(pq);
			c.setUser(u);
			daoCart.save(c);
			}
		}
	}
}
