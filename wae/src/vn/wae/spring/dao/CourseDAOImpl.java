package vn.wae.spring.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		Session s = sessionFactory.getCurrentSession();
		s.doReturningWork(new ReturningWork<Object>() {

			@Override
			public Object execute(Connection conn) throws SQLException {
				try (Statement stmt = conn.createStatement()) {
					stmt.executeQuery("SET NAMES utf8mb4");
				}
				return null;
			}
		});
		return s;
	}

	@Override
	public int saveCourse(Course course) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(course);
			return course.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteCourse(int courseId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM Course c WHERE c.id=:courseId");
			query.setParameter("courseId", courseId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public Course getCourse(int courseId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(Course.class, courseId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Course();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourses(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Course c ORDER BY c.id DESC");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Course>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCoursesAvailable(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Course c WHERE c.status = true ORDER BY c.id DESC");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Course>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int countCourseAvaiable() {
		try {
			Session currentSession = getCurrentSession();
			Query<?> countQuery = currentSession.createQuery("select count(*) from Course c WHERE c.status = true");
			List<Long> listResult = (List<Long>) countQuery.getResultList();
			return listResult.get(0).intValue();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

}
