package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.Blog;

@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveBlog(Blog blog) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(blog);
			return blog.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteBlog(int blogId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM Blog b WHERE b.id=:blogId");
			query.setParameter("blogId", blogId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public Blog getBlog(int blogId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(Blog.class, blogId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Blog();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getBlogs(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Blog");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<Blog>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getBlogsHighLight(int pos, int limit, boolean highlight) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Blog b WHERE b.highlight=:highlight");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			query.setParameter("highlight", highlight);
			return (ArrayList<Blog>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getBlogsByCategory(int pos, int limit, int categoryId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Blog b WHERE b.categoryId=:categoryId");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			query.setParameter("categoryId", categoryId);
			return (ArrayList<Blog>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
