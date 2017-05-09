package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.SmartGardenStatus;

public interface SmartGardenStatusDAO {

	public long saveSmartGardenStatus(SmartGardenStatus status);

	public SmartGardenStatus getLastStatus();
	
	public List<SmartGardenStatus> getStatuses(int pos, int limit);

	public List<SmartGardenStatus> getStatusByTime(long fromTime, long toTime);

}
