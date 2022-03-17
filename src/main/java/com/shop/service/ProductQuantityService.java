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
public class ProductQuantityService {
	
	@Autowired
	private DAOCart daoCart;
	@Autowired
	private DAOUser daoUser;
	@Autowired
	private DAOProd daoProd;
	@Autowired
	private DAOProdQuan daoProdQuan;
	
	@Transactional
	public List<ProductQuantity> getProductQuantitys() {
		return daoProdQuan.findAll();
	}
	
	@Transactional
	public ProductQuantity getProductQuantityById(Long id) {
		if (daoProdQuan.findById(id).isEmpty())
			return null;
		return daoProdQuan.findById(id).get();
	}
	
	@Transactional
	public void save(ProductQuantity pq) {
		daoProdQuan.save(pq);
	}
	
	@Transactional
	public void delete(ProductQuantity pq) {
		daoProdQuan.delete(pq);
	}
}
