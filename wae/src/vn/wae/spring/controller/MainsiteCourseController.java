package vn.wae.spring.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriUtils;

import vn.wae.spring.dao.LogAccessType;
import vn.wae.spring.entity.Course;
import vn.wae.spring.service.MainsiteService;
import vn.wae.spring.utils.StringUtils;

@Controller
public class MainsiteCourseController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/course/{page}")
	public String course(Model model, @PathVariable(value = "page") String page) {
		// get page in url
		if (!page.matches("\\d+")) {
			return "mainsite/404";
		}

		// Render recent course
		List<Course> lastestCourses = mainsiteService.getCourseHighLight(0, 5);
		model.addAttribute("lastestCourses", lastestCourses);

		// Render Section Course
		int coursePerPage = 3;
		int p = Integer.parseInt(page);
		int startIdx = (p - 1) * coursePerPage;
		List<Course> courses = mainsiteService.getCourseHighLight(startIdx, coursePerPage);
		model.addAttribute("courses", courses);

		// Render pagination
		int totalCourse = mainsiteService.countCourseAvailable();
		if (totalCourse > coursePerPage) {
			model.addAttribute("showPagination", true);
			model.addAttribute("currentPage", p);
			int totalPage = totalCourse / coursePerPage;
			if (totalCourse % coursePerPage > 0) {
				totalPage += 1;
			}
			List<Integer> pages = new ArrayList<>();
			for (int i = 1; i <= totalPage; i++) {
				pages.add(i);
			}
			model.addAttribute("paginations", pages);
		}

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.COURSE.getValue());
		return "mainsite/course";
	}

	@RequestMapping(value = "/course/*/{id}")
	public String courseDetail(Model model, @PathVariable(value = "id") String id) throws UnsupportedEncodingException {
		// get id in url
		if (!id.matches("\\d+")) {
			return "mainsite/404";
		}

		int courseId = Integer.parseInt(id);
		Course course = mainsiteService.getCourse(courseId);
		model.addAttribute("course", course);
		String titleUrl = StringUtils.getTitleFilterCharVn(course.getTitle());
		String shareLink = "http://wae.vn/course/" + titleUrl + "/" + course.getId();
		String encodeShareLink = UriUtils.encode(shareLink, Charset.forName("UTF-8").toString());
		model.addAttribute("shareLink", shareLink);
		model.addAttribute("encodeShareLink", encodeShareLink);

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.COURSE_DETAIL.getValue());
		return "mainsite/course_detail";
	}

}
