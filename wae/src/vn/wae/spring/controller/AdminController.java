package vn.wae.spring.controller;

import javax.servlet.http.Cookie;
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
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools")
	public String bootstrap(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookie) {
		if (StringUtils.isNullOrEmpty(cookie) || cookie.equals("false")) {
			return "redirect:/waetools/login";
		}
		return "redirect:/waetools/dashboard";
	}

	@RequestMapping("/waetools/login")
	public String login(Model model) {
		// first access
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
			model.addAttribute("checkAdmin", false);
		}

		// get attribute redirect after execute-login
		// result error
		Object objResult = model.asMap().get("org.springframework.validation.BindingResult.user");
		if (objResult != null) {
			BindingResult result = (BindingResult) objResult;
			model.addAttribute("errCount", result.getErrorCount());
		}
		// result check admin
		Object objIsAdmin = model.asMap().get("isAdmin");
		if (objIsAdmin != null) {
			boolean isAdmin = (boolean) objIsAdmin;
			if (!isAdmin) {
				model.addAttribute("checkAdmin", true);
			}
		}

		return "admin/login";
	}

	@PostMapping("/waetools/execute-login")
	public String executeLogin(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletResponse response, RedirectAttributes redirectAttrs) {

		// check form login error
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
			redirectAttrs.addFlashAttribute("user", user);
			return "redirect:/waetools/login";
		}

		// check user login is admin
		boolean isAdmin = adminService.isAdmin(user.getEmail(), user.getPassword());
		if (!isAdmin) {
			redirectAttrs.addFlashAttribute("isAdmin", isAdmin);
			return "redirect:/waetools/login";
		}

		Cookie cookieAdmin = new Cookie("wae.user.admin", String.valueOf(isAdmin));
		cookieAdmin.setMaxAge(3600);
		response.addCookie(cookieAdmin);

		Cookie cookieAdminType = new Cookie("wae.user.admin.type",
				String.valueOf(adminService.getUser(user.getEmail()).getPrivilege()));
		response.addCookie(cookieAdminType);
		return "redirect:/waetools/dashboard";
	}

	@RequestMapping("/waetools/logout")
	public String logout(Model model, HttpServletResponse response, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie tmpCookie : cookies) {
			if (tmpCookie.getName().equals("wae")) {
				tmpCookie.setMaxAge(-1);
			}
		}
		return "redirect:/waetools/login";
	}

	@RequestMapping("/waetools/dashboard")
	public String dashboard(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		// if
		// (cookieAdminType.equals(String.valueOf(UserPrivilege.MASTER.getValue())))
		// {
		model.addAttribute("modifyAdmin", "true");
		// }
		return "admin/dashboard";
	}
}
