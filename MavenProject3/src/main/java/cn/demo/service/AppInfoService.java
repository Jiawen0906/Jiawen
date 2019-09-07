package cn.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.demo.entity.AppInfo;

public interface AppInfoService {
	
	/**
	 * update Sale Status By AppId and Operator
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfo) throws Exception;

	
	/**
	 * 淇敼app淇℃伅
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean modify(AppInfo appInfo)throws Exception;
	
	/**
	 * 鍒犻櫎logo鍥剧墖
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppLogo(Integer id)throws Exception;
	
	/**
	 * 鏍规嵁appId鍒犻櫎app搴旂敤
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppInfoById(Integer delId)throws Exception;
	
	/**
	 * 閫氳繃appId鍒犻櫎app搴旂敤(app_info銆乤pp_version)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean appsysdeleteAppById(Integer id)throws Exception;
	
	/**
	 * 查找APKName
	 * @param id
	 * @param APKName
	 * @return
	 */
	public AppInfo getAppInfo(@Param(value="id")Integer id,@Param(value="APKName")String APKName);
	
	/**
	 * 新增app
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean add(AppInfo appInfo) throws Exception;
 
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
			Integer devId,Integer currentPageNo,Integer pageSize);
	
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
							Integer queryCategoryLevel3,Integer queryFlatformId,Integer devId);

}
