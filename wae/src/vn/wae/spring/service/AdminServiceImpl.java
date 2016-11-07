package vn.wae.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.wae.spring.dao.BlogCategoryDAO;
import vn.wae.spring.dao.BlogDAO;
import vn.wae.spring.dao.CourseDAO;
import vn.wae.spring.dao.EmailUserDAO;
import vn.wae.spring.dao.MessageDAO;
import vn.wae.spring.dao.PartnerDAO;
import vn.wae.spring.dao.ProjectDAO;
import vn.wae.spring.dao.TeamDAO;
import vn.wae.spring.dao.UserDAO;
import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.BlogCategory;
import vn.wae.spring.entity.Course;
import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.entity.Project;
import vn.wae.spring.entity.Teammate;
import vn.wae.spring.entity.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private BlogCategoryDAO blogCategoryDAO;

	@Autowired
	private BlogDAO blogDAO;

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	private PartnerDAO partnerDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private TeamDAO teamDAO;

	@Autowired
	private EmailUserDAO emailUserDAO;

	@Override
	@Transactional
	public int saveUser(User user) {
		return userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public int deleteUser(int userId) {
		return userDAO.deleteUser(userId);
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public User getUser(String email) {
		return userDAO.getUser(email);
	}

	@Override
	@Transactional
	public List<User> getUsers(int pos, int limit) {
		return userDAO.getUsers(pos, limit);
	}

	@Override
	@Transactional
	public boolean isAdmin(String email, String password) {
		return userDAO.isAdmin(email, password);
	}

	@Override
	@Transactional
	public int saveBlogCategory(BlogCategory blogCategory) {
		return blogCategoryDAO.saveBlogCategory(blogCategory);
	}

	@Override
	@Transactional
	public int deleteBlogCategory(int blogCategoryId) {
		return blogCategoryDAO.deleteBlogCategory(blogCategoryId);
	}

	@Override
	@Transactional
	public BlogCategory getBlogCategory(int blogCategoryId) {
		return blogCategoryDAO.getBlogCategory(blogCategoryId);
	}

	@Override
	@Transactional
	public List<BlogCategory> getBlogCategories(int pos, int limit) {
		return blogCategoryDAO.getBlogCategories(pos, limit);
	}

	@Override
	@Transactional
	public int saveCourse(Course course) {
		return courseDAO.saveCourse(course);
	}

	@Override
	@Transactional
	public int deleteCourse(int courseId) {
		return courseDAO.deleteCourse(courseId);
	}

	@Override
	@Transactional
	public Course getCourse(int courseId) {
		return courseDAO.getCourse(courseId);
	}

	@Override
	@Transactional
	public List<Course> getCourses(int pos, int limit) {
		return courseDAO.getCourses(pos, limit);
	}

	@Override
	@Transactional
	public int deleteMessage(int messageId) {
		return messageDAO.deleteMessage(messageId);
	}

	@Override
	@Transactional
	public Message getMessage(int messageId) {
		return messageDAO.getMessage(messageId);
	}

	@Override
	@Transactional
	public List<Message> getMessage(int pos, int limit) {
		return messageDAO.getMessages(pos, limit);
	}

	@Override
	@Transactional
	public int savePartner(Partner partner) {
		return partnerDAO.savePartner(partner);
	}

	@Override
	@Transactional
	public int deletePartner(int partnerId) {
		return partnerDAO.deletePartner(partnerId);
	}

	@Override
	@Transactional
	public Partner getPartner(int partnerId) {
		return partnerDAO.getPartner(partnerId);
	}

	@Override
	@Transactional
	public List<Partner> getPartners(int pos, int limit) {
		return partnerDAO.getPartners(pos, limit);
	}

	@Override
	@Transactional
	public int saveProject(Project project) {
		return projectDAO.saveProject(project);
	}

	@Override
	@Transactional
	public int deleteProject(int projectId) {
		return projectDAO.deleteProject(projectId);
	}

	@Override
	@Transactional
	public Project getProject(int projectId) {
		return projectDAO.getProject(projectId);
	}

	@Override
	@Transactional
	public List<Project> getProjects(int pos, int limit) {
		return projectDAO.getProjects(pos, limit);
	}

	@Override
	@Transactional
	public int saveTeam(Teammate team) {
		return teamDAO.saveTeam(team);
	}

	@Override
	@Transactional
	public int deleteTeam(int teamId) {
		return teamDAO.deleteTeam(teamId);
	}

	@Override
	@Transactional
	public Teammate getTeam(int teamId) {
		return teamDAO.getTeam(teamId);
	}

	@Override
	@Transactional
	public List<Teammate> getTeams(int pos, int limit) {
		return teamDAO.getTeams(pos, limit);
	}

	@Override
	@Transactional
	public int saveBlog(Blog blog) {
		return blogDAO.saveBlog(blog);
	}

	@Override
	@Transactional
	public int deleteBlog(int blogId) {
		return blogDAO.deleteBlog(blogId);
	}

	@Override
	@Transactional
	public Blog getBlog(int blogId) {
		return blogDAO.getBlog(blogId);
	}

	@Override
	@Transactional
	public List<Blog> getBlogs(int blogCategoryId, int pos, int limit) {
		return blogDAO.getBlogsByCategory(pos, limit, blogCategoryId);
	}

	@Override
	@Transactional
	public int deleteEmailUser(int emailUserId) {
		return emailUserDAO.deleteEmail(emailUserId);
	}

	@Override
	@Transactional
	public List<EmailUser> getEmailUses(int pos, int limit) {
		return emailUserDAO.getEmails(pos, limit);
	}
}
