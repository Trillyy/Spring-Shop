package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.shop.dao.DAOUser;
import com.shop.model.User;

@Controller
@RequestMapping
public class UserController {
	@Autowired
	private DAOUser daoUser;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		SessionController.destroySession(req);
		res.sendRedirect("login");
	}
	
	@PostMapping("/login")
	public void loginVerification(Model model, 
			@RequestParam(value="username") String username,
			@RequestParam(value="password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(daoUser.findUser(username, password) == 1) {
			Long id = daoUser.findUserId(username, password);
			SessionController.createSession(request, id);
			User u = daoUser.findById((Long) SessionController.getAttribute("id")).get();
			model.addAttribute("user", u);
			response.sendRedirect("/");
		}
		else
		{
			response.sendRedirect("/login?err");
		}
	}
}
