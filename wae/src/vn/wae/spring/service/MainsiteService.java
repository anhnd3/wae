package vn.wae.spring.service;

import java.util.List;

import vn.wae.spring.entity.Blog;
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

}
