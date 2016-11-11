package vn.wae.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.wae.spring.dao.BlogDAO;
import vn.wae.spring.dao.CourseDAO;
import vn.wae.spring.dao.EmailUserDAO;
import vn.wae.spring.dao.MessageDAO;
import vn.wae.spring.dao.PartnerDAO;
import vn.wae.spring.dao.ProjectDAO;
import vn.wae.spring.dao.TeammateDAO;
import vn.wae.spring.entity.Blog;
import vn.wae.spring.entity.Course;
import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;
import vn.wae.spring.entity.Partner;
import vn.wae.spring.entity.Project;
import vn.wae.spring.entity.Teammate;

@Service
public class MainsiteServiceImpl implements MainsiteService {

	@Autowired
	EmailUserDAO emailDAO;

	@Autowired
	MessageDAO messageDAO;

	@Autowired
	PartnerDAO partnerDAO;

	@Autowired
	CourseDAO courseDAO;

	@Autowired
	ProjectDAO projectDAO;

	@Autowired
	BlogDAO blogDAO;

	@Autowired
	TeammateDAO teammateDAO;

	@Override
	@Transactional
	public int saveEmail(EmailUser email) {
		return emailDAO.saveEmail(email);
	}

	@Override
	@Transactional
	public int saveMessage(Message message) {
		return messageDAO.saveMessage(message);
	}

	@Override
	@Transactional
	public List<Partner> getPartners(int pos, int limit) {
		return partnerDAO.getPartnersAvailable(pos, limit);
	}

	@Override
	@Transactional
	public List<Course> getCourseHighLight(int pos, int limit) {
		return courseDAO.getCoursesAvailable(pos, limit);
	}

	@Override
	@Transactional
	public List<Project> getProjectHighLight(int limit, boolean highlight) {
		return projectDAO.getProjectsHighlight(limit, highlight);
	}

	@Override
	@Transactional
	public List<Blog> getBlogHighlight(int pos, int limit, boolean highlight) {
		return blogDAO.getBlogsHighLight(pos, limit, highlight);
	}

	@Override
	@Transactional
	public List<Teammate> getTeamAvailable(int pos, int limit) {
		return teammateDAO.getTeamsAvailable(pos, limit);
	}

}
