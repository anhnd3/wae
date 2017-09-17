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
import vn.wae.spring.entity.Teammate;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminTeamController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools/team")
	public String team(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<Teammate> teams = adminService.getTeams(0, 1000);
		model.addAttribute("teams", teams);
		return "admin/team_listing";
	}

	@RequestMapping("/waetools/team-form")
	public String teamForm(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		Teammate team;
		if (!model.containsAttribute("team")) {
			team = new Teammate();
		} else {
			team = (Teammate) model.asMap().get("team");
		}
		model.addAttribute("team", team);
		return "admin/team_form";
	}

	@PostMapping("/waetools/team-form-execute")
	public String teamFormExecute(@Valid @ModelAttribute("team") Teammate team, BindingResult result,
			HttpServletResponse response, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.team", result);
			redirectAttrs.addFlashAttribute("team", team);
			return "redirect:/waetools/team-form";
		}
		adminService.saveTeam(team);
		return "redirect:/waetools/team";
	}

	@RequestMapping("/waetools/team-detail")
	public String teamDetail(HttpServletRequest request, RedirectAttributes redirectAttrs) {

		String teamId = request.getParameter("id");
		if (StringUtils.isNullOrEmpty(teamId) || !teamId.matches("\\d+")) {
			return "redirect:/waetools/team";
		}
		Teammate team = adminService.getTeam(Integer.parseInt(teamId));
		if (team == null || team.getId() != Integer.parseInt(teamId)) {
			return "redirect:/waetools/team";
		}
		redirectAttrs.addFlashAttribute("team", team);
		return "redirect:/waetools/team-form";
	}

	@RequestMapping("/waetools/team-delete")
	public String teamDelete(HttpServletRequest request) {
		String teamId = request.getParameter("id");
		if (!StringUtils.isNullOrEmpty(teamId) && teamId.matches("\\d+")) {
			adminService.deleteTeam(Integer.parseInt(teamId));
		}
		return "redirect:/waetools/team";
	}
}
