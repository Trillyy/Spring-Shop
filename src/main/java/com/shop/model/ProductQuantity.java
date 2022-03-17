package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ProductQuantity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product p;
	
	private int quantity;
	
	@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;
	
	public ProductQuantity() {}
	
	public ProductQuantity(Product p, int quantity) {
		this.p = p;
		this.quantity = quantity;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity < 0)
			throw new IllegalArgumentException("La quantità deve essere positiva");
		if(quantity > 1000)
			throw new IllegalArgumentException("Quantità massima raggiunta");
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public Double getTotalPrice() {
		return p.getPrice() * quantity;
	}
}
