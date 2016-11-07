package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.EmailUser;

@Repository
public class EmailUserDAOImpl implements EmailUserDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveEmail(EmailUser email) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(email);
			return email.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteEmail(int emailId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM EmailUser e WHERE e.id=:emailId");
			query.setParameter("emailId", emailId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public EmailUser getEmail(int emailId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(EmailUser.class, emailId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new EmailUser();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmailUser> getEmails(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM EmailUser");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<EmailUser>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
