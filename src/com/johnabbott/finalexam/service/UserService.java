package com.johnabbott.finalexam.service;


import java.util.List;

import com.johnabbott.finalexam.model.UserEntity;



public interface UserService {
	public boolean addUser(UserEntity user);
	
	public List<UserEntity> getUsers(); // Read
	
	public UserEntity getUserById(int userId); // Read
	
	public UserEntity getUserByName(String userName); //Read
	
	public boolean deleteUser(int userId); //DELETE
	
	public boolean updateUser(UserEntity user); // UPDATE
	
}

