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
	 *����ѯ
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user);
	/**
	 * ���
	 * @param user
	 * @return
	 */
	public Integer addUser(User user);
	
	public int addUser2(User user);
	
	/**
	 * �û���¼
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
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

