package cn.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.AppInfoMapper;
import cn.demo.entity.AppInfo;
@Service("appInfoService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService {
	
      @Resource
      private AppInfoMapper appInfoMapper;
   /**
    * 获取app
    */
	public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
	}
public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
		Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
		throws Exception {
	// TODO Auto-generated method stub
	return appInfoMapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
}

}
