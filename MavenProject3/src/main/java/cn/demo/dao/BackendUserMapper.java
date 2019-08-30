package cn.demo.dao;

import org.springframework.stereotype.Repository;

import cn.demo.entity.BackendUser;
@Repository("backendUserMapper")
public interface BackendUserMapper {

	
	/**
	 * 后台管理者登录
	 * @param user
	 * @return
	 */
	public BackendUser getLoginBackendUser(BackendUser user);
}
