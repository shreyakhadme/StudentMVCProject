package in.shreya.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;

import in.shreya.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

