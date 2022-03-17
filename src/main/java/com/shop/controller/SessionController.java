package com.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SessionController {
		@Autowired
		private static HttpSession session;
		
		public static boolean verifySession(HttpServletRequest request) {
			session = request.getSession();
			if(session.getAttribute("id") == null)
				return false;
			else
				return true;
		}
		
		public static void createSession(HttpServletRequest request, Long id) {
			session = request.getSession();
			session.setAttribute("id", id);
		}
		
		public static void destroySession(HttpServletRequest request) {
			session = request.getSession(false);
		    if (session != null) {
		        session.invalidate();
		    }
		}
		
		public static Object getAttribute(String attr) {
			return session.getAttribute(attr);
		}
		
		public static void addAttribute(String attr, Object value) {
			session.setAttribute(attr, value);
		}
		
		public static void removeAttribute(String attr) {
			session.removeAttribute(attr);
		}
		
		
}
