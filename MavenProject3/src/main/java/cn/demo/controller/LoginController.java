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
 * �����ص�����
 * @author jw
 *
 */
@Controller
public class LoginController {
	private Logger log = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	 /**
     * ��תע�����
     * @return
     */
	@RequestMapping(value = "/Register",method=RequestMethod.GET)
	public String Register() {
		return "Register";
	}
	
	 /**
     * ע�����
     * @param user
     * @param request
     * @return
     */
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request,HttpSession session) {
		//ǰ̨�ύ���û��� ����
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
			session.setAttribute("message","�û�������,����������!");
			return "Register";
		}
	}
				



	
	 /**
     * ��ת��¼����
     * @return
     */
	@RequestMapping(value = "/Login",method=RequestMethod.GET)
	public String login() {
		return "Login";
	}
	
	 /**
     * �����¼����
     * @param user
     * @param request
     * @return
     */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(User user, HttpServletRequest request,HttpSession session) {
        log.info("����login,user:"+user);
		User user1 = userService.getLoginUser(user);
		if (user1 != null) {
			session.setAttribute("user", user1);
			return "redirect:/sys/user/index";
		} else {
			request.setAttribute("message", "�û���������������������룡");
			return "Login";
		}
	}


}
