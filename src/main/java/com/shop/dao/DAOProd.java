package com.shop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Product;

@Transactional
public interface DAOProd extends CrudRepository<Product, Long> {
  public List<Product> findAll();
  public List<Product> findAllById(Long id);
}