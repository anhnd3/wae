package vn.wae.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppGpsTrackingController {

	@RequestMapping(value = "/apps/gps-tracking")
	public String home(Model model) {
		return "apps/gps_tracking_location_listing";
	}

}
