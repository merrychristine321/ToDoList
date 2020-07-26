package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persistence.UserInfoMapper;
import com.example.web.UserForm;

@Service
public class DBUserService {
	
	@Autowired
	private UserInfoMapper userMapper;
	
	public void insertUserInfo(UserForm userForm) {
		userMapper.insertUserInfo(userForm);
	}

}
