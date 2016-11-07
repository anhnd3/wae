package vn.wae.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.StringUtils;

import vn.wae.spring.dao.UserPrivilege;
import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminMessageController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools/message")
	public String message(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<Message> messages = adminService.getMessage(0, 1000);
		model.addAttribute("messages", messages);
		return "admin/message_listing";
	}

	@RequestMapping("/waetools/message-form")
	public String messageForm(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}

		Message message;
		if (!model.containsAttribute("message")) {
			message = new Message();
		} else {
			message = (Message) model.asMap().get("message");
		}
		model.addAttribute("message", message);
		return "admin/message_form";
	}

	@RequestMapping("/waetools/message-detail")
	public String messageDetail(HttpServletRequest request, RedirectAttributes redirectAttrs) {

		String messageId = request.getParameter("id");
		if (StringUtils.isNullOrEmpty(messageId) || !messageId.matches("\\d+")) {
			return "redirect:/waetools/message";
		}

		Message message = adminService.getMessage(Integer.parseInt(messageId));
		if (message == null || message.getId() != Integer.parseInt(messageId)) {
			return "redirect:/waetools/message";
		}
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/waetools/message-form";
	}

	@RequestMapping("/waetools/message-delete")
	public String messageDelete(HttpServletRequest request) {

		String messageId = request.getParameter("id");
		if (!StringUtils.isNullOrEmpty(messageId) && messageId.matches("\\d+")) {
			adminService.deleteMessage(Integer.parseInt(messageId));
		}
		return "redirect:/waetools/message";
	}

	@RequestMapping("/waetools/email")
	public String email(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<EmailUser> emailUses = adminService.getEmailUses(0, 1000);
		model.addAttribute("emailUses", emailUses);
		return "admin/email_listing";
	}

	@RequestMapping("/waetools/email-delete")
	public String messageDelete(@RequestParam(value = "id", defaultValue = "null") String id) {

		if (!StringUtils.isNullOrEmpty(id) && id.matches("\\d+")) {
			adminService.deleteEmailUser(Integer.parseInt(id));
		}
		return "redirect:/waetools/email";
	}
}
