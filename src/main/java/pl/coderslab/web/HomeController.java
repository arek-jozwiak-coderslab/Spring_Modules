package pl.coderslab.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.User;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.UserService;

@Controller
@Slf4j
public class HomeController {

	private final UserService userService;
	private final BookRepository bookRepository;

	public HomeController(UserService userService, BookRepository bookRepository) {
		this.userService = userService;
		this.bookRepository = bookRepository;
	}
	@RequestMapping("/create-book")
    @ResponseBody
	public String createBook(@AuthenticationPrincipal CurrentUser customUser){
	    Book b = new Book();
	    b.setTitle("Some title");
	    b.setOwner(customUser.getUser());
	    bookRepository.save(b);
        return "created";
    }
	@RequestMapping("/add-some")
	@ResponseBody
	public String addSomeWithuser() {
		User newUser = new User();
		newUser.setUsername("admin");
		newUser.setPassword("admin");
		userService.saveAdmin(newUser);
		return "add-some";
	}

	@GetMapping("/add-user")
	@ResponseBody
	public String addUser() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin");
		userService.saveAdmin(u);
		return "add-user";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin(@AuthenticationPrincipal CurrentUser customUser) {
		return "this is user " + customUser.getUser();
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
