package com.example.examtoolweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examtoolweb.domain.Test;
import com.example.examtoolweb.repository.TestRepository;

/**
 * It is used to provide some business functionalities
 * 
 * @author aditi.jain
 *
 */
@Service
public class TestService {

	/**
	 * it will create object at runtime inject collaborating beans into one bean
	 */
	@Autowired
	private TestRepository testRepository;
	
	/**
	 * it will save the tests to the list in the application
	 * @param test
	 * @return
	 */
	public Test saveOrUpdate(Test test) {
		return testRepository.save(test);
	}

	/**
	 * it will delete the tests from the list
	 * @param id
	 */
	public void delete(Long id) {
		testRepository.deleteById(id);
	}

	/**
	 * it will update the details of the test in the application
	 * @param id
	 * @param test
	 * @return
	 */
	public Test saveOrUpdate(Long id, Test test) {
		Test tempTest = testRepository.findById(id).get();
		tempTest = test;
		return testRepository.save(tempTest);
	}

	/**
	 * it will give the list of all the tests 
	 * @return
	 */
	public List<Test> getAllTests() {
		List<Test> list = new ArrayList<>();
		testRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
}
