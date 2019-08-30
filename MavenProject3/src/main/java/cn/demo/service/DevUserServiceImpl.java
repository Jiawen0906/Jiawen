package cn.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.DevUserMapper;
import cn.demo.entity.DevUser;
import cn.demo.entity.User;

/**
 * Userҵ���߼���ʵ����
 * @author lxh
 *
 */
@Service("devUserService")
@Transactional
public class DevUserServiceImpl implements DevUserService {

	@Resource
	private DevUserMapper userMapper;
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public DevUser getLoginDevUser(DevUser user){
		return userMapper.getLoginDevUser(user);
	}

	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addUser2(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
  
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User checkUserCode(String userCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
