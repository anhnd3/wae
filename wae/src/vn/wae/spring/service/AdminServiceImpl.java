package vn.wae.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.wae.spring.dao.UserDAO;
import vn.wae.spring.entity.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public int saveUser(User user) {
		return userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public int deleteUser(int userId) {
		return userDAO.deleteUser(userId);
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public User getUser(String email) {
		return userDAO.getUser(email);
	}

	@Override
	@Transactional
	public List<User> getUsers(int pos, int limit) {
		return userDAO.getUsers(pos, limit);
	}

	@Override
	@Transactional
	public boolean isAdmin(String email, String password) {
		return userDAO.isAdmin(email, password);
	}

}
