package vn.wae.spring.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.wae.spring.entity.SmartGardenStatus;
import vn.wae.spring.service.SmartGardenStatusService;

@Controller
public class AppsSmartGardenController {

	@Autowired
	private SmartGardenStatusService smartGardenStatusService;

	@RequestMapping(value = "/apps/he-thong-giam-sat-vuon-thong-minh")
	public String monitoringEnvironmentalCondition(Model model) {
		SmartGardenStatus lastStatus = smartGardenStatusService.getLastStatus();
		if (lastStatus == null) {
			lastStatus = new SmartGardenStatus();
		}
		model.addAttribute("lastStatus", lastStatus);
		return "apps/monitor_env_condition";
	}

}
