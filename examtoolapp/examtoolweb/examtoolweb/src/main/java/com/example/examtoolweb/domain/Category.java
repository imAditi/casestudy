package com.example.examtoolweb.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * it contains the type of test
 * it maps with the test class and has one to many relationship
 * 
 * @author aditi.jain
 *
 */
@Entity
public class Category {

	/**
	 * id of category which acts as primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * name of the category of tests
	 */
	private String categoryName;

	/**
	 * mapping between category and test
	 */
	@OneToMany(mappedBy = "testCategory")
	private List<Test> tests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

}
