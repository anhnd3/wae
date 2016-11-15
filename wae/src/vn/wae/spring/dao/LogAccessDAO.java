package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.LogAccess;

public interface LogAccessDAO {

	public void increaseLogAccess(int id);

	public List<LogAccess> getLogAccesses(int pos, int limit);

}
