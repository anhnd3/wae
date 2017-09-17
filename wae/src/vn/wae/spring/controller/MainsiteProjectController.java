package vn.wae.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.dao.LogAccessType;
import vn.wae.spring.entity.Project;
import vn.wae.spring.service.MainsiteService;

@Controller
public class MainsiteProjectController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/project")
	public String project(Model model) {

		// =================
		// Render Section Work(course, project, blog)

		List<Project> projects = mainsiteService.getProjectsAvailable(0, 9);
		model.addAttribute("projects", projects);

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.PROJECT.getValue());
		return "mainsite/project";
	}
}
