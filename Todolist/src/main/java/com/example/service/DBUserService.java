package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persistence.UserInfoMapper;
import com.example.web.UserForm;

@Service
public class DBUserService {
	
	@Autowired
	private UserInfoMapper userMapper;
	
	/**
	 * 회원정보 등록
	 * @param userForm
	 */
	public void insertUserInfo(UserForm userForm) {
		userMapper.insertUserInfo(userForm);
	}
	
	/**
	 * ID 중복체크. 이미 등록된  ID존재시, false값 반환. 없으면 true
	 * @param userId
	 * @return
	 */
	public boolean checkID(String userId) {
		
		boolean flag = true;
		
		try {
		String userIdResult = userMapper.checkID(userId);
		
		if(!userIdResult.equals("")) {
			flag = false;
		}
		
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}

}
