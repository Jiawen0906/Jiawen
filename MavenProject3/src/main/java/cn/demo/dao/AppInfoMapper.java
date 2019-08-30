package cn.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.entity.AppInfo;

@Repository("appInfoMapper")
public interface AppInfoMapper {
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
			@Param(value="pageSize")Integer pageSize)throws Exception;
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
			   @Param(value="devId")Integer devId)throws Exception;


}
