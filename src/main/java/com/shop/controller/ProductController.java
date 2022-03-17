package com.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.exception.ProductNotFoundException;
import com.shop.model.Product;
import com.shop.model.ProductQuantity;
import com.shop.model.User;
import com.shop.service.CartService;
import com.shop.service.ProductQuantityService;
import com.shop.service.ProductService;
import com.shop.service.UserService;
import com.shop.utils.EmailValidator;
import com.shop.utils.NameValidator;
import com.shop.utils.PasswordValidator;
import com.shop.utils.SurnameValidator;
import com.shop.utils.UsernameValidator;

@Controller
@RequestMapping
public class ProductController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductQuantityService productQuantityService;
	
	@GetMapping("/products")
	public String getProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productService.getProducts();
		request.setAttribute("products", products);
		return "products";
		}
	
	@GetMapping("/products/{id}")
	public String getProducts(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") Long id) throws ServletException, IOException {
		if(!productService.productExists(id))
		{
			throw new ProductNotFoundException("Prodotto non disponibile");
		}
		Product p = productService.getProductById(id);
		request.setAttribute("prod", p);
		return "item";
		}
	
	@GetMapping("/add")
	public void add(HttpServletResponse response) throws IOException {
		Product p = new Product("Laptop", -1200.0, "https://static1.unieuro.it/medias/sys_master/root/hcd/h97/32637757358110/-api-rest-00ed29448a7522f610cac04d7b9ea7e0-assets-47a08072d31218ab4f164e43fa83ce5d-preview-sgmConversionBaseFormat-sgmProductFormat.jpg", "Elettronica", 0, "ciao");
		productService.save(p);
		response.sendRedirect("/");
	}
	
	@GetMapping("/cart")
	public String cart(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!SessionController.verifySession(request))
		{
			response.sendRedirect("/login");
			return "login";
		}
		User u = userService.getUserById((Long) SessionController.getAttribute("id"));
		
		model.addAttribute("cart", cartService.getCartByUserId(u.getId()));
		model.addAttribute("sum", 
				cartService.getCartByUserId(u.getId()).stream().mapToDouble(o -> o.getTotalPrice()).sum());
		return "cart";
	}
	
	@GetMapping("/")
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!SessionController.verifySession(request))
		{
			response.sendRedirect("/login");
			return "login";
		}
		User u = userService.getUserById((Long) SessionController.getAttribute("id"));
		model.addAttribute("user", u);
		model.addAttribute("err", SessionController.getAttribute("err"));
		SessionController.removeAttribute("err");
		System.out.print(model.getAttribute("err"));
		return "home";
	}
	
	@GetMapping("/settings")
	public String settings(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!SessionController.verifySession(request))
		{
			response.sendRedirect("/login");
			return "login";
		}
		User u = userService.getUserById((Long) SessionController.getAttribute("id"));
		model.addAttribute("user", u);
		return "settings";
	}
	
	@PostMapping("/order")
	public void order(Model model, @RequestParam(value = "id", required = false) Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!SessionController.verifySession(request))
			response.sendRedirect("/login");
		if(cartService.cartExists(id))
		{
			cartService.emptyCart(id);
			User u = userService.getUserById((Long) SessionController.getAttribute("id"));
			model.addAttribute("cart", cartService.getCartByUserId(u.getId()));
			model.addAttribute("sum", 0.0);
		}
		response.sendRedirect("cart");
	}
	
	@PostMapping("/editqty")
	public void editqty(Model model, @RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "op", required = true) String op, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!SessionController.verifySession(request))
			response.sendRedirect("/login");
		User u = userService.getUserById((Long) SessionController.getAttribute("id"));
		if(id == null)
			response.sendRedirect("cart");

		ProductQuantity  pq = productQuantityService.getProductQuantityById(id);
		if(pq.getQuantity() == 1 && op.equals("-"))
			productQuantityService.delete(pq);
		else
			if(op.equals("-"))
				pq.setQuantity(pq.getQuantity() - 1);
			else
				if(op.equals("+"))
					pq.setQuantity(pq.getQuantity() + 1);
		model.addAttribute("cart", cartService.getCartByUserId(u.getId()));
		model.addAttribute("sum", 
				cartService.getCartByUserId(u.getId()).stream().mapToDouble(o -> o.getTotalPrice()).sum());
		response.sendRedirect("cart");
	}	
	
	@PostMapping("/editdetails")
	public void editdetails(Model model, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "surname", required = true) String surname,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "cpassword", required = true) String cpassword) throws IOException {
		if(!SessionController.verifySession(request))
			response.sendRedirect("/login");
		User u = userService.getUserById((Long) SessionController.getAttribute("id"));

		ArrayList<String> errors = new ArrayList<String>();
		if(EmailValidator.isValidMail(email))
			u.setEmail(email);
		else
			errors.add("Mail non valida");
		
		if(NameValidator.isValidName(name))
			u.setName(name);
		else
			errors.add("Nome non valido");
		
		if(SurnameValidator.isValidSurname(surname))
			u.setSurname(surname);
		else
			errors.add("Cognome non valido");
		
		if(UsernameValidator.isValidUsername(username))
			u.setUsername(username);
		else
			errors.add("Username non valido");
		
		if(PasswordValidator.isValidPassword(password) && PasswordValidator.matches(password, cpassword))
			u.setPassword(password);
		else
			errors.add("Password non valida");
		
		userService.save(u);
		SessionController.addAttribute("err", errors);
		System.out.println(model.getAttribute("err"));
		response.sendRedirect("/");
	}	
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
	
	@PostMapping("/buy")
    public String buyProduct(@RequestParam(value = "id", required = true) Long id, 
    		@RequestParam(value = "qty", required = true) int qty, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!SessionController.verifySession(request))
		{
			response.sendRedirect("/login");
			return "login";
		}
		if(!productService.productExists(id))
			throw new IllegalStateException("Prodotto inesistente!");
		User u = userService.getUserById((Long) SessionController.getAttribute("id"));
		Product p = productService.getProductById(id);
		cartService.addToCart(u, p, qty); 
		model.addAttribute("cart", cartService.getCartByUserId(u.getId()));
		model.addAttribute("sum", 
				cartService.getCartByUserId(u.getId()).stream().mapToDouble(o -> o.getTotalPrice()).sum());
		response.sendRedirect("/cart");
		return "cart";
    }
}
