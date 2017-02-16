package vn.wae.spring.controller.ajax;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import vn.wae.spring.entity.GpsLocation;
import vn.wae.spring.service.GpsTrackingLocationService;
import vn.wae.spring.utils.HttpClientUtils;

@RestController
@RequestMapping("/apps/gps-tracking/api")
public class GpsApiController {

	private final int ERROR_CODE_SUCCESSFUL = 0;
	private final int ERROR_CODE_EXCEPTION = -1;
	private final int ERROR_CODE_PARAM_ERROR = -2;
	private final int ERROR_CODE_DATABASE_ERROR = -3;

	private final String SECRET_KEY = "f160ffc8ff677e2a10495d23e8f9e088";

	private String apiGoogleAddress = "https://maps.googleapis.com/maps/api/geocode/json?latlng=%s,%s";

	@Autowired
	private GpsTrackingLocationService gpsTrackingLocationService;

	@RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
	public String project(@RequestParam(value = "lng", defaultValue = "0") String longtitude,
			@RequestParam(value = "lat", defaultValue = "0") String latitude,
			@RequestParam(value = "device", defaultValue = "") String device,
			@RequestParam(value = "time", defaultValue = "1970-01-01 00:00:01") String time,
			@RequestParam(value = "cs", defaultValue = "") String checksum) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			if (longtitude.equals("0") && latitude.equals("0")) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Location doesn't mismatch");
				return mapper.writeValueAsString(result);
			}

			if (device.equals("") || !device.matches("\\d+")) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Device doesn't mismatch");
				return mapper.writeValueAsString(result);
			}

			if (time.equals("1970-01-01 00:00:01")) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Time doesn't mismatch");
				return mapper.writeValueAsString(result);
			}

			if (checksum.equals("")) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Checksum doesn't mismatch");
				return mapper.writeValueAsString(result);
			}

			String cs = DigestUtils.md5DigestAsHex((SECRET_KEY + device + time).getBytes());
			if (!cs.equals(checksum)) {
				ObjectNode result = mapper.createObjectNode();
				result.put("errorCode", ERROR_CODE_PARAM_ERROR);
				result.put("msg", "Checksum doesn't match");
				return mapper.writeValueAsString(result);
			}

			String addressFromGeocode = new HttpClientUtils()
					.get(String.format(apiGoogleAddress, latitude, longtitude));
			JsonNode rootNode = new ObjectMapper().readValue(addressFromGeocode, JsonNode.class);
			JsonNode resultNode = rootNode.get("results").get(0);
			JsonNode address = resultNode.get("formatted_address");
			String formattedAddress = "";
			if (address != null) {
				formattedAddress = address.asText();
			}

			int deviceId = Integer.parseInt(device);
			Date receiveDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
			GpsLocation gpsTrackingLocation = new GpsLocation(deviceId, receiveDate, longtitude, latitude,
					formattedAddress);

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
			return mapper.writeValueAsString(result);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
			return "{\"errorCode\": " + ERROR_CODE_EXCEPTION + ", \"msg\": \"" + e.getMessage() + "\"}";
		}
	}
}
