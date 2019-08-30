package cn.demo.service;

import java.util.List;

import cn.demo.entity.AppInfo;

public interface AppInfoService {
 
	/**
	 * 获取app
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<AppInfo> getAppInfoList(String querySoftwareName,Integer queryStatus,
			Integer queryCategoryLevel1,Integer queryCategoryLevel2,
			Integer queryCategoryLevel3,Integer queryFlatformId,
			Integer devId,Integer currentPageNo,Integer pageSize)throws Exception;
	
	/**
	 * 翻页
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @return
	 * @throws Exception
	 */
	public int getAppInfoCount(String querySoftwareName,Integer queryStatus,
							Integer queryCategoryLevel1,Integer queryCategoryLevel2,
							Integer queryCategoryLevel3,Integer queryFlatformId,Integer devId)throws Exception;

}
