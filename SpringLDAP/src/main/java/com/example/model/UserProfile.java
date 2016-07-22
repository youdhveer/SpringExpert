package com.example.model;

public class UserProfile {

	private String userName;
	private String email;
	private String projectName;
	private String managerName;
	private String managerEmail;
	private String password;
	private String[] subOrdinateList;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getSubOrdinateList() {
		return subOrdinateList;
	}
	public void setSubOrdinateList(String[] subOrdinateList) {
		this.subOrdinateList = subOrdinateList;
	}
	
	
}
