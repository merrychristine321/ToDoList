package com.example.persistence;

import com.example.web.UserForm;

public interface UserInfoMapper {
	
	/**
	 * 유저 회원가입 정보 등록
	 * @param userForm
	 */
	public void insertUserInfo(UserForm userForm);
	
	/**
	 * ID 중복체크
	 * @param userId
	 * @return
	 */
	public String checkID(String userId);

}
