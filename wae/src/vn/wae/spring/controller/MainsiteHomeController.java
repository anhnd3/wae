package vn.wae.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.dao.LogAccessType;
import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.Course;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.entity.Project;
import vn.wae.spring.service.MainsiteService;

@Controller
public class MainsiteHomeController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/")
	public String home(Model model) {
		// Render Section Partner
		List<Partner> partners = mainsiteService.getPartners(0, 6);
		model.addAttribute("partners", partners);
		// =================
		// Render Section Work(course, project, blog)
		int sectionEmpty = 0;
		List<Project> projects = mainsiteService.getProjectHighLight(3, true);
		if (projects.isEmpty()) {
			sectionEmpty++;
			model.addAttribute("showProject", false);
		} else {
			model.addAttribute("showProject", true);
			model.addAttribute("projects", projects);
		}
		List<Course> courses = mainsiteService.getCourseHighLight(0, 3);
		if (courses.isEmpty()) {
			sectionEmpty++;
			model.addAttribute("showCourse", false);
		} else {
			model.addAttribute("showCourse", true);
			model.addAttribute("courses", courses);
		}
		List<Blog> blogs = mainsiteService.getBlogHighlight(0, 3, true);
		if (blogs.isEmpty()) {
			sectionEmpty++;
			model.addAttribute("showBlog", false);
		} else {
			model.addAttribute("showBlog", true);
			model.addAttribute("blogs", blogs);
		}
		if (sectionEmpty == 3) {
			model.addAttribute("showSectionWork", false);
		} else {
			model.addAttribute("showSectionWork", true);
		}

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.HOME.getValue());
		return "mainsite/home";
	}

	@RequestMapping(value = "/countdown")
	public String countdown(Model model) {
		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.COUNTDOWN.getValue());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/zohoverify/verifyforzoho.html")
	public String zohoverify(Model model){
		return "mainsite/zohoverify";
	}
}
