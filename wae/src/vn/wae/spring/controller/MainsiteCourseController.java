package vn.wae.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.entity.Course;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.service.MainsiteService;

@Controller
public class MainsiteCourseController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/course/{page}")
	public String about(Model model, @PathVariable(value = "page") String page) {
		// get page in url
		if (!page.matches("\\d+")) {
			return "redirect:/course/1";
		}

		// Render Section Partner
		List<Partner> partners = mainsiteService.getPartners(0, 6);
		model.addAttribute("partners", partners);

		// Render recent course
		List<Course> lastestCourses = mainsiteService.getCourseHighLight(0, 5);
		model.addAttribute("lastestCourses", lastestCourses);

		// Render Section Course
		int coursePerPage = 3;
		int p = Integer.parseInt(page);
		int startIdx = (p - 1) * coursePerPage;
		List<Course> courses = mainsiteService.getCourseHighLight(startIdx, coursePerPage);
		model.addAttribute("courses", courses);
		return "mainsite/course";
	}

}
