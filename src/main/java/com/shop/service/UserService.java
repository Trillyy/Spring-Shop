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
import com.shop.model.Product;
import com.shop.model.ProductQuantity;
import com.shop.model.User;

@Service
public class UserService {
	
	@Autowired
	private DAOCart daoCart;
	@Autowired
	private DAOUser daoUser;
	@Autowired
	private DAOProd daoProd;
	@Autowired
	private DAOProdQuan daoProdQuan;
	
	@Transactional
	public boolean userExists(Long id) {
		return daoUser.findById(id).isEmpty();
	}
	
	@Transactional
	public User getUserById(Long id) {
		if (daoUser.findById(id).isEmpty())
			return null;
		return daoUser.findById(id).get();
	}
	
	@Transactional
	public void save(User u) {
		daoUser.save(u);
	}
}
