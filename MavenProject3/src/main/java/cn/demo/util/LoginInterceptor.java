package cn.demo.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.demo.entity.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
			Object handler) throws IOException{
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect(request.getContextPath()+"/Login");
			
			return false;
		}else{
			return true;
		}
	}

}
