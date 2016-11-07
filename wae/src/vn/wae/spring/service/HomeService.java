package vn.wae.spring.service;

import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;

public interface HomeService {
	
	public int saveEmail(EmailUser email);

	public int saveMessage(Message message);
}
