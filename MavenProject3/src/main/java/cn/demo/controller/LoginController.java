package cn.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.demo.entity.BackendUser;
import cn.demo.entity.DevUser;
import cn.demo.service.BackendUserService;
import cn.demo.service.DevUserService;
import cn.demo.util.Constants;









/**
 * 控制层
 * @author jw
 *
 */
@Controller
@RequestMapping(value="/dev")
public class LoginController {
	private Logger log = Logger.getLogger(LoginController.class);
	
	@Resource
	private DevUserService devUserService;
	
	@Resource
	private BackendUserService backendUserService;
	 /**
     * ��תע�����
     * @return
     */
	@RequestMapping(value = "/manager",method=RequestMethod.GET)
	public String Register(HttpSession session) {
		session.removeAttribute(Constants.USER_SESSION);
		return "manager";
	}
	
	 /**
     * ע�����
     * @param user
     * @param request
     * @return
     */
	/*@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
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
	}*/
				
	 /**
     * 后台管理者注销
     * @return
     */
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute(Constants.USER_SESSION);
		return "BackLogin";
	}
	
	 /**
     * 开发者注销
     * @return
     */
	@RequestMapping(value = "/devlogout")
	public String devlogout(HttpSession session) {
		session.removeAttribute(Constants.USER_SESSION);
		return "DevLogin";
	}
	



	
	 /**
     * 开发者登录
     * @return
     */
	@RequestMapping(value = "/Login",method=RequestMethod.GET)
	public String login() {
		return "DevLogin";
	}
	
	 /**
     * 登录跳转
     * @param user
     * @param request
     * @return
     */
	@RequestMapping(value = "/doDevLogin", method = RequestMethod.POST)
	public String doLogin(DevUser user, HttpServletRequest request,HttpSession session) {
        log.info("DevUser**********************,user:"+user);
		user = devUserService.getLoginDevUser(user);
		if (user != null) {
			session.setAttribute(Constants.USER_SESSION,user);
			return "redirect:/dev/index";
		} else {
			request.setAttribute("message", "登录失败，请重新登录！");
			return "/DevLogin";
		}
	}
	@RequestMapping(value = "/index")
	public String index(HttpSession session) {
		if(session.getAttribute(Constants.USER_SESSION)==null){
			return "redirect:/dev/Login";
		}
		return "devUser/index";
	}
	
	
	 /**
     * 后台管理者 登录
     * @return
     */
	@RequestMapping(value = "/BackLogin",method=RequestMethod.GET)
	public String login1() {
		return "BackLogin";
	}
	
	 /**
     * �����¼����
     * @param user
     * @param request
     * @return
     */
	@RequestMapping(value = "/doBackLogin", method = RequestMethod.POST)
	public String doLogin1(BackendUser backenduser, HttpServletRequest request,HttpSession session) {
        log.info("BackUser**********************,user:"+backenduser);
        backenduser = backendUserService.getLoginBackendUser(backenduser);
		if (backenduser != null) {
			session.setAttribute(Constants.USER_SESSION, backenduser);
			return "redirect:/sos/backendUser/index2";
		} else {
			request.setAttribute("message", "登录失败，请重新登录！");
			return "BackLogin";
 		}
	}


}
