package vn.wae.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;

import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.Course;
import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.entity.Project;
import vn.wae.spring.service.MainsiteService;

@Controller
public class MainsiteHomeController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/")
	public String home(Model model) {
		String startDate = "10:30 - 19.10.2016";
		try {
			long startTime = new SimpleDateFormat("HH:mm - dd.MM.yyyy").parse(startDate).getTime();
			if (startTime > System.currentTimeMillis()) {
				return "redirect:/countdown";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

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
		return "mainsite/home";
	}

	@RequestMapping(value = "/countdown")
	public String countdown(Model model) {
		model.addAttribute("emailUser", new EmailUser());
		model.addAttribute("message", new Message());
		return "countdown/countdown";
	}

	@PostMapping(value = "/countdown/submit-email")
	public @ResponseBody int submitEmail(HttpServletRequest request) {
		String email = request.getParameter("email");
		if (!StringUtils.isNullOrEmpty(email)) {
			EmailUser emailUser = new EmailUser(email);
			return mainsiteService.saveEmail(emailUser);
		}
		return -1;
	}

	@PostMapping(value = "/countdown/send-message")
	public String sendMessage(@Valid @ModelAttribute("message") Message message, BindingResult result) {
		System.out.println(message);
		if (!result.hasErrors()) {
			mainsiteService.saveMessage(message);
		}
		return "redirect:/countdown";
	}

}
