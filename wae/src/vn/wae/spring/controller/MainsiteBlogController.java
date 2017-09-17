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

import vn.wae.spring.dao.BlogType;
import vn.wae.spring.dao.LogAccessType;
import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.BlogCategory;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.service.MainsiteService;
import vn.wae.spring.utils.StringUtils;

@Controller
public class MainsiteBlogController {

	@Autowired
	private MainsiteService mainsiteService;

	@RequestMapping(value = "/news/{page}")
	public String news(Model model, @PathVariable(value = "page") String page) {
		// Render Section Partner
		List<Partner> partners = mainsiteService.getPartners(0, 6);
		model.addAttribute("partners", partners);

		// get page in url
		if (!page.matches("\\d+")) {
			return "mainsite/404";
		}

		// Render blog category
		List<BlogCategory> blogCategories = mainsiteService.getBlogCategoriesByType(BlogType.NEWS, 0, 10);
		for (BlogCategory category : blogCategories) {
			category.setTotalBlog(mainsiteService.countTotalBlogByCategory(category.getId()));
		}
		model.addAttribute("categories", blogCategories);

		// Render recent blogs
		List<Blog> lastestBlogByType = mainsiteService.getBlogsByType(BlogType.NEWS, 0, 6);
		model.addAttribute("lastestBlog", lastestBlogByType);

		// Render main blog
		int blogPerPage = 3;
		int p = Integer.parseInt(page);
		int startIdx = (p - 1) * blogPerPage;
		List<Blog> blogs = mainsiteService.getBlogsByType(BlogType.NEWS, startIdx, blogPerPage);
		model.addAttribute("blogs", blogs);

		// Render pagination
		int totalBlog = mainsiteService.countTotalBlogByType(BlogType.NEWS);
		if (totalBlog > blogPerPage) {
			model.addAttribute("showPagination", true);
			model.addAttribute("currentPage", p);
			int totalPage = totalBlog / blogPerPage;
			if (totalBlog % blogPerPage > 0) {
				totalPage += 1;
			}
			List<Integer> pages = new ArrayList<>();
			for (int i = 1; i <= totalPage; i++) {
				pages.add(i);
			}
			model.addAttribute("paginations", pages);
		}

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.NEWS.getValue());
		return "mainsite/news";
	}

	@RequestMapping(value = "/news/*/{id}")
	public String courseDetail(Model model, @PathVariable(value = "id") String id) throws UnsupportedEncodingException {
		// get id in url
		if (!id.matches("\\d+")) {
			return "mainsite/404";
		}

		int blogId = Integer.parseInt(id);
		Blog blog = mainsiteService.getBlog(blogId);
		model.addAttribute("news", blog);
		String titleUrl = StringUtils.getTitleFilterCharVn(blog.getTitle());
		String shareLink = "http://wae.vn/news/" + titleUrl + "/" + blog.getId();
		String encodeShareLink = UriUtils.encode(shareLink, Charset.forName("UTF-8").toString());
		model.addAttribute("shareLink", shareLink);
		model.addAttribute("encodeShareLink", encodeShareLink);

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.NEWS_DETAIL.getValue());
		return "mainsite/news_detail";
	}
	
	@RequestMapping(value = "/tutorial/{page}")
	public String tutorial(Model model, @PathVariable(value = "page") String page) {
		// Render Section Partner
		List<Partner> partners = mainsiteService.getPartners(0, 6);
		model.addAttribute("partners", partners);

		// get page in url
		if (!page.matches("\\d+")) {
			return "mainsite/404";
		}

		// Render blog category
		List<BlogCategory> blogCategories = mainsiteService.getBlogCategoriesByType(BlogType.TUTORIAL, 0, 10);
		for (BlogCategory category : blogCategories) {
			category.setTotalBlog(mainsiteService.countTotalBlogByCategory(category.getId()));
		}
		model.addAttribute("categories", blogCategories);

		// Render recent blogs
		List<Blog> lastestBlogByType = mainsiteService.getBlogsByType(BlogType.TUTORIAL, 0, 6);
		model.addAttribute("lastestBlog", lastestBlogByType);

		// Render main blog
		int blogPerPage = 3;
		int p = Integer.parseInt(page);
		int startIdx = (p - 1) * blogPerPage;
		List<Blog> blogs = mainsiteService.getBlogsByType(BlogType.TUTORIAL, startIdx, blogPerPage);
		model.addAttribute("blogs", blogs);

		// Render pagination
		int totalBlog = mainsiteService.countTotalBlogByType(BlogType.TUTORIAL);
		if (totalBlog > blogPerPage) {
			model.addAttribute("showPagination", true);
			model.addAttribute("currentPage", p);
			int totalPage = totalBlog / blogPerPage;
			if (totalBlog % blogPerPage > 0) {
				totalPage += 1;
			}
			List<Integer> pages = new ArrayList<>();
			for (int i = 1; i <= totalPage; i++) {
				pages.add(i);
			}
			model.addAttribute("paginations", pages);
		}

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.TUTORIAL.getValue());
		return "mainsite/tutorial";
	}

	@RequestMapping(value = "/tutorial/*/{id}")
	public String tutorialDetail(Model model, @PathVariable(value = "id") String id) throws UnsupportedEncodingException {
		// get id in url
		if (!id.matches("\\d+")) {
			return "mainsite/404";
		}

		int blogId = Integer.parseInt(id);
		Blog blog = mainsiteService.getBlog(blogId);
		model.addAttribute("tutorial", blog);
		String titleUrl = StringUtils.getTitleFilterCharVn(blog.getTitle());
		String shareLink = "http://wae.vn/tutorial/" + titleUrl + "/" + blog.getId();
		String encodeShareLink = UriUtils.encode(shareLink, Charset.forName("UTF-8").toString());
		model.addAttribute("shareLink", shareLink);
		model.addAttribute("encodeShareLink", encodeShareLink);

		// increase logAccess
		mainsiteService.increaseAccess(LogAccessType.TUTORIAL_DETAIL.getValue());
		return "mainsite/tutorial_detail";
	}
}
