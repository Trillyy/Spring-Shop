package com.shop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shop.exception.InvalidPriceException;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Double price;
	private String image;
	private String category;
	private Integer discount;
	@Column(length = 4096)
	private String description;
	@OneToMany(mappedBy="p")
    private List<ProductQuantity> pqs;
	
	public Product(String name, Double price, String image, String category, Integer discount, String description) {
		this.name = name;
		setPrice(price);
		this.image = image;
		this.category = category;
		this.discount = discount;
		this.description = description;
	}
	
	public Product() {}

	public List<ProductQuantity> getPqs() {
		return pqs;
	}

	public void setPqs(List<ProductQuantity> pqs) {
		this.pqs = pqs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		if(price < 0)
			throw new InvalidPriceException("Il prezzo deve essere > 0");
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
