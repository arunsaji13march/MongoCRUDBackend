package com.mongoCRUD.service;

import java.util.List;

import com.mongoCRUD.exceptions.NoUserExistsException;
import com.mongoCRUD.exceptions.UserAleadyExistsException;
import com.mongoCRUD.model.User;

public interface IUserServices {

	public User addUser(User uObj) throws UserAleadyExistsException;
	public User updateUser(User uObj ,int id) throws NoUserExistsException;
	public List<User> getAllUsers();
	public boolean delUer(int id) throws NoUserExistsException;
	public User getUserById(int id) throws NoUserExistsException;

}
