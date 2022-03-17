package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private String username;
	private String email;
	private String password;
	
	@OneToOne(mappedBy = "user")
	private Cart cart;

	
	public User(String name, String surname, String username, String email, String password) {
			this.name = name;
			this.surname = surname;
			this.username = username;
			this.email = email;
			this.password = password;
	}
		
	public User() {}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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

	public String getSurname() {
			return surname;
	}

	public void setSurname(String surname) {
			this.surname = surname;
	}

	public String getUsername() {
			return username;
	}

	public void setUsername(String username) {
			this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
			return password;
	}

	public void setPassword(String password) {
			this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username + ", password="
				+ password + "]";
	}
}
