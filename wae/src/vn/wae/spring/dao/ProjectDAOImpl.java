package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveProject(Project project) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(project);
			return project.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteProject(int projectId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM Project p WHERE p.id=:projectId");
			query.setParameter("projectId", projectId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public Project getProject(int projectId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(Project.class, projectId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Project();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Project");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Project>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsHighlight(int limit, byte highlight) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Project p WHERE p.highlight=:highlight");
			query.setParameter("highlight", highlight);
			query.setMaxResults(limit);
			return (ArrayList<Project>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
