package pl.borowik.akademia.service;

import pl.borowik.akademia.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    void save(Student theStudent);
}