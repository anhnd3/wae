package vn.wae.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.entity.GpsTrackingLocation;
import vn.wae.spring.service.GpsTrackingLocationService;

@Controller
public class AppGpsTrackingController {

	@Autowired
	private GpsTrackingLocationService gpsTrackingLocationService;

	@RequestMapping(value = "/apps/gps-tracking")
	public String home(Model model) {
		List<GpsTrackingLocation> locations = gpsTrackingLocationService.getLocations(0, 1000);
		model.addAttribute("locations", locations);
		return "apps/gps_tracking_location_listing";
	}

}
