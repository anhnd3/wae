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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.StringUtils;

import vn.wae.spring.dao.UserPrivilege;
import vn.wae.spring.entity.Course;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminCourseController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools/course")
	public String course(Model model, @CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<Course> courses = adminService.getCourses(0, 1000);
		model.addAttribute("courses", courses);
		return "admin/course_listing";
	}

	@RequestMapping("/waetools/course-form")
	public String courseForm(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}

		Course course;
		if (!model.containsAttribute("course")) {
			course = new Course();
		} else {
			course = (Course) model.asMap().get("course");
		}
		model.addAttribute("course", course);
		return "admin/course_form";
	}

	@RequestMapping(value="/waetools/course-form-execute")
	public String courseFormExecute(@Valid @ModelAttribute("course") Course course, BindingResult result,
			HttpServletResponse response, RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.course", result);
			redirectAttrs.addFlashAttribute("course", course);
			return "redirect:/waetools/course-form";
		}
		
		adminService.saveCourse(course);
		return "redirect:/waetools/course";
	}

	@RequestMapping("/waetools/course-detail")
	public String courseDetail(HttpServletRequest request, RedirectAttributes redirectAttrs) {

		String courseId = request.getParameter("id");
		if (StringUtils.isNullOrEmpty(courseId) || !courseId.matches("\\d+")) {
			return "redirect:/waetools/course";
		}

		Course course = adminService.getCourse(Integer.parseInt(courseId));
		if (course == null || course.getId() != Integer.parseInt(courseId)) {
			return "redirect:/waetools/course";
		}
		redirectAttrs.addFlashAttribute("course", course);
		return "redirect:/waetools/course-form";
	}

	@RequestMapping("/waetools/course-delete")
	public String courseDelete(HttpServletRequest request) {
		String courseId = request.getParameter("id");
		if (!StringUtils.isNullOrEmpty(courseId) && courseId.matches("\\d+")) {
			adminService.deleteCourse(Integer.parseInt(courseId));
		}
		return "redirect:/waetools/course";
	}
}