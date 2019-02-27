package com.example.casestudyapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casestudyapp.domain.User;
import com.example.casestudyapp.exception.UserNotExistException;
import com.example.casestudyapp.repositoryimpl.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository userRepository;
	public User showUser(int id) {
		try {	
		return userRepository.getUser(id);
		}catch (Exception e) {
			throw new UserNotExistException("User not exist");
		}
	}
	
	public User insert(User  user) {
		return userRepository.save(user);
	}
	
	public List<User> userList() {
		return userRepository.listOfUsers();
	}
	
	public User update(User user) {
		return userRepository.update(user);
	}
	
	public int delete(int id) {
		return userRepository.delete(id);
	}
}
