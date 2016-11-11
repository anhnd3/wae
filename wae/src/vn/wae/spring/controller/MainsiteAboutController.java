package vn.wae.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.entity.Partner;
import vn.wae.spring.entity.Teammate;
import vn.wae.spring.service.MainsiteService;

@Controller
public class MainsiteAboutController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/about")
	public String about(Model model) {
		// Render Section Partner
		List<Partner> partners = mainsiteService.getPartners(0, 6);
		model.addAttribute("partners", partners);

		// Render Section Teammate
		List<Teammate> teams = mainsiteService.getTeamAvailable(0, 10);
		model.addAttribute("teams", teams);
		return "mainsite/about";
	}

}
