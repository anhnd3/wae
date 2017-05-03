package vn.wae.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.entity.GpsLocation;
import vn.wae.spring.service.GpsTrackingLocationService;

@Controller
public class AppsController {

	private double defaultLat = 10.771918;
	private double defaultLng = 106.6961583;

	@Autowired
	private GpsTrackingLocationService gpsTrackingLocationService;

	@RequestMapping(value = "/apps/gps-tracking")
	public String gpsTracking(Model model) {
		List<GpsLocation> locations = gpsTrackingLocationService.getLocations(0, 1000);
		if (locations != null && !locations.isEmpty()) {
			model.addAttribute("locations", locations);
			GpsLocation lastLocation = locations.get(0);
			model.addAttribute("lastLongtitude", lastLocation.getLongtitude());
			model.addAttribute("lastLatitude", lastLocation.getLatitude());
			model.addAttribute("lastAddress", lastLocation.getAddress());
		} else {
			model.addAttribute("lastLatitude", defaultLat);
			model.addAttribute("lastLongtitude", defaultLng);
		}

		return "apps/gps_tracking_location_listing";
	}

	@RequestMapping(value = "/apps/location")
	public String gpsTrackingLocation(Model model) {
		List<GpsLocation> locations = gpsTrackingLocationService.getLocations(0, 1000);
		if (locations != null && !locations.isEmpty()) {
			model.addAttribute("locations", locations);
			GpsLocation lastLocation = locations.get(0);
			model.addAttribute("lastLongtitude", lastLocation.getLongtitude());
			model.addAttribute("lastLatitude", lastLocation.getLatitude());
			model.addAttribute("lastAddress", lastLocation.getAddress());
		} else {
			model.addAttribute("lastLatitude", defaultLat);
			model.addAttribute("lastLongtitude", defaultLng);
		}

		return "apps/gps_tracking_location_listing2";
	}

	@RequestMapping(value = "/apps/he-thong-giam-sat-vuon-thong-minh")
	public String monitoringEnvironmentalCondition(Model model) {
		return "apps/monitor_env_condition";
	}

}
