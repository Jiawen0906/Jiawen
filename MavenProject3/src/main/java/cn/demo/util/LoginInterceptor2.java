package cn.demo.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.demo.entity.BackendUser;

public class LoginInterceptor2 extends HandlerInterceptorAdapter{

		
		public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
				Object handler) throws IOException{
			BackendUser backenduser = (BackendUser) request.getSession().getAttribute(Constants.USER_SESSION);
			if(backenduser == null){
				response.sendRedirect(request.getContextPath()+"/dev/BackLogin");
				
				return false;
			}else{
				return true;
			}
			
		}

	}


