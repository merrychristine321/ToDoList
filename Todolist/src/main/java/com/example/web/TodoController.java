package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	/**
	 * 회원정보 등록
	 * @param userForm
	 * @return
	 */
	@RequestMapping(value="/goto-loginPage",params="signUp-btn",method=RequestMethod.POST)
	public String insertUserInfo(@Validated UserForm userForm,BindingResult result,@RequestParam("pwCheck")String pwCheck,Model model) {
		
		//필수사항 미입력 체크
		if(result.hasErrors()) {
			return "signUp";
		}
		
		//비밀번호 일치여부 체크
		if(!userForm.getUserPw().equals(pwCheck)) {
			model.addAttribute("errMessage","비밀번호가 일치하지 않습니다.");
			return "signUp";
		}
		
		//ID중복 체크
		boolean idCheck = userService.checkID(userForm.getUserId());
		if(!idCheck) {
			model.addAttribute("IDerrMessage","이미 등록된 ID입니다.");
			return "signUp";
		}
		
		//회원정보 등록
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
