package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.wae.spring.entity.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveMessage(Message message) {
		try {
			Session currentSession = getCurrentSession();
			currentSession.saveOrUpdate(message);
			return message.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteMessage(int messageId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM Message m WHERE m.id=:messageId");
			query.setParameter("messageId", messageId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public Message getMessage(int messageId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(Message.class, messageId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Message();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessages(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM Message");
			query.setMaxResults(limit);
			query.setFirstResult(pos);
			return (ArrayList<Message>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
