package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.BlogCategory;

@Repository
public class BlogCategoryDAOImpl implements BlogCategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveBlogCategory(BlogCategory category) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(category);
			return category.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteBlogCategory(int categoryId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM BlogCategory c WHERE c.id=:categoryId");
			query.setParameter("categoryId", categoryId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public BlogCategory getBlogCategory(int categoryId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(BlogCategory.class, categoryId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new BlogCategory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogCategory> getBlogCategories(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM BlogCategory");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<BlogCategory>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogCategory> getBlogCategoriesByType(BlogType type, int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM BlogCategory bc WHERE bc.type = :type AND bc.status = true");
			query.setParameter("type", type.getValue());
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<BlogCategory>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
