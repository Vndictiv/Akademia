package pl.borowik.akademia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.borowik.akademia.entity.Student;
import pl.borowik.akademia.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theStudentService){
        studentService = theStudentService;
    }

    @GetMapping("/list")
    public String findAll(Model theModel){

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students", theStudents);

        return "students";
    }

    @GetMapping("/addStudent")
    public String addForm(Model theModel){

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student theStudent){

        studentService.save(theStudent);

        return "redirect:/students/list";
    }
}