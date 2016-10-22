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

import vn.wae.spring.entity.User;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools")
	public String bootstrap(Model model) {

		return "redirect:/waetools/login";
	}

	@RequestMapping("/waetools/login")
	public String login(Model model) {

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
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
			redirectAttrs.addFlashAttribute("user", user);
			return "redirect:/waetools/login";
		}

		boolean isAdmin = adminService.isAdmin(user.getEmail(), user.getPassword());

		if (!isAdmin) {
			redirectAttrs.addFlashAttribute("isAdmin", isAdmin);
			return "redirect:/waetools/login";
		}

		Cookie cookie = new Cookie("wae", String.valueOf(isAdmin));
		cookie.setMaxAge(3600);
		response.addCookie(cookie);

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
			@CookieValue(name = "wae", required = true, defaultValue = "false") String cookie) {
		if (StringUtils.isNullOrEmpty(cookie) || cookie.equals("false")) {
			return "redirect:/waetools/login?loginResult=false";
		}
		return "admin/dashboard";
	}

}
