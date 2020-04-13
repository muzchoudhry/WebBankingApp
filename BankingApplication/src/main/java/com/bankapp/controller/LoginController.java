package com.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.forms.LoginForm;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if("admin".equals(username) && "admin".equals(password)) {
			return "customer";
		}
		model.addAttribute("invalidCredentials", true);
		return "login";
		
	}
}
