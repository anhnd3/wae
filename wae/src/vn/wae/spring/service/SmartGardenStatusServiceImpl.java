package vn.wae.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.wae.spring.dao.SmartGardenStatusDAO;
import vn.wae.spring.entity.SmartGardenStatus;

@Service
public class SmartGardenStatusServiceImpl implements SmartGardenStatusService {

	@Autowired
	SmartGardenStatusDAO smartGardenStatusDAO;

	@Override
	@Transactional
	public long saveSmartGardenStatus(SmartGardenStatus status) {
		return smartGardenStatusDAO.saveSmartGardenStatus(status);
	}

	@Override
	@Transactional
	public SmartGardenStatus getLastStatus() {
		return smartGardenStatusDAO.getLastStatus();
	}

	@Override
	@Transactional
	public List<SmartGardenStatus> getStatuses(int pos, int limit) {
		return smartGardenStatusDAO.getStatuses(pos, limit);
	}

	@Override
	@Transactional
	public List<SmartGardenStatus> getStatusByTime(long fromTime, long toTime) {
		return smartGardenStatusDAO.getStatusByTime(fromTime, toTime);
	}

}
