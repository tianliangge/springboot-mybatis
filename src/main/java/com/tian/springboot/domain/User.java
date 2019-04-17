package com.tian.springboot.domain;

public class User {
    private Integer userId;

    private String userName;

    private String userAddress;
    
    public User() {
		// TODO Auto-generated constructor stub
	}
    

    public User(String userName, String userAddress) {
		super();
		this.userName = userName;
		this.userAddress = userAddress;
	}



	public User(Integer userId, String userName, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
	}



	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + "]";
	}
    
    
}