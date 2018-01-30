package pl.coderslab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Student;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	private final UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/add-user")
	@ResponseBody
	public String addUser() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin");
		userService.saveUser(u);
		return "add-user";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin";
	}

	@RequestMapping("/")
	public String hello() {
		log.info("some log");
		return "index";
	}

	@GetMapping("/student")
	public String student(Model model) {
		model.addAttribute("message", "Created with love");
		Student s = new Student();
		s.setFirstName("Arek");
		model.addAttribute("student", s);
		return "student";
	}
}
