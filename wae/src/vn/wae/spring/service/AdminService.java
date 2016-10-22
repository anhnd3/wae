package vn.wae.spring.service;

import java.util.List;

import vn.wae.spring.entity.User;

public interface AdminService {

	public int saveUser(User user);

	public int deleteUser(int userId);

	public User getUser(int userId);

	public User getUser(String email);

	public List<User> getUsers(int pos, int limit);

	public boolean isAdmin(String email, String password);

}
