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
import vn.wae.spring.entity.Project;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminProjectController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools/project")
	public String project(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<Project> projects = adminService.getProjects(0, 1000);
		model.addAttribute("projects", projects);
		return "admin/project_listing";
	}

	@RequestMapping("/waetools/project-form")
	public String projectForm(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {
		
		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		
		Project project;
		if (!model.containsAttribute("project")) {
			project = new Project();
		} else {
			project = (Project) model.asMap().get("project");
		}
		model.addAttribute("project", project);
		return "admin/project_form";
	}

	@PostMapping("/waetools/project-form-execute")
	public String projectFormExecute(@Valid @ModelAttribute("project") Project project, BindingResult result,
			HttpServletResponse response, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.project", result);
			redirectAttrs.addFlashAttribute("project", project);
			return "redirect:/waetools/project-form";
		}
		adminService.saveProject(project);
		return "redirect:/waetools/project";
	}

	@RequestMapping("/waetools/project-detail")
	public String projectDetail(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		
		String projectId = request.getParameter("id");
		if (StringUtils.isNullOrEmpty(projectId) || !projectId.matches("\\d+")) {
			return "redirect:/waetools/project";
		}
		
		Project project = adminService.getProject(Integer.parseInt(projectId));
		if (project == null || project.getId() != Integer.parseInt(projectId)) {
			return "redirect:/waetools/project";
		}
		redirectAttrs.addFlashAttribute("project", project);
		return "redirect:/waetools/project-form";
	}

	@RequestMapping("/waetools/project-delete")
	public String projectDelete(HttpServletRequest request) {
		
		String projectId = request.getParameter("id");
		if (!StringUtils.isNullOrEmpty(projectId) && projectId.matches("\\d+")) {
			adminService.deleteProject(Integer.parseInt(projectId));
		}
		return "redirect:/waetools/project";
	}
}
