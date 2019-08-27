package cn.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.UserMapper;
import cn.demo.entity.User;

/**
 * User业务逻辑层实现类
 * @author lxh
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

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
    /**
     * 用户登录
     */
	public User getLoginUser(User user) {
		
		return userMapper.getLoginUser(user);
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
