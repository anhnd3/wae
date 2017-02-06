package vn.wae.spring.service;

import java.util.List;

import vn.wae.spring.entity.GpsTrackingLocation;

public interface GpsTrackingLocationService {

	public long saveLocation(GpsTrackingLocation location);

	public List<GpsTrackingLocation> getLocations(int pos, int limit);

	public List<GpsTrackingLocation> getLocationsByTime(String fromTime, String toTime);

}
