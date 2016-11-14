package vn.wae.spring.controller.object;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponseBody {
	@JsonView()
	String msg;

	@JsonView()
	String code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}