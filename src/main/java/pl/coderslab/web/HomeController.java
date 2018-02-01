package pl.coderslab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.User;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.UserService;

@Controller
@Slf4j
public class HomeController {

	private final UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/add-some")
	@ResponseBody
	public String addSomeWithuser() {
		//get user id from logged user
		return "add-some";
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
	public String admin(@AuthenticationPrincipal CurrentUser customUser) {
		return "admin id " + customUser.getUserID();
	}

	@RequestMapping("/")
	public String hello() {
		log.info("some log");
		return "index";
	}

	@GetMapping("/student")
	public String student(Model model) {
		model.addAttribute("message", "Created with love");
		
		Student s = Student.builder().firstName("Arek").lastName("Jozwiak").build();
		Student s2 = new Student();
		s2.setFirstName("Arek");
		s2.setLastName("Jozwai");
		log.info(s.getFirstName());
		
		model.addAttribute("student", s);
		return "student";
	}
}
