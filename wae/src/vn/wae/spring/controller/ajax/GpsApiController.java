package vn.wae.spring.controller.ajax;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import vn.wae.spring.entity.GpsTrackingLocation;
import vn.wae.spring.service.GpsTrackingLocationService;

@RestController
@RequestMapping("/api/gps")
public class GpsApiController {

	private final int ERROR_CODE_SUCCESSFUL = 0;
	private final int ERROR_CODE_EXCEPTION = -1;
	private final int ERROR_CODE_PARAM_ERROR = -2;
	private final int ERROR_CODE_DATABASE_ERROR = -3;

	// private final String SECRET_KEY = "f160ffc8ff677e2a10495d23e8f9e088";

	@Autowired
	private GpsTrackingLocationService gpsTrackingLocationService;

	@RequestMapping(value = "/add")
	public String project(@RequestParam(value = "x", defaultValue = "0") String x,
			@RequestParam(value = "y", defaultValue = "0") String y,
			@RequestParam(value = "device", defaultValue = "") String device,
			@RequestParam(value = "time", defaultValue = "1970-01-01 00:00:01") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date time,
			@RequestParam(value = "cs", defaultValue = "") String checksum) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			if (x.equals("0") && y.equals("0")) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Location doesn't mismatch");
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			}

			if (device.equals("") || !device.matches("\\d+")) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Device doesn't mismatch");
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			}

			if (time.getTime() <= 0) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Time doesn't mismatch");
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			}

			/*
			 * if (checksum.equals("")) { ObjectNode result =
			 * mapper.createObjectNode(); result.put("errorCode",
			 * ERROR_CODE_PARAM_ERROR); result.put("msg",
			 * "Checksum doesn't mismatch"); return
			 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result
			 * ); }
			 * 
			 * String cs = DigestUtils.md5DigestAsHex((SECRET_KEY +
			 * device).getBytes()); if (!cs.equals(checksum)) { ObjectNode
			 * result = mapper.createObjectNode(); result.put("errorCode",
			 * ERROR_CODE_PARAM_ERROR); result.put("msg",
			 * "Checksum doesn't match"); return
			 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result
			 * ); }
			 */

			ObjectNode objectLocation = mapper.createObjectNode();
			objectLocation.put("x", x);
			objectLocation.put("y", y);

			String location = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectLocation);
			int deviceId = Integer.parseInt(device);
			GpsTrackingLocation gpsTrackingLocation = new GpsTrackingLocation(deviceId, time, location);
			System.out.println(gpsTrackingLocation);

			long id = gpsTrackingLocationService.saveLocation(gpsTrackingLocation);

			ObjectNode result = mapper.createObjectNode();

			if (id > 0) {
				result.put("errorCode", ERROR_CODE_SUCCESSFUL);
				result.put("msg", "Successful");
				result.put("data", gpsTrackingLocation.toString());
			} else {
				result.put("errorCode", ERROR_CODE_DATABASE_ERROR);
				result.put("msg", "Database error");
			}

			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "{\"errorCode\": " + ERROR_CODE_EXCEPTION + ", \"msg\": \"JsonProcessingException\"}";
		}
	}
}
