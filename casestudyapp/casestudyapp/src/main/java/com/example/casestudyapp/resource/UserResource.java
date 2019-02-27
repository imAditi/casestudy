package com.example.casestudyapp.resource;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casestudyapp.domain.User;
import com.example.casestudyapp.serviceimpl.MapValidationErrorService;
import com.example.casestudyapp.serviceimpl.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/users")

public class UserResource {

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	/*@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return userService.showUser(id);
		
	}*/
	
	@GetMapping("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> getUser(@PathVariable int id){
		System.out.println("Get Method called of controller");
		User user = userService.showUser(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	/*@PostMapping("")
	public User createUser(@RequestBody User user) {
		return userService.insert(user);
	}*/
	
	@PostMapping("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> createUser( @Valid @RequestBody User user,BindingResult result) {
		ResponseEntity<?> errMap =mapValidationErrorService.mapValidationError(result);
		if(result.hasErrors()) {
			return errMap;
		}
		 userService.insert(user);
		 return new ResponseEntity<User>(user,HttpStatus.CREATED);
		
	}
	
/*	@GetMapping("")
	public List<User> usersList(){
		return userService.userList();
	}*/
	
	@GetMapping("")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> usersList(){
		List<User> users =  userService.userList();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	/*@PutMapping("")
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}*/
	
	@PutMapping("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User user1 = userService.update(user);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
	
	/*@DeleteMapping("/{id}")
	public int deleteUser(@PathVariable int id) {
		return userService.delete(id);
	}*/
	
	@DeleteMapping("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Integer> deleteUser(@PathVariable int id) {
		userService.delete(id);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
}
