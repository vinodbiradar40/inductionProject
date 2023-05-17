package com.query.QueryApp.MyController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.QueryApp.Details.Student;
import com.query.QueryApp.Repository.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentRepo studentRepo;
	
	@PostMapping("/createStudentDetails")
	public boolean addUser(@RequestBody Student student)
	{
		Student students=studentRepo.save(student);
		return true;
	}
	
	
	@GetMapping("/readStudentDetails")
	public List<Student> readStudentDetails()
	{
		return studentRepo.findAll();
	}
	
	@GetMapping("/readStudentDetails/{id}")
	public Student readStudentId(@PathVariable int id)
	{
		return studentRepo.findById(id).get();
	}
	
	@PutMapping("/updateStudentDetails/{id}")
	public boolean updateDetails(@PathVariable int id,@RequestBody Student student)
	{
		student.setId(id);
		studentRepo.save(student);
		return true;
	}
	
	@DeleteMapping("/deleteStudentDetails/{id}")
	public boolean deleteDetails(@PathVariable int id)
	{
		studentRepo.deleteById(id);
		return true;
	}

}
