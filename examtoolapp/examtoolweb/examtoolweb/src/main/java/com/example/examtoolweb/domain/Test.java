package com.example.examtoolweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Test is a model that is used to travel data from one layer to other
 * layer.
 * 
 * @author aditi.jain
 *
 */
@Entity
@Table(name = "tests")
public class Test {

	/**
	 * id of test, this will be used as primary key it is auto incremented
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * name of the test
	 */
	@NotBlank(message = "Test name is required")
	private String testName;

	/**
	 * many to one mapping between test and category
	 */
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category testCategory;
	/**
	 * it tells about the start date of a particular test
	 */
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date start_date;

	/**
	 * it tells about the end date of a particular test
	 */
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date end_date;

	/**
	 * it tells when the test is created
	 */
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date created_At;

	/**
	 * updated date of test
	 * 
	 */
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated_At;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	/**
	 * Life cycle hook it is called before persisting data
	 */
	@PrePersist
	public void onCreate() {
		this.created_At = new Date();
	}

	/**
	 * Life cycle hook it is called after updating data
	 */
	@PostUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}
}
