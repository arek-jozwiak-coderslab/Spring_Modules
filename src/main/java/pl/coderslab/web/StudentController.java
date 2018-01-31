package pl.coderslab.web;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.repository.StudentRepository;

@Controller
public class StudentController {

	private final StudentRepository studentRepository;
	

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@RequestMapping("/student/list")
	public String list(Model model, @SortDefault("id") Pageable pageable) {
		model.addAttribute("page", studentRepository.findAll(pageable));
		return "student/list";
	}
}
