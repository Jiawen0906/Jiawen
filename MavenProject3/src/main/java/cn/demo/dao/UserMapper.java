package cn.demo.dao;
/**
 * 
 * @author jw
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.entity.User;

@Repository("userMapper")
public interface UserMapper {
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public Integer addUser(User user);
	
	public int addUser2(User user);

	/**
	 * 登录用户
	 * @param user
	 * @return
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
