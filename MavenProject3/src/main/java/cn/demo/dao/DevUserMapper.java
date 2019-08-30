package cn.demo.dao;
/**
 * 
 * @author jw
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.entity.BackendUser;
import cn.demo.entity.DevUser;
import cn.demo.entity.User;

@Repository("devUserMapper")
public interface DevUserMapper {
	/**
	 * 获取开发者用户
	 * @param user
	 * @return
	 */
	public List<DevUser> getDevUserList(DevUser user);
	/**
	 * 添加开发者用户
	 * @param user
	 * @return
	 */
	public Integer addUser(DevUser user);
	
	public int addUser2(DevUser user);

	/**
	 * 开发者登录
	 * @param user
	 * @return
	 */
	public DevUser getLoginDevUser(DevUser user);
	
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public Integer updateUser(DevUser user);
	
	/**
	 * ����������ȡ�û�
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * У��userCode�Ƿ����
	 * @param userCode
	 * @return
	 */
	public User checkUserCode(String DevCode);
	
	
	
	
	
}
