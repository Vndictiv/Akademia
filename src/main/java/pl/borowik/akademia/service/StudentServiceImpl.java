package pl.borowik.akademia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.borowik.akademia.dao.StudentRepository;
import pl.borowik.akademia.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository){
        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {

        studentRepository.deleteById(theId);

    }

    @Override
    public Student findById(int theId) {

       Optional<Student> result = studentRepository.findById(theId);

       Student theStudent = null;

       if (result.isPresent()){
           theStudent = result.get();
       }
       else {
           throw new RuntimeException("Student not found: " + theId);
       }
           return theStudent;
       }


}
