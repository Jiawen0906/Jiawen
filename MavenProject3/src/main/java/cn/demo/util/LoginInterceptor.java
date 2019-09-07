package cn.demo.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.demo.entity.DevUser;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
			Object handler) throws IOException{
		DevUser user = (DevUser) request.getSession().getAttribute(Constants.USER_SESSION);
		if(user == null){
			response.sendRedirect(request.getContextPath()+"/dev/Login");
			
			return false;
		}else{
			return true;
		}
		
	}
	
	
}
