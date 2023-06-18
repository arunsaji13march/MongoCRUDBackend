package com.mongoCRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongoCRUD.exceptions.NoUserExistsException;
import com.mongoCRUD.exceptions.UserAleadyExistsException;
import com.mongoCRUD.model.User;
import com.mongoCRUD.service.IUserServices;
import com.mongodb.annotations.Beta.Reason;

@RestController
@RequestMapping("api/v1")
public class userController {
	
	@Autowired
	IUserServices iUserServices;
	
	ResponseEntity<?> responseEntity;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUserHandle(@RequestBody User uObj) throws UserAleadyExistsException{
		
		User newUser=null;
		try {
			newUser = this.iUserServices.addUser(uObj);
			responseEntity=new ResponseEntity<>(newUser,HttpStatus.CREATED);
		} catch (UserAleadyExistsException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("exception");
			responseEntity= new ResponseEntity<>("User already exists..",HttpStatus.CONFLICT);
			
		}
		return responseEntity;
		
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsersHandle(
			@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize){
		System.out.println("getAllUsers");
		List<User> userList=this.iUserServices.getAllUsers(pageNumber,pageSize);
		System.out.println(userList.get(0));
		responseEntity=new ResponseEntity<>(userList,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUserHandle(@RequestBody User uobj,@PathVariable int id) {
		User updateUser=null;
		try {
			updateUser = this.iUserServices.updateUser(uobj, id);
			responseEntity=new ResponseEntity<>(updateUser,HttpStatus.CREATED);		
		} catch (NoUserExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseEntity=new ResponseEntity<>("no user Found",HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUseHandle(@PathVariable int id){
		boolean deleted=false;
		try {
			deleted = this.iUserServices.delUer(id);
			responseEntity=new ResponseEntity<>(deleted,HttpStatus.OK);
		} catch (NoUserExistsException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			responseEntity=new ResponseEntity<>("no user found",HttpStatus.NOT_FOUND);
			
		}
		return responseEntity;
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		User delUser=null;
		try {
			delUser=this.iUserServices.getUserById(id);
			responseEntity=new ResponseEntity<>(delUser, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO: handle exception
			responseEntity=new ResponseEntity<>("No user found", HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
		
	}
	
}
