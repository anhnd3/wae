package vn.wae.spring.service;

import java.util.List;

import vn.wae.spring.entity.GpsLocation;

public interface GpsTrackingLocationService {

	public long saveLocation(GpsLocation location);

	public List<GpsLocation> getLocations(int pos, int limit);

	public List<GpsLocation> getLocationsByTime(String fromTime, String toTime);

}
