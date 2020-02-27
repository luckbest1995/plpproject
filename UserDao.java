package com.capgemini.librarymanagementsystem.dao;

import java.util.HashMap;

import com.capgemini.librarymanagementsystem.bean.UserBean;

public interface UserDao {

//	public HashMap<Integer, UserBean> getAllUser();

	public void showAllUser();
	
	public boolean updateUser(int userId, UserBean password);

	public boolean deleteUser(int userId);

	public boolean addUser(UserBean books);

	public UserBean searchUser(int userId);

}
