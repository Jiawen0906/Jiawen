package cn.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.entity.AppInfo;

@Repository("appInfoMapper")
public interface AppInfoMapper {
	
	/*
	 * 鏇存柊app鐘舵��
	 * @param status
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateSatus(@Param(value="status")Integer status,@Param(value="id")Integer id)throws Exception;
	
	/**
	 *
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public int updateSaleStatusByAppId(@Param(value="id")Integer appId) throws Exception;
	
	public int modify(AppInfo appInfo)throws Exception;
	
	public int deleteAppInfoById(@Param(value="id")Integer delId)throws Exception;
	
	public int deleteAppLogo(@Param(value="id")Integer id)throws Exception;
	
	
	/**
	 * 鏍规嵁appId锛屾洿鏂版渶鏂皏ersionId
	 * @param versionId
	 * @param appId
	 * @return
	 */
	public int updateVersionId(@Param(value="versionId")Integer versionId,@Param(value="id")Integer appId);
	
	/**
	 * 查找APKName
	 * @param id
	 * @param APKName
	 * @return
	 */
	public AppInfo getAppInfo(@Param(value="id")Integer id,@Param(value="APKName")String APKName);
	/**
	 * 新增app
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public int add(AppInfo appInfo);
	
	/**
	 * 获取app
	 * @param appInfo
	 * @return
	 */
	public List<AppInfo> getAppInfoList(@Param(value="softwareName")String querySoftwareName,
			@Param(value="status")Integer queryStatus,
			@Param(value="categoryLevel1")Integer queryCategoryLevel1,
			@Param(value="categoryLevel2")Integer queryCategoryLevel2,
			@Param(value="categoryLevel3")Integer queryCategoryLevel3,
			@Param(value="flatformId")Integer queryFlatformId,
			@Param(value="devId")Integer devId,
			@Param(value="from")Integer currentPageNo,
			@Param(value="pageSize")Integer pageSize);
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
	public int getAppInfoCount(@Param(value="softwareName")String querySoftwareName,
			   @Param(value="status")Integer queryStatus,
			   @Param(value="categoryLevel1")Integer queryCategoryLevel1,
			   @Param(value="categoryLevel2")Integer queryCategoryLevel2,
			   @Param(value="categoryLevel3")Integer queryCategoryLevel3,
			   @Param(value="flatformId")Integer queryFlatformId,
			   @Param(value="devId")Integer devId);


}
