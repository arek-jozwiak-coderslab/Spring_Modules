package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private final String LOGIN_TEMPLATE = "admin";

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return LOGIN_TEMPLATE+"/login";
	}
}
