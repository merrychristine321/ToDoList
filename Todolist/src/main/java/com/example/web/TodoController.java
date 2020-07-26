package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.DBUserService;

@Controller
public class TodoController {
	
	@Autowired
	private DBUserService userService;
	
	@ModelAttribute("userForm")
	public UserForm setUserForm() {
		return new UserForm();
	}
	
	/**
	 * 투두리스트 로그인 페이지로 이동
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	/**
	 * 회원가입
	 * @return
	 */
	@RequestMapping(value="/nextPage-branch",params="signup-btn")
	public String gotoSignUp() {
		
		return "signUp";
	}
	
	/**
	 * 로그인 페이지로 돌아가기 버튼 눌렀을때
	 * @return
	 */
	@RequestMapping(value="/goto-loginPage",params="back-btn",method=RequestMethod.POST)
	public String gobackLoginPage() {
		
		return "redirect:/login";
	}
	
	
	@RequestMapping(value="/goto-loginPage",params="signUp-btn",method=RequestMethod.POST)
	public String insertUserInfo(UserForm userForm) {
		
		userService.insertUserInfo(userForm);
		
		
		return "login";
	}
	
	
	
	
	
	/**
	 * 로그인 후 투두리스트 페이지에 이동
	 * @return
	 */
	@RequestMapping(value="/nextPage-branch",params="login-btn")
	public String toroTodolist() {
		
		return "todolist";
	}
	
	

}
