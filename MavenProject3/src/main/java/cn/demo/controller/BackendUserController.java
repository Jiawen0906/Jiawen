package cn.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.demo.entity.AppCategory;
import cn.demo.entity.AppInfo;
import cn.demo.entity.AppVersion;
import cn.demo.entity.BackendUser;
import cn.demo.entity.DataDictionary;
import cn.demo.entity.DevUser;
import cn.demo.service.AppCategoryService;
import cn.demo.service.AppInfoService;
import cn.demo.service.AppService;
import cn.demo.service.AppVersionService;
import cn.demo.service.BackendUserService;
import cn.demo.service.DataDictionaryService;
import cn.demo.util.Constants;
import cn.demo.util.PageSupport;

@Controller
@RequestMapping("/sos/backendUser")
public class BackendUserController {
    
	private Logger log = Logger.getLogger(BackendUserController.class);
	
	@Resource
	private AppService appService;
	@Resource
	private BackendUserService backendUserService;
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private AppVersionService appVersionService;
	
	@RequestMapping(value = "/index2")
	public String index2(HttpSession session) {
		if(session.getAttribute(Constants.USER_SESSION)==null){
			return "redirect:/dev/BackLogin";
		}
		return "backendUser/index2";
	}
	
	@RequestMapping(value="/list")
	public String getAppInfoList(Model model,HttpSession session,
							@RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
							@RequestParam(value="queryCategoryLevel1",required=false) String _queryCategoryLevel1,
							@RequestParam(value="queryCategoryLevel2",required=false) String _queryCategoryLevel2,
							@RequestParam(value="queryCategoryLevel3",required=false) String _queryCategoryLevel3,
							@RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
							@RequestParam(value="pageIndex",required=false) String pageIndex){
		
		log.info("getAppInfoList -- > querySoftwareName: " + querySoftwareName);
		log.info("getAppInfoList -- > queryCategoryLevel1: " + _queryCategoryLevel1);
		log.info("getAppInfoList -- > queryCategoryLevel2: " + _queryCategoryLevel2);
		log.info("getAppInfoList -- > queryCategoryLevel3: " + _queryCategoryLevel3);
		log.info("getAppInfoList -- > queryFlatformId: " + _queryFlatformId);
		log.info("getAppInfoList -- > pageIndex: " + pageIndex);
		
		List<AppInfo> appInfoList = null;
		List<DataDictionary> flatFormList = null;
		List<AppCategory> categoryLevel1List = null;//列出一级分类列表，注：二级和三级分类列表通过异步ajax获取
		List<AppCategory> categoryLevel2List = null;
		List<AppCategory> categoryLevel3List = null;
		//页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		Integer currentPageNo = 1;
		
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Integer queryCategoryLevel1 = null;
		if(_queryCategoryLevel1 != null && !_queryCategoryLevel1.equals("")){
			queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
		}
		Integer queryCategoryLevel2 = null;
		if(_queryCategoryLevel2 != null && !_queryCategoryLevel2.equals("")){
			queryCategoryLevel2 = Integer.parseInt(_queryCategoryLevel2);
		}
		Integer queryCategoryLevel3 = null;
		if(_queryCategoryLevel3 != null && !_queryCategoryLevel3.equals("")){
			queryCategoryLevel3 = Integer.parseInt(_queryCategoryLevel3);
		}
		Integer queryFlatformId = null;
		if(_queryFlatformId != null && !_queryFlatformId.equals("")){
			queryFlatformId = Integer.parseInt(_queryFlatformId);
		}
		
		//总数量（表）
		int totalCount = 0;
		try {
			totalCount = appService.getAppInfoCount(querySoftwareName, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		try {
			appInfoList = appService.getAppInfoList(querySoftwareName, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, currentPageNo, pageSize);
			flatFormList = this.getDataDictionaryList("APP_FLATFORM");
			categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("pages", pages);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("queryFlatformId", queryFlatformId);
		
		//二级分类列表和三级分类列表---回显
		if(queryCategoryLevel2 != null && !queryCategoryLevel2.equals("")){
			categoryLevel2List = getCategoryList(queryCategoryLevel1.toString());
			model.addAttribute("categoryLevel2List", categoryLevel2List);
		}
		if(queryCategoryLevel3 != null && !queryCategoryLevel3.equals("")){
			categoryLevel3List = getCategoryList(queryCategoryLevel2.toString());
			model.addAttribute("categoryLevel3List", categoryLevel3List);
		}
		return "backendUser/applist";
	}
	
	public List<DataDictionary> getDataDictionaryList(String typeCode){
		List<DataDictionary> dataDictionaryList = null;
		try {
			dataDictionaryList = dataDictionaryService.getDataDictionaryList(typeCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataDictionaryList;
	}
	
	public List<AppCategory> getCategoryList (String pid){
		List<AppCategory> categoryLevelList = null;
		try {
			categoryLevelList = appCategoryService.getAppCategoryListByParentId(pid==null?null:Integer.parseInt(pid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryLevelList;
	}
	/**
	 * 根据parentId查询出相应的分类级别列表
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/categorylevellist.json",method=RequestMethod.GET)
	@ResponseBody
	public List<AppCategory> getAppCategoryList (@RequestParam String pid){
		log.debug("getAppCategoryList pid ============ " + pid);
		if(pid.equals("")) pid = null;
		return getCategoryList(pid);
	}
	
	
	/**
	 * 跳转到APP信息审核页面
	 * @param appId
	 * @param versionId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public String check(@RequestParam(value="aid",required=false) String appId,
					   @RequestParam(value="vid",required=false) String versionId,
					   Model model){
		AppInfo appInfo = null;
		AppVersion appVersion = null;
		try {
			appInfo = appService.getAppInfo(Integer.parseInt(appId));
			appVersion = appVersionService.getAppVersionById(Integer.parseInt(versionId));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute(appVersion);
		model.addAttribute(appInfo);
		return "backendUser/appcheck";
	}
	@RequestMapping(value="/checksave",method=RequestMethod.POST)
	public String checkSave(AppInfo appInfo){
		log.debug("appInfo =========== > " + appInfo.getStatus());
		try {
			if(appService.updateSatus(appInfo.getStatus(),appInfo.getId())){
				return "redirect:/sos/backendUser/list";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "backendUser/appcheck";
	}
	


}
