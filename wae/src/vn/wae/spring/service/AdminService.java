package vn.wae.spring.service;

import java.util.List;

import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.BlogCategory;
import vn.wae.spring.entity.Course;
import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.entity.Project;
import vn.wae.spring.entity.Teammate;
import vn.wae.spring.entity.User;

public interface AdminService {

	public int saveUser(User user);

	public int deleteUser(int userId);

	public User getUser(int userId);

	public User getUser(String email);

	public List<User> getUsers(int pos, int limit);

	public boolean isAdmin(String email, String password);

	public int saveBlogCategory(BlogCategory blogCategory);

	public int deleteBlogCategory(int blogCategoryId);

	public BlogCategory getBlogCategory(int blogCategoryId);

	public List<BlogCategory> getBlogCategories(int pos, int limit);

	public int saveCourse(Course course);

	public int deleteCourse(int courseId);

	public Course getCourse(int courseId);

	public List<Course> getCourses(int pos, int limit);

	public int deleteMessage(int messageId);

	public Message getMessage(int messageId);

	public List<Message> getMessage(int pos, int limit);

	public int savePartner(Partner partner);

	public int deletePartner(int partnerId);

	public Partner getPartner(int partnerId);

	public List<Partner> getPartners(int pos, int limit);

	public int saveProject(Project project);

	public int deleteProject(int projectId);

	public Project getProject(int projectId);

	public List<Project> getProjects(int pos, int limit);

	public int saveTeam(Teammate team);

	public int deleteTeam(int teamId);

	public Teammate getTeam(int teamId);

	public List<Teammate> getTeams(int pos, int limit);

	public int saveBlog(Blog blog);

	public int deleteBlog(int blogId);

	public Blog getBlog(int blogId);

	public List<Blog> getBlogs(int blogCategoryId, int pos, int limit);
	
	public int deleteEmailUser(int emailUserId);

	public List<EmailUser> getEmailUses(int pos, int limit);

}
