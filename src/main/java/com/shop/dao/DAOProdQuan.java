package com.shop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.ProductQuantity;

@Transactional
public interface DAOProdQuan extends CrudRepository<ProductQuantity, Long> {
  public List<ProductQuantity> findAll();
  public List<ProductQuantity> findAllById(Long id);
}