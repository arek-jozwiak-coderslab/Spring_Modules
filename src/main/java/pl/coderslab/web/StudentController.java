package pl.coderslab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.repository.StudentRepository;

import static pl.coderslab.utils.MessageHelper.addSuccessAttribute;

@Controller
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@RequestMapping("/student/list")
	public String list(Model model, @SortDefault("id") Pageable pageable) {
		model.addAttribute("page", studentRepository.findAll(pageable));
		return "student/list";
	}

	@RequestMapping(value = "/student/remove", method = RequestMethod.GET)
	public String processRegistration(Model model, RedirectAttributes redirectAttrs) {
		addSuccessAttribute(redirectAttrs, "info.success");
		return "redirect:/student/list";
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Authentication authentication) {
		log.info(authentication.toString());
		return authentication.getName();
	}
}
