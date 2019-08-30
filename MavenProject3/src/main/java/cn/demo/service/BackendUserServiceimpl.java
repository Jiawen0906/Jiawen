package cn.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.BackendUserMapper;
import cn.demo.entity.BackendUser;

@Service("backendUserService")
@Transactional
public class BackendUserServiceimpl implements BackendUserService{
	@Resource
	private BackendUserMapper backendUserMapper;

	public BackendUser getLoginBackendUser(BackendUser user) {
		// TODO Auto-generated method stub
		return backendUserMapper.getLoginBackendUser(user);
	}

}
