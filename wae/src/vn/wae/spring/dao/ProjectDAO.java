package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.Project;

public interface ProjectDAO {

	public int saveProject(Project project);

	public int deleteProject(int projectId);

	public Project getProject(int projectId);

	public List<Project> getProjects(int pos, int limit);

	public List<Project> getProjectsHighlight(int limit, boolean highlight);

	public int countProject();

	public List<Project> getProjectsAvailable(int pos, int limit);

}
