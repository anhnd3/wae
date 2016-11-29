package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.LogAccess;

@Repository
public class LogAccessDAOImpl implements LogAccessDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void increaseLogAccess(int id) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession
					.createQuery("UPDATE LogAccess la set la.access = la.access + 1 WHERE la.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogAccess> getLogAccesses(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM LogAccess lg ORDER BY lg.url ASC");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<LogAccess>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
