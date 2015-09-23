package com.controller.cn;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyShrioLoginController {
@RequestMapping("/login")
public String login(HttpServletRequest request)throws Exception{
	
	String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
	System.out.println(exceptionClassName);
	if(exceptionClassName!=null){
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			throw new CustomException("�˻�������!");
		} else if (IncorrectCredentialsException.class.getName().equals(
				exceptionClassName)) {
			throw new CustomException("���벻��ȷ!");
		}
	}
	System.out.println("--------------------------------");
	return "index";
}
}
