package in.shreya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.shreya.entity.Student;
import in.shreya.serviceInterface.StudentService;



@Controller
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService Service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("students", Service.getAllStudents());
        return "index";
    }

    @GetMapping("/addstd")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addstudent"; 
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        Service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", Service.getStudentById(id));
        return "editstudent";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        Service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Service.deleteStudent(id);
        return "redirect:/";
    }
}