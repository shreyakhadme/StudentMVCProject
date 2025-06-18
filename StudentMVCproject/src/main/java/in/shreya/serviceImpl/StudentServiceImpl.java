package in.shreya.serviceImpl;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shreya.entity.Student;
import in.shreya.repository.StudentRepository;
import in.shreya.serviceInterface.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		 studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
 
}

