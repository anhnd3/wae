package vn.wae.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;

import vn.wae.spring.entity.EmailUser;
import vn.wae.spring.entity.Message;
import vn.wae.spring.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/")
	public String home(Model model) {
		String startDate = "10:30 - 19.10.2016";
		try {
			long startTime = new SimpleDateFormat("HH:mm - dd.MM.yyyy").parse(startDate).getTime();
			if (startTime > System.currentTimeMillis()) {
				return "redirect:/countdown";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "mainsite/home";
	}

	@RequestMapping(value = "/countdown")
	public String countdown(Model model) {
		model.addAttribute("emailUser", new EmailUser());
		model.addAttribute("message", new Message());
		return "countdown/countdown";
	}

	@PostMapping(value = "/countdown/submit-email")
	public @ResponseBody int submitEmail(HttpServletRequest request) {
		String email = request.getParameter("email");
		if (!StringUtils.isNullOrEmpty(email)) {
			EmailUser emailUser = new EmailUser(email);
			return homeService.saveEmail(emailUser);
		}
		return -1;
	}

	@PostMapping(value = "/countdown/send-message")
	public String sendMessage(@Valid @ModelAttribute("message") Message message, BindingResult result) {
		System.out.println(message);
		if (!result.hasErrors()) {
			homeService.saveMessage(message);
		}
		return "redirect:/countdown";
	}

}
