package com.query.QueryApp.Details;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String electiveSubject;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id")
	List<Student> students=new ArrayList<>();

	public Batch() {
		super();
	}

	public Batch(int id, String electiveSubject, List<Student> students) {
		super();
		this.id = id;
		this.electiveSubject = electiveSubject;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElectiveSubject() {
		return electiveSubject;
	}

	public void setElectiveSubject(String electiveSubject) {
		this.electiveSubject = electiveSubject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", electiveSubject=" + electiveSubject + ", students=" + students + "]";
	}
	
	

}
