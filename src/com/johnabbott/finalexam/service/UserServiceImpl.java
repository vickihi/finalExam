package com.johnabbott.finalexam.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.finalexam.dao.UserDao;
import com.johnabbott.finalexam.model.UserEntity;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	List<UserEntity> listUsers;
	
	public UserServiceImpl() {
		listUsers = new ArrayList<UserEntity>();
	}
	
	@Override
	public List<UserEntity> getUsers(){
		return userDao.getUsers();
	}

	@Override
	public boolean addUser(UserEntity user) {
		return userDao.insertUser(user) > 0 ;
	}

	@Override
	public UserEntity getUserById(int userId) {
		return userDao.getUserById(userId);
	}
	
	@Override
	public UserEntity getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	@Override
	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public boolean updateUser(UserEntity user) {
		return userDao.updateUser(user);
	}


	
	
}
