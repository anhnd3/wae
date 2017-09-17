package vn.wae.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.dao.LogAccessType;
import vn.wae.spring.entity.Message;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.service.MainsiteService;

@Controller
public class MainsiteContactController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/contact")
	public String about(Model model) {
		// Render Section Partner
		List<Partner> partners = mainsiteService.getPartners(0, 6);
		model.addAttribute("partners", partners);
		model.addAttribute("message", new Message());

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.CONTACT.getValue());
		return "mainsite/contact";
	}

	@PostMapping(value = "/contact/send-message")
	public String sendMessage(@Valid @ModelAttribute("message") Message message, BindingResult result) {
		if (!result.hasErrors()) {
			mainsiteService.saveMessage(message);
		}
		return "redirect:/contact";
	}

}
