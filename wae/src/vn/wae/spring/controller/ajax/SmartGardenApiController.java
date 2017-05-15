package vn.wae.spring.controller.ajax;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import vn.wae.spring.entity.SmartGardenStatus;
import vn.wae.spring.service.SmartGardenStatusService;

@RestController
@RequestMapping("/apps/smart-garden/api")
public class SmartGardenApiController {

	private final int ERROR_CODE_SUCCESSFUL = 0;
	private final int ERROR_CODE_EXCEPTION = -1;
	private final int ERROR_CODE_PARAM_ERROR = -2;
	private final int ERROR_CODE_DATABASE_ERROR = -3;

	public static volatile boolean IS_NEW_STATUS_RECORD = false;

	@Autowired
	SmartGardenStatusService smartGardenStatusService;

	@RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
	public String project(@RequestParam(value = "t", defaultValue = "0") String temperature,
			@RequestParam(value = "a", defaultValue = "0") String airHumidity,
			@RequestParam(value = "g", defaultValue = "0") String groundHumidity,
			@RequestParam(value = "dt", defaultValue = "0") String dripTime,
			@RequestParam(value = "de", defaultValue = "0") String dripError,
			@RequestParam(value = "st", defaultValue = "0") String sprayTime,
			@RequestParam(value = "se", defaultValue = "0") String sprayError) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			if (temperature == "nan" || airHumidity == "nan" || groundHumidity == "nan" || dripTime == "nan"
					|| dripError == "nan" || sprayTime == "nan" || sprayError == "nan") {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Param error");
				return mapper.writeValueAsString(result);
			}

			double dripTimeRunning = 0, sprayTimeRunning = 0;
			boolean isDripError, isSprayError;
			try {
				dripTimeRunning = NumberUtils.parseNumber(dripTime, Double.class);
				sprayTimeRunning = NumberUtils.parseNumber(sprayTime, Double.class);

				isDripError = NumberUtils.parseNumber(dripError, Integer.class) == 1;
				isSprayError = NumberUtils.parseNumber(sprayError, Integer.class) == 1;
			} catch (Exception ex) {
				ex.printStackTrace();
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Parse Param Fail");
				return mapper.writeValueAsString(result);
			}

			long time = System.currentTimeMillis();
			long id = 0;

			SmartGardenStatus status = new SmartGardenStatus(time, temperature, airHumidity, groundHumidity,
					dripTimeRunning, isDripError, sprayTimeRunning, isSprayError);
			id = smartGardenStatusService.saveSmartGardenStatus(status);

			ObjectNode result = mapper.createObjectNode();

			if (id > 0) {
				result.put("errorCode", ERROR_CODE_SUCCESSFUL);
				result.put("msg", "Successful");
				result.put("data", status.toString());
				IS_NEW_STATUS_RECORD = true;
			} else {
				result.put("errorCode", ERROR_CODE_DATABASE_ERROR);
				result.put("msg", "Database error");
			}
			return mapper.writeValueAsString(result);
		} catch (IOException e) {
			e.printStackTrace();
			return "{\"errorCode\": " + ERROR_CODE_EXCEPTION + ", \"msg\": \"" + e.getMessage() + "\"}";
		}
	}

	@RequestMapping(value = "/isNew", produces = "application/json;charset=UTF-8")
	public String checkNewStatus() {
		try {
			ObjectMapper mapper = new ObjectMapper();

			ObjectNode result = mapper.createObjectNode();

			result.put("errorCode", ERROR_CODE_SUCCESSFUL);
			result.put("msg", "Successful");
			result.put("data", IS_NEW_STATUS_RECORD);
			if (IS_NEW_STATUS_RECORD) {
				IS_NEW_STATUS_RECORD = false;
			}

			return mapper.writeValueAsString(result);
		} catch (IOException e) {
			e.printStackTrace();
			return "{\"errorCode\": " + ERROR_CODE_EXCEPTION + ", \"msg\": \"" + e.getMessage() + "\"}";
		}
	}
}
