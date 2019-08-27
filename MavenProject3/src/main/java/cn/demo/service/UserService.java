package cn.demo.service;

import java.util.List;

import cn.demo.entity.User;
/**
 * 
 * @author jw
 *
 */
public interface UserService {

	/**
	 *查询
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user);
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	public Integer addUser(User user);
	
	public int addUser2(User user);
	
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
	
	/**
	 * 根据主键获取用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * 校验userCode是否存在
	 * @param userCode
	 * @return
	 */
	public User checkUserCode(String userCode);
}

