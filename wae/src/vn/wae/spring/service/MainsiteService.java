package vn.wae.spring.service;

import java.util.List;

import vn.wae.spring.dao.BlogType;
import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.BlogCategory;
import vn.wae.spring.entity.Course;
import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.entity.Project;
import vn.wae.spring.entity.Teammate;

public interface MainsiteService {

	public int saveEmail(EmailUser email);

	public int saveMessage(Message message);

	public List<Partner> getPartners(int pos, int limit);

	public List<Course> getCourseHighLight(int pos, int limit);

	public List<Project> getProjectHighLight(int limit, boolean highlight);

	public List<Blog> getBlogHighlight(int pos, int limit, boolean highlight);

	public List<Teammate> getTeamAvailable(int pos, int limit);

	public void increaseAccess(int id);

	public Course getCourse(int courseId);

	public Blog getBlog(int blogId);

	public List<Blog> getBlogsByType(BlogType type, int pos, int limit);

	public List<BlogCategory> getBlogCategoriesByType(BlogType type, int pos, int limit);

	public int countTotalBlogByCategory(int categoryId);

	public List<Blog> getBlogs(int pos, int limit);
	
	public int countTotalBlogByType(BlogType type);

}
