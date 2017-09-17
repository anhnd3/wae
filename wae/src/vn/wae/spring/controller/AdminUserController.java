package vn.wae.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.StringUtils;

import vn.wae.spring.dao.UserPrivilege;
import vn.wae.spring.entity.User;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminUserController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools/user")
	public String user(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<User> users = adminService.getUsers(0, 1000);
		model.addAttribute("users", users);
		return "admin/user_listing";
	}

	@RequestMapping("/waetools/user-form")
	public String userForm(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		// set data Course to input
		User user;
		if (!model.containsAttribute("user")) {
			user = new User();
		} else {
			user = (User) model.asMap().get("user");
		}
		model.addAttribute("user", user);
		model.addAttribute("privileges", UserPrivilege.values());
		return "admin/user_form";
	}

	@RequestMapping("/waetools/user-form-privilege")
	public String userFormPrivilege(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		// set data Course to input
		User user;
		if (!model.containsAttribute("user")) {
			user = new User();
		} else {
			user = (User) model.asMap().get("user");
		}
		model.addAttribute("user", user);
		model.addAttribute("privileges", UserPrivilege.values());
		return "admin/user_form_privilege";
	}

	@PostMapping("/waetools/user-form-execute")
	public String userFormExecute(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletResponse response, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
			redirectAttrs.addFlashAttribute("user", user);
			return "redirect:/waetools/user-form";
		}
		adminService.saveUser(user);
		return "redirect:/waetools/user";
	}

	@RequestMapping("/waetools/user-detail")
	public String userDetail(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		String userId = request.getParameter("id");
		if (StringUtils.isNullOrEmpty(userId) || !userId.matches("\\d+")) {
			return "redirect:/waetools/user";
		}
		User user = adminService.getUser(Integer.parseInt(userId));
		if (user == null || user.getId() != Integer.parseInt(userId)) {
			return "redirect:/waetools/user";
		}
		redirectAttrs.addFlashAttribute("user", user);
		String privilege = request.getParameter("type");
		if (!StringUtils.isNullOrEmpty(privilege) && privilege.equals("privilege")) {
			return "redirect:/waetools/user-form-privilege";
		}
		return "redirect:/waetools/user-form";
	}

	@RequestMapping("/waetools/user-delete")
	public String userDelete(HttpServletRequest request) {
		String userId = request.getParameter("id");
		if (!StringUtils.isNullOrEmpty(userId) && userId.matches("\\d+")) {
			adminService.deleteUser(Integer.parseInt(userId));
		}
		return "redirect:/waetools/user";
	}
}
