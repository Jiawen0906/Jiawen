package cn.demo.service;

import cn.demo.entity.BackendUser;

public interface BackendUserService {

	/**
	 * 后台管理者登录
	 * @param user
	 * @return
	 */
	public BackendUser getLoginBackendUser(BackendUser user);
}
