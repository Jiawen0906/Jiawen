package cn.demo.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;



public class User {
	private Integer id; //id 
	
	private String userCode; //鐢ㄦ埛缂栫爜
	private String userName; //鐢ㄦ埛鍚嶇О
	
	private String userPassword; //鐢ㄦ埛瀵嗙爜
	private Integer gender;  //性别
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date birthday;  //出生日期
	private String phone;   //电话
	private String address; //地址
	private Integer userRole;    //鐢ㄦ埛瑙掕壊
	private Integer createdBy;   //鍒涘缓鑰�
	private Date creationDate; //鍒涘缓鏃堕棿
	private Integer modifyBy;     //鏇存柊鑰�
	private Date modifyDate;   //鏇存柊鏃堕棿
	private String userRoleName;	//鐢ㄦ埛瑙掕壊鍚嶇О
	private String idPicPath;	//璇佷欢鐓�
	private String workPicPath;	//宸ヤ綔璇佺収
	public Integer getId() {
		return id;
	}
	public String getUserCode() {
		return userCode;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public String getIdPicPath() {
		return idPicPath;
	}
	public String getWorkPicPath() {
		return workPicPath;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}
	public void setWorkPicPath(String workPicPath) {
		this.workPicPath = workPicPath;
	}

}
