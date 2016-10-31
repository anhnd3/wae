package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveCourse(Course course) {
		System.out.println(course);
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(course);
			System.out.println(course);
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

}
