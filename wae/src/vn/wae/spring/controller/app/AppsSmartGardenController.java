package vn.wae.spring.controller.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import vn.wae.spring.entity.SmartGardenStatus;
import vn.wae.spring.service.SmartGardenStatusService;
import vn.wae.spring.utils.TimeUtils;

@Controller
public class AppsSmartGardenController {

	@Autowired
	private SmartGardenStatusService smartGardenStatusService;

	@RequestMapping(value = "/apps/he-thong-giam-sat-vuon-thong-minh")
	public String monitoringEnvironmentalCondition(Model model) throws JsonProcessingException {
		// Render last status
		SmartGardenStatus lastStatus = smartGardenStatusService.getLastStatus();
		if (lastStatus == null) {
			lastStatus = new SmartGardenStatus();
		}
		model.addAttribute("lastStatus", lastStatus);

		// Render list status in last day
		Date renderDate = new Date(lastStatus.getTime());
		long startOfDay = TimeUtils.getStartOfDay(renderDate).getTime();
		long endOfDay = TimeUtils.getEndOfDay(renderDate).getTime();
		List<SmartGardenStatus> statusInDays = smartGardenStatusService.getStatusByTime(startOfDay, endOfDay);
		if (statusInDays == null) {
			statusInDays = new ArrayList<>();
		}

		// Create json array
		ObjectMapper temperatureMapper = new ObjectMapper();
		ObjectMapper humidityMapper = new ObjectMapper();
		ArrayNode temperatureArray = temperatureMapper.createArrayNode();
		ArrayNode humidityArray = humidityMapper.createArrayNode();

		for (SmartGardenStatus status : statusInDays) {
			ObjectNode temperatureObject = temperatureMapper.createObjectNode();
			temperatureObject.put("period", TimeUtils.timestampToString(status.getTime(), "dd-MM-yyyy HH:mm:ss"));
			temperatureObject.put("temperature", NumberUtils.parseNumber(status.getTemperature(), Double.class));
			temperatureArray.add(temperatureObject);

			ObjectNode humidityObject = temperatureMapper.createObjectNode();
			humidityObject.put("period", TimeUtils.timestampToString(status.getTime(), "dd-MM-yyyy HH:mm:ss"));
			humidityObject.put("air", NumberUtils.parseNumber(status.getAirHumidity(), Double.class));
			humidityObject.put("ground", NumberUtils.parseNumber(status.getGroundHumidity(), Double.class));
			humidityArray.add(humidityObject);
		}

		model.addAttribute("temperatureJson", temperatureMapper.writeValueAsString(temperatureArray));
		model.addAttribute("humidityJson", humidityMapper.writeValueAsString(humidityArray));

		return "apps/monitor_env_condition";
	}

}
