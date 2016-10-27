package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.Course;

public interface CourseDAO {

	public int saveCourse(Course course);

	public int deleteCourse(int courseId);

	public Course getCourse(int courseId);

	public List<Course> getCourses(int pos, int limit);

}
