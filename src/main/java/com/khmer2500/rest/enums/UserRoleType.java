package com.khmer2500.rest.enums;

public enum UserRoleType {
	CUSTOMER,
	SELLER,
	ADMIN;
	String userRoleType;
	public String getUserRoleType() {
		return userRoleType;
	}
	public void setUserRoleType(String userRoleType) {
		this.userRoleType = userRoleType;
	}
}
