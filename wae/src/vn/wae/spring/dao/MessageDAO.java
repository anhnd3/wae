package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.Message;

public interface MessageDAO {

	public int saveMessage(Message message);

	public int deleteMessage(int messageId);

	public Message getMessage(int messageId);

	public List<Message> getMessages(int pos, int limit);

}
