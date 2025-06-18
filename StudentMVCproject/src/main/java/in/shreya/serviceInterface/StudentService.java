package in.shreya.serviceInterface;

 
import java.util.List;

import in.shreya.entity.Student;

public interface StudentService {
	
    Student saveStudent(Student student);
    
    void deleteStudent(Long id);
    
    Student getStudentById(Long id);
    
    List<Student> getAllStudents();
}

