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
	 * ��ѯ�û���
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user);
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public Integer addUser(User user);
	
	public int addUser2(User user);

	/**
	 * ��¼�û�
	 * @param user
	 * @return
	 */
	public User getLoginUser(User user);
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
	
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
	public User checkUserCode(String userCode);
	
	
	
	
	
}
