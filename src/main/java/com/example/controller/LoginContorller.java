package com.example.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.shiro.Encripty;

@Controller
public class LoginContorller {

	@RequestMapping("/login")
	public String gotoLogin(HttpServletRequest request, HttpServletResponse response, String lang) {
		return "login";
	}

	@RequestMapping("/validata")
	public String login(String account, String password, HttpServletRequest request, ModelMap map) {
		Subject subject = SecurityUtils.getSubject();// 创建主体
		String pass = Encripty.enctiptyPassword(password);// 密码加密
		// 创建token
		UsernamePasswordToken token = new UsernamePasswordToken(account, pass);
		try {
			subject.login(token);// 登录
		} catch (AuthenticationException e) {
			// 登录失败
			e.printStackTrace();
			map.put("err", e.getMessage());
			return "login";
		}
		// 登录成功
		HttpSession session = request.getSession();
		session.setAttribute("login", account);
		return "redirect:home/index";
	}

	@RequestMapping("/home/left")
	public String gotoMenu() {
		return "left";
	}

	@RequestMapping("/home/index")
	public String gotoMain() {
		return "main";
	}

	@RequestMapping("/home/right")
	public String gotoRight() {
		return "right";
	}
	@RequestMapping("/home/test")
	public String test() throws Exception {
		int x=10/0;
		return "right";
	}
}
