package vn.wae.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.wae.spring.dao.GpsTrackingLocationDAO;
import vn.wae.spring.entity.GpsTrackingLocation;

@Service
public class GpsTrackingLocationServiceImpl implements GpsTrackingLocationService {

	@Autowired
	GpsTrackingLocationDAO gpsTrackingLocationDAO;

	@Override
	@Transactional
	public long saveLocation(GpsTrackingLocation location) {
		return gpsTrackingLocationDAO.saveLocation(location);
	}

	@Override
	@Transactional
	public List<GpsTrackingLocation> getLocations(int pos, int limit) {
		return gpsTrackingLocationDAO.getLocations(pos, limit);
	}

	@Override
	@Transactional
	public List<GpsTrackingLocation> getLocationsByTime(String fromTime, String toTime) {
		return gpsTrackingLocationDAO.getLocationsByTime(fromTime, toTime);
	}

}
