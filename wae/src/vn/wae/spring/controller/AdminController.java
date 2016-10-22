package vn.wae.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.entity.User;
import vn.wae.spring.service.AdminService;

@Controller
@RequestMapping("/waetools")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "admin/login";
	}

	@PostMapping("/execute-login")
	public String executeLogin(@ModelAttribute("user") User user, Model model) {
		boolean isAdmin = adminService.isAdmin(user.getEmail(), user.getPassword());
		model.addAttribute("isAdmin", isAdmin);
		return "admin/execute_login";
	}
}
