package vn.wae.spring.controller.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/apps/test/api")
public class TestApiController {

	private final int ERROR_CODE_SUCCESSFUL = 0;
	private final int ERROR_CODE_EXCEPTION = -1;
	private final int ERROR_CODE_PARAM_ERROR = -2;
	private final int ERROR_CODE_DATABASE_ERROR = -3;

	@RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
	public String project(@RequestParam(value = "data", defaultValue = "") String data) {
		try {

			ObjectMapper mapper = new ObjectMapper();

			ObjectNode result = mapper.createObjectNode();
			result.put("errorCode", ERROR_CODE_SUCCESSFUL);
			result.put("data", data);

			return mapper.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"errorCode\": " + ERROR_CODE_EXCEPTION + ", \"msg\": \"" + e.getMessage() + "\"}";
		}
	}
}
