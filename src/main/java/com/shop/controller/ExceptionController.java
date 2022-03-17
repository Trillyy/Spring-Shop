package com.shop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shop.exception.InvalidPriceException;
import com.shop.exception.ProductNotFoundException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({ ProductNotFoundException.class })
    public String handleException(Model m, HttpServletResponse res, ProductNotFoundException e) throws IOException {
        res.sendError(404);
        m.addAttribute("message", e.getMessage());
        return "error";
    }
	
	@ExceptionHandler({ InvalidPriceException.class })
    public String handleException(Model m, HttpServletResponse res, InvalidPriceException e) throws IOException {
        res.sendError(500);
        m.addAttribute("message", e.getMessage());
        return "error";
    }
}
