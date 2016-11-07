package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.EmailUser;

public interface EmailUserDAO {

	public int saveEmail(EmailUser email);

	public int deleteEmail(int emailId);

	public EmailUser getEmail(int emailId);

	public List<EmailUser> getEmails(int pos, int limit);

}
