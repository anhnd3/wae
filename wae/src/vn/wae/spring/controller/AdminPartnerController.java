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
import vn.wae.spring.entity.Partner;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminPartnerController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools/partner")
	public String partner(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<Partner> partners = adminService.getPartners(0, 1000);
		model.addAttribute("partners", partners);
		return "admin/partner_listing";
	}

	@RequestMapping("/waetools/partner-form")
	public String partnerForm(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		
		Partner partner;
		if (!model.containsAttribute("partner")) {
			partner = new Partner();
		} else {
			partner = (Partner) model.asMap().get("partner");
		}
		model.addAttribute("partner", partner);
		return "admin/partner_form";
	}

	@PostMapping("/waetools/partner-form-execute")
	public String partnerFormExecute(@Valid @ModelAttribute("partner") Partner partner, BindingResult result,
			HttpServletResponse response, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.partner", result);
			redirectAttrs.addFlashAttribute("partner", partner);
			return "redirect:/waetools/partner-form";
		}
		adminService.savePartner(partner);
		return "redirect:/waetools/partner";
	}

	@RequestMapping("/waetools/partner-detail")
	public String partnerDetail(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		
		String partnerId = request.getParameter("id");
		if (StringUtils.isNullOrEmpty(partnerId) || !partnerId.matches("\\d+")) {
			return "redirect:/waetools/partner";
		}
		
		Partner partner = adminService.getPartner(Integer.parseInt(partnerId));
		if (partner == null || partner.getId() != Integer.parseInt(partnerId)) {
			return "redirect:/waetools/partner";
		}
		redirectAttrs.addFlashAttribute("partner", partner);
		return "redirect:/waetools/partner-form";
	}

	@RequestMapping("/waetools/partner-delete")
	public String partnerDelete(HttpServletRequest request) {
		
		String messageId = request.getParameter("id");
		if (!StringUtils.isNullOrEmpty(messageId) && messageId.matches("\\d+")) {
			adminService.deleteMessage(Integer.parseInt(messageId));
		}
		return "redirect:/waetools/partner";
	}
}
