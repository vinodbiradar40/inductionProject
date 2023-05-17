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

import com.query.QueryApp.Details.Batch;
import com.query.QueryApp.Details.Student;
import com.query.QueryApp.Repository.BatchRepo;
import com.query.QueryApp.Repository.StudentProjection;
import com.query.QueryApp.Repository.StudentRepo;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	private BatchRepo batchRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	
	@PostMapping("/createBatchDetails")
	public boolean addUser(@RequestBody Batch batch)
	{
		Batch batches=batchRepo.save(batch);
		return true;
	}
	
	@GetMapping("/readBatchDetails")
	public List<Batch> readBatchDetails()
	{
		return  batchRepo.findAll();
	}
	
	@GetMapping("/readBatchDetails/{id}")
	public Batch readBatchId(@PathVariable int id)
	{
		return batchRepo.findById(id).get();
	}
	
	@PutMapping("/updateBatchDetails/{id}")
	public boolean updateDetails(@PathVariable int id,@RequestBody Batch batch)
	{
		batch.setId(id);
		batchRepo.save(batch);
		return true;
	}
	
	@DeleteMapping("/deleteBatchDetails/{id}")
	public boolean deleteDetails(@PathVariable int id)
	{
		batchRepo.deleteById(id);
		return true;
	}
	
	//assign student to batch
	@PutMapping("/assignStudents/{batch_id}/{student_id}")
	public boolean assignStudents(@PathVariable int batch_id,@PathVariable int student_id)
	{
		Batch batch=batchRepo.findById(batch_id).get();
		Student student=studentRepo.findById(student_id).get();
		batch.getStudents().add(student);
		batchRepo.save(batch);
		
		return true;
	}
	
	@PutMapping("/assignStudents")
	public boolean assignStudents(@RequestBody Batch batch)
	{
		batchRepo.save(batch);	
		return true;
	}
	

	//to get name and their elective subject
	@GetMapping("/getNameAndSubject")
	public List<StudentProjection> getName()
	{
		return batchRepo.getNameAndSubject();
	}

	//to get selected subject students list
	@GetMapping("/name/{id}")
	public String getNameString(@PathVariable int id)
	{
		return batchRepo.getName(id);
	}
	
	
}
