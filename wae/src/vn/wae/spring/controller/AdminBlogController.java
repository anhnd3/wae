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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.StringUtils;

import vn.wae.spring.dao.UserPrivilege;
import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.BlogCategory;
import vn.wae.spring.service.AdminService;

@Controller
public class AdminBlogController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/waetools/blog-category")
	public String blogCategory(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}
		List<BlogCategory> blogCategories = adminService.getBlogCategories(0, 1000);
		model.addAttribute("blogCategories", blogCategories);
		return "admin/blog_category_listing";
	}

	@RequestMapping("/waetools/blog-category-form")
	public String blogCategoryForm(Model model,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}

		BlogCategory blogCategory;
		if (!model.containsAttribute("blogCategory")) {
			blogCategory = new BlogCategory();
		} else {
			blogCategory = (BlogCategory) model.asMap().get("blogCategory");
		}
		model.addAttribute("blogCategory", blogCategory);
		return "admin/blog_category_form";
	}

	@RequestMapping("/waetools/blog-category-form-execute")
	public String blogCategoryFormExecute(@Valid @ModelAttribute("blogCategory") BlogCategory blogCategory,
			BindingResult result, HttpServletResponse response, RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.blogCategory", result);
			redirectAttrs.addFlashAttribute("blogCategory", blogCategory);
			return "redirect:/waetools/blog-category-form";
		}
		adminService.saveBlogCategory(blogCategory);
		return "redirect:/waetools/blog-category";
	}

	@RequestMapping("/waetools/blog-category-detail")
	public String blogCategoryDetail(HttpServletRequest request, RedirectAttributes redirectAttrs) {

		String blogCategoryId = request.getParameter("id");
		if (StringUtils.isNullOrEmpty(blogCategoryId) || !blogCategoryId.matches("\\d+")) {
			return "redirect:/waetools/blog-category";
		}

		BlogCategory blogCategory = adminService.getBlogCategory(Integer.parseInt(blogCategoryId));
		if (blogCategory == null || blogCategory.getId() != Integer.parseInt(blogCategoryId)) {
			return "redirect:/waetools/blog-category";
		}
		redirectAttrs.addFlashAttribute("blogCategory", blogCategory);
		return "redirect:/waetools/blog-category-form";
	}

	@RequestMapping("/waetools/blog-category-delete")
	public String blogCategoryDelete(HttpServletRequest request) {

		String blogCategoryId = request.getParameter("id");
		if (!StringUtils.isNullOrEmpty(blogCategoryId) && blogCategoryId.matches("\\d+")) {
			adminService.deleteBlogCategory(Integer.parseInt(blogCategoryId));
		}
		return "redirect:/waetools/blog-category";
	}

	@RequestMapping("/waetools/blog")
	public String blog(Model model, @RequestParam(value = "blogCategoryId", defaultValue = "0") String blogCategoryId,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}

		if (blogCategoryId.equals("0") || !blogCategoryId.matches("\\d+")) {
			return "redirect:/waetools/blog-category";
		}
		BlogCategory blogCategory = adminService.getBlogCategory(Integer.parseInt(blogCategoryId));
		List<Blog> blogs = adminService.getBlogs(Integer.parseInt(blogCategoryId), 0, 1000);
		model.addAttribute("blogs", blogs);
		model.addAttribute("blogCategory", blogCategory);
		return "admin/blog_listing";
	}

	@RequestMapping("/waetools/blog-form")
	public String blogForm(Model model,
			@RequestParam(value = "blogCategoryId", defaultValue = "0") String blogCategoryId,
			@CookieValue(name = "wae.user.admin", defaultValue = "false") String cookieAdmin,
			@CookieValue(name = "wae.user.admin.type", defaultValue = "1") String cookieAdminType) {

		if (StringUtils.isNullOrEmpty(cookieAdmin) || cookieAdmin.equals("false")) {
			return "redirect:/waetools/login";
		}
		if (cookieAdminType.equals(String.valueOf(UserPrivilege.ADMIN.getValue()))) {
			model.addAttribute("modifyAdmin", "true");
		}

		Blog blog;
		if (!model.containsAttribute("blog")) {
			blog = new Blog();
			if (blogCategoryId.equals("0") || !blogCategoryId.matches("\\d+")) {
				return "redirect:/waetools/blog-category";
			}
			blog.setCategoryId(Integer.parseInt(blogCategoryId));
		} else {
			blog = (Blog) model.asMap().get("blog");
		}
		model.addAttribute("blog", blog);
		return "admin/blog_form";
	}

	@RequestMapping("/waetools/blog-form-execute")
	public String blogFormExecute(@Valid @ModelAttribute("blog") Blog blog, BindingResult result,
			RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.blog", result);
			redirectAttrs.addFlashAttribute("blog", blog);
			return "redirect:/waetools/blog-form";
		}
		if (blog.getId() == 0) {
			blog.setTime(System.currentTimeMillis());
		}
		adminService.saveBlog(blog);
		return "redirect:/waetools/blog?blogCategoryId=" + blog.getCategoryId();
	}

	@RequestMapping("/waetools/blog-detail")
	public String blogDetail(@RequestParam(value = "blogCategoryId", defaultValue = "0") String blogCategoryId,
			@RequestParam(value = "id", defaultValue = "0") String blogId, RedirectAttributes redirectAttrs) {
		if (blogCategoryId.equals("0") || !blogCategoryId.matches("\\d+")) {
			return "redirect:/waetools/blog-category";
		}
		if (blogId.equals("0") || !blogId.matches("\\d+")) {
			return "redirect:/waetools/blog?blogCategoryId=" + blogCategoryId;
		}
		Blog blog = adminService.getBlog(Integer.parseInt(blogId));
		if (blog == null || blog.getId() != Integer.parseInt(blogId)) {
			return "redirect:/waetools/blog?blogCategoryId=" + blogCategoryId;
		}
		redirectAttrs.addFlashAttribute("blog", blog);
		return "redirect:/waetools/blog-form";
	}

	@RequestMapping("/waetools/blog-delete")
	public String blogDelete(@RequestParam(value = "blogCategoryId", defaultValue = "0") String blogCategoryId,
			@RequestParam(value = "id", defaultValue = "0") String blogId) {
		if (blogCategoryId.equals("0") || !blogCategoryId.matches("\\d+")) {
			return "redirect:/waetools/blog-category";
		}
		if (blogId.equals("0") || !blogId.matches("\\d+")) {
			return "redirect:/waetools/blog?blogCategoryId=" + blogCategoryId;
		}
		adminService.deleteBlog(Integer.parseInt(blogId));
		return "redirect:/waetools/blog?blogCategoryId=" + blogCategoryId;
	}
}
