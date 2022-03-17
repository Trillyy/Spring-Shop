package com.shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(mappedBy="cart")
	private List<ProductQuantity> cart;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	public Cart() {
		cart = new ArrayList<ProductQuantity>();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart(List<ProductQuantity> cart) {
		this.cart = cart;
	}
	
	public List<ProductQuantity> getCart() {
		return cart;
	}
	
	public void addProduct(ProductQuantity pq) {
		cart.add(pq);
	}
	
	public void setCart(List<ProductQuantity> cart) {
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean existInCart(Long id) {
		for(ProductQuantity pq: cart) {
			if(pq.getP().getId() == id)
				return true;
		}
		return false;
	}
	
	public boolean existInCart(Product p) {
		for(ProductQuantity pq: cart) {
			if(pq.getP().getId() == p.getId())
				return true;
		}
		return false;
	}
	
	public void addQuantity(Long id, int 	qty) {
		for(ProductQuantity pq: cart)
			if(pq.getP().getId() == id)
				pq.setQuantity(pq.getQuantity() + qty);
	}
	
	public Double getTotalPrice() {
		Double sum = 0.0;
		if(cart.isEmpty())
			return sum;
		for(ProductQuantity pq: cart)
			sum += pq.getTotalPrice();
		return sum;	
	}
}
