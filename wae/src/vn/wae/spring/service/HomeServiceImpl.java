package vn.wae.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.wae.spring.dao.EmailUserDAO;
import vn.wae.spring.dao.MessageDAO;
import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	EmailUserDAO emailDAO;

	@Autowired
	MessageDAO messageDAO;

	@Override
	@Transactional
	public int saveEmail(EmailUser email) {
		return emailDAO.saveEmail(email);
	}

	@Override
	@Transactional
	public int saveMessage(Message message) {
		return messageDAO.saveMessage(message);
	}

}
