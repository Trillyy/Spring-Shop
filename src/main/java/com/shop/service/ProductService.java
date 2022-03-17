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
public class ProductService {
	
	@Autowired
	private DAOCart daoCart;
	@Autowired
	private DAOUser daoUser;
	@Autowired
	private DAOProd daoProd;
	@Autowired
	private DAOProdQuan daoProdQuan;
	
	@Transactional
	public List<Product> getProducts() {
		return daoProd.findAll();
	}
	
	@Transactional
	public boolean productExists(Long id) {
		return daoProd.findById(id).isPresent();
	}
	
	@Transactional
	public Product getProductById(Long id) {
		if (daoProd.findById(id).isEmpty())
			return null;
		return daoProd.findById(id).get();
	}
	
	@Transactional
	public void save(Product p) {
		daoProd.save(p);
	}
}
