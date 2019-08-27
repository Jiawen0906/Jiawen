package cn.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.demo.entity.User;
import cn.demo.service.UserService;

/**
 * 不拦截的请求
 * @author jw
 *
 */
@Controller
public class LoginController {
	private Logger log = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	 /**
     * 跳转注册界面
     * @return
     */
	@RequestMapping(value = "/Register",method=RequestMethod.GET)
	public String Register() {
		return "Register";
	}
	
	 /**
     * 注册界面
     * @param user
     * @param request
     * @return
     */
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request,HttpSession session) {
		//前台提交的用户名 密码
		 String userCode=(String)request.getParameter("userCode");
		 String userPassword=(String)request.getParameter("userPassword");
		 User user1=new User();
		 user1.setUserCode(userCode);
		user1.setUserPassword(userPassword);
        User user2 = userService.getLoginUser(user1);
		if (user2 == null) {
			
			
			int te=userService.addUser2(user1);
			if(te>0){
				return "redirect:Login";
			}else{
				return "Register";
			}
		}else{
			session.setAttribute("message","用户名存在,请重新输入!");
			return "Register";
		}
	}
				



	
	 /**
     * 跳转登录界面
     * @return
     */
	@RequestMapping(value = "/Login",method=RequestMethod.GET)
	public String login() {
		return "Login";
	}
	
	 /**
     * 进入登录界面
     * @param user
     * @param request
     * @return
     */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(User user, HttpServletRequest request,HttpSession session) {
        log.info("进入login,user:"+user);
		User user1 = userService.getLoginUser(user);
		if (user1 != null) {
			session.setAttribute("user", user1);
			return "redirect:/sys/user/index";
		} else {
			request.setAttribute("message", "用户名或密码错误，请重新输入！");
			return "Login";
		}
	}


}
