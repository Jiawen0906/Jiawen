package cn.demo.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.AppInfoMapper;
import cn.demo.dao.AppVersionMapper;
import cn.demo.entity.AppInfo;
import cn.demo.entity.AppVersion;
@Service("appInfoService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService {
	
      @Resource
      private AppInfoMapper appInfoMapper;
      @Resource
  	  private  AppVersionMapper mapper;
      
      public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfoObj) throws Exception {
  		/*
  		 * 涓婃灦锛� 
  			1 鏇存敼status鐢便��2 or 5銆� to 4 锛� 涓婃灦鏃堕棿
  			2 鏍规嵁versionid 鏇存柊 publishStauts 涓� 2 
  			
  			涓嬫灦锛�
  			鏇存敼status 鐢�4缁欎负5
  		 */
  		
  		Integer operator = appInfoObj.getModifyBy();
  		if(operator < 0 || appInfoObj.getId() < 0 ){
  			throw new Exception();
  		}
  		
  		//get appinfo by appid
  		AppInfo appInfo = appInfoMapper.getAppInfo(appInfoObj.getId(), null);
  		if(null == appInfo){
  			return false;
  		}else{
  			switch (appInfo.getStatus()) {
  				case 2: //褰撶姸鎬佷负瀹℃牳閫氳繃鏃讹紝鍙互杩涜涓婃灦鎿嶄綔
  					onSale(appInfo,operator,4,2);
  					break;
  				case 5://褰撶姸鎬佷负涓嬫灦鏃讹紝鍙互杩涜涓婃灦鎿嶄綔
  					onSale(appInfo,operator,4,2);
  					break;
  				case 4://褰撶姸鎬佷负涓婃灦鏃讹紝鍙互杩涜涓嬫灦鎿嶄綔
  					offSale(appInfo,operator,5);
  					break;

  			default:
  				return false;
  			}
  		}
  		return true;
  	}
  	
      /**
  	 * on Sale
  	 * @param appInfo
  	 * @param operator
  	 * @param appInfStatus
  	 * @param versionStatus
  	 * @throws Exception
  	 */
  	private void onSale(AppInfo appInfo,Integer operator,Integer appInfStatus,Integer versionStatus) throws Exception{
  		offSale(appInfo,operator,appInfStatus);
  		setSaleSwitchToAppVersion(appInfo,operator,versionStatus);
  	}
  	
  	
  	/**
  	 * offSale
  	 * @param appInfo
  	 * @param operator
  	 * @param appInfStatus
  	 * @return
  	 * @throws Exception
  	 */
  	private boolean offSale(AppInfo appInfo,Integer operator,Integer appInfStatus) throws Exception{
  		AppInfo _appInfo = new AppInfo();
  		_appInfo.setId(appInfo.getId());
  		_appInfo.setStatus(appInfStatus);
  		_appInfo.setModifyBy(operator);
  		_appInfo.setOffSaleDate(new Date(System.currentTimeMillis()));
  		appInfoMapper.modify(_appInfo);
  		return true;
  	}
  	
  	/**
	 * set sale method to on or off
	 * @param appInfo
	 * @param operator
	 * @return
	 * @throws Exception
	 */
	private boolean setSaleSwitchToAppVersion(AppInfo appInfo,Integer operator,Integer saleStatus) throws Exception{
		AppVersion appVersion = new AppVersion();
		appVersion.setId(appInfo.getVersionId());
		appVersion.setPublishStatus(saleStatus);
		appVersion.setModifyBy(operator);
		appVersion.setModifyDate(new Date(System.currentTimeMillis()));
		mapper.modify(appVersion);
		return false;
	}
      
      public boolean modify(AppInfo appInfo) throws Exception {
    		// TODO Auto-generated method stub
    	  boolean flag = false;
  		if(appInfoMapper.modify(appInfo) > 0){
  			flag = true;
  		}
  		return flag;
  	}

      
      public boolean deleteAppLogo(Integer id) throws Exception {
  		// TODO Auto-generated method stub
  		boolean flag = false;
  		if(appInfoMapper.deleteAppLogo(id) > 0){
  			flag = true;
  		}
  		return flag;
  	}
      
      public boolean deleteAppInfoById(Integer delId) throws Exception {
  		// TODO Auto-generated method stub
  		boolean flag = false;
  		if(appInfoMapper.deleteAppInfoById(delId) > 0){
  			flag = true;
  		}
  		return flag;
  	}
      
      /**
  	 * 涓氬姟锛氭柊澧瀉pp鐨勭増鏈俊鎭�
  	 * 1銆乤pp_verion琛ㄦ彃鍏ユ暟鎹�
  	 * 2銆佹洿鏂癮pp_info琛ㄥ搴攁pp鐨剉ersionId瀛楁锛堣褰曟渶鏂扮増鏈琲d锛�
  	 * 娉ㄦ剰锛氫簨鍔℃帶鍒�
  	 */
  	public boolean appsysadd(AppVersion appVersion) throws Exception {
  		// TODO Auto-generated method stub
  		boolean flag = false;
  		Integer versionId = null;
  		if(mapper.add(appVersion) > 0){
  			versionId = appVersion.getId();
  			flag = true;
  		}
  		if(appInfoMapper.updateVersionId(versionId, appVersion.getAppId()) > 0 && flag){
  			flag = true;
  		}
  		return flag;
  	}
  	public boolean appsysdeleteAppById(Integer id) throws Exception {
  		boolean flag = false;
		int versionCount = mapper.getVersionCountByAppId(id);
		List<AppVersion> appVersionList = null;
		if(versionCount > 0){//1 鍏堝垹鐗堟湰淇℃伅
			//<1> 鍒犻櫎涓婁紶鐨刟pk鏂囦欢
			appVersionList = mapper.getAppVersionList(id);
			for(AppVersion appVersion:appVersionList){
				if(appVersion.getApkLocPath() != null && !appVersion.getApkLocPath().equals("")){
					File file = new File(appVersion.getApkLocPath());
					if(file.exists()){
						if(!file.delete())
							throw new Exception();
					}
				}
			}			
			//<2> 鍒犻櫎app_version琛ㄦ暟鎹�
			mapper.deleteVersionByAppId(id);
		}
		//2 鍐嶅垹app鍩虹淇℃伅
		//<1> 鍒犻櫎涓婁紶鐨刲ogo鍥剧墖
		AppInfo appInfo = appInfoMapper.getAppInfo(id, null);
		if(appInfo.getLogoLocPath() != null && !appInfo.getLogoLocPath().equals("")){
			File file = new File(appInfo.getLogoLocPath());
			if(file.exists()){
				if(!file.delete())
					throw new Exception();
			}
		}
		//<2> 鍒犻櫎app_info琛ㄦ暟鎹�
		if(appInfoMapper.deleteAppInfoById(id) > 0){
			flag = true;
		}
		return flag;
	}
  	
      
      /**
       * 查询APKName
       */
      public AppInfo getAppInfo(Integer id, String APKName) {
    		
    		return appInfoMapper.getAppInfo(id, APKName);
    	}
      
      /**
       * 新增app
       */
      public boolean add(AppInfo appInfo) throws Exception {
  		// TODO Auto-generated method stub
  		boolean flag = false;
  		if(appInfoMapper.add(appInfo) > 0){
  			flag = true;
  		}
  		return flag;
  	}
   /**
    * 获取app
    */
	public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize){
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
	}
public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
		Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
		 {
	// TODO Auto-generated method stub
	return appInfoMapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
}




}
