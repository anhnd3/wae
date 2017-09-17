package vn.wae.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import com.mysql.jdbc.StringUtils;

import vn.wae.spring.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveUser(User user) {
		try {
			Session currentSession = getCurrentSession();

			if (!user.getPassword().matches("[a-fA-F0-9]{32}")) {
				String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes("UTF-8"));
				user.setPassword(password);
			}
			currentSession.saveOrUpdate(user);
			return user.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteUser(int userId) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("DELETE FROM User u WHERE u.id=:userId");
			query.setParameter("userId", userId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	@Override
	public User getUser(int userId) {
		try {
			Session currentSession = getCurrentSession();
			return currentSession.get(User.class, userId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new User();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String email) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM User u WHERE u.email=:email");
			query.setParameter("email", email);
			query.setMaxResults(1);

			List<User> users = (List<User>) query.getResultList();

			if (users != null && !users.isEmpty()) {
				return users.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new User();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers(int pos, int limit) {
		try {
			Session currentSession = getCurrentSession();
			Query<?> query = currentSession.createQuery("FROM User");
			query.setFirstResult(pos);
			query.setMaxResults(limit);
			return (ArrayList<User>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public boolean isAdmin(String email, String password) {
		try {
			User user = getUser(email);
			if (user != null && user.getId() > 0 && !StringUtils.isNullOrEmpty(user.getEmail())
					&& !StringUtils.isNullOrEmpty(user.getPassword())) {
				String passwordMD5 = DigestUtils.md5DigestAsHex(password.getBytes("UTF-8"));
				if (user.getPassword().equalsIgnoreCase(passwordMD5)
						&& !UserPrivilege.fromValue(user.getPrivilege()).equals(UserPrivilege.USER)) {
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
