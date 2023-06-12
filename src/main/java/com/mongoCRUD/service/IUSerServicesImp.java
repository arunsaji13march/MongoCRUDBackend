package com.mongoCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mongoCRUD.exceptions.NoUserExistsException;
import com.mongoCRUD.exceptions.UserAleadyExistsException;
import com.mongoCRUD.model.User;
import com.mongoCRUD.repository.IUserReposiory;


@Service
public class IUSerServicesImp implements IUserServices {
	
	@Autowired
	IUserReposiory iUserReposiory;

	@Override
	public User addUser(User uObj) throws UserAleadyExistsException {
		
		Optional<User> optional=this.iUserReposiory.findById(uObj.getId());
		
		User newUser=null;
		if(optional.isPresent()) {
			System.out.print("Ueer already exists...");
			throw new UserAleadyExistsException();
		}else {
			newUser=this.iUserReposiory.save(uObj);
		}
			return newUser;
	}

	@Override
	public User updateUser(User uObj, int id) throws NoUserExistsException {
		// TODO Auto-generated method stub
		Optional<User> optional =iUserReposiory.findById(id);
		User objUser=null;
		User updateUser=null;
		
		if(optional.isPresent()) {
			
			objUser=optional.get();
			if(uObj.getName()!=null) {objUser.setName(uObj.getName());}
			if(uObj.getAge() !=0) {objUser.setAge(uObj.getAge());}
			if(uObj.getEmail()!=null) {objUser.setEmail(uObj.getEmail());}
			if(uObj.getSex()!=null) {objUser.setSex(uObj.getSex());}
			if(uObj.getJob()!=null) {objUser.setJob(uObj.getJob());}
			if(uObj.getFriend()!=null) {objUser.setFriend(uObj.getFriend());}
			
			updateUser= this.iUserReposiory.save(objUser);
			
			
		}else {
			System.out.println("User does not exist...");
			throw new NoUserExistsException();
		}
		return updateUser;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=iUserReposiory.findAll();
		return users;
	}

	@Override
	public boolean delUer(int id) throws NoUserExistsException{
		// TODO Auto-generated method stub
		Optional<User> optional =this.iUserReposiory.findById(id);
		boolean flag=false;
		if(optional.isPresent()) {
			this.iUserReposiory.deleteById(id);
			flag=true;
		}else {
			throw new  NoUserExistsException();
		}
		return flag;
	}

	@Override
	public User getUserById(int id) throws NoUserExistsException {
		// TODO Auto-generated method stub
		User user=null;
		Optional<User> optional=this.iUserReposiory.findById(id);
		
		if(optional.isPresent()) {
			user=optional.get();
			this.iUserReposiory.delete(user);
		}
		else {
			throw new NoUserExistsException();
		}
		return user;
	}

}
