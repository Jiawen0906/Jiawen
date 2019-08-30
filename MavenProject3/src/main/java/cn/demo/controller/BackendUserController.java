package cn.demo.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.demo.service.BackendUserService;

@Controller
@RequestMapping("/sos/backendUser")
public class BackendUserController {
    
	private Logger log = Logger.getLogger(BackendUserController.class);
	
	@Resource
	private BackendUserService backendUserService;
	
	@RequestMapping(value = "/index2")
	public String index() {
		return "backendUser/index2";
	}
}
