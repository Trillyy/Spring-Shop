package com.shop.model;

public class CartQuery {
	private Long id;
	private int quantity;
	private String category;
	private int discount;
	private String image;
	private String name;
	private Double price;
	private Long cartid;
	private Long pqid;

	public CartQuery() {}
	
	public CartQuery(Long id, int quantity, String category, int discount, String image, String name, Double price, Long cartid, Long pqid) {
		this.id = id;
		this.quantity = quantity;
		this.category = category;
		this.discount = discount;
		this.image = image;
		this.name = name;
		this.price = price;
		this.cartid = cartid;
		this.pqid = pqid;
	}

	public Long getPqid() {
		return pqid;
	}

	public void setPqid(Long pqid) {
		this.pqid = pqid;
	}

	public Long getCartid() {
		return cartid;
	}

	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CartQuery [id=" + id + ", quantity=" + quantity + ", category=" + category + ", discount=" + discount
				+ ", image=" + image + ", name=" + name + ", price=" + price + ", cartid=" + cartid + ", pqid=" + pqid
				+ "]";
	}
	
	public Double getTotalPrice() {
		return price * quantity;
	}
}
