package pl.borowik.akademia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borowik.akademia.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
